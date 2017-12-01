/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

public class Notas extends javax.swing.JInternalFrame {
    conDB cone;
   DefaultTableModel modelo;
    public Notas() {
        initComponents();
        cone=new conDB();
        consultar();
        cargarLabel();
    }
     public void cargarLabel(){
        
         
       
        try {
            ResultSet rs = cone.consultaBD("SELECT * FROM docentes where Id=1");
            while(rs.next()){
                jLabel8.setText(rs.getString("Id"));
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         
       
        
        try {
            ResultSet rs = cone.consultaBD("SELECT * FROM usuario where Id=1");
            while(rs.next()){
                
                jLabel7.setText(rs.getString("Nombres")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         
         
        
    }

   public void consultar(){
       
         String titulos[]={"IdLogro", "Estudiante","Nota"};
         modelo= new DefaultTableModel(null,titulos);
         String fila[]= new String[3];
        
        try {
            ResultSet rs= cone.consultaBD("SELECT * FROM NotaxLogro ");
        while (rs.next ()) {
            fila [0]=rs.getString("IdLogro");
            fila [1]=rs.getString("Estudiante");
            fila [2]=rs.getString("Nota");
             modelo.addRow(fila);
            }
         jTable1.setModel(modelo);
        } catch (Exception error) {
            System.out.println("Error "+error);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Notas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Grupo que da el Docente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, -1, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 16, 185, 20));

        jLabel3.setText("Materias del Grupo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 99, -1, -1));

        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 54, -1, -1));

        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 99, -1, -1));

        jLabel1.setText("Docente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 17, -1, -1));

        jLabel6.setText("Nombre del Docente:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 17, -1, -1));

        jLabel4.setText("Logros :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 146, -1, -1));

        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 141, 28, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 514, 133));

        jButton1.setText("Guardar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, -1));

        jLabel5.setText("Actividad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 201, -1, -1));

        getContentPane().add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 196, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, 20));

        jLabel9.setText("calificacion");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
