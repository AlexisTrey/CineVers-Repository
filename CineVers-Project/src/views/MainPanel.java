package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
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
    private Footer footer;
    private JPanel contentContainer;
    private JScrollPane scrollPane;

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
    private SelectSeats selectSeats;
    private SeatState seatState;

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
        header.setAdminVisible(false);

        footer = new Footer();
        //background = new Background();

        contentContainer = new JPanel(new BorderLayout());

        scrollPane = new JScrollPane(contentContainer);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        add(header, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        selectCityView = new SelectCityView(listener);
        homePanel = new HomePanel(listener);
        loginView = new LoginView(listener);
        registerView = new RegisterView(listener);
        movieDetailsPanel = new MovieDetailsPanel(listener);
        panelAsientos = new PanelAsientos(listener);
        panelAsientos.setSeatState(seatState);
        SeatState seatState = new SeatState(listener);
        roomEditionPanel = new RoomEditionPanel(listener);
        billboardEditionPanel = new BillboardEditionPanel(listener);
        functionsEditionPanel = new FunctionsEditionPanel(listener);
        addRoomPanel = new AddRoomPanel(listener);
        addMovieBillboard = new AddMovieBillboard(listener);
        addFuctionPanel = new AddFuctionPanel(listener);
        selectSeats = new SelectSeats(listener);

        showPanel(SELECT_CITY);
    }

    public void showPanel(String panelName) {
        contentContainer.removeAll(); // Limpia el contenido anterior

        JPanel newPanel = switch (panelName) {
            case HOME ->
                homePanel;
            case LOGIN ->
                loginView;
            case REGISTER ->
                registerView;
            case SELECT_CITY ->
                selectCityView;
            case MOVIE_DETAILS ->
                movieDetailsPanel;
            case SELECT_SEATS ->
                selectSeats;
            case EDIT_ROOMS ->
                roomEditionPanel;
            case EDIT_BILLBOARD ->
                billboardEditionPanel;
            case EDIT_FUNCTIONS ->
                functionsEditionPanel;
            case ADD_ROOM ->
                addRoomPanel;
            case ADD_BILLBOARD ->
                addMovieBillboard;
            case ADD_FUNCTION ->
                addFuctionPanel;
            default ->
                new JPanel();
        };

        contentContainer.add(newPanel, BorderLayout.CENTER);
        contentContainer.add(footer, BorderLayout.SOUTH);

        contentContainer.revalidate();
        contentContainer.repaint();
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

    public SelectCityView getSelectCityView() {
        return selectCityView;
    }

    public Header getHeader() {
        return header;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public RegisterView getRegisterView() {
        return registerView;
    }

    public FunctionsEditionPanel getFunctionsEditionPanel() {
        return functionsEditionPanel;
    }

}
