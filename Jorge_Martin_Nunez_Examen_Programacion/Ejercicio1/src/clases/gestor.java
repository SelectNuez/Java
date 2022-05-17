package clases;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Martin
 */
public class gestor {

    public gestor() {
        VMunicipios.add(new Municipio("Olmedo", "1", 1451, 100));
        VMunicipios.add(new Municipio("Boecillo", "2", 1425, 200));
        VMunicipios.add(new Municipio("Laguna de Duero", "3", 1474, 300));
        VMunicipios.add(new Municipio("Cubillas de Santa Marta", "4", 1254, 400));

    }
    private static ArrayList<Municipio> VMunicipios = new ArrayList<>();
    private static HashMap<String, Integer> consumo_municipios = new HashMap<String, Integer>();
/**
 * Inserta el municipio en el ArrayList
 * @param nombreMunicipio 
 * @param codPostal
 * @param nHabitantes
 * @param nHogares
 * @return Devuelve un mensaje con la informacion necesaria
 */
    public static String InsertarMuncicipio(String nombreMunicipio, String codPostal, int nHabitantes, int nHogares) {
        VMunicipios.add(new Municipio(nombreMunicipio, codPostal, nHabitantes, nHogares));
        return "Se ha insertado con exito el municipio";
    }
/**
 * Comprueba si el municipio existe
 * @param codPostal
 * @return True si existe
 */
    public static boolean comprobarMunicipio(String codPostal) {
        for (Municipio municipio : VMunicipios) {
            if (municipio.getCodPostal().equals(codPostal)) {
                return true;
            }
        }
        return false;
    }
/**
 * Registra un consumo para un municipio
 * @param codPostal
 * @return Devuelve un mensaje con la informacion necesaria
 */
    public static String registrarConsumo(String codPostal) {
        if (comprobarMunicipio(codPostal)) {
            int consumo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el consumo estimado a realizar (m3): "));
            consumo_municipios.put(codPostal, consumo);
            return "Consumo registrado con exito";
        } else {
            return "¡Error, ese municipio no existe!";
        }
    }
/**
 * Lista los municipios
 * @return Devuelve un mensaje con un listado de los municipios y su consumo
 */
    public static String listadoMunicipios() {
        String mensaje = "Nombre Municipio               Consumo\n";
        String consumo = "Sin dato";

        for (Municipio municipio : VMunicipios) {

            consumo = String.valueOf(consumo_municipios.get(municipio.getCodPostal()));
            if (consumo.equals("null")) {
                consumo = "Sin dato";
            }

            mensaje += municipio.getNombreMunicipio() + "                                         " + consumo + " m3\n";
        }
        return mensaje;
    }
/**
 * Calcula el municipio que mas ha consumido ademas de devolver la suma del consumo de todos los municipios
 * @return Devuelve un mensaje con los datos necesarios
 */
    public static String consumoTotal() {
        int consumo = 0;
        int consumoAnt = 0;
        int consumoMax = 0;
        String ciudadMax = null;
        for (Municipio municipio : VMunicipios) {
            String checkConsumo = String.valueOf(consumo_municipios.get(municipio.getCodPostal()));
            if (checkConsumo.equals("null")) {
                consumo = 0;
            } else {
                if (consumo_municipios.get(municipio.getCodPostal()) > consumoAnt) {
                    ciudadMax = municipio.getNombreMunicipio();
                    consumoAnt = consumo_municipios.get(municipio.getCodPostal());
                }
                consumoMax += consumo_municipios.get(municipio.getCodPostal());
            }
        }
        return "El consumo total realizado es de " + consumoMax + " m3\n"
                + "El municipio de mayor consumo por habitante es: " + ciudadMax;
    }
/**
 * Muestra el el consumo de cada Municipio
 * @param codPostal
 * @see consumoTotal
 * @return Devuelve un mensaje con los datos necesarios
 */
    public static String consumoMunicipio(String codPostal) {
        String mensaje = null;
        int media;
        int consumo = 0;
        int nHab = 0;
        if (comprobarMunicipio(codPostal)) {
            for (Municipio municipio : VMunicipios) {
                String checkConsumo = String.valueOf(consumo_municipios.get(codPostal));
                if (checkConsumo.equals("null")) {
                    return "Este municipio no tiene consumos por lo que no se pueden visualizar estas estadisticas";
                } else {
                    consumo = consumo_municipios.get(codPostal);
                    nHab = municipio.getnHabitantes();
                    media = (consumo / nHab);
                    mensaje = "Sus " + nHab + " hogares han consumido un total de " + consumo + " m3, con una media de " + media + " m3/habitante";
                }
            }
            return mensaje;
        } else {
            return "¡Error, ese municipio no existe!";
        }
    }

}//Fin de clase
