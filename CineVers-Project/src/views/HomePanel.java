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
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import models.CineVersSystem;
import models.Movie;
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
    private CineVersSystem cine;

    public HomePanel(ActionListener listener) {
        this.listener = listener;
        this.cine = new CineVersSystem();

        setLayout(new BorderLayout());
        setBackground(new Color(44, 44, 84));

        mainContent = new JPanel();
        mainContent.setLayout(new BorderLayout());
        mainContent.setBackground(new Color(44, 44, 84));

        createTopPanel();
        createContentPanel();

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

        mainContent.add(topPanel, BorderLayout.NORTH);
    }

    private void createContentPanel() {
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);
        gbc.gridy = 0;
        gbc.gridx = 0;

        List<Movie> movies = cine.getMovies();
        int col = 0;

        for (Movie m : movies) {
            String imagePath = Utilities.getImageForMovieTitle(m.getTitle());
            MovieCardPanel card = new MovieCardPanel(
                    m.getTitle(),
                    m.getGenre() + " • " + m.getClassification(),
                    "Duración: " + m.getDurationMinutes() + " min",
                    new ImageIcon(getClass().getResource(imagePath)),
                    listener
            );

            card.getBtnDetails().setActionCommand("VER_DETALLES_" + m.getId());
            card.getBtnDetails().addActionListener(listener);

            contentPanel.add(card, gbc);
            col++;
            if (col == 3) {
                col = 0;
                gbc.gridx = 0;
                gbc.gridy++;
            } else {
                gbc.gridx++;
            }
        }

        //Próximos Estrenos
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(80, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;

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

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 30, 50, 30);
        gbc.gridx = 0;

        List<Movie> upcomingMovies = cine.getGson().loadPeliculas(Utilities.UPCOMING_MOVIES_PATH);
        col = 0;

        for (Movie m : upcomingMovies) {
            String imagePath = Utilities.getImageForMovieTitle(m.getTitle());
            MovieCardPanel card = new MovieCardPanel(
                    m.getTitle(),
                    m.getGenre() + " • " + m.getClassification(),
                    "Duración: " + m.getDurationMinutes() + " min",
                    new ImageIcon(getClass().getResource(imagePath)),
                    listener
            );

            card.getBtnDetails().setActionCommand("VER_DETALLES_" + m.getId());
            card.getBtnDetails().addActionListener(listener);

            contentPanel.add(card, gbc);

            col++;
            if (col == 3) {
                col = 0;
                gbc.gridx = 0;
                gbc.gridy++;
            } else {
                gbc.gridx++;
            }
        }

        mainContent.add(contentPanel, BorderLayout.CENTER);
    }

    public void scrollToUpcoming() {
        if (scrollPane != null && btnUpcoming != null) {
            SwingUtilities.invokeLater(() -> {
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
