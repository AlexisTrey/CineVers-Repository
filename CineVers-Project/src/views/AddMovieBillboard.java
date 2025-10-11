/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.awt.BorderLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import views.Background;
import views.Footer;
import views.Header;

/**
 *
 * @author jhonnyd
 */
public class AddMovieBillboard extends javax.swing.JPanel {
        private Background badground;
        private Header header;
        private Footer footer;
        private ActionListener listener;
        private GridBagConstraints gbc;


    public AddMovieBillboard() {
       this.listener = listener; 
        initComponents2(listener);
    }

    private void initComponents2(ActionListener listener) {
        this.setLayout(new BorderLayout());
        this.header = new Header(listener);
        this.badground = new Background();
        this.footer = new  Footer();
        JPanel centerWrapper  = createCenterContainer();
        this.badground.setLayout(new BorderLayout());
        this.badground.add(header, BorderLayout.NORTH);
        this.badground.add(centerWrapper , BorderLayout.CENTER);
        this.badground.add(footer, BorderLayout.SOUTH);
        this.add(this.badground);

    }
    
   
private JPanel createCenterContainer() {      
        gbc =new GridBagConstraints();
        JPanel centerWrapper = new JPanel();
        JPanel auxPanel = new JPanel();
         auxPanel.setLayout(new GridBagLayout());
         auxPanel.setOpaque(false);
        centerWrapper.setOpaque(true); 
        FormBillboardPanel formPanel = new FormBillboardPanel(listener); 
        centerWrapper.add(formPanel); 
        gbc.ipadx = 800;
        gbc.ipady = 400;
        auxPanel.add(centerWrapper , gbc);

        return auxPanel;
    }

}    
        
