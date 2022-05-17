/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import utilidades.date;

/**
 *
 * @author Blitz
 */
public class Libros {

    /**
     * Mediante el String comprueba si el libro existe y si lo hace sealiza la
     * modificacion deseada
     *
     * @param con Conexion con BBDD
     * @return Mensaje si se han podido realizar los cambios o no
     * @see existeLibro
     */
    public static String modificaLibro(Connection con) {
        String mensaje = "No se han realizado cambios";
        try {

            Statement s = con.createStatement();
            int option = JOptionPane.showConfirmDialog(null, "¿Desea cambiar el titulo del libro?");
            if (option == 0) {
                String titulo_old = JOptionPane.showInputDialog("Introduzca el Titulo a cambiar");
                String titulo_nuevo = JOptionPane.showInputDialog("Introduzca el nuevo titulo");

                if (Libros.existeLibro(titulo_old, con)) {
                    s.executeUpdate("UPDATE Libros SET titulo = \"" + titulo_nuevo + "\" WHERE titulo = \"" + titulo_old + "\"");
                    mensaje = "Cambio realizado con exito";
                } else {
                    mensaje = "Imposible modificar libro no encontrado";
                }
            } else if (option == 1) {
                int tempOp = JOptionPane.showConfirmDialog(null, "¿Desea cambiar la editorial del libro?");
                if (tempOp == 0) {
                    String editorial_old = JOptionPane.showInputDialog("Introduzca la editorial antigua");
                    String editorial_new = JOptionPane.showInputDialog("Introduzca la nueva editorial");
                    if (Libros.existeLibro(editorial_old, con)) {
                        s.executeUpdate("UPDATE Libros SET editorial = \"" + editorial_new + "\" WHERE editorial = \"" + editorial_old + "\"");
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
     * Comprueba si existe un libro
     *
     * @param id_libro Identificador libro
     * @param con Conexion con la BBDD
     * @return Boolean de la existencia del libro
     */
    public static boolean existeLibro(int id_libro, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from Libros where id_libro = \"" + id_libro + "\"");
            return rs.next();

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }

    /**
     * Comprueba si existe el libro buscado
     *
     * @param parametro Autor o Editorial del libro
     * @param conConexion con BBDD
     * @return Boolean con la existencia del libro
     */
    public static boolean existeLibro(String parametro, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from Libros where titulo = \"" + parametro + "\" OR editorial=\"" + parametro + "\"");
            return rs.next();

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }

    /**
     * Lista los libros que hay con un parametro introducido
     *
     * @param parametro Titulo o Editorial
     * @param con Conexion con BBDD
     * @return Listado de los libros existentes
     */
    public static ArrayList<String> consultaLibros(String parametro, Connection con) {
        ArrayList<String> datos = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from Libros where titulo = \"" + parametro + "\" OR editorial=\"" + parametro + "\"");
            if (rs.next() == true) {
                do {
                    datos.add("Id: " + rs.getString("Id_Libro") + "\n"
                            + "Titulo: " + rs.getString("Titulo") + "\n"
                            + "Numero de ejemplares: " + rs.getString("Num_ejemplares") + "\n"
                            + "Editorial: " + rs.getString("Editorial") + "\n"
                            + "Numero de paginas: " + rs.getString("Num_paginas") + "\n"
                            + "Fecha de edicion: " + rs.getString("Fecha_edicion") + "\n"
                    );
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
     *
     * @param parametro Autor o Editorial del libro
     * @param conConexion con BBDD
     * @return Boolean con la existencia del libro
     */
    public static boolean existeSocio(int id_Socio, Connection con) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from Socios where id_Socio = \"" + id_Socio + "\"");
            if (rs.next() == true) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return false;
    }

    /**
     * Se realiza un nuevo prestamo y se une en libro con el socio que lo posee
     *
     * @param id_libro Identificador del libro
     * @param id_Socio Identificador del Socio
     * @param con Conexion con la BBDD
     * @return Indicacion de como se ha realizado el prestamo
     */
    public static String nuevoPrestamo(int id_libro, int id_Socio, Connection con) {

        try {

            if (Libros.existeLibro(id_libro, con)) {
                if (Libros.existeSocio(id_Socio, con)) {
                    Statement s = con.createStatement();
                    s.executeUpdate("insert into Prestamos values(" + id_libro + "," + id_Socio + "," + date.fechaHoy() + ",null)");
                    return "Se ha realizado el nuevo prestamo";
                } else {
                    return "No se ha encontrado el Socio indicado";
                }
            } else {
                return "No se ha encontrado el Libro deseado";

            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.toString());
        }
        return null;
    }

    /**
     * Consulta los libros de un Socio
     *
     * @param nombre Nombre del Socio
     * @param con Conexion con la BBDD
     * @return Una lista con todos los datos de cada libro
     */
    public static ArrayList<String> consultaLibrosSocio(String nombre, Connection con) {
        ArrayList<String> datos = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select s.nombre_socio,l.titulo,l.editorial,p.Fecha_inicio,p.fecha_fin from libros l,prestamos p, socios s where p.id_libro = l.id_libro and s.id_socio = p.id_socio and s.nombre_socio = \"" + nombre + "\"");
            if (rs.next() == true) {
                do {
                    datos.add("Nombre socio: " + rs.getString("s.nombre_socio") + "\n"
                            + "Titulo: " + rs.getString("l.titulo") + "\n"
                            + "Editorial: " + rs.getString("l.editorial") + "\n"
                            + "Fecha inicio del prestamo: " + rs.getString("p.Fecha_inicio") + "\n"
                            + "Fecha devolucion" + rs.getString("p.fecha_fin"));
                } while (rs.next());

            } else {
                datos.add("No se ha encontrado el Socio");
            }
        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }

        return datos;
    }

    public static String borrado(String titulo, Connection con) {
        String mensaje = "No se ha encontrado el libro";
        try {
            if (existeLibro(titulo, con)) {
                Statement s = con.createStatement();
                //Si se desease tener el numero de registros borrados valdria con asignar una variable al executeUpdate
                s.executeUpdate("Delete from libros where titulo = \"" + titulo + "\"");
                mensaje = "Borrado realizado con exito";
            }

        } catch (SQLException ex) {
            System.out.print("SQL Exception: " + ex.toString());
        }
        return mensaje;
    }

}
