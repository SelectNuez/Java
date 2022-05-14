package objetos;

import Datos.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class parking {

    private ArrayList<String> residentes;
    private ArrayList<Coche> particulares;

    public parking() {
        try{
        datos datos = new datos();
        residentes = datos.meterDatosresidentes();
        particulares = datos.meterDatosParticulares();
        }
        catch(Exception e)
        {
            System.out.println("Ha fallado la importacion de datos");
        }
    }

    /**
     * Comprueba si la matricula esta dentro de la lista de residentes
     *
     * @param matricula
     * @return True si esta en la lista,False si no
     */
    public boolean esResidente(String matricula) {
        for (String residente : residentes) {
            if (residente.contentEquals(matricula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si esta en la lista de residentes, sino, comprueba si enta en
     * el parking y si no lo añade a la lista.
     *
     * @param matricula
     * @param fecha Fecha de entrada
     * @return Un String con la informacion para el usuario
     */
    public String entraCoche(String matricula, String fecha) {
        String entra = "El vehiculo es de un residente por lo que no se le añade a la lista de vehiculos en el Parking";

        if (!esResidente(matricula)) {
            for (Coche particular : particulares) {
                if (particular.getMatricula().equals(matricula)) {
                    return entra = "El vehiculo ya esta dentro de el Parking";
                }
            }
            //Como no es residente se agrega a la lista
            particulares.add(new Coche(matricula, fecha, false));
            return entra = "El vehiculo se ha añadido satisfactoriamente";
        }

        return entra;
    }

    public int indArr(String matricula) {
        int indice = -1;
        for (Coche particular : particulares) {
            if (particular.getMatricula().equals(matricula)) {
                indice = particulares.indexOf(particular);
            }
        }
        return indice;
    }

    public String saleCoche(String matricula) {
        String mensaje = "Hasta pronto!";
        int ind = -1;
        if (!esResidente(matricula)) {
            for (Coche particular : particulares) {
                if (!particular.isPagado() && particular.getMatricula().equals(matricula)) {
                    return mensaje = "Debe pagar antes de abandonar el parking";
                }
            }
            ind = indArr(matricula);
            particulares.remove(ind);
        }
        return mensaje;
    }

    public void listado() {
        String pagado = "No";
        for (Coche particular : particulares) {
            if (particular.isPagado() == true) {
                pagado = "Si";
            } else {
                pagado = "No";
            }
            JOptionPane.showMessageDialog(null, "Mostrando coches particulares del parking "
                    + "\nLa matricula es: " + particular.getMatricula()
                    + "\nLa hora de entrada es: " + particular.getFecha()
                    + "\nPagado: " + pagado);

        }
    }

    public String pagar(String matricula, long tiempo) {
        String mensaje = "Este vehiculo no tiene que pagar";
        double precio = 0;
        for (Coche particular : particulares) {
            if (particular.getMatricula().equals(matricula) && particular.isPagado() == false) {
                precio = Math.round(tiempo * 0.001);
                mensaje = "Se debe pagar: " + precio / 100 + " €";
                particular.setPagado(true);
            }
        }

        return mensaje;
    }
}
