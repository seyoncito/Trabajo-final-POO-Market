import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RegistrCliente extends JFrame {
    public RegistrCliente() {
        setTitle("Crear Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblDireccion = new JLabel("Dirección:");
        JTextField txtDireccion = new JTextField();
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();

                Cliente cliente = new Cliente(nombre, direccion, telefono);
                JOptionPane.showMessageDialog(null, "Cliente creado: \n" + cliente.toString());
                dispose();
            }
        });

        add(lblNombre);
        add(txtNombre);
        add(lblDireccion);
        add(txtDireccion);
        add(lblTelefono);
        add(txtTelefono);
        add(btnGuardar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrCliente().setVisible(true));
    }
}
