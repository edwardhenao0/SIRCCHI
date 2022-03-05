
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
import java.util.ArrayList;
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


public class Buscar_chica extends JFrame
{
    //Variables y atributos
    DefaultTableModel modelo_tabla = new DefaultTableModel();
    DecimalFormat mi_formato = new DecimalFormat("###,###.##");
    DecimalFormat mi_formato_2 = new DecimalFormat("########");
    
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection enlace_1 = conexion_1.conectar();
    java.sql.Connection conex = conexion_1.conectar();    
    
    int chicas_registradas = 0;
    int turno_registros = 0;
    int fila_seleccionada = 0;   
    int id_registro = 0;
    int aux_id = 0;   
    ArrayList <Integer> id_registros = new ArrayList();
    ArrayList <Integer> cantidad_registradas = new ArrayList();
    ArrayList <String> fecha_registros = new ArrayList();
     ArrayList <String> dia_registros = new ArrayList();
    
    
    public Buscar_chica() 
    {
        initComponents();
        fila_seleccionada = 0;
        setLocationRelativeTo(null);
        setTitle("Buscar Chica");
        
        jTable1_datos.setFont(new java.awt.Font("Tahoma", 1, 11));
        jTable1_datos.getTableHeader().getColumnModel();
        jTable1_datos.setRowHeight(20);
        

        JTableHeader cabezera;
        cabezera = jTable1_datos.getTableHeader();
        Font fuente = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        //Font fuente = new Font("Cooper Black", 1, 10);
        //cabezera.setFont(fuente);
        cabezera.setFont(cabezera.getFont().deriveFont(Font.BOLD));
        
         TableColumnModel columnModel = jTable1_datos.getColumnModel();             
//       columnModel.getColumn(0).setPreferredWidth(1);        
        columnModel.getColumn(1).setPreferredWidth(110);
//        columnModel.getColumn(2).setPreferredWidth(75);
        columnModel.getColumn(3).setPreferredWidth(3);
        columnModel.getColumn(4).setPreferredWidth(48);
//        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(13);
        columnModel.getColumn(8).setPreferredWidth(28);
        
        jTable1_datos.getTableHeader().setResizingAllowed(false);
                        
        jLabel3_fecha.setText(fecha_sistema());
        jTextField1_nombre_buscar.requestFocus();        
        
        jLabel1_nombre.setVisible(false);
        jTextField1_nombre.setVisible(false);
        jLabel5_prestamos.setVisible(false);
        jTextField2_prestamos.setVisible(false);
        jLabel6_show.setVisible(false);
        jComboBox1_show.setVisible(false);        
        jLabel7_borrar_turno.setVisible(false);
        jTextField1_borrar_turno.setVisible(false);
        jLabel4_borrar_turno_motivo.setVisible(false);
        jRadioButton1_borrar_turno_si.setVisible(false);
        jRadioButton2_borrar_turno_no.setVisible(false);
        jLabel8_paga_multa.setVisible(false);
        jTextField1_paga_multa.setVisible(false);
        jLabel5_paga_multa_ejemplo.setVisible(false);
        jRadioButton1_paga_multa_si.setVisible(false);
        jRadioButton2_paga_multa_no.setVisible(false);
        jLabel9_debe_examenes.setVisible(false);
        jTextField1_examenes.setVisible(false);
        jLabel6_examenes_ejemplo.setVisible(false);
        jRadioButton1_debe_examen_si.setVisible(false);
        jRadioButton2__debe_examen_no.setVisible(false);
        jButton5_cargar_registro.setVisible(false);
        jButton1_actualizar.setVisible(false);
        jButton4_eliminar.setVisible(false);                
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
    
    //Metodo para obtener la fecha del registro
    private String fecha_registro() 
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
                            else
                            {
                                dia = 6;
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
    
    public void limpiar_campos()
    {
        jTextField1_nombre.requestFocus();
        jTextField1_nombre.setText("");        
        jTextField2_prestamos.setText("");        
        jTextField1_borrar_turno.setText("");
        jTextField1_borrar_turno.setVisible(false);
        jLabel4_borrar_turno_motivo.setVisible(false);
        jComboBox1_show.setSelectedIndex(0);
        jTextField1_paga_multa.setText("");
        jTextField1_paga_multa.setVisible(false);
        jLabel5_paga_multa_ejemplo.setVisible(false);
        jTextField1_examenes.setText("");
        jTextField1_examenes.setVisible(false);
        jLabel6_examenes_ejemplo.setVisible(false);        
        buttonGroup1_borrar_turno.clearSelection();
        buttonGroup2_paga_multa.clearSelection();
        buttonGroup3_debe_exam.clearSelection();        
    }
    
    //Metodo para saber que show ha hecho la chica y poderlo guardar en la BD
    public int tipo_shows_guardar() 
    {        
        int indice_combo = jComboBox1_show.getSelectedIndex();
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
    public void buscar_chica() throws SQLException
    {    
        String fecha_anterior = fecha_dias_antes();
        String fecha_actual = fecha_registro();
        String nombre_buscar = jTextField1_nombre_buscar.getText();
        int cant_chicas = 0;
        String fecha = "";
        String dia_semana = "";
        String nombre = "";
        int turnos = 0;
        String turno_borrado = "";
        String prestamos = "";
        int show = 0;
        String multa = "";
        String examenes = "";        
        int contador = 0;
        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1_datos.getModel();
        jTable1_datos.setModel(modelo);
        
        String consulta_SQL = ("SELECT *FROM personal WHERE nombre ='"+nombre_buscar+"' AND fecha_trabajo BETWEEN '"+fecha_anterior+"' AND '"+fecha_actual+"'");               
        Statement stm = enlace_1.createStatement();
        ResultSet rs = stm.executeQuery(consulta_SQL);                
        
        if (conex != null) 
        {                        
           
            while (rs.next()) 
            {
                id_registro  = rs.getInt(1);
                id_registros.add(id_registro);                
                cant_chicas = rs.getInt(2);
                cantidad_registradas.add(cant_chicas);
                fecha = rs.getString(3);
                fecha_registros.add(fecha);
                dia_semana = rs.getString(4);                
                dia_registros.add(dia_semana);                
                nombre = rs.getString(5);
                turnos = rs.getInt(6);                
                turno_borrado = rs.getString(7);
                prestamos = rs.getString(8);
                int aux_prestamos = Integer.parseInt(prestamos);
                show = rs.getInt(9);                
                String clase_show = tipo_shows_mostrar(show);
                multa = rs.getString(10);
                int aux_multa = Integer.parseInt(multa);
                examenes = rs.getString(11);  
                int aux_examenes = Integer.parseInt(examenes);
                                        
                modelo.addRow(new Object[]{cant_chicas, fecha+" "+dia_semana, nombre, turnos, turno_borrado, mi_formato.format(aux_prestamos), clase_show, mi_formato.format(aux_multa), mi_formato.format(aux_examenes)});
                
                jTextField1_nombre.requestFocus();
                jLabel1_nombre_buscar.setVisible(false);
                jLabel3_ejemplo_nombre_buscar.setVisible(false);
                jLabel1_nombre.setVisible(true);
                jTextField1_nombre.setVisible(true);
                jLabel5_prestamos.setVisible(true);
                jTextField2_prestamos.setVisible(true);
                jLabel6_show.setVisible(true);
                jComboBox1_show.setVisible(true);
                jLabel7_borrar_turno.setVisible(true);
                jTextField1_borrar_turno.setVisible(true);
                jLabel4_borrar_turno_motivo.setVisible(true);
                jRadioButton1_borrar_turno_si.setVisible(true);
                jRadioButton2_borrar_turno_no.setVisible(true);
                jLabel8_paga_multa.setVisible(true);
                jTextField1_paga_multa.setVisible(true);
                jLabel5_paga_multa_ejemplo.setVisible(true);
                jRadioButton1_paga_multa_si.setVisible(true);
                jRadioButton2_paga_multa_no.setVisible(true);
                jLabel9_debe_examenes.setVisible(true);
                jTextField1_examenes.setVisible(true);
                jLabel6_examenes_ejemplo.setVisible(true);
                jRadioButton1_debe_examen_si.setVisible(true);
                jRadioButton2__debe_examen_no.setVisible(true);
                jButton5_cargar_registro.setVisible(true);

                jButton1_actualizar.setVisible(false);
                jButton4_eliminar.setVisible(false);
                jButton1_buscar.setVisible(false);
                jLabel1_nombre_chica.setVisible(false);
                jTextField1_nombre_buscar.setVisible(false);
                jTextField1_fecha_buscar.setVisible(false);
                jLabel3_ejemplo_fecha_registro.setVisible(false);
                jTextField1_nombre.requestFocus();
            }            
            rs.close();           
        }
        else 
        {                
            JOptionPane.showMessageDialog(null, "Error NO se ha encontrado ningun registro desde hace una semana atras con nombre: " + nombre_buscar , "Registro de Personal", JOptionPane.INFORMATION_MESSAGE, icono);
        }        
    }       
    
    public void editar_chica(int fila_seleccionada) throws SQLException
    {                          
        String nombre = jTextField1_nombre.getText();        
        int turnos = 0;        
        String turno_borrado = jTextField1_borrar_turno.getText();
        String prestamos = jTextField2_prestamos.getText();
        int tipo_show = jComboBox1_show.getItemCount();
        String multas = jTextField1_paga_multa.getText();
        String examenes = jTextField1_examenes.getText();
        String show_especial = "";
        int indice_combo = jComboBox1_show.getSelectedIndex();
        int id = 0;        
        
        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                
        if (conex != null) 
        {   
            chicas_registradas = Integer.parseInt(jTable1_datos.getValueAt(fila_seleccionada, 0).toString());
            String fecha_registro = jTable1_datos.getValueAt(fila_seleccionada, 1).toString();           
            fecha_registros.add(fecha_registro);
            jTextField1_nombre.setText(jTable1_datos.getValueAt(fila_seleccionada, 2).toString());
            turnos = Integer.parseInt(jTable1_datos.getValueAt(fila_seleccionada, 3).toString());            
            turno_registros = turnos;
            
            jTextField1_borrar_turno.setText(jTable1_datos.getValueAt(fila_seleccionada, 4).toString());
            if (!jTextField1_borrar_turno.equals("")) 
            {
                jTextField1_borrar_turno.setVisible(true);
                jLabel4_borrar_turno_motivo.setVisible(true);
                jRadioButton1_borrar_turno_si.isSelected();
            } 
            else 
            {
                jTextField1_borrar_turno.setVisible(false);
                jLabel4_borrar_turno_motivo.setVisible(false);
                jRadioButton2_borrar_turno_no.isSelected();
            }
            
            String x = (jTable1_datos.getValueAt(fila_seleccionada, 5).toString());
            double y = Double.parseDouble(x);
            jTextField2_prestamos.setText(mi_formato_2.format(y * 1000));
            
            String aux_show = jTable1_datos.getValueAt(fila_seleccionada, 6).toString();            
            if (aux_show.equals("0")) 
            {                        
                jComboBox1_show.setSelectedIndex(0);
            }
            if (aux_show.equals("Individual")) 
            {                        
                jComboBox1_show.setSelectedIndex(1);
            }                    
            if (aux_show.equals("Ind/al y Grupo")) 
            {                        
                jComboBox1_show.setSelectedIndex(2);
            }
            if (aux_show.equals("Grupo")) 
            {                        
                jComboBox1_show.setSelectedIndex(3);
            }
            if (aux_show.equals("Especial")) 
            {
                jComboBox1_show.setSelectedIndex(4);
            }                                      
            
            String v = (jTable1_datos.getValueAt(fila_seleccionada, 7).toString());
            double w = Double.parseDouble(v);
            jTextField1_paga_multa.setText(mi_formato_2.format(w * 1000));                        
            if (!jTextField1_paga_multa.equals("")) 
            {
                jTextField1_paga_multa.setVisible(true);
                jLabel5_paga_multa_ejemplo.setVisible(true);
                jRadioButton1_paga_multa_si.isSelected();
            } 
            else 
            {
                jTextField1_paga_multa.setVisible(false);
                jLabel5_paga_multa_ejemplo.setVisible(false);
                jRadioButton2_paga_multa_no.isSelected();
            }
            
            String m = (jTable1_datos.getValueAt(fila_seleccionada, 8).toString());
            double n = Double.parseDouble(m);
            jTextField1_examenes.setText(mi_formato_2.format(n * 1000));            
            if (!jTextField1_examenes.equals("")) 
            {
                jTextField1_examenes.setVisible(true);
                jLabel6_examenes_ejemplo.setVisible(true);
                jRadioButton1_debe_examen_si.isSelected();
            } 
            else 
            {
                jTextField1_examenes.setVisible(false);
                jLabel6_examenes_ejemplo.setVisible(false);
                jRadioButton2__debe_examen_no.isSelected();
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Error NO se ha Modificado el Registro", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
        }
        JOptionPane.showMessageDialog(null, "Ahora puede Actualizar o Eliminar el registro de la Chica"
                + ", Si va a Eliminar un registro use los datos del Nombre y Fecha del Registro de la Tabla \n"
                + " ("+jTextField1_nombre.getText()+" y "+fecha_registros.get(fila_seleccionada)+")","Registro de Personal",JOptionPane.INFORMATION_MESSAGE,icono);                        
        jButton1_actualizar.setVisible(true);
        jButton4_eliminar.setVisible(true);
        jButton5_cargar_registro.setVisible(false); 
        
        aux_id = buscar_id_chica();
    }
    
    //Metodo para saber que show ha hecho la chica y poderlo guardar en la BD
    public String tipo_shows(int indice_combo) 
    {               
        int tipo_show = 0;
        String retorno_show = "";        

        if (indice_combo == 0) 
        {
            retorno_show = "0";
            tipo_show = 0;
        }
        if (indice_combo == 1) 
        {
            retorno_show = "Individual";
            tipo_show = 1;                        
        }
        if (indice_combo == 2) 
        {
            retorno_show = "Ind/al y Grupo";
            tipo_show = 2;                         
        }
        if (indice_combo == 3) 
        {
            retorno_show = "Grupo";
            tipo_show = 3;            
        }
        if (indice_combo == 4) 
        {    
            retorno_show = "Especial";
            tipo_show = 4;                        
        }
        return retorno_show;
    }
    
    //Metodo para buscar el id de la chica para poder actualizarla
    public int buscar_id_chica()
    {
        int id = 0;
        //String fecha_anterior = fecha_dias_antes();
        String fecha_actual = String.valueOf(fecha_registros.get(fila_seleccionada));
        String nombre = jTextField1_nombre.getText();
        int turnos = 0;        
        String consulta_SQL = "";
        Statement stm = null;
        ResultSet rs = null;
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                                                                
        if (conex != null) 
        {
            try 
            {
                consulta_SQL = ("SELECT Id FROM personal WHERE nombre ='" + nombre + "' AND fecha_trabajo = '"+fecha_actual+"'");                
                stm = conex.createStatement();                
                rs = stm.executeQuery(consulta_SQL);
                                                                                
                if (rs.last()) 
                {
                    id = rs.getInt(1);                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error, No hay un Id seleccionado", "Buscar Chica", JOptionPane.INFORMATION_MESSAGE, icono);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Buscar_chica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al Modificar en la Base de Datos:" + ex);
            }
        }                
        return id;
    }
    
    //Metodo para buscar el id del del ultimo registro ingresado
    public int buscar_ultimo_turno_chica_nuevo_nombre()
    {
        int id = 0;
        String fecha_anterior = fecha_dias_antes();
        String fecha_actual = fecha_registro();
        String nombre = jTextField1_nombre.getText();
        int turnos = 0;        
        String consulta_SQL = "";
        Statement stm = null;
        ResultSet rs = null;
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                                                                
        if (conex != null) 
        {
            try 
            {
                consulta_SQL = ("SELECT turnos FROM personal WHERE nombre ='" + nombre + "' AND fecha_trabajo BETWEEN '"+fecha_anterior+"' AND '"+fecha_actual+"'");                
                stm = conex.createStatement();                
                rs = stm.executeQuery(consulta_SQL);
                                                                                
                if (rs.last()) 
                {                    
                    turnos = rs.getInt(1);
                }
                else
                {
                    turnos = 0;                    
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Buscar_chica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al Modificar en la Base de Datos:" + ex);
            }
        }                
        return turnos;
    }    
    
    //Metodo para hacer cambios a un registro ingresado previamente
    public void actualizar_registro_chica()
    {               
        int id = aux_id;        
        String fecha_trabajo =  String.valueOf(fecha_registros.get(fila_seleccionada));         
        String nombre = jTextField1_nombre.getText();
        int turnos = buscar_ultimo_turno_chica_nuevo_nombre(); 
        if (turnos == 0) 
        {
            turnos = 1;            
        }
        
        String turno_borrado = jTextField1_borrar_turno.getText();
        String prestamos = jTextField2_prestamos.getText();
        int indice_show = jComboBox1_show.getSelectedIndex();
        String clase_show = tipo_shows(indice_show);
        String multas = jTextField1_paga_multa.getText();
        String examenes = jTextField1_examenes.getText();        
        int indice_combo = jComboBox1_show.getSelectedIndex();
        int cantidad_chicas_registradas = Integer.parseInt(jTable1_datos.getValueAt(fila_seleccionada, 0).toString()); 
                        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
        
        try 
        {                        
            if (multas.equals("")) 
            {
                multas = "0";
            }
            if (examenes.equals("")) 
            {
                examenes = "0";
            }                                        
            modelo_tabla = (DefaultTableModel) jTable1_datos.getModel();
            int a = modelo_tabla.getRowCount() -1;                
            if (fila_seleccionada != -1) 
            {
                //Arreglo de tipo String para poder mostrarlos los datos en la tabla
                String datos[] = new String[10];
                datos[0]= String.valueOf(cantidad_chicas_registradas);
                datos[1] = fecha_trabajo;                   
                datos[2] = nombre;
                datos[3] = String.valueOf(turnos);                    
                datos[4] = turno_borrado;
                                               
                double aux_prestamos = Double.valueOf(prestamos);
                String aux2_prestamos = mi_formato.format(aux_prestamos);
                datos[5] = aux2_prestamos;                                
                datos[6] = clase_show;
                
                double aux_multas = Double.valueOf(multas);
                String aux2_multas = mi_formato.format(aux_multas);
                datos[7] = aux2_multas;
                
                double aux_examenes = Double.valueOf(examenes);
                String aux2_examenes = mi_formato.format(aux_examenes);
                datos[8] = aux2_examenes;                
                                                                                           

                modelo_tabla.fireTableDataChanged();
                modelo_tabla.setValueAt(datos[0], fila_seleccionada, 0);   
                //modelo_tabla.setValueAt(datos[1], fila_seleccionada, 1);
                modelo_tabla.setValueAt(datos[2], fila_seleccionada, 2);
                modelo_tabla.setValueAt(datos[3], fila_seleccionada, 3);
                modelo_tabla.setValueAt(datos[4], fila_seleccionada, 4);
                modelo_tabla.setValueAt(datos[5], fila_seleccionada, 5);
                modelo_tabla.setValueAt(datos[6], fila_seleccionada, 6);
                modelo_tabla.setValueAt(datos[7], fila_seleccionada, 7);
                modelo_tabla.setValueAt(datos[8], fila_seleccionada, 8);

                jTable1_datos.setModel(modelo_tabla);
                jTable1_datos.setUpdateSelectionOnSort(true);
                
                //Object datos_1[] = {cantidad_chicas_registradas,fecha_trabajo+" "+dia_registros.get(fila_seleccionada), nombre,turno_actualizado, turno_borrado, mi_formato.format(aux_prestamos),clase_show ,multas,examenes};
                //modelo_tabla.addRow(datos_1);                                
            }

            PreparedStatement pps = conex.prepareStatement("UPDATE personal SET  chicas_registradas ='" + cantidad_chicas_registradas + "',fecha_trabajo='" + fecha_trabajo + "', dia_semana ='"+dia_registros.get(fila_seleccionada)+"', nombre= '" + nombre + "',turnos='" + turnos + "',turno_borrado='" + turno_borrado + "',prestamos='" + prestamos + "', shows='" + indice_show + "',multas='" + multas + "' ,examenes='" + examenes + "' WHERE Id=" + id);
            pps.executeUpdate();            
            JOptionPane.showMessageDialog(null, "Registro Actualizado Correctamente", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);                                               
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Buscar_chica.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Actualizár el registro en la Base de Datos:" + ex);
        }
        
        jTextField1_nombre.requestFocus();        
        jTextField1_nombre.setText("");        
        jTextField2_prestamos.setText("");        
        jComboBox1_show.setSelectedIndex(0);        
        jLabel6_show.setVisible(true);
        jTextField1_borrar_turno.setVisible(false);
        jLabel4_borrar_turno_motivo.setVisible(false);        
        jLabel7_borrar_turno.setVisible(true);
        jTextField1_paga_multa.setText("");
        jTextField1_paga_multa.setVisible(false);
        jLabel8_paga_multa.setVisible(false);        
        jLabel9_debe_examenes.setVisible(true);
        jTextField1_examenes.setText("");
        jTextField1_examenes.setVisible(false);
        jLabel6_examenes_ejemplo.setVisible(false);
        buttonGroup1_borrar_turno.clearSelection();
        buttonGroup2_paga_multa.clearSelection();
        buttonGroup3_debe_exam.clearSelection(); 
        
        jButton1_actualizar.setVisible(true);
        jButton4_eliminar.setVisible(true);
                                       
    }
        
                
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_tabla_1 = new javax.swing.JTable();
        buttonGroup1_borrar_turno = new javax.swing.ButtonGroup();
        buttonGroup2_paga_multa = new javax.swing.ButtonGroup();
        buttonGroup3_debe_exam = new javax.swing.ButtonGroup();
        jLabel_titulo = new javax.swing.JLabel();
        jButton2_salir = new javax.swing.JButton();
        jLabel4_hora = new javax.swing.JLabel();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel1_nombre_chica = new javax.swing.JLabel();
        jTextField1_nombre_buscar = new javax.swing.JTextField();
        jLabel3_ejemplo_fecha_registro = new javax.swing.JLabel();
        jButton5_cargar_registro = new javax.swing.JButton();
        jButton4_eliminar = new javax.swing.JButton();
        jTextField1_nombre = new javax.swing.JTextField();
        jLabel1_nombre = new javax.swing.JLabel();
        jTextField2_prestamos = new javax.swing.JTextField();
        jLabel5_prestamos = new javax.swing.JLabel();
        jComboBox1_show = new javax.swing.JComboBox<>();
        jLabel6_show = new javax.swing.JLabel();
        jTextField1_borrar_turno = new javax.swing.JTextField();
        jRadioButton1_borrar_turno_si = new javax.swing.JRadioButton();
        jRadioButton2_borrar_turno_no = new javax.swing.JRadioButton();
        jLabel7_borrar_turno = new javax.swing.JLabel();
        jLabel4_borrar_turno_motivo = new javax.swing.JLabel();
        jTextField1_paga_multa = new javax.swing.JTextField();
        jRadioButton1_paga_multa_si = new javax.swing.JRadioButton();
        jRadioButton2_paga_multa_no = new javax.swing.JRadioButton();
        jLabel8_paga_multa = new javax.swing.JLabel();
        jLabel5_paga_multa_ejemplo = new javax.swing.JLabel();
        jTextField1_examenes = new javax.swing.JTextField();
        jLabel6_examenes_ejemplo = new javax.swing.JLabel();
        jRadioButton2__debe_examen_no = new javax.swing.JRadioButton();
        jRadioButton1_debe_examen_si = new javax.swing.JRadioButton();
        jLabel9_debe_examenes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1_datos = new javax.swing.JTable();
        jButton1_actualizar = new javax.swing.JButton();
        jTextField1_fecha_buscar = new javax.swing.JTextField();
        jLabel3_ejemplo_nombre_buscar = new javax.swing.JLabel();
        jLabel1_nombre_buscar = new javax.swing.JLabel();
        jButton1_buscar = new javax.swing.JButton();
        jLabel1_fondo = new javax.swing.JLabel();

        jScrollPane1.setAutoscrolls(true);

        jTable1_tabla_1.setBackground(new java.awt.Color(204, 245, 208));
        jTable1_tabla_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha", "Nombre", "Turnos", "Turno Borrado", "Prestamos", "Shows", "Multas debe", "Examenes debe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1_tabla_1.setEnabled(false);
        jTable1_tabla_1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1_tabla_1.setRowHeight(12);
        jTable1_tabla_1.setRowMargin(3);
        jScrollPane1.setViewportView(jTable1_tabla_1);
        if (jTable1_tabla_1.getColumnModel().getColumnCount() > 0) {
            jTable1_tabla_1.getColumnModel().getColumn(0).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(0).setPreferredWidth(4);
            jTable1_tabla_1.getColumnModel().getColumn(1).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(2).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(3).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1_tabla_1.getColumnModel().getColumn(4).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(5).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(5).setPreferredWidth(44);
            jTable1_tabla_1.getColumnModel().getColumn(6).setResizable(false);
            jTable1_tabla_1.getColumnModel().getColumn(8).setResizable(false);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1050, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        jLabel_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, 360, -1));

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 90, 30));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 190, 20));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 190, 20));

        jLabel1_nombre_chica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1_nombre_chica.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1_nombre_chica.setText("Fecha de registro:");
        getContentPane().add(jLabel1_nombre_chica, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 40, 130, -1));

        jTextField1_nombre_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_nombre_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nombre_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_nombre_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, -1));

        jLabel3_ejemplo_fecha_registro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3_ejemplo_fecha_registro.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_ejemplo_fecha_registro.setText("Ejemplo: 2018-12-20");
        getContentPane().add(jLabel3_ejemplo_fecha_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 90, 130, -1));

        jButton5_cargar_registro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5_cargar_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jButton5_cargar_registro.setText("Editar Registro");
        jButton5_cargar_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_cargar_registroActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5_cargar_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 170, 25));

        jButton4_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar2.png"))); // NOI18N
        jButton4_eliminar.setText("Eliminar");
        jButton4_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 123, 25));

        jTextField1_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nombreKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, -1));

        jLabel1_nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1_nombre.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1_nombre.setText("Nombre:");
        getContentPane().add(jLabel1_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, -1));

        jTextField2_prestamos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2_prestamos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2_prestamosKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField2_prestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, -1));

        jLabel5_prestamos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5_prestamos.setForeground(new java.awt.Color(102, 255, 255));
        jLabel5_prestamos.setText("Prestamos:");
        getContentPane().add(jLabel5_prestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jComboBox1_show.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1_show.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show's", "Individual", "Individual y grupo", "Grupo", "Especial" }));
        getContentPane().add(jComboBox1_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, -1));

        jLabel6_show.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6_show.setForeground(new java.awt.Color(102, 255, 255));
        jLabel6_show.setText("Show's:");
        getContentPane().add(jLabel6_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 60, -1));

        jTextField1_borrar_turno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_borrar_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 80, -1));

        buttonGroup1_borrar_turno.add(jRadioButton1_borrar_turno_si);
        jRadioButton1_borrar_turno_si.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1_borrar_turno_si.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton1_borrar_turno_si.setText("Si");
        jRadioButton1_borrar_turno_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_borrar_turno_siActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_borrar_turno_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 35, -1));

        buttonGroup1_borrar_turno.add(jRadioButton2_borrar_turno_no);
        jRadioButton2_borrar_turno_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2_borrar_turno_no.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton2_borrar_turno_no.setText("No");
        jRadioButton2_borrar_turno_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_borrar_turno_noActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_borrar_turno_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 38, -1));

        jLabel7_borrar_turno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7_borrar_turno.setForeground(new java.awt.Color(102, 255, 255));
        jLabel7_borrar_turno.setText("Borrar turno:");
        getContentPane().add(jLabel7_borrar_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel4_borrar_turno_motivo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4_borrar_turno_motivo.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4_borrar_turno_motivo.setText(" (Motivo)");
        jLabel4_borrar_turno_motivo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel4_borrar_turno_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        jTextField1_paga_multa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_paga_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 80, -1));

        buttonGroup2_paga_multa.add(jRadioButton1_paga_multa_si);
        jRadioButton1_paga_multa_si.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1_paga_multa_si.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton1_paga_multa_si.setText("Si");
        jRadioButton1_paga_multa_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_paga_multa_siActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_paga_multa_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        buttonGroup2_paga_multa.add(jRadioButton2_paga_multa_no);
        jRadioButton2_paga_multa_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2_paga_multa_no.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton2_paga_multa_no.setText("No");
        jRadioButton2_paga_multa_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_paga_multa_noActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_paga_multa_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel8_paga_multa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8_paga_multa.setForeground(new java.awt.Color(102, 255, 255));
        jLabel8_paga_multa.setText("Paga multa:");
        getContentPane().add(jLabel8_paga_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel5_paga_multa_ejemplo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5_paga_multa_ejemplo.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5_paga_multa_ejemplo.setText("Ejemplo: 20000");
        getContentPane().add(jLabel5_paga_multa_ejemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        jTextField1_examenes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 80, -1));

        jLabel6_examenes_ejemplo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6_examenes_ejemplo.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6_examenes_ejemplo.setText("Ejemplo: 20000");
        getContentPane().add(jLabel6_examenes_ejemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        buttonGroup3_debe_exam.add(jRadioButton2__debe_examen_no);
        jRadioButton2__debe_examen_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2__debe_examen_no.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton2__debe_examen_no.setText("No");
        jRadioButton2__debe_examen_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2__debe_examen_noActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2__debe_examen_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        buttonGroup3_debe_exam.add(jRadioButton1_debe_examen_si);
        jRadioButton1_debe_examen_si.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1_debe_examen_si.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton1_debe_examen_si.setText("Si");
        jRadioButton1_debe_examen_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_debe_examen_siActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_debe_examen_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jLabel9_debe_examenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9_debe_examenes.setForeground(new java.awt.Color(102, 255, 255));
        jLabel9_debe_examenes.setText("Debe exam:");
        getContentPane().add(jLabel9_debe_examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable1_datos.setBackground(new java.awt.Color(204, 255, 208));
        jTable1_datos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable1_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha", "Nombre", "Turno", "Turno Borrado", "Prestamos", "Show's", "Multas", "Examenes"
            }
        ));
        jTable1_datos.setRowMargin(3);
        jTable1_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_datosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1_datos);
        if (jTable1_datos.getColumnModel().getColumnCount() > 0) {
            jTable1_datos.getColumnModel().getColumn(0).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1_datos.getColumnModel().getColumn(1).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTable1_datos.getColumnModel().getColumn(2).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1_datos.getColumnModel().getColumn(3).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(4).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(5).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(5).setPreferredWidth(30);
            jTable1_datos.getColumnModel().getColumn(6).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(7).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(7).setPreferredWidth(18);
            jTable1_datos.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 790, 170));

        jButton1_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar_3.png"))); // NOI18N
        jButton1_actualizar.setText("Actualizar");
        jButton1_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 123, 25));

        jTextField1_fecha_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_fecha_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_fecha_buscarKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_fecha_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 130, -1));

        jLabel3_ejemplo_nombre_buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3_ejemplo_nombre_buscar.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_ejemplo_nombre_buscar.setText("Ejemplo: Ana");
        getContentPane().add(jLabel3_ejemplo_nombre_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

        jLabel1_nombre_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1_nombre_buscar.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1_nombre_buscar.setText("Nombre:");
        getContentPane().add(jLabel1_nombre_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 70, -1));

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
        getContentPane().add(jButton1_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 105, 25));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        jLabel1_fondo.setPreferredSize(new java.awt.Dimension(1100, 500));
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jTextField1_nombre_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nombre_buscarKeyPressed
        // TODO add your handling code here:        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_fecha_buscar.requestFocus();
            jTextField1_fecha_buscar.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_nombre_buscarKeyPressed

    private void jButton5_cargar_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_cargar_registroActionPerformed
        
        fila_seleccionada = jTable1_datos.getSelectedRow();        

        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
        
        if (fila_seleccionada >= 0) 
        {                       
            try 
            {
                editar_chica(fila_seleccionada);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Buscar_chica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al cargar la edicion", "Buscar chica", JOptionPane.INFORMATION_MESSAGE, icono);
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Seleccione la Fila de la tabla que quiere modificar por favor", "Buscar chica", JOptionPane.INFORMATION_MESSAGE, icono);
        }       
    }//GEN-LAST:event_jButton5_cargar_registroActionPerformed

    private void jButton4_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_eliminarActionPerformed
          
            Eliminar_chica ventana_eliminar = new Eliminar_chica();
            ventana_eliminar.setVisible(true);            
            setExtendedState(JFrame.CROSSHAIR_CURSOR);                                                         
    }//GEN-LAST:event_jButton4_eliminarActionPerformed

    private void jTextField1_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nombreKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jTextField2_prestamos.requestFocus();
        }

    }//GEN-LAST:event_jTextField1_nombreKeyPressed

    private void jTextField2_prestamosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2_prestamosKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField2_prestamosKeyPressed

    private void jRadioButton1_borrar_turno_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_borrar_turno_siActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1_borrar_turno_si.isSelected() == true)
        {
            jTextField1_borrar_turno.setVisible(true);
            jTextField1_borrar_turno.requestFocus();
            jLabel4_borrar_turno_motivo.setVisible(true);
        }
        else
        {
            jTextField1_borrar_turno.setVisible(false);
            jLabel4_borrar_turno_motivo.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_borrar_turno_siActionPerformed

    private void jRadioButton2_borrar_turno_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_borrar_turno_noActionPerformed
        // TODO add your handling code here:

        jTextField1_borrar_turno.setVisible(false);
        jLabel4_borrar_turno_motivo.setVisible(false);
    }//GEN-LAST:event_jRadioButton2_borrar_turno_noActionPerformed

    private void jRadioButton1_paga_multa_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_paga_multa_siActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1_paga_multa_si.isSelected() == true)
        {
            jTextField1_paga_multa.setVisible(true);
            jTextField1_paga_multa.requestFocus();
            jLabel5_paga_multa_ejemplo.setVisible(true);
        }
        else
        {
            jTextField1_paga_multa.setVisible(false);
            jLabel5_paga_multa_ejemplo.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_paga_multa_siActionPerformed

    private void jRadioButton2_paga_multa_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_paga_multa_noActionPerformed
        // TODO add your handling code here:
        jTextField1_paga_multa.setVisible(false);
        jLabel5_paga_multa_ejemplo.setVisible(false);
    }//GEN-LAST:event_jRadioButton2_paga_multa_noActionPerformed

    private void jRadioButton2__debe_examen_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2__debe_examen_noActionPerformed
        // TODO add your handling code here:
        jTextField1_examenes.setVisible(false);
        jLabel6_examenes_ejemplo.setVisible(false);
    }//GEN-LAST:event_jRadioButton2__debe_examen_noActionPerformed

    private void jRadioButton1_debe_examen_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_debe_examen_siActionPerformed
        // TODO add your handling code here:

        if (jRadioButton1_debe_examen_si.isSelected() == true)
        {
            jTextField1_examenes.setVisible(true);
            jTextField1_examenes.requestFocus();
            jLabel6_examenes_ejemplo.setVisible(true);
        }
        else
        {
            jTextField1_examenes.setVisible(false);
            jLabel6_examenes_ejemplo.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_debe_examen_siActionPerformed

    private void jButton1_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_actualizarActionPerformed
        // TODO add your handling code here:         
        //int turno_actualizado = Integer.parseInt(jTable1_datos.getValueAt(fila_seleccionada, 3).toString());        
        String evento =  evt.getActionCommand();        
        ImageIcon icono = new ImageIcon("src/Imagenes/buscar.png");
        
        if (jTextField1_nombre.getText().equals("")
            || jTextField2_prestamos.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Error en la Actualizarción, "
                + "Intente revisar que el campo del nombre no este vacio "
                + "\n ó si la chica no tiene prestamos escriba Cero (0)",
                "Buscar Personal", JOptionPane.INFORMATION_MESSAGE,icono);
            jTextField1_nombre.requestFocus();
        }
        else 
        {
            actualizar_registro_chica();            
        }        
    }//GEN-LAST:event_jButton1_actualizarActionPerformed

    private void jTextField1_fecha_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_fecha_buscarKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jButton1_buscar.requestFocus();
            jButton1_buscar.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_fecha_buscarKeyPressed

    private void jButton1_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_buscarActionPerformed
        // TODO add your handling code here:
        
        String nombre = jTextField1_nombre_buscar.getText();
        String fecha = jTextField1_fecha_buscar.getText();
        ImageIcon icono = new ImageIcon("src/Imagenes/buscar.png");
        if (nombre.equals("")) 
        {
            if (fecha.equals("")) 
            {                                
                JOptionPane.showMessageDialog(null, "Error en la Busqueda, "
                        + "Intente revisar que los campos del nombre y la fecha no esten vacios ó que la fecha de registro sea la correcta. ",
                        "Buscar Personal", JOptionPane.INFORMATION_MESSAGE, icono);
                jTextField1_nombre_buscar.requestFocus();
            }
            else
            {                
                JOptionPane.showMessageDialog(null, "Error en la Busqueda, "
                        + "Intente revisar que el campo del nombre no este vacio.",
                        "Buscar Personal", JOptionPane.INFORMATION_MESSAGE, icono);
                jTextField1_nombre_buscar.requestFocus();
            }                        
        }
        else
        {
            if (!nombre.equals("")) 
            {
                if (!fecha.equals("")) 
                {
                    try 
                    {
                        buscar_chica();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(Buscar_chica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {                    
                    JOptionPane.showMessageDialog(null, "Error en la Busqueda, "
                        + "Intente revisar que el campo de la fecha no este vacio o la fecha ingresada sea la correcta en su formato(aaaa-mm-dd).",
                        "Buscar Personal", JOptionPane.INFORMATION_MESSAGE, icono);
                jTextField1_nombre_buscar.requestFocus();
                }                                
            }                         
        }
    }//GEN-LAST:event_jButton1_buscarActionPerformed

    private void jButton1_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_buscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.jButton1_buscar.doClick();
        }        
    }//GEN-LAST:event_jButton1_buscarKeyPressed

    private void jTable1_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_datosMouseClicked
        
        for (int c = 0; c < jTable1_datos.getColumnCount(); c++)
        {
            Class<?> col_class = jTable1_datos.getColumnClass(c);
            jTable1_datos.setDefaultEditor(col_class, null);        // remove editor
        }
    }//GEN-LAST:event_jTable1_datosMouseClicked

    
    public static void main(String args[]) {
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_chica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1_borrar_turno;
    private javax.swing.ButtonGroup buttonGroup2_paga_multa;
    public javax.swing.ButtonGroup buttonGroup3_debe_exam;
    private javax.swing.JButton jButton1_actualizar;
    private javax.swing.JButton jButton1_buscar;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JButton jButton4_eliminar;
    private javax.swing.JButton jButton5_cargar_registro;
    private javax.swing.JComboBox<String> jComboBox1_show;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel1_nombre;
    private javax.swing.JLabel jLabel1_nombre_buscar;
    private javax.swing.JLabel jLabel1_nombre_chica;
    private javax.swing.JLabel jLabel3_ejemplo_fecha_registro;
    private javax.swing.JLabel jLabel3_ejemplo_nombre_buscar;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4_borrar_turno_motivo;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel5_paga_multa_ejemplo;
    private javax.swing.JLabel jLabel5_prestamos;
    private javax.swing.JLabel jLabel6_examenes_ejemplo;
    private javax.swing.JLabel jLabel6_show;
    private javax.swing.JLabel jLabel7_borrar_turno;
    private javax.swing.JLabel jLabel8_paga_multa;
    private javax.swing.JLabel jLabel9_debe_examenes;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JRadioButton jRadioButton1_borrar_turno_si;
    private javax.swing.JRadioButton jRadioButton1_debe_examen_si;
    private javax.swing.JRadioButton jRadioButton1_paga_multa_si;
    private javax.swing.JRadioButton jRadioButton2__debe_examen_no;
    private javax.swing.JRadioButton jRadioButton2_borrar_turno_no;
    private javax.swing.JRadioButton jRadioButton2_paga_multa_no;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1_datos;
    private javax.swing.JTable jTable1_tabla_1;
    private javax.swing.JTextField jTextField1_borrar_turno;
    private javax.swing.JTextField jTextField1_examenes;
    private javax.swing.JTextField jTextField1_fecha_buscar;
    private javax.swing.JTextField jTextField1_nombre;
    private javax.swing.JTextField jTextField1_nombre_buscar;
    private javax.swing.JTextField jTextField1_paga_multa;
    private javax.swing.JTextField jTextField2_prestamos;
    // End of variables declaration//GEN-END:variables
}
