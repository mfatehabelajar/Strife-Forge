package strifeforge;

public class Instruktur extends Person {
    private String spesialisasi;

    public Instruktur(String id, String nama, String noTelepon, String spesialisasi) {
        super(id, nama, noTelepon);
        this.spesialisasi = spesialisasi;
    }

    public String getSpesialisasi() { return spesialisasi; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[INSTRUKTUR] ID: %s | Nama: %s | Spesialisasi: %s\n", id, nama, spesialisasi);
    }
}