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
public class Reservation {
    private String id;
    private User user;
    private Function function;
    private Seat seat;
    private LocalDateTime reservationDate;
    private boolean status;
    private double price;

    public Reservation(String id, User user, Function function, Seat seat, LocalDateTime reservationDate, boolean status, double price) {
        this.id = id;
        this.user = user;
        this.function = function;
        this.seat = seat;
        this.reservationDate = reservationDate;
        this.status = status; //Confirmada, cancelada
        this.price = price; 
    }

    public Reservation() {
    }
 
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Function getFunction() {
        return function;
    }
    public void setFunction(Function function) {
        this.function = function;
    }
    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean isConfirmed() {
        return status;
    }
    public void setConfirmed(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
    public void confirm() {
    this.status = true;
    }

    public void cancel() {
    this.status = false;
    }


   public String getReservationDetails() {
    return "Reserva " + id +
           " | Usuario: " + (user != null ? user.getName() : "N/A") +
           " | Función: " + (function != null ? function.getMovieTitle() : "N/A") +
           " | Asiento: " + (seat != null ? seat.getSeatInfo() : "N/A") +
           " | Fecha: " + reservationDate +
           " | Estado: " + (status ? "Confirmada" : "Cancelada") +
           " | Precio: $" + price;
}
}
