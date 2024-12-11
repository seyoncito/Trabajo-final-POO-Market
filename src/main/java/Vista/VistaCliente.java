package Vista;

import Model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaCliente extends JFrame{

    private JTextField IdField;
    private JTextField NomField;
    private JTextField ApellidField;
    private JTextField DireccField;
    private JTextField RucField;
    private JButton addclientButton;
    private JTextArea clientTextArea;

    private JMenuBar menuBar;
    private JMenu menuProductos;
    private JMenuItem addFacturButton;
    private JMenuItem agregarProductoItem;
    private JMenuItem listarProductosItem;

    public VistaCliente() {
        setTitle("Registrar Clientes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los componentes

        IdField = new JTextField(10);
        NomField = new JTextField(10);
        ApellidField = new JTextField(10);
        DireccField= new JTextField(20);
        RucField= new JTextField(10);

        addclientButton = new JButton("Agregar Clientes");
        clientTextArea = new JTextArea(10, 40);
        clientTextArea.setEditable(false);

        // Configurar el diseño
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2,5,5));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(IdField);
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(NomField);
        inputPanel.add(new JLabel("Apellido"));
        inputPanel.add(ApellidField);
        inputPanel.add(new JLabel("Direccion"));
        inputPanel.add(DireccField);
        inputPanel.add(new JLabel("Ruc"));
        inputPanel.add(RucField);
        inputPanel.add(new JLabel());

        inputPanel.add(addclientButton);

        JScrollPane scrollPane = new JScrollPane(clientTextArea);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        menuBar = new JMenuBar();
        menuProductos = new JMenu("Clientes");
        addFacturButton = new JMenuItem("Nueva Factura");
        agregarProductoItem = new JMenuItem("Agregar Productos");
        listarProductosItem = new JMenuItem("Listar Clientes");
        menuProductos.add(addFacturButton);
        menuProductos.add(agregarProductoItem);
        menuProductos.add(listarProductosItem);
        menuBar.add(menuProductos);

        setJMenuBar(menuBar);
    }

    public String getCodCliente() {
        return IdField.getText();
    }
    public String getNombre() {
        return NomField.getText();
    }
    public String getApellidoP() {
        return ApellidField.getText();
    }
    public String getDireccion() {
        return DireccField.getText();
    }
    public String getRuc() {
        return RucField.getText();
    }
    public void addClienteButtonListener(ActionListener listener) {
        addclientButton.addActionListener(listener);
    }

    public void addProductButtonListener(ActionListener listener){
        agregarProductoItem.addActionListener(listener);
    }

    public void addfacturaButtonListener(ActionListener listener) {
        addFacturButton.addActionListener(listener);
    }
    public void mostrarClientes(List<Cliente> clients) {
        clientTextArea.setText("");
        for (Cliente cliente : clients) {
            clientTextArea.append(cliente.toString() + "\n");
        }
    }

}
