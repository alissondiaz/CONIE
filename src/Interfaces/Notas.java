/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Resource.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

public class Notas extends javax.swing.JInternalFrame {
    ConexionBD cone;
   DefaultTableModel modelo;
    public Notas() {
        initComponents();
        cone=new ConexionBD();
        consultar();
        cargarLabel();
        cargaCombo1();
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
     
     public void cargaCombo1(){
     jComboBox2.removeAllItems();
     
     
        try {
            ResultSet rs=cone.consultaBD("SELECT * FROM grupos where DocenteLider="+jLabel8.getText());
            while(rs.next()){
                jComboBox2.addItem(rs.getString("Nombre"));
            }
        } catch (Exception e) {
        }
     
     
     }
     
       public void cargaCombo2(){
       try {
           
           jComboBox3.removeAllItems();
           ConexionBD cone2 = new ConexionBD();
           ResultSet rs=cone2.consultaBD("select m.Nombre from materias_x_grupo_x_docente mgd "
                   + "inner join materias m on mgd.IdMateria = m.Id where mgd.IdDocente ="+jLabel8.getText()+""
                           + " and mgd.IdGrupo = (select Id from grupos where Nombre='"+jComboBox2.getSelectedItem()+"')");
           while(rs.next()){
               jComboBox3.addItem(rs.getString("m.Nombre"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
       }
     
 }
       
       public void cargaCombo3(){
       jComboBox4.removeAllItems();
       ConexionBD cone3 = new ConexionBD();
       
        try {
            ResultSet rs = cone3.consultaBD("SELECT * FROM logros where IdMaterias =(select Id from materias where Nombre='"+jComboBox3.getSelectedItem()+"')");
            while(rs.next()){
                jComboBox4.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       public void cargaCombo4(){
           jComboBox5.removeAllItems();
       ConexionBD cone4 = new ConexionBD();   
        try {
            ResultSet rs = cone4.consultaBD("select a.nombre from actividades a inner join logros l on a.IdLogro = l.Id where l.nombre='"+jComboBox4.getSelectedItem()+"'");

            while(rs.next()){
                jComboBox5.addItem(rs.getString("a.nombre"));
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
            ResultSet rs= cone.consultaBD("SELECT * FROM notasxlogro ");
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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 120, 20));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 120, -1));

        jLabel1.setText("Docente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 17, -1, -1));

        jLabel6.setText("Nombre del Docente:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 17, -1, -1));

        jLabel4.setText("Logros :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 141, 120, -1));

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
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));
        getContentPane().add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 120, -1));
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

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        cargaCombo2();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
       cargaCombo3();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        cargaCombo4();
    }//GEN-LAST:event_jComboBox4ItemStateChanged


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
