/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import views.Background;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class SelectCityView extends JPanel {

    private Background background;
    private JButton btnSelectCity;
    private ActionListener listener;

    public SelectCityView(ActionListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());

        background = new Background();
        background.setLayout(new BorderLayout());

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

        btnSelectCity.addActionListener(e -> showDialog());

        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40)); // margen arriba
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(btnSelectCity);

        background.add(wrapperPanel, BorderLayout.NORTH);
        add(background, BorderLayout.CENTER);
    }

    private void showDialog() {
        JDialog dialog = new JDialog((Frame) null, "Selecciona tu ubicación", true);
        dialog.setUndecorated(true);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.setSize(450, 300);
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));

        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                g2.setColor(new Color(0, 0, 0, 30));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 40, 40);

                g2.dispose();
            }
        };
        panel.setOpaque(false);

        panel.setBorder(new EmptyBorder(30, 50, 30, 50));

        dialog.setContentPane(panel);

        JLabel lblTitle = new JLabel("Selecciona tu ubicación");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(30, 30, 30));

        JLabel lblPais = new JLabel("País");
        lblPais.setFont(new Font("Segoe UI", Font.PLAIN, 16));

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
        lblCiudad.setVisible(false);
        cbCiudad.setVisible(false);
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

        cbPais.addActionListener(e -> {
            boolean mostrarCiudad = "Colombia".equals(cbPais.getSelectedItem());
            lblCiudad.setVisible(mostrarCiudad);
            cbCiudad.setVisible(mostrarCiudad);
            dialog.revalidate();
            dialog.repaint();
        });

        btnAceptar.addActionListener(e -> {
            if (!cbCiudad.isVisible()) {
                JOptionPane.showMessageDialog(dialog, "Selecciona un país primero.");
                return;
            }
            dialog.dispose();
            if (listener != null) {
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "HOME"));
            }

        });

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

    private void estilizarCombo(JComboBox<String> combo) {
        combo.setBackground(Color.WHITE);
        combo.setForeground(new Color(60, 60, 60));
        combo.setPreferredSize(new Dimension(320, 40));
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        combo.setFocusable(false);

        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                lbl.setOpaque(true);
                if (isSelected) {
                    lbl.setBackground(new Color(150, 90, 255));
                    lbl.setForeground(Color.WHITE);
                } else {
                    lbl.setBackground(Color.WHITE);
                    lbl.setForeground(new Color(60, 60, 60));
                }
                lbl.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                return lbl;
            }
        });

        combo.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton arrow = new JButton("▾");
                arrow.setBorder(null);
                arrow.setContentAreaFilled(false);
                arrow.setFocusPainted(false);
                arrow.setForeground(new Color(120, 70, 220));
                return arrow;
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (hasFocus || combo.isPopupVisible()) {
                    g2.setColor(new Color(150, 90, 255));
                } else {
                    g2.setColor(Color.WHITE);
                }

                g2.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 30, 30);
                g2.dispose();
            }

            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(150, 90, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(1, 1, c.getWidth() - 3, c.getHeight() - 3, 30, 30);

                g2.dispose();
            }
        });
    }

    public JButton getBtnSelectCity() {
        return btnSelectCity;
    }

}
