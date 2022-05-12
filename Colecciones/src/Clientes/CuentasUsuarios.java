package Clientes;

import java.util.*;
import javax.swing.JOptionPane;

public class CuentasUsuarios {
    
    public static void main(String[] args) {
        int cont = 0;
        Cliente cl1 = new Cliente("Jorge", "00001", 150000);
        Cliente cl2 = new Cliente("Matias", "00002", 270000);
        Cliente cl3 = new Cliente("Ana", "00003", 100000);
        Cliente cl4 = new Cliente("Julio", "00004", 140000);
        Cliente cl5 = new Cliente("Julio", "00004", 140000);

        Set<Cliente> clientesBanco = new HashSet<Cliente>();
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5);

        if (cl4.equals(cl5)) {
            JOptionPane.showMessageDialog(null, "Es el mismo cliente");
        } else {
            JOptionPane.showMessageDialog(null, "No es el mismo cliente");
        }

        for (Cliente cliente : clientesBanco) {
            cont ++;
            JOptionPane.showMessageDialog(null, "Cliente Numero: " + cont +" Nombre: " + cliente.getNombre() + " Numero cuenta: " + cliente.getN_cuenta() + " Saldo: " + cliente.getSaldo());

        }
    }
}
