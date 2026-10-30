package strifeforge.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;

    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                // Konfigurasi MySQL XAMPP untuk database db_app
                String url = "jdbc:mysql://localhost:3306/db_app";
                String user = "root";
                String pass = "";

                koneksi = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.err.println("Gagal terhubung ke MySQL: " + e.getMessage());
            }
        }
        return koneksi;
    }
}