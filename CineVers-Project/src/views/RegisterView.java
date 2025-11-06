/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class RegisterView extends JPanel {

    private Background background;

    public RegisterView(ActionListener listener) {
        setLayout(new BorderLayout());

        background = new Background();
        background.setLayout(new GridBagLayout());
        add(background, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.insets = new Insets(0, 60, 0, 60);
        gbcMain.gridy = 0;

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        formPanel.setPreferredSize(new Dimension(700, 700));
        JLabel lblTitulo = new JLabel("Crea tu cuenta en CineVers", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(new EmptyBorder(40, 0, 60, 0));

        JTextField txtNombres = crearCampo("Nombres");
        JTextField txtApellidos = crearCampo("Apellidos");
        JTextField txtCorreo = crearCampo("Correo electrónico");
        JTextField txtDireccion = crearCampo("Dirección", false);
        JTextField txtCiudad = crearCampo("Ciudad", false);
        JTextField txtDocumento = crearCampo("Tipo de Documento");

        JCheckBox chkTerminos = new JCheckBox("Confirmo que he leído los términos y condiciones y el habeas data");
        chkTerminos.setForeground(Color.WHITE);
        chkTerminos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chkTerminos.setOpaque(false);

        JButton btnRegistrar = new JButton("Registrarse") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(124, 77, 255),
                        getWidth(), getHeight(), new Color(186, 104, 200)
                );
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setPreferredSize(new Dimension(300, 60));
        btnRegistrar.setEnabled(false);

        chkTerminos.addActionListener(e -> btnRegistrar.setEnabled(chkTerminos.isSelected()));
        btnRegistrar.addActionListener(e -> {
            listener.actionPerformed(
                    new java.awt.event.ActionEvent(this, 0, "LOGIN")
            );
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);
        titlePanel.add(lblTitulo);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        formPanel.add(titlePanel, gbc);
        gbc.gridwidth = 1;

        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy++;
        formPanel.add(txtNombres, gbc);

        gbc.gridy++;
        formPanel.add(txtApellidos, gbc);

        gbc.gridy++;
        formPanel.add(txtCorreo, gbc);

        gbc.gridy++;
        JPanel direccionCiudadPanel = new JPanel(new GridBagLayout());
        direccionCiudadPanel.setOpaque(false);

        GridBagConstraints gbcDC = new GridBagConstraints();
        gbcDC.fill = GridBagConstraints.HORIZONTAL;
        gbcDC.weightx = 0.5;
        gbcDC.insets = new Insets(0, 0, 0, 10);
        direccionCiudadPanel.add(txtDireccion, gbcDC);

        gbcDC.gridx = 1;
        gbcDC.insets = new Insets(0, 10, 0, 0);
        direccionCiudadPanel.add(txtCiudad, gbcDC);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(direccionCiudadPanel, gbc);

        gbc.gridy++;
        formPanel.add(txtDocumento, gbc);

        gbc.gridy++;
        formPanel.add(chkTerminos, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(btnRegistrar, gbc);

        JPanel infoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = 40;
                int w = getWidth();
                int h = getHeight();

                g2.setColor(new Color(80, 0, 130, 230));
                g2.fillRoundRect(0, 0, w, h, arc, arc);

                g2.dispose();
            }
        };
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        infoPanel.setPreferredSize(new Dimension(320, 360));
        infoPanel.setLayout(new BorderLayout());

        JLabel infoText = new JLabel("<html><div style='width:200px; text-align:justify;'>"
                + "Llena este formulario con todos tus datos correctos y verificables.<br><br>"
                + "Escribe todo en minúsculas. Los campos con (‘*’) son obligatorios para poder acceder "
                + "a los beneficios que el programa de cliente CineVers te ofrece durante el desarrollo "
                + "de campañas y actividades que se programen para este fin."
                + "</div></html>");
        infoText.setForeground(Color.WHITE);
        infoText.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        infoText.setHorizontalAlignment(SwingConstants.CENTER);
        infoText.setVerticalAlignment(SwingConstants.CENTER);

        JPanel infoTextPanel = new JPanel(new GridBagLayout());
        infoTextPanel.setOpaque(false);
        infoTextPanel.add(infoText);

        infoPanel.add(infoTextPanel, BorderLayout.CENTER);

        gbcMain.gridx = 0;
        mainPanel.add(formPanel, gbcMain);

        gbcMain.gridx = 1;
        mainPanel.add(infoPanel, gbcMain);

        JScrollPane scrollForm = new JScrollPane(mainPanel);
        scrollForm.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollForm.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollForm.getVerticalScrollBar().setUnitIncrement(16);
        scrollForm.setBorder(null);
        scrollForm.getViewport().setOpaque(false);
        scrollForm.setOpaque(false);
        background.setLayout(new BorderLayout());
        background.add(scrollForm, BorderLayout.NORTH);

        add(background, BorderLayout.CENTER);
    }

    private JTextField crearCampo(String placeholder) {
        return crearCampo(placeholder, true);
    }

    private JTextField crearCampo(String placeholder, boolean ancho) {
        JTextField txt = new JTextField(18) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(110, 70, 180));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

                g2.setColor(new Color(180, 130, 255));
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 25, 25);

                g2.dispose();
                super.paintComponent(g);

                if (getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setFont(getFont().deriveFont(Font.ITALIC));
                    g2d.setColor(new Color(200, 200, 200));
                    g2d.drawString(placeholder, 15, getHeight() / 2 + 5);
                    g2d.dispose();
                }
            }
        };

        txt.setOpaque(false);
        txt.setForeground(Color.WHITE);
        txt.setCaretColor(Color.WHITE);
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        txt.setBorder(new EmptyBorder(10, 15, 10, 15));

        int width = ancho ? 350 : 130;
        txt.setPreferredSize(new Dimension(width, 50));

        return txt;
    }
}
