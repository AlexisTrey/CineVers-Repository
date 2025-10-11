/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jhonnyd
 */
public class PanelMainCreateCartelera extends javax.swing.JPanel {
        private Background badground;
        private Header header;
        private ActionListener listener;

    public PanelMainCreateCartelera() {
       this.listener = listener; 
        initComponents2(listener);

    }

    private void initComponents2(ActionListener listener) {
        this.setLayout(new BorderLayout());
        this.header = new Header(listener);
        
       this.add(header, BorderLayout.NORTH);
    }
    
    
//private JPanel CreatecenterPane() {
//
//}
    
         public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Demo Cineverso");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1024, 768);
            frame.setLocationRelativeTo(null);

            // Aquí agregás tu panel principal completo
            frame.add(new PanelMainCreateCartelera());

            frame.setVisible(true);
        });
    }
        
        
}
