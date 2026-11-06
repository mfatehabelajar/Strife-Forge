package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class TransaksiForm extends JFrame {
    public JComboBox<String> cbMember = new JComboBox<>();
    public JComboBox<String> cbPaket = new JComboBox<>();
    public JComboBox<String> cbMetode = new JComboBox<>(new String[]{"Tunai", "Transfer", "QRIS"});
    
    public JTextField txtHarga = new JTextField();
    public JTextField txtDurasi = new JTextField();
    public JTextField txtTglMulai = new JTextField();
    public JTextField txtTglBerakhir = new JTextField();

    public JButton btnBayar = new JButton("Bayar");
    public JButton btnReset = new JButton("Reset");
    public JButton btnKembali = new JButton("Kembali");
    public JButton btnCetakUlang = new JButton("Cetak Struk");

    public DefaultTableModel tableModel = new DefaultTableModel(
        new String[]{"ID Trx", "Member", "Paket", "Total", "Metode", "Tanggal"}, 0
    );
    public JTable tblTransaksi = new JTable(tableModel);
    public JLabel lblTotalOmzet = new JLabel("Total Pendapatan: Rp 0");

    public TransaksiForm() {
        setTitle("Transaksi & Pembayaran");
        setSize(900, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Kiri (Form)
        JPanel left = new JPanel(new GridLayout(8, 2, 5, 5));
        left.setBorder(BorderFactory.createTitledBorder("Form Transaksi"));
        
        txtHarga.setEditable(false);
        txtDurasi.setEditable(false);
        txtTglMulai.setEditable(false);
        txtTglBerakhir.setEditable(false);

        left.add(new JLabel("Member:")); left.add(cbMember);
        left.add(new JLabel("Paket:")); left.add(cbPaket);
        left.add(new JLabel("Durasi:")); left.add(txtDurasi);
        left.add(new JLabel("Harga:")); left.add(txtHarga);
        left.add(new JLabel("Tgl Mulai:")); left.add(txtTglMulai);
        left.add(new JLabel("Tgl Berakhir:")); left.add(txtTglBerakhir);
        left.add(new JLabel("Metode:")); left.add(cbMetode);

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnBayar);
        btnPanel.add(btnReset);
        btnPanel.add(btnKembali);

        JPanel west = new JPanel(new BorderLayout());
        west.add(left, BorderLayout.CENTER);
        west.add(btnPanel, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);

        // Panel Kanan (Tabel)
        JPanel right = new JPanel(new BorderLayout());
        right.setBorder(BorderFactory.createTitledBorder("Riwayat Transaksi"));
        right.add(new JScrollPane(tblTransaksi), BorderLayout.CENTER);

        JPanel footer = new JPanel(new BorderLayout());
        footer.add(lblTotalOmzet, BorderLayout.WEST);
        footer.add(btnCetakUlang, BorderLayout.EAST);
        right.add(footer, BorderLayout.SOUTH);

        add(right, BorderLayout.CENTER);
    }

    // Shortcut Listener biar gampang dipanggil di Controller
    public void setAksiBayar(ActionListener l) { btnBayar.addActionListener(l); }
    public void setAksiReset(ActionListener l) { btnReset.addActionListener(l); }
    public void setAksiKembali(ActionListener l) { btnKembali.addActionListener(l); }
}