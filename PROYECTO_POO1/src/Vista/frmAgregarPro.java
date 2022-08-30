/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.DBManager;
import Modelo.Producto;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultText;
import controlador.ControladorProducto;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.InterfaceAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN-PC
 */
public class frmAgregarPro extends javax.swing.JFrame {

    /**
     * Creates new form frmAgregarPro
     */
    ControladorProducto c = new ControladorProducto();
    DefaultTableModel modT = new DefaultTableModel();
    Producto agregar = null;

    public frmAgregarPro() {
        
        initComponents();
        this.setSize(850, 490);
        this.setLocationRelativeTo(null);
        ControladorProducto.mostrar(modT, tblProducto);
        txtCodigoP.setText(ControladorProducto.generarCodigo());
        txtCodigoP.setEditable(false);
        btnGuardar.setVisible(false);
    }

    public int codigo() {
        return Integer.parseInt(txtCodigoP.getText());
    }

    public String nombre() {
        return txtNombreP.getText();
    }

    public double precio() {
        return Double.parseDouble(txtPrecioP.getText());
    }

    public int stock() {
        return Integer.parseInt(txtCantidadP.getText());
    }

    public String estado() {
        if (rbnDisponible.isSelected()) {
            return "A";
        } else {
            return "I";
        }
    }

    public void agregar() {
        agregar = new Producto(nombre(), precio(), stock(), estado());
        if (ControladorProducto.insertar(agregar) > 0) {
            JOptionPane.showMessageDialog(null, "insertado");
        }
    }

    public void cajaCodigo() {
        agregar();
        txtCodigoP.setEditable(true);

        txtCodigoP.setText(c.generarCodigo());
        txtCodigoP.setEditable(false);
    }

    public int selector() {
        return tblProducto.getSelectedRow();
    }

    public int id() {
        return tblProducto.getSelectedColumn();
    }

    public void buscar() {
        String id = tblProducto.getValueAt(selector(), 0).toString();
        int codigo = Integer.parseInt(id);
        if (ControladorProducto.buscar(txtNombreP, txtPrecioP, rbnDisponible,rbnNoDisponible, txtCantidadP, codigo) && selector() > -1) {
            btnActualizar.setVisible(false);
            txtCodigoP.setEditable(true);
            if (codigo < 10) {
                txtCodigoP.setText("000" + String.valueOf(codigo));
            } else {
                txtCodigoP.setText("00" + codigo);
            }
            txtCodigoP.setEditable(false);
            btnGuardar.setVisible(true);
        } 
        else {
            JOptionPane.showMessageDialog(null, "no encontrado");
        }

    }

    void limpiar() {
        txtNombreP.setText("");
        txtPrecioP.setText("");
        txtCantidadP.setText("");
        rbnDisponible.setSelected(true);
        txtNombreP.requestFocus();
    }

    void generarCodigo() {
        txtCodigoP.setEditable(true);
        txtCodigoP.setText(ControladorProducto.generarCodigo());
        txtCodigoP.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecioP = new javax.swing.JTextField();
        txtCantidadP = new javax.swing.JTextField();
        Estado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        rbnNoDisponible = new javax.swing.JRadioButton();
        rbnDisponible = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Codigo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 20, 60, 16);

        txtCodigoP.setBorder(null);
        getContentPane().add(txtCodigoP);
        txtCodigoP.setBounds(150, 10, 90, 30);

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 70, 50, 10);

        txtNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePActionPerformed(evt);
            }
        });
        txtNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombreP);
        txtNombreP.setBounds(150, 60, 180, 30);

        jLabel3.setText("Precio:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 100, 50, 20);

        txtPrecioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecioP);
        txtPrecioP.setBounds(150, 100, 80, 30);
        getContentPane().add(txtCantidadP);
        txtCantidadP.setBounds(150, 140, 100, 30);

        Estado.setText("Cantidad:");
        getContentPane().add(Estado);
        Estado.setBounds(80, 140, 60, 20);

        jLabel6.setText("Estado:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 180, 60, 20);

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver);
        btnVolver.setBounds(780, 0, 38, 40);

        buttonGroup1.add(rbnNoDisponible);
        rbnNoDisponible.setText("No disponible");
        rbnNoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnNoDisponibleActionPerformed(evt);
            }
        });
        getContentPane().add(rbnNoDisponible);
        rbnNoDisponible.setBounds(260, 180, 110, 20);

        buttonGroup1.add(rbnDisponible);
        rbnDisponible.setText("Disponible");
        getContentPane().add(rbnDisponible);
        rbnDisponible.setBounds(150, 180, 90, 20);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/download_done_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(380, 20, 60, 40);

        tblProducto.setBackground(new java.awt.Color(0, 255, 255));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 220, 607, 226);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/auto_delete_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(690, 290, 60, 60);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar - copia.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(690, 220, 60, 60);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save_as_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(690, 220, 60, 60);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(150, 40, 90, 2);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo6.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 840, 478);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        
     if(validar()){   
        cajaCodigo();
        limpiar();
        }
        ControladorProducto.mostrar(modT, tblProducto);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        frmMenu menu = new frmMenu();
        //menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int respuesta;
        String id ="";
        int codigo=0;
                         
        try {
            if (selector() < 0) {
                JOptionPane.showMessageDialog(null, "no ha seleccionado producto a eliminar");
            } else {
                respuesta = JOptionPane.showConfirmDialog(null, "seguro que desea eliminar", "eliminar", JOptionPane.YES_NO_OPTION);
                id=tblProducto.getValueAt(selector(), 0).toString();
                codigo=Integer.parseInt(id);
                if (respuesta == JOptionPane.YES_OPTION) {
                    ControladorProducto.eliminar(codigo);
                    ControladorProducto.mostrar(modT, tblProducto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (selector() > -1) {
            buscar();

            btnAgregar.setEnabled(false);

            btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "selecione antes de presionar boton");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    
    public boolean validar(){
        boolean v=false;
        if (txtNombreP.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "ingrese nombre");
            
        }if (txtPrecioP.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"ingrese precio");
        }if (txtCantidadP.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"ingrrese cantidad");
        } else{
            v=true;
        }
        return v;
        
    }
    
    private void rbnNoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnNoDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnNoDisponibleActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int codigo = Integer.parseInt(txtCodigoP.getText());
        ControladorProducto.actualizar(codigo, nombre(), precio(), estado(), stock());

        ControladorProducto.mostrar(modT, tblProducto);
        btnAgregar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnActualizar.setVisible(true);
        btnGuardar.setVisible(false);
        limpiar();
        generarCodigo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtNombreP.requestFocus();
    }//GEN-LAST:event_txtNombrePActionPerformed

    private void txtNombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Campo de solo texto");
        }
    }//GEN-LAST:event_txtNombrePKeyTyped

    private void txtPrecioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtPrecioPActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregarPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new AluminiumLookAndFeel());
                } catch (Exception e) {
                }
                new frmAgregarPro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Estado;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbnDisponible;
    private javax.swing.JRadioButton rbnNoDisponible;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtCantidadP;
    public static transient volatile javax.swing.JTextField txtCodigoP;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtPrecioP;
    // End of variables declaration//GEN-END:variables
}
