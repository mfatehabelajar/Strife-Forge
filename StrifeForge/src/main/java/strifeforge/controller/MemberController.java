package strifeforge.controller;

import strifeforge.model.Member;
import strifeforge.service.MemberService;
import strifeforge.view.MemberForm;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tabel.getModel();
        t.setRowCount(0);
        for (Member m : service.getSemuaMember()) {
            t.addRow(new Object[]{m.getId(), m.getNama(), m.getNoTelp(), m.getJenisKelamin(), m.getAlamat(), m.getTanggalLahir(), m.getStatus()});
        }
    }
}