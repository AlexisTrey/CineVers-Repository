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

    private Header header;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private Footer footer;
    private JPanel scrollContainer;
    private JScrollPane scrollPane;

    public static final String HOME = "home";
    public static final String EDIT_ROOMS = "editRooms";
    public static final String EDIT_BILLBOARD = "editBillboard";
    public static final String EDIT_FUNCTIONS = "editFunctions";
    public static final String SELECT_CITY = "selectCity";
    public static final String LOGIN = "login";

   public MainPanel(ActionListener listener) {
    setLayout(new BorderLayout());
    header = new Header(listener);
    footer = new Footer();

    scrollContainer = new JPanel();
    scrollContainer.setLayout(new BoxLayout(scrollContainer, BoxLayout.Y_AXIS));

    cardLayout = new CardLayout();
    contentPanel = new JPanel(cardLayout);

    // Crear el listener para manejar el evento del SelectCityView
    ActionListener internalListener = e -> {
        if ("goHome".equals(e.getActionCommand())) {
            showPanel(HOME);
        }
    };

    // Agregar vistas
    contentPanel.add(new HomePanel(), HOME);
    contentPanel.add(new RoomEditionPanel(listener), EDIT_ROOMS);
    contentPanel.add(new BillboardEditionPanel(listener), EDIT_BILLBOARD);
    contentPanel.add(new FunctionsEditionPanel(listener), EDIT_FUNCTIONS);

    // Pasar el listener correcto al SelectCityView
    SelectCityView selectCityView = new SelectCityView(internalListener);
    contentPanel.add(selectCityView, SELECT_CITY);

    LoginView loginView = new LoginView();
    contentPanel.add(loginView, LOGIN);

    // Scroll y estructura
    scrollContainer.add(contentPanel);
    scrollContainer.add(footer);

    scrollPane = new JScrollPane(scrollContainer);
    scrollPane.setBorder(null);
    scrollPane.getVerticalScrollBar().setUnitIncrement(20);

    add(header, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);

    // Mostrar inicialmente la vista de selección de ciudad
    cardLayout.show(contentPanel, SELECT_CITY);
}

   public void showPanel(String panelName) {
    cardLayout.show(contentPanel, panelName);

    boolean esVistaSimple = panelName.equals(SELECT_CITY) || panelName.equals(LOGIN);

 
    removeAll();
    add(header, BorderLayout.NORTH);

    if (esVistaSimple) {
    add(contentPanel, BorderLayout.CENTER);
    } else {
 
        scrollContainer.removeAll();
        scrollContainer.add(contentPanel);
        scrollContainer.add(footer);
        add(scrollPane, BorderLayout.CENTER);
    }

    revalidate();
    repaint();
}

}

