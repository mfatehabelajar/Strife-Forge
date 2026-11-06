package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MemberForm extends JFrame {
    public JTextField txtId = new JTextField();
    public JTextField txtNama = new JTextField();
    public JTextField txtTelp = new JTextField();
    public JComboBox<String> cbJk = new JComboBox<>(new String[]{"Laki-laki", "Perempuan"});
    public JTextField txtAlamat = new JTextField();
    public JTextField txtTglLahir = new JTextField();
    public JComboBox<String> cbStatus = new JComboBox<>(new String[]{"Aktif", "Nonaktif"});
    public JTextField txtCari = new JTextField();

    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnUbah = new JButton("Ubah");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnReset = new JButton("Reset");
    public JButton btnCari = new JButton("Cari");
    public JButton btnKembali = new JButton("Kembali");

    public DefaultTableModel model = new DefaultTableModel(
        new String[]{"ID", "Nama", "No. Telp", "Gender", "Alamat", "Tgl Lahir", "Status"}, 0
    );
    public JTable tabel = new JTable(model);

    public MemberForm() {
        setTitle("Manajemen Member");
        setSize(850, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Kiri: Form Input
        JPanel pForm = new JPanel(new GridLayout(7, 2, 5, 5));
        pForm.setBorder(BorderFactory.createTitledBorder("Data Member"));
        txtId.setEditable(false);

        pForm.add(new JLabel("ID:")); pForm.add(txtId);
        pForm.add(new JLabel("Nama:")); pForm.add(txtNama);
        pForm.add(new JLabel("No. Telp:")); pForm.add(txtTelp);
        pForm.add(new JLabel("Gender:")); pForm.add(cbJk);
        pForm.add(new JLabel("Alamat:")); pForm.add(txtAlamat);
        pForm.add(new JLabel("Tgl Lahir:")); pForm.add(txtTglLahir);
        pForm.add(new JLabel("Status:")); pForm.add(cbStatus);

        JPanel pBtn = new JPanel();
        pBtn.add(btnSimpan); pBtn.add(btnUbah); pBtn.add(btnHapus); 
        pBtn.add(btnReset); pBtn.add(btnKembali);

        JPanel pLeft = new JPanel(new BorderLayout());
        pLeft.add(pForm, BorderLayout.CENTER);
        pLeft.add(pBtn, BorderLayout.SOUTH);
        add(pLeft, BorderLayout.WEST);

        // Panel Kanan: Tabel & Cari
        JPanel pRight = new JPanel(new BorderLayout());
        JPanel pCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCari.add(new JLabel("Cari:")); pCari.add(txtCari); pCari.add(btnCari);

        pRight.add(pCari, BorderLayout.NORTH);
        pRight.add(new JScrollPane(tabel), BorderLayout.CENTER);
        add(pRight, BorderLayout.CENTER);
    }
}