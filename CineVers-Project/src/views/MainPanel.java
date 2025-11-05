package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class MainPanel extends JPanel {

    private ActionListener listener;

    private Header header;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private Background background;
    private Footer footer;
    private JPanel scrollContainer;

    public static final String SELECT_CITY = "select_city";
    public static final String HOME = "home";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    public static final String MOVIE_DETAILS = "movie_details";
    public static final String SELECT_SEATS = "select_seats";
    public static final String CONFIRM_RESERVATION = "confirm_reservation";
    public static final String EDIT_ROOMS = "edit_rooms";
    public static final String EDIT_BILLBOARD = "edit_billboard";
    public static final String EDIT_FUNCTIONS = "edit_functions";
    public static final String ADD_ROOM = "add_room";
    public static final String ADD_BILLBOARD = "add_billboard";
    public static final String ADD_FUNCTION = "add_function";

    public MainPanel(ActionListener listener) {
        setLayout(new BorderLayout());
        this.listener = listener;
        
        header = new Header(listener);
        footer = new Footer();
        //background = new Background();

        scrollContainer = new JPanel();
        scrollContainer.setLayout(new BoxLayout(scrollContainer, BoxLayout.Y_AXIS));

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Agregación de vistas al CardLayout
        contentPanel.add(new SelectCityView(listener), SELECT_CITY);
        contentPanel.add(new HomePanel(listener), HOME);
        contentPanel.add(new LoginView(listener), LOGIN);
        contentPanel.add(new RegisterView(listener), REGISTER);
        contentPanel.add(new MovieDetailsPanel(listener), MOVIE_DETAILS);
        contentPanel.add(new PanelAsientos(listener), SELECT_SEATS);
        contentPanel.add(new RoomEditionPanel(listener), EDIT_ROOMS);
        contentPanel.add(new BillboardEditionPanel(listener), EDIT_BILLBOARD);
        contentPanel.add(new FunctionsEditionPanel(listener), EDIT_FUNCTIONS);
        contentPanel.add(new AddRoomPanel(listener), ADD_ROOM);
        contentPanel.add(new AddMovieBillboard(listener), ADD_BILLBOARD);
        contentPanel.add(new AddFuctionPanel(listener), ADD_FUNCTION);

        scrollContainer.add(contentPanel);
        scrollContainer.add(footer);

        JScrollPane scrollPane = new JScrollPane(scrollContainer);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        add(header, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }

}
