package Cuenta;

public class Banco {
//Inicializamos variables
    protected static int contador;
    protected CuentaBancaria[] cuentas;
//Contructor Banco
    public Banco() {
        cuentas = new CuentaBancaria[100];
        Banco.contador = 0;
    }
//Metodo abrir que guarda el objeto cuenta el el array cuentas    
//Devuelve true si se ha podido crear la cuenta
    

    public int numeroCuentas() {
        return contador;
    }
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        boolean resultado = false;
        this.cuentas[Banco.contador] = cuenta;
        resultado = true;
//Suma 1 al contador cada vez que se crea de forma que se van almacenando todos los objetos cuenta
        Banco.contador++;
        return resultado;
    }


    public String[] listadoCuentas() {
        String[] listado = new String[Banco.contador];
        for (int m = 0; m < Banco.contador; m++) {
            listado[m] = "Datos cuenta " + (m + 1) + " :\n " + this.cuentas[m].devolverInfoString();
        }
        return listado;
    }
//Intoduce un IBAN y si se ecuentra se devuelve la cuenta llamando al metodo imprimible, sino devuelve null

    public String informacionCuenta(String IBAN) {
        String informacion = null;
        for (int n = 0; n < Banco.contador; n++) {
            if (IBAN.equals(this.cuentas[n].IBAN)) {
                informacion = this.cuentas[n].devolverInfoString();
            }
        }
        System.out.println(informacion);
        return informacion;
    }
//Devuelve un true si se ha ingresado correctamente el dinero y false si ha habido algun error

    public boolean ingresoCuenta(String IBAN, double cantidad) {
        int numCuenta = -1;
        //Busca la cuenta y actualiza numCuenta en caso de que encuentre la cuenta
        for (int i = 0; i < Banco.contador; i++) {
            if (this.cuentas[i].IBAN.equals(IBAN)) {
                numCuenta = i;
            }
        }
        if (numCuenta == -1) {
            return false;
        } else {
            this.cuentas[numCuenta].saldoActual += cantidad;
            return true;
        }
    }
//Solicita el IBAN y una cantidad
    public boolean retiradaCuenta(String IBAN, double cantidad) {
        int numCuenta = -1;
        //Busca la cuenta y actualiza numCuenta en caso de que encuentre la cuenta
        for (int j = 0; j < Banco.contador; j++) {
            if (this.cuentas[j].IBAN.equals(IBAN)) {
                numCuenta = j;
            }
        }
        //Si la cuenta no se ha encontrado devuelve false
        if (numCuenta == -1) {
            return false;
            //Si la cantidad es mayor que el saldo devuelve false
        } else if (cantidad > this.cuentas[numCuenta].saldoActual) {
            return false;
        } else {
            //Resta la cantidad
            this.cuentas[numCuenta].saldoActual -= cantidad;
            return true;
        }

    }
//Solicitamos el IBAN y si  se encuentra devolvemos el saldo actual
    public double obtenerSaldo(String IBAN) {
        int numCuenta = -1;
        for (int k = 0; k < Banco.contador; k++) {
            if (this.cuentas[k].IBAN.equals(IBAN)) {
                numCuenta = k;
            }
        }
        if (numCuenta == -1) {
            return -1;
        } else {
            return this.cuentas[numCuenta].saldoActual;
        }
    }

}
