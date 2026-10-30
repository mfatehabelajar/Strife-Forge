package strifeforge;

import java.util.ArrayList;
import java.util.List;

public class JadwalService {
    private List<JadwalKelas> jadwal = new ArrayList<>();

    public JadwalService() {
        jadwal.add(new JadwalKelas("KLS01", "Body Combat & HIIT", "Coach Adrian", "Senin", "19:00 - 20:30", 15));
        jadwal.add(new JadwalKelas("KLS02", "Power Yoga", "Coach Jessica", "Rabu", "18:30 - 20:00", 20));
        jadwal.add(new JadwalKelas("KLS03", "Zumba Dance Fitness", "Coach Maya", "Jumat", "19:30 - 21:00", 25));
    }

    public List<JadwalKelas> getDaftarJadwal() { return jadwal; }

    public void tambahJadwal(String id, String nama, String inst, String hari, String jam, int kuota) {
        jadwal.add(new JadwalKelas(id, nama, inst, hari, jam, kuota));
        System.out.println("[Sukses] Jadwal kelas berhasil ditambahkan.");
    }

    public boolean ikutiKelas(String idKelas) {
        for (JadwalKelas jk : jadwal) {
            if (jk.getIdKelas().equalsIgnoreCase(idKelas)) {
                return jk.tambahPeserta();
            }
        }
        return false;
    }
}