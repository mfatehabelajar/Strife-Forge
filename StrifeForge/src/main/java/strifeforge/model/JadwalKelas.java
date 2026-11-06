package strifeforge.model;

import javax.persistence.*;

@Entity
@Table(name = "jadwal_kelas")
public class JadwalKelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String namaKelas;
    private String instruktur;
    private String hari;
    private String jam;
    private int kuota;

    public JadwalKelas() {}

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNamaKelas() { return namaKelas; }
    public void setNamaKelas(String namaKelas) { this.namaKelas = namaKelas; }
    public String getInstruktur() { return instruktur; }
    public void setInstruktur(String instruktur) { this.instruktur = instruktur; }
    public String getHari() { return hari; }
    public void setHari(String hari) { this.hari = hari; }
    public String getJam() { return jam; }
    public void setJam(String jam) { this.jam = jam; }
    public int getKuota() { return kuota; }
    public void setKuota(int kuota) { this.kuota = kuota; }
}