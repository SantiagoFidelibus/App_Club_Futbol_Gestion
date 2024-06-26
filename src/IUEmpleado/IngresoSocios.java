/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IUEmpleado;

import Containers.ContenedoraSocio;
import Mail.Correos;
import Model.Empleado;
import Model.Socio;
import Webcam.WebCamScan;
import Webcam.WebcamClass;
import Login.Login;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author sanch
 */
public class IngresoSocios extends javax.swing.JFrame {
    int xMouse, yMouse;
    /**
     * Creates new form IngresoSocios
     */
    private WebCamScan webCamScan;

    /**
     * Creates new form IngresoSocios
     */
            ContenedoraSocio socios = new ContenedoraSocio();

    public IngresoSocios() {
        initComponents();
setTitle("Administracion Acantilados FC");
        try{
            File iconFile = new File("src/com/images/LOGO1.png"); // Ruta de tu imagen
            BufferedImage iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            socios.cargarSociosDeJson("Socios.json");
        } catch (IOException e) {
            System.out.println("Error al cargar el JSON de Socios");
        }


        socios.verificarQr();
        validarIngresoBtn.setVisible(false);
        validarIngresoBtn.setEnabled(false);
        fondoDatos.setVisible(false);
        fondoDatos.setEnabled(false);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitMenu = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        scanBtn = new javax.swing.JButton();
        cerrarSesionLabel = new javax.swing.JLabel();
        Marco = new javax.swing.JLabel();
        fotoUsuario = new javax.swing.JLabel();
        validarIngresoBtn = new javax.swing.JButton();
        pelota4 = new javax.swing.JLabel();
        pelota2 = new javax.swing.JLabel();
        fondo_1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondoDatos.setBackground(new java.awt.Color(255, 255, 255));
        fondoDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fondoDatos.add(jLabel1);

        getContentPane().add(fondoDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 220, 30));

