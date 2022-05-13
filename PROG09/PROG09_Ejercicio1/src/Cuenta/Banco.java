package Cuenta;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;


public class Banco {
//Inicializamos variables

    protected static int contador;
    protected Set<CuentaBancaria> cuentas;
    private static File f=new File("datoscuentasbancarias.dat");
    private static File fCCC= new File ("ListadoClientesCCC.txt");

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
        this.cuentas.add(cuenta);
        resultado = true;
        System.out.println(cuentas.size());

        return resultado;
    }

    public String[] listadoCuentas() {
        String[] listado = new String[cuentas.size()];
        int i = 0;
        
        for (CuentaBancaria cuenta : cuentas) {
            listado[i] = "Datos cuenta: " + "\n" + cuenta.devolverInfoString();
            i++;
        }

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


    public boolean eliminarCuenta(String IBAN) {
        boolean eliminar = false;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.IBAN.equals(IBAN)) {
                if (cuenta.saldoActual == 0) {
                    cuentas.remove(cuenta);
                    eliminar = true;
                }
            }
        }

        return eliminar;
    }
public void crearArchivo(){
    try{
            f.createNewFile();
            System.out.println("Fichero creado");
        }catch(Exception ex){
            System.err.println("ERROR: "+ex.getMessage());
        }
}
    /*
Cuando la aplicación finalice, es decir, el usuario seleccione la opción Salir, 
la aplicación volcará el contenido de la estructura de datos con las cuentas bancarias a un fichero binario denominado datoscuentasbancarias.dat.
     */
    public void guardarDatos() {
        try {
            if(!f.exists()) f=new File("datoscuentasbancarias.dat");   
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0;i<cuentas.size();i++){

            oos.writeObject(cuentas);
            oos.close();
            fos.close();
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }

    }
//Cargamos los datos del archivo creado mediante los wrappers
    public void cargarDatos() {
try{
            if(!f.exists()){
                crearArchivo();
            }else{
                if(f.canRead()){
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    cuentas = (HashSet<CuentaBancaria>)ois.readObject();
                    ois.close();
                    fis.close();
                }else{
                    System.err.println("FICHERO VACÍO");
                }
            }
        }catch(IOException | ClassNotFoundException ex){
            System.err.println("Error: "+ex.getMessage());
        }
    }

    public void guardarDatosCCC() {
        try {
            //En caso de que no exista el fichero lo creamos
            if(!fCCC.exists()) fCCC=new File("ListadoClientesCCC.txt");   
            //Definimos los wrappers
            FileWriter fCCC = null;
            PrintWriter pw = null;
            //En el FileWriter definimos el fichero sobre el que escribira
            fCCC = new FileWriter("ListadoClientesCCC.txt");
            //En el PrintWriter le decimos a que objeto tiene que escribir
            pw = new PrintWriter(fCCC);
            //Decimos que escriba el Array recibido por el metodo listado clientes
            pw.println(listadoClientes());
           //Cerramos los Wrappers
            pw.close();
            fCCC.close();
            
        }catch(Exception ex){
            System.err.println("Ha ocurrido un error inesperado en el guardado de los Datos");
        }

    }

//Metodo que genera el String que vamos a guardar en el fichero
public String listadoClientes(){
    String lista = "Listado de Clientes\n";
    
    for(CuentaBancaria i:this.cuentas){
        lista = lista + i.getTitular().getNombre()+ " " + i.getTitular().getApellidos() + " " + i.getIBAN() + "\n"; 
    }
    lista += "Numero total de cuentas existentes: " + this.cuentas.size();
    return lista;
}
    
}//Fin de clase
