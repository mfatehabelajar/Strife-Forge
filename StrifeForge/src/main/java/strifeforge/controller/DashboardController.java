package strifeforge.controller;

import strifeforge.model.Paket;
import strifeforge.model.*;
import strifeforge.view.*;

public class DashboardController {
    private DashboardForm view;

    public DashboardController(DashboardForm view) {
        this.view = view;

        view.btnMember.addActionListener(e -> {
            MemberForm f = new MemberForm();
            new MemberController(f, new Member());
            f.setVisible(true);
        });

        view.btnPaket.addActionListener(e -> {
            PaketForm f = new PaketForm();
            new PaketController(f, new Paket());
            f.setVisible(true);
        });

        view.btnTransaksi.addActionListener(e -> {
            TransaksiForm f = new TransaksiForm();
            new TransaksiController(f);
            f.setVisible(true);
        });

        view.btnAbsensi.addActionListener(e -> {
            AbsensiForm f = new AbsensiForm();
            new AbsensiController(f);
            f.setVisible(true);
        });

        view.btnLogout.addActionListener(e -> {
            view.dispose();
            LoginForm f = new LoginForm();
            new LoginController(f, new User());
            f.setVisible(true);
        });
    }
}