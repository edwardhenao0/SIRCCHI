package conexion_SQL;

import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionMySQL         
{           
    public PreparedStatement preparar_Sentencia;
    Connection conexion_BD = null;
    ResultSet r_s;
    Statement s_t;
    
    public String db = "casa_show_las_muñecas";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
    
    public Connection conectar()
    {        
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");            
            conexion_BD = DriverManager.getConnection(this.url, this.user, this.pass);            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Error en la conexión a la BD = "+ ex);
        }
        return conexion_BD;
    }
    
    //Metodo DB desconecta
    public void desconectar()
    {
        conexion_BD = null;
        JOptionPane.showMessageDialog(null, "Desconectado de la Base de Datos: ");        
    }
}

