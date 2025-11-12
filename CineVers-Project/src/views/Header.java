package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.*;
import models.User;

import javax.swing.JPanel;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Header extends JPanel {

    private Font customFont;
    private JButton btnBillboard;
    private JButton btnUpcomingReleases;
    private JButton btnAccount;
    private JButton btnAdmin;
    private ActionListener listener;
    private JButton btnUserProfile;
    private UserMenuPanel userMenu;

    private JLabel lblName, lblEmail, lblRole;

    public Header(ActionListener listener) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int panelHeight = (int) (screenSize.height * 0.12);
        this.setPreferredSize(new Dimension(screenSize.width, panelHeight));
        setLayout(new BorderLayout());

        this.listener = listener;
        loadCustomFont();
        createPanelBtns();
    }

    private void loadCustomFont() {
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/LuckiestGuy-Regular.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la fuente personalizada, usando Impact.");
            customFont = new Font("Impact", Font.BOLD, 60);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawHeader(g2d);
    }

    private void drawHeader(Graphics2D g2d) {

        g2d.setColor(new Color(14, 14, 24));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(new Color(235, 242, 240));

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font bigFont = customFont.deriveFont(Font.BOLD, 70f);
        Font normalFont = customFont.deriveFont(Font.BOLD, 50f);

        int x = 50;
        int y = 85;

        g2d.setFont(bigFont);
        g2d.drawString("C", x, y);
        x += g2d.getFontMetrics().stringWidth("C");

        g2d.setFont(normalFont);
        g2d.drawString("INE", x, y);
        x += g2d.getFontMetrics().stringWidth("INE");

        g2d.setFont(bigFont);
        g2d.drawString("V", x, y);
        x += g2d.getFontMetrics().stringWidth("V");

        g2d.setFont(normalFont);
        g2d.drawString("ERS", x, y);
    }

    private JButton createBtn(String text, String actionCommand, ActionListener listener) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(220, 70));
        button.setUI(new ShapedButtons());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        return button;
    }

    public void btnBillboardListener() {
        btnBillboard.addActionListener(listener);
    }

    public void btnUpcomingReleasesListener() {
        btnUpcomingReleases.addActionListener(listener);
    }

    public void btnAccountListener() {
        btnAccount.addActionListener(listener);
    }

    public void btnAdminListener() {
        btnAdmin.addActionListener(listener);
    }

    public void setAdminVisible(boolean visible) {
        if (btnAdmin != null) {
            btnAdmin.setVisible(visible);
        }
    }

    private void createPanelBtns() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 20));
        buttonsPanel.setOpaque(false);

        btnBillboard = createBtn("Cartelera", "HOME", listener);
        btnAccount = createBtn("Mi Cuenta", "LOGIN", listener);
        btnAdmin = createBtn("Gestión", "EDITAR_FUNCIONES", listener);

        btnUserProfile = new JButton("");
        userMenu = new UserMenuPanel(listener);

        btnUserProfile.setPreferredSize(new Dimension(60, 60));
        btnUserProfile.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnUserProfile.setBackground(new Color(70, 67, 133));
        btnUserProfile.setForeground(Color.WHITE);
        btnUserProfile.setFocusPainted(false);
        btnUserProfile.setVisible(false);
        btnUserProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnUserProfile.setBorderPainted(false);
        btnUserProfile.setContentAreaFilled(false);

        btnUserProfile.setOpaque(true);
        btnUserProfile.setBorder(BorderFactory.createEmptyBorder());
        btnUserProfile.setBackground(new Color(70, 67, 133));

        btnUserProfile.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(btnUserProfile.getBackground());
                g2.fillOval(0, 0, c.getWidth(), c.getHeight());
                super.paint(g, c);
                g2.dispose();
            }
        });

        btnUserProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnUserProfile.setBackground(new Color(123, 44, 191));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnUserProfile.setBackground(new Color(70, 67, 133));
            }
        });

        btnUserProfile.addActionListener(e -> {
            if (userMenu != null) {
                userMenu.show(btnUserProfile, 0, btnUserProfile.getHeight());
            }
        });

        btnUserProfile.addActionListener(e -> {
            if (userMenu != null) {
                userMenu.show(btnUserProfile, 0, btnUserProfile.getHeight());
            }
        });

        buttonsPanel.add(btnBillboard);
        buttonsPanel.add(btnAccount);
        buttonsPanel.add(btnAdmin);
        buttonsPanel.add(btnUserProfile);
        add(buttonsPanel, BorderLayout.CENTER);

    }

    public void setUserVisible(boolean visible) {
        btnUserProfile.setVisible(visible);

        btnAccount.setVisible(!visible);

        if (!visible && btnAdmin != null) {
            btnAdmin.setVisible(false);
        }
    }

    public void updateUserInfo(User user) {
        if (user != null) {
            String initial = user.getFullName().substring(0, 1).toUpperCase();
            btnUserProfile.setText(initial);
            userMenu.updateUserInfo(
                    user.getFullName(),
                    user.getEmail(),
                    user.isAdmin() ? "Administrador" : "Cliente"
            );
            btnUserProfile.setVisible(true);
            btnAccount.setVisible(false);
            setAdminVisible(user.isAdmin());
        } else {
            btnUserProfile.setVisible(false);
            btnAccount.setVisible(true);
            setAdminVisible(false);
        }

    }

}
