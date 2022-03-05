package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Edward Henao1
 */
public class Historial_inventario extends javax.swing.JFrame implements ActionListener {

    //Atributos y variables    
    Inventario ventana_inventario = new Inventario();    
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection enlace_1 = conexion_1.conectar();
    java.sql.Connection conex = conexion_1.conectar();
    
    ResultSet r_s;
    Statement s_t;

    DecimalFormat formatea = new DecimalFormat("###,###.##");

    boolean abrir_nue_vent;   

    //Constructor     
    public Historial_inventario() 
    {
        initComponents();        

        this.setLocationRelativeTo(this);
        setTitle("Historial Inventario");
        jLabel1_fondo.setVerticalAlignment(jLabel1_fondo.CENTER);
        jLabel1_fondo.setHorizontalAlignment(jLabel1_fondo.CENTER);

        jLabel3_fecha.setText(fecha());
        jTextField1_buscar_fecha.requestFocus();
        jButton1_historial.setText("Buscar"); //esta línea ya está escrita, solo para ubicarse
        jButton1_historial.setActionCommand("Buscar");
        jButton1_historial.addActionListener(this);

    }

    //Metodo para obtener la fecha y hora del sistema
    private String fecha() 
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

    
    public String buscar_fecha(String fecha_a_buscar) 
    {   
        
        ImageIcon icono = new ImageIcon("src/Imagenes/buscar.png");
        String sentencia_sql = "";        
        String datos[]= new String[75];        
                       
            if (conex != null)                
            {
                
                sentencia_sql = "SELECT *FROM historial_inventario  WHERE fecha_inventario='" + fecha_a_buscar + "'";                
            } 
            else 
            {
                sentencia_sql = "SELECT  *FROM historial_inventario  WHERE fecha_inventario ";
            }
            try 
            {
                
                Statement statemen_t = enlace_1.createStatement();
                ResultSet r_s = statemen_t.executeQuery(sentencia_sql);
                if (!r_s.next()) 
                {
                    JOptionPane.showMessageDialog(null, "No hay un Historial de Inventario con esa fecha ("+fecha_a_buscar+")\n"
                            + " Verifique la fecha que ha ingresado");                    
                }
                        
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
                    datos[16] = r_s.getString(18);
                    datos[17] = r_s.getString(19);
                    datos[18] = r_s.getString(20);
                    datos[19] = r_s.getString(21);
                    datos[20] = r_s.getString(22);
                    datos[21] = r_s.getString(23);
                    datos[22] = r_s.getString(24);
                    datos[23] = r_s.getString(25);
                    datos[24] = r_s.getString(26);
                    datos[25] = r_s.getString(27);
                    datos[26] = r_s.getString(28);
                    datos[27] = r_s.getString(29);
                    datos[28] = r_s.getString(30);
                    datos[29] = r_s.getString(31);
                    datos[30] = r_s.getString(32);
                    datos[31] = r_s.getString(33);
                    datos[32] = r_s.getString(34);
                    datos[33] = r_s.getString(35);
                    datos[34] = r_s.getString(36);
                    datos[35] = r_s.getString(37);
                    datos[36] = r_s.getString(38);
                    datos[37] = r_s.getString(39);
                    datos[38] = r_s.getString(40);
                    datos[39] = r_s.getString(41);
                    datos[40] = r_s.getString(42);
                    datos[41] = r_s.getString(43);
                    datos[42] = r_s.getString(44);
                    datos[43] = r_s.getString(45);
                    datos[44] = r_s.getString(46);
                    datos[45] = r_s.getString(47);
                    datos[46] = r_s.getString(48);
                    datos[47] = r_s.getString(49);
                    datos[48] = r_s.getString(50);
                    datos[49] = r_s.getString(51);
                    datos[50] = r_s.getString(52);
                    datos[51] = r_s.getString(53);
                    datos[52] = r_s.getString(54);
                    datos[53] = r_s.getString(55);
                    datos[54] = r_s.getString(56);
                    datos[55] = r_s.getString(57);
                    datos[56] = r_s.getString(58);
                    datos[57] = r_s.getString(59);
                    datos[58] = r_s.getString(60);
                    datos[59] = r_s.getString(61);
                    datos[60] = r_s.getString(62);
                    datos[61] = r_s.getString(63);
                    datos[62] = r_s.getString(64);
                    datos[63] = r_s.getString(65);
                    datos[64] = r_s.getString(66);
                    datos[65] = r_s.getString(67);
                    datos[66] = r_s.getString(68);
                    datos[67] = r_s.getString(69);
                    datos[68] = r_s.getString(70);
                    datos[69] = r_s.getString(71);
                    datos[70] = r_s.getString(72);                    
                    datos[71] = r_s.getString(73);
                    datos[72] = r_s.getString(74);
                    datos[73] = r_s.getString(75);
                    datos[74] = r_s.getString(76);                    

                    jLabel4_fecha_buscada.setText(datos[0]);

                    jTextField1_Ab.setText(datos[1]);
                    jTextField1_Ab1.setText(datos[2]);
                    jTextField1_resul_Ab1_salio.setText(datos[3]);
                    jTextField1_resul_Ab.setText(datos[4]);

                    jTextField1_A_caneco.setText(datos[5]);
                    jTextField1_A_caneco1.setText(datos[6]);
                    jTextField1_resul_A_caneco1_salio.setText(datos[7]);
                    jTextField1_resul_A_caneco.setText(datos[8]);

                    jTextField1_Rb.setText(datos[9]);
                    jTextField1_Rb1.setText(datos[10]);
                    jTextField1_resul_Rb1_salio.setText(datos[11]);
                    jTextField1_resul_Rb.setText(datos[12]);

                    jTextField1_R_caneco.setText(datos[13]);
                    jTextField1_R_caneco1.setText(datos[14]);
                    jTextField1_resul_R_caneco1_salio.setText(datos[15]);
                    jTextField1_resul_R_caneco.setText(datos[16]);

                    jTextField1_Bb.setText(datos[17]);
                    jTextField1_Bb1.setText(datos[18]);
                    jTextField1_resul_Bb1_salio.setText(datos[19]);
                    jTextField1_resul_Bb.setText(datos[20]);

                    jTextField1_B_caneco.setText(datos[21]);
                    jTextField1_B_caneco1.setText(datos[22]);
                    jTextField1_resul_B_caneco1_salio.setText(datos[23]);
                    jTextField1_resul_B_caneco.setText(datos[24]);

                    jTextField1_piñas.setText(datos[25]);
                    jTextField1_piñas1.setText(datos[26]);
                    jTextField1_resul_piñas1_salio.setText(datos[27]);
                    jTextField1_resul_piñas.setText(datos[28]);

                    jTextField1_poker.setText(datos[29]);
                    jTextField1_poker1.setText(datos[30]);
                    jTextField1_resul_poker1_salio.setText(datos[31]);
                    jTextField1_resul_poker.setText(datos[32]);

                    jTextField1_gaseosa.setText(datos[33]);
                    jTextField1_gaseosa1.setText(datos[34]);
                    jTextField1_resul_gaseosa1_salio.setText(datos[35]);
                    jTextField1_resul_gaseosa.setText(datos[36]);

                    jTextField1_agua.setText(datos[37]);
                    jTextField1_agua1.setText(datos[38]);
                    jTextField1_resul_agua1_salio.setText(datos[39]);
                    jTextField1_resul_agua.setText(datos[40]);

                    jTextField1_gatorade.setText(datos[41]);
                    jTextField1_gatorade1.setText(datos[42]);
                    jTextField1_resul_gatorade1_salio.setText(datos[43]);
                    jTextField1_resul_gatorade.setText(datos[44]);

                    jTextField1_redds.setText(datos[45]);
                    jTextField1_redds1.setText(datos[46]);
                    jTextField1_resul_redds1_salio.setText(datos[47]);
                    jTextField1_resul_redds.setText(datos[48]);

                    jTextField1_club.setText(datos[49]);
                    jTextField1_club1.setText(datos[50]);
                    jTextField1_resul_club1_salio.setText(datos[51]);
                    jTextField1_resul_club.setText(datos[52]);

                    jTextField1_redbull.setText(datos[53]);
                    jTextField1_redbull1.setText(datos[54]);
                    jTextField1_resul_redbull1_salio.setText(datos[55]);
                    jTextField1_resul_redbull.setText(datos[56]);
                    
                    jTextField1_corona.setText(datos[57]);
                    jTextField1_corona1.setText(datos[58]);
                    jTextField1_resul_corona1_salio.setText(datos[59]);
                    jTextField1_resul_corona.setText(datos[60]);

                    jTextField1_wisky.setText(datos[61]);
                    jTextField1_wisky1.setText(datos[62]);
                    jTextField1_resul_wisky1_salio.setText(datos[63]);
                    jTextField1_resul_wisky.setText(datos[64]);

                    jTextField1_habitaciones1.setText(datos[65]);
                    jTextField1_resul_habitaciones1_salio.setText(datos[66]);
                    jTextField1_resul_habitaciones.setText(datos[67]);

                    jTextField1_multas1.setText(datos[68]);
                    jTextField1_resul_multas1_salio.setText(datos[69]);
                    jTextField1_resul_multas.setText(datos[70]);

                    jTextField1_gastos1.setText(datos[71]);
                    jTextField1_resul_gastos1_salio.setText(datos[72]);
                    jTextField1_resul_gastos.setText(datos[73]);

                    jTextField1_resul_total.setText(datos[74]);

                conex.close();
            } 
            catch (SQLException e) 
            {                
                System.out.println("Error al buscar la fecha: " + e);
            }               
        return fecha_a_buscar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_productos = new javax.swing.JLabel();
        jLabel_Ab = new javax.swing.JLabel();
        jLabel_Ab1 = new javax.swing.JLabel();
        jLabel_Ab2 = new javax.swing.JLabel();
        jLabel_Ab3 = new javax.swing.JLabel();
        jLabel_Ab4 = new javax.swing.JLabel();
        jLabel_Ab5 = new javax.swing.JLabel();
        jLabel_Ab6 = new javax.swing.JLabel();
        jLabel_Ab7 = new javax.swing.JLabel();
        jLabel_Ab8 = new javax.swing.JLabel();
        jLabel_Ab9 = new javax.swing.JLabel();
        jLabel_Ab10 = new javax.swing.JLabel();
        jLabel_Ab11 = new javax.swing.JLabel();
        jLabel_Ab12 = new javax.swing.JLabel();
        jLabel_Ab13 = new javax.swing.JLabel();
        jLabel_Ab14 = new javax.swing.JLabel();
        jLabel_Ab15 = new javax.swing.JLabel();
        jLabel_Ab16 = new javax.swing.JLabel();
        jLabel_Ab17 = new javax.swing.JLabel();
        jTextField1_A_caneco = new javax.swing.JTextField();
        jTextField1_Ab = new javax.swing.JTextField();
        jTextField1_R_caneco = new javax.swing.JTextField();
        jTextField1_Rb = new javax.swing.JTextField();
        jTextField1_Bb = new javax.swing.JTextField();
        jTextField1_B_caneco = new javax.swing.JTextField();
        jTextField1_piñas = new javax.swing.JTextField();
        jTextField1_poker = new javax.swing.JTextField();
        jTextField1_gaseosa = new javax.swing.JTextField();
        jTextField1_agua = new javax.swing.JTextField();
        jTextField1_gatorade = new javax.swing.JTextField();
        jTextField1_redds = new javax.swing.JTextField();
        jTextField1_club = new javax.swing.JTextField();
        jTextField1_redbull = new javax.swing.JTextField();
        jTextField1_wisky = new javax.swing.JTextField();
        jTextField1_resul_A_caneco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_Ab1 = new javax.swing.JTextField();
        jTextField1_A_caneco1 = new javax.swing.JTextField();
        jTextField1_Rb1 = new javax.swing.JTextField();
        jTextField1_R_caneco1 = new javax.swing.JTextField();
        jTextField1_Bb1 = new javax.swing.JTextField();
        jTextField1_B_caneco1 = new javax.swing.JTextField();
        jTextField1_piñas1 = new javax.swing.JTextField();
        jTextField1_poker1 = new javax.swing.JTextField();
        jTextField1_gaseosa1 = new javax.swing.JTextField();
        jTextField1_agua1 = new javax.swing.JTextField();
        jTextField1_gatorade1 = new javax.swing.JTextField();
        jTextField1_redds1 = new javax.swing.JTextField();
        jTextField1_club1 = new javax.swing.JTextField();
        jTextField1_redbull1 = new javax.swing.JTextField();
        jTextField1_habitaciones1 = new javax.swing.JTextField();
        jTextField1_multas1 = new javax.swing.JTextField();
        jTextField1_wisky1 = new javax.swing.JTextField();
        jTextField1_gastos1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3_titulo_resul_inve = new javax.swing.JLabel();
        jTextField1_resul_Ab = new javax.swing.JTextField();
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
        jTextField1_resul_habitaciones = new javax.swing.JTextField();
        jTextField1_resul_multas = new javax.swing.JTextField();
        jTextField1_resul_wisky = new javax.swing.JTextField();
        jTextField1_resul_gastos = new javax.swing.JTextField();
        jLabel_resultado = new javax.swing.JLabel();
        jTextField1_resul_total = new javax.swing.JTextField();
        jButton2_salir = new javax.swing.JButton();
        jLabel4_hora = new javax.swing.JLabel();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel1_buscar_fecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1_historial = new javax.swing.JButton();
        jLabel4_fecha_buscada = new javax.swing.JLabel();
        jLabel4_titulo = new javax.swing.JLabel();
        jTextField1_buscar_fecha = new javax.swing.JTextField();
        jLabel3_titulo_resul_inve1 = new javax.swing.JLabel();
        jTextField1_resul_Ab1_salio = new javax.swing.JTextField();
        jTextField1_resul_A_caneco1_salio = new javax.swing.JTextField();
        jTextField1_resul_Rb1_salio = new javax.swing.JTextField();
        jTextField1_resul_R_caneco1_salio = new javax.swing.JTextField();
        jTextField1_resul_Bb1_salio = new javax.swing.JTextField();
        jTextField1_resul_B_caneco1_salio = new javax.swing.JTextField();
        jTextField1_resul_piñas1_salio = new javax.swing.JTextField();
        jTextField1_resul_poker1_salio = new javax.swing.JTextField();
        jTextField1_resul_gaseosa1_salio = new javax.swing.JTextField();
        jTextField1_resul_agua1_salio = new javax.swing.JTextField();
        jTextField1_resul_gatorade1_salio = new javax.swing.JTextField();
        jTextField1_resul_redds1_salio = new javax.swing.JTextField();
        jTextField1_resul_club1_salio = new javax.swing.JTextField();
        jTextField1_resul_redbull1_salio = new javax.swing.JTextField();
        jTextField1_resul_wisky1_salio = new javax.swing.JTextField();
        jTextField1_resul_habitaciones1_salio = new javax.swing.JTextField();
        jTextField1_resul_multas1_salio = new javax.swing.JTextField();
        jTextField1_resul_gastos1_salio = new javax.swing.JTextField();
        jTextField1_resul_corona = new javax.swing.JTextField();
        jTextField1_resul_corona1_salio = new javax.swing.JTextField();
        jTextField1_corona1 = new javax.swing.JTextField();
        jTextField1_corona = new javax.swing.JTextField();
        jLabel_Ab18 = new javax.swing.JLabel();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(194, 100));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 370, -1));

        jLabel_productos.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_productos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_productos.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_productos.setText("Productos: ");
        getContentPane().add(jLabel_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel_Ab.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab.setText("2) Aguardiente Medio (A 1/2)");
        getContentPane().add(jLabel_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, -1));

        jLabel_Ab1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab1.setText("1) Aguardiente Botello    (A b)");
        getContentPane().add(jLabel_Ab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, -1));

        jLabel_Ab2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab2.setText("4) Ron Medio               (R 1/2)");
        getContentPane().add(jLabel_Ab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 210, -1));

        jLabel_Ab3.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab3.setText("3) Ron Botello                  (R b)");
        getContentPane().add(jLabel_Ab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, -1));

        jLabel_Ab4.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab4.setText("8) Poker                               (P)");
        getContentPane().add(jLabel_Ab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 210, -1));

        jLabel_Ab5.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab5.setText("7) Piñas");
        getContentPane().add(jLabel_Ab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, -1));

        jLabel_Ab6.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab6.setText("6) Brandy Medio          (B 1/2)");
        getContentPane().add(jLabel_Ab6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 210, -1));

        jLabel_Ab7.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab7.setText("5) Brandy Botello             (B b)");
        getContentPane().add(jLabel_Ab7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 210, -1));

        jLabel_Ab8.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab8.setText("9) Gaseosa                           (g)");
        getContentPane().add(jLabel_Ab8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 210, -1));

        jLabel_Ab9.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab9.setText("10) Agua                              (A)");
        getContentPane().add(jLabel_Ab9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 210, -1));

        jLabel_Ab10.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab10.setText("11) Gatorade                   (Get)");
        getContentPane().add(jLabel_Ab10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 220, -1));

        jLabel_Ab11.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab11.setText("12) Reedd´s                  (Reds)");
        getContentPane().add(jLabel_Ab11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 220, -1));

        jLabel_Ab12.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab12.setText("13) Club              (Ligth y club)");
        getContentPane().add(jLabel_Ab12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 210, -1));

        jLabel_Ab13.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab13.setText("14) Redbull                (Redbull)");
        getContentPane().add(jLabel_Ab13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 210, -1));

        jLabel_Ab14.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab14.setText("16) Habitaciones             (hab)");
        getContentPane().add(jLabel_Ab14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 210, -1));

        jLabel_Ab15.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab15.setText("17) Multas                       (Mult)");
        getContentPane().add(jLabel_Ab15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 210, 20));

        jLabel_Ab16.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab16.setText("16) Wisky                      (wisky)");
        getContentPane().add(jLabel_Ab16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 210, -1));

        jLabel_Ab17.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab17.setText("18) Gastos                  (gastos)");
        getContentPane().add(jLabel_Ab17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 210, 20));

        jTextField1_A_caneco.setEditable(false);
        jTextField1_A_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_A_caneco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_A_canecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_A_canecoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_A_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 75, -1));

        jTextField1_Ab.setEditable(false);
        jTextField1_Ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Ab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_AbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_AbKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 75, -1));

        jTextField1_R_caneco.setEditable(false);
        jTextField1_R_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_R_caneco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_R_canecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_R_canecoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_R_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 75, -1));

        jTextField1_Rb.setEditable(false);
        jTextField1_Rb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Rb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_RbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_RbKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 75, -1));

        jTextField1_Bb.setEditable(false);
        jTextField1_Bb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Bb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_BbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_BbKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 75, -1));

        jTextField1_B_caneco.setEditable(false);
        jTextField1_B_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_B_caneco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_B_canecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_B_canecoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_B_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 75, -1));

        jTextField1_piñas.setEditable(false);
        jTextField1_piñas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_piñas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_piñasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_piñasKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_piñas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 75, -1));

        jTextField1_poker.setEditable(false);
        jTextField1_poker.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_poker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_pokerKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_pokerKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_poker, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 75, -1));

        jTextField1_gaseosa.setEditable(false);
        jTextField1_gaseosa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gaseosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 75, -1));

        jTextField1_agua.setEditable(false);
        jTextField1_agua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_aguaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_aguaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 75, -1));

        jTextField1_gatorade.setEditable(false);
        jTextField1_gatorade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatoradeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatoradeKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 75, -1));

        jTextField1_redds.setEditable(false);
        jTextField1_redds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_reddsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_reddsKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 75, -1));

        jTextField1_club.setEditable(false);
        jTextField1_club.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_clubKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_clubKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 75, -1));

        jTextField1_redbull.setEditable(false);
        jTextField1_redbull.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbullKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbullKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 75, -1));

        jTextField1_wisky.setEditable(false);
        jTextField1_wisky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gastos1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 75, -1));

        jTextField1_resul_A_caneco.setEditable(false);
        jTextField1_resul_A_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_A_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 110, -1));

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Lo que Hay:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 90, -1));

        jTextField1_Ab1.setEditable(false);
        jTextField1_Ab1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_Ab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 75, -1));

        jTextField1_A_caneco1.setEditable(false);
        jTextField1_A_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_A_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 75, -1));

        jTextField1_Rb1.setEditable(false);
        jTextField1_Rb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_Rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 75, -1));

        jTextField1_R_caneco1.setEditable(false);
        jTextField1_R_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_R_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 75, -1));

        jTextField1_Bb1.setEditable(false);
        jTextField1_Bb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_Bb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 75, -1));

        jTextField1_B_caneco1.setEditable(false);
        jTextField1_B_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_B_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 75, -1));

        jTextField1_piñas1.setEditable(false);
        jTextField1_piñas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_piñas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 75, -1));

        jTextField1_poker1.setEditable(false);
        jTextField1_poker1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_poker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 75, -1));

        jTextField1_gaseosa1.setEditable(false);
        jTextField1_gaseosa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_gaseosa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 75, -1));

        jTextField1_agua1.setEditable(false);
        jTextField1_agua1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_agua1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_agua1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 75, -1));

        jTextField1_gatorade1.setEditable(false);
        jTextField1_gatorade1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 75, -1));

        jTextField1_redds1.setEditable(false);
        jTextField1_redds1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redds1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redds1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 75, -1));

        jTextField1_club1.setEditable(false);
        jTextField1_club1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_club1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_club1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 75, -1));

        jTextField1_redbull1.setEditable(false);
        jTextField1_redbull1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbull1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbull1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 75, -1));

        jTextField1_habitaciones1.setEditable(false);
        jTextField1_habitaciones1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_habitaciones1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_habitaciones1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_habitaciones1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_habitaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 75, -1));

        jTextField1_multas1.setEditable(false);
        jTextField1_multas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_multas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_multas1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_multas1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_multas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, 75, -1));

        jTextField1_wisky1.setEditable(false);
        jTextField1_wisky1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_wisky1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_wisky1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 75, -1));

        jTextField1_gastos1.setEditable(false);
        jTextField1_gastos1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gastos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gastos1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gastos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 75, -1));

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("Lo que Habia:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jLabel3_titulo_resul_inve.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_titulo_resul_inve.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve.setText("Resultado del Inventario:");
        getContentPane().add(jLabel3_titulo_resul_inve, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 180, -1));

        jTextField1_resul_Ab.setEditable(false);
        jTextField1_resul_Ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 110, -1));

        jTextField1_resul_Rb.setEditable(false);
        jTextField1_resul_Rb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 110, -1));

        jTextField1_resul_R_caneco.setEditable(false);
        jTextField1_resul_R_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_R_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 110, -1));

        jTextField1_resul_Bb.setEditable(false);
        jTextField1_resul_Bb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 110, -1));

        jTextField1_resul_B_caneco.setEditable(false);
        jTextField1_resul_B_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_B_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 110, -1));

        jTextField1_resul_piñas.setEditable(false);
        jTextField1_resul_piñas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_piñas, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 110, -1));

        jTextField1_resul_poker.setEditable(false);
        jTextField1_resul_poker.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_poker, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 110, -1));

        jTextField1_resul_gaseosa.setEditable(false);
        jTextField1_resul_gaseosa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 110, -1));

        jTextField1_resul_agua.setEditable(false);
        jTextField1_resul_agua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 110, -1));

        jTextField1_resul_gatorade.setEditable(false);
        jTextField1_resul_gatorade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 110, -1));

        jTextField1_resul_redds.setEditable(false);
        jTextField1_resul_redds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redds, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 110, -1));

        jTextField1_resul_club.setEditable(false);
        jTextField1_resul_club.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 110, -1));

        jTextField1_resul_redbull.setEditable(false);
        jTextField1_resul_redbull.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redbull, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 110, -1));

        jTextField1_resul_habitaciones.setEditable(false);
        jTextField1_resul_habitaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_habitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 110, -1));

        jTextField1_resul_multas.setEditable(false);
        jTextField1_resul_multas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_multas, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 640, 110, -1));

        jTextField1_resul_wisky.setEditable(false);
        jTextField1_resul_wisky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_wisky, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 110, -1));

        jTextField1_resul_gastos.setEditable(false);
        jTextField1_resul_gastos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 670, 110, -1));

        jLabel_resultado.setBackground(new java.awt.Color(102, 255, 255));
        jLabel_resultado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_resultado.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_resultado.setText("Venta total:");
        getContentPane().add(jLabel_resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 690, 90, -1));

        jTextField1_resul_total.setEditable(false);
        jTextField1_resul_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 660, 110, 30));

        jButton2_salir.setBackground(new java.awt.Color(0, 153, 255));
        jButton2_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton2_salir.setText("Salir");
        jButton2_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 90, 30));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 170, 20));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 190, 20));

        jLabel1_buscar_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1_buscar_fecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_buscar_fecha.setText("Ingrese la fecha a Buscar:");
        getContentPane().add(jLabel1_buscar_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ejemplo: (2017-09-24)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 85, 150, -1));

        jButton1_historial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton1_historial.setText("Buscar");
        jButton1_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_historialActionPerformed(evt);
            }
        });
        jButton1_historial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1_historialKeyPressed(evt);
            }
        });
        getContentPane().add(jButton1_historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 60, 110, 25));

        jLabel4_fecha_buscada.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_fecha_buscada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4_fecha_buscada.setForeground(new java.awt.Color(101, 255, 255));
        getContentPane().add(jLabel4_fecha_buscada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 20));

        jLabel4_titulo.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_titulo.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_titulo.setText("Inventario del Dia:");
        getContentPane().add(jLabel4_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 20));

        jTextField1_buscar_fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_buscar_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_buscar_fechaKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_buscar_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 60, 140, -1));

        jLabel3_titulo_resul_inve1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_titulo_resul_inve1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve1.setText("Lo que Salio:");
        getContentPane().add(jLabel3_titulo_resul_inve1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 93, -1));

        jTextField1_resul_Ab1_salio.setEditable(false);
        jTextField1_resul_Ab1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Ab1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 75, -1));

        jTextField1_resul_A_caneco1_salio.setEditable(false);
        jTextField1_resul_A_caneco1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_A_caneco1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 75, -1));

        jTextField1_resul_Rb1_salio.setEditable(false);
        jTextField1_resul_Rb1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Rb1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 75, -1));

        jTextField1_resul_R_caneco1_salio.setEditable(false);
        jTextField1_resul_R_caneco1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_R_caneco1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 75, -1));

        jTextField1_resul_Bb1_salio.setEditable(false);
        jTextField1_resul_Bb1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Bb1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 75, -1));

        jTextField1_resul_B_caneco1_salio.setEditable(false);
        jTextField1_resul_B_caneco1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_B_caneco1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 75, -1));

        jTextField1_resul_piñas1_salio.setEditable(false);
        jTextField1_resul_piñas1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_piñas1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 75, -1));

        jTextField1_resul_poker1_salio.setEditable(false);
        jTextField1_resul_poker1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_poker1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 75, -1));

        jTextField1_resul_gaseosa1_salio.setEditable(false);
        jTextField1_resul_gaseosa1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gaseosa1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 75, -1));

        jTextField1_resul_agua1_salio.setEditable(false);
        jTextField1_resul_agua1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_agua1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 75, -1));

        jTextField1_resul_gatorade1_salio.setEditable(false);
        jTextField1_resul_gatorade1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gatorade1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 75, -1));

        jTextField1_resul_redds1_salio.setEditable(false);
        jTextField1_resul_redds1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redds1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 75, -1));

        jTextField1_resul_club1_salio.setEditable(false);
        jTextField1_resul_club1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_club1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 75, -1));

        jTextField1_resul_redbull1_salio.setEditable(false);
        jTextField1_resul_redbull1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redbull1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 75, -1));

        jTextField1_resul_wisky1_salio.setEditable(false);
        jTextField1_resul_wisky1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_wisky1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 580, 75, -1));

        jTextField1_resul_habitaciones1_salio.setEditable(false);
        jTextField1_resul_habitaciones1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_habitaciones1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 610, 75, -1));

        jTextField1_resul_multas1_salio.setEditable(false);
        jTextField1_resul_multas1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_multas1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 640, 75, -1));

        jTextField1_resul_gastos1_salio.setEditable(false);
        jTextField1_resul_gastos1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gastos1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 670, 75, -1));

        jTextField1_resul_corona.setEditable(false);
        jTextField1_resul_corona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 550, 110, -1));

        jTextField1_resul_corona1_salio.setEditable(false);
        jTextField1_resul_corona1_salio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_corona1_salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 75, -1));

        jTextField1_corona1.setEditable(false);
        jTextField1_corona1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_corona1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_corona1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 75, -1));

        jTextField1_corona.setEditable(false);
        jTextField1_corona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_coronajTextField1_gastos1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 75, -1));

        jLabel_Ab18.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab18.setText("15) Corona          (Cer.corona)");
        getContentPane().add(jLabel_Ab18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 210, -1));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        jLabel1_fondo.setPreferredSize(new java.awt.Dimension(910, 830));
        jLabel1_fondo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel1_fondoKeyTyped(evt);
            }
        });
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_A_canecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_canecoKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_Rb.requestFocus();
            jTextField1_Rb.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_A_canecoKeyPressed

    private void jTextField1_RbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_RbKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_R_caneco.requestFocus();
            jTextField1_R_caneco.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_RbKeyPressed

    private void jTextField1_R_canecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_canecoKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_Bb.requestFocus();
            jTextField1_Bb.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_R_canecoKeyPressed

    private void jTextField1_BbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_BbKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_B_caneco.requestFocus();
            jTextField1_B_caneco.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_BbKeyPressed

    private void jTextField1_B_canecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_canecoKeyPressed


        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_piñas.requestFocus();
            jTextField1_piñas.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_B_canecoKeyPressed

    private void jTextField1_piñasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñasKeyPressed


        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_poker.requestFocus();
            jTextField1_poker.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_piñasKeyPressed

    private void jTextField1_pokerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_pokerKeyPressed


        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_gaseosa.requestFocus();
            jTextField1_gaseosa.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_pokerKeyPressed

    private void jTextField1_gaseosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosaKeyPressed
 

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_agua.requestFocus();
            jTextField1_agua.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gaseosaKeyPressed

    private void jTextField1_aguaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_aguaKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_gatorade.requestFocus();
            jTextField1_gatorade.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_aguaKeyPressed

    private void jTextField1_gatoradeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatoradeKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_redds.requestFocus();
            jTextField1_redds.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gatoradeKeyPressed

    private void jTextField1_reddsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_reddsKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_club.requestFocus();
            jTextField1_club.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_reddsKeyPressed

    private void jTextField1_clubKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_clubKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            jTextField1_redbull.requestFocus();
            jTextField1_redbull.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_clubKeyPressed

    private void jTextField1_redbullKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbullKeyPressed

    }//GEN-LAST:event_jTextField1_redbullKeyPressed

    private void jTextField1_AbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_AbKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_AbKeyTyped

    private void jTextField1_A_canecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_canecoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_A_canecoKeyTyped

    private void jTextField1_RbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_RbKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_RbKeyTyped

    private void jTextField1_R_canecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_canecoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_R_canecoKeyTyped

    private void jTextField1_BbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_BbKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_BbKeyTyped

    private void jTextField1_B_canecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_canecoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_B_canecoKeyTyped

    private void jTextField1_piñasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñasKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_piñasKeyTyped

    private void jTextField1_pokerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_pokerKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_pokerKeyTyped

    private void jLabel1_fondoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1_fondoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jLabel1_fondoKeyTyped

    private void jTextField1_gaseosaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosaKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gaseosaKeyTyped

    private void jTextField1_aguaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_aguaKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_aguaKeyTyped

    private void jTextField1_gatoradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatoradeKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gatoradeKeyTyped

    private void jTextField1_reddsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_reddsKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_reddsKeyTyped

    private void jTextField1_clubKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_clubKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_clubKeyTyped

    private void jTextField1_redbullKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbullKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que 
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redbullKeyTyped

    private void jTextField1_agua1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_gatorade1.requestFocus();
            jTextField1_gatorade1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_agua1KeyPressed

    private void jTextField1_agua1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_agua1KeyTyped

    private void jTextField1_gatorade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_redds1.requestFocus();
            jTextField1_redds1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gatorade1KeyPressed

    private void jTextField1_gatorade1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gatorade1KeyTyped

    private void jTextField1_redds1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_club1.requestFocus();
            jTextField1_club1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redds1KeyPressed

    private void jTextField1_redds1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redds1KeyTyped

    private void jTextField1_club1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_redbull1.requestFocus();
            jTextField1_redbull1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_club1KeyPressed

    private void jTextField1_club1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_club1KeyTyped

    private void jTextField1_redbull1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_habitaciones1.requestFocus();
            jTextField1_habitaciones1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redbull1KeyPressed

    private void jTextField1_redbull1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redbull1KeyTyped

    private void jTextField1_habitaciones1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_habitaciones1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_multas1.requestFocus();
            jTextField1_multas1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_habitaciones1KeyPressed

    private void jTextField1_habitaciones1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_habitaciones1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_habitaciones1KeyTyped

    private void jTextField1_wisky1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_gastos1.requestFocus();
            jTextField1_gastos1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_wisky1KeyPressed

    private void jTextField1_wisky1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_wisky1KeyTyped

    private void jTextField1_AbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_AbKeyPressed
        // TODO add your handling code here:

        int entrada = 40;

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_A_caneco.requestFocus();
            jTextField1_A_caneco.setFocusable(true);
        }

    }//GEN-LAST:event_jTextField1_AbKeyPressed

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
            System.out.println("exepcion = "+e);
        }
    }//GEN-LAST:event_jButton2_salirActionPerformed

    private void jTextField1_multas1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_multas1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada = evt.getKeyChar();
        if (entrada < '0' || entrada > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_multas1KeyTyped

    private void jTextField1_multas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_multas1KeyPressed
        // TODO add your handling code here:

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_wisky1.requestFocus();
            jTextField1_wisky1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_multas1KeyPressed

    private void jButton1_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_historialActionPerformed
        // TODO add your handling code here:       
        String fecha_a_buscar = jTextField1_buscar_fecha.getText();
        ImageIcon icono = new ImageIcon("src/Imagenes/chicas_1.png");
        
        if (fecha_a_buscar.equals("")) 
        {
            JOptionPane.showMessageDialog(null,"Ingrese la fecha del Inventario que desea buscar \n"
                            + " ", "Inventario", JOptionPane.WARNING_MESSAGE,icono);            
        }
        else
        {           
            buscar_fecha(fecha_a_buscar);                       
        }                                                        
    }//GEN-LAST:event_jButton1_historialActionPerformed

    private void jButton1_historialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1_historialKeyPressed
                        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {                        
            this.jButton1_historial.doClick();            
        }        
    }//GEN-LAST:event_jButton1_historialKeyPressed

    private void jTextField1_gastos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gastos1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_gastos1KeyTyped

    private void jTextField1_buscar_fechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_buscar_fechaKeyPressed
        
         
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {                        
            jButton1_historial.requestFocus();
        }
    }//GEN-LAST:event_jTextField1_buscar_fechaKeyPressed

    private void jTextField1_corona1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_corona1KeyPressed

    private void jTextField1_corona1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_corona1KeyTyped

    private void jTextField1_coronajTextField1_gastos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_coronajTextField1_gastos1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_coronajTextField1_gastos1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Historial_inventario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_historial;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_buscar_fecha;
    public javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel3_titulo_resul_inve;
    private javax.swing.JLabel jLabel3_titulo_resul_inve1;
    private javax.swing.JLabel jLabel4_fecha_buscada;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel4_titulo;
    private javax.swing.JLabel jLabel_Ab;
    private javax.swing.JLabel jLabel_Ab1;
    private javax.swing.JLabel jLabel_Ab10;
    private javax.swing.JLabel jLabel_Ab11;
    private javax.swing.JLabel jLabel_Ab12;
    private javax.swing.JLabel jLabel_Ab13;
    private javax.swing.JLabel jLabel_Ab14;
    private javax.swing.JLabel jLabel_Ab15;
    private javax.swing.JLabel jLabel_Ab16;
    private javax.swing.JLabel jLabel_Ab17;
    private javax.swing.JLabel jLabel_Ab18;
    private javax.swing.JLabel jLabel_Ab2;
    private javax.swing.JLabel jLabel_Ab3;
    private javax.swing.JLabel jLabel_Ab4;
    private javax.swing.JLabel jLabel_Ab5;
    private javax.swing.JLabel jLabel_Ab6;
    private javax.swing.JLabel jLabel_Ab7;
    private javax.swing.JLabel jLabel_Ab8;
    private javax.swing.JLabel jLabel_Ab9;
    private javax.swing.JLabel jLabel_productos;
    private javax.swing.JLabel jLabel_resultado;
    private javax.swing.JLabel jLabel_titulo;
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
    private javax.swing.JTextField jTextField1_buscar_fecha;
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
