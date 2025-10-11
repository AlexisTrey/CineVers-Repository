package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
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
    public static final String REGISTER="register";
  
    public MainPanel(ActionListener listener) {
    setLayout(new BorderLayout());
    
    ActionListener mainListener = e -> {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "HOME":
                showPanel(HOME);
                break;
            case "ACCOUNT":
                showPanel(LOGIN);
                break;
            case "UPCOMING":
                System.out.println("Próximos estrenos - aún no implementado");
                break;
            case "ABRIR_REGISTRO":
                showPanel(REGISTER);
                break;
            default:
                System.out.println("Comando no reconocido: " + cmd);
        }
    };
    header = new Header(listener);
    footer = new Footer();

    scrollContainer = new JPanel();
    scrollContainer.setLayout(new BoxLayout(scrollContainer, BoxLayout.Y_AXIS));

    cardLayout = new CardLayout();
    contentPanel = new JPanel(cardLayout);
   
    ActionListener internalListener = e -> {
        if ("goHome".equals(e.getActionCommand())) {
            showPanel(HOME);
        }
    };


    contentPanel.add(new HomePanel(), HOME);
    contentPanel.add(new RoomEditionPanel(listener), EDIT_ROOMS);
    contentPanel.add(new BillboardEditionPanel(listener), EDIT_BILLBOARD);
    contentPanel.add(new FunctionsEditionPanel(listener), EDIT_FUNCTIONS);

    
    SelectCityView selectCityView = new SelectCityView(internalListener);
    contentPanel.add(selectCityView, SELECT_CITY);

    LoginView loginView = new LoginView(mainListener);
    contentPanel.add(loginView, LOGIN);
 RegisterView registerView = new RegisterView(mainListener);
    contentPanel.add(registerView, REGISTER);
    scrollContainer.add(contentPanel);
    scrollContainer.add(footer);

    scrollPane = new JScrollPane(scrollContainer);
    scrollPane.setBorder(null);
    scrollPane.getVerticalScrollBar().setUnitIncrement(20);

    add(header, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);  

    header = new Header(mainListener);
    footer = new Footer();
    header.btnAccountListener();
        header.btnBillboardListener();
        header.btnUpcomingReleasesListener();
    
    cardLayout.show(contentPanel, SELECT_CITY);
}

public void showPanel(String panelName) {
    cardLayout.show(contentPanel, panelName);

    removeAll();
    add(header, BorderLayout.NORTH);

    if (panelName.equals(SELECT_CITY) || panelName.equals(LOGIN)) {
        
        add(contentPanel, BorderLayout.CENTER);

    } else {
        
        scrollContainer.removeAll();
        scrollContainer.add(contentPanel);
        scrollContainer.add(footer);

        if (panelName.equals(REGISTER)) {
           
            scrollPane.setPreferredSize(new Dimension(0, 700)); 
            scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        } else {
            scrollPane.setPreferredSize(null); 
            scrollPane.getVerticalScrollBar().setUnitIncrement(25);
        }

        add(scrollPane, BorderLayout.CENTER);
    }

    revalidate();
    repaint();
}



}

