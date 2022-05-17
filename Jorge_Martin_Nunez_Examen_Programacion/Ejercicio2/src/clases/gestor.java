package clases;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilidades.*;

/**
 *
 * @author Jorge Martin
 */
public class gestor {

    public gestor() {
    }
/**
 * Comprueba si existe el tipo de incidencia
 * @param id_tipo Tipo de incidencia
 * @param con Conexion con la base de datos
 * @return true si existe, false si no
 */
    public static boolean existeTipo(String id_tipo, Connection con) {
        try {

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from tipo_incidencia where id_tipo = \"" + id_tipo + "\"");
            return rs.next();

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }
/**
 * Verifica si existe una incidencia con cierto numero
 * @param numIncidencia Numero de incidencia
 * @param con  Conexion con la base de datos
 * @return True en caso de que exista, False en caso de que no
 */
    public static boolean existeNum(int numIncidencia, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from incidencia where Num_incidencia = " + numIncidencia);
            return rs.next();

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }
/**
 * Da de alta una incidencia con sus datos
 * @param con  Conexion con la base de datos
 */
    public static void altaIncidencia(Connection con) {

        String id_tipo = null;
        String urgencia = JOptionPane.showInputDialog("Es Urgente? (true/false)"); //Deberia ser boolean
        System.out.println(urgencia);
        id_tipo = JOptionPane.showInputDialog("Identificador del tipo de incidencia");
        boolean existe = gestor.existeTipo(id_tipo, con);
        while (existe == false) {
            JOptionPane.showMessageDialog(null, "¡Error,No existe un tipo de incidencia con ese codigo!");
            id_tipo = JOptionPane.showInputDialog("Identificador del tipo de incidencia");
        }
        String fecha_alta = date.fechaHoy();
        String lugar = JOptionPane.showInputDialog("Lugar de la incidencia: ");
        String descripcion = JOptionPane.showInputDialog("Descripcion: ");
        String arreglada = JOptionPane.showInputDialog("¿Arreglada? (true/false)");//Deberia ser boolean
        //S/N
        String guardado = (JOptionPane.showInputDialog("¿Desea guardar la informacion? (S/N)").toUpperCase());
        if (guardado.equals("S")) {
            try {
                Statement s = con.createStatement();
                s.executeUpdate("insert into incidencia values(Num_incidencia ," + urgencia + "," + id_tipo + ",\"" + fecha_alta + "\",\"" + lugar + "\",\"" + descripcion + "\"," + arreglada + ")");
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex.toString());

            }
        }
    }
/**
 * Verifica si una incidencia esta arreglada
 * @param numIncidencia Numero de la incidencia
 * @param con Conexion con la base de datos
 * @return True en caso de que este sin arreglar, false en caso de que este arreglada
 */
    public static boolean incidenciaArreglada(int numIncidencia, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select arreglada from incidencia where Num_incidencia = \"" + numIncidencia + "\"");

            if (rs.next() == true) {
                String prueba = rs.getString("arreglada");
                if (prueba.equals("1")) {
                    return false;
                    
                } else {
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }
/**
 * Da de baja una incidencia en caso de que no este arreglada y exista
 * @param num_incidencia Numero de la incidencia
 * @param con Conexion con la base de datos
 * @return Mensaje con la informacion necesaria
 */
    public static String bajaIncidencia(int num_incidencia, Connection con) {
        String mensaje = null;
        try {
            if (existeNum(num_incidencia, con)) {
                if (incidenciaArreglada(num_incidencia, con)) {
                    Statement s = con.createStatement();
                    s.executeUpdate("Delete from incidencia where num_incidencia = \"" + num_incidencia + "\"");
                    mensaje = "Borrado realizado con exito";
                } else {
                    mensaje = "¡Error, No se puede borrar esa incidencia al estar ya ARREGLADA!";
                }
            } else {
                mensaje = "¡Error, ese numero de incidencia NO EXISTE!";

            }
        } catch (SQLException ex) {
            System.out.println("SQL Exeption: " + ex.toString());
        }
        return mensaje;
    }
/**
 * Cambia de Estado una incidencia verificando que exista, en caso de que este arreglada muestra mensaje de que se ha cambiado correctamente sin diferenciar este caso
 * @param num_incidencia Numero de la incidencia
 * @param con Conexion con la base de datos
 * @return Mensaje con la informacion necesaria
 */
    public static String cambioEstado(int num_incidencia, Connection con) {
        String mensaje = null;
        try {
            if (existeNum(num_incidencia, con)) {
                Statement s = con.createStatement();
                s.executeUpdate("UPDATE incidencia SET Arreglada = true WHERE Num_incidencia = \"" + num_incidencia + "\"");
                mensaje = "Estado de incidencia cambiado correctamente";
            } else {
                mensaje = "¡Error, ese numero de incidencia NO EXISTE!";

            }
        } catch (SQLException ex) {
            System.out.println("SQL Exeption: " + ex.toString());
        }
        return mensaje;
    }
/**
 * Lista todas las incidencias que sean urgentes y esten sin arreglar en orden de fecha descendente
 * @param con Conexion con la base de datos
 * @return 
 */
    public static ArrayList<String> listado(Connection con) {
        ArrayList<String> datos = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from incidencia where urgencia = true AND arreglada = false Order By Fecha ASC");
            if (rs.next() == true) {
                do {
                    datos.add("Nº incidencia: " + rs.getString("Num_incidencia") + "\n"
                            + "Tipo: " + rs.getString("Id_tipo") + "\n"
                            + "Fecha y Hora " + rs.getString("Fecha") + "\n"
                            + "Lugar: " + rs.getString("Lugar") + "\n"
                            + "Descripcion " + rs.getString("Descripcion") + "\n"
                    );
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return datos;
    }
}//Fin clase
