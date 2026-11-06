package strifeforge.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import strifeforge.config.Koneksi;
import strifeforge.model.Paket;
import java.util.List;

public class PaketService {

    public List<Paket> getDaftarPaket() {
        Session session = Koneksi.getSessionFactory().openSession();
        List<Paket> list = session.createQuery("FROM Paket", Paket.class).getResultList();
        session.close();
        return list;
    }

    public void simpanPaket(Paket paket) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(paket);
        tx.commit();
        session.close();
    }

    public void hapusPaket(String id) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Paket p = session.get(Paket.class, id);
        if (p != null) session.delete(p);
        tx.commit();
        session.close();
    }
}