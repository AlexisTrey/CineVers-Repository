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
public class Movie {

    private String id;
    private String title;
    private String genre;
    private int durationMinutes;
    private String classification; // Ej: A, B, C, +12, +18
//    private String director;
    private String synopsis;
//    private String language;
    private String releaseDate;
//    private Boolean incart; // si esta cartelera o no 

    public Movie(String URL, String title, String genre, int durationMinutes, String classification, String synopsis, String date) {
        this.id = URL;
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
        this.classification = classification;
//        this.director = director;
        this.synopsis = synopsis;
//        this.language = language;
        this.releaseDate = date;
//        this.incart = incarte;
    }

    public Movie() {
    }

//    public LocalDateTime getReleaseDate() {
//        return releaseDate;
//    }
//    public void setReleaseDate(LocalDateTime releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//    public Boolean getIncart() {
//        return incart;
//    }
//    public void setIncart(Boolean incart) {
//        this.incart = incart;
//    }
//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
//    public String getDirector() {
//        return director;
//    }
//    public void setDirector(String director) {
//        this.director = director;
//    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
//    public String getLanguage() {
//        return language;
//    }
//    public void setLanguage(String language) {
//        this.language = language;
//    }

    public String getMovieInfo() {
        return title + " (" + genre + ") - " + durationMinutes + " min - Clasificación: " + classification;
    }

    @Override
    public String toString() {
        return getMovieInfo();
    }
}
