package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class DashboardForm extends JFrame {
    public JButton btnMember = menuBtn("Manajemen Member");
    public JButton btnPaket = menuBtn("Manajemen Paket");
    public JButton btnTransaksi = menuBtn("Transaksi & Pembayaran");
    public JButton btnAbsensi = menuBtn("Absensi Kunjungan");
    public JButton btnJadwal = menuBtn("Jadwal Kelas");
    public JButton btnLogout = menuBtn("Logout");

    private final CardLayout card = new CardLayout();
    private final JPanel content = new JPanel(card);

    public DashboardForm() {
        setTitle("Strife Forge Gym");
        setSize(1200, 700);
        setMinimumSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar
        JPanel side = new JPanel();
        side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));
        side.setBackground(new Color(0x1E1B2E));
        side.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        side.setPreferredSize(new Dimension(240, 0));

        JLabel logo = new JLabel("STRIFE FORGE");
        logo.setFont(logo.getFont().deriveFont(Font.BOLD, 20f));
        logo.setForeground(new Color(0xA78BFA));
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);
        side.add(logo);
        side.add(Box.createVerticalStrut(25));

        for (JButton b : new JButton[]{btnMember, btnPaket, btnTransaksi, btnAbsensi, btnJadwal}) {
            side.add(b);
            side.add(Box.createVerticalStrut(8));
        }
        side.add(Box.createVerticalGlue());
        side.add(btnLogout);

        // Halaman awal
        JLabel welcome = new JLabel("Selamat Datang di Dashboard Strife Forge Gym", SwingConstants.CENTER);
        welcome.setFont(welcome.getFont().deriveFont(Font.BOLD, 22f));
        content.add(welcome, "home");

        add(side, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
    }

    private static JButton menuBtn(String text) {
        JButton b = new JButton(text);
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setFocusPainted(false);
        return b;
    }

    public void tambahHalaman(String nama, JComponent panel) { content.add(panel, nama); }
    public void tampil(String nama) { card.show(content, nama); }
}