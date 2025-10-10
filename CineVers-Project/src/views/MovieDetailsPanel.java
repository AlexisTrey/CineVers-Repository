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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Paola
 */
public class MovieDetailsPanel extends JPanel {

    //private Footer footer;
    private JLabel lblBanner;
    private JLabel lblPoster;
    private JLabel lblTitle;
    private JLabel lblSynopsis;
    private JLabel lblInfo;
    private JLabel lblDay;
    private JLabel lblTheater;

    private JPanel pnlContent;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JPanel pnlSchedule;
    private JPanel pnlDays;
    private JPanel pnlBottom;

    private JButton btnPrevDay;
    private JButton btnNextDay;

    private JComboBox<String> comboTheater;
    private BannerMoviePanel banner;
    private ActionListener listener;

    public MovieDetailsPanel(ActionListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ---------- CONTENIDO CENTRAL ----------
        pnlContent = new JPanel(new BorderLayout());
        pnlContent.setBackground(Color.WHITE);

        banner = new BannerMoviePanel(); //BANNER
        banner.setPreferredSize(new Dimension(800, 250)); // altura opcional
        setBannerImage("/resources/images/banner_together.jpg");
        add(banner, BorderLayout.NORTH); // ubicarlo arriba

        // ---------- PANEL INFERIOR ----------
        pnlBottom = new JPanel(new GridLayout(1, 2, 40, 0));
        pnlBottom.setBackground(Color.WHITE);
        pnlBottom.setBorder(new EmptyBorder(40, 100, 40, 100));

        // ---------- PANEL IZQUIERDO (SINOPSIS) ----------
        pnlLeft = new JPanel();
        pnlLeft.setBackground(new Color(250, 250, 250)); // Gris suave
        pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.Y_AXIS));
        pnlLeft.setPreferredSize(new Dimension(350, 600));

        // Póster
        lblPoster = new JLabel(new ImageIcon(getClass().getResource("/resources/images/poster_together.png")));
        lblPoster.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPoster.setBorder(new EmptyBorder(0, 0, 15, 0));
        pnlLeft.add(lblPoster);

        // Título SINOPSIS
        lblTitle = new JLabel("SINOPSIS");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlLeft.add(lblTitle);

        // Texto de sinopsis
        JTextArea txtSynopsis = new JTextArea(
                "Una mudanza al campo desata fuerzas sobrenaturales\n"
                + "que transforman la relación de una pareja, su realidad y sus cuerpos."
        );
        txtSynopsis.setFont(new Font("SansSerif", Font.PLAIN, 15));
        txtSynopsis.setForeground(Color.DARK_GRAY);
        txtSynopsis.setBackground(new Color(250, 250, 250));
        txtSynopsis.setEditable(false);
        txtSynopsis.setLineWrap(true);
        txtSynopsis.setWrapStyleWord(true);
        txtSynopsis.setBorder(new EmptyBorder(10, 0, 10, 0));
        txtSynopsis.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlLeft.add(txtSynopsis);

        // Información adicional
        JTextArea txtInfo = new JTextArea(
                "\nNombre original: TOGETHER\n"
                + "Clasificación: Para mayores de 15 años\n"
                + "Reparto: Dave Franco, Alison Brie, Damon Herriman\n"
                + "Director: Michael Shanks"
        );
        txtInfo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtInfo.setForeground(new Color(80, 80, 80));
        txtInfo.setBackground(new Color(250, 250, 250));
        txtInfo.setEditable(false);
        txtInfo.setBorder(null);
        txtInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlLeft.add(txtInfo);

        // Espaciado flexible abajo
        pnlLeft.add(Box.createVerticalGlue());

        // Scroll del panel izquierdo
        JScrollPane scrollLeft = new JScrollPane(pnlLeft);
        scrollLeft.setBorder(null);
        scrollLeft.getViewport().setBackground(new Color(250, 250, 250));
        scrollLeft.setPreferredSize(new Dimension(400, 700));
        scrollLeft.getVerticalScrollBar().setUnitIncrement(16);
        pnlBottom.add(scrollLeft);

        // ---------- PANEL DERECHO (HORARIOS) ----------
        pnlRight = new JPanel();
        pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));
        pnlRight.setBackground(Color.WHITE);

        // Días
        pnlDays = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pnlDays.setBackground(Color.WHITE);

        btnPrevDay = new JButton("<");
        btnNextDay = new JButton(">");

        lblDay = new JLabel("MAR 19 AGO", SwingConstants.CENTER);
        lblDay.setFont(new Font("SansSerif", Font.BOLD, 14));

        pnlDays.add(btnPrevDay);
        pnlDays.add(lblDay);
        pnlDays.add(btnNextDay);

        pnlRight.add(pnlDays);

        // Teatro
        lblTheater = new JLabel("Multicine Viva Tunja", SwingConstants.CENTER);
        lblTheater.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTheater.setBorder(new EmptyBorder(10, 0, 10, 0));
        pnlRight.add(lblTheater);

        // Horarios
        pnlSchedule = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        pnlSchedule.setBackground(Color.WHITE);

        String[] hours = {"4:20 p.m.", "7:40 p.m.", "9:10 p.m."};
        for (String h : hours) {
            JButton btn = new JButton(h);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(230, 230, 230));
            btn.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
            pnlSchedule.add(btn);
        }

        pnlRight.add(pnlSchedule);
        pnlBottom.add(pnlRight);

        // Añadir panel inferior al contenido
        pnlContent.add(pnlBottom, BorderLayout.CENTER);
        add(pnlContent, BorderLayout.CENTER);
    }

    public void setBannerImage(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        banner.paintBanner(img);
    }
}
