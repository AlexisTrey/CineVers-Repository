/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class HomePanel extends JPanel {

    private JPanel mainContent;
    private JPanel topPanel;
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private ActionListener listener;
    private JButton btnUpcoming;

    public HomePanel(ActionListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());
        setBackground(new Color(44, 44, 84));

        mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(new Color(44, 44, 84));

        createTopPanel();
        createContentPanel();

        mainContent.add(topPanel);
        mainContent.add(contentPanel);

        scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void createTopPanel() {
        topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(new Color(122, 43, 191));
        topPanel.setPreferredSize(new Dimension(0, 250));

        JLabel lblTitle = new JLabel("Tu portal al universo del cine");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblTitle.setForeground(Color.WHITE);

        JLabel lblSubTitle = new JLabel("Disfruta de los últimos éxitos de taquilla en un ambiente apto para toda la familia.");
        lblSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        lblSubTitle.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new java.awt.Insets(10, 0, 10, 0);
        topPanel.add(lblTitle, gbc);

        gbc.gridy = 1;
        topPanel.add(lblSubTitle, gbc);
    }

    private void createContentPanel() {
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(30, 30, 30, 30);
        gbc.gridy = 0;
        gbc.gridx = 0;

        MovieCardPanel[] movies = {
            new MovieCardPanel("Orgullo y Prejuicio", "Drama • Romance", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.PREJUICIO_PATH)), listener),
            new MovieCardPanel("Together: Juntos Hasta la Muerte", "Horror • 1h 42min", "2D",
            new ImageIcon(getClass().getResource(Utilities.TOGETHER_PATH)), listener),
            new MovieCardPanel("Otro Viernes de Locos", "Comedia • Familiar • 2h 7min", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.VIERNES_PATH)), listener),
            new MovieCardPanel("Miraculous: Las Aventuras de Ladybug", "Animación • Aventura", "2D - VIP",
            new ImageIcon(getClass().getResource(Utilities.MIRACULOUS_PATH)), listener),
            new MovieCardPanel("Demon Slayer: Infinity Castle", "Acción • Fantasía • 2h 54min", "2D - 3D - VIP",
            new ImageIcon(getClass().getResource(Utilities.DEMON_PATH)), listener),
            new MovieCardPanel("Jurassic World Rebirth", "Aventura • Ciencia Ficción • 2h 7min", "3D - 2D",
            new ImageIcon(getClass().getResource(Utilities.JURASSIC_PATH)), listener)
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
        gbc.insets = new java.awt.Insets(60, 0, 20, 0);

        btnUpcoming = new JButton("PRÓXIMOS ESTRENOS");
        btnUpcoming.setFont(new Font("Segoe UI", Font.BOLD, 34));
        btnUpcoming.setForeground(Color.BLACK);
        btnUpcoming.setOpaque(false);
        btnUpcoming.setContentAreaFilled(false);
        btnUpcoming.setBorderPainted(false);
        btnUpcoming.setFocusPainted(false);
        btnUpcoming.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpcoming.setActionCommand("UPCOMING");
        btnUpcoming.addActionListener(listener);
        contentPanel.add(btnUpcoming, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(20, 30, 50, 30);
        gbc.gridy++;
        gbc.gridx = 0;

        MovieCardPanel[] upcoming = {
            new MovieCardPanel("Pompoko - La Guerra de los Mapaches", "Tierna • Animado • 1h 06min ", "2D",
            new ImageIcon(getClass().getResource(Utilities.POMPOKO_PATH)), listener),
            new MovieCardPanel("Zootopia 2", "Drama • Romance • 2h 54min", "2D - 3D - VIP",
            new ImageIcon(getClass().getResource(Utilities.ZOOTOPIA_PATH)), listener),
            new MovieCardPanel("Avatar: Fuego y Ceniza", "Comedia • Accion • 2h 7min", "2D - 3D - VIP",
            new ImageIcon(getClass().getResource(Utilities.AVATAR_PATH)), listener)
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
    }

    public void scrollToUpcoming() {
        if (scrollPane != null && btnUpcoming != null) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                Rectangle rect = btnUpcoming.getBounds();
                btnUpcoming.scrollRectToVisible(rect);
                scrollPane.getViewport().setViewPosition(
                        new java.awt.Point(0, rect.y - 50)
                );
            });
        }
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
}
