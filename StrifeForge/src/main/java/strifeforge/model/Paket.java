package strifeforge.model;

import javax.persistence.*;

@Entity
@Table(name = "pakets")
public class Paket {
    @Id
    @Column(name = "id_paket")
    private String idPaket;

    @Column(name = "nama_paket")
    private String namaPaket;

    @Column(name = "durasi_hari")
    private int durasiHari;

    private double harga;

    public Paket() {}

    public Paket(String idPaket, String namaPaket, int durasiHari, double harga) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.durasiHari = durasiHari;
        this.harga = harga;
    }

    // Getter dan Setter
    public String getIdPaket() { return idPaket; }
    public void setIdPaket(String idPaket) { this.idPaket = idPaket; }
    
    public String getNamaPaket() { return namaPaket; }
    public void setNamaPaket(String namaPaket) { this.namaPaket = namaPaket; }
    
    public int getDurasiHari() { return durasiHari; }
    public void setDurasiHari(int durasiHari) { this.durasiHari = durasiHari; }
    
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
}