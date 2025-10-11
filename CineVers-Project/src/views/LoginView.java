/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Paola Andrea Camacho Gonzalez
 * @author Hellen Valeria Melo Cubides
 * @author Jhonnyd Bleyck Arias Santafe
 */

public class LoginView extends JPanel {

    private Header header;
    private Background background;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JButton btnLogin, btnCrearCuenta;
    private JLabel lblOlvido, lblMensajeInferior, lblTitulo;

    public LoginView() {
        setLayout(new BorderLayout());

        
        header = new Header(e -> {
            System.out.println("Botón del header presionado: " + e.getActionCommand());
        });
        add(header, BorderLayout.NORTH);

    
        background = new Background();
        background.setLayout(new GridBagLayout());

     
        JPanel panelLogin = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(250, 250, 250)); 
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                g2.setColor(new Color(0, 0, 0, 30)); 
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 40, 40);
                g2.dispose();
            }
        };
        panelLogin.setOpaque(false);
       panelLogin.setBorder(new EmptyBorder(20, 60, 20, 60));


       lblTitulo = new JLabel("CineVers", SwingConstants.CENTER);
lblTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 50)); 
lblTitulo.setBorder(new EmptyBorder(0, 0, -10, 0)); 

        lblTitulo.setForeground(new Color(200, 90, 220)); 

        JLabel lblSub = new JLabel("Inicio de Sesión", SwingConstants.CENTER);
        lblSub.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblSub.setForeground(Color.BLACK);

        txtCorreo = crearCampoTexto("Correo Electrónico");
        txtContrasena = new JPasswordField();
        estilizarCampo(txtContrasena, "Contraseña");


        btnLogin = new JButton("Iniciar Sesión") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(180, 70, 220),
                        getWidth(), getHeight(), new Color(230, 130, 200)
                );
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setPreferredSize(new Dimension(250, 45));


        lblOlvido = new JLabel("¿Olvidaste tu contraseña?");
        lblOlvido.setForeground(new Color(150, 70, 200));
        lblOlvido.setFont(new Font("Segoe UI", Font.BOLD, 16)); 

        lblOlvido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblOlvido.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        mostrarVentanaOlvidoContrasena();
    }
});

        lblMensajeInferior = new JLabel("¿No tienes una cuenta?");
        lblMensajeInferior.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        btnCrearCuenta = new JButton("Crear cuenta");
        btnCrearCuenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCrearCuenta.setForeground(new Color(150, 70, 200));
        btnCrearCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCrearCuenta.setBorderPainted(false);
        btnCrearCuenta.setFocusPainted(false);
        btnCrearCuenta.setContentAreaFilled(false);

        btnLogin.addActionListener(e -> JOptionPane.showMessageDialog(this, "Iniciando sesión..."));
        btnCrearCuenta.addActionListener(e -> System.out.println("Abrir pantalla de registro..."));

 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelLogin.add(lblTitulo, gbc);

        gbc.gridy++;
        panelLogin.add(lblSub, gbc);

        gbc.gridy++;
        panelLogin.add(txtCorreo, gbc);

        gbc.gridy++;
        panelLogin.add(txtContrasena, gbc);

        gbc.gridy++;
        panelLogin.add(btnLogin, gbc);

        gbc.gridy++;
        panelLogin.add(lblOlvido, gbc);

        gbc.gridy++;
        JPanel panelInferior = new JPanel(new GridLayout(2, 1, 0, 3));
panelInferior.setOpaque(false);

JLabel lblMensaje1 = new JLabel("¿No tienes una cuenta?", SwingConstants.CENTER);
lblMensaje1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
lblMensaje1.setForeground(Color.BLACK);

JButton btnCrear = new JButton("Crear cuenta");
btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 14));
btnCrear.setForeground(new Color(150, 70, 200));
btnCrear.setFocusPainted(false);
btnCrear.setContentAreaFilled(false);
btnCrear.setBorderPainted(false);
btnCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
btnCrear.addActionListener(e -> System.out.println("Abrir pantalla de registro..."));

panelInferior.add(lblMensaje1);
panelInferior.add(btnCrear);

panelLogin.add(panelInferior, gbc);


       
        GridBagConstraints center = new GridBagConstraints();
        center.gridx = 0;
        center.gridy = 0;
        background.add(panelLogin, center);

        add(background, BorderLayout.CENTER);
    }

    private JTextField crearCampoTexto(String placeholder) {
        JTextField txt = new JTextField(20);
        estilizarCampo(txt, placeholder);
        return txt;
    }

    private void estilizarCampo(JTextField campo, String placeholder) {
         campo.setPreferredSize(new Dimension(300, 40));
    campo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    campo.setForeground(Color.WHITE);
    campo.setBackground(new Color(200, 160, 230)); 
    campo.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

    campo.setOpaque(false);
    campo.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(200, 160, 230), 0),
        BorderFactory.createEmptyBorder(10, 15, 10, 15)
    ));

    campo.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
        @Override
        protected void paintSafely(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(campo.getBackground());
            g2.fillRoundRect(0, 0, campo.getWidth(), campo.getHeight(), 25, 25);
            super.paintSafely(g);
            g2.dispose();
        }
    });

    campo.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (campo.getText().equals(placeholder)) {
                campo.setText("");
                campo.setForeground(Color.WHITE);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (campo.getText().isEmpty()) {
                campo.setText(placeholder);
                campo.setForeground(Color.WHITE);
            }
        }
    });

    campo.setText(placeholder);
    }
    
