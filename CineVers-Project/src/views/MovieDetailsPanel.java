/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
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
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class MovieDetailsPanel extends JPanel {

 private BannerMoviePanel banner;
    private PosterMoviePanel poster;
    private ScheduleMoviePanel schedule;
    private SinopsisMovie sinopsis;
    private Footer footer;
    private ActionListener listener;

    // Tamaño preferido razonable para evitar estiramientos verticales
    private static final Dimension PREFERRED = new Dimension(1200, 800);

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
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new EmptyBorder(30, 60, 30, 60));

        // ---------- PANEL IZQUIERDO (Poster) ----------
        poster = new PosterMoviePanel();
        poster.setPreferredSize(new Dimension(250, 400));
        // Para que no se estire verticalmente:
        poster.setMaximumSize(poster.getPreferredSize());
        poster.setAlignmentY(Component.TOP_ALIGNMENT);

        // ---------- PANEL CENTRO (Sinopsis) ----------
        sinopsis = new SinopsisMovie();
        sinopsis.setPreferredSize(new Dimension(400, 400));
        sinopsis.setMaximumSize(sinopsis.getPreferredSize());
        sinopsis.setAlignmentY(Component.TOP_ALIGNMENT);

        // ---------- PANEL DERECHO (Horarios) ----------
        schedule = new ScheduleMoviePanel(listener);
        schedule.setPreferredSize(new Dimension(550, 300));
        schedule.setMaximumSize(schedule.getPreferredSize());
        schedule.setAlignmentY(Component.TOP_ALIGNMENT);

        // ---------- PANEL CONTENEDOR HORIZONTAL ----------
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        // Contenedores individuales (envuelven cada panel para más control)
        JPanel leftContainer = new JPanel(new BorderLayout());
        leftContainer.setBackground(Color.WHITE);
        leftContainer.add(poster, BorderLayout.NORTH);
        leftContainer.setPreferredSize(poster.getPreferredSize());
        leftContainer.setMaximumSize(leftContainer.getPreferredSize());
        leftContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        JPanel centerContainer = new JPanel(new BorderLayout());
        centerContainer.setBackground(Color.WHITE);
        centerContainer.add(sinopsis, BorderLayout.CENTER);
        centerContainer.setPreferredSize(sinopsis.getPreferredSize());
        centerContainer.setMaximumSize(centerContainer.getPreferredSize());
        centerContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        JPanel rightContainer = new JPanel(new BorderLayout());
        rightContainer.setBackground(Color.WHITE);
        rightContainer.add(schedule, BorderLayout.CENTER);
        rightContainer.setPreferredSize(schedule.getPreferredSize());
        rightContainer.setMaximumSize(rightContainer.getPreferredSize());
        rightContainer.setAlignmentY(Component.TOP_ALIGNMENT);

        // Agregar separación horizontal entre paneles
        contentPanel.add(leftContainer);
        contentPanel.add(Box.createHorizontalStrut(50)); // espacio ajustable
        contentPanel.add(centerContainer);
        contentPanel.add(Box.createHorizontalStrut(70)); // espacio ajustable
        contentPanel.add(rightContainer);

        centerPanel.add(contentPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Establecer preferredSize de la vista completa para que el scroll no la estire
        setPreferredSize(PREFERRED);
    }

    @Override
    public Dimension getMaximumSize() {
        // Permitimos ancho ilimitado (para que se ajuste al ancho del scroll),
        // pero fijamos la altura al preferred para no estirar verticalmente.
        Dimension pref = getPreferredSize();
        if (pref == null) return new Dimension(Integer.MAX_VALUE, 800);
        return new Dimension(Integer.MAX_VALUE, pref.height);
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

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Horarios de Cine");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MovieDetailsPanel panel = new MovieDetailsPanel(null);
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
