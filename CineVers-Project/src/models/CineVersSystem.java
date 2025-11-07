/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;
import utilities.Utilities;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class CineVersSystem {

    private List<User> users;
    private List<Movie> movies;
    private List<Function> functions;
    private List<Reservation> reservations;
    private List<Cartelera> carteleras;
    private GsonConverter gson;

    public CineVersSystem() {
        users = new ArrayList<>();
        movies = gson.loadPeliculas(Utilities.MOVIES_PATH);
        functions = new ArrayList<>();
        reservations = new ArrayList<>();
        carteleras = new ArrayList<>();
        System.out.println("se cargaron con exito");
    }

    //Acciones de Usuarios
    public void addUser(User user) {
        users.add(user);
    }
    public void setMovies(List<Movie> movies){
        this.movies=movies;
    }
    public User findUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean login(String email, String password) {
        User user = findUserByEmail(email);
        return user != null && user.login(email, password);
    }

    //Acciones de Administrador
    public void addMovie(User user, Movie movie) {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede agregar películas.");
            return;
        }
        movies.add(movie);
        this.gson.saveListToJson(movies, Utilities.MOVIES_PATH);
        System.out.println("Película agregada: " + movie.getTitle());
    }

    public void removeMovie(User user, Movie movie) {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede eliminar películas.");
            return;
        }
        movies.remove(movie);
        System.out.println("Película eliminada: " + movie.getTitle());
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addFunction(User user, Function function) {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede crear funciones.");
            return;
        }
        functions.add(function);
        System.out.println("Función agregada: " + function.getMovie().getTitle());
    }

    public void removeFunction(User user, Function function) {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede eliminar funciones.");
            return;
        }
        functions.remove(function);
        System.out.println("Función eliminada.");
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void addReservation(User user, Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reserva creada para " + user.getFullName());
    }

    public void cancelReservation(User user, String reservationId) {
        for (Reservation r : reservations) {
            if (r.getId().equals(reservationId)) {
                r.cancel();
                System.out.println("Reserva cancelada correctamente por " + user.getFullName());
                return;
            }
        }
        System.out.println("No se encontró la reserva con ID: " + reservationId);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addCartelera(User user, Cartelera cartelera) {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede crear carteleras.");
            return;
        }
        carteleras.add(cartelera);
        System.out.println("Cartelera agregada para la ciudad: " + cartelera.getCity().getName());
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

    public List<Movie> searchMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                result.add(m);
            }
        }
        return result;
    }

}
