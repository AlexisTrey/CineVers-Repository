/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.time.LocalDateTime;

import javax.swing.ImageIcon;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class Utilities {

    // Rutas
    public static final String CHECK_PATH = "/resources/images/check.png";
    public static final String ICON_ROOM_PATH = "/resources/images/IconRoom.png";
    public static final String LOGO_FOOTER_PATH = "/resources/images/LogoFooter.png";
    public static final String INSTAGRAM_PATH = "/resources/images/Instagram.png";
    public static final String TIKTOK_PATH = "/resources/images/TikTok.png";
    public static final String FACEBOOK_PATH = "/resources/images/FaceBook.png";
    public static final String TELEGRAM_PATH = "/resources/images/Telegram.png";
    public static final String PREJUICIO_PATH = "/resources/images/Prejuicio.png";
    public static final String TOGETHER_PATH = "/resources/images/Together.png";
    public static final String VIERNES_PATH = "/resources/images/OtroViernesDeLocos.png";
    public static final String MIRACULOUS_PATH = "/resources/images/Miraculous.png";
    public static final String DEMON_PATH = "/resources/images/DemonSlayer.png";
    public static final String JURASSIC_PATH = "/resources/images/JurassicWorldRebirth.png";
    public static final String POMPOKO_PATH = "/resources/images/Pompoko.png";
    public static final String ZOOTOPIA_PATH = "/resources/images/Zootopia2.png";
    public static final String AVATAR_PATH = "/resources/images/Avatar2.png";
    public static final String MOVIES_PATH = "src/persistence/movies.json";
    public static final String USERS_PATH = "src/persistence/users.json";
    public static final String FUNCTION_PATH = "src/persistence/functions.json";
    public static final String ROOMS_PATH = "src/persistence/rooms.json";
    public static final String RESERVATION_PATH = "src/persistence/reservations.json";
    public static final String BANNER_TOGETHER_PATH = "/resources/images/banner_together.jpg";
    public static final String[] FILAS_ASIENTOS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" }; // Filas de la sala
    public static final int[] ASIENTOS_POR_FILA = { 9, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11, 11, 13 };    // El tamaño de la sala se determina por la suma de las sillas por fila
    public static final String UPCOMING_MOVIES_PATH = "src/persistence/upcomingMovies.json";

    public static final ImageIcon BASE_ICON_SEAT_PATH = new ImageIcon(
            Utilities.class.getResource("/resources/images/silladesocupada.png"));
    public static final ImageIcon SELECTED_ICON_SEAT_PATH = new ImageIcon(
            Utilities.class.getResource("/resources/images/sillaocupada.png"));

    public static String getImageForMovieTitle(String title) {
        if (title == null) return PREJUICIO_PATH;
        title = title.toLowerCase();

        if (title.contains("orgullo")) return PREJUICIO_PATH;
        if (title.contains("zootopia")) return ZOOTOPIA_PATH;
        if (title.contains("demon")) return DEMON_PATH;
        if (title.contains("miraculous")) return MIRACULOUS_PATH;
        if (title.contains("jurassic")) return JURASSIC_PATH;
        if (title.contains("together")) return TOGETHER_PATH;
        if (title.contains("viernes")) return VIERNES_PATH;
        if (title.contains("pompoko")) return POMPOKO_PATH;
        if (title.contains("avatar")) return AVATAR_PATH;

        return PREJUICIO_PATH;
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

}
