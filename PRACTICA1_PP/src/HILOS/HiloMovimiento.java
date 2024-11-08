/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HILOS;

import GUI.PanelProduccion;
import javax.swing.*;

public class HiloMovimiento extends Thread {  // Clase que extiende Thread para gestionar el movimiento de las cajas
    private int cantidadArticulos;  // Cantidad total de artículos a procesar
    private int empaquetados = 0;  // Contador de artículos empaquetados
    private PanelProduccion panel;  // Panel de producción para actualizar los elementos gráficos
    private int posXAbierta = 0;  // Posición inicial de la caja abierta en el eje X
    private int posXCerrada = 450; // Posición inicial de la caja cerrada en el eje X

    public HiloMovimiento(int cantidadArticulos, PanelProduccion panel) {
        this.cantidadArticulos = cantidadArticulos;  // Inicializa la cantidad de artículos
        this.panel = panel;  // Asocia el panel de producción
    }

    @Override
    public void run() {
        while (empaquetados < cantidadArticulos) {  // Bucle hasta empaquetar todos los artículos
            // Mueve la caja abierta 
            while (posXAbierta < 200) {
                posXAbierta += 5;  // Incrementa la posición de la caja abierta
                panel.getCajaAbiertaLabel().setBounds(posXAbierta, 300, 100, 100);  // Actualiza la posición en el panel
                panel.getLblContador().setText("Artículos en la banda: " + (empaquetados + 1));  // Actualiza el contador en la interfaz
                
                try {
                    Thread.sleep(60);  // Pausa para simular el movimiento gradual
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // Oculta la caja abierta
            panel.getCajaAbiertaLabel().setVisible(false);  // Oculta la caja abierta
            panel.getCajaCerradaLabel().setBounds(posXCerrada, 300, 100, 100);  // Posiciona la caja cerrada en la línea azul
            panel.getCajaCerradaLabel().setVisible(true);  // Muestra la caja cerrada

            try {
                Thread.sleep(100);  // Simula el tiempo de empaquetado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Mueve la caja cerrada lentamente hasta el final de la banda
            while (posXCerrada < 700) {
                posXCerrada += 2;  // Movimiento más lento para la caja cerrada
                panel.getCajaCerradaLabel().setBounds(posXCerrada, 300, 100, 100);  // Actualiza la posición de la caja cerrada
                
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Incrementa el contador de empaquetados y restablece las posiciones
            empaquetados++;
            panel.getLblEmpaquetados().setText("Artículos empaquetados: " + empaquetados);  // Actualiza el contador de empaquetados
            posXAbierta = 0;  // Restablece la posición de la caja abierta
            posXCerrada = 450;  // Restablece la posición de la caja cerrada
            panel.getCajaAbiertaLabel().setBounds(posXAbierta, 300, 100, 100);  // Reubica la caja abierta
            panel.getCajaAbiertaLabel().setVisible(true);  // Muestra la caja abierta
            panel.getCajaCerradaLabel().setVisible(false);  // Oculta la caja cerrada
        }
    }
}
