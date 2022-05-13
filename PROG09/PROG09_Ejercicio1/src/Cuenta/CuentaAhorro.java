package Cuenta;
//Las cuentas de ahorro son remuneradas y tienen un determinado tipo de interés.
//Depende de CuentaBancaria
public class CuentaAhorro extends CuentaBancaria{
    //Tipo de interés anual (si se trata de una cuenta de ahorro).
    protected double interesAnual;
//Contructor
    public CuentaAhorro(double interesAnual, double saldoActual, String IBAN, Persona titular) {
        super(saldoActual, IBAN, titular);
        this.interesAnual = interesAnual;
    }
//Sobreescribimos la clase de la Interfaz y devolvemos los datos
    @Override
    public String devolverInfoString() {
        return "El titular es:" + titular.nombre + " " +titular.apellidos + " Con DNI: " + titular.DNI 
                + "\nEl IBAN de la cuenta es: " + this.IBAN 
                +  "\nEl saldo de la cuenta es: " + this.saldoActual
                +  "\nEl interes Anual es: " + this.interesAnual;
    }
}
