
package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
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
public class Precios extends javax.swing.JFrame implements ActionListener
{
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection conexion_SQL = conexion_1.conectar();    
    
    Inventario ventana_inventario = new Inventario();        
       
    
    public Precios() 
    {
        initComponents();        
        this.setLocationRelativeTo(this);
        setTitle("Precios");
        jLabel1_fondo.setVerticalAlignment(jLabel1_fondo.CENTER);
        jLabel1_fondo.setHorizontalAlignment(jLabel1_fondo.CENTER);
        
        jLabel3_fecha.setText(fecha_sistema());
        jTextField1_Ab_precio.setRequestFocusEnabled(true);
        jTextField1_Ab_precio.requestFocus();
        
        jLabel4_ejemplo_fecha_buscar.setText("Ultima fecha de modificación: "+ultima_fecha_modificacion());                
        
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
        String variable_fecha  = df_1.format(fecha);
                
        jLabel4_hora.setText(hora);
        return variable_fecha;
    }
    
    //Metodo que hace una consulta a la BD para optener la ultima fecha de modificacion de los precios
    public String ultima_fecha_modificacion()
    {
        String consulta_SQL = "";        
        ResultSet rs = null;
        String fecha_modificacion = "";
        
        if (conexion_1 != null) 
        {
            try 
            {
                consulta_SQL = ("SELECT fecha_modificacion FROM `precios_productos` WHERE 1");
                Statement stm = conexion_SQL.createStatement();                                
                rs = stm.executeQuery(consulta_SQL);
                                                                                
                if(rs.next()) 
                {
                    fecha_modificacion = rs.getString(1);                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error,verifique que todos los registros seleccionados /n"
                            + "o que la fecha esta bien digitada(Ver Ultima fecha modificada)");                    
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al consultar la ultima fecha de modificacion de la Tabla precios_productos en la Base de Datos:" + ex);
            }
        }
        return fecha_modificacion;
    }
    
