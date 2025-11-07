package views;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.plaf.basic.BasicTextFieldUI;

/**
 * Clase estática para la creación centralizada de componentes estilizados.
 */
public class SurveryStyle {

    // --- COLORES BASADOS EN LA IMAGEN DE LOGIN ---
    // El púrpura oscuro del botón 'Crear cuenta' y el borde del panel.
    public static final Color ACCENT_COLOR_DARK = new Color(150, 70, 200); 
    // El púrpura claro de fondo de los campos de texto
    public static final Color FIELD_BG_COLOR = new Color(200, 160, 230); 
    public static final Color FIELD_FG_COLOR = Color.WHITE; 
    
    // Gradiente del Botón 'Iniciar Sesión' (de oscuro a claro)
    public static final Color GRADIENT_START = new Color(180, 70, 220); // Púrpura oscuro
    public static final Color GRADIENT_END = new Color(230, 130, 200);   // Rosa claro
    
    public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 16); 
    public static final Font TITLE_FONT = new Font("Segoe UI Black", Font.BOLD, 50); // Usamos Black para el título CineVers
    public static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.BOLD, 24); // Título 'Inicio de Sesión'

    /**
     * Aplica estilo uniforme a un JTextField con esquinas redondeadas.
     */
    public static JTextField createStyledTextField(String placeholder) {
        JTextField textField = new JTextField("");

        // 1. Estilos de fuente y color base
        textField.setFont(DEFAULT_FONT);
        textField.setForeground(FIELD_FG_COLOR);
        textField.setBackground(FIELD_BG_COLOR);    
        textField.setCaretColor(FIELD_FG_COLOR);
        textField.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        textField.setOpaque(false); // Esencial para el custom UI

        // 3. Custom UI para dibujar el fondo redondeado
        textField.setUI(new BasicTextFieldUI() {
            @Override
            protected void paintSafely(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Dibuja el fondo púrpura redondeado (25px de radio)
                g2.setColor(FIELD_BG_COLOR);
                g2.fillRoundRect(0, 0, textField.getWidth(), textField.getHeight(), 25, 25);
                
                super.paintSafely(g);
                g2.dispose();
            }
        });
        
        // 4. Borde y relleno interno
        // Es necesario crear un borde vacío grande para que el texto no se pegue a los bordes redondeados
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 160, 230), 0),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.WHITE);
                }
            }
        });
        textField.setText(placeholder);
        return textField;
    }

    /**
     * Aplica estilo uniforme a un JTextArea.
     */
    public static JTextArea createStyledTextArea(String placeholder) {
        JTextArea textArea = new JTextArea();
        
        // JTextArea es más difícil de redondear directamente. Solo aplicamos el color de fondo.
        textArea.setFont(DEFAULT_FONT);
        textArea.setForeground(FIELD_FG_COLOR);
        textArea.setBackground(FIELD_BG_COLOR);
        textArea.setCaretColor(FIELD_FG_COLOR);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setPreferredSize(new Dimension(300, 150));
        textArea.setBorder(new EmptyBorder(15, 15, 15, 15));


        textArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textArea.getText().equals(placeholder)) {
                    textArea.setText("");
                    textArea.setForeground(Color.WHITE);
                }
            }
            

            @Override
            public void focusLost(FocusEvent e) {
                if (textArea.getText().isEmpty()) {
                    textArea.setText(placeholder);
                    textArea.setForeground(Color.WHITE);
                }
            }
        });
        textArea.setText(placeholder);
        return textArea;
    }

    /**
     * Crea un botón estilizado con gradiente de color y esquinas redondeadas.
     */
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Dibuja el gradiente del botón como en el LoginView
                GradientPaint gp = new GradientPaint(
                    0, 0, GRADIENT_START,
                    getWidth(), getHeight(), GRADIENT_END
                );
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // 30px de radio
                g2.dispose();
                
                // Permite que el texto se dibuje sobre el gradiente
                super.paintComponent(g);
            }
        };

        button.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Fuente del botón
        button.setForeground(Color.WHITE);
        
        // Importante para ver el paintComponent
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        
        button.setPreferredSize(new Dimension(250, 50)); // Tamaño fijo para consistencia
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    /**
     * Aplica estilo uniforme a un JComboBox.
     */
    public static JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        
        // Por la complejidad de estilizar el ComboBox completamente, 
        // solo aplicamos el fondo púrpura del campo de texto.
        comboBox.setFont(DEFAULT_FONT);
        comboBox.setForeground(FIELD_FG_COLOR);
        comboBox.setBackground(FIELD_BG_COLOR);
        comboBox.setPreferredSize(new Dimension(300, 50));
        
        return comboBox;
    }
    
}