package strifeforge.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "id_member")
    private Long idMember;
    
    @Column(name = "nama_member")
    private String namaMember;
    
    @Column(name = "nama_paket")
    private String namaPaket;
    
    private double jumlah;
    private String metode;
    
    @Column(name = "tanggal_transaksi")
    private LocalDate tanggalTransaksi = LocalDate.now();

    public Pembayaran() {}

    public String getIdTransaksi() { return "TRX" + String.format("%04d", id != null ? id : 1); }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdMember() { return idMember; }
    public void setIdMember(Long idMember) { this.idMember = idMember; }
    public String getNamaMember() { return namaMember; }
    public void setNamaMember(String namaMember) { this.namaMember = namaMember; }
    public String getNamaPaket() { return namaPaket; }
    public void setNamaPaket(String namaPaket) { this.namaPaket = namaPaket; }
    public double getJumlah() { return jumlah; }
    public void setJumlah(double jumlah) { this.jumlah = jumlah; }
    public String getMetode() { return metode; }
    public void setMetode(String metode) { this.metode = metode; }
    public LocalDate getTanggalTransaksi() { return tanggalTransaksi; }
    public void setTanggalTransaksi(LocalDate tanggalTransaksi) { this.tanggalTransaksi = tanggalTransaksi; }
}