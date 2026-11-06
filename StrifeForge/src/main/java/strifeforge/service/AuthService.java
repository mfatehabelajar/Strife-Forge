package strifeforge.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import strifeforge.config.Koneksi;
import strifeforge.model.User;

public class AuthService {
    private static User currentUser = null;

    public boolean login(String username, String password) {
        Session session = Koneksi.getSessionFactory().openSession();
        Query<User> query = session.createQuery(
            "FROM User WHERE username = :u AND password = :p", User.class
        );
        query.setParameter("u", username);
        query.setParameter("p", password);
        
        User user = query.uniqueResult();
        session.close();

        if (user != null) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }
}