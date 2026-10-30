package strifeforge;

public class Paket {
    private String idPaket;
    private String namaPaket;
    private int durasiHari;
    private double harga;

    public Paket(String idPaket, String namaPaket, int durasiHari, double harga) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        this.durasiHari = durasiHari;
        this.harga = harga;
    }

    public String getIdPaket() { return idPaket; }
    public String getNamaPaket() { return namaPaket; }
    public int getDurasiHari() { return durasiHari; }
    public double getHarga() { return harga; }

    public void setNamaPaket(String namaPaket) { this.namaPaket = namaPaket; }
    public void setDurasiHari(int durasiHari) { this.durasiHari = durasiHari; }
    public void setHarga(double harga) { this.harga = harga; }
}