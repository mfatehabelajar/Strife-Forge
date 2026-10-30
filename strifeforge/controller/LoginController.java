package strifeforge.controller;

import strifeforge.model.User;
import strifeforge.view.LoginForm;
import strifeforge.view.DashboardForm;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginForm view;
    private User model;

    public LoginController(LoginForm view, User model) {
        this.view = view;
        this.model = model;

        this.view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesLogin();
            }
        });
    }

    private void prosesLogin() {
        String username = view.getUsernameInput().trim();
        String password = view.getPasswordInput().trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Username dan Password wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean loginBerhasil = model.login(username, password);

        if (loginBerhasil) {
            JOptionPane.showMessageDialog(view, "Login Berhasil! Selamat Datang, " + username, "Informasi", JOptionPane.INFORMATION_MESSAGE);
            DashboardForm dashboard = new DashboardForm();
            dashboard.setLocationRelativeTo(null);
            dashboard.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Username atau Password salah!", "Autentikasi Gagal", JOptionPane.ERROR_MESSAGE);
            view.resetForm();
        }
    }
}