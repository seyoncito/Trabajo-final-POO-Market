package Controller;

import Model.ClienteModel;
import Model.Cliente;
import Vista.VistaCliente;
import Vista.VistaFactura;
import Vista.VistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteController {
    private ClienteModel model1;
    private VistaCliente view1;
    private VistaProducto Go;
    private VistaFactura ir;

    public ClienteController(ClienteModel model1,VistaCliente view1) {
        this.model1 = model1;
        this.view1 = view1;
        view1.addClienteButtonListener(new addButtoncListener());
        view1.addProductButtonListener (new ProductButtonListener());
        view1.addfacturaButtonListener(new AddnuevaFactura());
    }

    class addButtoncListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String codCliente = view1.getCodCliente();
            String nombre= view1.getNombre();
            String apellidoP= view1.getApellidoP();
            String direccion= view1.getDireccion();
            String ruc=view1.getRuc();
            Cliente cliente = new Cliente(codCliente,nombre,apellidoP,direccion,ruc);
            model1.agregarCliente(cliente);
            view1.mostrarClientes(model1.getClientes());
        }
    }
    class ProductButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaProducto vistaProductos = new VistaProducto();
            vistaProductos.setVisible(true);
            view1.dispose(); // Cierra la ventana actual
        }
    }
    class AddnuevaFactura implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            VistaFactura nuevaFactura = new VistaFactura();
            nuevaFactura.setVisible(true);
            view1.dispose(); // Cierra la ventana actual
        }
    }
}
