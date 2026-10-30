package strifeforge;

public abstract class Person {
    protected String id;
    protected String nama;
    protected String noTelepon;

    public Person(String id, String nama, String noTelepon) {
        this.id = id;
        this.nama = nama;
        this.noTelepon = noTelepon;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getNoTelepon() { return noTelepon; }
    public void setNama(String nama) { this.nama = nama; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    public abstract void tampilkanInfo();
}