package main;

import java.util.ArrayList;
import java.util.Random;

public class Rndm {

    ArrayList<Integer> numeros = new ArrayList<>();
    Random rand = new Random();
   
    
//Genera numeros aleatorios y los almacena en un array
    public Rndm() {
        int leng = Capitales.getLenHash();
        int numRand;
        for (int i = 0; i < Capitales.getNumPreg(); i++) {
            numRand = rand.nextInt(leng);
            while (numeros.contains(numRand)) {
                numRand = rand.nextInt(leng);
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
