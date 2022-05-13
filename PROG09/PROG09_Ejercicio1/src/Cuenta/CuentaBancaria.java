
package Cuenta;
import java.io.Serializable;
import javax.swing.JOptionPane;
//Creamos una clase abstracta e implementamos la interfaz imprimible
public abstract class CuentaBancaria implements Imprimible,Serializable{
    //Saldo actual de la cuenta.
    protected double saldoActual;
    //Número de cuenta (IBAN).
    protected String IBAN;
    protected Persona titular;
//Contructor
    public CuentaBancaria(double saldoActual, String IBAN,Persona titular) {
        this.saldoActual = saldoActual;
        this.IBAN = IBAN;
        this.titular = titular;
        
    }  
//Devolvemos el IBAN
    public String getIBAN() {
        return IBAN;
    }

    public Persona getTitular() {
        return titular;
    }

}
