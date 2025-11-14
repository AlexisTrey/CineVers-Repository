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
public class FormBillboardPanel extends JPanel {

    private final int FIELD_WIDTH = 400;
    private final int FIELD_HEIGHT = 50;
    private ActionListener listener;

    private JLabel titleLabel;
    private JComboBox<String> cmbPeliculas;
    String[] titles = new String[0];
    private JButton botonContinuar;
    private JTextField txtFunctionId; // Nuevo: ID de la Función
    private JComboBox<String> cmbRooms; // Sala (Nuevo JComboBox)
    private JTextField txtStartTime; // Hora de inicio (LocalDateTime)
    private String[] newRoomNames;

    public FormBillboardPanel(ActionListener listener) {
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

    public void setJComboBox(String[] titles) {
        this.titles = titles;
        this.updateMovieTitles(titles);
    }

        public void setJComboBoxRooms(String[] newRoomNames) {
        this.newRoomNames = newRoomNames;
        this.updateRoomNames(newRoomNames);
    }

    public void updateMovieTitles(String[] newTitles) {

        if (cmbPeliculas != null) {
            // Reemplazar el modelo del ComboBox con los nuevos títulos.
            cmbPeliculas.setModel(new DefaultComboBoxModel<>(newTitles));

            // Forzar el redibujado (revalidate/repaint) para que los cambios se muestren
            cmbPeliculas.revalidate();
            cmbPeliculas.repaint();

            // Si quieres que el panel completo se actualice, podrías incluir:
            this.revalidate();
            this.repaint();
        }
    }

    public void updateRoomNames(String[] newRoomNames) {
        if (cmbRooms != null) {
            cmbRooms.setModel(new DefaultComboBoxModel<>(newRoomNames));
            cmbRooms.revalidate();
            cmbRooms.repaint();
        }
    }
    

    private void buildFormContent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        titleLabel = new JLabel("Agregar Funcion");
        titleLabel.setFont(SurveryStyle.TITLE_FONT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0); // Más espacio después del título
        add(titleLabel, gbc);

        txtFunctionId = SurveryStyle.createStyledTextField("ID de Función:");
        txtFunctionId.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Ocupa todo el ancho
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(txtFunctionId, gbc);

        //peliculas re escalables
        cmbPeliculas = SurveryStyle.createStyledComboBox(titles);
        cmbPeliculas.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.7;
        gbc.insets = new Insets(10, 0, 10, 15); // Espacio derecho entre título e imagen
        add(cmbPeliculas, gbc);

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

       cmbRooms = SurveryStyle.createStyledComboBox(newRoomNames );
       cmbRooms.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
       gbc.gridy++;
       gbc.gridx = 0;
       gbc.gridwidth = 2; 
       gbc.insets = new Insets(10, 0, 10, 0);
       add(cmbRooms, gbc);


        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(createSeparator(), gbc);

        txtStartTime = SurveryStyle.createStyledTextField("FechaFin::");
        txtStartTime.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(10, 0, 10, 10);
        add(txtStartTime, gbc);

        botonContinuar = SurveryStyle.createStyledButton("Continuar");
        botonContinuar.setActionCommand("AGREGAR_FUNCION_ FORM");
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

    public ActionListener getListener() {
        return listener;
    }

    public void setListener(ActionListener listener) {
        this.listener = listener;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JComboBox<String> getCmbPeliculas() {
        return cmbPeliculas;
    }

    public void setCmbPeliculas(JComboBox<String> cmbPeliculas) {
        this.cmbPeliculas = cmbPeliculas;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public JButton getBotonContinuar() {
        return botonContinuar;
    }

    public void setBotonContinuar(JButton botonContinuar) {
        this.botonContinuar = botonContinuar;
    }

    public JTextField getTxtFunctionId() {
        return txtFunctionId;
    }

    public void setTxtFunctionId(JTextField txtFunctionId) {
        this.txtFunctionId = txtFunctionId;
    }

    public JComboBox<String> getCmbRooms() {
        return cmbRooms;
    }

    public void setCmbRooms(JComboBox<String> cmbRooms) {
        this.cmbRooms = cmbRooms;
    }

    public JTextField getTxtStartTime() {
        return txtStartTime;
    }

    public void setTxtStartTime(JTextField txtStartTime) {
        this.txtStartTime = txtStartTime;
    }

//        public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Demo Cineverso");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(1024, 768);
//            frame.setLocationRelativeTo(null);
//
//            // Aquí agregás tu panel principal completo
//            frame.add(new FormBillboardPanel());
//
//            frame.setVisible(true);
//        });
//    }
}
