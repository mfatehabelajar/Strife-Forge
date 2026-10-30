package strifeforge.model;

import strifeforge.config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String id;
    private String nama;
    private String noTelp;
    private String username;
    private String password;
    private String role;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String id, String nama, String noTelp, String username, String password, String role) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Validasi login via JDBC MySQL (tabel users)
    public boolean login(String usernameInput, String passwordInput) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection conn = Koneksi.getConnection();

        if (conn == null) {
            return false;
        }

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usernameInput);
            ps.setString(2, passwordInput);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.username = rs.getString("username");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Query Error: " + e.getMessage());
        }
        return false;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}