/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Function {
    private String id;
    private Movie movie;
    private Room room;
    private LocalDateTime dateTime;
    private double price;

    public Function(String id, Movie movie, Room room, LocalDateTime dateTime, double price) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.dateTime = dateTime;
        this.price = price;
    }

    public Function() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Room getRoom() {
        return room;
    }    
    public void setRoom(Room room) {
        this.room = room;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Función: " + movie.getTitle() + " en sala " + room.getName() +
                " | Fecha: " + dateTime + " | Precio: $" + price;
    }
   
}
