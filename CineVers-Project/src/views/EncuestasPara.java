/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 *
 * @author jhonnyd
 */
public class EncuestasPara {
    
    // Estilos predefinidos
    public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);
    public static final Color BORDER_COLOR = new Color(200, 200, 200);
    public static final Color BUTTON_BG = new Color(70, 130, 180);
    public static final Color BUTTON_FG = Color.WHITE;
    
    /**
     * Aplica estilo uniforme a un JTextField
     */
    public static void styleTextField(JTextField textField) {
        textField.setFont(DEFAULT_FONT);
        textField.setBorder(createStyledBorder());
        textField.setPreferredSize(new Dimension(250, 35));
    }
    
    /**
     * Aplica estilo uniforme a un JTextArea
     */
    public static void styleTextArea(JTextArea textArea) {
        textArea.setFont(DEFAULT_FONT);
        textArea.setBorder(createStyledBorder());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }
    
    /**
     * Aplica estilo uniforme a un JComboBox
     */
    public static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(DEFAULT_FONT);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(createStyledBorder());
    }
    
    
    /**
     * Aplica estilo uniforme a un JCheckBox
     */
    public static void styleCheckBox(JCheckBox checkBox) {
        checkBox.setFont(DEFAULT_FONT);
        checkBox.setFocusPainted(false);
    }
    
    /**
     * Aplica estilo uniforme a un JLabel
     */
    public static void styleLabel(JLabel label) {
        label.setFont(DEFAULT_FONT);
    }
    
    /**
     * Aplica estilo a todos los componentes de un contenedor
     */
    public static void styleContainer(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) {
                styleTextField((JTextField) comp);
            } else if (comp instanceof JTextArea) {
                styleTextArea((JTextArea) comp);
            } else if (comp instanceof JComboBox) {
                styleComboBox((JComboBox<?>) comp);
            } else if (comp instanceof JCheckBox) {
                styleCheckBox((JCheckBox) comp);
            } else if (comp instanceof JLabel) {
                styleLabel((JLabel) comp);
            }
            
            // Si el componente es un contenedor, aplicar recursivamente
            if (comp instanceof Container) {
                styleContainer((Container) comp);
            }
        }
    }
    
    /**
     * Crea un borde estilizado para los campos
     */
    private static Border createStyledBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );
    }
    
    /**
     * Método para crear un JTextField ya estilizado
     */
    public static JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        styleTextField(textField);
        return textField;
    }
    
    
    /**
     * Método para crear un JComboBox ya estilizado
     */
    public static JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        styleComboBox(comboBox);
        return comboBox;
    }
}
