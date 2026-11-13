package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JadwalForm extends JFrame {
    
    // Komponen di-set public agar mudah diakses oleh Controller
    public JTextField txtNamaKelas;
    public JTextField txtInstruktur;
    public JComboBox<String> cbHari;
    public JTextField txtJam;
    public JTable tblJadwal;
    public JButton btnSimpan;
    public JButton btnHapus;
    public JButton btnKembali;

    public JadwalForm() {
        // 1. Pengaturan Dasar Frame
        setTitle("Manajemen Jadwal Kelas - Strife Forge");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Agar form muncul di tengah layar
        setLayout(new BorderLayout(10, 10));

        // 2. Panel Kiri (Form Input)
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(6, 2, 10, 15)); // 6 baris, 2 kolom
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));

        panelForm.add(new JLabel("Nama Kelas:"));
        txtNamaKelas = new JTextField();
        panelForm.add(txtNamaKelas);

        panelForm.add(new JLabel("Instruktur:"));
        txtInstruktur = new JTextField();
        panelForm.add(txtInstruktur);

        panelForm.add(new JLabel("Hari:"));
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
        cbHari = new JComboBox<>(hari);
        panelForm.add(cbHari);

        panelForm.add(new JLabel("Jam (contoh: 19:00):"));
        txtJam = new JTextField();
        panelForm.add(txtJam);

        // 3. Panel Bawah Kiri (Tombol)
        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnKembali = new JButton("Kembali");

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelTombol.add(btnSimpan);
        panelTombol.add(btnHapus);
        panelTombol.add(btnKembali);

        panelForm.add(new JLabel()); // Slot kosong untuk grid kiri
        panelForm.add(panelTombol);  // Tombol di grid kanan

        // 4. Panel Kanan (Tabel)
        String[] headerKolom = {"ID", "Nama Kelas", "Instruktur", "Hari", "Jam"};
        DefaultTableModel tableModel = new DefaultTableModel(headerKolom, 0);
        tblJadwal = new JTable(tableModel);
        JScrollPane scrollTabel = new JScrollPane(tblJadwal);
        scrollTabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));

        // 5. Gabungkan Semua Panel ke Frame Utama
        JLabel lblJudul = new JLabel("DATA JADWAL KELAS", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Arial", Font.BOLD, 18));
        lblJudul.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        add(lblJudul, BorderLayout.NORTH);
        add(panelForm, BorderLayout.WEST);
        add(scrollTabel, BorderLayout.CENTER);
    }
}