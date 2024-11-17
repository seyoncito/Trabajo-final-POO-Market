import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame{


    private JTextField usuario;
    private JPasswordField contraseña;
    private JButton loginButton;
    private JButton registro;
    public LoginPanel() {

        setLayout(new BorderLayout());
        setTitle("Market");

        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        add(panel, BorderLayout.CENTER);

        JScrollPane jScrollBar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(jScrollBar);

        JLabel label = new JLabel("Acceder a la cuenta");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(400,20, 500,40);
        panel.add(label);

        JLabel userLabel = new JLabel("Usuario");
        userLabel.setBounds(15, 60, 90, 30);
        panel.add(userLabel);

        usuario = new JTextField(15);
        panel.add(usuario);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(15, 60, 90, 30);
        panel.add(passwordLabel);

        contraseña = new JPasswordField(15);
        panel.add(contraseña);


        loginButton = new JButton("Iniciar Session");
        loginButton.setBounds(10, 80, 100, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        panel.add(loginButton);
        registro = new JButton("Registrarse");
        registro.setBounds(100, 80, 80, 25);
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registro();
            }
        });

        panel.add(registro);

    }
    private void login() {
        String user = usuario.getText();
        String pass = new String(contraseña.getPassword());

        // Verificar credenciales
        if (user.equals("admin") && pass.equals("admin")) {
            // JOptionPane.showMessageDialog(this, "Bienvenido " + user);
            //System.exit(0);
            Acerca sistyF =new Acerca();
            sistyF.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
        }
    }

    private void registro() {
        // Implementar registro de usuario
        JOptionPane.showMessageDialog(this, "Registro de usuario");
    }

    private boolean verificarCredenciales(String user, String pass) {
        // Implementar lógica de verificación de credenciales
        // Por ahora, solo se verifica si el usuario es "admin" y la contraseña es "admin"
        return user.equals("admin") && pass.equals("admin");
    }

}

