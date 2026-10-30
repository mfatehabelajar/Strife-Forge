package strifeforge.service;

import strifeforge.model.User;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users = new ArrayList<>();
    private User currentUser = null;

    public AuthService() {
        users.add(new User("USR01", "Administrator Gym", "08123456789", "admin", "admin123", "ADMIN"));
        users.add(new User("USR02", "Petugas Kasir", "08987654321", "petugas", "kasir123", "PETUGAS"));
    }

    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                this.currentUser = u;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}