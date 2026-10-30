package strifeforge;

import java.util.ArrayList;
import java.util.List;

public class PaketService {
    private List<Paket> daftarPaket = new ArrayList<>();

    public PaketService() {
        daftarPaket.add(new Paket("PKT01", "Harian", 1, 35000));
        daftarPaket.add(new Paket("PKT02", "Bulanan", 30, 250000));
        daftarPaket.add(new Paket("PKT03", "3 Bulan", 90, 650000));
        daftarPaket.add(new Paket("PKT04", "Tahunan", 365, 2200000));
    }

    public List<Paket> getDaftarPaket() { return daftarPaket; }

    public Paket cariPaketById(String id) {
        for (Paket p : daftarPaket) {
            if (p.getIdPaket().equalsIgnoreCase(id)) return p;
        }
        return null;
    }

    public void tambahPaket(String id, String nama, int durasi, double harga) {
        daftarPaket.add(new Paket(id, nama, durasi, harga));
        System.out.println("[Sukses] Paket keanggotaan berhasil ditambahkan.");
    }
}