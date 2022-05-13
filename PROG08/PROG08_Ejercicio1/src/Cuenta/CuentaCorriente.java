package Cuenta;

//Las cuentas corrientes no son remuneradas, pero tienen asociada una lista de entidades autorizadas para cobrar recibos domiciliados en la cuenta.
//Depende de CuentaBancaria
public abstract class CuentaCorriente extends CuentaBancaria {

    //Lista de entidades autorizadas para cobrar recibos de la cuenta (si se trata de una cuenta corriente).
    protected String entidadesAutorizadas;
//Creamos el metodo abstracto entidadesAutorizadas para que las clases que dependen de CuentaCorriente esten obligadas a dar los datos necesarios
    public abstract String entidadesAutorizadas();
//Constructor
    public CuentaCorriente(String entidadesAutorizadas, double saldoActual, String IBAN, Persona titular) {
        super(saldoActual, IBAN, titular);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }


}
