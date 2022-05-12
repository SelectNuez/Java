package Aleatorios;

import java.util.ArrayList;
import java.util.Random;
import main.Capitales;

public class Rndm {

  private ArrayList<Integer> numeros = new ArrayList<>();
  private  Random rand = new Random();
   
    
//Genera numeros aleatorios y los almacena en un array
    public Rndm(int max) {
        int numRand;
        for (int i = 0; i < max; i++) {
            numRand = rand.nextInt(max);
            while (numeros.contains(numRand)) {
                numRand = rand.nextInt(max);
            }
            numeros.add(numRand);
        }
    }
/**
 * 
 * @return Un array con los numeros aleatorios solicitados 
 */
    
    
    public ArrayList<Integer> getNumeros() {
        return numeros;
    }
    
    
}
