/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class BillboardEditionPanel extends JPanel {

    private JPanel menuPanel;
    private JButton btnFunctions;
    private JButton btnBillboard;
    private JButton btnRooms;
    private JPanel contentPanel;
    private ActionListener listener;

    public BillboardEditionPanel(ActionListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        createMenuPanel(listener);
        createContentPanel();

        add(menuPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void createMenuPanel(ActionListener listener) {
        menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 16));
        menuPanel.setBackground(new Color(122, 43, 191));
        menuPanel.setPreferredSize(new Dimension(0, 80));
        menuPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(98, 43, 160)));

        btnFunctions = createStyledButton("Edición de Funciones", "EDITAR_FUNCIONES", listener);
        btnBillboard = createStyledButton("Edición de Cartelera", "EDITAR_CARTELERA", listener);
        btnRooms = createStyledButton("Edición de Salas", "EDITAR_SALAS", listener);

        menuPanel.add(btnFunctions);
        menuPanel.add(btnBillboard);
        menuPanel.add(btnRooms);
    }

    private JButton createStyledButton(String text, String actionCommand, ActionListener listener) {
        JButton button = new JButton(text);
        button.setUI(new ShapedButtons());
        button.setPreferredSize(new Dimension(230, 45));
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        return button;
    }

    private void createContentPanel() {
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBackground(new Color(240, 240, 240));

        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));
        contentPanel.setBorder(new EmptyBorder(0, 0, 30, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(30, 30, 30, 30);
        gbc.gridy = 0;
        gbc.gridx = 0;

        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(50, 0, 50, 0);
        AddCardButton btnAddBillboard = new AddCardButton("Agregar Cartelera");
        btnAddBillboard.setActionCommand("AGREGAR_CARTELERA");
        btnAddBillboard.addActionListener(listener);
        contentPanel.add(btnAddBillboard, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.insets = new java.awt.Insets(10, 30, 30, 30);

        BillboardCardPanel[] movies = {
            new BillboardCardPanel("Orgullo y Prejuicio", "Drama • Romance", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.PREJUICIO_PATH))),
            new BillboardCardPanel("Together: Juntos Hasta la Muerte", "Horror • 1h 42min", "2D",
            new ImageIcon(getClass().getResource(Utilities.TOGETHER_PATH))),
            new BillboardCardPanel("Otro Viernes de Locos", "Comedia • Familiar • 2h 7min", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.VIERNES_PATH))),
            new BillboardCardPanel("Miraculous: Las Aventuras de Ladybug", "Animación • Aventura", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.MIRACULOUS_PATH))),
            new BillboardCardPanel("Demon Slayer: Infinity Castle", "Acción • Fantasía • 2h 54min", "2D - 3D - VIP",
            new ImageIcon(getClass().getResource(Utilities.DEMON_PATH))),
            new BillboardCardPanel("Jurassic World Rebirth", "Aventura • Ciencia Ficción • 2h 7min", "3D - 2D",
            new ImageIcon(getClass().getResource(Utilities.JURASSIC_PATH)))
        };

        for (int i = 0; i < movies.length; i++) {
            contentPanel.add(movies[i], gbc);

            if ((i + 1) % 3 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            } else {
                gbc.gridx++;
            }
        }

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        gbc.insets = new java.awt.Insets(80, 0, 20, 0);
        JLabel lblUpcoming = new JLabel("PRÓXIMOS ESTRENOS", JLabel.CENTER);
        lblUpcoming.setFont(new Font("Segoe UI", Font.BOLD, 34));
        lblUpcoming.setForeground(new Color(30, 30, 30));
        contentPanel.add(lblUpcoming, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(20, 30, 50, 30);
        gbc.gridy++;
        gbc.gridx = 0;

        BillboardCardPanel[] upcoming = {
            new BillboardCardPanel("Pompoko - La Guerra de los Mapaches", "Tierna • Animado • 1h 06min ", "2D",
            new ImageIcon(getClass().getResource(Utilities.POMPOKO_PATH))),
            new BillboardCardPanel("Zootopia 2", "Drama • Romance • 2h 54min", "2D - 3D - VIP",
            new ImageIcon(getClass().getResource(Utilities.ZOOTOPIA_PATH))),
            new BillboardCardPanel("Avatar: Fuego y Ceniza", "Comedia • Acción • 2h 7min", "2D - 3D - VIP",
            new ImageIcon(getClass().getResource(Utilities.AVATAR_PATH)))
        };

        for (int i = 0; i < upcoming.length; i++) {
            contentPanel.add(upcoming[i], gbc);

            if ((i + 1) % 3 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            } else {
                gbc.gridx++;
            }
        }

        wrapperPanel.add(contentPanel, BorderLayout.NORTH);
        this.contentPanel = wrapperPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
