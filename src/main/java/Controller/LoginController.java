package Controller;

import Model.ClienteModel;
import Model.ProducModel;
import Model.UserModel;
import Vista.LoginForm;
import Vista.VistaCliente;
import Vista.VistaProducto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private UserModel model;
    private LoginForm view;

    public LoginController(UserModel model, LoginForm view) {
        this.model = model;
        this.view = view;

        view.addLoginButtonListener(new LoginButtonListener());
    }

    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (model.validateCredentials(username, password)) {
                view.showSuccessMessage();
              //new  Home();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VistaProducto view = new VistaProducto();
                        ProducModel model = new ProducModel();
                        new ProduController(model, view);
                        view.setVisible(true);
                    }
                });

                view.dispose(); // Cierra la ventana de login
            } else {
                view.showErrorMessage();
            }
        }
    }
}
