package strifeforge.controller;

import strifeforge.model.*;
import strifeforge.view.*;

public class DashboardController {
    private DashboardForm view;

    public DashboardController(DashboardForm view) {
        this.view = view;

        MemberForm memberPanel = new MemberForm();
        MemberController memberCtrl = new MemberController(memberPanel, new Member());
        view.tambahHalaman("member", memberPanel);
        view.btnMember.addActionListener(e -> { memberCtrl.loadTable(); view.tampil("member"); });

        PaketForm paketPanel = new PaketForm();
        PaketController paketCtrl = new PaketController(paketPanel, new Paket());
        view.tambahHalaman("paket", paketPanel);
        view.btnPaket.addActionListener(e -> { paketCtrl.loadTable(); view.tampil("paket"); });

        TransaksiForm trxPanel = new TransaksiForm();
        TransaksiController trxCtrl = new TransaksiController(trxPanel);
        view.tambahHalaman("transaksi", trxPanel);
        view.btnTransaksi.addActionListener(e -> { trxCtrl.refresh(); view.tampil("transaksi"); });

        AbsensiForm absenPanel = new AbsensiForm();
        AbsensiController absenCtrl = new AbsensiController(absenPanel);
        view.tambahHalaman("absensi", absenPanel);
        view.btnAbsensi.addActionListener(e -> { absenCtrl.loadTable(); view.tampil("absensi"); });

        JadwalForm jadwalPanel = new JadwalForm();
        JadwalController jadwalCtrl = new JadwalController(jadwalPanel);
        view.tambahHalaman("jadwal", jadwalPanel);
        view.btnJadwal.addActionListener(e -> { jadwalCtrl.loadTable(); view.tampil("jadwal"); });

        view.btnLogout.addActionListener(e -> {
            view.dispose();
            LoginForm f = new LoginForm();
            new LoginController(f, new User());
            f.setVisible(true);
        });
    }
}