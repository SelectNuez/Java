package Cuenta;

public class CuentaCorrienteEmpresa extends CuentaCorriente {

    //Tipo de interés por descubierto (si es una cuenta corriente de empresa).
    private double interesDescubierto;
    //Máximo descubierto permitido (si se trata de una cuenta corriente de empresa)
    private double descubiertoPermitido;
//Constructor

    public CuentaCorrienteEmpresa(double interesDescubierto, double descubiertoPermitido, String entidadesAutorizadas, double saldoActual, String IBAN, Persona titular) {
        super(entidadesAutorizadas, saldoActual, IBAN, titular);
        this.interesDescubierto = interesDescubierto;
        this.descubiertoPermitido = descubiertoPermitido;
    }
//Sobreescribimos el metodo entidadesAutorizadas

    @Override
    public String entidadesAutorizadas() {
        return entidadesAutorizadas;
    }
    //Sobreescribimos la clase de la Interfaz y devolvemos los datos

    @Override
    public String devolverInfoString() {
        return "El titular es:" + titular.nombre + " " + titular.apellidos + " Con DNI: " + titular.DNI
                + "\nEl IBAN de la cuenta es: " + this.IBAN
                + "\nEl saldo de la cuenta es: " + this.saldoActual
                + "\nEl interes Descubierto es: " + this.interesDescubierto
                + "\nEl descubierto permitido es: " + this.descubiertoPermitido
                + "\nLas entidades Autorizadas son: " + this.entidadesAutorizadas;
    }
}
