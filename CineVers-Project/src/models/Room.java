/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;

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
    private double price;
    private List<Seat> allSeats;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Room(String id, String name, int capacity, String type, List<Seat> seats) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.allSeats = seats;
    }

    public Room() {
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

    public boolean reserveSeat(String row, int number) {
        Seat seat = findSeat(row, number);
        if (seat != null && seat.isAvailable()) {
            seat.reserve();
            return true;
        }
        return false;
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

}
