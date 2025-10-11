package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */
public class MainFrame extends JFrame {

    private ActionListener listener;
    private MainPanel mainPanel;

    public MainFrame(ActionListener listener) {
        super("CineVers");
        this.listener = listener;
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //this.setLayout(new BorderLayout());

        mainPanel = new MainPanel(listener);
        add(mainPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
