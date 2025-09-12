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
    private boolean paid;

    public Reservation(String id, User user, Function function, Seat seat, LocalDateTime reservationDate, boolean paid) {
        this.id = id;
        this.user = user;
        this.function = function;
        this.seat = seat;
        this.reservationDate = reservationDate;
        this.paid = paid;
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    public void confirmPayment() {
        this.paid = true;
    }

    @Override
    public String toString() {
        return "Reserva #" + id + " | Usuario: " + user.getFullName() +
                " | Película: " + function.getMovie().getTitle() +
                " | Asiento: " + seat.toString() +
                " | Pagada: " + (paid ? "Sí" : "No");
    }
}
