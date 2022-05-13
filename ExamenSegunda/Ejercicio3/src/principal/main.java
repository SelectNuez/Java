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
        ConnectionDB mysql = new ConnectionDB();
        Connection con = ConnectionDB.openConnection();
        
        String ISBN;
        int menu = 0;
        do {

            menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "1.Modificar un libro.\n"
                    + "2.Consultar un libro.\n"
                    + "3.Realizar un prestamo\n"
                    + "4.Listado de libros y prestamos\n"
                    + "5.Salir."));

            switch (menu) {
                case 1:
                    ISBN = JOptionPane.showInputDialog("Introduzca el ISBN del libro que quiere modificar");
                    JOptionPane.showMessageDialog(null,Libros.modificaLibro(ISBN, con));
                    break;
                case 2:
                    String parametro = JOptionPane.showInputDialog("Introduce el Titulo o la editorial del que deseas obtener los datos");
                    for (String consultaLibro : Libros.consultaLibros(parametro, con)) {
                        JOptionPane.showMessageDialog(null, consultaLibro);
                    }

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:

            }

        } while (menu != 5);
    }

}
