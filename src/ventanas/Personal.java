package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.ButtonModel;
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
public class Personal extends javax.swing.JFrame 
{

    //Atributos y variables
    Inventario ventana_inventario = new Inventario();
    DecimalFormat mi_formato = new DecimalFormat("###,###.##");
    DecimalFormat mi_formato_2 = new DecimalFormat("#####");
    
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection enlace_1 = conexion_1.conectar();
    java.sql.Connection conex = conexion_1.conectar();
    Connection conector = null;        
    
    DefaultTableModel modelo_de_la_tabla;
    String [][]matriz = {};
    String titulos[]={"N°","Fecha","Nombre","Turnos","Turno Borrado","Prestamos","Show´s","Multas","Examenes"};
    
    int chicas_registradas = 0;     
    String fecha_actualizar = "";
    int turno_actualizado = 0;
    int fila_seleccionada = 0;
    int columna_seleccionada = 0;
    int aux_id = 0;
    boolean tiene_turno = false;
    
    public Personal() 
    {
        initComponents();
        
        setLocationRelativeTo(null);        
        setTitle("Resgistro de Personal");
        
        modelo_de_la_tabla = new DefaultTableModel(matriz, titulos);
        jTable1_datos.setModel(modelo_de_la_tabla);
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
        columnModel.getColumn(3).setPreferredWidth(6);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(35);
        columnModel.getColumn(6).setPreferredWidth(60);
        columnModel.getColumn(7).setPreferredWidth(18);
        columnModel.getColumn(8).setPreferredWidth(33);
        jTable1_datos.getTableHeader().setResizingAllowed(false);
        
        jTextField1_nombre.requestFocus();                
        jTextField1_borrar_turno.setVisible(false);
        jTextField1_paga_multa.setVisible(false);
        jTextField1_examenes.setVisible(false);                        
        jLabel4_borrar_turno_motivo.setVisible(false);
        jLabel5_paga_multa.setVisible(false);
        jLabel6_examenes_ejemplo.setVisible(false);
        
        jButton1_actualizar.setVisible(true);
        jButton1_buscar_chica.setVisible(true);
                
    }

    //Metodos        
            
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
    
