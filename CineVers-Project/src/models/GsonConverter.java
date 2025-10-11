/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class GsonConverter {
    private final Gson gson;

    public GsonConverter() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void writeObjectToJson(Object object, String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(object, writer);
        }
    }

    public <T> T readObjectFromJson(String path, Class<T> clazz) throws IOException {
        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, clazz);
        }
    }
}
