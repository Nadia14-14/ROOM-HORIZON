/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MAIN;

import GUI.VentanaPrincipal;
import HILOS.HiloMovimiento;

import javax.swing.*;

public class LineaDeProduccion {
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();  // Crea y muestra la ventana principal

        while (true) {
            String input = JOptionPane.showInputDialog("Ingrese la cantidad de artículos:");  // Solicita al usuario la cantidad de artículos
            if (input == null || input.isEmpty()) break;  // Si el usuario no ingresa nada, finaliza

            int cantidadArticulos = Integer.parseInt(input);  // Convierte el texto ingresado a un número
            if (cantidadArticulos <= 0) break;  // Finaliza si la cantidad es 0 o negativa

            HiloMovimiento movimiento = new HiloMovimiento(cantidadArticulos, ventana.getPanelProduccion());  // Crea un nuevo hilo de movimiento
            movimiento.start();  // Inicia el hilo de movimiento

            // Espera a que termine el hilo actual antes de preguntar si quiere agregar más productos
            try {
                movimiento.join();  // Espera a que el hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Pregunta al usuario si desea agregar más productos
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar más productos?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                // Muestra un mensaje final si el usuario no desea agregar más productos
                JOptionPane.showMessageDialog(null, "Todos los artículos en la banda han sido empaquetados de manera exitosa.", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                break;  // Sale del bucle y finaliza el programa
            }
        }

        System.out.println("Programa terminado.");  // Mensaje en consola indicando que el programa ha finalizado
    }
}
