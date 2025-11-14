/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class SelectSeats extends JPanel {

    private MovieDetailsPanel contentPanelMovieDetails;
    private PanelAsientos contentPanelAsientos;
    private SeatState contentPanelSeatState;

    public SelectSeats(ActionListener listener) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        contentPanelMovieDetails = new MovieDetailsPanel(listener); //revisar cómo quedaría bien porque la clase MovieDetailsPanel pide un listener por parámetro
        contentPanelAsientos = new PanelAsientos(listener);
        contentPanelSeatState = new SeatState(listener);
        buildPanel();
    }

    private void buildPanel() {
        JPanel contentCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0)); // 40 px de espacio horizontal entre los paneles
        contentCenterPanel.setBackground(Color.WHITE);

        add(contentPanelMovieDetails, BorderLayout.NORTH);

        contentCenterPanel.add(contentPanelSeatState);
        contentCenterPanel.add(contentPanelAsientos);

        add(contentCenterPanel, BorderLayout.CENTER);
    }

    public PanelAsientos getPanelAsientos(){
        return contentPanelAsientos;
    }
    
    
//    public static void main(String[] args) {
//            SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Sillas selecionadas");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//            SelectSeats panel = new SelectSeats();
//            frame.add(panel);

//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
}
