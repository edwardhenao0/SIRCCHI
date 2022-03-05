package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Historial_chicas_liquidadas extends javax.swing.JFrame 
{

    //Variables
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection enlace_1 = conexion_1.conectar();
    java.sql.Connection conex = conexion_1.conectar();
    Connection conector = null; 
           
    DecimalFormat mi_formato = new DecimalFormat("###,###.##");
    DefaultTableModel modelo;
    String [][]matriz = {};
    String titulos[]={"N°","Fecha Liquidación","Nombre","Turnos","Turno Borrado","Prestamos","Multas","Show´s","Examenes","Liquidación"};
    
    
    public Historial_chicas_liquidadas() 
    {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Historial Chicas Liquidadas");
        jLabel3_fecha.setText(fecha_sistema());
        
        modelo = new DefaultTableModel(matriz, titulos);
        jTable1_tabla_chicas_liquidadas.setModel(modelo);
        jLabel3_fecha.setText(fecha_sistema());
        JTableHeader cabezera;
        cabezera = jTable1_tabla_chicas_liquidadas.getTableHeader();
        Font fuente = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        //Font fuente = new Font("Cooper Black", 1, 10);
        //cabezera.setFont(fuente);
        cabezera.setFont(cabezera.getFont().deriveFont(Font.BOLD));
        
        TableColumnModel columnModel = jTable1_tabla_chicas_liquidadas.getColumnModel();        
        columnModel.getColumn(0).setPreferredWidth(2);
        columnModel.getColumn(1).setPreferredWidth(135);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(35);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(25);
        columnModel.getColumn(7).setPreferredWidth(35);
        columnModel.getColumn(8).setPreferredWidth(35);
        columnModel.getColumn(9).setPreferredWidth(55);
        
        jTable1_tabla_chicas_liquidadas.getTableHeader().setResizingAllowed(false);
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
    String fecha_registro() 
    {
        SimpleDateFormat formato_sql = new SimpleDateFormat("yyyy-MM-dd");//2018-09-09 19:52:54
        Date hoy = new Date();
        Date ayer = new Date(hoy.getTime() - 86400000);
        String variable_fecha = formato_sql.format(ayer);

        return variable_fecha;
    }
    
    //Metodo para obtener la fecha de registro del dia en que inicia la semana y asi saber los turnos de la chica
    private String fecha_dias_antes() 
    {
        SimpleDateFormat formato_sql = new SimpleDateFormat("yyyy-MM-dd");//2018-09-09 19:52:54        
        Date hoy = new Date();        
        int dia = 0;
        String dia_semana = dias_de_la_semana();
        
        if (dia_semana.equals("Lunes")) 
        {
            dia = 6;
        } 
        else 
        {
            if (dia_semana.equals("Martes")) 
            {
                dia = 7;
            } 
            else 
            {
                if (dia_semana.equals("Miercoles")) 
                {
                    dia = 1;
                } 
                else 
                {
                    if (dia_semana.equals("Jueves")) 
                    {
                        dia = 2;
                    } 
                    else 
                    {
                        if (dia_semana.equals("Viernes")) 
                        {
                            dia = 3;
                        } 
                        else 
                        {
                            if (dia_semana.equals("Sabado")) 
                            {
                                dia = 4;
                            } 
                            else 
                            {
                                if (dia_semana.equals("Domingo")) 
                                {
                                    dia = 5;
                                }
                            }
                        }
                    }
                }
            }
        }
                                
        Date ayer = new Date(hoy.getTime() - (86400000 * dia));
        //Date ayer = new Date(hoy.getTime() - (86400000));
        String variable_fecha = formato_sql.format(ayer);
        
        return variable_fecha;
    }
    
    //Metodo para saber los dias de la semana y poder saber desde donde se debe buscar el turno
    public String dias_de_la_semana()
    {    
        Calendar now = Calendar.getInstance();
        String dia_semana = "";
        
        String[] Arreglo_dias = new String[] //Array con los dias de la semana 
        {
            "Domingo",
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes",
            "Sabado"}; 
        
        dia_semana = (Arreglo_dias[now.get(Calendar.DAY_OF_WEEK) - 1]);        
        return dia_semana;        
    }

    //Metodo para mostrar el registro de las chicas de alguna fecha atras a la actual (Historial de registros)
    public void historial_chicas_liquidadas() throws SQLException
    {       
        String fecha_actual = fecha_registro();
        String fecha_anterior = fecha_dias_antes();
        
        int cantidad_chicas ;
        String fecha = "";
        String dia = "";
        String nombre = "";
        int turnos = 0;
        int turno_borrado = 0;
        int prestamos = 0;
        int show = 0;
        int multa = 0;
        int examenes = 0;
        int liquidacion = 0;       
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                        
        String consulta_SQL = ("SELECT *FROM liquidaciones WHERE fecha_liquidacion BETWEEN '"+fecha_anterior+"' AND '"+fecha_actual+"'");       
        Statement stm = conex.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);                
                                                   
            
        if (!rs.next()) 
        {
            JOptionPane.showMessageDialog(null, "Error NO se ha encontrado ningun registro con la fecha: " + fecha_actual + "", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
        } 
        else 
        {
            if (rs.first()) 
            {
                cantidad_chicas = rs.getInt("Id");
                fecha = rs.getString("fecha_liquidacion");
                dia = rs.getString("dia_semana");
                nombre = rs.getString("nombre");
                turnos = rs.getInt("turnos");
                turno_borrado = rs.getInt("turno_borrados");
                prestamos = rs.getInt("prestamos");
                multa = rs.getInt("multas");
                show = rs.getInt("shows");                
                examenes = rs.getInt("examenes");
                liquidacion = rs.getInt("liquidacion");
                
                Object datos[] ={cantidad_chicas, fecha+"  "+dia, nombre, mi_formato.format(turnos), mi_formato.format(turno_borrado), mi_formato.format(prestamos), mi_formato.format(multa),  mi_formato.format(show), mi_formato.format(examenes), mi_formato.format(liquidacion)};
                modelo.addRow(datos);               
            }
            while (rs.next()) 
            {
                cantidad_chicas = rs.getInt("Id");
                fecha = rs.getString("fecha_liquidacion");
                dia = rs.getString("dia_semana");
                nombre = rs.getString("nombre");
                turnos = rs.getInt("turnos");
                turno_borrado = rs.getInt("turno_borrados");
                prestamos = rs.getInt("prestamos");
                multa = rs.getInt("multas");
                show = rs.getInt("shows");                
                examenes = rs.getInt("examenes");
                liquidacion = rs.getInt("liquidacion");

                Object datos[] ={cantidad_chicas, fecha+"  "+dia, nombre, mi_formato.format(turnos), mi_formato.format(turno_borrado), mi_formato.format(prestamos), mi_formato.format(multa),  mi_formato.format(show), mi_formato.format(examenes), mi_formato.format(liquidacion)};
                modelo.addRow(datos);                
            }
        }            
        rs.close(); 
        
        int total_liquidacion = 0;
        modelo= (DefaultTableModel) jTable1_tabla_chicas_liquidadas.getModel();
        int a = modelo.getRowCount()-1;               
        
        if (a != -1) 
        {
            for (int i = 0; i <= a; i++) 
            {                                
                String aux_total = jTable1_tabla_chicas_liquidadas.getValueAt(i, 9).toString();
                double aux_1 = Double.parseDouble(aux_total);
                double aux_2 = aux_1*1000;
                int aux_3= (int)aux_2;
                total_liquidacion += aux_3;                 
            }                            
        }
        
        jTextField1_total_liquidacion.setText(String.valueOf(mi_formato.format(total_liquidacion)));
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
        jTable1_tabla_chicas_liquidadas = new javax.swing.JTable();
        jTextField1_total_liquidacion = new javax.swing.JTextField();
        jLabel2_total_liquidacion = new javax.swing.JLabel();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 360, -1));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 170, 20));

        jButton2_salir.setBackground(new java.awt.Color(153, 255, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 90, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Historial de chicas Liquidadas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1_tabla_chicas_liquidadas.setBackground(new java.awt.Color(204, 255, 208));
        jTable1_tabla_chicas_liquidadas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable1_tabla_chicas_liquidadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha Liquidacion", "Nombre", "Turnos", "Turno Borrado", "Prestamos", "Multas", "Show's", "Examenes", "Liquidación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_tabla_chicas_liquidadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1_tabla_chicas_liquidadas.setGridColor(new java.awt.Color(153, 255, 255));
        jTable1_tabla_chicas_liquidadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_tabla_chicas_liquidadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_tabla_chicas_liquidadas);
        if (jTable1_tabla_chicas_liquidadas.getColumnModel().getColumnCount() > 0) {
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(0).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(1).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(2).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(3).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(4).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(5).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(6).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(7).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(8).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(9).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 900, 400));

        jTextField1_total_liquidacion.setEditable(false);
        jTextField1_total_liquidacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jTextField1_total_liquidacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 495, 80, -1));

        jLabel2_total_liquidacion.setBackground(new java.awt.Color(102, 255, 255));
        jLabel2_total_liquidacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2_total_liquidacion.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2_total_liquidacion.setText("EL Total Liquidado es: $");
        getContentPane().add(jLabel2_total_liquidacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, -1, -1));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 530));

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

    private void jTable1_tabla_chicas_liquidadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_tabla_chicas_liquidadasMouseClicked
        // TODO add your handling code here:
        
        for (int c = 0; c < jTable1_tabla_chicas_liquidadas.getColumnCount(); c++)
        {
            Class<?> col_class = jTable1_tabla_chicas_liquidadas.getColumnClass(c);
            jTable1_tabla_chicas_liquidadas.setDefaultEditor(col_class, null);        // remove editor
        }
    }//GEN-LAST:event_jTable1_tabla_chicas_liquidadasMouseClicked
    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(Historial_chicas_liquidadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial_chicas_liquidadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial_chicas_liquidadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial_chicas_liquidadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new Historial_chicas_liquidadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel2_total_liquidacion;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_tabla_chicas_liquidadas;
    private javax.swing.JTextField jTextField1_total_liquidacion;
    // End of variables declaration//GEN-END:variables
   
}
