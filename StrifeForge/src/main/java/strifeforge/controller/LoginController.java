package strifeforge.controller;

import org.hibernate.Session;
import org.hibernate.query.Query;
import strifeforge.config.Koneksi;
import strifeforge.model.User;
import strifeforge.view.LoginForm;
import strifeforge.view.DashboardForm;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginForm view;
    private User model;

    public LoginController(LoginForm view, User model) {
        this.view = view;
        this.model = model;

        view.btnLogin.addActionListener(e -> {
            String u = view.txtUsername.getText().trim();
            String p = new String(view.txtPassword.getPassword()).trim();

            Session session = Koneksi.getSessionFactory().openSession();
            Query<User> query = session.createQuery("FROM User WHERE username = :uname AND password = :pwd", User.class);
            query.setParameter("uname", u);
            query.setParameter("pwd", p);
            User user = query.uniqueResult();
            session.close();

            if (user != null) {
                JOptionPane.showMessageDialog(view, "Login Sukses!");
                DashboardForm dash = new DashboardForm();
                new DashboardController(dash);
                dash.setVisible(true);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Username atau Password salah!");
            }
        });
    }
}