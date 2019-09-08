/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_simple_bd_0;

import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class Ej_Simple_BD_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos();

        try {
            bd.conectar();

            String id = JOptionPane.showInputDialog("ingrese el id del producto");
            String nombre = JOptionPane.showInputDialog("ingrese el nombre del producto");
            String categoria = JOptionPane.showInputDialog("ingrese la categoria del producto");
            
            bd.insertaProducto(id, nombre, categoria);
            bd.leerProductos();
            
            bd.desconectar();
        } catch (Exception e) {
        }
    }

}
