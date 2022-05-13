//Crea una clase estática denominada PropietariosDAO.java que contenga los métodos necesarios para realizar operaciones contra la tabla propietarios.
package com.prog11.clases;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jorma
 */
public class PropietariosDAO {

    /**
     * <p>
     * Metodo nuevoProp</p>
     *
     * <p>
     * Recibe por parámetro los datos de un propietario a insertar, trata de
     * insertarlo en la BBDD </p>
     *
     * @param nombre_prop El nombre del propietario
     * @param dni_prop El DNI del propietario
     * @param con Se pasa la conexion a la base de datos como parametro
     *
     * @return Devuelve 0 si la operación se realizó con éxito o -1 en caso
     * contrario.
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static int nuevoProp(String nombre_prop, String dni_prop, Connection con) {
        int resultado = -1;
        try {
            Statement s = con.createStatement();

            s.executeUpdate("INSERT INTO PROPIETARIOS"
                    + " (nombre_prop, dni_prop)"
                    + " VALUES (\"" + nombre_prop + "\",\"" + dni_prop + "\" )");
            resultado = 0;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
        return resultado;
    }
    /**
     * <p>
     * Metodo datosBBDD</p>
     *
     * <p>
     * Recibe por parámetro la conexion con la BBDD </p>
     *
     * @param con Se pasa la conexion a la base de datos como parametro
     *
     * @return Devuelve un String con el numero de vehiculos y de propietarios que contiene la BBDD
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static String datosBBDD(Connection con) {
        String datos = null;

        try {
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM PROPIETARIOS");

            while (rs.next()) {
                datos = "La base de datos tiene: " + rs.getString(1) + " propietario/s\n";
            }
            ResultSet rq = s.executeQuery("SELECT COUNT(*) FROM Vehiculos");
            while (rq.next()) {
                datos = datos + "La base de datos tiene: " + rq.getString(1) + " vehiculo/s\n";
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }

        return datos;
    }

    /**
     * <p>
     * Metodo lista</p>
     *
     * <p>
     * Recibe por parámetro el DNI de un propietario y devuelve una lista con la
     * matrícula, marca, número de kms y precio de todo sus vehículos.</p>
     *
     * @param DNI El DNI del propietario
     * @param con Se pasa la conexion a la base de datos como parametro
     *
     * @return Retornará null si hubo problemas.
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static ArrayList<String> lista(String DNI, Connection con) {
        ArrayList<String> datos = new ArrayList<String>();

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select mat_veh, marca_veh,kms_veh,precio_veh "
                    + "from vehiculos INNER JOIN propietarios on propietarios.id_prop = vehiculos.id_prop "
                    + "WHERE propietarios.dni_prop = \"" + DNI + "\" ");

            if (rs.next() == true) {
                do {
                    datos.add("Vehiculo: \n"
                            + "Matricula: " + rs.getString(1) + "\n"
                            + "Marca: " + rs.getString(2) + "\n"
                            + "Km: " + rs.getString(3) + "\n"
                            + "Precio: " + rs.getString(4) + "€\n");

                } while (rs.next());

            } else {
                datos.add("El propietario con DNI " + DNI + " no tiene ningun vehiculo");
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
        return datos;
    }

    /**
     * <p>
     * Metodo borrarProp</p>
     *
     * <p>
     * Recibe por parámetro el DNI de un propietario y trata de eliminarlo de la
     * BBDD. </p>
     *
     * @param
     * @param dni_prop El DNI del propietario
     * @param con Se pasa la conexion a la base de datos como parametro
     *
     * @return Devuelve el número de registros eliminados.
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static int borrarProp(String dni_prop, Connection con) {
        int numReg = 0;
        int id = 0;
        try {

            Statement s = con.createStatement();

            //Primero obtengo el ID del propietario y borro todos los registros de los coches que tiene para despues borrar al propietario
            ResultSet id_prop = s.executeQuery("SELECT id_prop from propietarios WHERE dni_prop =\"" + dni_prop + "\" ");
            while (id_prop.next()) {
                id = id_prop.getInt(1);
            }

            numReg = s.executeUpdate("DELETE FROM VEHICULOS WHERE id_prop = \"" + id + "\" ");
            numReg = numReg + s.executeUpdate("DELETE FROM PROPIETARIOS WHERE dni_prop = \"" + dni_prop + "\" ");

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());

        }
        return numReg;
    }

}
