/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
import objetos.Coche;

/**
 *
 * @author Blitz
 */
public class datos {

    private ArrayList<String> residentes;
    private ArrayList<Coche> particulares;

    public ArrayList meterDatosresidentes() {

        residentes = new ArrayList<>();
        residentes.add("5349DYB");
        residentes.add("1129CBZ");
        residentes.add("2239DWS");
        residentes.add("3349CVB");
        residentes.add("4459BVD");
        residentes.add("5569BNM");
return residentes;
    }

    public ArrayList meterDatosParticulares() {
        particulares = new ArrayList<>();
        particulares.add(new Coche("4342DYB", "26-04-2022 13:31:40", true));
        particulares.add(new Coche("1122CBZ", "26-04-2022 13:33:40", true));
        particulares.add(new Coche("2233DWS", "26-04-2022 13:34:40", true));
        particulares.add(new Coche("3344CVB", "26-04-2022 13:35:40", true));
        particulares.add(new Coche("4455BVD", "27-04-2022 10:35:40", false));
        particulares.add(new Coche("5566BNM", "27-04-2022 11:31:40", false));
        particulares.add(new Coche("6677BJK", "27-04-2022 12:37:40", false));
        particulares.add(new Coche("7788DFR", "27-04-2022 13:39:40", false));
        particulares.add(new Coche("7788DFR", "27-04-2022 13:39:40", false));
        return particulares;
    }
}
