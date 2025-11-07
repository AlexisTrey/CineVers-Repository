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
    private HomePanel homePanel;
    private SelectCityView selectCityView;
    private LoginView loginView;
    private RegisterView registerView;
    private MovieDetailsPanel movieDetailsPanel;
    private PanelAsientos panelAsientos;
    private RoomEditionPanel roomEditionPanel;
    private BillboardEditionPanel billboardEditionPanel;
    private FunctionsEditionPanel functionsEditionPanel;
    private AddRoomPanel addRoomPanel;
    private AddMovieBillboard addMovieBillboard;
    private AddFuctionPanel addFuctionPanel;

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

        selectCityView = new SelectCityView(listener);
        homePanel = new HomePanel(listener);
        loginView = new LoginView(listener);
        registerView = new RegisterView(listener);
        movieDetailsPanel = new MovieDetailsPanel(listener);
        panelAsientos = new PanelAsientos(listener);
        roomEditionPanel = new RoomEditionPanel(listener);
        billboardEditionPanel = new BillboardEditionPanel(listener);
        functionsEditionPanel = new FunctionsEditionPanel(listener);
        addRoomPanel = new AddRoomPanel(listener);
        addMovieBillboard = new AddMovieBillboard(listener);
        addFuctionPanel = new AddFuctionPanel(listener);
        
        contentPanel.add(selectCityView, SELECT_CITY);
        contentPanel.add(homePanel, HOME);
        contentPanel.add(loginView, LOGIN);
        contentPanel.add(registerView, REGISTER);
        contentPanel.add(movieDetailsPanel, MOVIE_DETAILS);
        contentPanel.add(panelAsientos, SELECT_SEATS);
        contentPanel.add(roomEditionPanel, EDIT_ROOMS);
        contentPanel.add(billboardEditionPanel, EDIT_BILLBOARD);
        contentPanel.add(functionsEditionPanel, EDIT_FUNCTIONS);
        contentPanel.add(addRoomPanel, ADD_ROOM);
        contentPanel.add(addMovieBillboard, ADD_BILLBOARD);
        contentPanel.add(addFuctionPanel, ADD_FUNCTION); // Agregado

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

    public HomePanel getHomePanel() {
        return homePanel;
    }
    
    
    public AddMovieBillboard getAddMovieBillboard() {
        return addMovieBillboard;
    }
    
        public AddFuctionPanel getAddFuctionPanel() {
        return addFuctionPanel;
    }
}
