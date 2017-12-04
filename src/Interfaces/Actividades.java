package Interfaces;

import Resource.ConexionBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
public class Actividades extends javax.swing.JInternalFrame {
    ConexionBD cone;
    ConexionBD cone2;
   DefaultTableModel modelo;
    public Actividades() {
        initComponents();
       
        cone=new ConexionBD();
        cone2=new ConexionBD();
        jComboBox3.setVisible(false);
        cargarLabels();
        
        cargarCombos();
      
             jLabel3.setVisible(false);
             jLabel4.setVisible(false);
             jComboBox3.setVisible(false);
             jComboBox4.setVisible(false);
      
       
    }
 public void cargarLabels(){
        try{
         ResultSet rs = cone.consultaBD("SELECT * FROM docentes where Id=1");
       
         while(rs.next()){
             jLabel11.setText(rs.getString("Id"));
             
         } 
    }catch (Exception error) {
            System.out.println("Error " + error);
        }
        
         try{
       
        ResultSet rs = cone.consultaBD("SELECT * FROM usuario where Id=1");
         while(rs.next()){
            
             jLabel12.setText(rs.getString("Nombres"));
         } 
    }catch (Exception error) {
            System.out.println("Error " + error);
        }
         
         
        
    }
 
 public void cargarCobo2(){
       try {
           
           jComboBox3.removeAllItems();
           ConexionBD cone2 = new ConexionBD();
           ResultSet rs=cone2.consultaBD("select m.Nombre from materias_x_grupo_x_docente mgd "
                   + "inner join materias m on mgd.IdMateria = m.Id where mgd.IdDocente ="+jLabel11.getText()+""
                           + " and mgd.IdGrupo = (select Id from grupos where Nombre='"+jComboBox2.getSelectedItem()+"')");
           while(rs.next()){
               jComboBox3.addItem(rs.getString("m.Nombre"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
       }
     
 }
 
 public void cargaCobo3(){
     ConexionBD cone3 = new ConexionBD();
     
         jComboBox4.removeAllItems();
       try {
           ResultSet rs=cone3.consultaBD("SELECT * FROM logros where id_tipo=1 and IdMaterias=(select Id from materias where Nombre='"+jComboBox3.getSelectedItem()+"')");
           while(rs.next()){
               jComboBox4.addItem(rs.getString("nombre"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(Actividades.class.getName()).log(Level.SEVERE, null, ex);
       }

 }
 
 public void cargarCombos(){
     
     String nom=(String)jComboBox2.getSelectedItem();
      try {
            ResultSet rs=cone.consultaBD("SELECT * FROM grupos where DocenteLider="+jLabel11.getText());
            while(rs.next()){
                jComboBox2.addItem(rs.getString("Nombre"));
            }
        } catch (Exception e) {
        }
 
 }
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actividades");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Docente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 20));

        jLabel2.setText("Grupo que da el Docente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 59, -1, -1));

        jLabel3.setText("Materias del Grupo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 99, -1, -1));

        jLabel4.setText("Logros Academicos :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion de la Actividad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jButton1.setText("Crear actividad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 272, 127));

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
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 54, 110, -1));

        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 99, 110, -1));

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 135, 110, -1));

        jLabel6.setText("Nombre del Docente:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, 20));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 16, 130, 20));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 135, -1, 350));

        jLabel10.setText("Nombre de la Actividad:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 229, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 222, 120, 29));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 110, 20));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 100, 20));

        jLabel13.setText("Porcentaje");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 120, 30));

        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String des=jTextField1.getText();
        
        String nombre=jTextField2.getText();
        String por=jTextField3.getText();
        cone.modificaBD("INSERT INTO actividades VALUES (null,1,'"+nombre+"','"+des+"',"+por+")");
        cargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
           jComboBox3.setVisible(true);
           jLabel3.setVisible(true);
        cargarCobo2();
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged
public void cargarTabla(){
    String titulos[]={"id_materia","actividad","procentaje"};
            modelo=new DefaultTableModel(null,titulos);
            String filas[]=new String[3];
        try {
           ResultSet rs = cone.consultaBD("SELECT m.Id,a.Nombre,a.porcentaje from actividades a "
                   + "inner join logros on a.IdLogro=logros.Id inner join materias m on logros.IdMaterias=m.Id");
           while(rs.next()){
               filas[0]=rs.getString("m.Id");
               filas[1]=rs.getString("a.Nombre");
               filas[2]=rs.getString("a.porcentaje");
               modelo.addRow(filas);
           }
           jTable1.setModel(modelo);
        } catch (Exception e) {
        }
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           cargarTabla();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        String cod=(String)jComboBox3.getSelectedItem();
        jComboBox4.setVisible(true);
        jLabel4.setVisible(true);
        cargaCobo3();
       
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
