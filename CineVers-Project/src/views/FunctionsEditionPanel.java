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
import javax.swing.JPanel;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class FunctionsEditionPanel extends JPanel {

    private JPanel menuPanel;
    private JButton btnFunctions;
    private JButton btnBillboard;
    private JButton btnRooms;
    private JPanel contentPanel;
    private ActionListener listener;

    public FunctionsEditionPanel(ActionListener listener) {
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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(20, 0, 30, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        AddCardButton btnAddFunction = new AddCardButton("Agregar Función");
        btnAddFunction.setActionCommand("AGREGAR_FUNCION");
        btnAddFunction.addActionListener(listener);
        contentPanel.add(btnAddFunction, gbc);

        gbc.gridy++;
        gbc.insets = new java.awt.Insets(10, 30, 10, 30);

        FunctionCardPanel[] functions = {
            new FunctionCardPanel("Orgullo y Prejuicio", "05", "33", "12:00", "VIP 3D",
            new ImageIcon(getClass().getResource(Utilities.ORGULLO_PATH))),
            new FunctionCardPanel("Zootopia 2", "02", "50", "15:30", "2D",
            new ImageIcon(getClass().getResource(Utilities.ZOOTOPIA_PATH))),
            new FunctionCardPanel("Demon Slayer: Infinity Castle", "03", "20", "18:00", "3D",
            new ImageIcon(getClass().getResource(Utilities.DEMON_PATH))),
            new FunctionCardPanel("Miraculous: Las Aventuras de Ladybug", "04", "45", "10:00", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.MIRACULOUS_PATH))),
            new FunctionCardPanel("Jurassic World Rebirth", "01", "60", "21:00", "3D",
            new ImageIcon(getClass().getResource(Utilities.JURASSIC_PATH)))
        };

        for (FunctionCardPanel function : functions) {
            contentPanel.add(function, gbc);
            gbc.gridy++;
        }
        
        wrapperPanel.add(contentPanel, BorderLayout.NORTH);
        this.contentPanel = wrapperPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
