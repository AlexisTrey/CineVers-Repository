/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/*
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Seat {
    private String id;
    private String row;
    private int number;
    private boolean available;

    public Seat( String row, int number, boolean available) {
        this.id = row + number;
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
    public String getRow() {
        return row;
    }
    // public void setRow(int row) {
    //     if (row < 0) throw new IllegalArgumentException("Row cannot be negative");
    //     this.row = row;
    // }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        if (number < 0) throw new IllegalArgumentException("Number cannot be negative");
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

    public void free() {
        this.available = true;
    }

    public String getSeatInfo() {
        return "Fila " + row + " - Asiento " + number;
    }

    @Override
     public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", row=" + row +
                ", number=" + number +
                ", available=" + available +
                '}';
    }
}
