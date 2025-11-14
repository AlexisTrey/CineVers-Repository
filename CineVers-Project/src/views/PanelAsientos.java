/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import models.Seat;
import utilities.Utilities;



/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class PanelAsientos extends JPanel {

    private SeatState seatState;
    private final Set<String> sillasSeleccionadas = new HashSet<>();
    private final Map<String, JButton> seatButtonsMap = new HashMap<>(); // Para acceder a botones por ID
    private ActionListener listener;

    // Esta lista debe ser generada previamente por el SeatGenerator y RoomFactory
    public PanelAsientos(ActionListener listener, List<Seat> roomSeats) {
        setLayout(null);
        this.listener = listener; // Inicializa la lista de asientos de la sala
        setPreferredSize(new Dimension(800, 1000));
        setBackground(Color.WHITE);
        buildSeatsView(roomSeats); 
    }
        public PanelAsientos(ActionListener listener) {
        setLayout(null);
        this.listener = listener; // Inicializa la lista de asientos de la sala
        setPreferredSize(new Dimension(800, 1000));
        setBackground(Color.WHITE); 
    }

    public void buildSeatsView(List<Seat> roomSeats) {
        int T_SILLA = 40;
        int ESPACIO_X = 10;
        int ESPACIO_Y = 15;
        int OFFSET_X = 50;
        int OFFSET_Y = 100;
        
        // Variables para calcular las coordenadas (similar al original)
        int asientosEnFilaActual = 0;
        String filaAnterior = "";
        int rowIndex = -1; // Usado para calcular la posición Y

        for (Seat seat : roomSeats) {
            String seatKey = seat.getId(); // Ej: "A1", "B5"
            String seatRow = seat.getRow();
            
            // 1. Detección de cambio de fila y cálculo de posición Y
            if (!seatRow.equals(filaAnterior)) {
                filaAnterior = seatRow;
                asientosEnFilaActual = 0; 
                rowIndex++; 
            }
            
            // 2. Cálculo de Coordenadas
            int x = OFFSET_X + asientosEnFilaActual * (T_SILLA + ESPACIO_X);
            int y = OFFSET_Y + rowIndex * (T_SILLA + ESPACIO_Y);
            

            JButton silla = new JButton();
            silla.setName(seatKey);
            silla.setBounds(x, y, T_SILLA, T_SILLA);
            silla.setBackground(Color.WHITE);
            
            if (seat.isAvailable()) {
                silla.setIcon(Utilities.BASE_ICON_SEAT_PATH);
                silla.addActionListener(listener);
                silla.setActionCommand("SELECTED_SEAT");
            } else {
                silla.setIcon(Utilities.SELECTED_ICON_SEAT_PATH);
                silla.setEnabled(false); // No se puede interactuar
            }
            
            add(silla);
            seatButtonsMap.put(seatKey, silla);
            asientosEnFilaActual++;
        }
    }

    public void setSeatState(SeatState seatState) {
        this.seatState = seatState;
    }
    
    // EL CONTROLADOR LLAMA A ESTE MÉTODO (DEBE MANTENERSE)
    public Set<String> getSillasSeleccionadas() {
        return sillasSeleccionadas;
    }

    // EL CONTROLADOR LLAMA A ESTE MÉTODO (DEBE MANTENERSE)
    public void alternarSeleccion(JButton silla) {
        String nombreSilla = silla.getName();
        
        // Lógica de alternancia del Controlador:
        if (sillasSeleccionadas.contains(nombreSilla)) {
            sillasSeleccionadas.remove(nombreSilla); 
            // La vista (icono) ya fue cambiada por el Controlador
        } else {
            sillasSeleccionadas.add(nombreSilla); 
            // La vista (icono) ya fue cambiada por el Controlador
        }
        
    }
    
    // Métodos accesorios para el Controlador (si usas la Solución 2)
    public ImageIcon getNextIcon(JButton silla) {
        if (silla.getIcon().equals(Utilities.BASE_ICON_SEAT_PATH)) {
            return Utilities.SELECTED_ICON_SEAT_PATH;
        } else {
            return Utilities.BASE_ICON_SEAT_PATH;
        }
    }
}