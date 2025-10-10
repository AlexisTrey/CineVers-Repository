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

    public static final String HOME = "home";
    public static final String EDIT_ROOMS = "editRooms";
    public static final String EDIT_BILLBOARD = "editBillboard";
    public static final String EDIT_FUNCTIONS = "editFunctions";
    public static final String MOVIE_DETAILS = "movieDetails";

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
        contentPanel.add(new HomePanel(), HOME);
        contentPanel.add(new RoomEditionPanel(), EDIT_ROOMS);
        contentPanel.add(new BillboardEditionPanel(), EDIT_BILLBOARD);
        contentPanel.add(new FunctionsEditionPanel(), EDIT_FUNCTIONS);

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

        //--- Contenedor central con CardLayout ---
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Paneles de contenido
        Background background = new Background(); 
        MovieDetailsPanel movieDetailsPanel = new MovieDetailsPanel(listener); // nuevo panel

        // Agregamos los paneles con un nombre identificador
        contentPanel.add(background, HOME);
        contentPanel.add(movieDetailsPanel, MOVIE_DETAILS);

        // Añadimos al centro del MainPanel
        add(contentPanel, BorderLayout.CENTER);
    }

}
