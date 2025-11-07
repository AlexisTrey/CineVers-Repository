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
public class FormFuctionPanel extends JPanel {

    private final int FIELD_WIDTH = 400; // Ancho base para los campos de texto
    private final int FIELD_HEIGHT = 50;
    private ActionListener listener;
    
    private JTextField campoTitulo;
    private JTextArea campoSinopsis;
    private JComboBox<String> comboGenero;
    private JTextField campoClasificacion;
    private JTextField campoDuracion;
    private JTextField campoEstreno;
    private JTextField campoFin;
    private JButton botonContinuar;

    public FormFuctionPanel(ActionListener listener) {
        this.listener = listener;
        setBackground(Color.WHITE);
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
        

        JLabel titleLabel = new JLabel("Agregar Pelicula a cartelera");
        titleLabel.setFont(SurveryStyle.TITLE_FONT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0); // Más espacio después del título
        add(titleLabel, gbc);

        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        campoTitulo = SurveryStyle.createStyledTextField("Título");
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

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0); // Más espacio arriba para separar sección
        add(createSeparator(), gbc);
        
        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        campoSinopsis = SurveryStyle.createStyledTextArea("Sinopsis:");
        campoSinopsis.setRows(4);
        JScrollPane scrollSinopsis = new JScrollPane(campoSinopsis);
        scrollSinopsis.setPreferredSize(new Dimension(FIELD_WIDTH * 2, 100));
        scrollSinopsis.setBorder(BorderFactory.createEmptyBorder());
        
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0); // Espacio después de sinopsis
        add(scrollSinopsis, gbc);

        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        comboGenero = SurveryStyle.createStyledComboBox(new String[]{"Comedia", "Drama", "Acción"});
        comboGenero.setPreferredSize(new Dimension(FIELD_WIDTH * 2, FIELD_HEIGHT));
        
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(comboGenero, gbc);

        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        campoClasificacion = SurveryStyle.createStyledTextField("Clasificación:");
        campoClasificacion.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(10, 0, 10, 10); // Espacio derecho
        add(campoClasificacion, gbc);

        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        campoDuracion = SurveryStyle.createStyledTextField("Duración (min):");
        campoDuracion.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 10, 10, 0); // Espacio izquierdo
        add(campoDuracion, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(createSeparator(), gbc);
        
        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        campoEstreno = SurveryStyle.createStyledTextField("Fecha de Estreno:");
        campoEstreno.setPreferredSize(new Dimension(FIELD_WIDTH * 2, FIELD_HEIGHT));
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(campoEstreno, gbc);

        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        campoFin = SurveryStyle.createStyledTextField("Fecha de Fin:");
        campoFin.setPreferredSize(new Dimension(FIELD_WIDTH * 2, FIELD_HEIGHT));
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0); // Más espacio antes del botón
        add(campoFin, gbc);

        // ASIGNACIÓN AL ATRIBUTO DE CLASE
        botonContinuar = SurveryStyle.createStyledButton("Continuar");
        botonContinuar.setActionCommand("AGREGAR_FUNCION_FORM");
        botonContinuar.addActionListener(listener);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 0, 0, 0); // Espacio arriba del botón
        add(botonContinuar, gbc);
    }


    private Component createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(200, 200, 200));
        separator.setPreferredSize(new Dimension(FIELD_WIDTH * 2, 1));
        return separator;
    }


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
    

    public JTextField getCampoTitulo() {
        return campoTitulo;
    }

    public JTextArea getCampoSinopsis() {
        return campoSinopsis;
    }

    public JComboBox<String> getComboGenero() {
        return comboGenero;
    }

    public JTextField getCampoClasificacion() {
        return campoClasificacion;
    }

    public JTextField getCampoDuracion() {
        return campoDuracion;
    }

    public JTextField getCampoEstreno() {
        return campoEstreno;
    }

    public JTextField getCampoFin() {
        return campoFin;
    }

    public JButton getBotonContinuar() {
        return botonContinuar;
    }

    // SETTERS (Para establecer valores, útil si estás cargando datos para edición)
    public void setCampoTitulo(String titulo) {
        this.campoTitulo.setText(titulo);
    }

    public void setCampoSinopsis(String sinopsis) {
        this.campoSinopsis.setText(sinopsis);
    }

    public void setComboGenero(String genero) {
        this.comboGenero.setSelectedItem(genero);
    }

    public void setCampoClasificacion(String clasificacion) {
        this.campoClasificacion.setText(clasificacion);
    }

    public void setCampoDuracion(String duracion) {
        this.campoDuracion.setText(duracion);
    }

    public void setCampoEstreno(String estreno) {
        this.campoEstreno.setText(estreno);
    }

    public void setCampoFin(String fin) {
        this.campoFin.setText(fin);
    }

    // Opcional: Setter para habilitar/deshabilitar el botón
    public void setBotonContinuarEnabled(boolean enabled) {
        this.botonContinuar.setEnabled(enabled);
    }
    
//            public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Demo Cineverso");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(1024, 768);
//            frame.setLocationRelativeTo(null);
//
//            // Aquí agregás tu panel principal completo
//            frame.add(new FormFuctionPanel());
//
//            frame.setVisible(true);
//        });
//    }
}