package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainPanel = new MainPanel(listener);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        this.listener = listener;
        this.setVisible(true);
    }
}
