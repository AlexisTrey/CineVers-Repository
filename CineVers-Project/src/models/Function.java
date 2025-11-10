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
    private String dateTime;

    public Function(String id, Movie movie, Room room, String dateTime) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.dateTime = dateTime;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getAvailableSeats() {
        return room.getAvailableSeats();
    }
 //Cambiar para que funcione ahora con una lista de sillas, porque se cambió en Room
//    public boolean reserveSeat(int row, int number) {
//        Seat[][] seats = room.getAllSeats();
//        if (row >= 0 && row < seats.length && number >= 0 && number < seats[row].length) {
//            Seat seat = seats[row][number];
//            if (seat.isAvailable()) {
//                seat.reserve();
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public String toString() {
        return "Función: " + movie.getTitle() + " en sala "
                + " | Fecha: " + dateTime;
    }

}
