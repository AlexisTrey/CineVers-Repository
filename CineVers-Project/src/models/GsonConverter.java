/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken; // ¡Nueva importación clave!
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jhonnyd
 */
public class GsonConverter {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


public static <T> void saveListToJson(List<T> list, String filePath) {
    
    // --- NUEVO CÓDIGO CLAVE PARA GESTIONAR LA RUTA ---
    File file = new File(filePath);
    File parentDir = file.getParentFile();
    
    if (parentDir != null && !parentDir.exists()) {
        // Crea las carpetas necesarias (persistence/) si no existen.
        if (parentDir.mkdirs()) { 
            System.out.println("Carpeta creada: " + parentDir.getAbsolutePath());
        } else {
            System.err.println("❌ Error: No se pudo crear la carpeta: " + parentDir.getAbsolutePath());
            return; // Detiene el guardado si falla la creación de la carpeta
        }
    }
    // ----------------------------------------------------

    try (FileWriter writer = new FileWriter(file)) {
        gson.toJson(list, writer);
        System.out.println("✅ Lista guardada en: " + filePath);
    } catch (IOException e) {
        // Este error solo ocurriría si el nombre del archivo es inválido o hay permisos.
        System.err.println("❌ Error al guardar la lista JSON: " + e.getMessage());
    }
}


    public static List<Movie> loadPeliculas(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            
            // Define el TIPO de dato que esperas leer. Esto es crucial para Listas genéricas.
            Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
            
            // Convierte el JSON de vuelta a la lista
            List<Movie> peliculas = gson.fromJson(reader, listType);
            
            // Si el archivo no existe o está vacío, devuelve una lista vacía
            return peliculas != null ? peliculas : new ArrayList<>();
            
        } catch (IOException e) {
            System.out.println("Archivo no encontrado o vacío. Inicializando con lista vacía.");
            return new ArrayList<>(); // Devuelve una lista vacía para que la aplicación no falle.
        }
    }
    
}
