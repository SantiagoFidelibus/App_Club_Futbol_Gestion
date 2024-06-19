package Webcam;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.*;
import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.*;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;

import static java.awt.SystemColor.window;


public class WebcamClass extends JFrame {

    private Webcam webcam;
    private WebcamPanel panel;
    private JLabel cameraStatusLabel;
    private String legajo;

    public WebcamClass(String legajo) {
        this.legajo = legajo;
        seleccionarPrimeraCamaraDisponible();
    }

    public void createAndShowGUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE); // Fondo blanco
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.setBackground(Color.WHITE); // Fondo blanco

        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE); // Fondo blanco
        // Botón para seleccionar cámara
        JButton selectCameraButton = new JButton("Seleccionar Cámara");
        configurarBoton(selectCameraButton);
        selectCameraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarCamara();
            }
        });
        controlPanel.add(selectCameraButton);

        // Botón para capturar foto
        JButton captureButton = new JButton("Capturar Foto");
        configurarBoton(captureButton);
        captureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capturarFoto();
            }
        });
        controlPanel.add(captureButton);

        // Botón para cambiar la visualización de la cámara
        ImageIcon icon = new ImageIcon("src/com/images/voltHoriz.png");
        JButton toggleButton = new JButton(icon);
        toggleButton.setPreferredSize(new Dimension(64, 64));
        toggleButton.setBackground(new Color(50, 115, 153)); // Color RGB 50, 115, 153
        toggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mano
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel != null) {
                    panel.setMirrored(!panel.isMirrored());
                }
            }
        });
        controlPanel.add(toggleButton);

        // Botón para iniciar escaneo
        // Botón para iniciar escaneo
        JButton scanButton = new JButton("Iniciar Escaneo");
        configurarBoton(scanButton);
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarEscaneo();
            }
        });
        controlPanel.add(scanButton);

        mainPanel.add(controlPanel, BorderLayout.NORTH);

        cameraStatusLabel = new JLabel("Estado de la Cámara: No seleccionada");
        cameraStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cameraStatusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(cameraStatusLabel, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.NORTH);


        setTitle("Visor de Webcam con Escaneo en Tiempo Real");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            File iconFile = new File("src/com/images/voltHoriz.png"); // Ruta de tu imagen
            BufferedImage iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }


        setSize(800, 600); // Tamaño ajustado
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarCamara();
            }
        });
    }

    private void configurarBoton(JButton button) {


            button.setPreferredSize(new Dimension(200, 64));
            button.setBackground(new Color(32, 73, 99)); // Fondo azul (RGB 32, 73, 99)
            button.setForeground(Color.BLACK); // Texto blanco
            button.setFont(new Font("Roboto", Font.PLAIN, 12));
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


    }

    private void seleccionarPrimeraCamaraDisponible() {
        new Thread(new Runnable() {
            public void run() {
                List<Webcam> webcams = Webcam.getWebcams();
                if (!webcams.isEmpty()) {
                    abrirCamara(webcams.get(0)); // Abre la primera cámara automáticamente
                }
            }
        }).start();
    }

    private void seleccionarCamara() {
        List<Webcam> webcams = Webcam.getWebcams();
        if (webcams.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron cámaras disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] cameraNames = new String[webcams.size()];
        for (int i = 0; i < webcams.size(); i++) {
            cameraNames[i] = webcams.get(i).getName();
        }

        String selectedCamera = (String) JOptionPane.showInputDialog(
                this,
                "Selecciona una cámara",
                "Selección de Cámara",
                JOptionPane.PLAIN_MESSAGE,
                null,
                cameraNames,
                cameraNames[0]
        );

        if (selectedCamera != null) {
            for (Webcam cam : webcams) {
                if (cam.getName().equals(selectedCamera)) {
                    abrirCamara(cam);
                    break;
                }
            }
        }
    }

    private void abrirCamara(Webcam cam) {
        cerrarCamara();
        webcam = cam;
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();

        panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);

        JPanel cameraPanel = new JPanel(new BorderLayout());
        cameraPanel.add(panel, BorderLayout.CENTER);

        getContentPane().add(cameraPanel, BorderLayout.CENTER);
        revalidate();

        cameraStatusLabel.setText("Cámara seleccionada: " + webcam.getName());
    }

    private void cerrarCamara() {
        if (webcam != null && webcam.isOpen()) {
            webcam.close();
            if (panel != null) {
                getContentPane().remove(panel.getParent());
                repaint();
            }
            cameraStatusLabel.setText("Estado de la Cámara: No seleccionada");
        }
    }

    private void capturarFoto() {
        if (webcam != null && webcam.isOpen()) {
            BufferedImage image = webcam.getImage();
            if (image != null) {
                try {
                    // Guardar la imagen con el nombre de legajo
                    String fileName = legajo + ".png";

                    // Directorio donde se guardará la imagen
                    String directoryPath = "src/com/imagesPersonas/";
                    File directory = new File(directoryPath);
                    if (!directory.exists()) {
                        directory.mkdirs(); // Crea el directorio si no existe
                    }

                    // Guardar la imagen en el directorio especificado
                    File file = new File(directoryPath + fileName);
                    ImageIO.write(image, "PNG", file);

                    JOptionPane.showMessageDialog(this, "¡Foto capturada y guardada correctamente!", "Captura exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al guardar la foto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se puede capturar la foto porque la cámara no está abierta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void iniciarEscaneo() {
        // Método para iniciar el escaneo cuando se presiona un botón, por ejemplo
        // Hints para el decodificador de códigos de barras y QR
        Map<DecodeHintType, Object> hints = new HashMap<>();
        hints.put(DecodeHintType.POSSIBLE_FORMATS, Arrays.asList(BarcodeFormat.CODE_128, BarcodeFormat.ITF));

        new Thread(new Runnable() {
            public void run() {
                boolean isScanned = false;

                while (!isScanned) {
                    BufferedImage image = webcam.getImage();
                    if (image != null) {
                        LuminanceSource source = new BufferedImageLuminanceSource(image);
                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                        try {
                            Result result = new MultiFormatReader().decode(bitmap, hints);
                            String decodedText = result.getText();
                            JOptionPane.showMessageDialog(WebcamClass.this, "Código decodificado: " + decodedText, "Escaneo exitoso", JOptionPane.INFORMATION_MESSAGE);
                            isScanned = true; // Se encontró un código, detener el escaneo
                        } catch (NotFoundException ex) {
                            // No se encontró un código, continuar escaneando
                        }
                    }
                }
            }
        }).start();
    }
}