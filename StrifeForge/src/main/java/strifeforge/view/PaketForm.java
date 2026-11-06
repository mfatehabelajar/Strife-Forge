package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PaketForm extends JFrame {
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
        setTitle("Manajemen Paket Keanggotaan");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Kiri (Form)
        JPanel pForm = new JPanel(new GridLayout(4, 2, 5, 5));
        pForm.setBorder(BorderFactory.createTitledBorder("Form Paket"));
        pForm.add(new JLabel("ID Paket:")); pForm.add(txtId);
        pForm.add(new JLabel("Nama:")); pForm.add(txtNama);
        pForm.add(new JLabel("Durasi (Hari):")); pForm.add(txtDurasi);
        pForm.add(new JLabel("Harga:")); pForm.add(txtHarga);

        JPanel pBtn = new JPanel();
        pBtn.add(btnSimpan); pBtn.add(btnUbah); pBtn.add(btnHapus); 
        pBtn.add(btnReset); pBtn.add(btnKembali);

        JPanel pLeft = new JPanel(new BorderLayout());
        pLeft.add(pForm, BorderLayout.CENTER);
        pLeft.add(pBtn, BorderLayout.SOUTH);
        add(pLeft, BorderLayout.WEST);

        // Panel Kanan (Tabel & Pencarian)
        JPanel pRight = new JPanel(new BorderLayout());
        JPanel pCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCari.add(new JLabel("Cari:")); pCari.add(txtCari); pCari.add(btnCari);
        
        pRight.add(pCari, BorderLayout.NORTH);
        pRight.add(new JScrollPane(tabel), BorderLayout.CENTER);
        add(pRight, BorderLayout.CENTER);
    }
}