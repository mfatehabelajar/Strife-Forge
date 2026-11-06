package strifeforge.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import strifeforge.config.Koneksi;
import strifeforge.model.Absensi;
import java.util.List;

public class AbsensiService {

    public boolean checkIn(Absensi absensi) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(absensi);
        tx.commit();
        session.close();
        return true;
    }

    public List<Absensi> getSemuaAbsensi() {
        Session session = Koneksi.getSessionFactory().openSession();
        List<Absensi> list = session.createQuery("FROM Absensi", Absensi.class).getResultList();
        session.close();
        return list;
    }
}