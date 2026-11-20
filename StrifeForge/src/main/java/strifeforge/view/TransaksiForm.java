package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class TransaksiForm extends JPanel {
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
        new String[]{"ID Trx", "ID Member", "Nama Member", "Paket", "Total", "Metode", "Tanggal"}, 0
    );
    public JTable tblTransaksi = new JTable(tableModel);
    public JLabel lblTotalOmzet = new JLabel("Total Pendapatan: Rp 0");

    public TransaksiForm() {
        UI.siapkan(this, "Transaksi & Pembayaran");

        JPanel pForm = UI.form("Form Transaksi",
            new String[]{"Member", "Paket", "Metode"},
            new JComponent[]{cbMember, cbPaket, cbMetode});

        JPanel right = new JPanel(new BorderLayout(0, 10));
        right.setBorder(BorderFactory.createTitledBorder("Riwayat Transaksi"));
        tblTransaksi.setFillsViewportHeight(true);
        right.add(new JScrollPane(tblTransaksi), BorderLayout.CENTER);
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footer.add(lblTotalOmzet);
        right.add(footer, BorderLayout.SOUTH);

        JPanel body = new JPanel(new BorderLayout(20, 0));
        body.add(UI.kiri(pForm, UI.tombol(btnBayar)), BorderLayout.WEST);
        body.add(right, BorderLayout.CENTER);
        add(body, BorderLayout.CENTER);
    }

    public void setAksiBayar(ActionListener l) { btnBayar.addActionListener(l); }
    public void setAksiReset(ActionListener l) { btnReset.addActionListener(l); }
    public void setAksiKembali(ActionListener l) { btnKembali.addActionListener(l); }
}