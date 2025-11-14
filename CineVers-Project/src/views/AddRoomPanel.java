/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import views.Background;
import views.Footer;
import views.Header;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class AddRoomPanel extends javax.swing.JPanel {

    private Background badground;
    private ActionListener listener;
    private GridBagConstraints gbc;
    private FormAddRoomPanel formPanel;

    public AddRoomPanel(ActionListener listener) {
        this.listener = listener;
        initComponents2(listener);

    }

    private void initComponents2(ActionListener listener) {
        this.setLayout(new BorderLayout());
        this.badground = new Background();
        this.badground.setLayout(new GridBagLayout());

        JPanel centerWrapper = createCenterContainer();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;

        this.badground.add(centerWrapper, gbc);
        this.add(this.badground, BorderLayout.CENTER);
    }

    private JPanel createCenterContainer() {
        gbc = new GridBagConstraints();
        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setOpaque(false);
        centerWrapper.setBorder(new EmptyBorder(110, 0, 120, 0));

        formPanel = new FormAddRoomPanel(listener);
        centerWrapper.add(formPanel, BorderLayout.NORTH);

        return centerWrapper;
    }

    public FormAddRoomPanel getFormPanel() {
        return formPanel;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Demo Cineverso");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(1024, 768);
//            frame.setLocationRelativeTo(null);
//
//            // Aquí agregás tu panel principal completo
//            frame.add(new AddRoomPanel(null));
//
//            frame.setVisible(true);
//        });
//    }
}
