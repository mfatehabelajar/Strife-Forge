package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JadwalForm extends JPanel {
    public JTextField txtNamaKelas = new JTextField();
    public JTextField txtInstruktur = new JTextField();
    public JComboBox<String> cbHari = new JComboBox<>(
        new String[]{"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"});
    public JTextField txtJam = new JTextField();
    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnKembali = new JButton("Kembali");

    public DefaultTableModel tableModel = new DefaultTableModel(
        new String[]{"ID", "Nama Kelas", "Instruktur", "Hari", "Jam"}, 0);
    public JTable tblJadwal = new JTable(tableModel);

    public JadwalForm() {
        UI.siapkan(this, "Jadwal Kelas");

        JPanel pForm = UI.form("Data Jadwal",
            new String[]{"Nama Kelas", "Instruktur", "Hari", "Jam (contoh 19:00)"},
            new JComponent[]{txtNamaKelas, txtInstruktur, cbHari, txtJam});

        JPanel body = new JPanel(new BorderLayout(20, 0));
        body.add(UI.kiri(pForm, UI.tombol(btnSimpan, btnHapus)), BorderLayout.WEST);
        tblJadwal.setFillsViewportHeight(true);
        body.add(new JScrollPane(tblJadwal), BorderLayout.CENTER);
        add(body, BorderLayout.CENTER);
    }
}