private void mostrarVentanaOlvidoContrasena() {
   
    Window parent = SwingUtilities.getWindowAncestor(this);

    
    JWindow overlay = new JWindow(parent);
    overlay.setBackground(new Color(0, 0, 0, 150));
    overlay.setBounds(parent.getBounds());
    overlay.setAlwaysOnTop(false);
    overlay.setVisible(true);


    JDialog dialog = new JDialog((Frame) parent, "Recuperar contraseña", true);
    dialog.setUndecorated(true);
    dialog.setSize(420, 320);
    dialog.setLocationRelativeTo(this);
    dialog.setLayout(new BorderLayout());
    dialog.setBackground(new Color(0, 0, 0, 0)); 
   
    JPanel fondo = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            g2.setColor(new Color(0, 0, 0, 25));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            g2.dispose();
        }
    };
    fondo.setLayout(new BorderLayout());
    fondo.setBorder(new EmptyBorder(20, 25, 25, 25));
    fondo.setOpaque(false);

    JButton btnCerrar = new JButton("×"); 
    btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
    btnCerrar.setFocusPainted(false);
    btnCerrar.setBorderPainted(false);
    btnCerrar.setContentAreaFilled(false);
    btnCerrar.setForeground(Color.DARK_GRAY);
    btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


    btnCerrar.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            btnCerrar.setForeground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnCerrar.setForeground(Color.DARK_GRAY);
        }
    });

    btnCerrar.addActionListener(e -> {
        overlay.dispose();
        dialog.dispose();
    });

    JPanel barraSuperior = new JPanel(new BorderLayout());
    barraSuperior.setOpaque(false);
    barraSuperior.setBorder(new EmptyBorder(5, 5, 10, 5)); 
    barraSuperior.add(btnCerrar, BorderLayout.EAST);

   
    JPanel contenido = new JPanel();
    contenido.setOpaque(false);
    contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
    contenido.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel lblTitulo = new JLabel("¿Olvidaste tu contraseña?");
    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
    lblTitulo.setForeground(Color.BLACK);
    lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel lblDescripcion = new JLabel(
        "<html><div style='text-align:center;'>Ingresa tu correo electrónico.<br>"
        + "Si estás registrado, te enviaremos un correo con una clave de acceso a nuestro sitio web.</div></html>",
        SwingConstants.CENTER
    );
    lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblDescripcion.setForeground(Color.DARK_GRAY);
    lblDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
    lblDescripcion.setPreferredSize(new Dimension(360, 50)); 


    JTextField txtCorreoRecuperar = new JTextField("Correo Electrónico");
    txtCorreoRecuperar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    txtCorreoRecuperar.setForeground(Color.GRAY);
    txtCorreoRecuperar.setMaximumSize(new Dimension(280, 40));
    txtCorreoRecuperar.setAlignmentX(Component.CENTER_ALIGNMENT);
    txtCorreoRecuperar.setHorizontalAlignment(SwingConstants.CENTER);
    txtCorreoRecuperar.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(180, 180, 180)),
        BorderFactory.createEmptyBorder(8, 12, 8, 12)
    ));

    txtCorreoRecuperar.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (txtCorreoRecuperar.getText().equals("Correo Electrónico")) {
                txtCorreoRecuperar.setText("");
                txtCorreoRecuperar.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (txtCorreoRecuperar.getText().isEmpty()) {
                txtCorreoRecuperar.setText("Correo Electrónico");
                txtCorreoRecuperar.setForeground(Color.GRAY);
            }
        }
    });


    JButton btnVerificar = new JButton("VERIFICAR") {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(30, 0, 80));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            g2.dispose();
            super.paintComponent(g);
        }
    };
    btnVerificar.setForeground(Color.WHITE);
    btnVerificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
    btnVerificar.setFocusPainted(false);
    btnVerificar.setContentAreaFilled(false);
    btnVerificar.setBorderPainted(false);
    btnVerificar.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnVerificar.setPreferredSize(new Dimension(160, 40));

    btnVerificar.addActionListener(e -> {
        JOptionPane.showMessageDialog(dialog, "Si el correo existe, se enviará un enlace de recuperación.");
        overlay.dispose();
        dialog.dispose();
    });

    contenido.add(lblTitulo);
    contenido.add(Box.createVerticalStrut(10));
    contenido.add(lblDescripcion);
    contenido.add(Box.createVerticalStrut(15));
    contenido.add(txtCorreoRecuperar);
    contenido.add(Box.createVerticalStrut(25));
    contenido.add(btnVerificar);

    fondo.add(barraSuperior, BorderLayout.NORTH);
    fondo.add(contenido, BorderLayout.CENTER);
    dialog.add(fondo, BorderLayout.CENTER);

    
    dialog.setVisible(true);

   
    overlay.dispose();
}

/*
 * public static void main(String[] args) {
        JFrame frame = new JFrame("CineVers - Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new LoginView());
        frame.setVisible(true);
    }
 */
   
}
