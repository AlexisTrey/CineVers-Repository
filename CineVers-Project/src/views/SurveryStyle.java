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
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class SurveryStyle {
    
    //
    // --- NUEVOS COLORES BASADOS EN LA IMAGEN ---
    // El púrpura oscuro del botón "Continuar"
    public static final Color ACCENT_COLOR = new Color(85, 40, 120); 
    // El púrpura claro de fondo de los campos de texto
    public static final Color FIELD_BG_COLOR = new Color(140, 90, 190); 
    public static final Color FIELD_FG_COLOR = Color.WHITE; // El texto dentro del campo
    public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 16); // Fuente ligeramente más grande
    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    
    /**
     * Aplica estilo uniforme a un JTextField
     */
   public static JTextField createStyledTextField(String placeholder) {
        // Usamos un JFormattedTextField solo para tener un objeto más avanzado
        JTextField textField = new JTextField(placeholder);
        
        textField.setFont(DEFAULT_FONT);
        textField.setForeground(FIELD_FG_COLOR);
        
        // Estilo de fondo púrpura
        textField.setBackground(FIELD_BG_COLOR);
        textField.setCaretColor(FIELD_FG_COLOR); // Color del cursor
        
        // Ajuste de tamaño y borde
        textField.setPreferredSize(new Dimension(250, 50)); // Más alto
        textField.setBorder(new EmptyBorder(10, 15, 10, 15)); // Relleno interno
        
        // ¡Importante! El campo DEBE ser opaco para que se vea el color.
        textField.setOpaque(true); 
        
        // Opcional: Aplicar borde redondeado a un contenedor
        // Si quieres el efecto redondeado, deberías poner el JTextField dentro
        // de un RoundedPanel, pero el JTextField no puede ser transparente.
        // Lo más sencillo es usar el color de fondo como se hace arriba.
        
        return textField;
    }

    
    /**
     * Aplica estilo uniforme a un JTextArea
     */
    public static JTextArea createStyledTextArea(String placeholder) {
        JTextArea textArea = new JTextArea(placeholder);
        textArea.setFont(DEFAULT_FONT);
        textArea.setForeground(FIELD_FG_COLOR);
        textArea.setBackground(FIELD_BG_COLOR);
        textArea.setCaretColor(FIELD_FG_COLOR);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        // Altura fija para el área de sinopsis
        textArea.setPreferredSize(new Dimension(300, 150)); 
        textArea.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        return textArea;
    }
    
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(TITLE_FONT); // Fuente negrita o más grande
        button.setBackground(ACCENT_COLOR); // Púrpura oscuro
        button.setForeground(Color.WHITE); 
        
        // Quita el borde por defecto y añade un relleno
        button.setBorder(new EmptyBorder(10, 30, 10, 30));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
    
    /**
     * Aplica estilo uniforme a un JComboBox
     */
    public static JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        
        comboBox.setFont(DEFAULT_FONT);
        comboBox.setForeground(FIELD_FG_COLOR);
        comboBox.setBackground(FIELD_BG_COLOR); 
        comboBox.setPreferredSize(new Dimension(300, 50));
        
        // Para hacer el JComboBox más parecido, se requiere un Custom Renderer, 
        // pero por simplicidad se mantienen los colores.
        
        return comboBox;
    }

}
