/*
Crea una clase estática denominada VehiculosDAO.java que contenga los métodos necesarios para realizar operaciones contra la tabla Vehiculos. Deberá contener métodos para:
 */
package com.prog11.clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jorma
 */
public class VehiculosDAO {

    /**
     * <p>
     * Metodo nuevoVeh</p>
     *
     * <p>
     * Recibe por parámetro los datos del vehículo a insertar, trata de
     * insertarlo en la BBDD </p>
     *
     * @param mat_veh Matricula del vechiculo
     * @param marca_veh Marca del vechiculo
     * @param precio_veh Precio del vechiculo
     * @param kms_veh Kilometros del vechiculo
     * @param desc_veh Descripcion del vechiculo
     * @param id_prop id del Propietario
     * @param con Conexion con la BBDD
     *
     * @return Devuelve 0 si la operación se realizó con éxito o -1 en caso
     * contrario
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static int nuevoVeh(String mat_veh, String marca_veh, int kms_veh, float precio_veh, String desc_veh, int id_prop, Connection con) {
        int resultado = -1;
        try {
            Statement s = con.createStatement();

            s.executeUpdate("INSERT INTO VEHICULOS"
                    + " (mat_veh, marca_veh, kms_veh,  precio_veh, desc_veh, id_prop)"
                    + " VALUES (\"" + mat_veh + "\",\"" + marca_veh + "\",\"" + kms_veh + "\",\"" + precio_veh + "\",\"" + desc_veh + "\",\"" + id_prop + "\" )");
            resultado = 0;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());

        }
        return resultado;
    }

    /**
     * <p>
     * Metodo actualizarVeh</p>
     *
     * <p>
     * Recibe por parámetro la matrícula de un vehículo junto al identificador
     * de un propietario y trata de actualizar el vehículo en la BBDD.  </p>
     *
     * @param mat_veh Matricula del vechiculo
     * @param id_prop id del Propietario
     * @param con Conexion con la BBDD
     *
     * @return Devuelve 0 si la operación se realizó con éxito o -1 si el
     * vehículo no existe.
     *
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static int actualizarVeh(String mat_veh, int id_prop, Connection con) {
        //UPDATE CLIENTE SET teléfono='968610009' WHERE idCLIENTE=3
        int resultado = -1;
        try {
            Statement s = con.createStatement();
            s.executeUpdate("UPDATE VEHICULOS SET id_prop = \"" + id_prop + "\" WHERE mat_veh = \"" + mat_veh + "\"");
            resultado = 0;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());

        }
        return resultado;
    }

    /**
     * <p>
     * Metodo borrarVeh</p>
     *
     * <p>
     * Recibe por parámetro la matrícula de un vehículo y trata de eliminarlo de
     * la BBDD.  </p>
     *
     * @param mat_veh Matricula del vechiculo
     * @param con Conexion con la BBDD
     *
     * @return Devuelve 0 si la operación se realizó con éxito o -1 si el
     * vehículo no existe.
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static int borrarVeh(String mat_veh, Connection con) {
        int resultado = -1;
        int numReg = 0;
        try {

            Statement s = con.createStatement();
            numReg = s.executeUpdate("DELETE FROM VEHICULOS WHERE mat_veh = \"" + mat_veh + "\" ");
            if (numReg != 0) {
                resultado = 0;
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());

        }
        return resultado;
    }



    /**
     * <p>Metodo recuVehMarc</p>
     *
     * <p>Recibe una marca por parámetro y devuelve una lista con el listado de vehículos de la citada marca.Para cada vehículo, la lista contendrá una cadena de caracteres con los datos del mismo. </p>
     *
     * @param marca_veh Marca del vechiculo
     * @param con Conexion con la BBDD
     *
     * @return Si no existen vehículos, devuelve el ArrayList vacío.
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
    public static ArrayList<String> recuVehMarc(String marca_veh, Connection con) {
        ArrayList<String> datos = new ArrayList<String>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select mat_veh, kms_veh,precio_veh from vehiculos where marca_veh = \"" + marca_veh + "\" ");

            if (rs.next() == true) {
                do {
                    datos.add("Vehiculos de marca " + marca_veh + ": \n"
                            + "Matricula: " + rs.getString(1) + "\n"
                            + "Km: " + rs.getString(2) + "\n"
                            + "Precio: " + rs.getString(3) + "€\n");

                } while (rs.next());

            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
        return datos;
    }

    /**
     * <p>Metodo recuVeh</p>
     *
     * <p>No recibe parámetros (solo la coneción con la BBDD)</p>
     *
     * @param con Conexion con la BBDD
     *
     * @return Retorna una lista con la matrícula, marca, kilómetros y precio de cada vehículo.
     *
     *
     * @author Jorge Martin
     * @version 1.0 13/04/2022
     */
  
    public static ArrayList<String> recuVeh(Connection con) {
        ArrayList<String> datos = new ArrayList<String>();

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select mat_veh, marca_veh,kms_veh,precio_veh from vehiculos");

            if (rs.next() == true) {
                do {
                    datos.add("Vehiculo: \n"
                            + "Matricula: " + rs.getString(1) + "\n"
                            + "Marca: " + rs.getString(2) + "\n"
                            + "Km: " + rs.getString(3) + "\n"
                            + "Precio: " + rs.getString(4) + "€\n");

                } while (rs.next());

            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
        return datos;
    }
}
