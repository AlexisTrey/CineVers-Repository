/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Paola
 */
public class MovieDetailsPanel extends JPanel {

    private BannerMoviePanel banner;
    private PosterMoviePanel poster;
    private ScheduleMoviePanel schedule;
    private SinopsisMovie sinopsis;
    private Footer footer;
    private ActionListener listener;

    public MovieDetailsPanel(ActionListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ---------- BANNER ----------
        banner = new BannerMoviePanel();
        banner.setPreferredSize(new Dimension(800, 250));
        setBannerImage("/resources/images/banner_together.jpg");
        add(banner, BorderLayout.NORTH);

        // ---------- PANEL CENTRAL PRINCIPAL ----------
        JPanel centerPanel = new JPanel(new BorderLayout(20, 0));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new EmptyBorder(20, 40, 20, 40));

        // ---------- PANEL IZQUIERDO (Poster) ----------
        poster = new PosterMoviePanel();
        poster.setPreferredSize(new Dimension(250, 400));

        // ---------- PANEL CENTRO (Sinopsis) ----------
        sinopsis = new SinopsisMovie();
        sinopsis.setPreferredSize(new Dimension(400, 400));

        // ---------- PANEL DERECHO (Horarios) ----------
        schedule = new ScheduleMoviePanel();
        schedule.setPreferredSize(new Dimension(550, 300));

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        JPanel leftContainer = new JPanel(new BorderLayout());
        leftContainer.setBackground(Color.WHITE);
        leftContainer.add(poster, BorderLayout.NORTH);

        JPanel centerContainer = new JPanel(new BorderLayout());
        centerContainer.setBackground(Color.WHITE);
        centerContainer.add(sinopsis, BorderLayout.CENTER);

        JPanel rightContainer = new JPanel(new BorderLayout());
        rightContainer.setBackground(Color.WHITE);
        rightContainer.add(schedule);

        contentPanel.add(leftContainer);
        contentPanel.add(centerContainer);
        contentPanel.add(rightContainer);

        centerPanel.add(contentPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

    }

    public void setBannerImage(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        banner.paintBanner(img);
    }

    private JButton createBtns(String textButton) {
        JButton button = new JButton(textButton);
        button.setPreferredSize(new Dimension(220, 70));
        button.setUI(new ShapedButtons());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        button.setFocusPainted(false);
        return button;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Horarios de Cine");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            MovieDetailsPanel panel = new MovieDetailsPanel(null);
//            frame.add(panel);
//
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
}
