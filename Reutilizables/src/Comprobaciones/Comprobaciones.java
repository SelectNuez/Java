package Comprobaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comprobaciones {
//Clase ValidarDNI que devuelve una excepcion si el DNI no cumple las condiciones
    public static void validarDNI(String DNI) throws Exception {
        Pattern patronDNI = Pattern.compile("[XYxy]?[0-9]{7,8}[a-zA-Z]");
        Matcher m;
        m = patronDNI.matcher(DNI);
        //Comprobamos el formato del DNI
        if (m.matches() == false) {
            throw new Exception("DNI no valido");
        }
    }
//Clase validarIBAN que devuelve una excepcion si el IBAN no cumple las condiciones

    public static void validarIBAN(String IBAN) throws Exception {
        Pattern patronIBAN = Pattern.compile("ES[0-9]{20}");
        Matcher m;
        m = patronIBAN.matcher(IBAN);
        //Comprobamos el formato del DNI
        if (m.matches() == false) {
            throw new Exception("IBAN incorrecto");
        }
    }
}


