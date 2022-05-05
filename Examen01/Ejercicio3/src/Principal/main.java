package Principal;

import Parques.Acuaticas;
import Parques.Terrestres;
import Parques.Parques;
import Parques.ReservasDeCaza;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {

        String reserva;
        int numeroEspecies;
        Parques parque[] = null;

        parque[0] = new ReservasDeCaza(100, "Escopeta", 1000, 25, "Sabana");
        parque[1] = new ReservasDeCaza(252.5, "Pistola", 1002.5, 10, "Cementerio De Huesos");
        parque[2] = new Acuaticas(10, 150, "Manos Limpias", 524, 12, "Lagos Taki");
        parque[3] = new Terrestres("Llanura", 120, "Sabanas Unidas", 45, 30, "Llanura Rey Leon");

        
        //Modificamos el numero de especies en un parque dado el nombre
        reserva = JOptionPane.showInputDialog(null, "Introduzca la Reserva de Caza de la que desea cambiar el numero de especies: ");
        if (reserva == "Sabana") {
            numeroEspecies = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de especies actualizado: "));
            parque[0].setNumeroEspecies(numeroEspecies);
        } else if (reserva == "Cementerio De Huesos") {
            numeroEspecies = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de especies actualizado: "));
            parque[1].setNumeroEspecies(numeroEspecies);
        }

    }
}
