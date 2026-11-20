package strifeforge.controller;

import strifeforge.model.Member;
import strifeforge.service.MemberService;
import strifeforge.view.MemberForm;
import strifeforge.config.AppContext;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.Connection;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class MemberController {
    private MemberForm view;
    private MemberService service = new MemberService();

    public MemberController(MemberForm view, Member model) {
        this.view = view;
        loadTable();

        // Simpan member baru
        view.btnSimpan.addActionListener(e -> {
            if (view.txtNama.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nama member wajib diisi!");
                return;
            }
            Member m = new Member();
            m.setNama(view.txtNama.getText().trim());
            m.setNoTelp(view.txtTelp.getText().trim());
            m.setJenisKelamin(view.cbJk.getSelectedItem().toString());
            m.setAlamat(view.txtAlamat.getText().trim());
            m.setTanggalLahir(view.txtTglLahir.getText().trim());
            m.setStatus(view.cbStatus.getSelectedItem().toString());
            service.simpanMember(m);
            JOptionPane.showMessageDialog(view, "Member berhasil disimpan!");
            kosongkanForm();
            loadTable();
        });

        // Klik baris tabel untuk mengisi form
        view.tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int r = view.tabel.getSelectedRow();
                if (r == -1) return;
                view.txtId.setText(String.valueOf(view.tabel.getValueAt(r, 0)));
                view.txtNama.setText(String.valueOf(view.tabel.getValueAt(r, 1)));
                view.txtTelp.setText(String.valueOf(view.tabel.getValueAt(r, 2)));
                view.cbJk.setSelectedItem(String.valueOf(view.tabel.getValueAt(r, 3)));
                view.txtAlamat.setText(String.valueOf(view.tabel.getValueAt(r, 4)));
                view.txtTglLahir.setText(String.valueOf(view.tabel.getValueAt(r, 5)));
                view.cbStatus.setSelectedItem(String.valueOf(view.tabel.getValueAt(r, 6)));
            }
        });

        // Ubah member terpilih
        view.btnUbah.addActionListener(e -> {
            if (view.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Pilih member dari tabel dulu!");
                return;
            }
            Member m = new Member();
            m.setId(Long.parseLong(view.txtId.getText()));
            m.setNama(view.txtNama.getText().trim());
            m.setNoTelp(view.txtTelp.getText().trim());
            m.setJenisKelamin(view.cbJk.getSelectedItem().toString());
            m.setAlamat(view.txtAlamat.getText().trim());
            m.setTanggalLahir(view.txtTglLahir.getText().trim());
            m.setStatus(view.cbStatus.getSelectedItem().toString());
            service.simpanMember(m);
            JOptionPane.showMessageDialog(view, "Member berhasil diubah!");
            kosongkanForm();
            loadTable();
        });

        // Hapus member terpilih
        view.btnHapus.addActionListener(e -> {
            if (view.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Pilih member dari tabel dulu!");
                return;
            }
            int yakin = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus member ini?",
                    "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (yakin == JOptionPane.YES_OPTION) {
                service.hapusMember(Long.parseLong(view.txtId.getText()));
                JOptionPane.showMessageDialog(view, "Member berhasil dihapus!");
                kosongkanForm();
                loadTable();
            }
        });

        // Reset form
        view.btnReset.addActionListener(e -> kosongkanForm());

        // Cetak Laporan (JasperReports)
        view.btnCetak.addActionListener(e -> {
            try {
                DataSource dataSource = AppContext.getBean(DataSource.class);
                Connection conn = dataSource.getConnection();

                String pathDesain = new File("src/main/resources/reports/LaporanMember.jrxml").getAbsolutePath();

                JasperReport jr = JasperCompileManager.compileReport(pathDesain);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);

                JasperViewer.viewReport(jp, false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Gagal mencetak laporan:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }

    private void kosongkanForm() {
        view.txtId.setText("");
        view.txtNama.setText("");
        view.txtTelp.setText("");
        view.txtAlamat.setText("");
        view.txtTglLahir.setText("");
        view.cbJk.setSelectedIndex(0);
        view.cbStatus.setSelectedIndex(0);
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tabel.getModel();
        t.setRowCount(0);
        for (Member m : service.getSemuaMember()) {
            t.addRow(new Object[]{m.getId(), m.getNama(), m.getNoTelp(), m.getJenisKelamin(), m.getAlamat(), m.getTanggalLahir(), m.getStatus()});
        }
    }
}