package principal;

import javax.swing.JOptionPane;
import bbdd.*;
import clases.Libros;
import java.sql.*;

/*
1.- Modificación de libros: Se modificará el título y/o la editorial. Si no existe el libro se mostrará el mensaje “Imposible modificar libro no encontrado”.
2.- Consulta de libros: Se realizará una consulta de libros por diferentes criterios: titulo o editorial. Se mostrarán todos los libros que cumplan el criterio de búsqueda o el mensaje “No se obtuvieron resultados” en caso negativo.
3.- Préstamo de libros: Se realizará una inserción en la tabla Préstamos controlando que exista el libro y el socio.
4.- Listado de libros prestados a un socio determinado: Se mostrará el nombre del socio y el título la editorial y la fecha de préstamo y de devolución.
 */
public class main {

    public static void main(String[] args) {
        Connection con = ConnectionDB.openConnection();
        String nombre;
        String ISBN;
        int menu = 0;
        do {

            menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "1.Modificar un libro.\n"
                    + "2.Consultar un libro.\n"
                    + "3.Realizar un prestamo\n"
                    + "4.Listado de libros y prestamos\n"
                    + "5.Borrar de libros\n"
                    + "6.Salir."));

            switch (menu) {
                case 1:
                    JOptionPane.showMessageDialog(null, Libros.modificaLibro(con));
                    break;
                case 2:
                    String parametro = JOptionPane.showInputDialog("Introduce el Titulo o la editorial del que deseas obtener los datos");
                    for (String consultaLibro : Libros.consultaLibros(parametro, con)) {
                        JOptionPane.showMessageDialog(null, consultaLibro);
                    }

                    break;
                case 3:
                    int id_libro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del libro a prestar"));
                    int id_socio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del socio"));
                    Libros.nuevoPrestamo(id_libro, id_socio, con);
                    break;
                case 4:
                    nombre = JOptionPane.showInputDialog("Introduzca el nombre del Socio del que quieres obtener los datos de sus prestamos");
                    for (String consultaLibrosSocio : Libros.consultaLibrosSocio(nombre, con)) {
                        JOptionPane.showMessageDialog(null, consultaLibrosSocio);
                    }
                    break;
                case 5:
                    nombre = JOptionPane.showInputDialog("Introduzca el nombre del libro que desea borrar");

                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Introduzca una opcion valida");
            }

        } while (menu != 6);
        /*
            Si deseamos abrir la conexion en cada metodo:
         Connection conn = ConnectionDB.openConnection();
         */
        ConnectionDB.closeConnection();
    }

}
