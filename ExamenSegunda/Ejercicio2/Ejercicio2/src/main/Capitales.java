package main;

import java.util.*;
import javax.swing.JOptionPane;

public class Capitales {

    private static int lenHash;
    HashMap<String, String> capitales_europeas = new HashMap<String, String>();
    private static int numPreg = 5;

    /**
     * Preguntamos al usuario cuantas preguntas quiere
     * Y si se pasa de las que tiene el HashMap le preguntaremos
     * para saber cuantas quiere, si el maximo o la default
     * @param numPreg  El numero de preguntas que quiere el usuario
     */
    public static void setNumPreg(int numPreg) {
        if (numPreg > getLenHash()) {
            JOptionPane.showMessageDialog(null, "Has excedido el numero maximo de respuestas, el limite es: " + getLenHash());
            int input = JOptionPane.showConfirmDialog(null, "¿Quieres participar con " + getLenHash() + " preguntas?");
            if (input == 0) {
                Capitales.numPreg = getLenHash();
            } else {
                JOptionPane.showMessageDialog(null, "Se ha establecido 5 preguntas");
            }

        } else {
            Capitales.numPreg = numPreg;
        }

    }

    public static int getNumPreg() {
        return numPreg;
    }
    
    public Capitales() {

        capitales_europeas.put("Albania", "Tirana");
        capitales_europeas.put("Alemania", "Berlin");
        capitales_europeas.put("Andorra", "Andorra La Vieja");
        capitales_europeas.put("Austria", "Viena");
        capitales_europeas.put("Belgica", "Bruselas");
        capitales_europeas.put("Bielorrusia", "Minsk");
        capitales_europeas.put("Bosnia y Herzegovina", "Sarajevo");
        capitales_europeas.put("Bulgaria", "Sofia");
        capitales_europeas.put("Croacia", "Zagreb");
        capitales_europeas.put("Dinamarca", "Copenhague");
        capitales_europeas.put("Eslovaquia", "Bratislava");
        capitales_europeas.put("Eslovenia", "Liubliana");
        capitales_europeas.put("España", "Madrid");
        capitales_europeas.put("Estonia", "Tallin");
        capitales_europeas.put("Finlandia", "Helsinki ");
        capitales_europeas.put("Francia", "Paris");
        capitales_europeas.put("Grecia", "Atenas");
        capitales_europeas.put("Hungria", "Budapest");
        capitales_europeas.put("Irlanda", "Dublin");
        capitales_europeas.put("Islandia", "Reikiavik");
        capitales_europeas.put("Italia", "Roma");
        capitales_europeas.put("Letonia", "Riga");
        capitales_europeas.put("Liechtenstein", "Vaduz");
        capitales_europeas.put("Lituania", "Vilna");
        capitales_europeas.put("Macedonia del Norte", "Skopie");
        capitales_europeas.put("Malta", "La Valeta");
        capitales_europeas.put("Moldavia", "Chisinau");
        capitales_europeas.put("Monaco", "Monaco");
        capitales_europeas.put("Montenegro", "Podgorica");
        capitales_europeas.put("Noruega", "Oslo");
        capitales_europeas.put("Paises Bajos", "Amsterdan");
        capitales_europeas.put("Polonia", "Varsovia");
        capitales_europeas.put("Portugal", "Lisboa");
        capitales_europeas.put("Reino Unido", "Londres");
        capitales_europeas.put("Republica Checa", "Praga");
        capitales_europeas.put("Rumania", "Bucarest");
        capitales_europeas.put("Rusia", "Moscu");
        capitales_europeas.put("San Marino", "San Marino");
        capitales_europeas.put("Serbia", "Belgrado");
        capitales_europeas.put("Suecia", "Estocolmo");
        capitales_europeas.put("Suiza", "Berna");
        capitales_europeas.put("Ucrania", "Kiev");
        capitales_europeas.put("Vaticano", "Vaticano");
        lenHash = capitales_europeas.size();

    }

    /**
     *
     * @return Longitud del HashMap
     */
    public static int getLenHash() {
        return lenHash;
    }

    /**
     * Repetimos dentro de un bucle segun el numero de preguntas
     * Dentro de el y para cada entrada del HashMap llamamos a otro metodo
     * para que nos las verique
     *@see comprobarPregunta
     * @see resultado
     * @return String con la explicacion de cuantas has acertado o fallado
     */
    public String getPregunta() {
        Rndm rndm = new Rndm();
        int bien = 0;
        for (int i = 0; i < numPreg; i++) {
            int rand = rndm.numeros.get(i);
            //Comienza el contador, que se igualara en el index correcto para mostrar el Hash que queremos
            int cont = 0;
            for (Map.Entry<String, String> entrada : capitales_europeas.entrySet()) {
                cont++;
                if (comprobarPregunta(cont, rand, entrada)) {
                    bien++;
                }
            }
        }
        return this.resultado(bien);
    }
/**
 * Se va a llamar a este metodo las veces que sea necesario segun el numero de preguntas
 * @param cont Contador que indica el index del objeto
 * @param rand Numero aleatorio que indica lo que preguntar en cada pregunta
 * @param entrada El HashMap en formato Map.Entry para poder sacar sus valores
 * @return 
 */
    public boolean comprobarPregunta(int cont, int rand, Map.Entry<String, String> entrada) {
        if (cont == rand) {

            String hashpais = entrada.getKey();
            //Lo asignamos a minusculas
            String hashcapi = entrada.getValue().toLowerCase();
            //Lo asignamos a minusculas
            String capital = JOptionPane.showInputDialog("Introduzca la capital de: " + hashpais).toLowerCase();
            
            if (hashcapi.equals(capital)) {
                JOptionPane.showMessageDialog(null, "Respuesta correcta!");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
                return false;
            }
        }
        return false;
    }
/**
 * 
 * @param bien
 * @return 
 */
    public String resultado(int bien) {
        return "Has tenido: " + bien + " respuestas correctas\n"
                + "Has tenido: " + (numPreg - bien) + " respuestas incorrectas";
    }

}
