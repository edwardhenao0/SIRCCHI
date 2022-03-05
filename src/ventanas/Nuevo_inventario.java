
package ventanas;

import conexion_SQL.ConexionMySQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class Nuevo_inventario extends javax.swing.JFrame implements ActionListener
{

    //Atributos y variables
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    
    Inventario ventana_inventario = new Inventario(); 
    
    ConexionMySQL conexion_1 = new ConexionMySQL();
    Connection conexion_SQL = conexion_1.conectar();       
    
    public Nuevo_inventario() 
    {
        initComponents();
        jLabel1_fondo.setVerticalAlignment(jLabel1_fondo.CENTER);
        jLabel1_fondo.setHorizontalAlignment(jLabel1_fondo.CENTER);        
        
        jLabel3_fecha.setText(fecha_sistema());
        
        setTitle("Nuevo Inventario");
        jLabel_titulo.setVerticalAlignment(jLabel_titulo.CENTER);
        jLabel_titulo.setHorizontalAlignment(jLabel_titulo.CENTER);
        this.setLocationRelativeTo(null);
        jTextField1_Ab_nuevo.requestFocus();
        jTextField1_Ab_nuevo.setFocusable(true);
        
        
        jTextField1_Ab1.setText(ventana_inventario.dato_campo_1);
        jTextField1_A_caneco1.setText(ventana_inventario.dato_campo_2);
        jTextField1_Rb1.setText(ventana_inventario.dato_campo_3);
        jTextField1_R_caneco1.setText(ventana_inventario.dato_campo_4);
        jTextField1_Bb1.setText(ventana_inventario.dato_campo_5);
        jTextField1_B_caneco1.setText(ventana_inventario.dato_campo_6);
        jTextField1_piñas1.setText(ventana_inventario.dato_campo_7);
        jTextField1_poker1.setText(ventana_inventario.dato_campo_8);
        jTextField1_gaseosa1.setText(ventana_inventario.dato_campo_9);
        jTextField1_agua1.setText(ventana_inventario.dato_campo_10);
        jTextField1_gatorade1.setText(ventana_inventario.dato_campo_11);
        jTextField1_redds1.setText(ventana_inventario.dato_campo_12);
        jTextField1_club1.setText(ventana_inventario.dato_campo_13);
        jTextField1_redbull1.setText(ventana_inventario.dato_campo_14);
        jTextField1_corona1.setText(ventana_inventario.dato_campo_15);
        jTextField1_wisky1.setText(ventana_inventario.dato_campo_16);
        
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
    
    //Metodo para obtener la fecha del registro
    private String fecha_registro() 
    {       
        SimpleDateFormat formato_sql = new SimpleDateFormat("yyyy-MM-dd");//2018-09-09 19:52:54
        Date now = new Date();
        String variable_fecha = formato_sql.format(now);        

        return variable_fecha; 
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Ab = new javax.swing.JLabel();
        jLabel_productos = new javax.swing.JLabel();
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
        jLabel_Ab16 = new javax.swing.JLabel();
        jTextField1_A_caneco_nuevo = new javax.swing.JTextField();
        jTextField1_Ab_nuevo = new javax.swing.JTextField();
        jTextField1_R_caneco_nuevo = new javax.swing.JTextField();
        jTextField1_Rb_nuevo = new javax.swing.JTextField();
        jTextField1_Bb_nuevo = new javax.swing.JTextField();
        jTextField1_B_caneco_nuevo = new javax.swing.JTextField();
        jTextField1_piñas_nuevo = new javax.swing.JTextField();
        jTextField1_poker_nuevo = new javax.swing.JTextField();
        jTextField1_gaseosa_nuevo = new javax.swing.JTextField();
        jTextField1_agua_nuevo = new javax.swing.JTextField();
        jTextField1_gatorade_nuevo = new javax.swing.JTextField();
        jTextField1_redds_nuevo = new javax.swing.JTextField();
        jTextField1_club_nuevo = new javax.swing.JTextField();
        jTextField1_redbull_nuevo = new javax.swing.JTextField();
        jTextField1_wisky_nuevo = new javax.swing.JTextField();
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
        jTextField1_wisky1 = new javax.swing.JTextField();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3_titulo_resul_inve = new javax.swing.JLabel();
        jTextField1_resul_Ab = new javax.swing.JTextField();
        jTextField1_resul_A_caneco = new javax.swing.JTextField();
        jTextField1_resul_redbull = new javax.swing.JTextField();
        jTextField1_resul_club = new javax.swing.JTextField();
        jTextField1_resul_redds = new javax.swing.JTextField();
        jTextField1_resul_gatorade = new javax.swing.JTextField();
        jTextField1_resul_agua = new javax.swing.JTextField();
        jTextField1_resul_gaseosa = new javax.swing.JTextField();
        jTextField1_resul_poker = new javax.swing.JTextField();
        jTextField1_resul_piñas = new javax.swing.JTextField();
        jTextField1_resul_B_caneco = new javax.swing.JTextField();
        jTextField1_resul_Bb = new javax.swing.JTextField();
        jTextField1_resul_R_caneco = new javax.swing.JTextField();
        jTextField1_resul_Rb = new javax.swing.JTextField();
        jTextField1_resul_wisky = new javax.swing.JTextField();
        jButton1_nue_inventario = new javax.swing.JButton();
        jButton2_salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1_guardar = new javax.swing.JButton();
        jLabel3_fecha = new javax.swing.JLabel();
        jLabel4_hora = new javax.swing.JLabel();
        jLabel_wisky15 = new javax.swing.JLabel();
        jTextField1_corona1 = new javax.swing.JTextField();
        jTextField1_corona_nuevo = new javax.swing.JTextField();
        jTextField1_resul_corona = new javax.swing.JTextField();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(980, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Ab.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab.setText("2) Aguardiente Medio ( A 1/2)");
        getContentPane().add(jLabel_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, -1));

        jLabel_productos.setBackground(new java.awt.Color(153, 255, 255));
        jLabel_productos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_productos.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_productos.setText("Productos: ");
        getContentPane().add(jLabel_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel_Ab1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab1.setText("1) Aguardiente Botello ( A b)");
        getContentPane().add(jLabel_Ab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, -1));

        jLabel_Ab2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab2.setText("4) Ron Medio ( R 1/2)");
        getContentPane().add(jLabel_Ab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, -1));

        jLabel_Ab3.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab3.setText("3) Ron Botello ( R b)");
        getContentPane().add(jLabel_Ab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, -1));

        jLabel_Ab4.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab4.setText("8) Poker ( P )");
        getContentPane().add(jLabel_Ab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 210, -1));

        jLabel_Ab5.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab5.setText("7) Piñas");
        getContentPane().add(jLabel_Ab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 210, -1));

        jLabel_Ab6.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab6.setText("6) Brandy Medio ( B 1/2)");
        getContentPane().add(jLabel_Ab6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 210, -1));

        jLabel_Ab7.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab7.setText("5) Brandy Botello ( B b)");
        getContentPane().add(jLabel_Ab7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 210, -1));

        jLabel_Ab8.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab8.setText("9) Gaseosa ( g)");
        getContentPane().add(jLabel_Ab8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 210, -1));

        jLabel_Ab9.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab9.setText("10) Agua ( A )");
        getContentPane().add(jLabel_Ab9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 210, -1));

        jLabel_Ab10.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab10.setText("11) Gatorade ( Get)");
        getContentPane().add(jLabel_Ab10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 210, -1));

        jLabel_Ab11.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab11.setText("12) Reedd´s ( Reds)");
        getContentPane().add(jLabel_Ab11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 210, -1));

        jLabel_Ab12.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab12.setText("13) Club (ligth y club )");
        getContentPane().add(jLabel_Ab12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 210, -1));

        jLabel_Ab13.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab13.setText("14) Redbull ( redbull)");
        getContentPane().add(jLabel_Ab13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 210, -1));

        jLabel_Ab16.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_Ab16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Ab16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ab16.setText("16) Wisky ( wisky)");
        getContentPane().add(jLabel_Ab16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 210, -1));

        jTextField1_A_caneco_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_A_caneco_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_A_caneco_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 130, 60, -1));

        jTextField1_Ab_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Ab_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Ab_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Ab_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Ab_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 100, 60, -1));

        jTextField1_R_caneco_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_R_caneco_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_R_caneco_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 190, 60, -1));

        jTextField1_Rb_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Rb_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Rb_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Rb_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Rb_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 160, 60, -1));

        jTextField1_Bb_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Bb_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Bb_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Bb_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Bb_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 220, 60, -1));

        jTextField1_B_caneco_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_B_caneco_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_B_caneco_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 250, 60, -1));

        jTextField1_piñas_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_piñas_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_piñas_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_piñas_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_piñas_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 280, 60, -1));

        jTextField1_poker_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_poker_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_poker_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_poker_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_poker_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 310, 60, -1));

        jTextField1_gaseosa_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gaseosa_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gaseosa_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 340, 60, -1));

        jTextField1_agua_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_agua_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_agua_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 370, 60, -1));

        jTextField1_gatorade_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 400, 60, -1));

        jTextField1_redds_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redds_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redds_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 430, 60, -1));

        jTextField1_club_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_club_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_club_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 460, 60, -1));

        jTextField1_redbull_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbull_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbull_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 490, 60, -1));

        jTextField1_wisky_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_wisky_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_wisky_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 550, 60, -1));

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Nuevo Surtio:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 100, -1));

        jTextField1_Ab1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Ab1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Ab1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Ab1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Ab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 60, -1));

        jTextField1_A_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_A_caneco1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_A_caneco1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_A_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 60, -1));

        jTextField1_Rb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Rb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Rb1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Rb1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 60, -1));

        jTextField1_R_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_R_caneco1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_R_caneco1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_R_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 60, -1));

        jTextField1_Bb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_Bb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_Bb1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_Bb1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_Bb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 60, -1));

        jTextField1_B_caneco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_B_caneco1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_B_caneco1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_B_caneco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 60, -1));

        jTextField1_piñas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_piñas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_piñas1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_piñas1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_piñas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 60, -1));

        jTextField1_poker1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_poker1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_poker1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_poker1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_poker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 60, -1));

        jTextField1_gaseosa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gaseosa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gaseosa1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gaseosa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 60, -1));

        jTextField1_agua1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_agua1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_agua1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_agua1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_agua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 60, -1));

        jTextField1_gatorade1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_gatorade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_gatorade1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_gatorade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 60, -1));

        jTextField1_redds1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redds1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redds1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redds1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redds1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 60, -1));

        jTextField1_club1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_club1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_club1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_club1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_club1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 60, -1));

        jTextField1_redbull1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_redbull1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_redbull1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_redbull1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_redbull1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 60, -1));

        jTextField1_wisky1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_wisky1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_wisky1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_wisky1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 60, -1));

        jLabel_titulo.setBackground(new java.awt.Color(51, 0, 255));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(102, 255, 255));
        jLabel_titulo.setText("CASA SHOW LAS MUÑECAS INVENTARIO VER 1.0");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("Lo que Habia:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 100, -1));

        jLabel3_titulo_resul_inve.setBackground(new java.awt.Color(153, 255, 255));
        jLabel3_titulo_resul_inve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_titulo_resul_inve.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_titulo_resul_inve.setText("Nuevo Inventario:");
        getContentPane().add(jLabel3_titulo_resul_inve, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 130, -1));

        jTextField1_resul_Ab.setEditable(false);
        jTextField1_resul_Ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Ab, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 60, -1));

        jTextField1_resul_A_caneco.setEditable(false);
        jTextField1_resul_A_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_A_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 60, -1));

        jTextField1_resul_redbull.setEditable(false);
        jTextField1_resul_redbull.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redbull, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 60, -1));

        jTextField1_resul_club.setEditable(false);
        jTextField1_resul_club.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_club, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 60, -1));

        jTextField1_resul_redds.setEditable(false);
        jTextField1_resul_redds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_redds, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 60, -1));

        jTextField1_resul_gatorade.setEditable(false);
        jTextField1_resul_gatorade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gatorade, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 60, -1));

        jTextField1_resul_agua.setEditable(false);
        jTextField1_resul_agua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_agua, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 60, -1));

        jTextField1_resul_gaseosa.setEditable(false);
        jTextField1_resul_gaseosa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_gaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 60, -1));

        jTextField1_resul_poker.setEditable(false);
        jTextField1_resul_poker.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_poker, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 60, -1));

        jTextField1_resul_piñas.setEditable(false);
        jTextField1_resul_piñas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_piñas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 60, -1));

        jTextField1_resul_B_caneco.setEditable(false);
        jTextField1_resul_B_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_B_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 60, -1));

        jTextField1_resul_Bb.setEditable(false);
        jTextField1_resul_Bb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Bb, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 60, -1));

        jTextField1_resul_R_caneco.setEditable(false);
        jTextField1_resul_R_caneco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_R_caneco, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 60, -1));

        jTextField1_resul_Rb.setEditable(false);
        jTextField1_resul_Rb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 60, -1));

        jTextField1_resul_wisky.setEditable(false);
        jTextField1_resul_wisky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_wisky, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 60, -1));

        jButton1_nue_inventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_nue_inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2.png"))); // NOI18N
        jButton1_nue_inventario.setText("Inventariar");
        jButton1_nue_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_nue_inventarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_nue_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 545, 125, 30));

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

        jLabel3.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nuevo Inventario ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jButton1_guardar.setBackground(new java.awt.Color(153, 153, 255));
        jButton1_guardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar_1.png"))); // NOI18N
        jButton1_guardar.setText("Guardar");
        jButton1_guardar.setPreferredSize(new java.awt.Dimension(121, 25));
        jButton1_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 545, 120, 30));

        jLabel3_fecha.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3_fecha.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 190, 20));

        jLabel4_hora.setBackground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4_hora.setForeground(new java.awt.Color(101, 255, 255));
        jLabel4_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 180, 20));

        jLabel_wisky15.setBackground(new java.awt.Color(0, 51, 204));
        jLabel_wisky15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_wisky15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_wisky15.setText("15) Corona ( Cer.corona)");
        getContentPane().add(jLabel_wisky15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 210, -1));

        jTextField1_corona1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_corona1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_corona1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 60, -1));

        jTextField1_corona_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1_corona_nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_corona_nuevoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_corona_nuevoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1_corona_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 520, 60, -1));

        jTextField1_resul_corona.setEditable(false);
        jTextField1_resul_corona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextField1_resul_corona, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 60, -1));

        jLabel1_fondo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        jLabel1_fondo.setPreferredSize(new java.awt.Dimension(980, 600));
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para generar nuevo inventario
    public static String nuevo_inventario(int a, int b)
    {
        String resultado;        
        resultado = String.valueOf((a + b));
        
        return resultado;
    }
                    
    private void jTextField1_A_caneco_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_caneco_nuevoKeyPressed

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Rb_nuevo.requestFocus();
            jTextField1_Rb_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_A_caneco_nuevoKeyPressed

    private void jTextField1_A_caneco_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_A_caneco_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_A_caneco_nuevoKeyTyped

    private void jTextField1_Ab_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Ab_nuevoKeyPressed
        // TODO add your handling code here:

        ////int entrada = 40;
        ////jTextField1_Ab.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField1_A_caneco_nuevo.requestFocus();
            jTextField1_A_caneco_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Ab_nuevoKeyPressed

    private void jTextField1_Ab_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Ab_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField1_Ab_nuevoKeyTyped

    private void jTextField1_R_caneco_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_caneco_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=40;
        //jTextField1_R_caneco.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_Bb_nuevo.requestFocus();
            jTextField1_Bb_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_R_caneco_nuevoKeyPressed

    private void jTextField1_R_caneco_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_R_caneco_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_R_caneco_nuevoKeyTyped

    private void jTextField1_Rb_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Rb_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=40;
        //jTextField1_Rb.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_R_caneco_nuevo.requestFocus();
            jTextField1_R_caneco_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Rb_nuevoKeyPressed

    private void jTextField1_Rb_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Rb_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Rb_nuevoKeyTyped

    private void jTextField1_Bb_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Bb_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=40;
        //jTextField1_Bb.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_B_caneco_nuevo.requestFocus();
            jTextField1_B_caneco_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_Bb_nuevoKeyPressed

    private void jTextField1_Bb_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_Bb_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_Bb_nuevoKeyTyped

    private void jTextField1_B_caneco_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_caneco_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=40;
        //jTextField1_B_caneco.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_piñas_nuevo.requestFocus();
            jTextField1_piñas_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_B_caneco_nuevoKeyPressed

    private void jTextField1_B_caneco_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_B_caneco_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_B_caneco_nuevoKeyTyped

    private void jTextField1_piñas_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñas_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=30;
        //jTextField1_piñas.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_poker_nuevo.requestFocus();
            jTextField1_poker_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_piñas_nuevoKeyPressed

    private void jTextField1_piñas_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_piñas_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_piñas_nuevoKeyTyped

    private void jTextField1_poker_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_poker_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=550;
        //jTextField1_poker.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gaseosa_nuevo.requestFocus();
            jTextField1_gaseosa_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_poker_nuevoKeyPressed

    private void jTextField1_poker_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_poker_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_poker_nuevoKeyTyped

    private void jTextField1_gaseosa_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosa_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=250;
        //jTextField1_gaseosa.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_agua_nuevo.requestFocus();
            jTextField1_agua_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gaseosa_nuevoKeyPressed

    private void jTextField1_gaseosa_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gaseosa_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gaseosa_nuevoKeyTyped

    private void jTextField1_agua_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=80;
        //jTextField1_agua.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_gatorade_nuevo.requestFocus();
            jTextField1_gatorade_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_agua_nuevoKeyPressed

    private void jTextField1_agua_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_agua_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_agua_nuevoKeyTyped

    private void jTextField1_gatorade_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=60;
        //jTextField1_gatorade.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redds_nuevo.requestFocus();
            jTextField1_redds_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_gatorade_nuevoKeyPressed

    private void jTextField1_gatorade_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_gatorade_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_gatorade_nuevoKeyTyped

    private void jTextField1_redds_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=60;
        //jTextField1_redds.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_club_nuevo.requestFocus();
            jTextField1_club_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redds_nuevoKeyPressed

    private void jTextField1_redds_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redds_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redds_nuevoKeyTyped

    private void jTextField1_club_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=300;
        //jTextField1_club.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_redbull_nuevo.requestFocus();
            jTextField1_redbull_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_club_nuevoKeyPressed

    private void jTextField1_club_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_club_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_club_nuevoKeyTyped

    private void jTextField1_redbull_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull_nuevoKeyPressed
        // TODO add your handling code here:
        //int entrada=30;
        //jTextField1_redbull.setText(String.valueOf(entrada));

        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_corona_nuevo.requestFocus();
            jTextField1_corona_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_redbull_nuevoKeyPressed

    private void jTextField1_redbull_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_redbull_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_redbull_nuevoKeyTyped

    private void jTextField1_wisky_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky_nuevoKeyTyped
        // TODO add your handling code here:
        //este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_wisky_nuevoKeyTyped

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

    private void jTextField1_wisky1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky1KeyTyped
        // TODO add your handling code here:

        //Escribir solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_wisky1KeyTyped

    private void jButton1_nue_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_nue_inventarioActionPerformed
        // TODO addyour handling code here:
        ImageIcon icono = new ImageIcon("src/Imagenes/nuevo_inventario.png");
        String evento_boton3 = evt.getActionCommand();

        if (evento_boton3.equals("Inventariar"))
        {
            if (jTextField1_Ab_nuevo.getText().equals("") || jTextField1_A_caneco_nuevo.getText().equals("")
                || jTextField1_Rb_nuevo.getText().equals("") || jTextField1_R_caneco_nuevo.getText().equals("")
                || jTextField1_Bb_nuevo.getText().equals("") || jTextField1_B_caneco_nuevo.getText().equals("")
                || jTextField1_piñas_nuevo.getText().equals("") || jTextField1_poker_nuevo.getText().equals("")
                || jTextField1_gaseosa_nuevo.getText().equals("") || jTextField1_agua_nuevo.getText().equals("")
                || jTextField1_gatorade_nuevo.getText().equals("") || jTextField1_redds_nuevo.getText().equals("")
                || jTextField1_club_nuevo.getText().equals("") || jTextField1_redbull_nuevo.getText().equals("")
                || jTextField1_corona_nuevo.getText().equals("") ||  jTextField1_wisky_nuevo.getText().equals(""))
            {
                
                JOptionPane.showMessageDialog(null,"Falta al menos un Campo por llenar, \n"
                        + " Verifiquelo por favor ", "Nuevo Inventario", JOptionPane.WARNING_MESSAGE,icono);

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

                jLabel3_titulo_resul_inve.setVisible(true);
                

                //Aguardiente Botello
                int a = 0;
                String aux1;
                if (a == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_Ab_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_Ab1.getText());                    

                    aux1 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_Ab.setText((aux1));
                    //jTextField1_resul_Ab.setText("Se ha Surtido: " + mi_formato.format(aux1));
                }

                //Aguardiente Caneco
                int b = 0;
                String aux2;
                if (b == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_A_caneco_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_A_caneco1.getText());                    

                    aux2 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_A_caneco.setText(aux2);
                }

                //Ron Botello
                int c = 0;
                String aux3;
                if (c == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_Rb_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_Rb1.getText());                    

                    aux3 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_Rb.setText(aux3);
                }

                //Ron Caneco
                int d = 0;
                String aux4;
                if (d == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_R_caneco_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_R_caneco1.getText());                    

                    aux4 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_R_caneco.setText(aux4);
                }

                //Brandy Botello
                int e = 0;
                String aux5;
                if (e == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_Bb_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_Bb1.getText());                    

                    aux5 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_Bb.setText(aux5);
                }

                //Brandy Caneco
                int f = 0;
                String aux6;
                if (f == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_B_caneco_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_B_caneco1.getText());                    

                    aux6 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_B_caneco.setText(aux6);
                }

                //Piñas
                int g = 0;
                String aux7;
                if (g == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_piñas_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_piñas1.getText());                    

                    aux7 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_piñas.setText(aux7);
                }

                //poker
                int h = 0;
                String aux8;
                if (h == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_poker_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_poker1.getText());                    

                    aux8 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_poker.setText(aux8);
                }

                //gaseosa
                int i = 0;
                String aux9;
                if (i == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_gaseosa_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_gaseosa1.getText());                    

                    aux9 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_gaseosa.setText(aux9);
                }

                //Agua
                int j = 0;
                String aux10;
                if (j == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_agua_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_agua1.getText());                    

                    aux10 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_agua.setText(aux10);
                }

                //Gatorade
                int k = 0;
                String aux11;
                if (k == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_gatorade_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_gatorade1.getText());                    

                    aux11 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_gatorade.setText(aux11);
                }

                //Reddss
                int l = 0;
                String aux12;
                if (l == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_redds_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_redds1.getText());                    

                    aux12 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_redds.setText(aux12);
                }

                //Club
                int m = 0;
                String aux13;
                if (m == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_club_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_club1.getText());                    

                    aux13 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_club.setText(aux13);
                }

                //Redbull
                int n = 0;
                String aux14;
                if (n == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_redbull_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_redbull1.getText());                    

                    aux14 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_redbull.setText(aux14);
                }  
                
                //Corona
                int o = 0;
                String aux15;
                if (o == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_corona_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_corona1.getText());                    

                    aux15 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_corona.setText(aux15);                    
                }

                //Wisky
                int p = 0;
                String aux16;
                if (p == 0) {
                    int numero_1 = Integer.parseInt(jTextField1_wisky_nuevo.getText());
                    int numero_2 = Integer.parseInt(jTextField1_wisky1.getText());
                    
                    aux16 = nuevo_inventario(numero_1, numero_2);
                    jTextField1_resul_wisky.setText(aux16);                    
                }                              
            }
        }
    }//GEN-LAST:event_jButton1_nue_inventarioActionPerformed

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

    private void jButton1_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_guardarActionPerformed
                    
        ImageIcon icono = new ImageIcon("src/Imagenes/guardar_1.png");
        String eveto_bot_guar = evt.getActionCommand();
               
            if (eveto_bot_guar.equals("Guardar")) 
            {
                if (jTextField1_resul_Ab.getText().equals("") || jTextField1_resul_A_caneco.getText().equals("")
                        || jTextField1_resul_Rb.getText().equals("") || jTextField1_resul_R_caneco.getText().equals("")
                        || jTextField1_resul_Bb.getText().equals("") || jTextField1_resul_B_caneco.getText().equals("")
                        || jTextField1_resul_piñas.getText().equals("") || jTextField1_resul_poker.getText().equals("")
                        || jTextField1_resul_gaseosa.getText().equals("") || jTextField1_resul_agua.getText().equals("")
                        || jTextField1_resul_gatorade.getText().equals("") || jTextField1_resul_redds.getText().equals("")
                        || jTextField1_resul_club.getText().equals("") || jTextField1_resul_redbull.getText().equals("")
                        ||jTextField1_resul_corona.getText().equals("") || jTextField1_resul_wisky.getText().equals("")) 
                {
                    
                    JOptionPane.showMessageDialog(null, "Hay un Error, debe haber un campo vacio, corrigalo","Nuevo Inventario",JOptionPane.INFORMATION_MESSAGE,icono);
                } 
                else 
                {
                    try 
                    {
                        PreparedStatement pps = conexion_SQL.prepareStatement("INSERT INTO productos (`Fecha_inventario`,`Aguardiente Botello`, `Aguardiente Caneco`, `Ron Botello`, `Ron Caneco`, `Brandy Botello`, `Brandy Caneco`, `Piñas`, `Poker`, `Gaseosa`, `Agua`, `Gatorade`, `Reedd´s`, `Club`, `Redbull`, `Corona`, `Wisky`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                        pps.setString(1, fecha_registro());
                        pps.setString(2, jTextField1_resul_Ab.getText());
                        pps.setString(3, jTextField1_resul_A_caneco.getText());
                        pps.setString(4, jTextField1_resul_Rb.getText());
                        pps.setString(5, jTextField1_resul_R_caneco.getText());
                        pps.setString(6, jTextField1_resul_Bb.getText());
                        pps.setString(7, jTextField1_resul_B_caneco.getText());
                        pps.setString(8, jTextField1_resul_piñas.getText());
                        pps.setString(9, jTextField1_resul_poker.getText());
                        pps.setString(10, jTextField1_resul_gaseosa.getText());
                        pps.setString(11, jTextField1_resul_agua.getText());
                        pps.setString(12, jTextField1_resul_gatorade.getText());
                        pps.setString(13, jTextField1_resul_redds.getText());
                        pps.setString(14, jTextField1_resul_club.getText());
                        pps.setString(15, jTextField1_resul_redbull.getText());
                        pps.setString(16, jTextField1_resul_corona.getText());
                        pps.setString(17, jTextField1_resul_wisky.getText());
                        
                        pps.executeUpdate();                        
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Se ha Guardado el Inventario Correctamente", "Guardar",JOptionPane.INFORMATION_MESSAGE,icono);
                    jTextField1_Ab1.setText("");
                    jTextField1_Ab_nuevo.setText("");
                    jTextField1_resul_Ab.setText("");
                    
                    jTextField1_A_caneco1.setText("");
                    jTextField1_A_caneco_nuevo.setText("");
                    jTextField1_resul_A_caneco.setText("");
                    
                    jTextField1_Rb1.setText("");
                    jTextField1_Rb_nuevo.setText("");
                    jTextField1_resul_Rb.setText("");
                    
                    jTextField1_R_caneco1.setText("");
                    jTextField1_R_caneco_nuevo.setText("");
                    jTextField1_resul_R_caneco.setText("");
                    
                    jTextField1_Bb1.setText("");                    
                    jTextField1_Bb_nuevo.setText("");
                    jTextField1_resul_Bb.setText("");
                    
                    
                    jTextField1_B_caneco1.setText("");
                    jTextField1_B_caneco_nuevo.setText("");
                    jTextField1_resul_B_caneco.setText("");
                    
                    jTextField1_piñas1.setText("");
                    jTextField1_piñas_nuevo.setText("");
                    jTextField1_resul_piñas.setText("");
                    
                    jTextField1_poker1.setText("");
                    jTextField1_poker_nuevo.setText("");
                    jTextField1_resul_poker.setText("");
                    
                    jTextField1_gaseosa1.setText("");
                    jTextField1_gaseosa_nuevo.setText("");
                    jTextField1_resul_gaseosa.setText("");
                    
                    jTextField1_agua1.setText("");
                    jTextField1_agua_nuevo.setText("");
                    jTextField1_resul_agua.setText("");
                    
                    jTextField1_gatorade1.setText("");
                    jTextField1_gatorade_nuevo.setText("");
                    jTextField1_resul_gatorade.setText("");
                    
                    jTextField1_redds1.setText("");
                    jTextField1_redds_nuevo.setText("");
                    jTextField1_resul_redds.setText("");
                    
                    jTextField1_club1.setText("");
                    jTextField1_club_nuevo.setText("");
                    jTextField1_resul_club.setText("");
                    
                    jTextField1_redbull1.setText("");
                    jTextField1_redbull_nuevo.setText("");
                    jTextField1_resul_redbull.setText("");
                    
                    jTextField1_corona1.setText("");
                    jTextField1_corona_nuevo.setText("");
                    jTextField1_resul_corona.setText("");
                    
                    jTextField1_wisky1.setText("");
                    jTextField1_wisky_nuevo.setText("");
                    jTextField1_resul_wisky.setText("");
                }
            }            
    }//GEN-LAST:event_jButton1_guardarActionPerformed

    private void jTextField1_wisky_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_wisky_nuevoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {            
            jButton1_nue_inventario.setFocusable(true);
            jButton1_nue_inventario.doClick();
        }
    }//GEN-LAST:event_jTextField1_wisky_nuevoKeyPressed

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

    private void jTextField1_corona_nuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona_nuevoKeyPressed
        // TODO add your handling code here:
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_wisky_nuevo.requestFocus();
            jTextField1_wisky_nuevo.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_corona_nuevoKeyPressed

    private void jTextField1_corona_nuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona_nuevoKeyTyped
        // TODO add your handling code here:
        
        //Este metodo KeyTyped que generea un evente en la entrada al jTextField que seleccionemos
        //nos permite capturar en un char cada caracter y compararlo con lo que
        //queremos que solo se pueda digitar en este caso solo numeros
        char entrada= evt.getKeyChar();
        if (entrada<'0'||entrada>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_corona_nuevoKeyTyped

    private void jTextField1_corona1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_corona1KeyPressed
        // TODO add your handling code here:
        //Condicion para tabular con la tecla enter
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            jTextField1_wisky1.requestFocus();
            jTextField1_wisky1.setFocusable(true);
        }
    }//GEN-LAST:event_jTextField1_corona1KeyPressed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new Nuevo_inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_guardar;
    public javax.swing.JButton jButton1_nue_inventario;
    private javax.swing.JButton jButton2_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_fecha;
    private javax.swing.JLabel jLabel3_titulo_resul_inve;
    private javax.swing.JLabel jLabel4_hora;
    private javax.swing.JLabel jLabel_Ab;
    private javax.swing.JLabel jLabel_Ab1;
    private javax.swing.JLabel jLabel_Ab10;
    private javax.swing.JLabel jLabel_Ab11;
    private javax.swing.JLabel jLabel_Ab12;
    private javax.swing.JLabel jLabel_Ab13;
    private javax.swing.JLabel jLabel_Ab16;
    private javax.swing.JLabel jLabel_Ab2;
    private javax.swing.JLabel jLabel_Ab3;
    private javax.swing.JLabel jLabel_Ab4;
    private javax.swing.JLabel jLabel_Ab5;
    private javax.swing.JLabel jLabel_Ab6;
    private javax.swing.JLabel jLabel_Ab7;
    private javax.swing.JLabel jLabel_Ab8;
    private javax.swing.JLabel jLabel_Ab9;
    private javax.swing.JLabel jLabel_productos;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_wisky15;
    public javax.swing.JTextField jTextField1_A_caneco1;
    public javax.swing.JTextField jTextField1_A_caneco_nuevo;
    public javax.swing.JTextField jTextField1_Ab1;
    public javax.swing.JTextField jTextField1_Ab_nuevo;
    public javax.swing.JTextField jTextField1_B_caneco1;
    public javax.swing.JTextField jTextField1_B_caneco_nuevo;
    public javax.swing.JTextField jTextField1_Bb1;
    public javax.swing.JTextField jTextField1_Bb_nuevo;
    public javax.swing.JTextField jTextField1_R_caneco1;
    public javax.swing.JTextField jTextField1_R_caneco_nuevo;
    public javax.swing.JTextField jTextField1_Rb1;
    public javax.swing.JTextField jTextField1_Rb_nuevo;
    public javax.swing.JTextField jTextField1_agua1;
    public javax.swing.JTextField jTextField1_agua_nuevo;
    public javax.swing.JTextField jTextField1_club1;
    public javax.swing.JTextField jTextField1_club_nuevo;
    public javax.swing.JTextField jTextField1_corona1;
    public javax.swing.JTextField jTextField1_corona_nuevo;
    public javax.swing.JTextField jTextField1_gaseosa1;
    public javax.swing.JTextField jTextField1_gaseosa_nuevo;
    public javax.swing.JTextField jTextField1_gatorade1;
    public javax.swing.JTextField jTextField1_gatorade_nuevo;
    public javax.swing.JTextField jTextField1_piñas1;
    public javax.swing.JTextField jTextField1_piñas_nuevo;
    public javax.swing.JTextField jTextField1_poker1;
    public javax.swing.JTextField jTextField1_poker_nuevo;
    public javax.swing.JTextField jTextField1_redbull1;
    public javax.swing.JTextField jTextField1_redbull_nuevo;
    public javax.swing.JTextField jTextField1_redds1;
    public javax.swing.JTextField jTextField1_redds_nuevo;
    public javax.swing.JTextField jTextField1_resul_A_caneco;
    public javax.swing.JTextField jTextField1_resul_Ab;
    public javax.swing.JTextField jTextField1_resul_B_caneco;
    public javax.swing.JTextField jTextField1_resul_Bb;
    public javax.swing.JTextField jTextField1_resul_R_caneco;
    public javax.swing.JTextField jTextField1_resul_Rb;
    public javax.swing.JTextField jTextField1_resul_agua;
    public javax.swing.JTextField jTextField1_resul_club;
    public javax.swing.JTextField jTextField1_resul_corona;
    public javax.swing.JTextField jTextField1_resul_gaseosa;
    public javax.swing.JTextField jTextField1_resul_gatorade;
    public javax.swing.JTextField jTextField1_resul_piñas;
    public javax.swing.JTextField jTextField1_resul_poker;
    public javax.swing.JTextField jTextField1_resul_redbull;
    public javax.swing.JTextField jTextField1_resul_redds;
    public javax.swing.JTextField jTextField1_resul_wisky;
    public javax.swing.JTextField jTextField1_wisky1;
    public javax.swing.JTextField jTextField1_wisky_nuevo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
