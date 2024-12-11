package Controller;

import Model.ClienteModel;
import Model.ProducModel;
import Model.Producto;
import Vista.VistaCliente;
import Vista.VistaFactura;
import Vista.VistaProducto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProduController {
    private ProducModel model;
    private VistaProducto view;

    public ProduController(ProducModel model, VistaProducto view) {
        this.model = model;
        this.view = view;

        view.addAddButtonListener(new AddButtonListener());
        view.addClientButtonListener(new ClientButtonListener());
        view.addFacturButtonListener(new AddnuevaFactura());
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getId();
            String name = view.getName();
            double price = view.getPrice();

            Producto product = new Producto(id, name, price);
            model.agregarproducto(product);

            view.displayProducts(model.getProducts());
        }
    }
    class ClientButtonListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VistaCliente view1 = new VistaCliente();
                ClienteModel model1 = new ClienteModel();
                new ClienteController(model1, view1);
                view1.setVisible(true);
                view.dispose(); // Cierra la ventana actual
                // Cierra la ventana actual
            }
        });
        }
    }
    class AddnuevaFactura implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaFactura nuevaFactura = new VistaFactura();
            nuevaFactura.setVisible(true);
            view.dispose(); // Cierra la ventana actual
        }
    }
}
