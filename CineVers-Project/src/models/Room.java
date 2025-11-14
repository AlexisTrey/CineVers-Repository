/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Room {

    private String id;
    private String name;
    private int capacity;
    private String type; // Ej: 2D, 3D, IMAX
    private List<Seat> allSeats;




    public Room(String id, String name, int capacity, String type, List<Seat> seats) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.allSeats = seats;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public List<Seat> getAllSeats() {
        return allSeats;
    }
    public void setAllSeats(List<Seat> seats) {
        this.allSeats = seats;
    }
    public void updateSeats(List<Seat> seatsToUpdate) {
    for (Seat updatedSeat : seatsToUpdate) {
        for (Seat seat : this.allSeats) {
            if (seat.getId().equals(updatedSeat.getId())) {
                seat.setAvailable(updatedSeat.isAvailable()); // Si manejas tipo de silla
                break;
            }
        }
    }
}

    public int getAvailableSeats() {
        int count = 0;
        for (Seat seat : allSeats) {
                if (seat.isAvailable()) {
                    count++;
                }
        }
        return count;
    }

    public Seat findSeat(String row, int number) {
        for (Seat seat : allSeats) {
                if (seat.getRow().equalsIgnoreCase(row) && seat.getNumber() == number) {
                    return seat;
                }
        }
        return null;
    }


    public void showSeatMap() {
    //Mostrar las filas ordenadas por letra 
    char currentRow = 0;

    for (Seat seat : allSeats) {
        // Si cambiamos de fila 
        if (seat.getRow().charAt(0) != currentRow) {
            if (currentRow != 0) { // salto de línea menos en la primera fila
                System.out.println();
            }
            // Actualizar fila actual y mostrar la letra
            currentRow = seat.getRow().charAt(0);
            System.out.print(currentRow + " ");
        }
        // Mostrar el asiento: [L] = libre, [X] = ocupado
        System.out.print(seat.isAvailable() ? "[L]" : "[X]");
    }
    System.out.println();  // Salto de línea final al terminar el mapa
    } 

    @Override
    public String toString() {
        return "Sala: " + name + " (" + type + ") - Capacidad: " + capacity;
    }

    public static List<Seat> generate(int capacity) {
        List<Seat> allSeats = new ArrayList<>();
        int count = 0; // Contador de sillas creadas

        for (int i = 0; i < Utilities.FILAS_ASIENTOS.length && count < capacity; i++) {
            String row = Utilities.FILAS_ASIENTOS[i];
            // Asegura que no se exceda la capacidad ni el tamaño máximo de la fila
            int seatsInRow = Math.min(Utilities.ASIENTOS_POR_FILA[i], capacity - count);

            for (int j = 0; j < seatsInRow; j++) {
                int number = j + 1;
                // Inicialmente, todas las sillas generadas están DISPONIBLES (available = true)
                Seat seat = new Seat(row, number, true); 
                allSeats.add(seat);
                count++;
            }
        }
        return allSeats;
    }

}
