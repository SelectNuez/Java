
package Clientes;

import java.util.Objects;


public class Cliente {
    private String nombre;
    private String n_cuenta;
    private double saldo;

    public Cliente(String nombre, String n_cuenta, double saldo) {
        this.nombre = nombre;
        this.n_cuenta = n_cuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getN_cuenta() {
        return n_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.n_cuenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.n_cuenta, other.n_cuenta);
    }
    
         
        
}
