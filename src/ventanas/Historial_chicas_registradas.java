/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Edward Henao1
 */
public class Historial_chicas_registradas extends javax.swing.JFrame 
{

    //Variables
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection enlace_1 = conexion_1.conectar();
    java.sql.Connection conex = conexion_1.conectar();
    Connection conector = null; 
    
    Personal ventan_personal = new Personal();
        
    DefaultTableModel modelo;
    String [][]matriz = {};
    String titulos[]={"N°","Fecha","Nombre","Turnos","Turno Borrado","Prestamos","Show´s","Multas","Examenes"};
    DecimalFormat mi_formato = new DecimalFormat("###,###.##");
    
    
    public Historial_chicas_registradas() 
    {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Historial Chicas registradas");
        jLabel3_fecha.setText(fecha_sistema());
        
        modelo = new DefaultTableModel(matriz, titulos);
        jTable1_datos.setModel(modelo);
        jLabel3_fecha.setText(fecha_sistema());
        JTableHeader cabezera;
        cabezera = jTable1_datos.getTableHeader();
        Font fuente = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        //Font fuente = new Font("Cooper Black", 1, 10);
        //cabezera.setFont(fuente);
        cabezera.setFont(cabezera.getFont().deriveFont(Font.BOLD));
        
        TableColumnModel columnModel = jTable1_datos.getColumnModel();        
        columnModel.getColumn(0).setPreferredWidth(1);
        columnModel.getColumn(1).setPreferredWidth(130);
//        columnModel.getColumn(2).setPreferredWidth(75);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(80);
        columnModel.getColumn(7).setPreferredWidth(25);
        columnModel.getColumn(8).setPreferredWidth(40);
        
        jTable1_datos.getTableHeader().setResizingAllowed(false);
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
    
     //Metodo para saber que show ha hecho la chica y poderlo guardar en la BD
    public int tipo_shows_guardar(int indice_combo) 
    {        
        //int indice_combo = jComboBox1_show.getSelectedIndex();
        int tipo_show = 0;
        String retorno_show = "";        

        if (indice_combo == 0) 
        {            
            tipo_show = 0;
        }
        if (indice_combo == 1) 
        {            
            tipo_show = 1;
        }
        if (indice_combo == 2) 
        {            
            tipo_show = 2;
        }
        if (indice_combo == 3) 
        {
            tipo_show = 3;            
        }
        if (indice_combo == 4) 
        {                                        
            tipo_show = 4;
        }
        return tipo_show;
    }
    
    //Metodo para mostrar en el Jtable el show que ha hecho la chica
    public String tipo_shows_mostrar(int tipo_show) 
    {                        
        String retorno_show = "";        

        if (tipo_show == 0) 
        {
            retorno_show = " 0";
            tipo_show = 0;
        }
        if (tipo_show == 1) 
        {
            retorno_show = "Individual";  
            tipo_show = 1;                      
        }
        if (tipo_show == 2) 
        {
            retorno_show = "Ind/al y Grupo";
            tipo_show = 2;                        
        }
        if (tipo_show == 3) 
        {
            retorno_show = "Grupo";
            tipo_show = 3;            
        }
        if (tipo_show == 4) 
        {    
            retorno_show = "Especial";
            tipo_show = 4;                        
        }
        return retorno_show;
    }    

    //Metodo para mostrar el registro de las chicas de alguna fecha atras a la actual (Historial de registros)
    public void mostrar_resgistro_diario_chicas(String fecha_buscar) throws SQLException
    {       
        int cantidad_chicas;
        String fecha = "";
        String dia_semana = "";
        String nombre = "";
        int turnos = 0;
        String turno_borrado = "";
        String prestamos = "";
        int show = 0;
        
        String multa = "";
        String examenes = "";        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                        
        String consulta_SQL = ("SELECT *FROM personal WHERE fecha_trabajo ='"+fecha_buscar+"'");        ;
        Statement stm = conex.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);                
                                                   
            if (!rs.next()) 
            {
                JOptionPane.showMessageDialog(null, "Error NO se ha encontrado ningun registro con la fecha: " + fecha_buscar + "", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
            } 
            else 
            {
                if (rs.first()) 
                {
                    cantidad_chicas = rs.getInt(2);
                    fecha = rs.getString(3);
                    dia_semana = rs.getString(4);
                    nombre = rs.getString(5);
                    turnos = rs.getInt(6);
                    turno_borrado = rs.getString(7);
                    prestamos = rs.getString(8);
                    int aux_prestamos = Integer.valueOf(prestamos);
                    show = rs.getInt(9);
                    String clase_show = tipo_shows_mostrar(show);
                    multa = rs.getString(10);
                    int aux_multa = Integer.valueOf(multa);
                    examenes = rs.getString(11);           
                    int aux_examenes = Integer.valueOf(examenes);

                    modelo.addRow(new Object[]{cantidad_chicas, fecha+" "+dia_semana, nombre, turnos, turno_borrado, mi_formato.format(aux_prestamos), clase_show, mi_formato.format(aux_multa), mi_formato.format(aux_examenes)});                    
                }
                while (rs.next()) 
                {
                    cantidad_chicas = rs.getInt(2);
                    fecha = rs.getString(3);
                    dia_semana = rs.getString(4);
                    nombre = rs.getString(5);
                    turnos = rs.getInt(6);
                    turno_borrado = rs.getString(7);
                    prestamos = rs.getString(8);
                    int aux_prestamos = Integer.valueOf(prestamos);
                    show = rs.getInt(9);
                    String clase_show = tipo_shows_mostrar(show);
                    multa = rs.getString(10);
                    int aux_multa = Integer.valueOf(multa);
                    examenes = rs.getString(11);           
                    int aux_examenes = Integer.valueOf(examenes);

                    modelo.addRow(new Object[]{cantidad_chicas, fecha+" "+dia_semana, nombre, turnos, turno_borrado, mi_formato.format(aux_prestamos), clase_show, mi_formato.format(aux_multa), mi_formato.format(aux_examenes)});
                }
                if (rs.next()) 
                {                                        
                    cantidad_chicas = rs.getInt(2);
                    fecha = rs.getString(3);
                    dia_semana = rs.getString(4);
                    nombre = rs.getString(5);
                    turnos = rs.getInt(6);
                    turno_borrado = rs.getString(7);
                    prestamos = rs.getString(8);
                    int aux_prestamos = Integer.valueOf(prestamos);
                    show = rs.getInt(9);
                    String clase_show = tipo_shows_mostrar(show);
                    multa = rs.getString(10);
                    int aux_multa = Integer.valueOf(multa);
                    examenes = rs.getString(11);           
                    int aux_examenes = Integer.valueOf(examenes);

                    modelo.addRow(new Object[]{cantidad_chicas, fecha+" "+dia_semana, nombre, turnos, turno_borrado, mi_formato.format(aux_prestamos), clase_show, mi_formato.format(aux_multa), mi_formato.format(aux_examenes)});
                }                               
                
                while (rs.next())
                {
                    cantidad_chicas = rs.getInt(2);
                    fecha = rs.getString(3);
                    dia_semana = rs.getString(4);                    
                    nombre = rs.getString(5);
                    turnos = rs.getInt(6);
                    turno_borrado = rs.getString(7);
                    prestamos = rs.getString(8);
                    int aux_prestamos = Integer.valueOf(prestamos);
                    show = rs.getInt(9);
                    String clase_show = tipo_shows_mostrar(show);
                    multa = rs.getString(10);
                    int aux_multa = Integer.valueOf(multa);
                    examenes = rs.getString(11);           
                    int aux_examenes = Integer.valueOf(examenes);
                    
                    modelo.addRow(new Object[]{cantidad_chicas, fecha+" "+dia_semana, nombre, turnos, turno_borrado, mi_formato.format(aux_prestamos), clase_show, mi_formato.format(aux_multa), mi_formato.format(aux_examenes)});
                }
            }
            rs.close();        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jButton2_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_datos = new javax.swing.JTable();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 360, -1));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 170, 20));

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 90, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Historial de Registro de chicas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1_datos.setBackground(new java.awt.Color(204, 255, 208));
        jTable1_datos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable1_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha", "Nombre", "Turnos", "Turno Borrado", "Prestamos", "Show's", "Multas", "Examenes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1_datos.setEnabled(false);
        jTable1_datos.setGridColor(new java.awt.Color(153, 255, 255));
        jTable1_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_datos);
        if (jTable1_datos.getColumnModel().getColumnCount() > 0) {
            jTable1_datos.getColumnModel().getColumn(0).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(1).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(2).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(3).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(4).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(5).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(6).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(7).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 830, 400));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_salirActionPerformed

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

    private void jTable1_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_datosMouseClicked
        // TODO add your handling code here:
        
        for (int c = 0; c < jTable1_datos.getColumnCount(); c++)
        {
            Class<?> col_class = jTable1_datos.getColumnClass(c);
            jTable1_datos.setDefaultEditor(col_class, null);        // remove editor
        }
    }//GEN-LAST:event_jTable1_datosMouseClicked
    
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
            java.util.logging.Logger.getLogger(Historial_chicas_registradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial_chicas_registradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial_chicas_registradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial_chicas_registradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial_chicas_registradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_datos;
    // End of variables declaration//GEN-END:variables
   
}
