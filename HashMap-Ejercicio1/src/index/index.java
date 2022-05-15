package index;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Blitz
 */
public class index {

    private static HashMap<String, Integer> inventario = new HashMap<>();

    public index() {
        inventario.put("Patata", 1);
        inventario.put("Macarrones", 4);
        inventario.put("Barbacoa", 10);
    }

    public static void AñadirProducto(String producto, int stock) {
        inventario.put(producto, stock);
    }

    public static boolean comprobarProducto(String producto) {
        return inventario.containsKey(producto);
    }

    public static void AumentarStock(String producto, int stock) {
        if (comprobarProducto(producto)) {
            inventario.replace(producto, stock);
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el stock");

        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto");
        }
    }

    public static void EliminarStock(String producto) {
        if (comprobarProducto(producto)) {
            inventario.replace(producto, 0);
            JOptionPane.showMessageDialog(null, "Producto eliminado");

        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto");
        }
    }

    public static void MostrarProductos() {
        if (index.HashVacio()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            for (Map.Entry<String, Integer> entrada : inventario.entrySet()) {
                String producto = entrada.getKey();
                int stock = entrada.getValue();
                JOptionPane.showMessageDialog(null, "Producto: " + producto
                        + "\nStock : " + stock);
            }
        }
    }

    public void EliminarProductos(String producto) {
        inventario.remove(producto);
    }

    public static boolean HashVacio() {
        return inventario.isEmpty();
    }

}
