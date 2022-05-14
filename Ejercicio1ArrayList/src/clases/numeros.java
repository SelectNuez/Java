package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Blitz
 */
public class numeros {
ArrayList<Integer> arrayNum  = new ArrayList<>();
    public numeros(){
    
    }

    public void agregarNumero(int numero) {
        arrayNum.add(numero);
    }
    
    public void listadoNumeros(){
        int index = 1;
        for (Integer numero : arrayNum) {
            JOptionPane.showMessageDialog(null, "El numero almacenado en la posicion " + index + " es: " + numero.intValue());
            index++;
        }
    }
    public int sumaNumeros(){
        int suma= 0;
        for (Integer numero : arrayNum) {
            suma +=  numero.valueOf(numero);
        }
        return suma;
    }
    
    public double mediaNumeros(){
    int media = 0;
    media = sumaNumeros()/arrayNum.size();
    return media;
    }
}
