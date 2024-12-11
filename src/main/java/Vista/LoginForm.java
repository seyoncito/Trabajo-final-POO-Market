package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{

    protected JTextField usernameField;
    protected JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {

        setTitle("Login");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel imajen = new JLabel();
        try {
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\asus\\IdeaProjects\\SytemVenta\\pictures\\logoMarketMingle.png");
            Image image = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            imajen.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            imajen.setText("Logo no encontrado"); // Mensaje alternativo si falla la carga
        }
        JPanel imagePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcImage = new GridBagConstraints(); // Crea un nuevo GridBagConstraints para imagePanel
        gbcImage.gridx = 0;
        gbcImage.gridy = 0;
        gbcImage.anchor = GridBagConstraints.CENTER;
        gbcImage.fill = GridBagConstraints.NONE;
        imagePanel.add(imajen, gbcImage); // Agrega la imagen al imagePanel

        add(imagePanel, BorderLayout.NORTH);

        // Panel para los componentes del formulario (usando GridBagLayout)
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 6, 6, 4); // Márgenes entre componentes
        gbc.anchor = GridBagConstraints.WEST; // Alineación a la izquierda

        // Título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Ocupa dos columnas
        JLabel l = new JLabel("Iniciar Sesión", JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        formPanel.add(l, gbc);

        // Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
       // gbc.gridheight = 2;
        JLabel usernameLabel = new JLabel("Username:");
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        usernameField = new JTextField(20); // Tamaño sugerido
        formPanel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Botón de Login
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Expande el botón horizontalmente
        loginButton = new JButton("Login");
        formPanel.add(loginButton, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Login successful!");
    }

    public void showErrorMessage() {
        JOptionPane.showMessageDialog(this, "Invalid username or password!", "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

