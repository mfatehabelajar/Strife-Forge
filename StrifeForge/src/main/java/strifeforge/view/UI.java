package strifeforge.view;

import javax.swing.*;
import java.awt.*;

public class UI {

    // Mengatur panel: layout, padding, dan judul besar di atas
    public static void siapkan(JPanel p, String judul) {
        p.setLayout(new BorderLayout(15, 15));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel l = new JLabel(judul);
        l.setFont(l.getFont().deriveFont(Font.BOLD, 22f));
        p.add(l, BorderLayout.NORTH);
    }

    // Form label + input yang rapi
    public static JPanel form(String title, String[] labels, JComponent[] inputs) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(BorderFactory.createTitledBorder(title));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 8, 6, 8);
        g.anchor = GridBagConstraints.WEST;
        for (int i = 0; i < labels.length; i++) {
            g.gridy = i;
            g.gridx = 0; g.weightx = 0; g.fill = GridBagConstraints.NONE;
            p.add(new JLabel(labels[i]), g);
            g.gridx = 1; g.weightx = 1; g.fill = GridBagConstraints.HORIZONTAL;
            inputs[i].setPreferredSize(new Dimension(220, 32));
            p.add(inputs[i], g);
        }
        return p;
    }

    // Deretan tombol sama lebar
    public static JPanel tombol(JButton... b) {
        JPanel p = new JPanel(new GridLayout(1, b.length, 8, 8));
        for (JButton x : b) p.add(x);
        return p;
    }

    // Kolom kiri: form di atas, tombol di bawahnya, tidak melar ke bawah
    public static JPanel kiri(JPanel form, JPanel tombol) {
        form.setAlignmentX(Component.LEFT_ALIGNMENT);
        tombol.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.add(form);
        box.add(Box.createVerticalStrut(10));
        box.add(tombol);
        JPanel wrap = new JPanel(new BorderLayout());
        wrap.add(box, BorderLayout.NORTH);
        return wrap;
    }
}