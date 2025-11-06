/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.MainFrame;
import views.MainPanel;
import views.ReservationConfirmationJDialog;

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
        mainFrame.getMainPanel().showPanel(MainPanel.SELECT_CITY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "HOME":
                mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                break;

            case "LOGIN":
                mainFrame.getMainPanel().showPanel(MainPanel.LOGIN);
                break;

            case "ABRIR_REGISTRO":
                mainFrame.getMainPanel().showPanel(MainPanel.REGISTER);
                break;

            case "REGISTRAR":
                mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                break;

            case "VER_DETALLES":
                mainFrame.getMainPanel().showPanel(MainPanel.MOVIE_DETAILS);
                break;

            case "SELECCIONAR_HORA":
                mainFrame.getMainPanel().showPanel(MainPanel.SELECT_SEATS);
                break;

            case "CONFIRMAR_RESERVA":
                ReservationConfirmationJDialog confirmDialog = new ReservationConfirmationJDialog(mainFrame, true);
                confirmDialog.setLocationRelativeTo(mainFrame);
                confirmDialog.setVisible(true);
                break;

            case "SELECCIONAR_CIUDAD":
                mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                break;

            //Flujos propios del Administrador
            case "EDITAR_FUNCIONES":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_FUNCTIONS);
                break;

            case "EDITAR_CARTELERA":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_BILLBOARD);
                break;

            case "EDITAR_SALAS":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_ROOMS);
                break;

            case "AGREGAR_FUNCION":
                mainFrame.getMainPanel().showPanel(MainPanel.ADD_FUNCTION);
                break;

            case "AGREGAR_CARTELERA":
                mainFrame.getMainPanel().showPanel(MainPanel.ADD_BILLBOARD);
                break;

            case "AGREGAR_SALA":
                mainFrame.getMainPanel().showPanel(MainPanel.ADD_ROOM);
                break;

            case "GUARDAR_FUNCION":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_FUNCTIONS);
                break;

            case "GUARDAR_CARTELERA":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_BILLBOARD);
                break;

            case "GUARDAR_SALA":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_ROOMS);
                break;

//            case "UPCOMING":
//                mainFrame.getMainPanel().showPanel(MainPanel.HOME);
//                javax.swing.SwingUtilities.invokeLater(() -> {
//                    mainFrame.getMainPanel().getHomePanel().scrollToUpcoming();
//                });
//                break;

            default:
                System.out.println("Acción no reconocida: " + command);
        }
    }

}
