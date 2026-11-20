package strifeforge.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import strifeforge.model.Member;

import java.util.List;

@Repository
@Transactional
public class MemberDao {

    // Spring akan menginjeksi SessionFactory secara otomatis (Dependency Injection)
    @Autowired
    private SessionFactory sessionFactory;

    // Method pembantu untuk mendapatkan sesi Hibernate saat ini
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    // Fungsi Simpan atau Update Data
    public void simpan(Member member) {
        getCurrentSession().saveOrUpdate(member);
        // Tidak perlu lagi tx.begin() dan tx.commit() karena sudah diurus @Transactional
    }

    // Fungsi Hapus Data
    public void hapus(Long id) {
        Member member = getCurrentSession().get(Member.class, id);
        if (member != null) {
            getCurrentSession().delete(member);
        }
    }

    // Fungsi Tarik Semua Data
    public List<Member> getSemuaMember() {
        return getCurrentSession().createQuery("FROM Member", Member.class).getResultList();
    }
    
    // Fungsi Cari Data Berdasarkan Nama atau Telepon
    public List<Member> cariMember(String keyword) {
        String hql = "FROM Member WHERE nama LIKE :keyword OR noTelp LIKE :keyword";
        return getCurrentSession().createQuery(hql, Member.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }
}