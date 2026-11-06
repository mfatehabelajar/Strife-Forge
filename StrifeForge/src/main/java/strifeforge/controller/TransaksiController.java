package strifeforge.controller;

import strifeforge.model.Member;
import strifeforge.model.Paket;
import strifeforge.model.Pembayaran;
import strifeforge.service.MemberService;
import strifeforge.service.PaketService;
import strifeforge.service.TransaksiService;
import strifeforge.view.TransaksiForm;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;

public class TransaksiController {
    private TransaksiForm view;
    private TransaksiService service = new TransaksiService();
    private MemberService memberService = new MemberService();
    private PaketService paketService = new PaketService();
    
    private List<Member> listMember;
    private List<Paket> listPaket;

    public TransaksiController(TransaksiForm view) {
        this.view = view;
        loadCombo();
        loadTable();

        view.btnBayar.addActionListener(e -> prosesTransaksi());
        view.btnKembali.addActionListener(e -> view.dispose());
    }

    private void loadCombo() {
        view.cbMember.removeAllItems();
        listMember = memberService.getSemuaMember();
        for (Member m : listMember) {
            view.cbMember.addItem(m.getId() + " - " + m.getNama());
        }

        view.cbPaket.removeAllItems();
        listPaket = paketService.getDaftarPaket();
        for (Paket p : listPaket) {
            view.cbPaket.addItem(p.getIdPaket() + " - " + p.getNamaPaket());
        }
    }

    public void loadTable() {
        DefaultTableModel t = (DefaultTableModel) view.tblTransaksi.getModel();
        t.setRowCount(0);
        for (Pembayaran p : service.getRiwayatTransaksi()) {
            t.addRow(new Object[]{
                p.getIdTransaksi(), 
                p.getIdMember(), 
                p.getNamaMember(), 
                p.getNamaPaket(), 
                p.getJumlah(), 
                p.getMetode(), 
                p.getTanggalTransaksi()
            });
        }
        view.lblTotalOmzet.setText("Total Omzet: Rp " + service.hitungTotalPendapatan());
    }

    private void prosesTransaksi() {
        try {
            int idxMember = view.cbMember.getSelectedIndex();
            int idxPaket = view.cbPaket.getSelectedIndex();

            if (idxMember == -1 || idxPaket == -1) {
                JOptionPane.showMessageDialog(view, "Pilih Member dan Paket terlebih dahulu!");
                return;
            }

            Member m = listMember.get(idxMember);
            Paket p = listPaket.get(idxPaket);
            String metode = view.cbMetode.getSelectedItem().toString();

            Pembayaran trx = new Pembayaran();
            trx.setIdMember(m.getIdLong());
            trx.setNamaMember(m.getNama());
            trx.setNamaPaket(p.getNamaPaket());
            trx.setJumlah(p.getHarga());
            trx.setMetode(metode);
            trx.setTanggalTransaksi(LocalDate.now());

            service.simpanTransaksi(trx);
            JOptionPane.showMessageDialog(view, "Transaksi & Pendaftaran Berhasil!");
            loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Gagal memproses transaksi: " + ex.getMessage());
        }
    }
}