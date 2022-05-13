package Cuenta;

public class CuentaCorrientePersonal extends CuentaCorriente {

    //Comisión de mantenimiento (para el caso de una cuenta corriente personal).
    private double comisionMantenimiento;
//Constructor
    public CuentaCorrientePersonal(double comisionMantenimiento, String entidadesAutorizadas, double saldoActual, String IBAN, Persona titular) {
        super(entidadesAutorizadas, saldoActual, IBAN, titular);
        this.comisionMantenimiento = comisionMantenimiento;
    }
//Getter comisionMantenimiento
    public double getComisionMantenimiento() {
        return comisionMantenimiento;
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
                + "\nLa comision de mantenimiento es: " + this.comisionMantenimiento
                + "\nLas entidades Autorizadas son: " + this.entidadesAutorizadas;
    }
    
}