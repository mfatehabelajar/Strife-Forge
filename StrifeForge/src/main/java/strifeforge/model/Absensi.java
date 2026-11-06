package strifeforge.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "absensi")
public class Absensi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_member")
    private int idMember;

    @Column(name = "nama_member")
    private String namaMember;

    @Column(name = "waktu_kunjungan")
    private LocalDateTime waktuKunjungan = LocalDateTime.now();

    public Absensi() {}

    public Absensi(int idMember, String namaMember) {
        this.idMember = idMember;
        this.namaMember = namaMember;
    }

    public Absensi(String idAbsensiStr, int idMember, String namaMember, LocalDateTime waktuKunjungan) {
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.waktuKunjungan = waktuKunjungan;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getIdAbsensi() { return "ABS" + String.format("%04d", id != null ? id : 1); }
    public int getIdMember() { return idMember; }
    public void setIdMember(int idMember) { this.idMember = idMember; }
    
    public String getNamaMember() { return namaMember; }
    public void setNamaMember(String namaMember) { this.namaMember = namaMember; }
    
    public LocalDateTime getWaktuKunjungan() { return waktuKunjungan; }
    public void setWaktuKunjungan(LocalDateTime waktuKunjungan) { this.waktuKunjungan = waktuKunjungan; }

    public String getFormattedWaktu() {
        if (waktuKunjungan == null) return "-";
        return waktuKunjungan.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}