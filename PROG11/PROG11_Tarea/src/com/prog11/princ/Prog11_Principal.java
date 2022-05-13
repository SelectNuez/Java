/*
Dentro este paquete, crea una clase denominada Prog11_Principal.java que contenga el método main.
Inserta el código necesario en esta clase para poder probar cada uno de los métodos implementados en las clases de acceso a la BBDD, , siguiendo el siguiente orden
Insertar varios vehículos y propietarios.
Listar todos los vehículos.
Actualizar propietario de un vehículo.
Listar todos los vehículos.
Eliminar un vehículo que exista.
Eliminar un vehículo que no exista.
Listar todos los vehículos.
Listar los vehículos de una marca.
Listar todos los vehículos de un propietario.
Eliminar un propietario con vehículos.
Eliminar un propietario sin vehículos.
 */
package com.prog11.princ;

import com.prog11.clases.VehiculosDAO;
import com.prog11.clases.PropietariosDAO;
import com.prog11.bbdd.*;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge Martin
 */
public class Prog11_Principal {

    public static void main(String[] args) {

        ConnectionDB mysql = new ConnectionDB();
        Connection con = ConnectionDB.openConnection();

//Insertar varios vehículos y propietarios.
        PropietariosDAO.nuevoProp("Harry Potter", "12345678A", con);
        PropietariosDAO.nuevoProp("Ron Weasley", "98765432B", con);
        PropietariosDAO.nuevoProp("Hermione Granger", "45612378C", con);
        VehiculosDAO.nuevoVeh("1975DRM", "Renault", 98035, 4999, "Renault Laguna Negro", 1, con);
        VehiculosDAO.nuevoVeh("8754VCL", "Toyota", 15021, 17999, "Toyota Yaris Blanco", 2, con);
        VehiculosDAO.nuevoVeh("0000DVD", "Tesla", 5000, 64500, "Tesla Model S Rojo", 3, con);
// Mejora: Mostrar los datos de la BBDD        
        JOptionPane.showMessageDialog(null, PropietariosDAO.datosBBDD(con));
        
//Listar todos los vehículos.

        for (String i : VehiculosDAO.recuVeh(con)) {
            JOptionPane.showMessageDialog(null, i);
        }
//Actualizar propietario de un vehículo.
        if (VehiculosDAO.actualizarVeh("0000DVD", 2 ,con) == 0) {
            JOptionPane.showMessageDialog(null, "Se ha actualizado el vehiculo");
        }
//Listar todos los vehículos.
        for (String i : VehiculosDAO.recuVeh(con)) {
            JOptionPane.showMessageDialog(null, i);
        }
//Eliminar un vehículo que exista.
        VehiculosDAO.borrarVeh("1975DRM",con);
//Eliminar un vehículo que no exista.
        VehiculosDAO.borrarVeh("1975DAM",con);
//Listar todos los vehículos.
        JOptionPane.showMessageDialog(null, VehiculosDAO.recuVeh(con));
//Listar los vehículos de una marca.
        for (String i : VehiculosDAO.recuVehMarc("Tesla", con)) {
            JOptionPane.showMessageDialog(null, i);
        }
//Listar todos los vehículos de un propietario.
        for (String i : PropietariosDAO.lista("98765432B", con)) {
            JOptionPane.showMessageDialog(null, i);
        }
//Eliminar un propietario con vehículos.
        JOptionPane.showMessageDialog(null, "Se han borrado: " + PropietariosDAO.borrarProp("98765432B", con) + " registro/s");
//Eliminar un propietario sin vehículos.
        JOptionPane.showMessageDialog(null, "Se han borrado: " + PropietariosDAO.borrarProp("45612378C", con) + " registro/s");
        ConnectionDB.closeConnection();
    }

}
