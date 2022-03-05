
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Inventario extends javax.swing.JFrame 
{

    //Atributos y variables
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection conexion_SQL = conexion_1.conectar();
    
    DecimalFormat mi_formato = new DecimalFormat("###,###.##");   
    
    //Para guardar los valores de cada campo            
    public static String dato_campo_1="";
    public static String dato_campo_2="";
    public static String dato_campo_3="";
    public static String dato_campo_4="";
    public static String dato_campo_5="";
    public static String dato_campo_6="";
    public static String dato_campo_7="";
    public static String dato_campo_8="";
    public static String dato_campo_9="";
    public static String dato_campo_10="";
    public static String dato_campo_11="";
    public static String dato_campo_12="";
    public static String dato_campo_13="";    
    public static String dato_campo_14="";
    public static String dato_campo_15="";
    public static String dato_campo_16="";
    
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
    
    //Constructor de la Clase
    public Inventario() 
    {
        initComponents();
        setLocationRelativeTo(null);        
        
        setTitle("Inventario");
        jLabel3_fecha.setText(fecha_sistema()); 
        
        jButton1_inventario.setText("Inventario"); //esta línea ya está escrita, solo para ubicarse
        jButton1_inventario.setActionCommand("Inventario"); 
        //jButton1_inventario.addActionListener((ActionListener) this);
        
        jTextField1_resul_Ab.setVisible(false);
        jTextField1_resul_A_caneco.setVisible(false);
        jTextField1_resul_Rb.setVisible(false);
        jTextField1_resul_R_caneco.setVisible(false);
        jTextField1_resul_Bb.setVisible(false);
        jTextField1_resul_B_caneco.setVisible(false);
        jTextField1_resul_piñas.setVisible(false);
        jTextField1_resul_poker.setVisible(false);
        jTextField1_resul_gaseosa.setVisible(false);
        jTextField1_resul_agua.setVisible(false);
        jTextField1_resul_gatorade.setVisible(false);
        jTextField1_resul_redds.setVisible(false);
        jTextField1_resul_club.setVisible(false);
        jTextField1_resul_redbull.setVisible(false);
        jTextField1_resul_corona.setVisible(false);
        jTextField1_resul_wisky.setVisible(false);
        jTextField1_resul_habitaciones.setVisible(false);
        jTextField1_resul_multas.setVisible(false);        
        jTextField1_resul_gastos.setVisible(false);
        jTextField1_resul_total.setVisible(false);
        
        jLabel_resultado.setVisible(false);
        jLabel3_titulo_resul_inve.setVisible(false);
        
        jLabel3_titulo_resul_inve1.setVisible(false);
        jTextField1_resul_Ab1_salio.setVisible(false);
        jTextField1_resul_A_caneco1_salio.setVisible(false);
        jTextField1_resul_Rb1_salio.setVisible(false);
        jTextField1_resul_R_caneco1_salio.setVisible(false);
        jTextField1_resul_Bb1_salio.setVisible(false);
        jTextField1_resul_B_caneco1_salio.setVisible(false);
        jTextField1_resul_piñas1_salio.setVisible(false);
        jTextField1_resul_poker1_salio.setVisible(false);
        jTextField1_resul_gaseosa1_salio.setVisible(false);
        jTextField1_resul_agua1_salio.setVisible(false);
        jTextField1_resul_gatorade1_salio.setVisible(false);
        jTextField1_resul_redds1_salio.setVisible(false);
        jTextField1_resul_club1_salio.setVisible(false);
        jTextField1_resul_redbull1_salio.setVisible(false);
        jTextField1_resul_corona1_salio.setVisible(false);
        jTextField1_resul_wisky1_salio.setVisible(false);
        jTextField1_resul_habitaciones1_salio.setVisible(false);
        jTextField1_resul_multas1_salio.setVisible(false);        
        jTextField1_resul_gastos1_salio.setVisible(false);
        
        jButton1_guardar_inventario.setVisible(false);
        jComboBox1_opciones.setVisible(true);
        jLabel_resultado.setVisible(false);
        jTextField1_resul_total.setVisible(false);
                 
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
        String variable_fecha  = df_1.format(fecha);
                
        jLabel4_hora.setText(hora);
        return variable_fecha;
    }
    
    //Metodo para obtener la fecha del registro
    private String fecha_registro() 
    {       
        SimpleDateFormat formato_sql = new SimpleDateFormat("yyyy-MM-dd");//2018-09-09 19:52:54
        Date now = new Date();
        String variable_fecha = formato_sql.format(now);
        //System.out.println("DataTime ="+variable_fecha);

        return variable_fecha; 
    }
    
    //Metodo para abrir la ventana de nuevo inventario
    private void nuevo_inventario(ActionEvent evt) 
    {                    
        dato_campo_1 = jTextField1_Ab1.getText();
        dato_campo_2 = jTextField1_A_caneco1.getText();
        dato_campo_3 = jTextField1_Rb1.getText();
        dato_campo_4 = jTextField1_R_caneco1.getText();
        dato_campo_5 = jTextField1_Bb1.getText();
        dato_campo_6 = jTextField1_B_caneco1.getText();
        dato_campo_7 = jTextField1_piñas1.getText();
        dato_campo_8 = jTextField1_poker1.getText();
        dato_campo_9 = jTextField1_gaseosa1.getText();
        dato_campo_10 = jTextField1_agua1.getText();
        dato_campo_11 = jTextField1_gatorade1.getText();
        dato_campo_12 = jTextField1_redds1.getText();
        dato_campo_13 = jTextField1_club1.getText();
        dato_campo_14 = jTextField1_redbull1.getText();
        dato_campo_15 = jTextField1_corona1.getText();
        dato_campo_16 = jTextField1_wisky1.getText();

        Nuevo_inventario ventana_nuevo_inventario = new Nuevo_inventario();
        ventana_nuevo_inventario.setVisible(true);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);                                                                         
    }
    
    //Metodo para abrir la ventana de registro de chicas
    public void registro_personal() throws SQLException 
    {                     
        Personal ventana_personal = new Personal();
        ventana_personal.setVisible(true);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);                    
    }
    
    //Mertodo para mostrar los datos desde la BD
    private void mostrar_datos(java.awt.event.ActionEvent evt)
    {        
        String datos[] = new String [17];       
        String comando_sql="";
        
        if (evt.equals("Cargar Base Datos")) 
        {                                    
            comando_sql = ("SELECT `Id`, `Aguardiente Botello`, `Aguardiente Caneco`, `Ron Botello`, "
                    + "`Ron Caneco`, `Brandy Botello`, `Brandy Caneco`, `Piñas`, `Poker`, `Gaseosa`, "
                    + "`Agua`, `Gatorade`, `Reedd´s`, `Club`, `Redbull`,`Corona`, `Wisky`, `fecha_inventario` FROM `productos` WHERE 1");
        }
        else
        {
            comando_sql = "SELECT * FROM `productos` WHERE 1";            
        }         
        try {
            Statement s_t = conexion_SQL.createStatement();
            ResultSet r_s = s_t.executeQuery(comando_sql);
            while (r_s.next()) 
            {                
                datos[0] = r_s.getString(2);
                datos[1] = r_s.getString(3);
                datos[2] = r_s.getString(4);
                datos[3] = r_s.getString(5);
                datos[4] = r_s.getString(6);
                datos[5] = r_s.getString(7);
                datos[6] = r_s.getString(8);
                datos[7] = r_s.getString(9);
                datos[8] = r_s.getString(10);
                datos[9] = r_s.getString(11);
                datos[10] = r_s.getString(12);
                datos[11] = r_s.getString(13);
                datos[12] = r_s.getString(14);
                datos[13] = r_s.getString(15);
                datos[14] = r_s.getString(16);
                datos[15] = r_s.getString(17);
                
                jTextField1_Ab.setText(datos[0]);                                
                jTextField1_A_caneco.setText(datos[1]);
                jTextField1_Rb.setText(datos[2]);
                jTextField1_R_caneco.setText(datos[3]);
                jTextField1_Bb.setText(datos[4]);
                jTextField1_B_caneco.setText(datos[5]);
                jTextField1_piñas.setText(datos[6]);
                jTextField1_poker.setText(datos[7]);
                jTextField1_gaseosa.setText(datos[8]);
                jTextField1_agua.setText(datos[9]);
                jTextField1_gatorade.setText(datos[10]);
                jTextField1_redds.setText(datos[11]);
                jTextField1_club.setText(datos[12]);
                jTextField1_redbull.setText(datos[13]);
                jTextField1_corona.setText(datos[14]);                
                jTextField1_wisky.setText(datos[15]);
                
            }                        
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Se ha generado una excepción: "+ e);
        }        
    }
    
    //Metodo para hacer la multimplicacion de la catidad de producto que habia, 
    //(-) menos la cantidad de producto que salio,(* x) por lo que vale el producto($)
    public static float calcular_precio(int a, int b, int multi) 
    {
        float resul = 0;
        if (a > 0 && b >= 0) 
        {
            resul = ((a - b) * multi);
        }
        return resul;
    }
    
    //Metodo solo para las habitaciones
    public static float calcular_habitaciones(int a, int multi) 
    {
        float resul = 0;        
        resul = (a * multi);
        
        return resul;
    }
    
    public void historial_inventarios() 
    {        
        Historial_inventario mi_historial = new Historial_inventario();
        mi_historial.setVisible(true);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);                  
    }
    
    
    //Metodo para capturar los precios desde la BD
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
            }
        }
    }
    
    //Metodo para hacer el inventario
    public void inventariar(String evt) throws SQLException
    {
        captura_precios();
        
        ImageIcon icono = new ImageIcon("src/Imagenes/inventario2.png");
                                
            if (evt.equals("Inventario")) 
            {
                if (jTextField1_Ab1.getText().equals("") || jTextField1_A_caneco1.getText().equals("")
                        || jTextField1_Rb1.getText().equals("") || jTextField1_R_caneco1.getText().equals("")
                        || jTextField1_Bb1.getText().equals("") || jTextField1_B_caneco1.getText().equals("")
                        || jTextField1_piñas1.getText().equals("") || jTextField1_poker1.getText().equals("")
                        || jTextField1_gaseosa1.getText().equals("") || jTextField1_agua1.getText().equals("")
                        || jTextField1_gatorade1.getText().equals("") || jTextField1_redds1.getText().equals("")
                        || jTextField1_club1.getText().equals("") || jTextField1_redbull1.getText().equals("")
                        || jTextField1_corona1.getText().equals("") || jTextField1_habitaciones1.getText().equals("")
                        || jTextField1_multas1.getText().equals("") || jTextField1_gastos1.getText().equals("")
                        ||jTextField1_wisky1.getText().equals("")) 
                {                   
                    JOptionPane.showMessageDialog(null,"Falta al menos un campo por llenar \n"
                            + "Verifique el Inventario y vuelva a intentarlo ", "Inventario", JOptionPane.WARNING_MESSAGE,icono);
                } 
                else 
                {
                    jTextField1_resul_Ab.setVisible(true);
                    jTextField1_resul_A_caneco.setVisible(true);
                    jTextField1_resul_Rb.setVisible(true);
                    jTextField1_resul_R_caneco.setVisible(true);
                    jTextField1_resul_Bb.setVisible(true);
                    jTextField1_resul_B_caneco.setVisible(true);
                    jTextField1_resul_piñas.setVisible(true);
                    jTextField1_resul_poker.setVisible(true);
                    jTextField1_resul_gaseosa.setVisible(true);
                    jTextField1_resul_agua.setVisible(true);
                    jTextField1_resul_gatorade.setVisible(true);
                    jTextField1_resul_redds.setVisible(true);
                    jTextField1_resul_club.setVisible(true);
                    jTextField1_resul_redbull.setVisible(true);
                    jTextField1_resul_corona.setVisible(true);
                    jTextField1_resul_wisky.setVisible(true);
                    jTextField1_resul_habitaciones.setVisible(true);
                    jTextField1_resul_multas.setVisible(true);                    
                    jTextField1_resul_gastos.setVisible(true);
                    jTextField1_resul_total.setVisible(true);

                    jLabel3_titulo_resul_inve.setVisible(true);
                    jLabel_resultado.setVisible(true);
                    
                    jLabel3_titulo_resul_inve1.setVisible(true);
                    jTextField1_resul_Ab1_salio.setVisible(true);
                    jTextField1_resul_A_caneco1_salio.setVisible(true);
                    jTextField1_resul_Rb1_salio.setVisible(true);
                    jTextField1_resul_R_caneco1_salio.setVisible(true);
                    jTextField1_resul_Bb1_salio.setVisible(true);
                    jTextField1_resul_B_caneco1_salio.setVisible(true);
                    jTextField1_resul_piñas1_salio.setVisible(true);
                    jTextField1_resul_poker1_salio.setVisible(true);
                    jTextField1_resul_gaseosa1_salio.setVisible(true);
                    jTextField1_resul_agua1_salio.setVisible(true);
                    jTextField1_resul_gatorade1_salio.setVisible(true);
                    jTextField1_resul_redds1_salio.setVisible(true);
                    jTextField1_resul_club1_salio.setVisible(true);
                    jTextField1_resul_redbull1_salio.setVisible(true);
                    jTextField1_resul_corona1_salio.setVisible(true);
                    jTextField1_resul_wisky1_salio.setVisible(true);
                    jTextField1_resul_habitaciones1_salio.setVisible(true);
                    jTextField1_resul_multas1_salio.setVisible(true);                    
                    jTextField1_resul_gastos1_salio.setVisible(true);
                    
                    jButton1_guardar_inventario.setVisible(true);
                    jComboBox1_opciones.setVisible(true);
                    jLabel_resultado.setVisible(true);
                    jTextField1_resul_total.setVisible(true);
                    

                    //Aguardiente Botello
                    int a = 0;
                    float aux1 = 0;
                    if (a == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_Ab.getText());
                        int numero_2 = Integer.parseInt(jTextField1_Ab1.getText());
                        int multiplo = (multiplo_Ab);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_Ab1_salio.setText(String.valueOf(salida));
                        aux1 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_Ab.setText("$ " + mi_formato.format(aux1));
                    }

                    //Aguardiente Caneco
                    int b = 0;
                    float aux2 = 0;
                    if (b == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_A_caneco.getText());
                        int numero_2 = Integer.parseInt(jTextField1_A_caneco1.getText());
                        int multiplo = (multiplo_A2);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_A_caneco1_salio.setText(String.valueOf(salida));
                        aux2 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_A_caneco.setText("$ " + mi_formato.format(aux2));
                    }

                    //Ron Botello
                    int c = 0;
                    float aux3 = 0;
                    if (c == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_Rb.getText());
                        int numero_2 = Integer.parseInt(jTextField1_Rb1.getText());
                        int multiplo = (multiplo_Rb);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_Rb1_salio.setText(String.valueOf(salida));
                        aux3 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_Rb.setText("$ " + mi_formato.format(aux3));
                    }

                    //Ron Caneco
                    int d = 0;
                    float aux4 = 0;
                    if (d == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_R_caneco.getText());
                        int numero_2 = Integer.parseInt(jTextField1_R_caneco1.getText());
                        int multiplo = (multiplo_R2);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_R_caneco1_salio.setText(String.valueOf(salida));
                        aux4 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_R_caneco.setText("$ " + mi_formato.format(aux4));
                    }

                    //Brandy Botello
                    int e = 0;
                    float aux5 = 0;
                    if (e == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_Bb.getText());
                        int numero_2 = Integer.parseInt(jTextField1_Bb1.getText());
                        int multiplo = (multiplo_Bb);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_Bb1_salio.setText(String.valueOf(salida));
                        aux5 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_Bb.setText("$ " + mi_formato.format(aux5));
                    }

                    //Brandy Caneco
                    int f = 0;
                    float aux6 = 0;
                    if (f == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_B_caneco.getText());
                        int numero_2 = Integer.parseInt(jTextField1_B_caneco1.getText());
                        int multiplo = (multiplo_B2);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_B_caneco1_salio.setText(String.valueOf(salida));
                        aux6 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_B_caneco.setText("$ " + mi_formato.format(aux6));
                    }

                    //Piñas
                    int g = 0;
                    float aux7 = 0;
                    if (g == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_piñas.getText());
                        int numero_2 = Integer.parseInt(jTextField1_piñas1.getText());
                        int multiplo = (multiplo_piñas);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_piñas1_salio.setText(String.valueOf(salida));
                        aux7 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_piñas.setText("$ " + mi_formato.format(aux7));
                    }

                    //poker
                    int h = 0;
                    float aux8 = 0;
                    if (h == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_poker.getText());
                        int numero_2 = Integer.parseInt(jTextField1_poker1.getText());
                        int multiplo = (multiplo_poker);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_poker1_salio.setText(String.valueOf(salida));
                        aux8 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_poker.setText("$ " + mi_formato.format(aux8));
                    }

                    //gaseosa
                    int i = 0;
                    float aux9 = 0;
                    if (i == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_gaseosa.getText());
                        int numero_2 = Integer.parseInt(jTextField1_gaseosa1.getText());
                        int multiplo = (multiplo_gaseosa);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_gaseosa1_salio.setText(String.valueOf(salida));
                        aux9 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_gaseosa.setText("$ " + mi_formato.format(aux9));
                    }

                    //Agua
                    int j = 0;
                    float aux10 = 0;
                    if (j == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_agua.getText());
                        int numero_2 = Integer.parseInt(jTextField1_agua1.getText());
                        int multiplo = (multiplo_agua);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_agua1_salio.setText(String.valueOf(salida));
                        aux10 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_agua.setText("$ " + mi_formato.format(aux10));
                    }

                    //Gatorade
                    int k = 0;
                    float aux11 = 0;
                    if (k == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_gatorade.getText());
                        int numero_2 = Integer.parseInt(jTextField1_gatorade1.getText());
                        int multiplo = (multiplo_gatorade);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_gatorade1_salio.setText(String.valueOf(salida));
                        aux11 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_gatorade.setText("$ " + mi_formato.format(aux11));
                    }

                    //Reddss
                    int l = 0;
                    float aux12 = 0;
                    if (l == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_redds.getText());
                        int numero_2 = Integer.parseInt(jTextField1_redds1.getText());
                        int multiplo = (multiplo_reds);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_redds1_salio.setText(String.valueOf(salida));
                        aux12 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_redds.setText("$ " + mi_formato.format(aux12));
                    }

                    //Club
                    int m = 0;
                    float aux13 = 0;
                    if (m == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_club.getText());
                        int numero_2 = Integer.parseInt(jTextField1_club1.getText());
                        int multiplo = (multiplo_club);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_club1_salio.setText(String.valueOf(salida));
                        aux13 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_club.setText("$ " + mi_formato.format(aux13));
                    }

                    //Redbull
                    int n = 0;
                    float aux14 = 0;
                    if (n == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_redbull.getText());
                        int numero_2 = Integer.parseInt(jTextField1_redbull1.getText());
                        int multiplo = (multiplo_redbull);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_redbull1_salio.setText(String.valueOf(salida)); 
                        aux14 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_redbull.setText("$ " + mi_formato.format(aux14));
                    }
                    
                    //Corona
                    int ñ = 0;
                    float aux15 = 0;
                    if (ñ == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_corona.getText());
                        int numero_2 = Integer.parseInt(jTextField1_corona1.getText());
                        int multiplo = (multiplo_corona);                        
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_corona1_salio.setText(String.valueOf(salida)); 
                        aux15 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_corona.setText("$ " + mi_formato.format(aux15));                        
                    }
                    
                    //Wisky
                    int o = 0;
                    float aux16 = 0;
                    if (o == 0) {
                        int numero_1 = Integer.parseInt(jTextField1_wisky.getText());
                        int numero_2 = Integer.parseInt(jTextField1_wisky1.getText());
                        int multiplo = (multiplo_wisky);
                        int salida = numero_1 - numero_2;
                        jTextField1_resul_wisky1_salio.setText(String.valueOf(salida));
                        aux16 = calcular_precio(numero_1, numero_2, multiplo);
                        jTextField1_resul_wisky.setText("$ " + mi_formato.format(aux16));
                    }

                    //Habitaciones
                    int p = 0;
                    float aux17 = 0;
                    if (p == 0) {
                        //int numero_1 = Integer.parseInt(jTextField1_habitaciones.getText());
                        int numero_2 = Integer.parseInt(jTextField1_habitaciones1.getText());
                        int multiplo = (multiplo_habitaciones);
                        int salida = numero_2;
                        jTextField1_resul_habitaciones1_salio.setText(String.valueOf(salida));
                        aux17 = calcular_habitaciones(numero_2, multiplo);
                        jTextField1_resul_habitaciones.setText("$ " + mi_formato.format(aux17));
                    }

                    //Multas
                    int q = 0;
                    float aux18 = 0;
                    if (q == 0) {
                        //int numero_2=Integer.parseInt(jTextField1_multas1.getText());
                        aux18 = Float.parseFloat(jTextField1_multas1.getText());
                        
                        if (aux18 != 0) 
                        {
                            if (aux18 < (multiplo_multas)) 
                            {
                                JOptionPane.showMessageDialog(null,"El Valor Ingresado en las Multas \n"
                                + "debe ser superior a $ 20.000, Verifique el Inventario y repitalo ", "Inventario", JOptionPane.WARNING_MESSAGE,icono);
                            }
                            else
                            {
                               jTextField1_resul_multas1_salio.setText("$ " + mi_formato.format(aux18));
                               jTextField1_resul_multas.setText("$ " + mi_formato.format(aux18));                                
                            }                                                        
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "NOTA: No has registado ningúna Multa ","Inventario", JOptionPane.WARNING_MESSAGE, icono);
                            jTextField1_resul_multas.setText("$ " + mi_formato.format(aux18));
                            jTextField1_resul_multas1_salio.setText("$ " + mi_formato.format(aux18));
                        }                        
                    }
                    

                    //Gastos
                    int r = 0;
                    float aux19 = 0;
                    if (r == 0) 
                    {                        
                        aux19 = Float.parseFloat(jTextField1_gastos1.getText());
                        
                        if (aux19 == 0) 
                        {
                            JOptionPane.showMessageDialog(null, "NOTA: No has registrado ningún Gasto ","Inventario", JOptionPane.WARNING_MESSAGE, icono);
                            jTextField1_resul_gastos.setText("$ " + mi_formato.format(aux19));
                            jTextField1_resul_gastos1_salio.setText("$ " + mi_formato.format(aux19));
                            
                        } 
                        else 
                        {
                            if (aux19 < 1000) 
                            {
                                JOptionPane.showMessageDialog(null, "El Valor Ingresado en los Gastos \n"
                                        + "debe ser superior a $ 1.000, Verifique el Inventario y vuelva a intentarlo ", "Inventario", JOptionPane.WARNING_MESSAGE, icono);
                            } 
                            else 
                            {
                                jTextField1_resul_gastos.setText("$ " + mi_formato.format(aux19));
                                jTextField1_resul_gastos1_salio.setText("$ " + mi_formato.format(aux19));
                            }
                        }                        
                    }

                    //Mostrar total venta - gastos
                    //Sumo todos los valores que hay en todos los "aux" y le resto los gastos
                    jTextField1_resul_total.setText("$ " + String.valueOf(mi_formato.format((aux1 + aux2 + aux3 + aux4 + aux5 + aux6
                            + aux7 + aux8 + aux9 + aux10 + aux11 + aux12 + aux13 + aux14 + aux15 + aux16 + aux17 + aux18) - aux19)));
                    
                    //Capturo la fecha del dia del inventario
                    String fecha_inventario = fecha_sistema();                                                        
            }                       
        }
    }
    
    //Metodo para guardar en la BD el inventario
    protected void guardar_inventario(java.awt.event.ActionEvent evt) 
    {
        ImageIcon icono = new ImageIcon("src/Imagenes/inventario2.png");
        String eveto_boton = evt.getActionCommand();

        if (eveto_boton.equals("Guardar")) 
        {
            if (jTextField1_resul_total.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Error, NO se puede guardar un Inventario vacío","Inventario",JOptionPane.INFORMATION_MESSAGE,icono);                
            }
            else
            {
                try 
                {
                    PreparedStatement pps = conexion_SQL.prepareStatement("INSERT INTO `historial_inventario`(`fecha_inventario`, `Aguardiente Botello lo que habia`, `Aguardiente Botello lo que hay`, `Aguardiente Botello lo que salio`, `Aguardiente Botello Resultado`, `Aguardiente Caneco lo que habia`, `Aguardiente Caneco lo que hay`, `Aguardiente Caneco lo que salio`, `Aguardiente Caneco Resultado`, `Ron Botello lo que habia`, `Ron Botello lo que hay`, `Ron Botello lo que salio`, `Ron Botello Resultado`, `Ron Caneco lo que habia`, `Ron Caneco lo que hay`, `Ron Caneco lo que salio`, `Ron Caneco Resultado`, `Brandy Botello lo que habia`, `Brandy Botello lo que hay`, `Brandy Botello lo que salio`, `Brandy Botello Resultado`, `Brandy Caneco lo que habia`, `Brandy Caneco lo que hay`, `Brandy Caneco lo que salio`, `Brandy Caneco Resultado`, `Piñas lo que habia`, `Piñas lo que hay`, `Piñas lo que salio`, `Piñas Resultado`, `Poker lo que habia`, `Poker lo que hay`, `Poker lo que salio`, `Poker Resultado`, `Gaseosa lo que habia`, `Gaseosa lo que hay`, `Gaseosa lo que salio`, `Gaseosa Resultado`, `Agua lo que habia`, `Agua lo que hay`, `Agua lo que salio`, `Agua Resultado`, `Gatorade lo que habia`, `Gatorade lo que hay`, `Gatorade lo que salio`, `Gatorade Resultado`, `Reedd´s lo que habia`, `Reedd´s lo que hay`, `Reedd´s lo que salio`, `Reedd´s Resultado`, `Club lo que habia`, `Club lo que hay`, `Club lo que salio`, `Club Resultado`, `Redbull lo que habia`, `Redbull lo que hay`, `Redbull lo que salio`, `Redbull Resultado`, `Corona lo que habia`, `Corona lo que hay`,`Corona lo que salio`, `Corona Resultado`,`Wisky lo que habia`, `Wisky lo que hay`, `Wisky lo que salio`, `Wisky Resultado`, `Habitaciones lo que hay`, `Habitaciones lo que salio`, `Habitaciones Resultado`, `Multas lo que hay`, `Multas lo que salio`, `Multas Resultado`, `Gastos lo que hay`, `Gastos lo que salio`, `Gastos Resultado`, `Venta Total`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    
                    pps.setString(1, fecha_registro());

                    pps.setString(2, jTextField1_Ab.getText());
                    pps.setString(3, jTextField1_Ab1.getText());
                    pps.setString(4, jTextField1_resul_Ab1_salio.getText());
                    pps.setString(5, jTextField1_resul_Ab.getText());

                    pps.setString(6, jTextField1_A_caneco.getText());
                    pps.setString(7, jTextField1_A_caneco1.getText());
                    pps.setString(8, jTextField1_resul_A_caneco1_salio.getText());
                    pps.setString(9, jTextField1_resul_A_caneco.getText());

                    pps.setString(10, jTextField1_Rb.getText());
                    pps.setString(11, jTextField1_Rb1.getText());
                    pps.setString(12, jTextField1_resul_Rb1_salio.getText());
                    pps.setString(13, jTextField1_resul_Rb.getText());

                    pps.setString(14, jTextField1_R_caneco.getText());
                    pps.setString(15, jTextField1_R_caneco1.getText());
                    pps.setString(16, jTextField1_resul_R_caneco1_salio.getText());
                    pps.setString(17, jTextField1_resul_R_caneco.getText());

                    pps.setString(18, jTextField1_Bb.getText());
                    pps.setString(19, jTextField1_Bb1.getText());
                    pps.setString(20, jTextField1_resul_Bb1_salio.getText());
                    pps.setString(21, jTextField1_resul_Bb.getText());

                    pps.setString(22, jTextField1_B_caneco.getText());
                    pps.setString(23, jTextField1_B_caneco1.getText());
                    pps.setString(24, jTextField1_resul_B_caneco1_salio.getText());
                    pps.setString(25, jTextField1_resul_B_caneco.getText());

                    pps.setString(26, jTextField1_piñas.getText());
                    pps.setString(27, jTextField1_piñas1.getText());
                    pps.setString(28, jTextField1_resul_piñas1_salio.getText());
                    pps.setString(29, jTextField1_resul_piñas.getText());

                    pps.setString(30, jTextField1_poker.getText());
                    pps.setString(31, jTextField1_poker1.getText());
                    pps.setString(32, jTextField1_resul_poker1_salio.getText());
                    pps.setString(33, jTextField1_resul_poker.getText());

                    pps.setString(34, jTextField1_gaseosa.getText());
                    pps.setString(35, jTextField1_gaseosa1.getText());
                    pps.setString(36, jTextField1_resul_gaseosa1_salio.getText());
                    pps.setString(37, jTextField1_resul_gaseosa.getText());

                    pps.setString(38, jTextField1_agua.getText());
                    pps.setString(39, jTextField1_agua1.getText());
                    pps.setString(40, jTextField1_resul_agua1_salio.getText());
                    pps.setString(41, jTextField1_resul_agua.getText());

                    pps.setString(42, jTextField1_gatorade.getText());
                    pps.setString(43, jTextField1_gatorade1.getText());
                    pps.setString(44, jTextField1_resul_gatorade1_salio.getText());
                    pps.setString(45, jTextField1_resul_gatorade.getText());

                    pps.setString(46, jTextField1_redds.getText());
                    pps.setString(47, jTextField1_redds1.getText());
                    pps.setString(48, jTextField1_resul_redds1_salio.getText());
                    pps.setString(49, jTextField1_resul_redds.getText());
                    

                    pps.setString(50, jTextField1_club.getText());
                    pps.setString(51, jTextField1_club1.getText());
                    pps.setString(52, jTextField1_resul_club1_salio.getText());
                    pps.setString(53, jTextField1_resul_club.getText());

                    pps.setString(54, jTextField1_redbull.getText());
                    pps.setString(55, jTextField1_redbull1.getText());
                    pps.setString(56, jTextField1_resul_redbull1_salio.getText());
                    pps.setString(57, jTextField1_resul_redbull.getText());
                    
                    pps.setString(58, jTextField1_corona.getText());
                    pps.setString(59, jTextField1_corona1.getText());
                    pps.setString(60, jTextField1_resul_corona1_salio.getText());
                    pps.setString(61, jTextField1_resul_corona.getText());
                    
                    pps.setString(62, jTextField1_wisky.getText());
                    pps.setString(63, jTextField1_wisky1.getText());
                    pps.setString(64, jTextField1_resul_wisky1_salio.getText());
                    pps.setString(65, jTextField1_resul_wisky.getText());

                    pps.setString(66, jTextField1_habitaciones1.getText());
                    pps.setString(67, jTextField1_resul_habitaciones1_salio.getText());
                    pps.setString(68, jTextField1_resul_habitaciones.getText());

                    pps.setString(69, jTextField1_multas1.getText());
                    pps.setString(70, jTextField1_resul_multas1_salio.getText());
                    pps.setString(71, jTextField1_resul_multas.getText());                   

                    pps.setString(72, jTextField1_gastos1.getText());
                    pps.setString(73, jTextField1_resul_gastos1_salio.getText());
                    pps.setString(74, jTextField1_resul_gastos.getText());

                    pps.setString(75, jTextField1_resul_total.getText());

                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se ha guardado correctamente este inventario ", "Invenario", JOptionPane.INFORMATION_MESSAGE, icono);
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }          
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Error NO se ha Guardado el Inventario" ,"Invenario", JOptionPane.INFORMATION_MESSAGE,icono); 
        }        
    }
    
    //Metodo para abrir la ventan de liquidacion
    public void Liquidacion()
    {
        Liquidacion ventana_liquidacion = new Liquidacion();
        ventana_liquidacion.setVisible(true);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);   
    }
    
    //Metodo para actualizar los precios desde la DB
    public void actualizar_precios()
    {
        Precios ventana_precios = new Precios();
        ventana_precios.setVisible(true);
        setExtendedState(JFrame.CROSSHAIR_CURSOR);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_agua10 = new javax.swing.JLabel();
        jTextField1_Bb1 = new javax.swing.JTextField();
        jLabel_Rb3 = new javax.swing.JLabel();
        jTextField1_poker1 = new javax.swing.JTextField();
        jTextField1_redds1 = new javax.swing.JTextField();
        jTextField1_resul_habitaciones1_salio = new javax.swing.JTextField();
        jTextField1_habitaciones1 = new javax.swing.JTextField();
        jLabel_Ab1 = new javax.swing.JLabel();
        jTextField1_R_caneco1 = new javax.swing.JTextField();
        jLabel_redbull14 = new javax.swing.JLabel();
        jTextField1_wisky1 = new javax.swing.JTextField();
        jTextField1_resul_redbull1_salio = new javax.swing.JTextField();
        jTextField1_club1 = new javax.swing.JTextField();
        jLabel_Piñas7 = new javax.swing.JLabel();
        jTextField1_agua1 = new javax.swing.JTextField();
        jButton2_Bases_datos = new javax.swing.JButton();
        jTextField1_wisky = new javax.swing.JTextField();
        jLabel_wisky16 = new javax.swing.JLabel();
        jLabel_Bb5 = new javax.swing.JLabel();
        jLabel_multas18 = new javax.swing.JLabel();
        jTextField1_piñas = new javax.swing.JTextField();
        jLabel_club13 = new javax.swing.JLabel();
        jTextField1_B_caneco = new javax.swing.JTextField();
        jTextField1_A_caneco1 = new javax.swing.JTextField();
        jTextField1_resul_multas1_salio = new javax.swing.JTextField();
        jTextField1_redds = new javax.swing.JTextField();
        jTextField1_poker = new javax.swing.JTextField();
        jTextField1_Rb = new javax.swing.JTextField();
        jLabel_reds12 = new javax.swing.JLabel();
        jTextField1_redbull1 = new javax.swing.JTextField();
        jTextField1_gaseosa1 = new javax.swing.JTextField();
        jTextField1_corona = new javax.swing.JTextField();
        jLabel_Am2 = new javax.swing.JLabel();
        jLabel_Bm6 = new javax.swing.JLabel();
        jTextField1_Rb1 = new javax.swing.JTextField();
        jLabel_Rm4 = new javax.swing.JLabel();
        jTextField1_B_caneco1 = new javax.swing.JTextField();
        jLabel_corona15 = new javax.swing.JLabel();
        jTextField1_gatorade1 = new javax.swing.JTextField();
        jTextField1_resul_gastos1_salio = new javax.swing.JTextField();
        jLabel_poker8 = new javax.swing.JLabel();
        jLabel_gatorade11 = new javax.swing.JLabel();
        jTextField1_gatorade = new javax.swing.JTextField();
        jTextField1_gastos1 = new javax.swing.JTextField();
        jTextField1_resul_wisky1_salio = new javax.swing.JTextField();
        jTextField1_club = new javax.swing.JTextField();
        jTextField1_A_caneco = new javax.swing.JTextField();
        jTextField1_gaseosa = new javax.swing.JTextField();
        jTextField1_Bb = new javax.swing.JTextField();
        jLabel_gastos19 = new javax.swing.JLabel();
        jTextField1_multas1 = new javax.swing.JTextField();
        jTextField1_redbull = new javax.swing.JTextField();
        jTextField1_R_caneco = new javax.swing.JTextField();
        jButton1_inventario = new javax.swing.JButton();
        jLabel_productos = new javax.swing.JLabel();
        jTextField1_agua = new javax.swing.JTextField();
        jLabel_Gaseosa9 = new javax.swing.JLabel();
        jTextField1_piñas1 = new javax.swing.JTextField();
        jTextField1_resul_club1_salio = new javax.swing.JTextField();
        jTextField1_resul_redds1_salio = new javax.swing.JTextField();
        jTextField1_resul_gatorade1_salio = new javax.swing.JTextField();
        jTextField1_resul_agua1_salio = new javax.swing.JTextField();
        jTextField1_resul_gaseosa1_salio = new javax.swing.JTextField();
        jTextField1_resul_poker1_salio = new javax.swing.JTextField();
        jTextField1_resul_piñas1_salio = new javax.swing.JTextField();
        jTextField1_resul_B_caneco1_salio = new javax.swing.JTextField();
        jTextField1_resul_Bb1_salio = new javax.swing.JTextField();
        jTextField1_resul_R_caneco1_salio = new javax.swing.JTextField();
        jTextField1_resul_Rb1_salio = new javax.swing.JTextField();
        jTextField1_resul_A_caneco1_salio = new javax.swing.JTextField();
        jTextField1_resul_A_caneco = new javax.swing.JTextField();
        jTextField1_resul_Rb = new javax.swing.JTextField();
        jTextField1_resul_R_caneco = new javax.swing.JTextField();
        jTextField1_resul_Bb = new javax.swing.JTextField();
        jTextField1_resul_B_caneco = new javax.swing.JTextField();
        jTextField1_resul_piñas = new javax.swing.JTextField();
        jTextField1_resul_poker = new javax.swing.JTextField();
        jTextField1_resul_gaseosa = new javax.swing.JTextField();
        jTextField1_resul_agua = new javax.swing.JTextField();
        jTextField1_resul_gatorade = new javax.swing.JTextField();
        jTextField1_resul_redds = new javax.swing.JTextField();
        jTextField1_resul_club = new javax.swing.JTextField();
        jTextField1_resul_redbull = new javax.swing.JTextField();
        jTextField1_resul_wisky = new javax.swing.JTextField();
        jTextField1_resul_habitaciones = new javax.swing.JTextField();
        jTextField1_resul_multas = new javax.swing.JTextField();
        jTextField1_resul_gastos = new javax.swing.JTextField();
        jButton1_guardar_inventario = new javax.swing.JButton();
        jComboBox1_opciones = new javax.swing.JComboBox<>();
        jButton2_salir = new javax.swing.JButton();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jLabel3_titulo_resul_inve = new javax.swing.JLabel();
        jTextField1_resul_Ab = new javax.swing.JTextField();
        jTextField1_resul_Ab1_salio = new javax.swing.JTextField();
        jLabel3_titulo_resul_inve1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_Ab1 = new javax.swing.JTextField();
        jTextField1_Ab = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        jTextField1_resul_total = new javax.swing.JTextField();
        jLabel_resultado = new javax.swing.JLabel();
        jTextField1_corona1 = new javax.swing.JTextField();
        jTextField1_resul_corona1_salio = new javax.swing.JTextField();
        jTextField1_resul_corona = new javax.swing.JTextField();
        jLabel_hab17 = new javax.swing.JLabel();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_agua10.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_agua10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_agua10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_agua10.setText("10) Agua                              (A)");
        getContentPane().add(jLabel_agua10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 210, -1));

        jTextField1_Bb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Bb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Bb1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Bb1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Bb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 190, 60, -1));

        jLabel_Rb3.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Rb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Rb3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rb3.setText("3) Ron Botello                  (R b)");
        getContentPane().add(jLabel_Rb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jTextField1_poker1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_poker1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_poker1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_poker1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_poker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 280, 60, -1));

        jTextField1_redds1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redds1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redds1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 400, 60, -1));

        jTextField1_resul_habitaciones1_salio.setEditable(false);
        jTextField1_resul_habitaciones1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_habitaciones1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 80, -1));

        jTextField1_habitaciones1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_habitaciones1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_habitaciones1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_habitaciones1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_habitaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 550, 60, -1));

        jLabel_Ab1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab1.setText("1) Aguardiente Botello    (A b)");
        getContentPane().add(jLabel_Ab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jTextField1_R_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_R_caneco1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_R_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 160, 60, -1));

        jLabel_redbull14.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_redbull14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_redbull14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_redbull14.setText("14) Redbull                (Redbull)");
        getContentPane().add(jLabel_redbull14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 210, -1));

        jTextField1_wisky1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_wisky1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_wisky1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 520, 60, -1));

        jTextField1_resul_redbull1_salio.setEditable(false);
        jTextField1_resul_redbull1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redbull1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 80, -1));

        jTextField1_club1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_club1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_club1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 430, 60, -1));

        jLabel_Piñas7.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Piñas7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Piñas7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Piñas7.setText("7) Piñas");
        getContentPane().add(jLabel_Piñas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        jTextField1_agua1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_agua1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_agua1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 340, 60, -1));

        jButton2_Bases_datos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_Bases_datos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bases_1.png"))); // NOI18N
        jButton2_Bases_datos.setText("Cargar Base Datos");
        jButton2_Bases_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_Bases_datosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_Bases_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 185, 30));

        jTextField1_wisky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_wiskyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_wiskyKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 60, -1));

        jLabel_wisky16.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_wisky16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_wisky16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_wisky16.setText("16) Wisky                      (Wisky)");
        getContentPane().add(jLabel_wisky16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 210, -1));

        jLabel_Bb5.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Bb5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Bb5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Bb5.setText("5) Brandy Botello             (B b)");
        getContentPane().add(jLabel_Bb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        jLabel_multas18.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_multas18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_multas18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_multas18.setText("18) Multas                       (Mult)");
        getContentPane().add(jLabel_multas18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 210, 20));

        jTextField1_piñas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_piñas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_piñasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_piñasKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_piñas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 60, -1));

        jLabel_club13.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_club13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_club13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_club13.setText("13) Club              (Ligth y club)");
        getContentPane().add(jLabel_club13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 210, -1));

        jTextField1_B_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_B_caneco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_B_canecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_B_canecoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_B_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 60, -1));

        jTextField1_A_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_A_caneco1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_A_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 100, 60, -1));

        jTextField1_resul_multas1_salio.setEditable(false);
        jTextField1_resul_multas1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_multas1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 580, 80, -1));

        jTextField1_redds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_reddsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_reddsKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 60, -1));

        jTextField1_poker.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_poker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_pokerKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_pokerKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_poker, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 60, -1));

        jTextField1_Rb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Rb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_RbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_RbKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 60, -1));

        jLabel_reds12.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_reds12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_reds12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_reds12.setText("12) Reedd´s                  (Reds)");
        getContentPane().add(jLabel_reds12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 220, -1));

        jTextField1_redbull1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbull1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbull1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 460, 60, -1));

        jTextField1_gaseosa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gaseosa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gaseosa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 310, 60, -1));

        jTextField1_corona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_coronaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_coronaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 60, -1));

        jLabel_Am2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Am2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Am2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Am2.setText("2) Aguardiente Medio (A 1/2)");
        getContentPane().add(jLabel_Am2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, -1));

        jLabel_Bm6.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Bm6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Bm6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Bm6.setText("6) Brandy Medio          (B 1/2)");
        getContentPane().add(jLabel_Bm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, -1));

        jTextField1_Rb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Rb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Rb1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Rb1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 130, 60, -1));

        jLabel_Rm4.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Rm4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Rm4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rm4.setText("4) Ron Medio               (R 1/2)");
        getContentPane().add(jLabel_Rm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, -1));

        jTextField1_B_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_B_caneco1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_B_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 220, 60, -1));

        jLabel_corona15.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_corona15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_corona15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_corona15.setText("15) Corona          (Cer.corona)");
        getContentPane().add(jLabel_corona15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 210, -1));

        jTextField1_gatorade1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 370, 60, -1));

        jTextField1_resul_gastos1_salio.setEditable(false);
        jTextField1_resul_gastos1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gastos1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 610, 80, -1));

        jLabel_poker8.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_poker8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_poker8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_poker8.setText("8) Poker                               (P)");
        getContentPane().add(jLabel_poker8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 210, -1));

        jLabel_gatorade11.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_gatorade11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_gatorade11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gatorade11.setText("11) Gatorade                   (Get)");
        getContentPane().add(jLabel_gatorade11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 220, -1));

        jTextField1_gatorade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatoradeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatoradeKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 60, -1));

        jTextField1_gastos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gastos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gastos1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gastos1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gastos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 610, 60, -1));

        jTextField1_resul_wisky1_salio.setEditable(false);
        jTextField1_resul_wisky1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_wisky1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 80, -1));

        jTextField1_club.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_clubKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_clubKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 60, -1));

        jTextField1_A_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_A_caneco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_A_canecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_A_canecoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_A_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, -1));

        jTextField1_gaseosa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gaseosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 60, -1));

        jTextField1_Bb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Bb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_BbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_BbKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 60, -1));

        jLabel_gastos19.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_gastos19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_gastos19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_gastos19.setText("18) Gastos                  (gastos)");
        getContentPane().add(jLabel_gastos19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 210, 20));

        jTextField1_multas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_multas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_multas1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_multas1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_multas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 580, 60, -1));

        jTextField1_redbull.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbullKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbullKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 60, -1));

        jTextField1_R_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_R_caneco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_R_canecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_R_canecoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_R_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 60, -1));

        jButton1_inventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2.png"))); // NOI18N
        jButton1_inventario.setText("Inventario");
        jButton1_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_inventarioActionPerformed(evt);
            }
        });
        jButton1_inventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1_inventarioKeyPressed(evt);
            }
        });
        getContentPane().add(jButton1_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 640, 130, 30));

        jLabel_productos.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_productos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_productos.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_productos.setText("Productos: ");
        getContentPane().add(jLabel_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jTextField1_agua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_aguaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_aguaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 60, -1));

        jLabel_Gaseosa9.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Gaseosa9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Gaseosa9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Gaseosa9.setText("9) Gaseosa                           (g)");
        getContentPane().add(jLabel_Gaseosa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        jTextField1_piñas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_piñas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_piñas1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_piñas1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_piñas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 250, 60, -1));

        jTextField1_resul_club1_salio.setEditable(false);
        jTextField1_resul_club1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_club1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 80, -1));

        jTextField1_resul_redds1_salio.setEditable(false);
        jTextField1_resul_redds1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redds1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 80, -1));

        jTextField1_resul_gatorade1_salio.setEditable(false);
        jTextField1_resul_gatorade1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gatorade1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 80, -1));

        jTextField1_resul_agua1_salio.setEditable(false);
        jTextField1_resul_agua1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_agua1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 80, -1));

        jTextField1_resul_gaseosa1_salio.setEditable(false);
        jTextField1_resul_gaseosa1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gaseosa1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 80, -1));

        jTextField1_resul_poker1_salio.setEditable(false);
        jTextField1_resul_poker1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_poker1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 80, -1));

        jTextField1_resul_piñas1_salio.setEditable(false);
        jTextField1_resul_piñas1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_piñas1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 80, -1));

        jTextField1_resul_B_caneco1_salio.setEditable(false);
        jTextField1_resul_B_caneco1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_B_caneco1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 80, -1));

        jTextField1_resul_Bb1_salio.setEditable(false);
        jTextField1_resul_Bb1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Bb1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 80, -1));

        jTextField1_resul_R_caneco1_salio.setEditable(false);
        jTextField1_resul_R_caneco1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_R_caneco1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 80, -1));

        jTextField1_resul_Rb1_salio.setEditable(false);
        jTextField1_resul_Rb1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Rb1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 80, -1));

        jTextField1_resul_A_caneco1_salio.setEditable(false);
        jTextField1_resul_A_caneco1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_A_caneco1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 80, -1));

        jTextField1_resul_A_caneco.setEditable(false);
        jTextField1_resul_A_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_A_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 110, -1));

        jTextField1_resul_Rb.setEditable(false);
        jTextField1_resul_Rb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 110, -1));

        jTextField1_resul_R_caneco.setEditable(false);
        jTextField1_resul_R_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_R_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 110, -1));

        jTextField1_resul_Bb.setEditable(false);
        jTextField1_resul_Bb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 110, -1));

        jTextField1_resul_B_caneco.setEditable(false);
        jTextField1_resul_B_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_B_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 110, -1));

        jTextField1_resul_piñas.setEditable(false);
        jTextField1_resul_piñas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_piñas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 110, -1));

        jTextField1_resul_poker.setEditable(false);
        jTextField1_resul_poker.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_poker, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 110, -1));

        jTextField1_resul_gaseosa.setEditable(false);
        jTextField1_resul_gaseosa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 110, -1));

        jTextField1_resul_agua.setEditable(false);
        jTextField1_resul_agua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 110, -1));

        jTextField1_resul_gatorade.setEditable(false);
        jTextField1_resul_gatorade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 110, -1));

        jTextField1_resul_redds.setEditable(false);
        jTextField1_resul_redds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redds, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 110, -1));

        jTextField1_resul_club.setEditable(false);
        jTextField1_resul_club.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 110, -1));

        jTextField1_resul_redbull.setEditable(false);
        jTextField1_resul_redbull.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redbull, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 110, -1));

        jTextField1_resul_wisky.setEditable(false);
        jTextField1_resul_wisky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_wisky, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 110, -1));

        jTextField1_resul_habitaciones.setEditable(false);
        jTextField1_resul_habitaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_habitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 110, -1));

        jTextField1_resul_multas.setEditable(false);
        jTextField1_resul_multas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_multas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, 110, -1));

        jTextField1_resul_gastos.setEditable(false);
        jTextField1_resul_gastos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 110, -1));

        jButton1_guardar_inventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_guardar_inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar_1.png"))); // NOI18N
        jButton1_guardar_inventario.setText("Guardar");
        jButton1_guardar_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_guardar_inventarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_guardar_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, 130, 30));

        jComboBox1_opciones.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox1_opciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opciones", "Nuevo Inventario", "Registro de Personal", "Historial de Inventarios", "Liquidar Chicas", "Actualización de Precios" }));
        jComboBox1_opciones.setToolTipText("");
        jComboBox1_opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_opcionesActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 640, 160, 30));

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 90, 30));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 190, 20));

        jLabel3_titulo_resul_inve.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_titulo_resul_inve.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve.setText("Total Inventario:");
        getContentPane().add(jLabel3_titulo_resul_inve, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 130, -1));

        jTextField1_resul_Ab.setEditable(false);
        jTextField1_resul_Ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 110, -1));

        jTextField1_resul_Ab1_salio.setEditable(false);
        jTextField1_resul_Ab1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Ab1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, -1));

        jLabel3_titulo_resul_inve1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_titulo_resul_inve1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve1.setText("Lo que Salio:");
        getContentPane().add(jLabel3_titulo_resul_inve1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 93, -1));

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Lo que Hay:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 50, 90, -1));

        jTextField1_Ab1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Ab1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Ab1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Ab1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Ab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 70, 60, -1));

        jTextField1_Ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Ab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_AbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_AbKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 60, -1));

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("Lo que Habia:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 360, -1));

        jTextField1_resul_total.setEditable(false);
        jTextField1_resul_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 680, 130, 30));

        jLabel_resultado.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_resultado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_resultado.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_resultado.setText("Venta total:");
        getContentPane().add(jLabel_resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 710, 90, -1));

        jTextField1_corona1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_corona1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_corona1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 490, 60, -1));

        jTextField1_resul_corona1_salio.setEditable(false);
        jTextField1_resul_corona1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_corona1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 80, -1));

        jTextField1_resul_corona.setEditable(false);
        jTextField1_resul_corona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, 110, -1));

        jLabel_hab17.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_hab17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_hab17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hab17.setText("17) Habitaciones             (hab)");
        getContentPane().add(jLabel_hab17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 210, -1));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_Bb1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Bb1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_B_caneco1.requestFocus();
            jTextField1_B_caneco1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Bb1KeyPressed

    private void jTextField1_Bb1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Bb1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Bb1KeyTyped

    private void jTextField1_poker1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_poker1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gaseosa1.requestFocus();
            jTextField1_gaseosa1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_poker1KeyPressed

    private void jTextField1_poker1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_poker1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_poker1KeyTyped

    private void jTextField1_redds1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_club1.requestFocus();
            jTextField1_club1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redds1KeyPressed

    private void jTextField1_redds1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redds1KeyTyped

    private void jTextField1_habitaciones1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_habitaciones1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_multas1.requestFocus();
            jTextField1_multas1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_habitaciones1KeyPressed

    private void jTextField1_habitaciones1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_habitaciones1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_habitaciones1KeyTyped

    private void jTextField1_R_caneco1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_caneco1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Bb1.requestFocus();
            jTextField1_Bb1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_R_caneco1KeyPressed

    private void jTextField1_R_caneco1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_caneco1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_R_caneco1KeyTyped

    private void jTextField1_wisky1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_habitaciones1.requestFocus();
            jTextField1_habitaciones1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_wisky1KeyPressed

    private void jTextField1_wisky1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_wisky1KeyTyped

    private void jTextField1_club1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redbull1.requestFocus();
            jTextField1_redbull1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_club1KeyPressed

    private void jTextField1_club1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_club1KeyTyped

    private void jTextField1_agua1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gatorade1.requestFocus();
            jTextField1_gatorade1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_agua1KeyPressed

    private void jTextField1_agua1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_agua1KeyTyped

    private void jButton2_Bases_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_Bases_datosActionPerformed
        // TODO add your handling code here:
        ImageIcon icono = new ImageIcon("src/Imagenes/bases_1.png");
        ImageIcon icono5 = new ImageIcon("src/Imagenes/conexion_cerrada.png");

        ConexionMySQL mysql = new ConexionMySQL();
        java.sql.Connection cn = mysql.conectar();

        if (cn != null)
        {
            mostrar_datos(evt);
            JOptionPane.showMessageDialog(null, "Se ha conectado y cargado a la Base de Datos correctamente",
                "Cargando Base de Datos", JOptionPane.INFORMATION_MESSAGE,icono);            
            
            try
            {
                cn.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Error al conectar con la base de datos " + ex);
                JOptionPane.showMessageDialog(null, "Se ha cerrado la conexión a la BD correctamente",
                    "Cerrando Base de Datos", JOptionPane.INFORMATION_MESSAGE, icono5);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos \n"
                + "desde la Base de Datos."
                + "\n Verifique que el servidor Xampp este encendido","Inventario",JOptionPane.INFORMATION_MESSAGE,icono5);
        }
    }//GEN-LAST:event_jButton2_Bases_datosActionPerformed

    private void jTextField1_wiskyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wiskyKeyPressed
        // TODO add your handling code here:
        //int entrada=6;
        //jTextField1_wisky.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Ab1.requestFocus();
            jTextField1_Ab1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_wiskyKeyPressed

    private void jTextField1_wiskyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wiskyKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_wiskyKeyTyped

    private void jTextField1_piñasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñasKeyPressed
        // TODO add your handling code here:
        int entrada=30;
        //jTextField1_piñas.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_poker.requestFocus();
            jTextField1_poker.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_piñasKeyPressed

    private void jTextField1_piñasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñasKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_piñasKeyTyped

    private void jTextField1_B_canecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_canecoKeyPressed
        // TODO add your handling code here:
        int entrada=40;
        //jTextField1_B_caneco.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_piñas.requestFocus();
            jTextField1_piñas.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_B_canecoKeyPressed

    private void jTextField1_B_canecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_canecoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_B_canecoKeyTyped

    private void jTextField1_A_caneco1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_caneco1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Rb1.requestFocus();
            jTextField1_Rb1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_A_caneco1KeyPressed

    private void jTextField1_A_caneco1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_caneco1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_A_caneco1KeyTyped

    private void jTextField1_reddsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_reddsKeyPressed
        // TODO add your handling code here:
        int entrada=60;
        //jTextField1_redds.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_club.requestFocus();
            jTextField1_club.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_reddsKeyPressed

    private void jTextField1_reddsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_reddsKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_reddsKeyTyped

    private void jTextField1_pokerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_pokerKeyPressed
        // TODO add your handling code here:
        int entrada=550;
        //jTextField1_poker.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gaseosa.requestFocus();
            jTextField1_gaseosa.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_pokerKeyPressed

    private void jTextField1_pokerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_pokerKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_pokerKeyTyped

    private void jTextField1_RbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_RbKeyPressed
        // TODO add your handling code here:
        int entrada=40;
        //jTextField1_Rb.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_R_caneco.requestFocus();
            jTextField1_R_caneco.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_RbKeyPressed

    private void jTextField1_RbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_RbKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_RbKeyTyped

    private void jTextField1_redbull1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_corona1.requestFocus();
            jTextField1_corona1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redbull1KeyPressed

    private void jTextField1_redbull1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redbull1KeyTyped

    private void jTextField1_gaseosa1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosa1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_agua1.requestFocus();
            jTextField1_agua1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gaseosa1KeyPressed

    private void jTextField1_gaseosa1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosa1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gaseosa1KeyTyped

    private void jTextField1_Rb1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Rb1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_R_caneco1.requestFocus();
            jTextField1_R_caneco1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Rb1KeyPressed

    private void jTextField1_Rb1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Rb1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Rb1KeyTyped

    private void jTextField1_B_caneco1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_caneco1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_piñas1.requestFocus();
            jTextField1_piñas1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_B_caneco1KeyPressed

    private void jTextField1_B_caneco1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_caneco1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_B_caneco1KeyTyped

    private void jTextField1_gatorade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redds1.requestFocus();
            jTextField1_redds1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gatorade1KeyPressed

    private void jTextField1_gatorade1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gatorade1KeyTyped

    private void jTextField1_gatoradeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatoradeKeyPressed
        // TODO add your handling code here:
        int entrada=60;
        //jTextField1_gatorade.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redds.requestFocus();
            jTextField1_redds.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gatoradeKeyPressed

    private void jTextField1_gatoradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatoradeKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gatoradeKeyTyped

    private void jTextField1_gastos1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gastos1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jButton1_inventario.requestFocus();
            jButton1_inventario.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gastos1KeyPressed

    private void jTextField1_gastos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gastos1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gastos1KeyTyped

    private void jTextField1_clubKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_clubKeyPressed
        // TODO add your handling code here:
        int entrada=300;
        //jTextField1_club.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redbull.requestFocus();
            jTextField1_redbull.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_clubKeyPressed

    private void jTextField1_clubKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_clubKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_clubKeyTyped

    private void jTextField1_A_canecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_canecoKeyPressed
        // TODO add your handling code here:
        int entrada=40;
        //jTextField1_A_caneco.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Rb.requestFocus();
            jTextField1_Rb.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_A_canecoKeyPressed

    private void jTextField1_A_canecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_canecoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_A_canecoKeyTyped

    private void jTextField1_gaseosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosaKeyPressed
        // TODO add your handling code here:
        int entrada=250;
        //jTextField1_gaseosa.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_agua.requestFocus();
            jTextField1_agua.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gaseosaKeyPressed

    private void jTextField1_gaseosaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosaKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gaseosaKeyTyped

    private void jTextField1_BbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_BbKeyPressed
        // TODO add your handling code here:
        int entrada=40;
        //jTextField1_Bb.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_B_caneco.requestFocus();
            jTextField1_B_caneco.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_BbKeyPressed

    private void jTextField1_BbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_BbKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_BbKeyTyped

    private void jTextField1_multas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_multas1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gastos1.requestFocus();
            jTextField1_gastos1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_multas1KeyPressed

    private void jTextField1_multas1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_multas1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_multas1KeyTyped

    private void jTextField1_redbullKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbullKeyPressed
        // TODO add your handling code here:
        int entrada=30;
        //jTextField1_redbull.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_corona.requestFocus();
            jTextField1_corona.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redbullKeyPressed

    private void jTextField1_redbullKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbullKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redbullKeyTyped

    private void jTextField1_R_canecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_canecoKeyPressed
        // TODO add your handling code here:
        int entrada=40;
        //jTextField1_R_caneco.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Bb.requestFocus();
            jTextField1_Bb.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_R_canecoKeyPressed

    private void jTextField1_R_canecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_canecoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_R_canecoKeyTyped

    private void jButton1_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_inventarioActionPerformed
       String evento_boton = evt.getActionCommand();       
        try 
        {        
            inventariar(evento_boton);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al capturar precios:" + ex);
        }
    }//GEN-LAST:event_jButton1_inventarioActionPerformed

    private void jTextField1_aguaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_aguaKeyPressed
        // TODO add your handling code here:
        int entrada=80;        

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gatorade.requestFocus();
            jTextField1_gatorade.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_aguaKeyPressed

    private void jTextField1_aguaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_aguaKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_aguaKeyTyped

    private void jTextField1_piñas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñas1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_poker1.requestFocus();
            jTextField1_poker1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_piñas1KeyPressed

    private void jTextField1_piñas1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñas1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_piñas1KeyTyped

    private void jButton1_guardar_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_guardar_inventarioActionPerformed
        // TODO add your handling code here:
        guardar_inventario(evt);
    }//GEN-LAST:event_jButton1_guardar_inventarioActionPerformed

    private void jComboBox1_opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_opcionesActionPerformed
        // TODO add your handling code here:
        int opcion = jComboBox1_opciones.getSelectedIndex();
        ImageIcon icono = new ImageIcon("src/Imagenes/bases_1.png");

        switch (opcion)
        {
            case 1:
                nuevo_inventario(evt);
                jComboBox1_opciones.setSelectedIndex(0);
                break;
            case 2:

                try 
                {
                    registro_personal();
                    jComboBox1_opciones.setSelectedIndex(0);
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error, No se ha eliminado el registro" + ex);
                }
                break;

            case 3:
                historial_inventarios();
                jComboBox1_opciones.setSelectedIndex(0);
                break;

            case 4:
                Liquidacion();
                jComboBox1_opciones.setSelectedIndex(0);
                break;
//
            case 5:
                actualizar_precios();
                jComboBox1_opciones.setSelectedIndex(0);
                break;

            default: JOptionPane.showMessageDialog(null, "Opcion Incorrecta","Herramientas Inventario",JOptionPane.INFORMATION_MESSAGE,icono);
            throw new AssertionError();
        }
    }//GEN-LAST:event_jComboBox1_opcionesActionPerformed

    private void jButton2_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2_salirActionPerformed

    private void jTextField1_Ab1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Ab1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_A_caneco1.requestFocus();
            jTextField1_A_caneco1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Ab1KeyPressed

    private void jTextField1_Ab1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Ab1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Ab1KeyTyped

    private void jTextField1_AbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_AbKeyPressed
        // TODO add your handling code here:

        int entrada = 40;

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_A_caneco.requestFocus();
            jTextField1_A_caneco.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_AbKeyPressed

    private void jTextField1_AbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_AbKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField1_AbKeyTyped

    private void jButton1_inventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_inventarioKeyPressed
        // TODO add your handling code here:
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {            
            jButton1_inventario.setFocusable(true);
            jButton1_inventario.doClick();
        }
        
    }//GEN-LAST:event_jButton1_inventarioKeyPressed

    private void jTextField1_coronaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_coronaKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_coronaKeyTyped

    private void jTextField1_coronaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_coronaKeyPressed
        // TODO add your handling code here:
        int entrada=30;
        //jTextField1_habitaciones.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_wisky.requestFocus();
            jTextField1_wisky.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_coronaKeyPressed

    private void jTextField1_corona1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona1KeyPressed
        // TODO add your handling code here:
        
        int entrada=30;
        //jTextField1_habitaciones.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_wisky1.requestFocus();
            jTextField1_wisky1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_corona1KeyPressed

    private void jTextField1_corona1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona1KeyTyped
        // TODO add your handling code here:
        
        //Este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_corona1KeyTyped

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_guardar_inventario;
    public javax.swing.JButton jButton1_inventario;
    private javax.swing.JButton jButton2_Bases_datos;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JComboBox<String> jComboBox1_opciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel3_titulo_resul_inve;
    private javax.swing.JLabel jLabel3_titulo_resul_inve1;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_Ab1;
    private javax.swing.JLabel jLabel_Am2;
    private javax.swing.JLabel jLabel_Bb5;
    private javax.swing.JLabel jLabel_Bm6;
    private javax.swing.JLabel jLabel_Gaseosa9;
    private javax.swing.JLabel jLabel_Piñas7;
    private javax.swing.JLabel jLabel_Rb3;
    private javax.swing.JLabel jLabel_Rm4;
    private javax.swing.JLabel jLabel_agua10;
    private javax.swing.JLabel jLabel_club13;
    private javax.swing.JLabel jLabel_corona15;
    private javax.swing.JLabel jLabel_gastos19;
    private javax.swing.JLabel jLabel_gatorade11;
    private javax.swing.JLabel jLabel_hab17;
    private javax.swing.JLabel jLabel_multas18;
    private javax.swing.JLabel jLabel_poker8;
    private javax.swing.JLabel jLabel_productos;
    private javax.swing.JLabel jLabel_redbull14;
    private javax.swing.JLabel jLabel_reds12;
    private javax.swing.JLabel jLabel_resultado;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_wisky16;
    public javax.swing.JTextField jTextField1_A_caneco;
    public javax.swing.JTextField jTextField1_A_caneco1;
    public javax.swing.JTextField jTextField1_Ab;
    public javax.swing.JTextField jTextField1_Ab1;
    public javax.swing.JTextField jTextField1_B_caneco;
    public javax.swing.JTextField jTextField1_B_caneco1;
    public javax.swing.JTextField jTextField1_Bb;
    public javax.swing.JTextField jTextField1_Bb1;
    public javax.swing.JTextField jTextField1_R_caneco;
    public javax.swing.JTextField jTextField1_R_caneco1;
    public javax.swing.JTextField jTextField1_Rb;
    public javax.swing.JTextField jTextField1_Rb1;
    public javax.swing.JTextField jTextField1_agua;
    public javax.swing.JTextField jTextField1_agua1;
    public javax.swing.JTextField jTextField1_club;
    public javax.swing.JTextField jTextField1_club1;
    public javax.swing.JTextField jTextField1_corona;
    public javax.swing.JTextField jTextField1_corona1;
    public javax.swing.JTextField jTextField1_gaseosa;
    public javax.swing.JTextField jTextField1_gaseosa1;
    public javax.swing.JTextField jTextField1_gastos1;
    public javax.swing.JTextField jTextField1_gatorade;
    public javax.swing.JTextField jTextField1_gatorade1;
    public javax.swing.JTextField jTextField1_habitaciones1;
    public javax.swing.JTextField jTextField1_multas1;
    public javax.swing.JTextField jTextField1_piñas;
    public javax.swing.JTextField jTextField1_piñas1;
    public javax.swing.JTextField jTextField1_poker;
    public javax.swing.JTextField jTextField1_poker1;
    public javax.swing.JTextField jTextField1_redbull;
    public javax.swing.JTextField jTextField1_redbull1;
    public javax.swing.JTextField jTextField1_redds;
    public javax.swing.JTextField jTextField1_redds1;
    public javax.swing.JTextField jTextField1_resul_A_caneco;
    public javax.swing.JTextField jTextField1_resul_A_caneco1_salio;
    public javax.swing.JTextField jTextField1_resul_Ab;
    public javax.swing.JTextField jTextField1_resul_Ab1_salio;
    public javax.swing.JTextField jTextField1_resul_B_caneco;
    public javax.swing.JTextField jTextField1_resul_B_caneco1_salio;
    public javax.swing.JTextField jTextField1_resul_Bb;
    public javax.swing.JTextField jTextField1_resul_Bb1_salio;
    public javax.swing.JTextField jTextField1_resul_R_caneco;
    public javax.swing.JTextField jTextField1_resul_R_caneco1_salio;
    public javax.swing.JTextField jTextField1_resul_Rb;
    public javax.swing.JTextField jTextField1_resul_Rb1_salio;
    public javax.swing.JTextField jTextField1_resul_agua;
    public javax.swing.JTextField jTextField1_resul_agua1_salio;
    public javax.swing.JTextField jTextField1_resul_club;
    public javax.swing.JTextField jTextField1_resul_club1_salio;
    public javax.swing.JTextField jTextField1_resul_corona;
    public javax.swing.JTextField jTextField1_resul_corona1_salio;
    public javax.swing.JTextField jTextField1_resul_gaseosa;
    public javax.swing.JTextField jTextField1_resul_gaseosa1_salio;
    public javax.swing.JTextField jTextField1_resul_gastos;
    public javax.swing.JTextField jTextField1_resul_gastos1_salio;
    public javax.swing.JTextField jTextField1_resul_gatorade;
    public javax.swing.JTextField jTextField1_resul_gatorade1_salio;
    public javax.swing.JTextField jTextField1_resul_habitaciones;
    public javax.swing.JTextField jTextField1_resul_habitaciones1_salio;
    public javax.swing.JTextField jTextField1_resul_multas;
    public javax.swing.JTextField jTextField1_resul_multas1_salio;
    public javax.swing.JTextField jTextField1_resul_piñas;
    public javax.swing.JTextField jTextField1_resul_piñas1_salio;
    public javax.swing.JTextField jTextField1_resul_poker;
    public javax.swing.JTextField jTextField1_resul_poker1_salio;
    public javax.swing.JTextField jTextField1_resul_redbull;
    public javax.swing.JTextField jTextField1_resul_redbull1_salio;
    public javax.swing.JTextField jTextField1_resul_redds;
    public javax.swing.JTextField jTextField1_resul_redds1_salio;
    public javax.swing.JTextField jTextField1_resul_total;
    public javax.swing.JTextField jTextField1_resul_wisky;
    public javax.swing.JTextField jTextField1_resul_wisky1_salio;
    public javax.swing.JTextField jTextField1_wisky;
    public javax.swing.JTextField jTextField1_wisky1;
    // End of variables declaration//GEN-END:variables

    
}
