import Controller.LoginController;

import javax.swing.*;
import Model.UserModel;
import Vista.LoginForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserModel model = new UserModel("admin", "admin");
                LoginForm view = new LoginForm();
                new LoginController(model, view);
                view.setVisible(true);
            }
        });
    }
}
