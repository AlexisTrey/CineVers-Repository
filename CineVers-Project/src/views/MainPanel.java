package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

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
    private Background background;

    public static final String HOME = "home";
    public static final String EDIT_ROOMS = "editRooms";
    public static final String EDIT_BILLBOARD = "editBillboard";
    public static final String EDIT_FUNCTIONS = "editFunctions";

    public MainPanel(ActionListener listener) {
        setLayout(new BorderLayout());
        header = new Header(listener);
        //background = new Background();

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Agregación de vistas al CardLayout
        contentPanel.add(new HomePanel(), HOME);
        contentPanel.add(new RoomEditionPanel(), EDIT_ROOMS);
        contentPanel.add(new BillboardEditionPanel(), EDIT_BILLBOARD);
        contentPanel.add(new FunctionsEditionPanel(), EDIT_FUNCTIONS);

        add(header, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        //add(background, BorderLayout.CENTER);
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }
}
