package PROG05_Ejerc1_util;
/*
Autor Jorge Martin
Clase que valida un DNI
*/
public class Validaciones {


            public static boolean validar(String dni) { //Retorna un boolean true si el DNI es correcto
                //Inicialiazamos las variables
                boolean esValido = false; 
                int i = 0;
                int caracterASCII = 0;
                char letra = ' ';
                int miDNI = 0;
                int resto = 0;
                //Introducimos un Array con las posibles letras del DNI
                char[] letraDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
                //Si la longitud del DNI es igual a 9 y ademas hay un caracter en la novena posicion(Las posiciones comienzan en el 0)
                if (dni.length() == 9 && Character.isLetter(dni.charAt(8))) {
                    
                    do {
                        //Creamos dentro de caracterASCII, con cada numero, que este entre las posiciones UNICODE 47 y 58, de manera que sean los numeros 0-9
                        caracterASCII = dni.codePointAt(i);
                        //Si esta dentro de 0-9 en UNICODE comprobamos el siguiente caracter
                        esValido = (caracterASCII > 47 && caracterASCII < 58);
                        i++;
                        //Mientras la longitud del DNI sea menor a 8,ya que la ultima es una letra, y mientras todos sean correctos.
                    } while (i < dni.length() - 1 && esValido);
                }
                //
                //Si todo son numeros esValido es True, por lo que inicia el siguiente bucle.
                if (esValido) {
                    //igualamos letra a el caracter en mayuscula
                    letra = Character.toUpperCase(dni.charAt(8));
                    //Pasamos el dni a un substring de las posiciones 0 a 8 (los numeros),el resto lo convertimos a entero.
                    miDNI = Integer.parseInt(dni.substring(0, 8));
                    //Dividimos entre 23 para averiguar la letra con el resto
                    resto = miDNI % 23;
                    //Si letra es igual a la letra en la posicion de la tabla letraDNI, es valido = true
                    esValido = (letra == letraDNI[resto]);
                }
                //Si se han validado las dos opciones, el DNI es valido
                return esValido;
            }
        }

    

