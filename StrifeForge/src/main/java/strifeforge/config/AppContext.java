package strifeforge.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {
    
    private static ApplicationContext context;

    // Blok statis ini akan otomatis dijalankan sekali saat aplikasi pertama kali di-run
    static {
        try {
            // Membaca file applicationContext.xml dari folder src/main/resources
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            System.out.println("Spring ApplicationContext berhasil dimuat!");
        } catch (Exception e) {
            System.err.println("Gagal memuat Spring ApplicationContext: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Fungsi untuk mendapatkan objek context (jika dibutuhkan)
    public static ApplicationContext getContext() {
        return context;
    }

    // Fungsi pembantu (helper) agar kita gampang memanggil DAO / Service
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}