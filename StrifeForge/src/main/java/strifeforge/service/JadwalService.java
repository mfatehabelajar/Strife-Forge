package strifeforge.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import strifeforge.config.Koneksi;
import strifeforge.model.JadwalKelas;
import java.util.List;

public class JadwalService {

    public List<JadwalKelas> getDaftarJadwal() {
        Session session = Koneksi.getSessionFactory().openSession();
        List<JadwalKelas> list = session.createQuery("FROM JadwalKelas", JadwalKelas.class).getResultList();
        session.close();
        return list;
    }

    public void simpanJadwal(JadwalKelas jadwal) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(jadwal);
        tx.commit();
        session.close();
    }

    public void hapusJadwal(Long id) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        JadwalKelas j = session.get(JadwalKelas.class, id);
        if (j != null) session.delete(j);
        tx.commit();
        session.close();
    }
}