package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PaketForm extends JPanel {
    public JTextField txtId = new JTextField();
    public JTextField txtNama = new JTextField();
    public JTextField txtDurasi = new JTextField();
    public JTextField txtHarga = new JTextField();
    public JTextField txtCari = new JTextField();

    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnUbah = new JButton("Ubah");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnReset = new JButton("Reset");
    public JButton btnCari = new JButton("Cari");
    public JButton btnKembali = new JButton("Kembali");

    public DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nama", "Durasi", "Harga"}, 0);
    public JTable tabel = new JTable(model);

    public PaketForm() {
        UI.siapkan(this, "Manajemen Paket");

        JPanel pForm = UI.form("Form Paket",
            new String[]{"ID Paket", "Nama", "Durasi (Hari)", "Harga"},
            new JComponent[]{txtId, txtNama, txtDurasi, txtHarga});

        JPanel body = new JPanel(new BorderLayout(20, 0));
        body.add(UI.kiri(pForm, UI.tombol(btnSimpan, btnHapus, btnReset)), BorderLayout.WEST);
        tabel.setFillsViewportHeight(true);
        body.add(new JScrollPane(tabel), BorderLayout.CENTER);
        add(body, BorderLayout.CENTER);
    }
}