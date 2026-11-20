package strifeforge.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AbsensiForm extends JPanel {
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
        UI.siapkan(this, "Absensi & Check-in Kunjungan");

        JPanel pTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pTop.setBorder(BorderFactory.createTitledBorder("Form Check-In"));
        pTop.add(new JLabel("ID Member:"));
        pTop.add(txtIdMember);
        pTop.add(btnCheckIn);

        JPanel pTabel = new JPanel(new BorderLayout(0, 10));
        pTabel.setBorder(BorderFactory.createTitledBorder("Riwayat Kunjungan"));
        JPanel pAtas = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pAtas.add(btnRefresh);
        pTabel.add(pAtas, BorderLayout.NORTH);
        tabel.setFillsViewportHeight(true);
        pTabel.add(new JScrollPane(tabel), BorderLayout.CENTER);
        JPanel pFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pFooter.add(lblTotal);
        pTabel.add(pFooter, BorderLayout.SOUTH);

        JPanel body = new JPanel(new BorderLayout(0, 15));
        body.add(pTop, BorderLayout.NORTH);
        body.add(pTabel, BorderLayout.CENTER);
        add(body, BorderLayout.CENTER);
    }
}