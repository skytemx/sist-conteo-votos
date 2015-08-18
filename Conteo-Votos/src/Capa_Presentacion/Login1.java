/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Presentacion;

import BackupMySQL.BackupDiario;
import Capa_Negocio.AccesoUsuario;
import Capa_Negocio.CalcularMoras;
import Capa_Negocio.FormatoFecha;
import inicio.start;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author 30234
 */
public class Login1 extends javax.swing.JFrame {

    private boolean accesoConcedido = false;
    private JOptionPane op;

    /**
     * Creates new form Login
     */
    public Login1() {
        initComponents();
    }

    private void login() {
        Calendar c = Calendar.getInstance();
        String fechaactual = "";
        String fechapc = FormatoFecha.getFormato(c.getTime(), FormatoFecha.A_M_D);

        if (fechainicio.getCalendar() != null) {
            fechaactual = FormatoFecha.getFormato(fechainicio.getCalendar().getTime(), FormatoFecha.A_M_D);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la fecha Actual", "Error: Datos vacios.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fechaactual.equals(fechapc)) {
            if (!this.usuario.getText().isEmpty() && !this.password.getText().isEmpty()) {

                String msg = "";
                AccesoUsuario.Estado configUsuario = AccesoUsuario.configUsuario(usuario.getText(), password.getText());

                if (configUsuario == AccesoUsuario.Estado.NO_EXISTE) {
                    msg = "El usuario:  " + this.usuario.getText() + "  no existe.";
                } else if (configUsuario == AccesoUsuario.Estado.USR_INACTICVO) {
                    msg = "El usuario: " + this.usuario.getText() + " no esta Activo.\n"
                            + "Comuniquese con el Administrador del Sistema";
                } else if (configUsuario == AccesoUsuario.Estado.ERROR_CLAVE) {
                    msg = "¡Contraseña Incorrecta!";
                } else if (configUsuario == AccesoUsuario.Estado.ACCESO_OK) {
                    Principal j = new Principal();
                    j.setVisible(true);
                    this.dispose();
                    //CalcularMoras.moras();//Si el usuario tiene acceso calcula moras si las hay
                    BackupDiario.GenerarBackupDiarioMySQL();
                    accesoConcedido = true;
                    return;
                }
                JOptionPane.showMessageDialog(this, msg, "Error: no se pudo conectar.", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre de usuario y su contraseña", "Error: Datos vacios.", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Verifique la fecha de la PC no Conicide con la fecha Actual");
            return;
        }
    }

    public boolean isAccesoConcedido() {
        return accesoConcedido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new elaprendiz.gui.panel.PanelImage();
        panelCurves1 = new elaprendiz.gui.panel.PanelCurves();
        jLabel5 = new javax.swing.JLabel();
        panelImage2 = new elaprendiz.gui.panel.PanelImage();
        usuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        iniciar = new elaprendiz.gui.button.ButtonAction();
        fechainicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlPaginador2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso al Sistema");
        setName("login"); // NOI18N
        setType(java.awt.Window.Type.UTILITY);

        panelImage1.setBackground(java.awt.SystemColor.activeCaption);
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/font.png"))); // NOI18N
        panelImage1.setLayout(null);

        panelCurves1.setToolTipText("");
        panelCurves1.setFont(new java.awt.Font("Arial", 1, 35)); // NOI18N
        panelCurves1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 38)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("\"COMPUVISIÓN\"");
        panelCurves1.add(jLabel5);
        jLabel5.setBounds(-3, 398, 330, 40);

        panelImage2.setBackground(java.awt.SystemColor.activeCaption);
        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/foil-154927_640.png"))); // NOI18N

        usuario.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        password.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        iniciar.setText("Acceder al Sistema");
        iniciar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        fechainicio.setDateFormatString("dd/MM/yyyy");
        fechainicio.setFocusable(false);
        fechainicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fechainicio.setMaxSelectableDate(new java.util.Date(3093496470100000L));
        fechainicio.setMinSelectableDate(new java.util.Date(-62135744300000L));
        fechainicio.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Fecha Actual:");

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                        .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                        .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelImage2Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelImage2Layout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE)))
        );

        panelCurves1.add(panelImage2);
        panelImage2.setBounds(10, 140, 296, 260);

        panelImage1.add(panelCurves1);
        panelCurves1.setBounds(0, 40, 320, 450);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/login_1.png"))); // NOI18N
        panelImage1.add(jLabel2);
        jLabel2.setBounds(-1, 45, 320, 128);

        pnlPaginador2.setBackground(new java.awt.Color(0, 0, 0));
        pnlPaginador2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlPaginador2.setToolTipText("");
        pnlPaginador2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pnlPaginador2.setPreferredSize(new java.awt.Dimension(786, 40));
        pnlPaginador2.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Script MT Bold", 1, 32)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        pnlPaginador2.add(jLabel10, new java.awt.GridBagConstraints());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Acceso al sistema");
        pnlPaginador2.add(jLabel6, new java.awt.GridBagConstraints());

        panelImage1.add(pnlPaginador2);
        pnlPaginador2.setBounds(0, 0, 320, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_iniciarActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /* asi debe ser linea de sintaxis para poder llamar la clase otra*/
                new Thread(new start()).start();
            }
        });
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fechainicio;
    private elaprendiz.gui.button.ButtonAction iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private elaprendiz.gui.panel.PanelCurves panelCurves1;
    private elaprendiz.gui.panel.PanelImage panelImage1;
    private elaprendiz.gui.panel.PanelImage panelImage2;
    private javax.swing.JPasswordField password;
    private javax.swing.JPanel pnlPaginador2;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
