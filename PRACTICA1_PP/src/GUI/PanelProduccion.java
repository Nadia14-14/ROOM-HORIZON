/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelProduccion extends JPanel {  // Clase que extiende JPanel para el diseño de la línea de producción
    private JLabel lblContador, lblEmpaquetados, lblTitulo;  // Etiquetas para el título y los contadores
    private JLabel cajaAbiertaLabel, cajaCerradaLabel;  // Etiquetas para la caja abierta y cerrada
    private int posX = 0;  // Posición inicial de la caja abierta en el eje X

    public PanelProduccion() {
        setLayout(null);  // Usa un layout nulo para posicionamiento absoluto

        // Título de la interfaz
        lblTitulo = new JLabel("LÍNEA DE PRODUCCIÓN\n", SwingConstants.CENTER);  // Crea el título centrado
        lblTitulo.setFont(new Font("Britannic Bold", Font.BOLD, 18));  // Aplica fuente y tamaño al título
        lblTitulo.setBounds(0, 10, 800, 30);  // Posiciona y ajusta el tamaño del título
        add(lblTitulo);  // Añade el título al panel

        // Imagen de fondo de la línea de producción
        JLabel fondoLabel = new JLabel(new ImageIcon("C:/Users/HP/Downloads/fondo.jpg"));  // Carga la imagen de fondo
        fondoLabel.setBounds(0, 0, 800, 600);  // Define el tamaño del fondo
        add(fondoLabel);  // Añade el fondo al panel

        // Caja abierta (primer estado)
        cajaAbiertaLabel = new JLabel(new ImageIcon("C:/Users/HP/Downloads/abierta caja.png"));  // Carga la imagen de caja abierta
        cajaAbiertaLabel.setBounds(posX, 300, 100, 100);  // Define la posición inicial de la caja abierta
        fondoLabel.add(cajaAbiertaLabel);  // Añade la caja abierta al fondo

        // Caja cerrada (segundo estado), inicialmente invisible
        cajaCerradaLabel = new JLabel(new ImageIcon("C:/Users/HP/Downloads/cerrada caja.png"));  // Carga la imagen de caja cerrada
        cajaCerradaLabel.setBounds(posX, 300, 100, 100);  // Define la posición de la caja cerrada
        cajaCerradaLabel.setVisible(false);  // Oculta la caja cerrada inicialmente
        fondoLabel.add(cajaCerradaLabel);  // Añade la caja cerrada al fondo

        // Contadores
        lblContador = new JLabel("Artículos en la banda: 0");
        lblEmpaquetados = new JLabel("Artículos empaquetados: 0");
        lblContador.setBounds(10, 10, 200, 30);
        lblEmpaquetados.setBounds(10, 40, 200, 30);
        add(lblContador);
        add(lblEmpaquetados);
    }

    public JLabel getCajaAbiertaLabel() {
        return cajaAbiertaLabel;  // Devuelve la etiqueta de la caja abierta
    }

    public JLabel getCajaCerradaLabel() {
        return cajaCerradaLabel;  // Devuelve la etiqueta de la caja cerrada
    }

    public JLabel getLblContador() {
        return lblContador;  // Devuelve la etiqueta del contador de artículos en la banda
    }

    public JLabel getLblEmpaquetados() {
        return lblEmpaquetados;  // Devuelve la etiqueta del contador de artículos empaquetados
    }
}
