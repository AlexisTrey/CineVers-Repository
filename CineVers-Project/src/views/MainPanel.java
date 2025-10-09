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

    public MainPanel(ActionListener listener) {
        setLayout(new BorderLayout());
        header = new Header(listener);
        //background = new Background();

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Agregación de vistas al CardLayout
        contentPanel.add(new HomePanel(), HOME);

        add(header, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        //add(background, BorderLayout.CENTER);
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }
}
