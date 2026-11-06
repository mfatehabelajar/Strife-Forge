package strifeforge.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import strifeforge.config.Koneksi;
import strifeforge.model.Pembayaran;
import java.util.List;

public class TransaksiService {

    public List<Pembayaran> getRiwayatTransaksi() {
        Session session = Koneksi.getSessionFactory().openSession();
        List<Pembayaran> list = session.createQuery("FROM Pembayaran", Pembayaran.class).getResultList();
        session.close();
        return list;
    }

    public void simpanTransaksi(Pembayaran pembayaran) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(pembayaran);
        tx.commit();
        session.close();
    }

    public double hitungTotalPendapatan() {
        Session session = Koneksi.getSessionFactory().openSession();
        Double total = session.createQuery("SELECT SUM(jumlah) FROM Pembayaran", Double.class).uniqueResult();
        session.close();
        return total != null ? total : 0.0;
    }
}