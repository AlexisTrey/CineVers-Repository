/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.MainFrame;
import views.MainPanel;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Controller implements ActionListener {

    private MainFrame mainFrame;

    public Controller() {
        mainFrame = new MainFrame(this);
    }

    public void init() {
        mainFrame.getMainPanel().showPanel(MainPanel.EDIT_FUNCTIONS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "HOME":
                mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                break;
            case "UPCOMING":
                mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                break;
            case "ACCOUNT":
                System.out.println("Abrir panel de cuenta (pendiente)");
                break;
            case "EDITAR_SALAS":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_ROOMS);
                break;
            case "EDITAR_CARTELERA":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_BILLBOARD);
                break;
            case "EDITAR_FUNCIONES":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_FUNCTIONS);
                break;
            default:
                System.out.println("Acción no reconocida: " + command);
        }
    }
}
