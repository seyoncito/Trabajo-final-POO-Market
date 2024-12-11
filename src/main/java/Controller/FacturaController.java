package Controller;


import Model.ClienteModel;
import Model.FacturaModel;
import Vista.VistaCliente;
import Vista.VistaFactura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaController {
    private FacturaModel model;
    private VistaFactura view;

    public FacturaController(FacturaModel model, VistaFactura view) {
        this.model = model;
        this.view = view;
        view.addClienteButton(new anadirClientesvista());

    }

   private class anadirClientesvista implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {

                    VistaCliente vistaCliente = new VistaCliente();
                    ClienteModel modeloCliente = new ClienteModel();
                    new ClienteController( modeloCliente,vistaCliente);
                    vistaCliente.setVisible(true);
                    view.dispose();

            });
        }
    }
}
