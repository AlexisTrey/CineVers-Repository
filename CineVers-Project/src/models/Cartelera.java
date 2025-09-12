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
public class Cartelera {
    private String id;
    private City city;
    private List<Function> functions;

    public Cartelera(String id, City city, List<Function> functions) {
        this.id = id;
        this.city = city;
        this.functions = functions;
    }
    public Cartelera() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public List<Function> getFunctions() {
        return functions;
    }
    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }
    
    public void addFunction(Function function) {
        functions.add(function);
    }

    public void removeFunction(Function function) {
        functions.remove(function);
    }

    public List<Function> searchByMovie(String title) {
        List<Function> result = new ArrayList<>();
        for (Function f : functions) {
            if (f.getMovie().getTitle().equalsIgnoreCase(title)) {
                result.add(f);
            }
        }
        return result;
    }
    
    public List<Function> searchByDate(String date){
            List<Function> result = new ArrayList<>();
            for (Function f : functions) {
                if (f.getDateTime().equals(date)) {
                    result.add(f);
                }
            }
            return result;
    }
    
    public List <Movie> getMovies(){
                  List<Movie> result = new ArrayList<>();
                  for (Function f : functions) {
                      //tiene que devolver solo las peliculas que estan en cartelera, sin importar la cantidad de funciones que tengan 
                        if (!result.contains(f.getMovie())) {
                            result.add(f.getMovie());
                        }
                  }
                  return result;
    }
    
    public int countFunctionByMovie(String title){
        int count = 0;
        for (Function f : functions) {
                   if (f.getMovie().getTitle().equalsIgnoreCase(title)) {
                           count ++;
                   }
        }
        return  count;
    }

    @Override
    public String toString() {
        return "Cartelera en " + city.getName() + " con " + functions.size() + " funciones.";
    }
    
}
