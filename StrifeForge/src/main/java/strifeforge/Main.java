package strifeforge;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import strifeforge.controller.LoginController;
import strifeforge.model.User;
import strifeforge.view.LoginForm;

import java.awt.Color;
import java.util.Collections;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#8B5CF6"));
        FlatDarkLaf.setup();
        UIManager.put("Component.arc", 10);
        UIManager.put("Button.arc", 10);
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Table.rowHeight", 28);
        UIManager.put("Table.alternateRowColor", new Color(0x2A2A3C));
        UIManager.put("TableHeader.background", new Color(0x4C1D95));
        UIManager.put("TableHeader.foreground", Color.WHITE);

        SwingUtilities.invokeLater(() -> {
            LoginForm f = new LoginForm();
            new LoginController(f, new User());
            f.setVisible(true);
        });
    }
}