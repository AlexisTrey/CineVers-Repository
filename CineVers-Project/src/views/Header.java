package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.InputStream;

import javax.swing.JPanel;

public class Header extends JPanel {
	
	private Font customFont;

	public Header() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int panelHeight = (int) (screenSize.height * 0.12);
		this.setPreferredSize(new Dimension(screenSize.width, panelHeight));
		setLayout(new BorderLayout()); 

		loadCustomFont();
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
		
		g2d.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		g2d.drawString("Cartelera", 1000, 70);
		g2d.drawString("Próximos Estrenos", 1130, 70);
		g2d.drawString("Mi Cuenta", 1350, 70);
	}
	
	/*private ShapedButtons createBtnBillboard (String text) {
		
	}*/
}