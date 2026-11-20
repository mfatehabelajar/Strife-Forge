package strifeforge.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import strifeforge.config.Koneksi;
import strifeforge.model.Member;
import java.util.List;

public class MemberService {

    public List<Member> getSemuaMember() {
        Session session = Koneksi.getSessionFactory().openSession();
        List<Member> list = session.createQuery("FROM Member", Member.class).getResultList();
        session.close();
        return list;
    }

    public void simpanMember(Member member) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(member);
        tx.commit();
        session.close();
    }

    public void hapusMember(Long id) {
        Session session = Koneksi.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Member m = session.get(Member.class, id);
        if (m != null) session.delete(m);
        tx.commit();
        session.close();
    }
}