    //Metodo que busca en la BD el Id de cada cambio de precio
    public int buscar_id_precio()
    {
        int id = 0;
        
        String consulta_SQL = "";
        Statement stm = null;
        ResultSet rs = null;
        
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");
                                                                
        if (conexion_1 != null) 
        {
            if (!jTextField1_fecha_modificacion_precio.getText().equals("")) 
            {
                if (jTextField1_Ab_precio.getText().equals("") || jTextField1_A_caneco_precio.getText().equals("")
                    ||jTextField1_Rb_precio.getText().equals("") || jTextField1_R_caneco_precio.getText().equals("")
                    || jTextField1_Bb_precio.getText().equals("") || jTextField1_B_caneco_precio.getText().equals("")
                    || jTextField1_piñas_precio.getText().equals("") || jTextField1_poker_precio.getText().equals("")
                    || jTextField1_gaseosa_precio.getText().equals("") || jTextField1_agua_precio.getText().equals("")
                    || jTextField1_gatorade_precio.getText().equals("") || jTextField1_redds_precio.getText().equals("")
                    || jTextField1_club_precio.getText().equals("") || jTextField1_redbull_precio.getText().equals("")
                    || jTextField1_corona_precio.getText().equals("") || jTextField1_wisky_precio.getText().equals("")
                    || jTextField1_habitaciones_precio.getText().equals("") || jTextField1_multas_precio.getText().equals("")
                    || jTextField1_examenes_precio.getText().equals("") || jTextField1_turnos_precio.getText().equals("")
                    || jTextField1_show_individual_precio.getText().equals("") || jTextField1_show_grupo_precio.getText().equals("")
                    || jTextField1_show_indi_grupo_precio.getText().equals("") || jTextField1_show_especial_precio.getText().equals("")) 
                {
                    JOptionPane.showMessageDialog(null, "Error, verifique que todos los precios esten diligenciados \n"
                                    + "o que la fecha esta digitada correctamente (Ver ejemplo -> Ultima fecha modificada)");
                }
                else
                {
                    try 
                    {
                        String fecha_modificacion = jTextField1_fecha_modificacion_precio.getText();
                        consulta_SQL = ("SELECT Id FROM precios_productos WHERE  fecha_modificacion = '" + fecha_modificacion + "'");
                        stm = conexion_SQL.createStatement();
                        rs = stm.executeQuery(consulta_SQL);

                        if (rs.next()) 
                        {
                            id = rs.getInt(1);
                            guardar_precios(id);
                        } 
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Error, verifique que la fecha esta bien digitada(Ver Ultima fecha modificada)");
                            jTextField1_fecha_modificacion_precio.requestFocus();
                            jTextField1_fecha_modificacion_precio.setFocusable(true);
                        }
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Error al Modificar la Base de Datos:" + ex);
                    }                    
                }                            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingrese la ultima fecha de modificación para actualizar los precios por favor", "Modificacion de Precios", JOptionPane.INFORMATION_MESSAGE, icono);                
                jTextField1_fecha_modificacion_precio.requestFocus();
                jTextField1_fecha_modificacion_precio.setFocusable(true);
            }
        }                        
        return id;
    }
    
    
    //Metodo para obtener la fecha del registro
    private String fecha_registro() 
    {       
        SimpleDateFormat formato_sql = new SimpleDateFormat("yyyy-MM-dd");//2018-09-09 19:52:54
        Date now = new Date();
        String variable_fecha = formato_sql.format(now);
        return variable_fecha; 
    }
    
    //Metod para guardar los nuevos precios y actualizados
    public void guardar_precios(int id)
    {        
        String fecha_modificacion = fecha_registro();        
        
        int multiplo_Ab =Integer.valueOf(jTextField1_Ab_precio.getText());        
        int multiplo_A2 = Integer.valueOf(jTextField1_A_caneco_precio.getText());
        int multiplo_Rb = Integer.valueOf(jTextField1_Rb_precio.getText());
        int multiplo_R2 = Integer.valueOf(jTextField1_R_caneco_precio.getText());
        int multiplo_Bb = Integer.valueOf(jTextField1_Bb_precio.getText());
        int multiplo_B2 = Integer.valueOf(jTextField1_B_caneco_precio.getText());
        int multiplo_piñas = Integer.valueOf(jTextField1_piñas_precio.getText());
        int multiplo_poker = Integer.valueOf(jTextField1_poker_precio.getText());
        int multiplo_gaseosa = Integer.valueOf(jTextField1_gaseosa_precio.getText());
        int multiplo_agua = Integer.valueOf(jTextField1_agua_precio.getText());
        int multiplo_gatorade = Integer.valueOf(jTextField1_gatorade_precio.getText());
        int multiplo_reds = Integer.valueOf(jTextField1_redds_precio.getText());
        int multiplo_club = Integer.valueOf(jTextField1_club_precio.getText());
        int multiplo_redbull = Integer.valueOf(jTextField1_redbull_precio.getText());
        int multiplo_corona = Integer.valueOf(jTextField1_corona_precio.getText());
        int multiplo_wisky = Integer.valueOf(jTextField1_wisky_precio.getText());
        int multiplo_habitaciones = Integer.valueOf(jTextField1_habitaciones_precio.getText());
        int multiplo_multas = Integer.valueOf(jTextField1_multas_precio.getText());
        int multiplo_examenes = Integer.valueOf(jTextField1_examenes_precio.getText());
        int multiplo_turnos = Integer.valueOf(jTextField1_turnos_precio.getText());
        int multiplo_show_individual = Integer.valueOf(jTextField1_show_individual_precio.getText());
        int multiplo_show_grupo = Integer.valueOf(jTextField1_show_grupo_precio.getText());
        int multiplo_show_indi_grupo = Integer.valueOf(jTextField1_show_indi_grupo_precio.getText());
        int multiplo_show_especial = Integer.valueOf(jTextField1_show_especial_precio.getText());
        
        
        ImageIcon icono = new ImageIcon("src/Imagenes/liquidar.png");
        
        try 
        {            
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta usted seguro que desea actualizar la lista de precios?", "Modificación de Precios", JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE, icono);                        
            if (confirmacion == 0) 
            {
                PreparedStatement pps_2 = conexion_SQL.prepareStatement("UPDATE precios_productos SET `fecha_modificacion`= '" + fecha_modificacion + "',`Aguardiente Botello`='" + multiplo_Ab + "',`Aguardiente Caneco`= '" + multiplo_A2 + "',`Ron Botello`='" + multiplo_Rb + "',`Ron Caneco`='" + multiplo_R2 + "',`Brandy Botello`='" + multiplo_Bb + "',`Brandy Caneco`='" + multiplo_B2 + "',`Piñas`='" + multiplo_piñas + "',`Poker`='" + multiplo_poker + "',`Gaseosa`='" + multiplo_gaseosa + "',`Agua`='" + multiplo_agua + "',`Gatorade`='" + multiplo_gatorade + "',`Reedd´s`='" + multiplo_reds + "',`Club`='" + multiplo_club + "',`Redbull`='" + multiplo_redbull + "',`Corona`='" + multiplo_corona +"',`Wisky`='" + multiplo_wisky + "',`Habitaciones`='" + multiplo_habitaciones + "',`Multas`='" + multiplo_multas + "',`Examenes`='"+ multiplo_examenes+"',`Turnos`='"+multiplo_turnos+"', `Show_individual`='"+multiplo_show_individual+"',`Show_grupo`='"+multiplo_show_grupo+"',`Show_indi_grupo`='"+multiplo_show_indi_grupo+"',`Show_especial`='"+multiplo_show_especial+"' WHERE `Id`=" + id);
                pps_2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Precios Actualizados Correctamente", "Modificacion de Precios", JOptionPane.INFORMATION_MESSAGE, icono);                
            }
            else
            {
                jTextField1_Ab_precio.setText("");
                jTextField1_A_caneco_precio.setText("");
                jTextField1_Rb_precio.setText("");
                jTextField1_R_caneco_precio.setText("");
                jTextField1_Bb_precio.setText("");
                jTextField1_B_caneco_precio.setText("");
                jTextField1_piñas_precio.setText("");
                jTextField1_poker_precio.setText("");
                jTextField1_gaseosa_precio.setText("");
                jTextField1_agua_precio.setText("");
                jTextField1_gatorade_precio.setText("");
                jTextField1_redds_precio.setText("");
                jTextField1_club_precio.setText("");
                jTextField1_redbull_precio.setText("");
                jTextField1_corona_precio.setText("");
                jTextField1_wisky_precio.setText("");
                jTextField1_habitaciones_precio.setText("");
                jTextField1_multas_precio.setText("");
                jTextField1_examenes_precio.setText("");
                jTextField1_turnos_precio.setText("");
                jTextField1_show_individual_precio.setText("");
                jTextField1_show_grupo_precio.setText("");
                jTextField1_show_indi_grupo_precio.setText("");
                //jTextField1_show_especial_precio.setText("");
                jTextField1_fecha_modificacion_precio.setText("");
                
                JOptionPane.showMessageDialog(null, "No Se ha Modificado la lista de precios ", "Invenario", JOptionPane.INFORMATION_MESSAGE, icono);
            }
            
            jTextField1_Ab_precio.setText("");
            jTextField1_A_caneco_precio.setText("");
            jTextField1_Rb_precio.setText("");
            jTextField1_R_caneco_precio.setText("");
            jTextField1_Bb_precio.setText("");
            jTextField1_B_caneco_precio.setText("");
            jTextField1_piñas_precio.setText("");
            jTextField1_poker_precio.setText("");
            jTextField1_gaseosa_precio.setText("");
            jTextField1_agua_precio.setText("");
            jTextField1_gatorade_precio.setText("");
            jTextField1_redds_precio.setText("");
            jTextField1_club_precio.setText("");
            jTextField1_redbull_precio.setText("");
            jTextField1_corona_precio.setText("");
            jTextField1_wisky_precio.setText("");
            jTextField1_habitaciones_precio.setText("");
            jTextField1_multas_precio.setText("");
            jTextField1_examenes_precio.setText("");
            jTextField1_turnos_precio.setText("");
            jTextField1_show_individual_precio.setText("");
            jTextField1_show_grupo_precio.setText("");
            jTextField1_show_indi_grupo_precio.setText("");
            //jTextField1_show_especial_precio.setText("");
            jTextField1_fecha_modificacion_precio.setText("");
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Precios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Actualizár el registro de la lista de precios en la Base de Datos:" + ex);
        }                   
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2_salir = new javax.swing.JButton();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_titulo_precios = new javax.swing.JLabel();
        jLabel_Ab = new javax.swing.JLabel();
        jLabel_A2 = new javax.swing.JLabel();
        jLabel_Rb = new javax.swing.JLabel();
        jLabel_R2 = new javax.swing.JLabel();
        jLabel_Bb = new javax.swing.JLabel();
        jLabel_B2 = new javax.swing.JLabel();
        jLabel_piñas = new javax.swing.JLabel();
        jLabel_poker = new javax.swing.JLabel();
        jLabel_gaseosa = new javax.swing.JLabel();
        jLabel_agua = new javax.swing.JLabel();
        jLabel_gatorade = new javax.swing.JLabel();
        jLabel_reds = new javax.swing.JLabel();
        jLabel_club = new javax.swing.JLabel();
        jLabel_redbull = new javax.swing.JLabel();
        jLabel_habitaciones = new javax.swing.JLabel();
        jLabel_corona = new javax.swing.JLabel();
        jLabel_turnos = new javax.swing.JLabel();
        jTextField1_Ab_precio = new javax.swing.JTextField();
        jTextField1_A_caneco_precio = new javax.swing.JTextField();
        jTextField1_Rb_precio = new javax.swing.JTextField();
        jTextField1_R_caneco_precio = new javax.swing.JTextField();
        jTextField1_Bb_precio = new javax.swing.JTextField();
        jTextField1_B_caneco_precio = new javax.swing.JTextField();
        jTextField1_piñas_precio = new javax.swing.JTextField();
        jTextField1_poker_precio = new javax.swing.JTextField();
        jTextField1_gaseosa_precio = new javax.swing.JTextField();
        jTextField1_agua_precio = new javax.swing.JTextField();
        jTextField1_gatorade_precio = new javax.swing.JTextField();
        jTextField1_redds_precio = new javax.swing.JTextField();
        jTextField1_club_precio = new javax.swing.JTextField();
        jTextField1_redbull_precio = new javax.swing.JTextField();
        jTextField1_habitaciones_precio = new javax.swing.JTextField();
        jTextField1_turnos_precio = new javax.swing.JTextField();
        jTextField1_corona_precio = new javax.swing.JTextField();
        jButton1_guardar_precios = new javax.swing.JButton();
        jLabel2_fecha_modificacion_precio = new javax.swing.JLabel();
        jTextField1_fecha_modificacion_precio = new javax.swing.JTextField();
        jLabel4_ejemplo_fecha_buscar = new javax.swing.JLabel();
        jLabel_productos1 = new javax.swing.JLabel();
        jLabel_multas = new javax.swing.JLabel();
        jTextField1_multas_precio = new javax.swing.JTextField();
        jLabel_examenes = new javax.swing.JLabel();
        jTextField1_examenes_precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2_fecha_modificacion_precio1 = new javax.swing.JLabel();
        jTextField1_wisky_precio = new javax.swing.JTextField();
        jLabel_wisky1 = new javax.swing.JLabel();
        jTextField1_show_individual_precio = new javax.swing.JTextField();
        jLabel_show_pista = new javax.swing.JLabel();
        jLabel_show_grupo = new javax.swing.JLabel();
        jTextField1_show_grupo_precio = new javax.swing.JTextField();
        jTextField1_show_indi_grupo_precio = new javax.swing.JTextField();
        jLabel_show_indi_grupo = new javax.swing.JLabel();
        jLabel_show_especial = new javax.swing.JLabel();
        jTextField1_show_especial_precio = new javax.swing.JTextField();
        jLabel_titulo_precios1 = new javax.swing.JLabel();
        jLabel_productos2 = new javax.swing.JLabel();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 90, 30));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 190, 20));

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel_titulo_precios.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_titulo_precios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo_precios.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo_precios.setText("Nuevo Precio: ");
        getContentPane().add(jLabel_titulo_precios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel_Ab.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab.setText("1) Aguardiente Botello    (A b)");
        getContentPane().add(jLabel_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel_A2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_A2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_A2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_A2.setText("2) Aguardiente Medio (A 1/2)");
        getContentPane().add(jLabel_A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel_Rb.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Rb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Rb.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rb.setText("3) Ron Botello                  (R b)");
        getContentPane().add(jLabel_Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel_R2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_R2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_R2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_R2.setText("4) Ron Medio               (R 1/2)");
        getContentPane().add(jLabel_R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel_Bb.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Bb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Bb.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Bb.setText("5) Brandy Botello             (B b)");
        getContentPane().add(jLabel_Bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel_B2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_B2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_B2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_B2.setText("6) Brandy Medio          (B 1/2)");
        getContentPane().add(jLabel_B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel_piñas.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_piñas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_piñas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_piñas.setText("7) Piñas");
        getContentPane().add(jLabel_piñas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel_poker.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_poker.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_poker.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_poker.setText("8) Poker                               (P)");
        getContentPane().add(jLabel_poker, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel_gaseosa.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_gaseosa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_gaseosa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gaseosa.setText("9) Gaseosa                           (g)");
        getContentPane().add(jLabel_gaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel_agua.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_agua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_agua.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_agua.setText("10) Agua                              (A)");
        getContentPane().add(jLabel_agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel_gatorade.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_gatorade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_gatorade.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gatorade.setText("11) Gatorade                   (Get)");
        getContentPane().add(jLabel_gatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel_reds.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_reds.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_reds.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_reds.setText("12) Reedd´s                  (Reds)");
        getContentPane().add(jLabel_reds, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel_club.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_club.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_club.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_club.setText("13) Club              (Ligth y club)");
        getContentPane().add(jLabel_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jLabel_redbull.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_redbull.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_redbull.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_redbull.setText("14) Redbull                (Redbull)");
        getContentPane().add(jLabel_redbull, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel_habitaciones.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_habitaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_habitaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_habitaciones.setText("17) Habitaciones             (hab)");
        getContentPane().add(jLabel_habitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jLabel_corona.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_corona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_corona.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_corona.setText("15) Corona          (Cer.corona)");
        getContentPane().add(jLabel_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 210, -1));

        jLabel_turnos.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_turnos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_turnos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_turnos.setText("20) Turnos                      (Tur)");
        getContentPane().add(jLabel_turnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 210, 20));

        jTextField1_Ab_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Ab_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Ab_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Ab_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Ab_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 60, -1));

        jTextField1_A_caneco_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_A_caneco_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_A_caneco_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 60, -1));

        jTextField1_Rb_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Rb_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Rb_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Rb_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Rb_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 60, -1));

        jTextField1_R_caneco_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_R_caneco_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_R_caneco_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 60, -1));

        jTextField1_Bb_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Bb_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Bb_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Bb_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Bb_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 60, -1));

        jTextField1_B_caneco_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_B_caneco_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_B_caneco_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 60, -1));

        jTextField1_piñas_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_piñas_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_piñas_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_piñas_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_piñas_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 60, -1));

        jTextField1_poker_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_poker_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_poker_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_poker_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_poker_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 60, -1));

        jTextField1_gaseosa_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gaseosa_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gaseosa_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 60, -1));

        jTextField1_agua_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_agua_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_agua_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 60, -1));

        jTextField1_gatorade_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 60, -1));

        jTextField1_redds_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redds_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redds_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 60, -1));

        jTextField1_club_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_club_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_club_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 60, -1));

        jTextField1_redbull_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbull_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbull_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 60, -1));

        jTextField1_habitaciones_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_habitaciones_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_habitaciones_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_habitaciones_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_habitaciones_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 60, -1));

        jTextField1_turnos_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_turnos_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_turnos_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_turnos_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_turnos_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 60, -1));

        jTextField1_corona_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_corona_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_corona_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 60, -1));

        jButton1_guardar_precios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_guardar_precios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar_1.png"))); // NOI18N
        jButton1_guardar_precios.setText("Guardar");
        jButton1_guardar_precios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_guardar_preciosActionPerformed(evt);
            }
        });
        jButton1_guardar_precios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1_guardar_preciosKeyPressed(evt);
            }
        });
        getContentPane().add(jButton1_guardar_precios, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 130, 30));

        jLabel2_fecha_modificacion_precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2_fecha_modificacion_precio.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2_fecha_modificacion_precio.setText("Fecha de modificación:");
        getContentPane().add(jLabel2_fecha_modificacion_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 160, 20));

        jTextField1_fecha_modificacion_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_fecha_modificacion_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_fecha_modificacion_precioActionPerformed(evt);
            }
        });
        jTextField1_fecha_modificacion_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_fecha_modificacion_precioKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_fecha_modificacion_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 160, -1));

        jLabel4_ejemplo_fecha_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4_ejemplo_fecha_buscar.setForeground(new java.awt.Color(102, 255, 255));
        getContentPane().add(jLabel4_ejemplo_fecha_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 300, 20));

        jLabel_productos1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_productos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_productos1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_productos1.setText("Productos: ");
        getContentPane().add(jLabel_productos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_multas.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_multas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_multas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_multas.setText("18) Multas                       (Mult)");
        getContentPane().add(jLabel_multas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 210, 20));

        jTextField1_multas_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_multas_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_multas_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_multas_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_multas_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 60, -1));

        jLabel_examenes.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_examenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_examenes.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_examenes.setText("19) Examenes                 (Exa)");
        getContentPane().add(jLabel_examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 210, 20));

        jTextField1_examenes_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_examenes_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_examenes_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_examenes_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_examenes_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 60, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("NOTA: Para modificar el valor de \nalgún artículo deberá también \nagregar los valores de los \nartículos que NO se cambien.");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 290, -1));

        jLabel2_fecha_modificacion_precio1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2_fecha_modificacion_precio1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2_fecha_modificacion_precio1.setText("Ingrese la ultima");
        getContentPane().add(jLabel2_fecha_modificacion_precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 160, -1));

        jTextField1_wisky_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_wisky_precioActionPerformed(evt);
            }
        });
        jTextField1_wisky_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_wisky_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_wisky_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 60, -1));

        jLabel_wisky1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_wisky1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_wisky1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_wisky1.setText("16) Wisky                      (wisky)");
        getContentPane().add(jLabel_wisky1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 210, -1));

        jTextField1_show_individual_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_show_individual_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_show_individual_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_show_individual_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_show_individual_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 60, -1));

        jLabel_show_pista.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_show_pista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_show_pista.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_show_pista.setText("21) Show Individual     (pista)");
        getContentPane().add(jLabel_show_pista, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 210, 20));

        jLabel_show_grupo.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_show_grupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_show_grupo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_show_grupo.setText("22) Show de grupo    (Grupo)");
        getContentPane().add(jLabel_show_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 210, 20));

        jTextField1_show_grupo_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_show_grupo_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_show_grupo_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_show_grupo_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_show_grupo_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 60, -1));

        jTextField1_show_indi_grupo_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_show_indi_grupo_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_show_indi_grupo_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_show_indi_grupo_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_show_indi_grupo_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 60, -1));

        jLabel_show_indi_grupo.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_show_indi_grupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_show_indi_grupo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_show_indi_grupo.setText("23) Show Ind/al - grupo(I/G)");
        getContentPane().add(jLabel_show_indi_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 210, 20));

        jLabel_show_especial.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_show_especial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_show_especial.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_show_especial.setText("24) Show Especial    (Especial)");
        getContentPane().add(jLabel_show_especial, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 210, 20));

        jTextField1_show_especial_precio.setEditable(false);
        jTextField1_show_especial_precio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_show_especial_precio.setText("0");
        jTextField1_show_especial_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_show_especial_precioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_show_especial_precioKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_show_especial_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 60, -1));

        jLabel_titulo_precios1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_titulo_precios1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo_precios1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo_precios1.setText("Nuevo Precio: ");
        getContentPane().add(jLabel_titulo_precios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));

        jLabel_productos2.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_productos2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_productos2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_productos2.setText("Productos: ");
        getContentPane().add(jLabel_productos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel1_fondo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 450));

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

    private void jTextField1_A_caneco_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_caneco_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Rb_precio.requestFocus();
            jTextField1_Rb_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_A_caneco_precioKeyPressed

    private void jTextField1_A_caneco_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_caneco_precioKeyTyped
        
        //Este metodo KeyTyped que generea un evento en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_A_caneco_precioKeyTyped

    private void jTextField1_Rb_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Rb_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_R_caneco_precio.requestFocus();
            jTextField1_R_caneco_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Rb_precioKeyPressed

    private void jTextField1_Rb_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Rb_precioKeyTyped
        
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Rb_precioKeyTyped

    private void jTextField1_R_caneco_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_caneco_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Bb_precio.requestFocus();
            jTextField1_Bb_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_R_caneco_precioKeyPressed

    private void jTextField1_R_caneco_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_caneco_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_R_caneco_precioKeyTyped

    private void jTextField1_Bb_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Bb_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_B_caneco_precio.requestFocus();
            jTextField1_B_caneco_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Bb_precioKeyPressed

    private void jTextField1_Bb_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Bb_precioKeyTyped
        
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Bb_precioKeyTyped

    private void jTextField1_B_caneco_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_caneco_precioKeyPressed
       
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_piñas_precio.requestFocus();
            jTextField1_piñas_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_B_caneco_precioKeyPressed

    private void jTextField1_B_caneco_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_caneco_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_B_caneco_precioKeyTyped

    private void jTextField1_piñas_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñas_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_poker_precio.requestFocus();
            jTextField1_poker_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_piñas_precioKeyPressed

    private void jTextField1_piñas_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñas_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_piñas_precioKeyTyped

    private void jTextField1_poker_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_poker_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gaseosa_precio.requestFocus();
            jTextField1_gaseosa_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_poker_precioKeyPressed

    private void jTextField1_poker_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_poker_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_poker_precioKeyTyped

    private void jTextField1_gaseosa_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosa_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_agua_precio.requestFocus();
            jTextField1_agua_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gaseosa_precioKeyPressed

    private void jTextField1_gaseosa_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosa_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gaseosa_precioKeyTyped

    private void jTextField1_agua_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gatorade_precio.requestFocus();
            jTextField1_gatorade_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_agua_precioKeyPressed

    private void jTextField1_agua_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_agua_precioKeyTyped

    private void jTextField1_gatorade_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redds_precio.requestFocus();
            jTextField1_redds_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gatorade_precioKeyPressed

    private void jTextField1_gatorade_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gatorade_precioKeyTyped

    private void jTextField1_redds_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_club_precio.requestFocus();
            jTextField1_club_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redds_precioKeyPressed

    private void jTextField1_redds_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redds_precioKeyTyped

    private void jTextField1_club_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redbull_precio.requestFocus();
            jTextField1_redbull_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_club_precioKeyPressed

    private void jTextField1_club_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_club_precioKeyTyped

    private void jTextField1_redbull_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull_precioKeyPressed
       
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_corona_precio.requestFocus();
            jTextField1_corona_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redbull_precioKeyPressed

    private void jTextField1_redbull_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redbull_precioKeyTyped

    private void jTextField1_habitaciones_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_habitaciones_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_multas_precio.requestFocus();
            jTextField1_multas_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_habitaciones_precioKeyPressed

    private void jTextField1_habitaciones_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_habitaciones_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_habitaciones_precioKeyTyped

    private void jTextField1_turnos_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_turnos_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_show_individual_precio.requestFocus();
            jTextField1_show_individual_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_turnos_precioKeyPressed

    private void jTextField1_turnos_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_turnos_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_turnos_precioKeyTyped

    private void jTextField1_corona_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona_precioKeyPressed
       
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_wisky_precio.requestFocus();
            jTextField1_wisky_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_corona_precioKeyPressed

    private void jTextField1_corona_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_corona_precioKeyTyped

    private void jButton1_guardar_preciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_guardar_preciosActionPerformed
        
        buscar_id_precio();
    }//GEN-LAST:event_jButton1_guardar_preciosActionPerformed

    private void jTextField1_Ab_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Ab_precioKeyPressed
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_A_caneco_precio.requestFocus();
            jTextField1_A_caneco_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Ab_precioKeyPressed

    private void jTextField1_Ab_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Ab_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Ab_precioKeyTyped

    private void jTextField1_fecha_modificacion_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_fecha_modificacion_precioActionPerformed
        // TODO add your handling code here:
        jButton1_guardar_precios.requestFocus();
    }//GEN-LAST:event_jTextField1_fecha_modificacion_precioActionPerformed

    private void jTextField1_fecha_modificacion_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_fecha_modificacion_precioKeyPressed
        // TODO add your handling code here:
        //jTextField1_fecha_buscar.requestFocus();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jButton1_guardar_precios.requestFocus();
            jButton1_guardar_precios.doClick();
        }
    }//GEN-LAST:event_jTextField1_fecha_modificacion_precioKeyPressed

    private void jTextField1_multas_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_multas_precioKeyPressed
        // TODO add your handling code here:                

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_examenes_precio.requestFocus();
            jTextField1_examenes_precio.setFocusable(true);
        }
        
    }//GEN-LAST:event_jTextField1_multas_precioKeyPressed

    private void jTextField1_examenes_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_examenes_precioKeyPressed
        // TODO add your handling code here:               

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_turnos_precio.requestFocus();
            jTextField1_turnos_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_examenes_precioKeyPressed

    private void jTextField1_wisky_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky_precioKeyPressed
        // TODO add your handling code here:
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_habitaciones_precio.requestFocus();
            jTextField1_habitaciones_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_wisky_precioKeyPressed

    private void jTextField1_wisky_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky_precioKeyTyped
        // TODO add your handling code here:
        
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_wisky_precioKeyTyped

    private void jTextField1_wisky_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_wisky_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_wisky_precioActionPerformed

    private void jTextField1_multas_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_multas_precioKeyTyped
        // TODO add your handling code here:
        
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_multas_precioKeyTyped

    private void jTextField1_examenes_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_examenes_precioKeyTyped
        // TODO add your handling code here:
        
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_examenes_precioKeyTyped

    private void jButton1_guardar_preciosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_guardar_preciosKeyPressed
        // TODO add your handling code here:
        
        if (jTextField1_fecha_modificacion_precio.getText().equals("")) 
        {
            jTextField1_fecha_modificacion_precio.requestFocus();
            jTextField1_fecha_modificacion_precio.setFocusable(true);            
        }
    }//GEN-LAST:event_jButton1_guardar_preciosKeyPressed

    private void jTextField1_show_individual_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_individual_precioKeyPressed
        // TODO add your handling code here:
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_show_grupo_precio.requestFocus();
            jTextField1_show_grupo_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_show_individual_precioKeyPressed

    private void jTextField1_show_individual_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_individual_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_show_individual_precioKeyTyped

    private void jTextField1_show_indi_grupo_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_indi_grupo_precioKeyPressed
        // TODO add your handling code here:
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_fecha_modificacion_precio.requestFocus();
            jTextField1_fecha_modificacion_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_show_indi_grupo_precioKeyPressed

    private void jTextField1_show_indi_grupo_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_indi_grupo_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_show_indi_grupo_precioKeyTyped

    private void jTextField1_show_grupo_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_grupo_precioKeyPressed
        // TODO add your handling code here:
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_show_indi_grupo_precio.requestFocus();
            jTextField1_show_indi_grupo_precio.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_show_grupo_precioKeyPressed

    private void jTextField1_show_grupo_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_grupo_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_show_grupo_precioKeyTyped

    private void jTextField1_show_especial_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_especial_precioKeyPressed
        // TODO add your handling code here:
        
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_fecha_modificacion_precio.requestFocus();
            jTextField1_fecha_modificacion_precio.setFocusable(true);
        }        
    }//GEN-LAST:event_jTextField1_show_especial_precioKeyPressed

    private void jTextField1_show_especial_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_show_especial_precioKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_show_especial_precioKeyTyped
    
    public static void main(String args[]) 
    {        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Precios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_guardar_precios;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel2_fecha_modificacion_precio;
    private javax.swing.JLabel jLabel2_fecha_modificacion_precio1;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel4_ejemplo_fecha_buscar;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_A2;
    private javax.swing.JLabel jLabel_Ab;
    private javax.swing.JLabel jLabel_B2;
    private javax.swing.JLabel jLabel_Bb;
    private javax.swing.JLabel jLabel_R2;
    private javax.swing.JLabel jLabel_Rb;
    private javax.swing.JLabel jLabel_agua;
    private javax.swing.JLabel jLabel_club;
    private javax.swing.JLabel jLabel_corona;
    private javax.swing.JLabel jLabel_examenes;
    private javax.swing.JLabel jLabel_gaseosa;
    private javax.swing.JLabel jLabel_gatorade;
    private javax.swing.JLabel jLabel_habitaciones;
    private javax.swing.JLabel jLabel_multas;
    private javax.swing.JLabel jLabel_piñas;
    private javax.swing.JLabel jLabel_poker;
    private javax.swing.JLabel jLabel_productos1;
    private javax.swing.JLabel jLabel_productos2;
    private javax.swing.JLabel jLabel_redbull;
    private javax.swing.JLabel jLabel_reds;
    private javax.swing.JLabel jLabel_show_especial;
    private javax.swing.JLabel jLabel_show_grupo;
    private javax.swing.JLabel jLabel_show_indi_grupo;
    private javax.swing.JLabel jLabel_show_pista;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_titulo_precios;
    private javax.swing.JLabel jLabel_titulo_precios1;
    private javax.swing.JLabel jLabel_turnos;
    private javax.swing.JLabel jLabel_wisky1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1_A_caneco_precio;
    public javax.swing.JTextField jTextField1_Ab_precio;
    public javax.swing.JTextField jTextField1_B_caneco_precio;
    public javax.swing.JTextField jTextField1_Bb_precio;
    public javax.swing.JTextField jTextField1_R_caneco_precio;
    public javax.swing.JTextField jTextField1_Rb_precio;
    public javax.swing.JTextField jTextField1_agua_precio;
    public javax.swing.JTextField jTextField1_club_precio;
    public javax.swing.JTextField jTextField1_corona_precio;
    public javax.swing.JTextField jTextField1_examenes_precio;
    public javax.swing.JTextField jTextField1_fecha_modificacion_precio;
    public javax.swing.JTextField jTextField1_gaseosa_precio;
    public javax.swing.JTextField jTextField1_gatorade_precio;
    public javax.swing.JTextField jTextField1_habitaciones_precio;
    public javax.swing.JTextField jTextField1_multas_precio;
    public javax.swing.JTextField jTextField1_piñas_precio;
    public javax.swing.JTextField jTextField1_poker_precio;
    public javax.swing.JTextField jTextField1_redbull_precio;
    public javax.swing.JTextField jTextField1_redds_precio;
    public javax.swing.JTextField jTextField1_show_especial_precio;
    public javax.swing.JTextField jTextField1_show_grupo_precio;
    public javax.swing.JTextField jTextField1_show_indi_grupo_precio;
    public javax.swing.JTextField jTextField1_show_individual_precio;
    public javax.swing.JTextField jTextField1_turnos_precio;
    public javax.swing.JTextField jTextField1_wisky_precio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
