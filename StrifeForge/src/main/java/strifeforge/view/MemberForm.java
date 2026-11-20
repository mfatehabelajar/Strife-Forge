package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MemberForm extends JPanel {
    public JTextField txtId = new JTextField();
    public JTextField txtNama = new JTextField();
    public JTextField txtTelp = new JTextField();
    public JComboBox<String> cbJk = new JComboBox<>(new String[]{"Laki-laki", "Perempuan"});
    public JTextField txtAlamat = new JTextField();
    public JTextField txtTglLahir = new JTextField();
    public JComboBox<String> cbStatus = new JComboBox<>(new String[]{"Aktif", "Nonaktif"});
    public JTextField txtCari = new JTextField(15);

    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnUbah = new JButton("Ubah");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnReset = new JButton("Reset");
    public JButton btnCari = new JButton("Cari");
    public JButton btnKembali = new JButton("Kembali"); // tidak dipakai di layout
    public JButton btnCetak = new JButton("Cetak Laporan");

    public DefaultTableModel model = new DefaultTableModel(
        new String[]{"ID", "Nama", "No. Telp", "Gender", "Alamat", "Tgl Lahir", "Status"}, 0
    );
    public JTable tabel = new JTable(model);

    public MemberForm() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel judul = new JLabel("Manajemen Member");
        judul.setFont(judul.getFont().deriveFont(Font.BOLD, 22f));
        add(judul, BorderLayout.NORTH);

        // Form kiri
        JPanel pForm = new JPanel(new GridBagLayout());
        pForm.setBorder(BorderFactory.createTitledBorder("Data Member"));
        txtId.setEditable(false);

        String[] label = {"ID", "Nama", "No. Telp", "Gender", "Alamat", "Tgl Lahir (yyyy-MM-dd)", "Status"};
        JComponent[] input = {txtId, txtNama, txtTelp, cbJk, txtAlamat, txtTglLahir, cbStatus};
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 8, 6, 8);
        g.anchor = GridBagConstraints.WEST;
        for (int i = 0; i < label.length; i++) {
            g.gridy = i;
            g.gridx = 0; g.weightx = 0; g.fill = GridBagConstraints.NONE;
            pForm.add(new JLabel(label[i]), g);
            g.gridx = 1; g.weightx = 1; g.fill = GridBagConstraints.HORIZONTAL;
            input[i].setPreferredSize(new Dimension(220, 32));
            pForm.add(input[i], g);
        }

        JPanel pBtn = new JPanel(new GridLayout(2, 3, 8, 8));
        pBtn.add(btnSimpan); pBtn.add(btnUbah); pBtn.add(btnHapus);
        pBtn.add(btnReset); pBtn.add(btnCetak);

        JPanel pLeft = new JPanel(new BorderLayout(0, 10));
        pLeft.add(pForm, BorderLayout.CENTER);
        pLeft.add(pBtn, BorderLayout.SOUTH);

        // Tabel kanan
        JPanel pCari = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pCari.add(new JLabel("Cari:")); pCari.add(txtCari); pCari.add(btnCari);

        tabel.setFillsViewportHeight(true);
        JPanel pRight = new JPanel(new BorderLayout(0, 10));
        pRight.add(pCari, BorderLayout.NORTH);
        pRight.add(new JScrollPane(tabel), BorderLayout.CENTER);

        JPanel body = new JPanel(new BorderLayout(20, 0));
        body.add(pLeft, BorderLayout.WEST);
        body.add(pRight, BorderLayout.CENTER);
        add(body, BorderLayout.CENTER);
    }
}