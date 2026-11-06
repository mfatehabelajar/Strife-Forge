package strifeforge.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nama;
    @Column(name = "no_telp")
    private String noTelp;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    private String alamat;
    @Column(name = "tanggal_lahir")
    private String tanggalLahir;
    private String status = "Aktif";
    
    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;
    
    @Column(name = "tanggal_berakhir")
    private LocalDate tanggalBerakhir;

    public Member() {}

    public boolean isAktif() {
        return status != null && status.equalsIgnoreCase("Aktif");
    }

    public int getIdInt() {
        return id != null ? id.intValue() : 0;
    }

    // Getter & Setter
    public Long getIdLong() { return id; }
    public String getId() { return String.valueOf(id); }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(LocalDate tanggalMulai) { this.tanggalMulai = tanggalMulai; }
    public LocalDate getTanggalBerakhir() { return tanggalBerakhir; }
    public void setTanggalBerakhir(LocalDate tanggalBerakhir) { this.tanggalBerakhir = tanggalBerakhir; }
}