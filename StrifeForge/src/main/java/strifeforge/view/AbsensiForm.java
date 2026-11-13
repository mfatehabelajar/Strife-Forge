package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AbsensiForm extends JFrame {
    public JTextField txtIdMember = new JTextField(12);
    public JTextField txtCari = new JTextField(15);
    
    public JButton btnCheckIn = new JButton("Check-In");
    public JButton btnCari = new JButton("Cari");
    public JButton btnRefresh = new JButton("Refresh");
    public JButton btnKembali = new JButton("Kembali");

    public DefaultTableModel model = new DefaultTableModel(
        new String[]{"ID Absen", "ID Member", "Nama Member", "Waktu Masuk"}, 0
    );
    public JTable tabel = new JTable(model);
    public JLabel lblTotal = new JLabel("Total Kunjungan: 0");

    public AbsensiForm() {
        setTitle("Absensi & Check-in Kunjungan");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Atas: Input Check-in
        JPanel pTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pTop.setBorder(BorderFactory.createTitledBorder("Form Check-In"));
        pTop.add(new JLabel("ID Member:"));
        pTop.add(txtIdMember);
        pTop.add(btnCheckIn);
        pTop.add(btnKembali);
        add(pTop, BorderLayout.NORTH);

        // Panel Tengah: Tabel & Cari
        JPanel pCenter = new JPanel(new BorderLayout());
        pCenter.setBorder(BorderFactory.createTitledBorder("Riwayat Kunjungan"));

        JPanel pCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pCari.add(new JLabel("Cari:"));
        pCari.add(txtCari);
        pCari.add(btnCari);
        pCari.add(btnRefresh);

        pCenter.add(pCari, BorderLayout.NORTH);
        pCenter.add(new JScrollPane(tabel), BorderLayout.CENTER);
        
        JPanel pFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pFooter.add(lblTotal);
        pCenter.add(pFooter, BorderLayout.SOUTH);

        add(pCenter, BorderLayout.CENTER);
    }
}