/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class CineVersSystem {
    private List<User> users;
    private List<Admin> admins;
    private List<Movie> movies;
    private List<Function> functions;
    private List<Reservation> reservations;
    private List<Cartelera> carteleras;

    public CineVersSystem() {
        users = new ArrayList<>();
        admins = new ArrayList<>();
        movies = new ArrayList<>();
        functions = new ArrayList<>();
        reservations = new ArrayList<>();
        carteleras = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addFunction(Function function) {
        functions.add(function);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void addCartelera(Cartelera cartelera) {
        carteleras.add(cartelera);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public List<Cartelera> getCarteleras() {
        return carteleras;
    }

    public List<Function> searchFunctionsByCity(String cityName) {
        List<Function> result = new ArrayList<>();
        for (Cartelera c : carteleras) {
            if (c.getCity().getName().equalsIgnoreCase(cityName)) {
                result.addAll(c.getFunctions());
            }
        }
        return result;
    }
}
