/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.MainFrame;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Controller {

    private ActionListener listener;
    private MainFrame mainFrame;

    public Controller() {
       this.listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initListener(e);
            }
        };
        mainFrame = new MainFrame(listener);
    }

    public void init() {
        mainFrame.setVisible(true);
    }
    
    public void initListener (ActionEvent e){
                String name = e.getActionCommand();
                switch (name) {
                   // case "BILLBOARD" -> calculateSum();
                    
                }
    }
}