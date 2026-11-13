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

        view.btnSimpan.addActionListener(e -> {
            Member m = new Member();
            m.setNama(view.txtNama.getText());
            m.setNoTelp(view.txtTelp.getText());
            m.setJenisKelamin(view.cbJk.getSelectedItem().toString());
            m.setAlamat(view.txtAlamat.getText());
            m.setTanggalLahir(view.txtTglLahir.getText());
            service.simpanMember(m);
            JOptionPane.showMessageDialog(view, "Member berhasil disimpan!");
            loadTable();
        });

        view.btnHapus.addActionListener(e -> {
            if (!view.txtId.getText().isEmpty()) {
                service.hapusMember(Long.parseLong(view.txtId.getText()));
                loadTable();
            }
        });

        view.btnKembali.addActionListener(e -> view.dispose());

        // Aksi Tombol Cetak Laporan
        view.btnCetak.addActionListener(e -> {
            try {
                // 1. Ambil koneksi database lewat Spring ApplicationContext
                DataSource dataSource = AppContext.getBean(DataSource.class);
                Connection conn = dataSource.getConnection();
                
                // 2. Cari path file Jasper yang baru dibuat
                String pathDesain = new File("src/main/resources/reports/LaporanMember.jrxml").getAbsolutePath();
                
                // 3. Compile dan Fill report
                JasperReport jr = JasperCompileManager.compileReport(pathDesain);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
                
                // 4. Tampilkan pratinjau laporan
                JasperViewer.viewReport(jp, false);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Gagal mencetak laporan:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tabel.getModel();
        t.setRowCount(0);
        for (Member m : service.getSemuaMember()) {
            t.addRow(new Object[]{m.getId(), m.getNama(), m.getNoTelp(), m.getJenisKelamin(), m.getAlamat(), m.getTanggalLahir(), m.getStatus()});
        }
    }
}