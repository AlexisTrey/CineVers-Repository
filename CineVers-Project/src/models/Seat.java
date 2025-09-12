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
public class Seat {
    private String id;
    private int row;
    private int number;
    private boolean available;

    public Seat(String id, int row, int number, boolean available) {
        this.id = id;
        this.row = row;
        this.number = number;
        this.available = available;
    }

    public Seat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void reserve() { 
        this.available = false; 
    }
    
    public void release() {
        this.available = true; 
    }

    @Override
    public String toString() {
        return "Fila " + row + " Asiento " + number + (available ? " [Disponible]" : " [Ocupado]");
    }
        
}
