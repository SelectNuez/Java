package Principal;

import Cuenta.Banco;
import Cuenta.CuentaAhorro;
import Cuenta.CuentaBancaria;
import Cuenta.CuentaCorrientePersonal;
import Cuenta.Persona;
import Comprobaciones.Comprobaciones;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        //Creamos las variables e inicializamos
        int menu = 0, menuCuenta = 0, valido;
        String nombre, apellidos, DNI, IBAN, entidadesAutorizadas;
        String[] lista;
        double saldoInicial = 0, interesAnual, comisionMantenimiento, interesDescubierto, maximoDescubierto, comisionFija, cantidad = 0;
        boolean abrirCuenta = false;
        //Inicializammos el banco
        Banco banco;
        banco = new Banco();
        CuentaBancaria cuenta;
        Persona titular;

        //Generamos el menu
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "1.Abrir una nueva cuenta.\n"
                    + "2.Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).\n"
                    + "3.Obtener los datos de una cuenta concreta.\n"
                    + "4.Realizar un ingreso en una cuenta.\n"
                    + "5.Retirar efectivo de una cuenta.\n"
                    + "6.Consultar el saldo actual de una cuenta.\n"
                    + "7.Salir de la aplicación."));

            switch (menu) {
                case (1):
                    //Solicitamos los datos del titular
                    nombre = JOptionPane.showInputDialog("Introduzca el nombre del titular");
                    apellidos = JOptionPane.showInputDialog("Introduzca los apellidos del titular");
                    do {
                        //Comprobamos los datos del DNI en caso de que sea incorrecto lanzamos una excepcion
                        DNI = JOptionPane.showInputDialog("Introduzca el DNI del titular");
                        valido = 1;
                        try {
                            Comprobaciones.validarDNI(DNI);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "DNI incorrecto");
                            valido = 0;
                        }
                    } while (valido == 0);
                    titular = new Persona(nombre, apellidos, DNI);
                    saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el saldo inicial:"));
                    do {
                        //Comprobamos los datos del IBAN en caso de que sea incorrecto lanzamos una excepcion
                        IBAN = JOptionPane.showInputDialog("Introduzca el IBAN de la cuenta: ");
                        valido = 1;
                        try {
                            Comprobaciones.validarIBAN(IBAN);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "IBAN incorrecto");
                            valido = 0;
                        }
                    } while (valido == 0);
                    //Preguntamos por el tipo de cuenta que quiere abrir
                    do {
                        menuCuenta = Integer.parseInt(JOptionPane.showInputDialog(
                                "Introduzca el tipo de cuenta que desea abrir:"
                                + "\n1.-Cuenta Corriente Personal"
                                + "\n2.-Cuenta Corriente Empresa"
                                + "\n3.-Cuenta de Ahorro"));

                        switch (menuCuenta) {
                            //Si crea una cuenta Personal
                            case 1:
                                comisionMantenimiento = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la comision de mantenimiento: "));
                                entidadesAutorizadas = JOptionPane.showInputDialog("Introduzca las entidades autorizadas a realizar cobros");
                                cuenta = new CuentaCorrientePersonal(comisionMantenimiento, entidadesAutorizadas, saldoInicial, IBAN, titular);
                                abrirCuenta = banco.abrirCuenta(cuenta);
                                if (abrirCuenta == true) {
                                    JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error creando la cuenta");
                                }

                                break;
                            //Si crea una cuenta de Empresa
                            case 2:
                                maximoDescubierto = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el maximo permitido de descubierto: "));
                                interesDescubierto = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el tipo de interes por descubierto: "));
                                comisionFija = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la comision fija en caso de descubierto: "));
                                cuenta = new CuentaAhorro(interesDescubierto, saldoInicial, IBAN, titular);
                                abrirCuenta = banco.abrirCuenta(cuenta);
                                if (abrirCuenta == true) {
                                    JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error creando la cuenta");
                                }
                                break;
                            //Si crea una cuenta de ahorro
                            case 3:
                                interesAnual = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el tipo de interes de remuneracion"));
                                cuenta = new CuentaAhorro(interesAnual, saldoInicial, IBAN, titular);
                                abrirCuenta = banco.abrirCuenta(cuenta);
                                if (abrirCuenta == true) {
                                    JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error creando la cuenta");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "La opcion introducida no es valida, por favor, introduzca la opcion de nuevo");
                                break;
                        }
                    } while (abrirCuenta == false);

                    break;

                //2.Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual)
                case (2):
                    lista = banco.listadoCuentas();
                    for (int i = 0; i < banco.numeroCuentas(); i++) {
                        JOptionPane.showMessageDialog(null, lista[i]);
                    }
                    break;
                //3.Obtener los datos de una cuenta concreta.
                case (3):
                    IBAN = JOptionPane.showInputDialog("Introduce el IBAN de la cuenta de la que quieres obtener los datos: ");
                    nombre = banco.informacionCuenta(IBAN);
                    System.out.println(nombre);
                    JOptionPane.showMessageDialog(null, banco.informacionCuenta(IBAN));
                    break;
                //4.Ingresar un cantidad en una cuenta
                case (4):
                    do {
                        cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la cantidad que desea ingresar(Cantidad mayor que 0):  "));
                        IBAN = JOptionPane.showInputDialog("Introduce el IBAN de la cuenta de la que quieres obtener los datos: ");
                    } while (cantidad < 0);
                    if (banco.ingresoCuenta(IBAN, cantidad) == true) {
                        JOptionPane.showMessageDialog(null, "Ingreso realizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo ha salido mal, por favor, vuelva a intentarlo mas tarde");
                    }
                    break;
                //5.Retirar efectivo de una cuenta.

                case (5):
                    do {
                        cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la cantidad que desea retirar:  "));
                        IBAN = JOptionPane.showInputDialog("Introduce el IBAN de la cuenta de la que quieres obtener los datos: ");
                    } while (cantidad < 0);
                    if (banco.retiradaCuenta(IBAN, cantidad) == true) {
                        JOptionPane.showMessageDialog(null, "Retirada realizada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Algo ha salido mal, por favor, vuelva a intentarlo mas tarde");
                    }
                    break;

                //6.Consultar el saldo actual de una cuenta.
                case (6):
                    IBAN = JOptionPane.showInputDialog("Introduce el IBAN de la cuenta de la que quieres obtener los datos: ");
                    JOptionPane.showMessageDialog(null, "El saldo de la cuenta introducida es: " + banco.obtenerSaldo(IBAN));
                    break;
                case (7):
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                    break;
            }

        } while (menu != 7);
    }

}
