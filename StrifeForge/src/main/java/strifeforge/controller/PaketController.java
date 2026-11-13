package strifeforge.controller;

import strifeforge.model.Paket;
import strifeforge.service.PaketService;
import strifeforge.view.PaketForm;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PaketController {
    private PaketForm view;
    private PaketService service = new PaketService();

    public PaketController(PaketForm view, Paket model) {
        this.view = view;
        loadTable();
        initListeners();
    }

    private void initListeners() {
        // Tombol Simpan Paket Baru
        view.btnSimpan.addActionListener(e -> simpanPaket());

        // Tombol Hapus Paket
        view.btnHapus.addActionListener(e -> hapusPaket());

        // Tombol Reset Form
        view.btnReset.addActionListener(e -> {
            view.txtId.setText("");
            view.txtNama.setText("");
            view.txtDurasi.setText("");
            view.txtHarga.setText("");
            loadTable();
        });

        // Tombol Kembali
        view.btnKembali.addActionListener(e -> view.dispose());

        // Klik baris tabel untuk mengisi form secara otomatis
        view.tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = view.tabel.getSelectedRow();
                if (row != -1) {
                    view.txtId.setText(view.tabel.getValueAt(row, 0).toString());
                    view.txtNama.setText(view.tabel.getValueAt(row, 1).toString());
                    view.txtDurasi.setText(view.tabel.getValueAt(row, 2).toString());
                    view.txtHarga.setText(view.tabel.getValueAt(row, 3).toString());
                }
            }
        });
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tabel.getModel();
        t.setRowCount(0);
        for (Paket p : service.getDaftarPaket()) {
            t.addRow(new Object[]{
                p.getIdPaket(), 
                p.getNamaPaket(), 
                p.getDurasiHari(), 
                String.format("Rp %,.0f", p.getHarga())
            });
        }
    }

    private void simpanPaket() {
        try {
            String id = view.txtId.getText().trim();
            String nama = view.txtNama.getText().trim();
            int durasi = Integer.parseInt(view.txtDurasi.getText().trim());
            double harga = Double.parseDouble(view.txtHarga.getText().trim());

            if (id.isEmpty() || nama.isEmpty()) {
                JOptionPane.showMessageDialog(view, "ID dan Nama Paket wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Paket p = new Paket(id, nama, durasi, harga);
            service.simpanPaket(p);
            
            JOptionPane.showMessageDialog(view, "Data paket keanggotaan berhasil disimpan!");
            view.txtId.setText("");
            view.txtNama.setText("");
            view.txtDurasi.setText("");
            view.txtHarga.setText("");
            loadTable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Durasi hari dan Harga harus berupa angka yang valid!", "Error Format", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusPaket() {
        String id = view.txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Pilih paket yang ingin dihapus dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus paket ID: " + id + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            service.hapusPaket(id);
            JOptionPane.showMessageDialog(view, "Paket berhasil dihapus!");
            view.txtId.setText("");
            view.txtNama.setText("");
            view.txtDurasi.setText("");
            view.txtHarga.setText("");
            loadTable();
        }
    }
}