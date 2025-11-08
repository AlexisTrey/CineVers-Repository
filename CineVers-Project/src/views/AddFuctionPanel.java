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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import views.Background;
import views.FormFuctionPanel;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class AddFuctionPanel extends javax.swing.JPanel {

    private Background badground;


    private ActionListener listener;
    private GridBagConstraints gbc;
    private FormBillboardPanel formPanel;

    public AddFuctionPanel(ActionListener listener) {
        this.listener = listener;
        initComponents2();

    }

    private void initComponents2() {
        this.setLayout(new BorderLayout());
        this.badground = new Background();
        this.badground.setLayout(new GridBagLayout());
        JPanel centerWrapper = createCenterContainer();
        
        gbc= new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        

        this.badground.add(centerWrapper, gbc);
        this.add(this.badground , BorderLayout.CENTER);

    }

    private JPanel createCenterContainer() {
        gbc = new GridBagConstraints();
        JPanel centerWrapper = new JPanel();
        centerWrapper.setBackground(Color.red);
        centerWrapper.setOpaque(false);
        centerWrapper.setBorder(new EmptyBorder(110, 0, 120, 0));
        formPanel = new FormBillboardPanel(listener);
        centerWrapper.add(formPanel, BorderLayout.NORTH);
        return centerWrapper;
    }
    
        public Background getBadground() {
        return badground;
    }

    public FormBillboardPanel getFormPanel() {
        return formPanel;
    }

}
