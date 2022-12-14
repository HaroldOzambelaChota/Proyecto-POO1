/*H
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Login;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import controlador.ControladorLogin;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.Blob;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author MASTER
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    Login login=null;
    public frmLogin() {
        initComponents();
        this.setSize(240,520);
        this.setLocationRelativeTo(null);
        cambiarCursor();
        txtLusu.setText("Brayan");
        txtLpass.setText("123");
    }
    void cambiarCursor(){
        btnIniciaSecion.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
        
    public String getLGusu(){
        return txtLusu.getText();
    }
    
    public String getLGpass(){
        return String.valueOf(txtLpass.getPassword());
    }
    
    
    public void limpiar(){
        txtLpass.setText("");
        txtLusu.setText("");
    }
    
    public void validarIng(){
        
        if (txtLusu.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Ingrese Usuario");
        }else if (getLGpass().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "ingrese Password");
        }else{
            login=new Login(getLGusu(), getLGpass());
            if(ControladorLogin.validarUsuario(login)) {
                frmMenu menu= new frmMenu();
                menu.setVisible(true);
                menu.txtMosUsuario.setText(login.getUsuario());
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "usuario y/o contraseña incorrectos");
                txtLusu.requestFocus();
            }
            limpiar();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   public static void tema(){
                try {
                    UIManager.setLookAndFeel(new AluminiumLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLusu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnIniciaSecion = new javax.swing.JButton();
        txtLpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 290, 24, 49);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("INICIAR SECION");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 230, 220, 29);

        txtLusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLusuActionPerformed(evt);
            }
        });
        getContentPane().add(txtLusu);
        txtLusu.setBounds(60, 300, 163, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/candado.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 350, 24, 49);

        btnIniciaSecion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIniciaSecion.setText("INGRESAR");
        btnIniciaSecion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciaSecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciaSecionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciaSecion);
        btnIniciaSecion.setBounds(50, 430, 140, 28);

        txtLpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLpassActionPerformed(evt);
            }
        });
        getContentPane().add(txtLpass);
        txtLpass.setBounds(60, 360, 163, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGIN.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 240, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciaSecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciaSecionActionPerformed
        // TODO add your handling code here:
        validarIng();
        
    }//GEN-LAST:event_btnIniciaSecionActionPerformed

    private void txtLusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLusuActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtLpass.requestFocus();
    }//GEN-LAST:event_txtLusuActionPerformed

    private void txtLpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLpassActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        btnIniciaSecionActionPerformed(evt);
    }//GEN-LAST:event_txtLpassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tema();
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciaSecion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtLpass;
    private javax.swing.JTextField txtLusu;
    // End of variables declaration//GEN-END:variables
}
