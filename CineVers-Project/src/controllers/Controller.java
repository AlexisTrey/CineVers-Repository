/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

import models.CineVersSystem;
import models.Function;
import models.Movie;
import models.Room;
import models.User;
import models.Seat;
import views.ConfirmReservation;
import views.FormBillboardPanel;
import views.FormFuctionPanel;
import views.MainFrame;
import views.MainPanel;
import views.PanelAsientos;
import views.LoginView;
import views.RegisterView;
import utilities.Utilities;
import models.City;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Frame;
import java.util.List;

import views.LoginPromptDialog;
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
    private CineVersSystem cine;
    private Timer loginPromptTimer;
    private boolean loginPromptShown = false;

    public Controller() {
        this.mainFrame = new MainFrame(this);
        this.cine = new CineVersSystem();
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
                startLoginPromptTimer(15_000);
                break;

            case "LOGIN":
                mainFrame.getMainPanel().showPanel(MainPanel.LOGIN);
                break;

            case "ABRIR_REGISTRO":

                mainFrame.getMainPanel().showPanel(MainPanel.REGISTER);
                break;

            case "REGISTRAR":
                RegisterView regView = mainFrame.getMainPanel().getRegisterView();

                String nombres = regView.getNombres();
                String apellidos = regView.getApellidos();
                String correo = regView.getCorreo();
                String contrasena = regView.getContrasena();
                String tipoDocumento = regView.getDocumento();
                String numeroDocumento = regView.getNumeroDocumento();
                String telefono = regView.getTelefono();
                String ciudad = regView.getCiudad();

                if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty()
                        || contrasena.isEmpty() || tipoDocumento.isEmpty() || numeroDocumento.isEmpty()
                        || ciudad.isEmpty()) {
                    regView.showMessage("Por favor completa todos los campos obligatorios.");
                    break;
                }

                if (correo.toLowerCase().contains("@admin")) {
                    regView.showMessage("No puedes registrar una cuenta con correo de administrador.");
                    break;
                }

                User nuevo = new User();
                nuevo.setFirstName(nombres);
                nuevo.setLastName(apellidos);
                nuevo.setEmail(correo);
                nuevo.setPassword(contrasena);
                nuevo.setDocumentType(tipoDocumento);
                nuevo.setDocumentNumber(numeroDocumento);
                nuevo.setPhone(telefono);
                nuevo.setAdmin(false);

                cine.setSelectedCity(ciudad);
                nuevo.setCity(cine.getSelectedCity());

                boolean registrado = cine.registerUser(nuevo);

                if (registrado) {
                    regView.showMessage("Usuario registrado correctamente.");
                    mainFrame.getMainPanel().showPanel(MainPanel.LOGIN);
                } else {
                    regView.showMessage("Ya existe un usuario con ese correo.");
                }
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
                String ciudadSeleccionada = mainFrame
                        .getMainPanel()
                        .getSelectCityView()
                        .getSelectedCity();

                if (ciudadSeleccionada != null && !ciudadSeleccionada.isEmpty()) {
                    cine.setSelectedCity(ciudadSeleccionada);
                    mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                    startLoginPromptTimer(10_000);
                }
                break;

            case "INICIAR_SESION":
                String email = mainFrame.getMainPanel()
                        .getLoginView()
                        .getEmail();
                String password = mainFrame.getMainPanel()
                        .getLoginView()
                        .getPassword();

                User user = cine.loginUser(email, password);

                if (user != null) {
                    cancelLoginPromptIfRunning();
                    mainFrame.getMainPanel().getHeader().setUserVisible(true);
                    mainFrame.getMainPanel().getHeader().updateUserInfo(user);

                    if (user.isAdmin()) {
                        mainFrame.getMainPanel().getHeader().setAdminVisible(true);
                        mainFrame.getMainPanel().showPanel(MainPanel.EDIT_BILLBOARD);
                    } else {
                        mainFrame.getMainPanel().getHeader().setAdminVisible(false);
                        mainFrame.getMainPanel().showPanel(MainPanel.HOME);
                    }
                } else {
                    mainFrame.getMainPanel().getLoginView().showError("Correo o contraseña incorrectos");
                }

                break;

            case "CERRAR_SESION":
                cine.logout();
                mainFrame.getMainPanel().getHeader().setUserVisible(false);
                mainFrame.getMainPanel().showPanel(MainPanel.LOGIN);
                mainFrame.getMainPanel().getHeader().updateUserInfo(null);

                break;

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
                this.mainFrame.getMainPanel().getAddFuctionPanel().getFormPanel()
                        .setJComboBox(this.cine.getMovieTitlesArray());

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
            case "AGREGAR_CARTELERA_FORM":

                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_BILLBOARD);
                FormFuctionPanel formPanel = this.mainFrame.getMainPanel().getAddMovieBillboard().getFormPanel();
                String title = formPanel.getCampoTitulo().getText();
                String synopsis = formPanel.getCampoSinopsis().getText();
                String gener = (String) formPanel.getComboGenero().getSelectedItem();
                String classification = formPanel.getCampoClasificacion().getText();
                String filePath = formPanel.getImagePath();
                int duration = Integer.parseInt(formPanel.getCampoDuracion().getText());

                try {
                    this.cine.addMovie(
                            new User(true),
                            new Movie(filePath, title, gener, duration, classification, synopsis, title));
                    System.out.println("Película agregada correctamente.");
                } catch (IOException ex) {
                    System.err.println("Error al guardar la película: " + ex.getMessage());
                }
                break;

            case "AGREGAR_FUNCION_FORM":
                FormBillboardPanel formanPnale1 = this.mainFrame.getMainPanel().getAddFuctionPanel().getFormPanel();
                String titleserch = (String) formanPnale1.getCmbPeliculas().getSelectedItem();

                String id = formanPnale1.getTxtFunctionId().getText();
                // Room rom1 = crear las salas
                String date = formanPnale1.getTxtStartTime().getText();
                Room selectedRoom = this.cine.getRooms().get(0);
                try {
                    this.cine.addFunction(
                            new User(true),
                            new Function(id, this.cine.searchMovieByTitle(titleserch), selectedRoom, date));
                    System.out.println("Función agregada correctamente.");
                    mainFrame.getMainPanel().showPanel(MainPanel.EDIT_BILLBOARD);
                } catch (IOException ex) {
                    System.err.println("Error al guardar la función: " + ex.getMessage());
                }

                break;

            case "AGREGAR_SALA_FORM":
                mainFrame.getMainPanel().showPanel(MainPanel.EDIT_ROOMS);

                break;

            case "SELECTED_SEAT":
                //hacer el llamado del cambio de icono
                JButton clickedSeat = (JButton) e.getSource();
                PanelAsientos panelAsientos = mainFrame.getMainPanel().getSelectSeatsPanel().getPanelAsientos();
                panelAsientos.alternarSeleccion(clickedSeat, Utilities.BASE_ICON_SEAT_PATH,
                Utilities.SELECTED_ICON_SEAT_PATH);
                break;

            case "CONFIRM_SEATS" :
                PanelAsientos panelAsientos2 = mainFrame.getMainPanel().getSelectSeatsPanel().getPanelAsientos();
                Set<String> setsleceted = panelAsientos2.getSillasSeleccionadas();
                String newIdReservation = String.valueOf(cine.createIdReservation());
               // Function fuctionreservation = this.cine.getFuctionReservation(this.mainFrame.getMainPanel().getMovieDetailsPanel().getSinopsis().getInfo()[0][1]);
               // List<Seat> seatsreservation = this.cine.filterChairsByName(setsleceted);
                
                ConfirmReservation dialog = new ConfirmReservation(mainFrame, this);
                dialog.setVisible(true);
                break;

                

            // case "UPCOMING":
            // mainFrame.getMainPanel().showPanel(MainPanel.HOME);
            // javax.swing.SwingUtilities.invokeLater(() -> {
            // mainFrame.getMainPanel().getHomePanel().scrollToUpcoming();
            // });
            // break;
            default:
                System.out.println("Acción no reconocida: " + command);
        }
    }

    private void startLoginPromptTimer(int delayMillis) {
        if (loginPromptTimer != null && loginPromptTimer.isRunning()) {
            loginPromptTimer.stop();
        }
        if (loginPromptShown) {
            return;
        }

        loginPromptTimer = new Timer(delayMillis, (e) -> {
            loginPromptTimer.stop();
            if (isUserLoggedIn()) {
                return;
            }
            if (loginPromptShown) {
                return;
            }

            loginPromptShown = true;
            javax.swing.SwingUtilities.invokeLater(() -> {
                Frame owner = mainFrame;
                System.out.println("[DEBUG] Timer disparado: mostrando LoginPromptDialog...");
                LoginPromptDialog prompt = new LoginPromptDialog(owner, this::handlePromptAction);
                prompt.setVisible(true);
            });

        });

        loginPromptTimer.setRepeats(false);
        loginPromptTimer.start();
    }

    private void cancelLoginPromptIfRunning() {
        if (loginPromptTimer != null && loginPromptTimer.isRunning()) {
            loginPromptTimer.stop();
        }
        loginPromptShown = true;
    }

    private void handlePromptAction(java.awt.event.ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (LoginPromptDialog.ACTION_GO_LOGIN.equals(cmd)) {

            mainFrame.getMainPanel().showPanel(MainPanel.LOGIN);

            cancelLoginPromptIfRunning();

        }
    }

    private boolean isUserLoggedIn() {
        try {
            User current = cine.getActiveUser();
            return current != null;
        } catch (Exception ex) {
            try {
                java.lang.reflect.Method m2 = mainFrame.getMainPanel().getHeader().getClass()
                        .getMethod("isUserVisible");
                Object visible = m2.invoke(mainFrame.getMainPanel().getHeader());
                if (visible instanceof Boolean)
                    return (Boolean) visible;
            } catch (Exception ex2) {
            }
            return false;
        }
    }

}
