/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

/**
 *
 * @author meloc
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Pantalla inicial para seleccionar país y ciudad antes de ingresar a CineVers.
 */
public class SelectCityView extends JPanel {

    private Header header;
    private Background background;
    private JButton btnSelectCity;

    public SelectCityView() {
        setLayout(new BorderLayout());

        // Encabezado
        header = new Header();
        add(header, BorderLayout.NORTH);

        // Fondo degradado (tu clase Background)
        background = new Background();
        background.setLayout(new GridBagLayout());

        // Botón principal con degradado
        btnSelectCity = new JButton("Seleccionar Ciudad") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(124, 77, 255),
                        getWidth(), getHeight(), new Color(186, 104, 200)
                );
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g);
                g2.dispose();
            }
        };
        btnSelectCity.setForeground(Color.WHITE);
        btnSelectCity.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnSelectCity.setFocusPainted(false);
        btnSelectCity.setContentAreaFilled(false);
        btnSelectCity.setBorderPainted(false);
        btnSelectCity.setPreferredSize(new Dimension(250, 50));

        // Acción al hacer clic
        btnSelectCity.addActionListener(e -> showDialog());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        background.add(btnSelectCity, gbc);

        add(background, BorderLayout.CENTER);
    }
private void showDialog() {
    JDialog dialog = new JDialog((Frame) null, "Selecciona tu ubicación", true);
    dialog.setUndecorated(true);
    dialog.setSize(450, 300);
    dialog.setLocationRelativeTo(this);

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(Color.WHITE);
    panel.setBorder(new EmptyBorder(20, 40, 20, 40));
    dialog.setContentPane(panel);

    JLabel lblTitle = new JLabel("Selecciona tu ubicación");
    lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
    lblTitle.setForeground(new Color(30, 30, 30));

    JLabel lblPais = new JLabel("País");
    lblPais.setFont(new Font("Segoe UI", Font.PLAIN, 16));

    // Combo de país
    JComboBox<String> cbPais = new JComboBox<>(new String[]{"Seleccionar país", "Colombia"});
    cbPais.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    cbPais.setPreferredSize(new Dimension(300, 35));
    estilizarCombo(cbPais);

    JLabel lblCiudad = new JLabel("Ciudad");
    lblCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 16));

    String[] ciudades = {
        "Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena",
        "Bucaramanga", "Manizales", "Pereira", "Armenia", "Cúcuta"
    };
    JComboBox<String> cbCiudad = new JComboBox<>(ciudades);
    cbCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    cbCiudad.setPreferredSize(new Dimension(300, 35));
    estilizarCombo(cbCiudad);
    cbCiudad.setVisible(false); // 🔸 inicialmente oculto

    // Botón degradado morado
    JButton btnAceptar = new JButton("Seleccionar ubicación") {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(
                    0, 0, new Color(124, 77, 255),
                    getWidth(), getHeight(), new Color(186, 104, 200)
            );
            g2.setPaint(gp);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
            g2.dispose();
            super.paintComponent(g);
        }
    };
    btnAceptar.setForeground(Color.WHITE);
    btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 17));
    btnAceptar.setFocusPainted(false);
    btnAceptar.setContentAreaFilled(false);
    btnAceptar.setBorderPainted(false);
    btnAceptar.setPreferredSize(new Dimension(250, 45));

    // 🔸 Mostrar ciudades solo si se elige Colombia
    cbPais.addActionListener(e -> {
        cbCiudad.setVisible("Colombia".equals(cbPais.getSelectedItem()));
        dialog.revalidate();
        dialog.repaint();
    });

    btnAceptar.addActionListener(e -> {
        if (!cbCiudad.isVisible()) {
            JOptionPane.showMessageDialog(dialog, "Selecciona un país primero.");
            return;
        }
        String ciudad = (String) cbCiudad.getSelectedItem();
        JOptionPane.showMessageDialog(dialog, "Has seleccionado: " + ciudad);
        dialog.dispose();
        // Aquí podrías abrir la vista principal, por ejemplo:
        // new MainFrame();
    });

    // Layout ordenado
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(lblTitle, gbc);
    gbc.gridy++;
    panel.add(lblPais, gbc);
    gbc.gridy++;
    panel.add(cbPais, gbc);
    gbc.gridy++;
    panel.add(lblCiudad, gbc);
    gbc.gridy++;
    panel.add(cbCiudad, gbc);
    gbc.gridy++;
    panel.add(btnAceptar, gbc);

    dialog.setVisible(true);
}

/**
 * 🔸 Método para dar estilo moderno a los JComboBox
 */
private void estilizarCombo(JComboBox<String> combo) {
    combo.setBackground(new Color(245, 245, 245));
    combo.setForeground(new Color(50, 50, 50));
    combo.setBorder(BorderFactory.createLineBorder(new Color(124, 77, 255), 2, true));
    combo.setFocusable(false);

    combo.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
        @Override
        protected JButton createArrowButton() {
            JButton arrow = new JButton("▼");
            arrow.setBorder(null);
            arrow.setContentAreaFilled(false);
            arrow.setFocusPainted(false);
            arrow.setForeground(new Color(124, 77, 255));
            return arrow;
        }
    });
}

    // Prueba independiente
    public static void main(String[] args) {
        JFrame frame = new JFrame("CineVers - Seleccionar Ciudad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new SelectCityView());
        frame.setVisible(true);
    }
}

