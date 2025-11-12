/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import utilities.Utilities;

import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class PanelAsientos extends JPanel {

    private Set<String> sillasSeleccionadas = new HashSet<>();
    private SeatState seatState;
    private ActionListener listener;
    private final ImageIcon ICONO_SILLA_BASE = Utilities.BASE_ICON_SEAT_PATH;
    private final ImageIcon ICONO_SILLA_SELECCIONADA = Utilities.SELECTED_ICON_SEAT_PATH;

    public PanelAsientos(ActionListener listener) {
        setLayout(null);
        this.listener = listener;
        // Establecer un tamaño para el panel
        setPreferredSize(new Dimension(800, 1000));
        setBackground(Color.WHITE);
        // Agregar las sillas
        generarAsientos();
    }

    public void setSeatState(SeatState seatState) {
        this.seatState = seatState;
    }

    private void generarAsientos() {
        int T_SILLA = 40;
        int ESPACIO_X = 10;
        int ESPACIO_Y = 15;
        int OFFSET_X = 50;
        int OFFSET_Y = 100;

        // Define las filas y el número de asientos por fila
        String[] filas = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };
        int[] asientosPorFila = { 9, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11, 11, 13 };

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < asientosPorFila[i]; j++) {

                // Cálculo de Coordenadas
                int x = OFFSET_X + j * (T_SILLA + ESPACIO_X);
                int y = OFFSET_Y + i * (T_SILLA + ESPACIO_Y);

                // Creación y Configuración del Botón
                JButton silla = new JButton(); // ¡Ya no necesita texto!
                silla.setName(filas[i] + (j + 1));
                silla.setBounds(x, y, T_SILLA, T_SILLA);
                silla.setBackground(Color.WHITE);
                silla.setIcon(Utilities.BASE_ICON_SEAT_PATH);
                silla.addActionListener(listener);
                silla.setActionCommand("SELECTED_SEAT");

                // Agregar el Listener para el Clic
                // silla.addActionListener(e -> alternarSeleccion(silla, ICONO_SILLA_BASE,
                // ICONO_SILLA_SELECCIONADA));

                add(silla);
            }
        }
    }

    public void alternarSeleccion(JButton silla) {
        if (silla.getIcon().equals(ICONO_SILLA_BASE) && seatState != null) {
            silla.setIcon(ICONO_SILLA_SELECCIONADA);
            sillasSeleccionadas.add(silla.getName());
            seatState.actualizarSillasSeleccionadas(sillasSeleccionadas);
        } else {
            silla.setIcon(ICONO_SILLA_BASE);
            sillasSeleccionadas.remove(silla.getName());
        }

        System.out.println("Sillas seleccionadas: " + sillasSeleccionadas);
    }

    // public void alternarSeleccion(JButton silla, Icon baseIcon, Icon seleccionadoIcon) {
    //     if (silla.getIcon().equals(baseIcon)) {
    //         Estado base -> Cambiar a seleccionado
    //         silla.setIcon(seleccionadoIcon);
    //         Opcional: podrías cambiar el ToolTipText para indicar el estado
    //         silla.setToolTipText("Asiento Seleccionado");
    //         String nombre = silla.getName();
    //         if (silla.getIcon().equals(ICONO_SILLA_BASE)) {
    //             silla.setIcon(ICONO_SILLA_SELECCIONADA);
    //             sillasSeleccionadas.add(nombre);
    //         } else {
    //             Estado seleccionado -> Cambiar a base
    //             silla.setIcon(baseIcon);
    //             silla.setToolTipText("Asiento Disponible");
    //             silla.setIcon(ICONO_SILLA_BASE);
    //             sillasSeleccionadas.remove(nombre);
    //         }
    //         Actualizar en SeatState
    //         if (seatState != null) {
    //             seatState.actualizarSillasSeleccionadas(sillasSeleccionadas);
    //         }
    //         System.out.println("Silla " + silla.getName() + " estado cambiado.");

    //         System.out.println("Sillas seleccionadas: " + sillasSeleccionadas);
    //     }
    // }

    public Set<String> getSillasSeleccionadas() {
        return sillasSeleccionadas;
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         JFrame frame = new JFrame("Demo Cineverso");
    //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         frame.setSize(1024, 768);
    //         frame.setLocationRelativeTo(null);

    //         // Creamos un ActionListener de prueba
    //         ActionListener listener = e -> {
    //             JButton clickedSeat = (JButton) e.getSource();
    //             System.out.println("Asiento presionado: " + clickedSeat.getName());
    //         };

    //         // Agregamos el panel de asientos con el listener
    //         frame.add(new PanelAsientos(listener));

    //         frame.setVisible(true);
    //     });
    // }

}
