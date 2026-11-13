package strifeforge.controller;

import org.hibernate.Session;
import strifeforge.config.Koneksi;
import strifeforge.model.Absensi;
import strifeforge.model.Member;
import strifeforge.service.AbsensiService;
import strifeforge.view.AbsensiForm;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbsensiController {
    private AbsensiForm view;
    private AbsensiService service = new AbsensiService();

    public AbsensiController(AbsensiForm view) {
        this.view = view;
        loadTable();
        
        view.btnCheckIn.addActionListener(e -> checkIn());
        view.btnKembali.addActionListener(e -> view.dispose());
        view.btnCari.addActionListener(e -> loadTable());
        view.btnRefresh.addActionListener(e -> loadTable());
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tabel.getModel();
        t.setRowCount(0);
        var list = service.getSemuaAbsensi();
        for (Absensi a : list) {
            t.addRow(new Object[]{a.getIdAbsensi(), a.getIdMember(), a.getNamaMember(), a.getFormattedWaktu()});
        }
        view.lblTotal.setText("Total: " + list.size());
    }

    private void checkIn() {
        String idStr = view.txtIdMember.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(view, "ID Member kosong!");
            return;
        }

        Session session = Koneksi.getSessionFactory().openSession();
        Member m = session.get(Member.class, Long.parseLong(idStr));
        session.close();

        if (m == null || !m.isAktif()) {
            JOptionPane.showMessageDialog(view, "Check-in gagal! Member tidak aktif atau tidak ditemukan.");
            return;
        }

        Absensi a = new Absensi(m.getIdInt(), m.getNama());
        if (service.checkIn(a)) {
            JOptionPane.showMessageDialog(view, "Check-in Berhasil: " + m.getNama());
            view.txtIdMember.setText("");
            loadTable();
        }
    }
}