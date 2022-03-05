
package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edward Henao1
 */
public class Eliminar_chica extends javax.swing.JFrame 
{

    DecimalFormat mi_formato = new DecimalFormat("###,###.##");
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection enlace_1 = conexion_1.conectar();
    java.sql.Connection conex = conexion_1.conectar();
    
 
    
    public Eliminar_chica() 
    {
        initComponents();               
        setLocation(480, 250);
        setTitle("Eliminar chicas");
        jLabel3_fecha.setText(fecha_sistema());
        jTextField1_nombre_chica.requestFocus();
        jTextField1_nombre_chica.setFocusable(true);
    }

     //Metodo para obtener la fecha del sistema
    private String fecha_sistema() 
    {
        //Locale local_col = new Locale("pt", "COL");
        java.util.Date fecha = new java.util.Date();
        DateFormat df_1 = DateFormat.getDateInstance(DateFormat.LONG);
        //DateFormat df_2 = DateFormat.getDateInstance(DateFormat.MEDIUM);        
        //DateFormat df_3 = DateFormat.getDateInstance(DateFormat.SHORT);
        //DateFormat df_4 = DateFormat.getDateInstance(DateFormat.LONG, local_col);
        //DateFormat df_5 = DateFormat.getTimeInstance(DateFormat.MEDIUM);        
        DateFormat hora_fecha = DateFormat.getTimeInstance(DateFormat.LONG);
        String hora = hora_fecha.format(fecha);
        String variable_fecha = df_1.format(fecha);

        jLabel4_hora.setText(hora);
        return variable_fecha;
    }
    
     //Metodo para obtener la fecha del registro
    private String fecha_registro() 
    {
        SimpleDateFormat formato_sql = new SimpleDateFormat("yyyy-MM-dd");//2018-09-09 19:52:54
        Date hoy = new Date();
        Date ayer = new Date(hoy.getTime() - 86400000);
        String variable_fecha = formato_sql.format(ayer);

        return variable_fecha;
    }
    
    //Metodo para traer de ventana Buscar_chica el valor de la fila seleccionada
    public String seleccionar_fecha()
    {              
        Buscar_chica ventana_buscar_chica = new Buscar_chica();
        int fila_seleccion = ventana_buscar_chica.fila_seleccionada;
        String fecha_borrar = ventana_buscar_chica.fecha_registros.get(fila_seleccion);
        
        return  fecha_borrar;
    }
    
    
    
    //Metodo para eliminar un registro del mismo dia
    public void eliminar_registro_chica() throws SQLException
    {        
        String nombre_borrar = jTextField1_nombre_chica.getText();
        String fecha_eliminar = jTextField1_fecha_borar.getText();
        ImageIcon icono = new ImageIcon("src/Imagenes/borrar2.png");
                        
        String consulta_SQL = ("DELETE FROM `personal` WHERE nombre = '"+nombre_borrar+"' AND fecha_trabajo = '"+fecha_eliminar+"'");
        
        PreparedStatement pps = conex.prepareCall(consulta_SQL);
        boolean execute = pps.execute();
        if (execute == true) 
        {
            JOptionPane.showMessageDialog(null, "Error, No Se ha podido eliminar el registro de nombre: "+nombre_borrar+" y fecha: "+fecha_eliminar+" con exito","Eliminar Registro",JOptionPane.INFORMATION_MESSAGE,icono);
        }
        else
        {            
            JOptionPane.showMessageDialog(null, "Se ha eliminado el registro de nombre: "+nombre_borrar+" y fecha: "+fecha_eliminar+" con exito","Eliminar Registro",JOptionPane.INFORMATION_MESSAGE,icono);
        }
        jTextField1_nombre_chica.setText("");
        jTextField1_fecha_borar.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2_salir = new javax.swing.JButton();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jTextField1_nombre_chica = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1_eliminar = new javax.swing.JButton();
        jTextField1_fecha_borar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 30));

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 310, -1));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 190, 20));

        jTextField1_nombre_chica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_nombre_chica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nombre_chicaKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_nombre_chica, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, -1));

        jLabel1.setBackground(new java.awt.Color(51, 0, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Nombre a borrar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jButton1_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar2.png"))); // NOI18N
        jButton1_eliminar.setText("Eliminar");
        jButton1_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_eliminarActionPerformed(evt);
            }
        });
        jButton1_eliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1_eliminarKeyPressed(evt);
            }
        });
        getContentPane().add(jButton1_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, 25));

        jTextField1_fecha_borar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_fecha_borar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_fecha_borarKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_fecha_borar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 130, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("Fecha a borrar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        jLabel1_fondo.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_eliminarActionPerformed
        // TODO add your handling code here:
                
        ImageIcon icono = new ImageIcon("src/Imagenes/borrar2.png");
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta usted seguro que desea eliminar este registro?", "Eliminar Registro de: "+jTextField1_nombre_chica.getText(), JOptionPane.INFORMATION_MESSAGE);
        if (confirmacion == 0) 
        {
            try 
            {
                eliminar_registro_chica();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Eliminar_chica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error, No se ha eliminado el registro" + ex);
            }                        
        }
        else
        {
            if (confirmacion == 1) 
            {
                JOptionPane.showMessageDialog(null, "No esta seguro de Eliminar el registo de: "+jTextField1_nombre_chica.getText()+",  Adios... ","Eliminar Registro",JOptionPane.INFORMATION_MESSAGE,icono);
                try 
                {
                    dispose();
                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setExtendedState(JFrame.CROSSHAIR_CURSOR);
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "Se ha Generado la excepcion:" + e);
                }
            }
            else
            {
                
            }
        }
    }//GEN-LAST:event_jButton1_eliminarActionPerformed

    private void jButton2_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_salirActionPerformed
        // TODO add your handling code here:        
        try 
        {           
            dispose();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.CROSSHAIR_CURSOR);                       
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Se ha Generado la excepcion:" + e);
        }
    }//GEN-LAST:event_jButton2_salirActionPerformed

    private void jTextField1_nombre_chicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nombre_chicaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jTextField1_fecha_borar.requestFocus();
        }
    }//GEN-LAST:event_jTextField1_nombre_chicaKeyPressed

    private void jTextField1_fecha_borarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_fecha_borarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_eliminar.requestFocus();
            jButton1_eliminar.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_fecha_borarKeyPressed

    private void jButton1_eliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_eliminarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_eliminar.doClick();            
        }
    }//GEN-LAST:event_jButton1_eliminarKeyPressed

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
            java.util.logging.Logger.getLogger(Eliminar_chica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar_chica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar_chica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar_chica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_chica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_eliminar;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JTextField jTextField1_fecha_borar;
    private javax.swing.JTextField jTextField1_nombre_chica;
    // End of variables declaration//GEN-END:variables
}
