package strifeforge;

import java.time.LocalDate;

public class Pembayaran {
    private String idTransaksi;
    private String idMember;
    private String namaMember;
    private String namaPaket;
    private double jumlah;
    private String metode;
    private LocalDate tanggalTransaksi;

    public Pembayaran(String idTransaksi, String idMember, String namaMember, String namaPaket, double jumlah, String metode) {
        this.idTransaksi = idTransaksi;
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.namaPaket = namaPaket;
        this.jumlah = jumlah;
        this.metode = metode;
        this.tanggalTransaksi = LocalDate.now();
    }

    public String getIdTransaksi() { return idTransaksi; }
    public String getIdMember() { return idMember; }
    public String getNamaMember() { return namaMember; }
    public String getNamaPaket() { return namaPaket; }
    public double getJumlah() { return jumlah; }
    public String getMetode() { return metode; }
    public LocalDate getTanggalTransaksi() { return tanggalTransaksi; }
}