        exitMenu.setBackground(new java.awt.Color(255, 255, 255));
        exitMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                exitMenuMouseDragged(evt);
            }
        });
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMenuMousePressed(evt);
            }
        });
        exitMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setBackground(new java.awt.Color(0, 0, 0));
        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitTxtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        exitMenu.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        getContentPane().add(exitMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        scanBtn.setText("ESCANEAR");
        scanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanBtnMouseClicked(evt);
            }
        });
        scanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBtnActionPerformed(evt);
            }
        });
        getContentPane().add(scanBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        cerrarSesionLabel.setForeground(new java.awt.Color(59, 132, 173));
        cerrarSesionLabel.setText("Cerrar Sesion");
        cerrarSesionLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarSesionLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarSesionLabelMouseExited(evt);
            }
        });
        getContentPane().add(cerrarSesionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        Marco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagesPersonas/marcoPerso.png"))); // NOI18N
        getContentPane().add(Marco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 250, 200));

        fotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/FotoCarnet.png"))); // NOI18N
        fotoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotoUsuarioMouseClicked(evt);
            }
        });
        getContentPane().add(fotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 150, 140));

        validarIngresoBtn.setText("Validar Ingreso");
        validarIngresoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    validarIngresoBtnMouseClicked(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        validarIngresoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarIngresoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(validarIngresoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        pelota4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/medicine.png"))); // NOI18N
        getContentPane().add(pelota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -40, -1, -1));

        pelota2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/medicine.png"))); // NOI18N
        getContentPane().add(pelota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -120, 200, 270));

        fondo_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/Rectangle 1.png"))); // NOI18N
        getContentPane().add(fondo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 450, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void headerMouseDragged(MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed
    private void scanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scanBtnActionPerformed

    private void scanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanBtnMouseClicked
        this.setVisible(false);

        WebCamScan webCamScan = new WebCamScan(new Runnable() {
            @Override
            public void run() {
                // Leer archivo y actualizar datosSocio
                validarIngresoBtn.setVisible(true);
                validarIngresoBtn.setEnabled(true);
                fondoDatos.setVisible(true);
                fondoDatos.setEnabled(true);

                String filePath = "src/com/imagesPersonas/" + leerArchivo() + ".png";
                File file = new File(filePath);
                if (file.exists()) {
                    ImageIcon icon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(fotoUsuario.getWidth(), fotoUsuario.getHeight(), Image.SCALE_SMOOTH));
                    fotoUsuario.setIcon(icon);
                }else{
                    filePath = "src/com/images/FotoCarnet.png";
                    ImageIcon icon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(fotoUsuario.getWidth(), fotoUsuario.getHeight(), Image.SCALE_SMOOTH));
                    fotoUsuario.setIcon(icon);
                }

                    Socio socioIngresante = null;
                    String legajo=leerArchivo();
                    try {
                        socioIngresante = socios.buscar(Integer.valueOf(legajo));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    jLabel1.setText("Nombre Completo: "+socioIngresante.getNombre()+" "+socioIngresante.getApellido());

                IngresoSocios.this.setVisible(true);

            }
        });
        webCamScan.createAndShowGUI();

    }//GEN-LAST:event_scanBtnMouseClicked

    private void fotoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoUsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fotoUsuarioMouseClicked

    private void validarIngresoBtnMouseClicked(java.awt.event.MouseEvent evt) throws Exception {//GEN-FIRST:event_validarIngresoBtnMouseClicked
        Correos correo = new Correos();
        String dato = leerArchivo();
        Socio socioIngresante = socios.buscar(Integer.valueOf(dato));

        if (socioIngresante == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró al socio.", "Error de Ingreso", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            if (!socioIngresante.isAptoMedico() && socioIngresante.isAptoCuota()) {
                javax.swing.JOptionPane.showMessageDialog(this, "El socio debe realizar su certificado médico.", "Error de Ingreso", javax.swing.JOptionPane.ERROR_MESSAGE);
                new Thread(() -> {
                    try {
                        correo.CorreoAptoMedicoRequerido(socioIngresante.getEmail(),socioIngresante.getNombre());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();

            } else if (!socioIngresante.isAptoCuota() && socioIngresante.isAptoMedico()) {
                javax.swing.JOptionPane.showMessageDialog(this, "El socio debe pagar su cuota.", "Error de Ingreso", javax.swing.JOptionPane.ERROR_MESSAGE);
                new Thread(() -> {
                    try {
                        correo.CorreoDeuda(socioIngresante.getEmail());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (!socioIngresante.isAptoCuota() && !socioIngresante.isAptoMedico()) {
                javax.swing.JOptionPane.showMessageDialog(this, "El socio debe pagar su cuota y realizar su certificación médica.", "Error de Ingreso", javax.swing.JOptionPane.ERROR_MESSAGE);
                new Thread(() -> {
                    try {
                        correo.CorreoRegularizate(socioIngresante.getEmail(),socioIngresante.getNombre());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (socioIngresante.isAptoCuota() && socioIngresante.isAptoMedico()) {
                javax.swing.JOptionPane.showMessageDialog(this, "El socio está al día y puede realizar sus actividades.", "Ingreso exitoso", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }//GEN-LAST:event_validarIngresoBtnMouseClicked

    private void validarIngresoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarIngresoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_validarIngresoBtnActionPerformed

    private void cerrarSesionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionLabelMouseClicked
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        this.dispose();        
    }//GEN-LAST:event_cerrarSesionLabelMouseClicked

    private void cerrarSesionLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionLabelMouseEntered
   cerrarSesionLabel.setBackground(new Color(80,139,166));
    }//GEN-LAST:event_cerrarSesionLabelMouseEntered

    private void cerrarSesionLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionLabelMouseExited
        cerrarSesionLabel.setBackground(new Color(59,132,173));
    }//GEN-LAST:event_cerrarSesionLabelMouseExited

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void exitTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitTxtMousePressed

    private void exitMenuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_exitMenuMouseDragged

    private void exitMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_exitMenuMousePressed


    public String leerArchivo() {
        String rutaArchivo = "src/com/temp/datoingreso.txt";
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si no se puede leer el archivo
        }

        return contenido.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Marco;
    private javax.swing.JLabel cerrarSesionLabel;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JPanel exitMenu;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel fondoDatos;
    private javax.swing.JLabel fondo_1;
    private javax.swing.JLabel fotoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pelota2;
    private javax.swing.JLabel pelota4;
    private javax.swing.JButton scanBtn;
    private javax.swing.JButton validarIngresoBtn;
    // End of variables declaration//GEN-END:variables
}
