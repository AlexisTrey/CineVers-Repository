/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    private List<User> admins;
    private List<Movie> movies;
    private List<Function> functions;
    private List<Reservation> reservations;
    private List<Cartelera> carteleras;
    private List<Room> rooms;
    private GsonConverter gson;
    private City selectedCity;
    private User activeUser;

    public CineVersSystem() {
        gson = new GsonConverter();
        users = new ArrayList<>();
        admins = new ArrayList<>();
        movies = gson.loadPeliculas(Utilities.MOVIES_PATH);
        functions = gson.loadFunctions(Utilities.FUNCTION_PATH);
        rooms = gson.loadRooms(Utilities.ROOMS_PATH);
        reservations = gson.loadReservations(Utilities.RESERVATION_PATH);
        carteleras = new ArrayList<>();

        loadUsers();

    }

    public int createIdReservation() {
        return reservations.size() + 1;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }

    public void logout() {
        this.activeUser = null;
    }

    public Function getFuctionReservation(String name) {
        for (Function f : functions) {
            if (f.getMovie().getTitle().equals(name)) {
                System.out.println("Función encontrada para el nombre: " + name);
                return f;
            }
        }
        System.out.println("Función no encontrada para el nombre: " + name);
        return null;
    }

    public void loadUsers() {
        List<User> allUsers = gson.loadUsers(Utilities.USERS_PATH);
        if (allUsers != null) {
            for (User u : allUsers) {
                if (u.isAdmin()) {
                    admins.add(u);
                } else {
                    users.add(u);
                }
            }
        }
    }

    public List<Seat> filterChairsByName(Set<String> nombresSillas, Room roomReservation) {
        List<Seat> resultado = new ArrayList<>();

        for (Seat seat : roomReservation.getAllSeats()) {
            if (nombresSillas.contains(seat.getId())) {
                resultado.add(seat);
            }
        }

        return resultado;
    }

    public void saveUsers() {
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(admins);
        allUsers.addAll(users);
        try {
            gson.saveListToJson(allUsers, Utilities.USERS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public User findUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        for (User a : admins) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        return null;
    }

    public boolean registerUser(User user) {
        if (findUserByEmail(user.getEmail()) != null) {
            return false;
        }

        if (user.getEmail().toLowerCase().contains("@admin")) {
            user.setAdmin(true);
            admins.add(user);
        } else {
            user.setAdmin(false);
            users.add(user);
        }

        saveUsers();
        return true;
    }

    public User loginUser(String email, String password) {
        User user = findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            if (selectedCity != null) {
                user.setCity(selectedCity);
                saveUsers();

            }
            this.activeUser = user;

            return user;
        }
        return null;
    }

    public boolean deleteUser(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                users.remove(u);
                saveUsers();
                return true;
            }
        }
        for (User a : admins) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                admins.remove(a);
                saveUsers();
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getAdmins() {
        return admins;
    }

    public void setSelectedCity(String cityName) {
        if (cityName != null && !cityName.isEmpty()) {
            String id = "C" + cityName.hashCode();
            this.selectedCity = new City(id, cityName);
        }
    }

    public City getSelectedCity() {
        return selectedCity;
    }

    public void addMovie(User user, Movie movie) throws IOException {

        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede agregar películas.");
            return;
        }
        movies.add(movie);
        try {
            this.gson.saveListToJson(movies, Utilities.MOVIES_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Película agregada: " + movie.getTitle());
    }

    public void removeMovie(User user, Movie movie) throws IOException {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede eliminar películas.");
            return;
        }
        movies.remove(movie);
        gson.saveListToJson(movies, Utilities.MOVIES_PATH);
        System.out.println("Película eliminada: " + movie.getTitle());
    }

    public void deleteMovieById(String id) {
        if (movies == null) {
            return;
        }

        movies.removeIf(m -> m.getId().equals(id));
        try {
            gson.saveListToJson(movies, Utilities.MOVIES_PATH);
            System.out.println("Película eliminada correctamente: " + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addFunction(User user, Function function) throws IOException {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede crear funciones.");
            return;
        }
        functions.add(function);
        gson.saveListToJson(functions, Utilities.FUNCTION_PATH);
        System.out.println("Función agregada: " + function.getMovie().getTitle());
    }

    public void removeFunction(User user, Function function) throws IOException {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede eliminar funciones.");
            return;
        }
        functions.remove(function);
        gson.saveListToJson(functions, Utilities.FUNCTION_PATH);
        System.out.println("Función eliminada correctamente.");
    }

    public void addReservation(User user, Reservation function) throws IOException {
        if (user.isAdmin()) {
            System.out.println("Solo un administrador puede crear funciones.");
            return;
        }
        reservations.add(function);
        gson.saveListToJson(functions, Utilities.RESERVATION_PATH);
        System.out.println("Reservcion agregada con exito ");
    }

    public void removeReservation(User user, Reservation function) throws IOException {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede eliminar funciones.");
            return;
        }
        reservations.remove(function);
        gson.saveListToJson(functions, Utilities.RESERVATION_PATH);
        System.out.println("reserva eliminada correctamente.");
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void addRoom(User user, Room room) throws IOException {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede crear salas.");
            return;
        }
        rooms.add(room);
        gson.saveListToJson(rooms, Utilities.ROOMS_PATH);
        System.out.println("Sala agregada: " + room.getName());
    }

    public void removeRoom(User user, Room room) throws IOException {
        if (!user.isAdmin()) {
            System.out.println("Solo un administrador puede eliminar salas.");
            return;
        }
        rooms.remove(room);
        gson.saveListToJson(rooms, Utilities.ROOMS_PATH);
        System.out.println("Sala eliminada: " + room.getName());
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // public void addReservation(User user, Reservation reservation) {
    // reservations.add(reservation);
    // System.out.println("Reserva creada para " + user.getFullName());
    // }

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

    public Movie searchMovieByTitle(String name) {
        Movie movieretur = new Movie();
        for (Movie m : this.movies) {
            if (m.getTitle().equalsIgnoreCase(name)) {
                movieretur = m;
            }
        }
        return movieretur;
    }

    public String[] getMovieTitlesArray() {

        // 1. Verificar si la lista está vacía o es nula
        if (this.movies == null || this.movies.isEmpty()) {
            // Devuelve un array con solo el placeholder si no hay películas
            return new String[] { "-- Sin Películas Disponibles --" };
        }

        // 2. Crear una lista temporal para recopilar los títulos (más fácil que un
        // array fijo)
        List<String> titlesList = new ArrayList<>();

        // 3. Añadir el placeholder como primer elemento
        titlesList.add("-- Seleccione una Película --");

        // 4. Extraer los títulos de las películas
        for (Movie movie : this.movies) {
            titlesList.add(movie.getTitle());
        }

        // 5. Convertir la List<String> a un vector String[]
        // El método toArray(new String[0]) es el estándar para esto.
        return titlesList.toArray(new String[0]);
    }

    public List<Seat> findRoomByName(String roomName) {
        // 1. Validaciones iniciales
        if (rooms == null || roomName == null) {
            // Devuelve una lista vacía en lugar de null para evitar NullPointerExceptions
            return Collections.emptyList();
        }

        // 2. Limpiamos y normalizamos el nombre de búsqueda
        String normalizedSearchName = roomName.trim().toLowerCase();

        // 3. Iteramos sobre la lista de salas (sin usar Streams)
        for (Room room : rooms) {

            // 4. Limpiamos y normalizamos el nombre de la sala actual para la comparación
            String currentRoomName = room.getName().trim().toLowerCase();

            // 5. Comparamos los nombres
            if (currentRoomName.equals(normalizedSearchName)) {
                // 6. ¡Coincidencia encontrada! Devolvemos la lista de asientos de esa sala.
                return room.getAllSeats();
            }
        }

        // 7. Si el bucle termina sin encontrar la sala, devolvemos una lista vacía.
        return Collections.emptyList();
    }

    public void refreshMovies() {
        this.movies = gson.loadPeliculas(Utilities.MOVIES_PATH);
    }

    public void refreshFunctions() {
        this.functions = gson.loadFunctions(Utilities.FUNCTION_PATH);
    }

    public void refreshRooms() {
        this.rooms = gson.loadRooms(Utilities.ROOMS_PATH);
    }

    public GsonConverter getGson() {
        return gson;
    }

    public void setGson(GsonConverter gson) {
        this.gson = gson;
    }

}
