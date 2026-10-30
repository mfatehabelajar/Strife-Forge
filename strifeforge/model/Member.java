package strifeforge;

import java.time.LocalDate;

public class Member extends Person {
    private String jenisKelamin;
    private String alamat;
    private String tanggalLahir;
    private String paketAktif;
    private LocalDate tanggalMulai;
    private LocalDate tanggalBerakhir;

    public Member(String id, String nama, String noTelepon, String jenisKelamin, String alamat, String tanggalLahir) {
        super(id, nama, noTelepon);
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.paketAktif = "Belum Ada";
        this.tanggalMulai = null;
        this.tanggalBerakhir = null;
    }

    public String getJenisKelamin() { return jenisKelamin; }
    public String getAlamat() { return alamat; }
    public String getTanggalLahir() { return tanggalLahir; }
    public String getPaketAktif() { return paketAktif; }
    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public LocalDate getTanggalBerakhir() { return tanggalBerakhir; }

    public void setPaket(String namaPaket, LocalDate mulai, LocalDate berakhir) {
        this.paketAktif = namaPaket;
        this.tanggalMulai = mulai;
        this.tanggalBerakhir = berakhir;
    }

    public boolean isAktif() {
        if (tanggalBerakhir == null) return false;
        return !LocalDate.now().isAfter(tanggalBerakhir);
    }

    @Override
    public void tampilkanInfo() {
        String status = isAktif() ? "AKTIF" : "KADALUWARSA/NON-AKTIF";
        System.out.printf("ID: %-6s | Nama: %-15s | JK: %-2s | Telp: %-12s | Paket: %-10s | Exp: %s (%s)\n",
                id, nama, jenisKelamin, noTelepon, paketAktif, 
                (tanggalBerakhir != null ? tanggalBerakhir.toString() : "-"), status);
    }
}