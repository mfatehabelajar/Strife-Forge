package strifeforge;

import java.util.ArrayList;
import java.util.List;

public class AbsensiService {
    private List<Absensi> logAbsensi = new ArrayList<>();
    private int counterAbsensi = 1;

    public boolean checkIn(Member member) {
        if (!member.isAktif()) {
            System.out.printf("[DITOLAK] Check-in gagal! Masa aktif keanggotaan ID: %s (%s) telah habis.\n", 
                    member.getId(), member.getNama());
            return false;
        }

        String idAbs = String.format("ABS%04d", counterAbsensi++);
        Absensi a = new Absensi(idAbs, member.getId(), member.getNama());
        logAbsensi.add(a);
        System.out.printf("[BERHASIL] Check-in tercatat! ID: %s | Waktu: %s\n", member.getId(), a.getFormattedWaktu());
        return true;
    }

    public List<Absensi> getLogAbsensi() { return logAbsensi; }
}