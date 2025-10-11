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
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Paola
 */
public class ScheduleMoviePanel extends JPanel {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color cardColor = new Color(255, 255, 255);
    private Color primaryColor = new Color(102, 0, 161); // Morado 
    private Color secondaryColor = new Color(140, 100, 210); // Morado más claro para hover
    private Color textColor = new Color(50, 50, 50);
    private Color lightTextColor = new Color(150, 150, 150);

    private List<DayCard> days;
    private int currentIndex = 0;
    private JPanel cardsPanel;
    private JLabel cinemaLabel;
    private JPanel timesPanel;

    public ScheduleMoviePanel() {
        setBackground(backgroundColor);
        setLayout(new BorderLayout());

        initializeDays();
        createUI();
    }

    private void initializeDays() {
        days = new ArrayList<>();
        days.add(new DayCard("MAR", "19 ago", new String[]{"4:20 p.m.", "7:40 p.m.", "9:10 p.m."}));
        days.add(new DayCard("MIÉ", "20 ago", new String[]{"2:30 p.m.", "5:45 p.m.", "8:15 p.m."}));
        days.add(new DayCard("JUE", "21 ago", new String[]{"3:15 p.m.", "6:30 p.m.", "9:45 p.m."}));
        days.add(new DayCard("VIE", "22 ago", new String[]{"1:20 p.m.", "4:40 p.m.", "7:50 p.m."}));
    }

    private void createUI() {
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior con el cine
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(backgroundColor);

        cinemaLabel = new JLabel("Multicine Viva Tunja");
        cinemaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cinemaLabel.setForeground(primaryColor);

        JLabel formatLabel = new JLabel("2D - DOB");
        formatLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        formatLabel.setForeground(primaryColor);

        topPanel.add(cinemaLabel, BorderLayout.WEST);
        topPanel.add(formatLabel, BorderLayout.EAST);

        // Panel del carrusel
        JPanel carouselPanel = new JPanel(new BorderLayout());
        carouselPanel.setBackground(backgroundColor);

        // Panel para las tarjetas de días
        cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        cardsPanel.setBackground(backgroundColor);
        updateCardsDisplay();

        // Botones de navegación usando ShapedButtons
        JButton prevButton = createNavigationButton("<");
        JButton nextButton = createNavigationButton(">");

        prevButton.addActionListener(e -> navigate(-1));
        nextButton.addActionListener(e -> navigate(1));

        JPanel navPanel = new JPanel(new BorderLayout());
        navPanel.setBackground(backgroundColor);
        navPanel.add(prevButton, BorderLayout.WEST);
        navPanel.add(cardsPanel, BorderLayout.CENTER);
        navPanel.add(nextButton, BorderLayout.EAST);

        carouselPanel.add(navPanel, BorderLayout.CENTER);

        // Panel de horarios
        timesPanel = createTimesPanel();

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(carouselPanel, BorderLayout.CENTER);
        mainPanel.add(timesPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JButton createNavigationButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(50, 50));
        button.setBackground(backgroundColor);
        button.setForeground(primaryColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setUI(new ShapedButtons());

        return button;
    }

    private JButton createTimeButton(String time) {
        JButton button = new JButton(time);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(100, 40));
        button.setBackground(cardColor);
        button.setForeground(primaryColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(primaryColor, 2));

        // Efecto hover personalizado
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(primaryColor);
                button.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(cardColor);
                button.setForeground(primaryColor);
            }
        });

        return button;
    }

    private void navigate(int direction) {
        currentIndex += direction;
        if (currentIndex < 0) {
            currentIndex = days.size() - 1;
        } else if (currentIndex >= days.size()) {
            currentIndex = 0;
        }
        updateCardsDisplay();
        updateTimesDisplay();
    }

    private void updateCardsDisplay() {
        cardsPanel.removeAll();

        // Mostrar 3 días a la vez (actual, anterior y siguiente)
        for (int i = -1; i <= 1; i++) {
            int index = currentIndex + i;
            if (index < 0) {
                index = days.size() - 1;
            }
            if (index >= days.size()) {
                index = 0;
            }

            DayCard day = days.get(index);
            JPanel dayCard = createDayCard(day, i == 0);
            cardsPanel.add(dayCard);
        }

        cardsPanel.revalidate();
        cardsPanel.repaint();
    }

    private void updateTimesDisplay() {
        timesPanel.removeAll();

        DayCard currentDay = days.get(currentIndex);
        for (String time : currentDay.getTimes()) {
            JButton timeButton = createTimeButton(time);
            timesPanel.add(timeButton);
        }

        timesPanel.revalidate();
        timesPanel.repaint();
    }

    private JPanel createDayCard(DayCard day, boolean isSelected) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (isSelected) {
                    // Tarjeta seleccionada con gradiente morado
                    GradientPaint gradient = new GradientPaint(
                            0, 0, primaryColor,
                            0, getHeight(), secondaryColor
                    );
                    g2d.setPaint(gradient);
                } else {
                    g2d.setColor(cardColor);
                }

                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

                // Borde
                g2d.setColor(isSelected ? primaryColor : new Color(200, 200, 200));
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
        };

        card.setPreferredSize(new Dimension(80, 70));
        card.setLayout(new BorderLayout());
        card.setOpaque(false);

        JLabel dayLabel = new JLabel(day.getDay(), SwingConstants.CENTER);
        dayLabel.setFont(new Font("Arial", Font.BOLD, 12));
        dayLabel.setForeground(isSelected ? Color.WHITE : lightTextColor);

        JLabel dateLabel = new JLabel(day.getDate(), SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        dateLabel.setForeground(isSelected ? Color.WHITE : textColor);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        contentPanel.add(dayLabel, BorderLayout.NORTH);
        contentPanel.add(dateLabel, BorderLayout.CENTER);

        card.add(contentPanel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createTimesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(backgroundColor);
        return panel;
    }

    // Clase interna para representar un día con sus horarios
    private static class DayCard {

        private String day;
        private String date;
        private String[] times;

        public DayCard(String day, String date, String[] times) {
            this.day = day;
            this.date = date;
            this.times = times;
        }

        public String getDay() {
            return day;
        }

        public String getDate() {
            return date;
        }

        public String[] getTimes() {
            return times;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Horarios de Cine");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ScheduleMoviePanel panel = new ScheduleMoviePanel();
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
