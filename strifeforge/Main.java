package strifeforge;

import strifeforge.controller.LoginController;
import strifeforge.model.User;
import strifeforge.view.LoginForm;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            LoginForm form = new LoginForm();
            User user = new User();
            new LoginController(form, user);

            form.setLocationRelativeTo(null);
            form.setVisible(true);
        });
    }
}