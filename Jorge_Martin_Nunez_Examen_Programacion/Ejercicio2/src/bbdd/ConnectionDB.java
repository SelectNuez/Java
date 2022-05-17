/*
Plantilla basica para realizar la conexion con una BBDD MySQL
 */
package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Blitz
 */
public class ConnectionDB {
    private static String db = "incidencias";
    private static String url = "jdbc:mysql://localhost/" + db;
    private static String user = "incidencias";
    private static String pass = "incidencias";
    private static Connection conn = null;

    /**
     * <p>Metodo openConnection</p>
     * 
     * <p>Este metodo se encarga de establecer la conexion a la DB.</p>
     * 
     * @return devuelve un objeto tipo Connection de la libreria "java.sql.*", 
     * en caso de poder realizar la conexion con exito.
     * 
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    
    public static Connection openConnection() {

        try {
            //cargamos el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creamos un enlace
            conn = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }
    /**
     * <p>Metodo closeConnection</p>
     * 
     * <p>Este metodo se encarga de cerrar la conexion a la DB.</p>
     * 
     * @author Jorge Martin
     */
    
    public static void closeConnection() {
        try {
            ConnectionDB.conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }

    }
}
