/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

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
    private Seat[][] seats;

    public Room(String id, String name, int capacity, String type, Seat[][] seats) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.seats = seats;
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
    public Seat[][] getSeats() {
        return seats;
    }
    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }
    
    public int getAvailableSeats() {
        int count = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.isAvailable()) count++;
            }
        }
        return count;
    }
    public Seat findSeat(int row, int number) {
    for (Seat[] fila : seats) {
        for (Seat seat : fila) {
            if (seat.getRow() == row && seat.getNumber() == number) {
                return seat;
            }
        }
    }
    return null; 
}

public boolean reserveSeat(int row, int number) {
    Seat seat = findSeat(row, number);
    if (seat != null && seat.isAvailable()) {
        seat.reserve();
        return true;
    }
    return false;
}

public void showSeatMap() {
    for (Seat[] fila : seats) {
        for (Seat seat : fila) {
            System.out.print(seat.isAvailable() ? "[L]" : "[X]");
        }
        System.out.println(); 
    }
}


    @Override
    public String toString() {
        return "Sala: " + name + " (" + type + ") - Capacidad: " + capacity;
    }
    
}

