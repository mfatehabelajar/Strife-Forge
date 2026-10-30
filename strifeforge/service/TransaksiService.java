package strifeforge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransaksiService {
    private List<Pembayaran> riwayatTransaksi = new ArrayList<>();
    private int counterTrx = 1;

    public Pembayaran prosesPendaftaranDanBayar(Member member, Paket paket, String metode) {
        LocalDate mulai;
        LocalDate berakhir;

        // Jika masa aktif masih berlaku, lakukan akumulasi perpanjangan
        if (member.isAktif() && member.getTanggalBerakhir() != null) {
            mulai = member.getTanggalBerakhir().plusDays(1);
            berakhir = mulai.plusDays(paket.getDurasiHari());
        } else {
            mulai = LocalDate.now();
            berakhir = mulai.plusDays(paket.getDurasiHari());
        }

        // Perbarui atribut member
        member.setPaket(paket.getNamaPaket(), mulai, berakhir);

        // Catat entri pembayaran
        String idTrx = String.format("TRX%04d", counterTrx++);
        Pembayaran p = new Pembayaran(idTrx, member.getId(), member.getNama(), paket.getNamaPaket(), paket.getHarga(), metode);
        riwayatTransaksi.add(p);

        return p;
    }

    public List<Pembayaran> getRiwayatTransaksi() { return riwayatTransaksi; }

    public double hitungTotalPendapatan() {
        double total = 0;
        for (Pembayaran p : riwayatTransaksi) {
            total += p.getJumlah();
        }
        return total;
    }

    public void cetakStruk(Pembayaran p) {
        System.out.println("=========================================");
        System.out.println("           STRIFE FORGE FITNESS          ");
        System.out.println("        BUKTI PEMBAYARAN RESMI           ");
        System.out.println("=========================================");
        System.out.printf("No. Transaksi : %s\n", p.getIdTransaksi());
        System.out.printf("Tanggal       : %s\n", p.getTanggalTransaksi());
        System.out.printf("ID Member     : %s\n", p.getIdMember());
        System.out.printf("Nama Member   : %s\n", p.getNamaMember());
        System.out.printf("Paket Dipilih : %s\n", p.getNamaPaket());
        System.out.printf("Metode Bayar  : %s\n", p.getMetode());
        System.out.println("-----------------------------------------");
        System.out.printf("Total Tagihan : Rp %,.2f\n", p.getJumlah());
        System.out.println("Status        : LUNAS");
        System.out.println("=========================================");
    }
}