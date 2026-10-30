package strifeforge;

public class JadwalKelas {
    private String idKelas;
    private String namaKelas;
    private String instruktur;
    private String hari;
    private String jam;
    private int kuota;
    private int terisi;

    public JadwalKelas(String idKelas, String namaKelas, String instruktur, String hari, String jam, int kuota) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.instruktur = instruktur;
        this.hari = hari;
        this.jam = jam;
        this.kuota = kuota;
        this.terisi = 0;
    }

    public String getIdKelas() { return idKelas; }
    public String getNamaKelas() { return namaKelas; }
    public String getInstruktur() { return instruktur; }
    public String getHari() { return hari; }
    public String getJam() { return jam; }
    public int getKuota() { return kuota; }
    public int getTerisi() { return terisi; }

    public boolean tambahPeserta() {
        if (terisi < kuota) {
            terisi++;
            return true;
        }
        return false;
    }
}