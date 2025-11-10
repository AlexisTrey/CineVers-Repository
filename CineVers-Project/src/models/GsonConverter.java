/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meloc
 */
public class GsonConverter {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static <T> void saveListToJson(List<T> list, String filePath) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                throw new IOException("No se pudo crear el directorio: " + parentDir.getAbsolutePath());
            }
        }

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(list, writer);
        }
    }

    public static <T> List<T> loadListFromJson(String filePath, Type typeToken) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            List<T> list = gson.fromJson(reader, typeToken);
            return list != null ? list : new ArrayList<>();
        }
    }

    public static List<Movie> loadPeliculas(String filePath) {
        try {
            Type listType = new TypeToken<ArrayList<Movie>>() {
            }.getType();

            return loadListFromJson(filePath, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static List<User> loadUsers(String filePath) {
        try {
            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            return loadListFromJson(filePath, listType);
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Function> loadFunctions(String filePath) {
        // ... (Tu método loadFunctions usando la instancia 'gson') ...
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Function>>() {
            }.getType();
            List<Function> functions = gson.fromJson(reader, listType); // Usa la instancia configurada
            return functions != null ? functions : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Room> loadRooms(String filePath) {
        try {
            Type listType = new TypeToken<ArrayList<Room>>() {
            }.getType();
            return loadListFromJson(filePath, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void saveFunctions(List<Function> list, String filePath) {
        try {
            saveListToJson(list, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRooms(List<Room> list, String filePath) {
        try {
            saveListToJson(list, filePath);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static List<Reservation> loadReservations(String filePath) {
        try {
            Type listType = new TypeToken<ArrayList<Reservation>>() {
            }.getType();
            return loadListFromJson(filePath, listType);
        } catch (IOException e) {
            System.out.println("Error al cargar reservaciones: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    

    public static void saveReservations(List<Reservation> list, String filePath) {
        try {
            saveListToJson(list, filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar reservaciones: " + e.getMessage());
        }
    }
}
