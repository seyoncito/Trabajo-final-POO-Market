package Vista;

import Model.Factura;
import Model.FacturaModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.List;

public class VistaFactura extends JFrame{
    private JTextField txtNumeroFactura;
    private JTextField txtFecha;
    private JTextField txtCliente;
    private JTextField txtProducto;
    private JTextField txtTotal;
    private JTextArea txtDetalle;
    private JButton btnGuardar;
    private JButton btncancelar;

    private JMenuBar menuBar;
    private JMenu menuFactura;
    private JMenuItem addFacturButton;
    private JMenuItem agregarClienteItem;
    private JMenuItem listarFacturasItem;

    public VistaFactura(){
        setTitle("Nueva Factura");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        menuBar = new JMenuBar();
        menuFactura = new JMenu("Factura");
        addFacturButton = new JMenuItem("Nueva Factura");
        agregarClienteItem = new JMenuItem("Agregar Clientes");
        listarFacturasItem = new JMenuItem("Listar Factura");
        menuFactura.add(addFacturButton);
        menuFactura.add(agregarClienteItem);
        menuFactura.add(listarFacturasItem);
        menuBar.add(menuFactura);

        setJMenuBar(menuBar);
        // Crear los componentes
        txtNumeroFactura = new JTextField(10);
        txtFecha = new JTextField(10);
        txtCliente = new JTextField(20);
        txtTotal = new JTextField(10);
        txtProducto = new JTextField(20);
        txtDetalle = new JTextArea(10, 40);
        btnGuardar = new JButton("Guardar");
        btncancelar = new JButton("Cancelar");

        FacturaModel modelo = new FacturaModel();
        String[] clientes = modelo.getClientes();
        // Configurar el diseño
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));
        panel.add(new JLabel("Número de Factura:"));
        panel.add(txtNumeroFactura);

        JComboBox<String> cmbClientes = new JComboBox<>(clientes);
        panel.add(new JLabel("Nombre Cliente:"));
        panel.add(cmbClientes);

        panel.add(new JLabel("Fecha:"));
        panel.add(txtFecha);
        panel.add(new JLabel("Nombre Producto:"));
        panel.add(txtProducto);
        panel.add(new JLabel("Total:"));
        panel.add(txtTotal);
        panel.add(btnGuardar);
        panel.add(btncancelar);

        JPanel panelDetalle = new JPanel();
        panelDetalle.setLayout(new BorderLayout());
        panelDetalle.add(new JLabel("Detalle de la Factura:"), BorderLayout.NORTH);
        panelDetalle.add(new JScrollPane(txtDetalle), BorderLayout.CENTER);

        // Agregar los componentes al frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(panelDetalle, BorderLayout.CENTER);

        // Agregar un listener para el botón guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarFactura(txtNumeroFactura.getText(),cmbClientes.getSelectedItem().toString(), txtFecha.getText(), txtProducto.getText(), txtTotal.getText());
            }
        });

        listarFacturasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrardetallefactur(); // Call the method to display invoices
            }
        });

        // la fecha actual
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        txtFecha.setText(formato.format(new Date()));

        btncancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            cancelar();
            }
        });
    }
    private void guardarFactura(String facturaId, String cliente, String fecha, String producto, String total) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Tienda","postgres","123456");
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO tb_facturas (factura_id, cliente_id, factura_date, producto_id, total) VALUES (?, ?, ?, ?, ?)")){

            String fechaString = txtFecha.getText().trim(); // Get date string from input
            java.sql.Date fechada = java.sql.Date.valueOf(fechaString); // Convert to java.sql.Date
             pstmt.setString(1, facturaId);
             pstmt.setString(2, cliente);
             pstmt.setDate(3, fechada); // Set the date in your PreparedStatement
             pstmt.setString(4, producto);
             pstmt.setDouble(5, Double.parseDouble(total));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Factura guardada exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar la factura.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la factura: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
}

    private void cancelar() {
        // Limpiar los campos
        txtNumeroFactura.setText("");
        txtFecha.setText("");
        txtCliente.setText("");
        txtTotal.setText("");
        txtDetalle.setText("");

        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Operación cancelada");
        //salir de la ventana
        this.dispose();
    }
    public void addClienteButton(ActionListener listener) {
        agregarClienteItem.addActionListener(listener);
    }
    public void mostrardetallefactur() {
        FacturaModel modelo1 = new FacturaModel();
        List<Factura> facturas = modelo1.getFacturas();
        
        txtDetalle.setText("");
        for (Factura factura : facturas) {
            txtDetalle.append(factura.toString() + "\n"); // Display each factura in the text area
        }
    }
}
