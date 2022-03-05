
package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Liquidacion extends javax.swing.JFrame 
{
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection conexion_SQL = conexion_1.conectar();    
    java.sql.Connection conex = conexion_1.conectar();
    
    Inventario ventana_inventario = new Inventario();    
    
    DefaultTableModel modelo = new DefaultTableModel();
    DecimalFormat mi_formato = new DecimalFormat("###,###.##");    
    PreparedStatement pps;
    DefaultTableModel modelo_tabla ;
    int chicas_registradas = 0;
    
    int multiplo_Ab = 0;
    int multiplo_A2 = 0;
    int multiplo_Rb = 0;
    int multiplo_R2 = 0;
    int multiplo_Bb = 0;
    int multiplo_B2 = 0;
    int multiplo_piñas = 0;
    int multiplo_poker = 0;
    int multiplo_gaseosa = 0;
    int multiplo_agua = 0;
    int multiplo_gatorade = 0;
    int multiplo_reds = 0;
    int multiplo_club = 0;
    int multiplo_redbull = 0;
    int multiplo_corona = 0;
    int multiplo_wisky = 0;
    int multiplo_habitaciones = 0;
    int multiplo_multas = 0;
    int multiplo_examenes = 0;
    int multiplo_turnos = 0;
    int multiplo_show_individual = 0;
    int multiplo_show_grupo = 0;
    int multiplo_show_indi_grupo = 0;
    int multiplo_show_especial = 0;
    int resul_turnos = 0;
    int resul_turno_borrado = 0;
    int resul_prestamos = 0;
    int resul_multas = 0;
    int resul_examenes = 0;
    int resul_shows = 0;
    
    

    public Liquidacion() 
    {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Liquidación");
        
        modelo_tabla = (DefaultTableModel) jTable1_tabla_liquidacion2.getModel();
        jTable1_tabla_liquidacion2.setModel(modelo_tabla);
        jLabel3_fecha.setText(fecha_sistema());
        jTextField1_nombre.requestFocus();
        jButton2_liquidar.setVisible(false);
        jButton3_limpiar.setVisible(false);
        
        JTableHeader cabezera;
        cabezera = jTable1_tabla_liquidacion2.getTableHeader();
        Font fuente = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        //Font fuente = new Font("Cooper Black", 1, 10);
        //cabezera.setFont(fuente);
        cabezera.setFont(cabezera.getFont().deriveFont(Font.BOLD));
        
        JTableHeader cabezera_2;
        cabezera_2 = jTable1_tabla_chicas_liquidadas.getTableHeader();        
        Font fuente_2 = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        //Font fuente = new Font("Cooper Black", 1, 10);
        //cabezera_2.setFont(fuente);
        cabezera_2.setFont(cabezera_2.getFont().deriveFont(Font.BOLD));
        TableColumnModel columnModel = jTable1_tabla_liquidacion2.getColumnModel();             
        columnModel.getColumn(0).setPreferredWidth(2); 
//        columnModel.getColumn(1).setPreferredWidth(30);
//        columnModel.getColumn(2).setPreferredWidth(130);
//        columnModel.getColumn(3).setPreferredWidth(1);
//        columnModel.getColumn(4).setPreferredWidth(45);
//        columnModel.getColumn(5).setPreferredWidth(30);
//        columnModel.getColumn(6).setPreferredWidth(15);
//        columnModel.getColumn(7).setPreferredWidth(20);
//        columnModel.getColumn(8).setPreferredWidth(10);
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
           
    //Metodo para mostrar en el Jtable el show que ha hecho la chica
    public String tipo_shows(int tipo_show) 
    {                        
        String retorno_show = "";        

        if (tipo_show == 0) 
        {
            retorno_show = " 0";
            tipo_show = 0;
        }
        if (tipo_show == 1) 
        {
            tipo_show = 1;
            retorno_show = "Individual";            
        }
        if (tipo_show == 2) 
        {
            tipo_show = 2;
            retorno_show = "Ind/al y Grupo";            
        }
        if (tipo_show == 3) 
        {
            tipo_show = 3;
            retorno_show = "Grupo";
        }
        if (tipo_show == 4) 
        {    
            tipo_show = 4;
            retorno_show = "Especial";            
        }
        return retorno_show;
    }
    
    //Metodo para guardar en la BD por cada fecha cuantas chicas se han registrado
    public int cantidad_chicas_dia() 
    {       
        chicas_registradas = chicas_registradas + 1;            
                        
        return chicas_registradas;        
    }
    
    public void captura_precios() throws SQLException
    {
        String consulta_SQL =("SELECT * FROM `precios_productos` WHERE 1");
        Statement stm = conexion_SQL.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);
        
        if (conexion_SQL != null) 
        {
            while(rs.next())
            {
                multiplo_Ab = rs.getInt(3);                             
                multiplo_A2 = rs.getInt(4);                
                multiplo_Rb = rs.getInt(5);                
                multiplo_R2 = rs.getInt(6);                
                multiplo_Bb = rs.getInt(7);                
                multiplo_B2  = rs.getInt(8);                
                multiplo_piñas = rs.getInt(9);                
                multiplo_poker = rs.getInt(10);                
                multiplo_gaseosa = rs.getInt(11);                
                multiplo_agua = rs.getInt(12);                
                multiplo_gatorade = rs.getInt(13);                
                multiplo_reds = rs.getInt(14);                
                multiplo_club = rs.getInt(15);                
                multiplo_redbull = rs.getInt(16);                
                multiplo_corona = rs.getInt(17);  
                multiplo_wisky = rs.getInt(18);                
                multiplo_habitaciones = rs.getInt(19);                
                multiplo_multas = rs.getInt(20);
                multiplo_examenes = rs.getInt(21);
                multiplo_turnos = rs.getInt(22);
                multiplo_show_individual = rs.getInt(23);
                multiplo_show_grupo = rs.getInt(24);
                multiplo_show_indi_grupo = rs.getInt(25);
                multiplo_show_especial = rs.getInt(26);
            }
        }
    }
    
    //Metodo para mostrar el registro de las chicas de alguna fecha atras a la actual (Historial de registros)
    public void buscar_chica(String nombre_buscar, String evento) throws SQLException
    {       
        String fecha_anterior = fecha_dias_antes();        
        String fecha_actual = fecha_registro();
        
        int cantidad_chicas = 0;
        String fecha = "";
        String dia = "";
        String nombre = "";
        int turnos = 0;
        String turno_borrado = "";
        long prestamos = 0;
        int show = 0;        
        long multa = 0;
        long examenes = 0;              
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1_tabla_liquidacion2.getModel();
        jTable1_tabla_liquidacion2.setModel(modelo);
                
        String consulta_SQL = ("SELECT *FROM personal WHERE nombre ='"+nombre_buscar+"' AND fecha_trabajo BETWEEN '"+fecha_anterior+"' AND '" + fecha_actual + "'");                
        String consulta_SQL_2 = ("SELECT *FROM personal WHERE nombre ='"+nombre_buscar+"' AND fecha_trabajo BETWEEN '"+fecha_anterior+"' AND '" + fecha_actual + "'");
        Statement stm = conexion_SQL.createStatement();
        Statement stm_2 = conexion_SQL.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);                
        ResultSet rs_2 = stm_2.executeQuery(consulta_SQL);
        
        if (jTextField1_nombre.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "<html><h4>Ingrese el nombre de la chica a liquidar por favor</h4></html>" ,"Liquidación de Personal", JOptionPane.INFORMATION_MESSAGE, icono);            
            jTextField1_nombre.requestFocus();
            jTextField1_nombre.setFocusable(true);
        }
        else 
        {
            if (conex != null) 
            {
                if (evento.equals("Buscar")) 
                {       
                    if (rs_2.next()) 
                    {
                        
                    }
                    else
                    {                        
                        JOptionPane.showMessageDialog(null,"<html><h3>No hay registros con el nombre: "+nombre_buscar+"</h3></html>","Nombre sin registros", JOptionPane.INFORMATION_MESSAGE, icono);
                                                
                        jTextField1_nombre.requestFocus();
                        jTextField1_nombre.setFocusable(true);
                        jButton2_liquidar.setVisible(false);
                        jButton3_limpiar.setVisible(false);
                        rs_2.close();
                    }
                    while (rs.next()) 
                    {
                        cantidad_chicas = rs.getInt(2);
                        fecha = rs.getString(3);
                        dia = rs.getString(4);
                        nombre = rs.getString(5);
                        turnos = rs.getInt(6);
                        turno_borrado = rs.getString(7);
                        prestamos = rs.getLong(8);
                        show = rs.getInt(9);                         
                        String clase_show = tipo_shows(show);                         
                        multa = rs.getLong(10);
                        examenes = rs.getLong(11);

                        Object datos[] ={cantidad_chicas, fecha+"  "+dia, nombre, turnos, turno_borrado, mi_formato.format(prestamos),mi_formato.format(multa), (clase_show),mi_formato.format(examenes)};
                        modelo.addRow(datos);
                        jTextField1_nombre.setText("");
                        jTextField1_nombre.requestFocus();
                        jTextField1_nombre.setFocusable(true);
                        jButton2_liquidar.setVisible(true);
                        jButton3_limpiar.setVisible(true);
                    }                                            
                    rs.close();
                }
            }            
        }
    }
    
    public void verificar_liquidacion(String nombre_liquidar,String fecha_actual) throws SQLException, Throwable
    {
        boolean existe = true;
        String consulta_SQL = ("SELECT liquidacion FROM liquidaciones WHERE nombre ='"+nombre_liquidar+"' AND fecha_liquidacion ='"+fecha_actual + "'");        
        Statement stm = conexion_SQL.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");
            
        if (rs.first()) 
        {
            int liquidada = rs.getInt(1);            

            if (liquidada != 0) 
            {
                JOptionPane.showMessageDialog(null, "<html><h4>La chica de nombre:  " + nombre_liquidar + "  ya ha sido liquidada, verifique su nombre he intente de nuevo</h4></html>", "Liquidación de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
            } 
            else 
            {
                liquidar_chica(nombre_liquidar);
            }
        }
        else
        {
            if (rs.next()) 
            {            
                int liquidada = rs.getInt(1);

                if (liquidada != 0) 
                {
                    JOptionPane.showMessageDialog(null, "<html><h4>La chica de nombre:  " + nombre_liquidar + "  ya ha sido liquidada, verifique su nombre he intente de nuevo</h4></html>", "Liquidación de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
                } 
                else 
                {
                    liquidar_chica(nombre_liquidar);
                }
            }
            else
            {                                            
                liquidar_chica(nombre_liquidar);                             
            }
        }
        rs.close();        
    }

        
    public void liquidar_chica(String nombre_liquidar) throws SQLException, Throwable
    {               
        captura_precios();
        
        String fecha_anterior = fecha_dias_antes();
        String fecha_actual = fecha_registro();
        String dia_liquidacion = dias_de_la_semana();
        
        int cantidad_chicas = 0;
        String fecha = "";
        String nombre = "";
        int turnos = 0;
        String turno_borrado = "";
        String prestamos = "";
        int show = 0;
        int resul_show_cero =0;
        int resul_show_indi =0;
        int resul_show_indi_grupo =0;
        int resul_show_grupo =0;        
        String multas = "";
        String examenes = "";  
        int liquidacion =0;        
        
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");
                
        String consulta_SQL = ("SELECT *FROM personal WHERE nombre ='"+nombre_liquidar+"' AND fecha_trabajo BETWEEN '"+fecha_anterior+"' AND '" + fecha_actual + "'");        
        Statement stm = conexion_SQL.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);                    
        
        if (jTable1_tabla_liquidacion2.getValueAt(0, 2).toString().equals("")) 
        {                        
            JOptionPane.showMessageDialog(null, "<html><h4>Ingrese el nombre de la chica a liquidar por favor</h4></html>" ,"Liquidación de Personal", JOptionPane.INFORMATION_MESSAGE, icono);            
        }
        else 
        {
            if (conex != null) 
            {
                while (rs.next()) 
                {                    
                    fecha = rs.getString("fecha_trabajo");
                    nombre = rs.getString("nombre");
                    turnos = rs.getInt("turnos");
                    turno_borrado = rs.getString("turno_borrado");
                    prestamos = rs.getString("prestamos");
                    show = rs.getInt("shows");
                    multas = rs.getString("multas");                    
                    examenes = rs.getString("examenes");
                    
                    String clase_show = tipo_shows(show);
                    if (clase_show.equals("0")) 
                    {                        
                        resul_shows += 0;
                    }
                    if (clase_show.equals("Individual")) 
                    {                        
                        resul_shows += multiplo_show_individual;
                    }                    
                    if (clase_show.equals("Ind/al y Grupo")) 
                    {                        
                        resul_shows += multiplo_show_indi_grupo;
                    }
                    if (clase_show.equals("Grupo")) 
                    {                        
                        resul_shows += multiplo_show_grupo;
                    }
                    if (clase_show.equals("Especial")) 
                    {
                        
                        String aux_a = JOptionPane.showInputDialog(null, "<html><h4>Ingrese el valor del Show´s Especial que tiene la chica Ej:(40000), si no tiene escriba Cero(0)</h4></html>", "Liquidacion de " + nombre_liquidar, JOptionPane.INFORMATION_MESSAGE);
                        if (aux_a.equals("")||aux_a == null) 
                        {
                            liquidar_chica(nombre_liquidar);
                        }
                        else
                        {
                            int aux_b = Integer.parseInt(aux_a);
                            resul_shows +=aux_b;                                                                                   
                        }                        
                    }
                    resul_turnos = turnos * multiplo_turnos;
                    
                    if (!turno_borrado.equals("0")) 
                    {
                        resul_turno_borrado += multiplo_turnos;
                    } 
                    else 
                    {
                        resul_turno_borrado += 0;
                    }
                    resul_prestamos += Integer.parseInt(prestamos);

                    resul_multas += Integer.parseInt(multas);
                    
                    if (!examenes.equals("0")) 
                    {
                        resul_examenes += Integer.parseInt(examenes);
                    } 
                    else 
                    {
                        resul_examenes += 0;
                    }
                }

                rs.close();
                jTextField1_nombre.setText("");
                jTextField1_nombre.requestFocus();
                jTextField1_nombre.setFocusable(true);
                
                if (resul_shows == 0) 
                {
                    modelo = (DefaultTableModel) jTable1_tabla_liquidacion2.getModel();
                    int a = modelo.getRowCount() - 1;
                    for (int i = 0; i <= a; i++) 
                    {
                        modelo.removeRow(0);
                    }
                    resul_shows = 0;
                }

                int numero_positio = resul_turnos + resul_shows;
                int numero_negativo = (resul_prestamos) + (resul_turno_borrado) + (resul_multas) + (resul_examenes);                
                liquidacion = numero_positio - numero_negativo;                
                JOptionPane.showMessageDialog(null, "<html><h4>La liquidacion total de " +  nombre_liquidar + " es: $ " + mi_formato.format(liquidacion)+"</h4></html>", "Liquidacion de " + nombre_liquidar, JOptionPane.INFORMATION_MESSAGE, icono);                
                guardar_liquidacion(fecha_actual,dia_liquidacion, nombre_liquidar, resul_turnos, resul_turno_borrado, resul_prestamos, resul_multas, resul_shows, resul_examenes, liquidacion);                
                modelo = (DefaultTableModel) jTable1_tabla_liquidacion2.getModel();
                int a = modelo.getRowCount();                
                for (int i = 1; i <=a; i++) 
                {
                    modelo.removeRow(0);
                }
                resul_turnos = 0;
                resul_shows = 0;
                resul_turno_borrado = 0;
                resul_prestamos = 0;
                resul_multas = 0;
                resul_examenes = 0;
                
                jTable1_tabla_chicas_liquidadas.scrollRectToVisible (jTable1_tabla_chicas_liquidadas.getCellRect (modelo.getRowCount()+2, 0, true));
            }
        }
        jButton2_liquidar.setVisible(false);
    }
    
    public void guardar_liquidacion(String fecha_actual, String dia_liquidacion,String nombre_liquidar,int cantidad_turnos,int turno_borrado,int prestamos,int multas, int shows,int examenes,int liquidacion)
    {        
        int cantidad_chicas_resgistradas = cantidad_chicas_dia();
                                 
        DefaultTableModel modelo_2 =  (DefaultTableModel) jTable1_tabla_chicas_liquidadas.getModel();
        jTable1_tabla_chicas_liquidadas.setModel(modelo_2);
        
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");
                    
        if (conex != null) 
        {
            try 
            {                
                PreparedStatement pps = conex.prepareStatement("INSERT INTO `liquidaciones`(`fecha_liquidacion`, `dia_semana`, `nombre`, `turnos`, `turno_borrados`, `prestamos`, `multas`, `shows`, `examenes`, `liquidacion`) VALUES (?,?,?,?,?,?,?,?,?,?)");
                pps.setString(1, fecha_actual);
                pps.setString(2, dia_liquidacion);
                pps.setString(3, nombre_liquidar);                
                pps.setInt(4, cantidad_turnos);
                pps.setInt(5, turno_borrado);
                pps.setInt(6, prestamos);
                pps.setInt(7,multas);
                pps.setInt(8, shows);
                pps.setInt(9, examenes);
                pps.setInt(10, liquidacion);                

                pps.executeUpdate();                                
                
                Object datos[] ={cantidad_chicas_resgistradas,fecha_actual+" "+dia_liquidacion, nombre_liquidar, mi_formato.format(cantidad_turnos), mi_formato.format(turno_borrado), mi_formato.format(prestamos), mi_formato.format(multas),  mi_formato.format(shows), mi_formato.format(examenes), mi_formato.format(liquidacion)};
                modelo_2.addRow(datos);                
                JOptionPane.showMessageDialog(null, "<html><h4>Registro guardado Correctamente</h4></html>", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(Liquidacion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar en la Base de Datos:" + ex);
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Error NO se ha Guardado el Registro", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }

    public void historial_chicas_liquidadas() throws SQLException
    {
        Historial_chicas_liquidadas ventaHistorial_chicas_liquidadas = new Historial_chicas_liquidadas();
        ventaHistorial_chicas_liquidadas.setVisible(true);
        ventaHistorial_chicas_liquidadas.historial_chicas_liquidadas();
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jButton2_salir = new javax.swing.JButton();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jButton1_buscar = new javax.swing.JButton();
        jTextField1_nombre = new javax.swing.JTextField();
        jButton2_liquidar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_tabla_liquidacion2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1_tabla_chicas_liquidadas = new javax.swing.JTable();
        jLabel3_cantidad_de_liquidacion = new javax.swing.JLabel();
        jButton3_historial_chicas_liquidadas = new javax.swing.JButton();
        jButton1_total_liquidaciones = new javax.swing.JButton();
        jButton3_limpiar = new javax.swing.JButton();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 310, -1));

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 90, -1));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 185, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 185, 20));

        jButton1_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton1_buscar.setText("Buscar");
        jButton1_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_buscarActionPerformed(evt);
            }
        });
        jButton1_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(jButton1_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 110, 25));

        jTextField1_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nombreKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 25));

        jButton2_liquidar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_liquidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/liquidar.png"))); // NOI18N
        jButton2_liquidar.setText("Liquidar");
        jButton2_liquidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_liquidarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_liquidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, 25));

        jTable1_tabla_liquidacion2.setBackground(new java.awt.Color(204, 245, 208));
        jTable1_tabla_liquidacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1_tabla_liquidacion2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable1_tabla_liquidacion2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha", "Nombre", "Turnos", "Turno Borrado", "Prestamos", "Multas", "Show's", "Examenes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_tabla_liquidacion2.setEnabled(false);
        jTable1_tabla_liquidacion2.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1_tabla_liquidacion2.setRowMargin(0);
        jTable1_tabla_liquidacion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_tabla_liquidacion2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_tabla_liquidacion2);
        if (jTable1_tabla_liquidacion2.getColumnModel().getColumnCount() > 0) {
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(0).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(1).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(1).setPreferredWidth(125);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(2).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(3).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(4).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(5).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(5).setPreferredWidth(35);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(6).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(6).setPreferredWidth(20);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(7).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(8).setResizable(false);
            jTable1_tabla_liquidacion2.getColumnModel().getColumn(8).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 880, 140));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Nombre de la chica a liquidar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, -1));

        jTable1_tabla_chicas_liquidadas.setBackground(new java.awt.Color(204, 245, 208));
        jTable1_tabla_chicas_liquidadas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable1_tabla_chicas_liquidadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha", "Nombre", "Turnos", "Turno Borrado", "Prestamos", "Multas", "Show's", "Examenes", "Liquidación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_tabla_chicas_liquidadas.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1_tabla_chicas_liquidadas.setRowHeight(15);
        jScrollPane2.setViewportView(jTable1_tabla_chicas_liquidadas);
        if (jTable1_tabla_chicas_liquidadas.getColumnModel().getColumnCount() > 0) {
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(0).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(1).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(2).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(3).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(4).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(4).setPreferredWidth(65);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(5).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(5).setPreferredWidth(42);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(6).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(6).setPreferredWidth(28);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(7).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(7).setPreferredWidth(28);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(8).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(8).setPreferredWidth(40);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(9).setResizable(false);
            jTable1_tabla_chicas_liquidadas.getColumnModel().getColumn(9).setPreferredWidth(42);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 880, 340));

        jLabel3_cantidad_de_liquidacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3_cantidad_de_liquidacion.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_cantidad_de_liquidacion.setText("Chicas Liquidadas:");
        getContentPane().add(jLabel3_cantidad_de_liquidacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 120, -1));

        jButton3_historial_chicas_liquidadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3_historial_chicas_liquidadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/liquidar_2.png"))); // NOI18N
        jButton3_historial_chicas_liquidadas.setText("Historial de Chicas Liquidadas");
        jButton3_historial_chicas_liquidadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_historial_chicas_liquidadasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_historial_chicas_liquidadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 635, -1, 25));

        jButton1_total_liquidaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_total_liquidaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/liquidar.png"))); // NOI18N
        jButton1_total_liquidaciones.setText("Total Liquidación $");
        jButton1_total_liquidaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_total_liquidacionesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_total_liquidaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 635, -1, 25));

        jButton3_limpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar2.png"))); // NOI18N
        jButton3_limpiar.setText("Limpiar Tabla");
        jButton3_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 670));

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

    private void jButton1_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_buscarActionPerformed
        
        String evento = evt.getActionCommand();
        String nombre = jTextField1_nombre.getText();
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar_3.png");
        
        modelo_tabla = (DefaultTableModel) jTable1_tabla_liquidacion2.getModel();
        int a = modelo_tabla.getRowCount();
        if (a > 0)      
        {
            JOptionPane.showMessageDialog(null, "<html><h4>Elimine la infomración de la tabla primero con el botón (Eliminar Tabla)</html></h4>"
                ,"Liquidar Personal", JOptionPane.INFORMATION_MESSAGE,icono);          
        }
        else
        {
            try 
            {
                buscar_chica(nombre, evento);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Liquidacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1_buscarActionPerformed

    private void jTextField1_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nombreKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jButton1_buscar.requestFocus(); 
        }               
    }//GEN-LAST:event_jTextField1_nombreKeyPressed

    private void jButton1_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_buscarKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            this.jButton1_buscar.doClick();
        }
    }//GEN-LAST:event_jButton1_buscarKeyPressed

    private void jButton2_liquidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_liquidarActionPerformed
        // TODO add your handling code here:
        String nombre = jTable1_tabla_liquidacion2.getValueAt(0, 2).toString();          
        String fechca_actual = fecha_registro();
        String evento = evt.getActionCommand();
        try 
        {                        
            verificar_liquidacion(nombre,fechca_actual);            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Liquidacion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Throwable ex) 
        {
            Logger.getLogger(Liquidacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2_liquidarActionPerformed

    private void jButton3_historial_chicas_liquidadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_historial_chicas_liquidadasActionPerformed
        // TODO add your handling code here:
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");        
        //String fecha_buscar = JOptionPane.showInputDialog(null,"<html><h4>Ingrese la fecha de la liquidación que desea buscar Ej:(2010-20-12)</h4></html>","Historial de Liquidaciones",JOptionPane.INFORMATION_MESSAGE);                
                
        try 
        {
            historial_chicas_liquidadas();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Liquidacion.class.getName()).log(Level.SEVERE, null, ex);
        }                        
    }//GEN-LAST:event_jButton3_historial_chicas_liquidadasActionPerformed

    private void jButton1_total_liquidacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_total_liquidacionesActionPerformed
        // TODO add your handling code here:
        int total_liquidacion = 0;
        modelo= (DefaultTableModel) jTable1_tabla_chicas_liquidadas.getModel();
        int a = modelo.getRowCount()-1;       
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar_3.png");
        
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
                
            JOptionPane.showMessageDialog(null, "<html><h4>El valor Total de la Liquidación de todas las chicas es: "+mi_formato.format(total_liquidacion)+"</h4></html>", "Liquidacion de Chicas", JOptionPane.INFORMATION_MESSAGE,icono);            
        }              
    }//GEN-LAST:event_jButton1_total_liquidacionesActionPerformed

    private void jButton3_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_limpiarActionPerformed
        // TODO add your handling code here:
        
        modelo = (DefaultTableModel) jTable1_tabla_liquidacion2.getModel();
        int a = modelo.getRowCount() - 1;
        for (int i = 0; i <= a; i++) 
        {
            modelo.removeRow(0);
        }
        jButton2_liquidar.setVisible(false);
    }//GEN-LAST:event_jButton3_limpiarActionPerformed

    private void jTable1_tabla_liquidacion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_tabla_liquidacion2MouseClicked
        // TODO add your handling code here:
        
        for (int c = 0; c < jTable1_tabla_liquidacion2.getColumnCount(); c++)
        {
            Class<?> col_class = jTable1_tabla_liquidacion2.getColumnClass(c);
            jTable1_tabla_liquidacion2.setDefaultEditor(col_class, null);        // remove editor
        }
    }//GEN-LAST:event_jTable1_tabla_liquidacion2MouseClicked
    
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
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Liquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Liquidacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_buscar;
    private javax.swing.JButton jButton1_total_liquidaciones;
    private javax.swing.JButton jButton2_liquidar;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JButton jButton3_historial_chicas_liquidadas;
    private javax.swing.JButton jButton3_limpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel3_cantidad_de_liquidacion;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1_tabla_chicas_liquidadas;
    private javax.swing.JTable jTable1_tabla_liquidacion2;
    private javax.swing.JTextField jTextField1_nombre;
    // End of variables declaration//GEN-END:variables
}
