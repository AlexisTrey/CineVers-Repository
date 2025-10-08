package views;

import java.awt.BorderLayout;

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
    private Background background;

    public MainPanel() {
        setLayout(new BorderLayout());
        header = new Header();
        background = new Background();
        add(header, BorderLayout.NORTH);
        add(background, BorderLayout.CENTER);
    }
}
