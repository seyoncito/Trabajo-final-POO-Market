package Vista;

import Model.Producto;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaProducto extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JButton addButton;
    private JTextArea productTextArea;
    private JButton addClientsButton;
    private JButton addProductsButton;
    private JMenuBar menuBar;
    private JMenu menuProductos;
    private JMenuItem agregarProductoItem;
    private JMenuItem listarProductosItem;

    public VistaProducto() {
        setTitle("Registro de Productos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los componentes

        idField = new JTextField(10);
        nameField = new JTextField(20);
        priceField = new JTextField(10);
        addButton = new JButton("Agregar Produtos");
        addClientsButton = new JButton("Agregar Clientes");
        productTextArea = new JTextArea(10, 30);
        productTextArea.setEditable(false);

        // Configurar el diseño
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Precio:"));
        inputPanel.add(priceField);
        inputPanel.add(addButton);
        inputPanel.add(addClientsButton);

        JScrollPane scrollPane = new JScrollPane(productTextArea);
        JScrollPane productScrollPane = new JScrollPane(productTextArea);


        // Agregar componentes al frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Añadir listener para el botón "Agregar Clientes"

        // Crear el menú
        menuBar = new JMenuBar();
        menuProductos = new JMenu("Productos");
        agregarProductoItem = new JMenuItem("Nuenva Factura");
        listarProductosItem = new JMenuItem("Listar Productos");

        menuProductos.add(agregarProductoItem);
        menuProductos.add(listarProductosItem);
        menuBar.add(menuProductos);

        // Agregar componentes al frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setJMenuBar(menuBar);

        // Agregar un panel para mostrar los productos
    }

    public String getId() {
        return idField.getText();
    }

    public String getName() {
        return nameField.getText();
    }

    public double getPrice() {
        return Double.parseDouble(priceField.getText());
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addClientButtonListener(ActionListener listener){
        addClientsButton.addActionListener(listener);

    }
    public void addFacturButtonListener(ActionListener listener) {
        agregarProductoItem.addActionListener(listener);
    }

    public void displayProducts(List<Producto> products) {
        productTextArea.setText("");
        for (Producto product : products) {
            productTextArea.append(product.toString() + "\n");
        }
    }
}