     //Metodo para saber los dias de la semana y poder saber desde donde se debe buscar el turno
    public String dias_de_la_semana_mostrar()
    {    
        Calendar now = Calendar.getInstance();        
        String dia_semana = "";
        
        String[] Arreglo_dias = new String[] //Array con los dias de la semana 
        {
            "Sabado",
            "Domingo",
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes"};
        
        dia_semana = (Arreglo_dias[now.get(Calendar.DAY_OF_WEEK) - 1]);        
        return dia_semana;        
    }
        
    //Metodo para mostrar en el Jtable el show que ha hecho la chica
    public int tipo_shows_guardar() 
    {        
        int indice_combo = jComboBox1_show.getSelectedIndex();
        int tipo_show = 0;               

        if (indice_combo == 0) 
        {            
            tipo_show = 0;
        }
        if (indice_combo == 1) 
        {            
            tipo_show = 15000;
        }
        if (indice_combo == 2) 
        {
            tipo_show = 25000;
        }
        if (indice_combo == 3) 
        {
            tipo_show = 10000;
        }
        if (indice_combo == 4) 
        {                                        
            tipo_show = 4;
        }
        return tipo_show;
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
    
    //Metodo para limpiar todos los campos
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
        jLabel5_paga_multa.setVisible(false);
        jTextField1_examenes.setText("");
        jTextField1_examenes.setVisible(false);
        jLabel6_examenes_ejemplo.setVisible(false); 
        
        buttonGroup1_borrar_turno.remove(jRadioButton1_borrar_turno_si);
        buttonGroup1_borrar_turno.remove(jRadioButton2_borrar_turno_no);
        buttonGroup1_paga_multa.remove(jRadioButton1_paga_multa_si);
        buttonGroup1_paga_multa.remove(jRadioButton2_paga_multa_no);
        buttonGroup1_debe_examen.remove(jRadioButton1_debe_examen_si);
        buttonGroup1_debe_examen.remove(jRadioButton2__debe_examen_no);
        
        jRadioButton1_borrar_turno_si.setSelected(false);
        jRadioButton2_borrar_turno_no.setSelected(false);
        jRadioButton1_paga_multa_si.setSelected(false);
        jRadioButton2_paga_multa_no.setSelected(false);
        jRadioButton1_debe_examen_si.setSelected(false);
        jRadioButton2__debe_examen_no.setSelected(false);
        
        buttonGroup1_borrar_turno.add(jRadioButton1_borrar_turno_si);
        buttonGroup1_borrar_turno.add(jRadioButton2_borrar_turno_no);
        buttonGroup1_paga_multa.add(jRadioButton1_borrar_turno_si);
        buttonGroup1_paga_multa.add(jRadioButton2_borrar_turno_no);
        buttonGroup1_debe_examen.add(jRadioButton1_borrar_turno_si);
        buttonGroup1_debe_examen.add(jRadioButton2_borrar_turno_no);        
        
        buttonGroup1_borrar_turno.clearSelection();
        buttonGroup1_paga_multa.clearSelection();        
        buttonGroup1_debe_examen.clearSelection();
    }
    //Metodo para guardar en la BD por cada fecha cuantas chicas se han registrado
    public int cantidad_chicas_dia() 
    {
        chicas_registradas = chicas_registradas+1;         
        return chicas_registradas;        
    }
    
    //Metodo para generar los turnos de las chicas por cada dia laborado
    public int turnos_chicas(java.awt.event.ActionEvent evt) throws SQLException 
    {
        int cantidad_chicas_resgistradas = 0;
        String fecha_actual = fecha_registro();
        String fecha_anterior = fecha_dias_antes();
        String dia_semana = dias_de_la_semana_mostrar();
        String nombre = jTextField1_nombre.getText();
        int turnos = 0;        
        String turno_borrado = jTextField1_borrar_turno.getText();
        if (turno_borrado.equals("")||turno_borrado.equals(" ")) 
        {
            turno_borrado = "0";            
        }
        String prestamos = jTextField2_prestamos.getText();        
        int tipo_show = 0;
        int indice_show = jComboBox1_show.getSelectedIndex();
        String clase_show = tipo_shows(indice_show);  
        if (clase_show.equals("0")) 
        {
            tipo_show = 0;
        }
        if (clase_show.equals("Individual")) 
        {            
            tipo_show = 1;
        }
        if (clase_show.equals("Ind/al y Grupo")) 
        {
            tipo_show = 2;            
        }
        if (clase_show.equals("Grupo")) 
        {           
            tipo_show = 3;
        }        
        if (clase_show.equals("Especial")) 
        {                                                                
            tipo_show = 4;
        }
        
        String multas = jTextField1_paga_multa.getText();
        if (multas.equals("")) 
        {
            multas = "0";
        }
        String examenes = jTextField1_examenes.getText();
        if (examenes.equals("")) 
        {
            examenes = "0";
        }
        String consulta_SQL = "";

        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");

        consulta_SQL = ("SELECT * FROM `personal` WHERE nombre = '" + nombre + "' AND fecha_trabajo BETWEEN '" + fecha_anterior + "' AND '" + fecha_actual + "'");                
        Statement stmt;
        stmt = conex.prepareStatement(consulta_SQL);
        ResultSet rs = stmt.executeQuery(consulta_SQL);

        if (conex != null) 
        {
            if (rs.last()) 
            {
                if (rs.getString(5).equals(nombre) && rs.getString(3).equals(fecha_actual)) 
                {
                    JOptionPane.showMessageDialog(null, "<html><h4>Error, Ese nombre ya se encuentran registrado en el dia hoy, verifique que su nombre este bien escrito</h4></html>", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
                    limpiar_campos();
                } 
                else 
                {                                        
                    turnos = rs.getInt(6);                    
                    turnos = turnos + 1;
                    cantidad_chicas_resgistradas = cantidad_chicas_dia();
                    guardar_registro_chica(cantidad_chicas_resgistradas, fecha_actual,dia_semana, nombre, turnos, turno_borrado, prestamos, tipo_show, multas, examenes);
                    limpiar_campos();
                }
            } 
            else 
            {
                turnos = 1;                
                cantidad_chicas_resgistradas = cantidad_chicas_dia();
                guardar_registro_chica(cantidad_chicas_resgistradas, fecha_actual,dia_semana, nombre, turnos, turno_borrado, prestamos, tipo_show, multas, examenes);                                               
                limpiar_campos();                
            }            
            rs.close();
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Error NO hay conexión con la BD", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
        }
        return turnos;
    }    
            
    //Metodo para guardar el registro de cada chica en la BD   
    protected void guardar_registro_chica(int cantidad_chicas_registradas, String fecha_actual, String dia_semana, String nombre, int turnos, String turno_borrado,String prestamos, int tipo_show, String multas, String examenes ) throws SQLException 
    {        
        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                    
        if (conex != null) 
        {
            try 
            {                
                PreparedStatement pps = conex.prepareStatement("INSERT INTO `personal`(`Id`, `chicas_registradas`, `fecha_trabajo`, `dia_semana`,`nombre`, `turnos`, `turno_borrado`, `prestamos`, `shows`, `multas`, `examenes`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                pps.setInt(1, 0);
                pps.setInt(2, cantidad_chicas_registradas);                
                pps.setString(3, fecha_actual);
                pps.setString(4, dia_semana);
                pps.setString(5, nombre);
                pps.setInt(6, turnos);                
                pps.setString(7, turno_borrado);
                pps.setString(8, prestamos);
                pps.setInt(9, tipo_show);                
                pps.setString(10, multas);
                pps.setString(11, examenes);

                pps.executeUpdate();                                

                registrar_chicas(cantidad_chicas_registradas, fecha_actual, dia_semana, nombre, turnos, turno_borrado, prestamos, tipo_show, multas, examenes);                
                JOptionPane.showMessageDialog(null, "<html><h4>Registro guardado Correctamente<h4></html>", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
            }
            catch (SQLException ex) 
            {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar en la Base de Datos:" + ex);
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Error NO se ha Guardado el Registro", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
        }
        
        limpiar_campos();
    }
    
    //Metodo para registrar los datos de las chicas en la tabla
    public void registrar_chicas( int cantidad_chicas_registradas, String fecha_actual, String dia_semana, String nombre, int turnos, String turno_borrado, String prestamos, int tipo_show, String multas, String examenes)
    {                      
        int aux_prestamos = Integer.valueOf(prestamos);
        int aux_multas = Integer.valueOf(multas);
        int aux_examenes = Integer.valueOf(examenes);
        String clase_show = tipo_shows(tipo_show);
                        
        Object datos[] ={cantidad_chicas_registradas, fecha_actual+"  "+dia_semana, nombre, turnos, turno_borrado, mi_formato.format(aux_prestamos),clase_show, mi_formato.format(aux_multas), mi_formato.format(aux_examenes)};
        modelo_de_la_tabla.addRow(datos);
        jTable1_datos.scrollRectToVisible ( jTable1_datos.getCellRect (modelo_de_la_tabla.getRowCount()+2, 0, true));        
        limpiar_campos();
    }
    
    //Metodo para mostrar el registro de las chicas de alguna fecha atras a la actual (Historial de registros)
    public void mostrar_resgistro_diario_chicas(String fecha_buscar, ActionEvent evt , String evento) throws SQLException
    {     
        Historial_chicas_registradas ventana_historial_chicas = new Historial_chicas_registradas();
        ventana_historial_chicas.setVisible(true);
        ventana_historial_chicas.mostrar_resgistro_diario_chicas(fecha_buscar);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);        
    }
    
    public void editar_chica(int fila_seleccionada) throws SQLException
    {                                  
        String nombre = jTextField1_nombre.getText();        
        String prestamos = jTextField2_prestamos.getText();
        int tipo_show = jComboBox1_show.getItemCount();
        String turno_borrado = jTextField1_borrar_turno.getText();                
        String multas = jTextField1_paga_multa.getText();
        String examenes = jTextField1_examenes.getText();        
        int indice_combo = jComboBox1_show.getSelectedIndex();
        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
                
        if (conex != null) 
        {                        
            jTextField1_nombre.setText(jTable1_datos.getValueAt(fila_seleccionada, 2).toString());
            jTextField1_borrar_turno.setText(jTable1_datos.getValueAt(fila_seleccionada, 4).toString());
            if (!jTextField1_borrar_turno.equals("")) 
            {
                jTextField1_borrar_turno.setVisible(true);
                jLabel4_borrar_turno_motivo.setVisible(true);                
                jRadioButton1_borrar_turno_si.setVisible(true);
            } 
            else 
            {
                jTextField1_borrar_turno.setVisible(false);
                jLabel4_borrar_turno_motivo.setVisible(false);
                jRadioButton1_borrar_turno_si.setSelected(true);

            }
            
            String x = (jTable1_datos.getValueAt(fila_seleccionada, 5).toString());
            double y = Double.parseDouble(x);
            jTextField2_prestamos.setText(mi_formato_2.format(y * 1000));
                                                
            String aux = jTable1_datos.getValueAt(fila_seleccionada, 6).toString();            
            if (aux.equals("0")) 
            {                        
                jComboBox1_show.setSelectedIndex(0);
            }
            if (aux.equals("Individual")) 
            {                        
                jComboBox1_show.setSelectedIndex(1);
            }                    
            if (aux.equals("Ind/al y Grupo")) 
            {                        
                jComboBox1_show.setSelectedIndex(2);
            }
            if (aux.equals("Grupo")) 
            {                        
                jComboBox1_show.setSelectedIndex(3);
            }
            if (aux.equals("Especial")) 
            {
                jComboBox1_show.setSelectedIndex(4);
            }         
            
            String m = (jTable1_datos.getValueAt(fila_seleccionada, 7).toString());
            double n = Double.parseDouble(m);
            jTextField1_paga_multa.setText(mi_formato_2.format(n * 1000));
            
            if (!jTextField1_paga_multa.equals("")) 
            {
                jTextField1_paga_multa.setVisible(true);
                jLabel5_paga_multa.setVisible(true);
                jRadioButton1_paga_multa_si.isSelected();
            } 
            else 
            {
                jTextField1_paga_multa.setVisible(false);
                jLabel5_paga_multa.setVisible(false);
                jRadioButton2_paga_multa_no.isSelected();
            }
            
            String e = (jTable1_datos.getValueAt(fila_seleccionada, 8).toString());
            double ex = Double.parseDouble(e);
            jTextField1_examenes.setText(mi_formato_2.format(ex * 1000));
            
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
        JOptionPane.showMessageDialog(null, "<html><h4>Ahora puede Actualizar el registro de la Chica</h4></html>","Registro de Personal",JOptionPane.INFORMATION_MESSAGE,icono);
        jButton1_registrar.setVisible(false);
        jButton1_buscar_chica.setVisible(false);        
        jButton1_actualizar.setVisible(true);
        jButton5_editar.setVisible(false);
        
        aux_id = buscar_id_chica();    
    }
    
    //Metodo para buscar el id de la chica para poder actualizarla
    public int buscar_id_chica()
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
        String fecha_ultimo_turno = "";
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
                consulta_SQL = ("SELECT turnos, fecha_trabajo FROM personal WHERE nombre ='" + nombre + "' AND fecha_trabajo BETWEEN '"+fecha_anterior+"' AND '"+fecha_actual+"'");                
                stm = conex.createStatement();                
                rs = stm.executeQuery(consulta_SQL);
                                                                                
                if (rs.last()) 
                {                    
                    fecha_ultimo_turno = rs.getString("fecha_trabajo");
                    
                    if (fecha_actual.equals(fecha_ultimo_turno)) 
                    {
                        turnos = rs.getInt("turnos");
                        tiene_turno = true;
                    }
                    else
                    {
                        turnos = rs.getInt("turnos");
                        tiene_turno = false;
                    }
                }
                else
                {
                    turnos = 0;                    
                    tiene_turno = false;
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
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
        
        if (chicas_registradas == 0) 
        {
            JOptionPane.showMessageDialog(null, "<html><h4>Seleccione primero un registro para actualizar</h4><html>", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
        }
        else
        {
            if (aux_id != 0) 
            {
                int id = aux_id;          
                String fecha_trabajo = fecha_registro();
                String dia = dias_de_la_semana_mostrar();
                String nombre = jTextField1_nombre.getText();
                int turnos = buscar_ultimo_turno_chica_nuevo_nombre();
                int aux_turnos = 0;
                String turno_borrado = jTextField1_borrar_turno.getText();
                
                String prestamos = jTextField2_prestamos.getText();                
                double aux_prestamos = Double.valueOf(prestamos);
                String aux2_prestamos = mi_formato.format(aux_prestamos); 
                
                int indice_show = jComboBox1_show.getSelectedIndex();
                String clase_show = tipo_shows(indice_show);
                
                String multas = jTextField1_paga_multa.getText();
                double aux_multas = Double.valueOf(multas);
                String aux2_multas = mi_formato.format(aux_multas);
                
                String examenes = jTextField1_examenes.getText();  
                double aux_examenes = Double.valueOf(examenes);
                String aux2_examenes = mi_formato.format(aux_examenes);
                
                int indice_combo = jComboBox1_show.getSelectedIndex();
                int registro_chica = Integer.valueOf(jTable1_datos.getValueAt(fila_seleccionada, 0).toString());                

                try 
                {                        
                    if (turno_borrado.equals("")) 
                    {
                        turno_borrado = " ";   
                        jRadioButton2_borrar_turno_no.isSelected();
                    }
                    else
                    {
                        jRadioButton1_borrar_turno_si.isSelected();
                    }

                    if (multas.equals("")) 
                    {
                        multas = "0";   
                        jRadioButton2_paga_multa_no.isSelected();
                    }
                    else
                    {
                        jRadioButton1_paga_multa_si.isSelected();
                    }

                    if (examenes.equals("")) 
                    {
                        examenes = "0";
                        jRadioButton2__debe_examen_no.isSelected();
                    }
                    else
                    {
                        jRadioButton1_debe_examen_si.isSelected();
                    }

                    modelo_de_la_tabla = (DefaultTableModel) jTable1_datos.getModel();
                    int a = modelo_de_la_tabla.getRowCount() -1;                
                    if (fila_seleccionada != -1) 
                    {
                        String datos[] = new String[9];
                        datos[0]= String.valueOf(registro_chica);
                        datos[1] = fecha_trabajo;
                        datos[2] = nombre;
                        if (tiene_turno == true) 
                        {                     
                            aux_turnos = turnos;                    
                        }
                        else
                        {
                            aux_turnos = turnos+1;
                        }               
                        datos[3] = String.valueOf(aux_turnos);
                        datos[4] = turno_borrado;                        
                        
                        datos[5] = aux2_prestamos;
                        datos[6] = clase_show;
                        datos[7] = aux2_multas;
                        datos[8] = aux2_examenes;  

                        modelo_de_la_tabla.fireTableDataChanged();
                        modelo_de_la_tabla.setValueAt(datos[0], fila_seleccionada, 0);   
                        modelo_de_la_tabla.setValueAt(datos[2], fila_seleccionada, 2);
                        modelo_de_la_tabla.setValueAt(datos[3], fila_seleccionada, 3);
                        modelo_de_la_tabla.setValueAt(datos[4], fila_seleccionada, 4);
                        modelo_de_la_tabla.setValueAt(datos[5], fila_seleccionada, 5);
                        modelo_de_la_tabla.setValueAt(datos[6], fila_seleccionada, 6);
                        modelo_de_la_tabla.setValueAt(datos[7], fila_seleccionada, 7);
                        modelo_de_la_tabla.setValueAt(datos[8], fila_seleccionada, 8);

                        jTable1_datos.setModel(modelo_de_la_tabla);
                        jTable1_datos.setUpdateSelectionOnSort(true);                                                
                    }    

                    PreparedStatement pps = conex.prepareStatement("UPDATE personal SET  chicas_registradas ='" + registro_chica + "',fecha_trabajo='" + fecha_trabajo + "', nombre= '" + nombre + "',turnos='" + aux_turnos + "',turno_borrado='" + turno_borrado + "',prestamos='" + prestamos + "', shows='" + indice_show + "',multas='" + multas + "' ,examenes='" + examenes + "' WHERE Id=" + id);
                    pps.executeUpdate();            
                    JOptionPane.showMessageDialog(null, "<html><h4>Registro Actualizado Correctamente</h4><html>", "Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);                                                          
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
                jLabel3.setVisible(true);
                jTextField1_borrar_turno.setVisible(false);
                jLabel4_borrar_turno_motivo.setVisible(false);        
                jLabel4.setVisible(true);
                jTextField1_paga_multa.setText("");
                jTextField1_paga_multa.setVisible(false);
                jLabel5_paga_multa.setVisible(false);        
                jLabel5.setVisible(true);
                jTextField1_examenes.setText("");
                jTextField1_examenes.setVisible(false);
                jLabel6_examenes_ejemplo.setVisible(false);
                buttonGroup1_borrar_turno.clearSelection();
                buttonGroup1_paga_multa.clearSelection();
                buttonGroup1_debe_examen.clearSelection(); 

                jButton1_registrar.setVisible(true);
                jButton5_editar.setVisible(true);   
                jButton1_buscar_chica.setVisible(true);                             
            }
        }        
    }
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1_borrar_turno = new javax.swing.ButtonGroup();
        buttonGroup1_paga_multa = new javax.swing.ButtonGroup();
        buttonGroup1_debe_examen = new javax.swing.ButtonGroup();
        jButton2_liquidar = new javax.swing.JButton();
        jButton1_buscar_chica = new javax.swing.JButton();
        jButton1_registrar = new javax.swing.JButton();
        jButton3_hist_registros = new javax.swing.JButton();
        jRadioButton2__debe_examen_no = new javax.swing.JRadioButton();
        jRadioButton1_debe_examen_si = new javax.swing.JRadioButton();
        jRadioButton2_paga_multa_no = new javax.swing.JRadioButton();
        jRadioButton1_paga_multa_si = new javax.swing.JRadioButton();
        jRadioButton2_borrar_turno_no = new javax.swing.JRadioButton();
        jRadioButton1_borrar_turno_si = new javax.swing.JRadioButton();
        jTextField1_borrar_turno = new javax.swing.JTextField();
        jLabel4_borrar_turno_motivo = new javax.swing.JLabel();
        jTextField1_paga_multa = new javax.swing.JTextField();
        jLabel5_paga_multa = new javax.swing.JLabel();
        jTextField1_examenes = new javax.swing.JTextField();
        jLabel6_examenes_ejemplo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1_nombre = new javax.swing.JLabel();
        jTextField1_nombre = new javax.swing.JTextField();
        jTextField2_prestamos = new javax.swing.JTextField();
        jComboBox1_show = new javax.swing.JComboBox<>();
        jLabel_titulo = new javax.swing.JLabel();
        jButton2_salir = new javax.swing.JButton();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jButton5_editar = new javax.swing.JButton();
        jButton1_actualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_datos = new javax.swing.JTable();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2_liquidar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_liquidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/liquidar.png"))); // NOI18N
        jButton2_liquidar.setText("Liquidar");
        jButton2_liquidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_liquidarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_liquidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 130, 25));

        jButton1_buscar_chica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_buscar_chica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton1_buscar_chica.setText("Buscar ");
        jButton1_buscar_chica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_buscar_chicaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_buscar_chica, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 130, 25));

        jButton1_registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/chicas_1.png"))); // NOI18N
        jButton1_registrar.setText("Registrar");
        jButton1_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_registrarActionPerformed(evt);
            }
        });
        jButton1_registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1_registrarKeyPressed(evt);
            }
        });
        getContentPane().add(jButton1_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 130, 25));

        jButton3_hist_registros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3_hist_registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial_2.png"))); // NOI18N
        jButton3_hist_registros.setText("Historial");
        jButton3_hist_registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_hist_registrosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_hist_registros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 130, 25));

        jRadioButton2__debe_examen_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2__debe_examen_no.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton2__debe_examen_no.setText("No");
        jRadioButton2__debe_examen_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2__debe_examen_noActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2__debe_examen_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 40, -1));

        jRadioButton1_debe_examen_si.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1_debe_examen_si.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton1_debe_examen_si.setText("Si");
        jRadioButton1_debe_examen_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_debe_examen_siActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_debe_examen_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 40, -1));

        jRadioButton2_paga_multa_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2_paga_multa_no.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton2_paga_multa_no.setText("No");
        jRadioButton2_paga_multa_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_paga_multa_noActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_paga_multa_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 40, -1));

        jRadioButton1_paga_multa_si.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1_paga_multa_si.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton1_paga_multa_si.setText("Si");
        jRadioButton1_paga_multa_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_paga_multa_siActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_paga_multa_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 40, -1));

        jRadioButton2_borrar_turno_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2_borrar_turno_no.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton2_borrar_turno_no.setText("No");
        jRadioButton2_borrar_turno_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_borrar_turno_noActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_borrar_turno_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 40, -1));

        jRadioButton1_borrar_turno_si.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1_borrar_turno_si.setForeground(new java.awt.Color(153, 255, 255));
        jRadioButton1_borrar_turno_si.setText("Si");
        jRadioButton1_borrar_turno_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_borrar_turno_siActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_borrar_turno_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 40, -1));

        jTextField1_borrar_turno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_borrar_turno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_borrar_turnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_borrar_turnoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_borrar_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 80, -1));

        jLabel4_borrar_turno_motivo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4_borrar_turno_motivo.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4_borrar_turno_motivo.setText(" (Motivo)");
        jLabel4_borrar_turno_motivo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel4_borrar_turno_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 50, -1));

        jTextField1_paga_multa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_paga_multa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_paga_multaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_paga_multaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_paga_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 80, -1));

        jLabel5_paga_multa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5_paga_multa.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5_paga_multa.setText("Ejemplo: 20000");
        getContentPane().add(jLabel5_paga_multa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 90, -1));

        jTextField1_examenes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_examenes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_examenesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_examenesKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 80, -1));

        jLabel6_examenes_ejemplo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6_examenes_ejemplo.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6_examenes_ejemplo.setText("Ejemplo: 20000");
        getContentPane().add(jLabel6_examenes_ejemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setText("Debe exam:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Cobrar multa:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Borrar turno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Show's:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Prestamos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel1_nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1_nombre.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1_nombre.setText("Nombre:");
        getContentPane().add(jLabel1_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));

        jTextField1_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nombreKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, -1));

        jTextField2_prestamos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2_prestamos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2_prestamosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2_prestamosKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField2_prestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 130, -1));

        jComboBox1_show.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1_show.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show's", "Individual", "Individual y grupo", "Grupo", "Especial" }));
        jComboBox1_show.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1_showKeyPressed(evt);
            }
        });
        getContentPane().add(jComboBox1_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 130, -1));

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 10, 360, -1));

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 90, 30));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 170, 20));

        jButton5_editar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        jButton5_editar.setText("Editar");
        jButton5_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_editarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 130, 25));

        jButton1_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar_3.png"))); // NOI18N
        jButton1_actualizar.setText("Actualizar");
        jButton1_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 130, 25));

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
        jTable1_datos.setGridColor(new java.awt.Color(153, 255, 255));
        jTable1_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_datos);
        if (jTable1_datos.getColumnModel().getColumnCount() > 0) {
            jTable1_datos.getColumnModel().getColumn(0).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1_datos.getColumnModel().getColumn(1).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(2).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(3).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(4).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(5).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(6).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(7).setResizable(false);
            jTable1_datos.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 910, 450));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        jLabel1_fondo.setMaximumSize(new java.awt.Dimension(1100, 500));
        jLabel1_fondo.setMinimumSize(new java.awt.Dimension(1100, 500));
        jLabel1_fondo.setPreferredSize(new java.awt.Dimension(1100, 500));
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2_liquidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_liquidarActionPerformed
        // TODO add your handling code here:
        Liquidacion ventana_liquidacion = new Liquidacion();
        ventana_liquidacion.setVisible(true);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);        
    }//GEN-LAST:event_jButton2_liquidarActionPerformed

    private void jButton1_buscar_chicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_buscar_chicaActionPerformed
        // TODO add your handling code here:
        Buscar_chica ventana_buscar_chica = new Buscar_chica();
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
        ventana_buscar_chica.setVisible(true);
    }//GEN-LAST:event_jButton1_buscar_chicaActionPerformed

    private void jButton1_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_registrarActionPerformed

        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");

        if (jTextField1_nombre.getText().equals("")
            || jTextField2_prestamos.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "<html><h4>Error en el Registro, Intente revisar que los campos nombre y prestamos no esten vacios </html> </h4>"                                
                ,"Registro de Personal", JOptionPane.INFORMATION_MESSAGE,icono);
            jTextField1_nombre.requestFocus();
        }
        else
        {
            try 
            {
                turnos_chicas(evt);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextField1_nombre.requestFocus();
            limpiar_campos();            
        }
    }//GEN-LAST:event_jButton1_registrarActionPerformed

    private void jButton1_registrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_registrarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.jButton1_registrar.doClick();
        }
    }//GEN-LAST:event_jButton1_registrarKeyPressed

    private void jButton3_hist_registrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_hist_registrosActionPerformed

        String evento = evt.getActionCommand();
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");

        String fecha_buscar = JOptionPane.showInputDialog(null, "Ingrese la fecha a buscar Ejemplo: (2010-12-20)","Historial de Registros",JOptionPane.INFORMATION_MESSAGE);

        try
        {
            mostrar_resgistro_diario_chicas(fecha_buscar,evt,evento);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3_hist_registrosActionPerformed

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

    private void jRadioButton2_paga_multa_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_paga_multa_noActionPerformed
        // TODO add your handling code here:
        jTextField1_paga_multa.setVisible(false);
        jLabel5_paga_multa.setVisible(false);
    }//GEN-LAST:event_jRadioButton2_paga_multa_noActionPerformed

    private void jRadioButton1_paga_multa_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_paga_multa_siActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1_paga_multa_si.isSelected() == true)
        {
            jTextField1_paga_multa.setVisible(true);
            jTextField1_paga_multa.requestFocus();
            jLabel5_paga_multa.setVisible(true);
        }
        else
        {
            jTextField1_paga_multa.setVisible(false);
            jLabel5_paga_multa.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_paga_multa_siActionPerformed

    private void jRadioButton2_borrar_turno_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_borrar_turno_noActionPerformed
        // TODO add your handling code here:

        jTextField1_borrar_turno.setVisible(false);
        jLabel4_borrar_turno_motivo.setVisible(false);
    }//GEN-LAST:event_jRadioButton2_borrar_turno_noActionPerformed

    private void jRadioButton1_borrar_turno_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_borrar_turno_siActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1_borrar_turno_si.isSelected() == true)
        {
            jTextField1_borrar_turno.setVisible(true);
            jTextField1_borrar_turno.requestFocus();
            jLabel4_borrar_turno_motivo.setVisible(true);
            jRadioButton1_borrar_turno_si.isSelected();
        }
        else
        {
            jTextField1_borrar_turno.setVisible(false);
            jLabel4_borrar_turno_motivo.setVisible(false);            
        }
    }//GEN-LAST:event_jRadioButton1_borrar_turno_siActionPerformed

    private void jTextField1_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nombreKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jTextField2_prestamos.requestFocus();
        }

    }//GEN-LAST:event_jTextField1_nombreKeyPressed

    private void jTextField2_prestamosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2_prestamosKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_registrar.requestFocus();
        }
    }//GEN-LAST:event_jTextField2_prestamosKeyPressed

    private void jComboBox1_showKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1_showKeyPressed
        // TODO add your handling code here:
        jButton1_registrar.requestFocus();
        jButton1_registrar.setFocusable(true);
    }//GEN-LAST:event_jComboBox1_showKeyPressed

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

    private void jButton5_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_editarActionPerformed

        fila_seleccionada = jTable1_datos.getSelectedRow();                
        columna_seleccionada = jTable1_datos.getSelectedColumn();
        
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");

        if (fila_seleccionada >= 0)
        {
            try
            {
                editar_chica(fila_seleccionada);
                jButton1_registrar.setVisible(false);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Buscar_chica.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al cargar la edicion", "Buscar chica", JOptionPane.INFORMATION_MESSAGE, icono);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "<html><h4>Seleccione la chica de la tabla que quiere modificar por favor</html> </h4>", "Buscar chica", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }//GEN-LAST:event_jButton5_editarActionPerformed

    private void jButton1_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_actualizarActionPerformed
        // TODO add your handling code here:
        String evento =  evt.getActionCommand();
        ImageIcon icono = new ImageIcon("src/Imagenes/actualizar_3.png");

        if (jTextField1_nombre.getText().equals("")
            || jTextField2_prestamos.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "<html><h4>Error en la actualización, cargue un registro primero</html></h4>"
                ,"Buscar Personal", JOptionPane.INFORMATION_MESSAGE,icono);
            jTextField1_nombre.requestFocus();
            jTextField1_nombre.setText("");
            jTextField2_prestamos.setText("");
            buttonGroup1_borrar_turno.clearSelection();
            jTextField1_borrar_turno.setText("");
            buttonGroup1_paga_multa.clearSelection();
            jTextField1_paga_multa.setText("");
            buttonGroup1_debe_examen.clearSelection();
            jTextField2_prestamos.setText("");
        }
        else
        {            
            actualizar_registro_chica();             
        }
    }//GEN-LAST:event_jButton1_actualizarActionPerformed

    private void jTextField1_borrar_turnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_borrar_turnoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_registrar.requestFocus();
        }
    }//GEN-LAST:event_jTextField1_borrar_turnoKeyPressed

    private void jTextField1_paga_multaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_paga_multaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_registrar.requestFocus();
        }
    }//GEN-LAST:event_jTextField1_paga_multaKeyPressed

    private void jTextField1_examenesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_examenesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_registrar.requestFocus();
        }
    }//GEN-LAST:event_jTextField1_examenesKeyPressed

    private void jTextField1_paga_multaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_paga_multaKeyTyped
        // TODO add your handling code here:
        
        //Este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_paga_multaKeyTyped

    private void jTextField1_borrar_turnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_borrar_turnoKeyTyped
        // TODO add your handling code here:
        
        //Codigo para escribir solo letras
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) 
        {
            
        }
        else
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_borrar_turnoKeyTyped

    private void jTextField1_examenesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_examenesKeyTyped
        // TODO add your handling code here:
        
        //Este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_examenesKeyTyped

    private void jTextField2_prestamosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2_prestamosKeyTyped
        // TODO add your handling code here:
        
        //Este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2_prestamosKeyTyped

    private void jTable1_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_datosMouseClicked
        // TODO add your handling code here:
        
        //Este scrip anula o remueve la edicion en la tabla
        for (int c = 0; c < jTable1_datos.getColumnCount(); c++)
        {
            Class<?> col_class = jTable1_datos.getColumnClass(c);
            jTable1_datos.setDefaultEditor(col_class, null);        // remove editor
        }
    }//GEN-LAST:event_jTable1_datosMouseClicked

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
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1_borrar_turno;
    private javax.swing.ButtonGroup buttonGroup1_debe_examen;
    private javax.swing.ButtonGroup buttonGroup1_paga_multa;
    private javax.swing.JButton jButton1_actualizar;
    private javax.swing.JButton jButton1_buscar_chica;
    private javax.swing.JButton jButton1_registrar;
    private javax.swing.JButton jButton2_liquidar;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JButton jButton3_hist_registros;
    private javax.swing.JButton jButton5_editar;
    protected javax.swing.JComboBox<String> jComboBox1_show;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel1_nombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_borrar_turno_motivo;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel5_paga_multa;
    private javax.swing.JLabel jLabel6_examenes_ejemplo;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JRadioButton jRadioButton1_borrar_turno_si;
    private javax.swing.JRadioButton jRadioButton1_debe_examen_si;
    private javax.swing.JRadioButton jRadioButton1_paga_multa_si;
    private javax.swing.JRadioButton jRadioButton2__debe_examen_no;
    private javax.swing.JRadioButton jRadioButton2_borrar_turno_no;
    private javax.swing.JRadioButton jRadioButton2_paga_multa_no;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_datos;
    private javax.swing.JTextField jTextField1_borrar_turno;
    private javax.swing.JTextField jTextField1_examenes;
    private javax.swing.JTextField jTextField1_nombre;
    private javax.swing.JTextField jTextField1_paga_multa;
    private javax.swing.JTextField jTextField2_prestamos;
    // End of variables declaration//GEN-END:variables
}
