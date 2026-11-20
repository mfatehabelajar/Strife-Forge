package strifeforge;

import java.util.Scanner;

public class Input {
    private static final Scanner s = new Scanner(System.in);

    public static String getString(String p) {
        System.out.print(p);
        return s.nextLine().trim();
    }

    public static int getInt(String p) {
        System.out.print(p);
        return Integer.parseInt(s.nextLine().trim());
    }
}