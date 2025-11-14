package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormAddRoomPanel extends JPanel {

    private ActionListener listener;

    // 🔹 Atributos visuales
    private JLabel titleLabel;
    private JTextField txtRoomName;
    private JTextField txtRoomNumber;
    private JComboBox<String> comboActive;
    private JTextField txtSeatsNumber;
    private JComboBox<String> comboCity;
    private JTextField txtRoomType;
    private JButton btnSaveRoom;

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

        g2.setColor(new Color(250, 250, 250));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);

        g2.setColor(new Color(0, 0, 0, 30));
        g2.setStroke(new BasicStroke(2f));
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 40, 40);

        g2.dispose();
        super.paintComponent(g);
    }

    private void buildFormContent() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // 🔹 TÍTULO
        titleLabel = new JLabel("Administrar Salas");
        titleLabel.setFont(SurveryStyle.TITLE_FONT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(titleLabel, gbc);

        // 🔹 Nombre sala (1 col x 2)
        txtRoomName = SurveryStyle.createStyledTextField("Nombre de Sala");
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(txtRoomName, gbc);

        // 🔹 Estado sala
        comboActive = SurveryStyle.createStyledComboBox(
                new String[]{"Estado de la sala:", "Activa", "Inactiva"});
        gbc.gridy = 2;
        add(comboActive, gbc);

        // 🔹 Número asientos + ciudad → 2 columnas
        gbc.gridy = 3;
        gbc.gridwidth = 1;

        txtSeatsNumber = SurveryStyle.createStyledTextField("Número de Asientos");
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 5);
        add(txtSeatsNumber, gbc);

        comboCity = SurveryStyle.createStyledComboBox(
                new String[]{"Seleccionar ciudad :", "Tunja", "Medellín"});
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 5, 10, 0);
        add(comboCity, gbc);

        // 🔹 Tipo sala (2 columnas)
        txtRoomType = SurveryStyle.createStyledTextField("Tipo de Sala");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(txtRoomType, gbc);

        // 🔹 Botón guardar
        btnSaveRoom = SurveryStyle.createStyledButton("Guardar Sala");
        btnSaveRoom.setActionCommand("AGREGAR_SALA_FORM");
        btnSaveRoom.addActionListener(listener);

        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(25, 0, 5, 0);
        add(btnSaveRoom, gbc);
    }

    // 👇 Getters y Setters
    public JTextField getTxtRoomName() { return txtRoomName; }
    public JComboBox<String> getComboActive() { return comboActive; }
    public JTextField getTxtSeatsNumber() { return txtSeatsNumber; }
    public JComboBox<String> getComboCity() { return comboCity; }
    public JTextField getTxtRoomType() { return txtRoomType; }
    public JButton getBtnSaveRoom() { return btnSaveRoom; }

}

