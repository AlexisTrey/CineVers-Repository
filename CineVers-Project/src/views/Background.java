package views;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;

import javax.swing.JPanel;

public class Background extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		background(g2d);
	}

	private void background(Graphics2D g2d) {
		int width = getWidth();
		int height = getHeight();
		Color leftColor = Color.decode("#2C2C54");   // Izquierda
		Color centerColor = Color.decode("#7B2CBF"); // Centro
		Color rightColor = Color.decode("#7B2CBF");  // Derecha

		float[] fractions = {0f, 0.5f, 1f}; // Posiciones relativas de los colores
		Color[] colors = {leftColor, centerColor, rightColor};
		LinearGradientPaint gradient = new LinearGradientPaint(0, 0, width, 0, fractions, colors);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, width, height);
	}
}
