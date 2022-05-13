package Cuenta;

import java.util.HashSet;
import java.util.Set;

public class Banco {
//Inicializamos variables

    protected static int contador;
    protected Set<CuentaBancaria> cuentas;
//Contructor Banco,en el inizializo el HashSet en el que se guardaran las distintas cuentas

    public Banco() {
        //Creo que la clase HashSet sera la mas optima ya que no queremos duplicados, tampoco nos interesa que este ordenado
        cuentas = new HashSet<CuentaBancaria>();
    }
//Metodo abrir que guarda el objeto cuenta el el array cuentas    
//Devuelve true si se ha podido crear la cuenta

    public int numeroCuentas() {
        return cuentas.size();
    }

    public boolean abrirCuenta(CuentaBancaria cuenta) {

        boolean resultado = false;

        cuentas.add(cuenta);
        resultado = true;

        return resultado;
    }

    public String[] listadoCuentas() {
        String[] listado = new String[cuentas.size()];
        int i = 0;
        for (CuentaBancaria cuenta : cuentas) {
            listado[i] = "Datos cuenta: " + "\n" + cuenta.devolverInfoString();
        }

//        String[] listado = new String[Banco.contador];
//        for (int m = 0; m < Banco.contador; m++) {
//            listado[m] = "Datos cuenta " + (m + 1) + " :\n " + this.cuentas[m].devolverInfoString();
//        }
        return listado;
    }
//Intoduce un IBAN y si se ecuentra se devuelve la cuenta llamando al metodo imprimible, sino devuelve null

    public String informacionCuenta(String IBAN) {
        String informacion = null;
        for (CuentaBancaria cuenta : cuentas) {
            if (IBAN.equals(cuenta.IBAN)) {
                informacion = cuenta.devolverInfoString();
            }
        }
//        String informacion = null;
//        for (int n = 0; n < Banco.contador; n++) {
//            if (IBAN.equals(this.cuentas[n].IBAN)) {
//                informacion = this.cuentas[n].devolverInfoString();
//            }
//        }
        return informacion;
    }
//Devuelve un true si se ha ingresado correctamente el dinero y false si ha habido algun error

    public boolean ingresoCuenta(String IBAN, double cantidad) {
        boolean ingreso = false;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.IBAN.equals(IBAN)) {
                cuenta.saldoActual += cantidad;
                ingreso = true;
                
            } 
        }
        return ingreso;

//        int numCuenta = -1;
//        //Busca la cuenta y actualiza numCuenta en caso de que encuentre la cuenta
//        for (int i = 0; i < Banco.contador; i++) {
//            if (this.cuentas[i].IBAN.equals(IBAN)) {
//                numCuenta = i;
//            }
//        }
//        if (numCuenta == -1) {
//            return false;
//        } else {
//            this.cuentas[numCuenta].saldoActual += cantidad;
//            return true;
//        }
    }

//Solicita el IBAN y una cantidad
    public boolean retiradaCuenta(String IBAN, double cantidad) {
        boolean retirada = false;
        //Busca la cuenta
        for (CuentaBancaria cuenta : cuentas) {
            //Solo en caso de que se encuentre el IBAN y ademas que la cantidad sea menor o igual que el saldo de dicha cuenta devolvera true.
            if (cuenta.IBAN.equals(IBAN)) {
                if (cuenta.saldoActual >= cantidad) {
                    cuenta.saldoActual -= cantidad;
                    retirada = true;
                }
            }
        }
        return retirada;
//        int numCuenta = -1;
//        //Busca la cuenta y actualiza numCuenta en caso de que encuentre la cuenta
//        for (int j = 0; j < Banco.contador; j++) {
//            if (this.cuentas[j].IBAN.equals(IBAN)) {
//                numCuenta = j;
//            }
//        }
//        //Si la cuenta no se ha encontrado devuelve false
//        if (numCuenta == -1) {
//            return false;
//            //Si la cantidad es mayor que el saldo devuelve false
//        } else if (cantidad > this.cuentas[numCuenta].saldoActual) {
//            return false;
//        } else {
//            //Resta la cantidad
//            this.cuentas[numCuenta].saldoActual -= cantidad;
//            return true;
//        }
//
//    }
    }

//Solicitamos el IBAN y si  se encuentra devolvemos el saldo actual
    public double obtenerSaldo(String IBAN) {
        double saldoIBAN = 0;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.IBAN.equals(IBAN)) {
                saldoIBAN = cuenta.saldoActual;
            }
        }
        return saldoIBAN;
    }
//        int numCuenta = -1;
//        for (int k = 0; k < Banco.contador; k++) {
//            if (this.cuentas[k].IBAN.equals(IBAN)) {
//                numCuenta = k;
//            }
//        }
//        if (numCuenta == -1) {
//            return -1;
//        } else {
//            return this.cuentas[numCuenta].saldoActual;
//        }
//    }

    public boolean eliminarCuenta(String IBAN) {
        boolean eliminar = false;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.IBAN.equals(IBAN)) {
                if(cuenta.saldoActual == 0){
                cuentas.remove(cuenta);
               eliminar = true;
                }
            }
        }

        return eliminar;
    }

}//Fin de clase
