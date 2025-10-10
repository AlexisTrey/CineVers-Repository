/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jhonnyd
 */
public class PanelAsientos extends JPanel{
        Icon ICONO_SILLA_BASE = new ImageIcon("/resources/images/silladesocupada.jpg"); 
    
    // Si usas íconos diferentes para el estado seleccionado y base
        Icon ICONO_SILLA_SELECCIONADA = new ImageIcon("/resources/images/sillaocupada.jpg");
    
        public PanelAsientos() {
        // Establecer el diseño a null (absolute positioning)
        setLayout(null); 
        
        // Opcional: Establecer un tamaño para el panel
        setPreferredSize(new Dimension(800, 1000)); 
        
        // Agregar las sillas
        generarAsientos();
    }
        
    private void generarAsientos() {
        int T_SILLA = 40;
        int ESPACIO_X = 10;
        int ESPACIO_Y = 15;
        int OFFSET_X = 50;
        int OFFSET_Y = 100;
        
        // Define las filas y el número de asientos por fila
        String[] filas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
        int[] asientosPorFila = {9, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11, 11, 13}; 

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < asientosPorFila[i]; j++) { 

                //  Cálculo de Coordenadas
                int x = OFFSET_X + j * (T_SILLA + ESPACIO_X);
                int y = OFFSET_Y + i * (T_SILLA + ESPACIO_Y);

                //  Creación y Configuración del Botón
                JButton silla = new JButton(); // ¡Ya no necesita texto!
                silla.setName(filas[i] + (j + 1)); 
                silla.setBounds(x, y, T_SILLA, T_SILLA); 
                
                silla.setIcon(ICONO_SILLA_BASE);

                // Agregar el Listener para el Clic
                silla.addActionListener(e -> alternarSeleccion(silla, ICONO_SILLA_BASE, ICONO_SILLA_SELECCIONADA));

                add(silla);
            }
        }
    }
    
private void alternarSeleccion(JButton silla, Icon baseIcon, Icon seleccionadoIcon) {
    if (silla.getIcon().equals(baseIcon)) {
        // Estado base -> Cambiar a seleccionado
        silla.setIcon(seleccionadoIcon);
        // Opcional: podrías cambiar el ToolTipText para indicar el estado
        silla.setToolTipText("Asiento Seleccionado");
    } else {
        // Estado seleccionado -> Cambiar a base
        silla.setIcon(baseIcon);
        silla.setToolTipText("Asiento Disponible");
    }
    System.out.println("Silla " + silla.getName() + " estado cambiado.");
}
        public static void main(String[] args) {
        // Asegura que la GUI se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Panel de Asientos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Agregar el panel de asientos
            frame.add(new PanelAsientos());
            
            frame.pack(); // Ajusta el tamaño del marco al tamaño preferido del panel
            frame.setLocationRelativeTo(null); // Centra la ventana
            frame.setVisible(true);
        });
        }
}
