package views;

import java.awt.BorderLayout;
import java.awt.Color;
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
    private ActionListener listener;

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

        Font bigFont = customFont.deriveFont(Font.BOLD, 70f);  // Para letras grandes
        Font normalFont = customFont.deriveFont(Font.BOLD, 50f); // Para el resto

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

    private void createPanelBtns() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 20));
        buttonsPanel.setOpaque(false);

        buttonsPanel.add(createBtns("Cartelera"));
        buttonsPanel.add(createBtns("Próximos estrenos"));
        buttonsPanel.add(createBtns("Mi Cuenta"));

        add(buttonsPanel, BorderLayout.CENTER);
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
}
