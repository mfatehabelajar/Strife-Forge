package strifeforge.controller;

import strifeforge.model.JadwalKelas;
import strifeforge.service.JadwalService;
import strifeforge.view.JadwalForm;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JadwalController {
    private JadwalForm view;
    private JadwalService service = new JadwalService();

    public JadwalController(JadwalForm view) {
        this.view = view;
        loadTable();

        view.btnSimpan.addActionListener(e -> {
            if (view.txtNamaKelas.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nama kelas wajib diisi!");
                return;
            }
            JadwalKelas j = new JadwalKelas();
            j.setNamaKelas(view.txtNamaKelas.getText().trim());
            j.setInstruktur(view.txtInstruktur.getText().trim());
            j.setHari(view.cbHari.getSelectedItem().toString());
            j.setJam(view.txtJam.getText().trim());

            service.simpanJadwal(j);
            JOptionPane.showMessageDialog(view, "Jadwal berhasil disimpan!");
            view.txtNamaKelas.setText("");
            view.txtInstruktur.setText("");
            view.txtJam.setText("");
            loadTable();
        });

        view.btnHapus.addActionListener(e -> {
            int row = view.tblJadwal.getSelectedRow();
            if (row != -1) {
                Long id = Long.parseLong(view.tblJadwal.getValueAt(row, 0).toString());
                service.hapusJadwal(id);
                JOptionPane.showMessageDialog(view, "Jadwal berhasil dihapus!");
                loadTable();
            } else {
                JOptionPane.showMessageDialog(view, "Pilih baris pada tabel terlebih dahulu!");
            }
        });
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tblJadwal.getModel();
        t.setRowCount(0);
        for (JadwalKelas j : service.getDaftarJadwal()) {
            t.addRow(new Object[]{
                j.getId(),
                j.getNamaKelas(),
                j.getInstruktur(),
                j.getHari(),
                j.getJam()
            });
        }
    }
}