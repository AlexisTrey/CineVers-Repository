/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import models.Room;

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
    private List<Seat> selectSeats;
    private LocalDateTime reservationDate;
    private boolean status;
    private double price;
    private Room roomReservation;


	public Reservation(String id, User user, Function function, List<Seat> seats, LocalDateTime reservationDate,
            boolean status, double price, Room roomReservation) {
        this.id = id;
        this.user = user;
        this.function = function;
        this.selectSeats = new ArrayList<>();
        this.reservationDate = reservationDate;
        this.status = status;
        this.price = price;
        this.roomReservation= roomReservation;
    }

    public boolean maxSeats(int numberSeats, String[] seatsSelects) {
        boolean reserv = false;
        if (numberSeats == seatsSelects.length) {
            reserv = true;
        }
        return reserv;
    }

    //metodo que devuelve la lista de asientos seleccionados




    public Reservation() {
        this.selectSeats = new ArrayList<>();
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

    public List<Seat> getSelectSeats() {
        return selectSeats;
    }

    public void setSelectSeats(List<Seat> seats) {
        this.selectSeats = seats;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public void addSeat(Seat seat) {
        selectSeats.add(seat);
    }

    public void removeSeat(Seat seat) {
        selectSeats.remove(seat);
    }

    public double getTotalPrice() {
        return price * selectSeats.size();
    }

    
    public Room getRoomReservation() {
		return roomReservation;
	}

	public void setRoomReservation(Room rommReservation) {
		this.roomReservation = rommReservation;
	}


    public String getReservationDetails() {
        return "Reserva: " + id + " | Usuario: " + user.getFullName()
                + " | Función: " + function.getMovie().getTitle()
                + " | Asientos: " + selectSeats.size()
                + " | Total: $" + getTotalPrice();
    }
}
