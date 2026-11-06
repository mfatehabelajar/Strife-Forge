package strifeforge;

import strifeforge.controller.LoginController;
import strifeforge.model.User;
import strifeforge.view.LoginForm;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            LoginForm form = new LoginForm();
            new LoginController(form, new User());
            form.setVisible(true);
        });
    }
}