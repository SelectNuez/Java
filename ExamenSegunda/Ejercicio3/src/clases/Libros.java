/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Blitz
 */
public class Libros {
/**
 * Mediante el String comprueba si el libro existe y si lo hace sealiza la modificacion deseada
 * @param ISBN ISBN unico del libro
 * @param con Conexion con BBDD
 * @return Mensaje si se han podido realizar los cambios o no
 * @see existeLibro
 */
    public static String modificaLibro(String ISBN, Connection con) {
        String mensaje = "No se han realizado cambios";
        try {

            Statement s = con.createStatement();
            int option = JOptionPane.showConfirmDialog(null, "¿Desea cambiar el titulo del libro?");
            if (option == 0) {
                String titulo = JOptionPane.showInputDialog("Introduzca el nuevo titulo");
                if (Libros.existeLibro(titulo, con)) {
                    s.executeUpdate("UPDATE biblioteca SET titulo = \"" + titulo + "\" WHERE ISBN = \"" + ISBN + "\"");
                    mensaje = "Cambio realizado con exito";
                } else {
                    mensaje = "Imposible modificar libro no encontrado";
                }
            } else if (option == 1) {
                int tempOp = JOptionPane.showConfirmDialog(null, "¿Desea cambiar la editorial del libro?");
                if (tempOp == 0) {
                    String editorial = JOptionPane.showInputDialog("Introduzca la nueva editorial");
                    if (Libros.existeLibro(editorial, con)) {
                        s.executeUpdate("UPDATE biblioteca SET editorial = \"" + editorial + "\" WHERE ISBN = \"" + ISBN + "\"");
                        mensaje = "Cambio realizado con exito";
                    } else {
                        mensaje = "Imposible modificar libro no encontrado";
                    }
                }

            }

        } catch (SQLException ex) {
            System.out.println("SQL Exeption: " + ex.toString());
        }
        return mensaje;
    }
/**
 * Comprueba si existe el libro buscado
 * @param parametro Autor o Editorial del libro
 * @param conConexion con BBDD
 * @return Boolean con la existencia del libro
 */
    public static boolean existeLibro(String parametro, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from biblioteca where titulo = \"" + parametro + "\" OR editorial=\"" + parametro + "\"");
            if (rs.next() == true) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }
/**
 * Lista los libros que hay con un parametro introducido
 * @param parametro Titulo o Editorial
 * @param con Conexion con BBDD
 * @return Listado de los libros existentes
 */
    public static ArrayList<String> consultaLibros(String parametro, Connection con) {
        ArrayList<String> datos = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from biblioteca where titulo = \"" + parametro + "\" OR editorial=\"" + parametro + "\"");
            if (rs.next() == true) {
                do {
                    datos.add("ISBN: " + rs.getString(1) + "\n"
                            + "Titulo: " + rs.getString(2) + "\n"
                            + "Editorial: " + rs.getString(3) + "\n");
                } while (rs.next());

            } else {
                datos.add("Imposible modificar libro no encontrado");
            }
        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return datos;
    }

    /**
 * Comprueba si existe el libro buscado
 * @param parametro Autor o Editorial del libro
 * @param conConexion con BBDD
 * @return Boolean con la existencia del libro
 */
    public static boolean existeSocio(String id_Socio, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from socio where id_Socio = \"" + id_Socio +  "\"");
            if (rs.next() == true) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }
    public static String nuevoPrestamo(String nombreLibro, String id_Socio, Connection con) {

        try {
            Statement s = con.createStatement();
            if(Libros.existeLibro(nombreLibro, con )){
                if(Libros.existeSocio)
            }else{ return "No se ha encontrado el Libro deseado";}
            s.executeUpdate("INSERT INTO PROPIETARIOS"
                    + " (nombre_prop, dni_prop)"
                    + " VALUES (\"" + nombre_prop + "\",\"" + dni_prop + "\" )");
            resultado = 0;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
        return resultado;
    }

}
