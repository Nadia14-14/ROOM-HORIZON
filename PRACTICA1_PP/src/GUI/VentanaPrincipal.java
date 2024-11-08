/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {  // Clase que extiende JFrame para crear la ventana principal
    private JLabel fondoLabel, cajaAbiertaLabel, cajaCerradaLabel;  // Etiquetas para el fondo y las cajas que estaran en la linea de produccion
    private PanelProduccion panelProduccion;  // Panel que contendrá la línea de producción

    public VentanaPrincipal() {
        setTitle("Línea de Producción");  // Establece el título de la ventana
        setSize(800, 560);  // Define el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define la operación de cierre al salir
        setLocationRelativeTo(null);  // Centra la ventana en la pantalla
        setLayout(null);  // Usa un layout nulo para posicionamiento absoluto
        setResizable(false);  // Evita que la ventana sea redimensionable


        // Panel de producción que contendrá la banda y las cajas
        panelProduccion = new PanelProduccion(); // clase de panel de proudccion
        panelProduccion.setBounds(0, 0, 800, 600);  // Establece el tamaño y posición del panel
        add(panelProduccion);  // Añade el panel de producción a la ventana
        
        setVisible(true);  // Hace visible la ventana
    }

    public PanelProduccion getPanelProduccion() {
        return panelProduccion;  // Método para obtener el panel de producción
    }
}

