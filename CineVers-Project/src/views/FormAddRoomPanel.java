/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class FormAddRoomPanel extends JPanel {

    private final int FIELD_WIDTH = 400;
    private final int FIELD_HEIGHT = 50;
    private ActionListener listener;

    public FormAddRoomPanel(ActionListener listener) {
        this.listener = listener;
        setOpaque(false);
        setBorder(new EmptyBorder(30, 40, 30, 40));
        setLayout(new GridBagLayout());
        buildFormContent();
    }
    
               @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // El color del fondo del panel (blanco/gris claro)
        g2.setColor(new Color(250, 250, 250)); // Puedes ajustar este color si quieres
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40); // 40px de radio para esquinas
        
        // Opcional: El borde sutil gris claro alrededor del panel
        g2.setColor(new Color(0, 0, 0, 30)); // Un gris muy transparente
        g2.setStroke(new BasicStroke(2f)); // Un borde de 2px
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 40, 40);
        
        g2.dispose();
        super.paintComponent(g); // Dibuja el resto de los componentes
    }

    private void buildFormContent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel titleLabel = new JLabel("Administrar Salas");
        titleLabel.setFont(SurveryStyle.TITLE_FONT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(titleLabel, gbc);

        JTextField campoTitulo = SurveryStyle.createStyledTextField("Nombre de Sala");
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(campoTitulo, gbc);
        
        gbc.gridy = 2;
        gbc.gridwidth = 1;

        JTextField numberRoom = SurveryStyle.createStyledTextField("Número de Sala");
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 5);
        add(numberRoom, gbc);

        JComboBox<String> comboActivo = SurveryStyle.createStyledComboBox(new String[]{"Estado de la sala:","Activa", "Inactiva"});
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 5, 10, 0);
        add(comboActivo, gbc);

        gbc.gridy = 3;

        JTextField numberSillas = SurveryStyle.createStyledTextField("Número de Asientos");
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 5);
        add(numberSillas, gbc);

        JComboBox<String> comboCity = SurveryStyle.createStyledComboBox(new String[]{"Selecionar ciudad :","Tunja", "Medellin"});
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 5, 10, 0);
        add(comboCity, gbc);

        JTextField tipeRoom = SurveryStyle.createStyledTextField("Tipo de Sala");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(tipeRoom, gbc);

        JButton botonContinuar = SurveryStyle.createStyledButton("Guardar Sala");
        botonContinuar.setActionCommand("AGREGAR_SALA_FORM");
        botonContinuar.addActionListener(listener);

        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(botonContinuar, gbc);
    }

    private Component createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(200, 200, 200));
        separator.setPreferredSize(new Dimension(FIELD_WIDTH * 2, 1));
        return separator;
    }
}
