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
 * @author jhonnyd
 */
public class FormBillboardPanel extends JPanel {
    
    
    private final int FIELD_WIDTH = 400; 
    private final int FIELD_HEIGHT = 50;
    private ActionListener listener;
    
    public FormBillboardPanel(ActionListener listener) {
        this.listener = listener;
        setBackground(Color.WHITE);
        setOpaque(false);
        setBorder(new EmptyBorder(30, 40, 30, 40)); 
        setLayout(new GridBagLayout());
        buildFormContent();
    }
    

    private void buildFormContent() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
    // --- Título del Formulario ---
    JLabel titleLabel = new JLabel("Agregar Función");
    titleLabel.setFont(SurveryStyle.TITLE_FONT);
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.insets = new Insets(0, 0, 30, 0); // Más espacio después del título
    add(titleLabel, gbc);

    

    JTextField campoTitulo = SurveryStyle.createStyledTextField("Título");
    campoTitulo.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
    gbc.gridy++;
    gbc.gridx = 0;
    gbc.gridwidth = 1;
    gbc.weightx = 0.7;
    gbc.insets = new Insets(10, 0, 10, 15); // Espacio derecho entre título e imagen
    add(campoTitulo, gbc);

    JPanel panelImagen = createImagenPlaceholder("Agregar imagen:");
    panelImagen.setPreferredSize(new Dimension(FIELD_WIDTH / 2, FIELD_HEIGHT * 2));
    gbc.gridx = 1;
    gbc.weightx = 0.3;
    gbc.insets = new Insets(10, 15, 10, 0); // Espacio izquierdo
    add(panelImagen, gbc);

    gbc.gridx = 0;
    gbc.gridwidth = 2;
    gbc.insets = new Insets(10, 0, 10, 0); // Más espacio arriba para separar sección
    add(createSeparator(), gbc);


    JTextArea campoSinopsis = SurveryStyle.createStyledTextArea("Sinopsis:");
    campoSinopsis.setRows(4);
    JScrollPane scrollSinopsis = new JScrollPane(campoSinopsis);
    scrollSinopsis.setPreferredSize(new Dimension(FIELD_WIDTH * 2, 100));
    scrollSinopsis.setBorder(BorderFactory.createEmptyBorder());
    
    gbc.gridy++;
    gbc.insets = new Insets(10, 0, 10, 0); // Espacio después de sinopsis
    add(scrollSinopsis, gbc);

    JComboBox<String> comboGenero = SurveryStyle.createStyledComboBox(new String[]{"Comedia", "Drama", "Acción"});
    comboGenero.setPreferredSize(new Dimension(FIELD_WIDTH * 2, FIELD_HEIGHT));
    
    gbc.gridy++;
    gbc.insets = new Insets(10, 0, 10, 0);
    add(comboGenero, gbc);

    JTextField campoClasificacion = SurveryStyle.createStyledTextField("Clasificación:");
    campoClasificacion.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
    gbc.gridy++;
    gbc.gridx = 0;
    gbc.gridwidth = 1;
    gbc.weightx = 0.5;
    gbc.insets = new Insets(10, 0, 10, 10); // Espacio derecho
    add(campoClasificacion, gbc);

    JTextField campoDuracion = SurveryStyle.createStyledTextField("Duración (min):");
    campoDuracion.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
    gbc.gridx = 1;
    gbc.insets = new Insets(10, 10, 10, 0); // Espacio izquierdo
    add(campoDuracion, gbc);

    // --- SECCIÓN 4: Fechas ---
    
    // Separador antes de fechas
    gbc.gridy++;
    gbc.gridx = 0;
    gbc.gridwidth = 2;
    gbc.insets = new Insets(10, 0, 10, 0);
    add(createSeparator(), gbc);
    
    JButton botonContinuar = SurveryStyle.createStyledButton("Continuar");
    botonContinuar.setActionCommand("AGREGAR_CARTELERA");
    botonContinuar.addActionListener(listener);
    gbc.gridy++;
    gbc.gridx = 0;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.NONE;
    gbc.insets = new Insets(10, 0, 0, 0); // Espacio arriba del botón
    add(botonContinuar, gbc);
}

/**
 * Crea un separador visual entre secciones
 */
private Component createSeparator() {
    JSeparator separator = new JSeparator();
    separator.setForeground(new Color(200, 200, 200));
    separator.setPreferredSize(new Dimension(FIELD_WIDTH * 2, 1));
    return separator;
}

/**
 * Mejorado: Placeholder para imagen más estilizado
 */
private JPanel createImagenPlaceholder(String text) {
    JPanel panel = new RoundedPanel(15, new Color(245, 245, 245)); // Color más suave
    panel.setLayout(new BorderLayout());
    panel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
    
    JLabel label = new JLabel(text, SwingConstants.CENTER);
    label.setFont(SurveryStyle.DEFAULT_FONT.deriveFont(Font.PLAIN, 12));
    label.setForeground(new Color(150, 150, 150)); // Color más suave
    
    // Agregar icono de cámara (opcional)
    JLabel iconLabel = new JLabel("📷");
    iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
    iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    JPanel contentPanel = new JPanel(new BorderLayout());
    contentPanel.setOpaque(false);
    contentPanel.add(iconLabel, BorderLayout.CENTER);
    contentPanel.add(label, BorderLayout.SOUTH);
    
    panel.add(contentPanel, BorderLayout.CENTER);
    panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    return panel;
}
}
