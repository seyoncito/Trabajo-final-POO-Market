import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaNueva extends JFrame {
    public FacturaNueva() {
        setTitle("Nueva Factura");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel lblCliente = new JLabel("Cliente:");
        JTextField txtCliente = new JTextField();
        JLabel lblItem = new JLabel("Item:");
        JTextField txtItem = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();

        JButton btnAgregar = new JButton("Agregar");
        JTextArea txtFactura = new JTextArea();
        Factura factura = new Factura("");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = txtCliente.getText();
                String item = txtItem.getText();
                double precio = Double.parseDouble(txtPrecio.getText());

                factura.agregarItem(item, precio);
                factura.setCliente(cliente);
                txtFactura.setText(factura.toString());
            }
        });

        add(lblCliente);
        add(txtCliente);
        add(lblItem);
        add(txtItem);
        add(lblPrecio);
        add(txtPrecio);
        add(btnAgregar);
        add(new JScrollPane(txtFactura));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FacturaNueva().setVisible(true));
    }
}
