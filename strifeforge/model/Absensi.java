package strifeforge;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Absensi {
    private String idAbsensi;
    private String idMember;
    private String namaMember;
    private LocalDateTime waktu;

    public Absensi(String idAbsensi, String idMember, String namaMember) {
        this.idAbsensi = idAbsensi;
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.waktu = LocalDateTime.now();
    }

    public String getIdAbsensi() { return idAbsensi; }
    public String getIdMember() { return idMember; }
    public String getNamaMember() { return namaMember; }
    public LocalDateTime getWaktu() { return waktu; }

    public String getFormattedWaktu() {
        return waktu.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}