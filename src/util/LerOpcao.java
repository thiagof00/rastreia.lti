package util;

import java.util.Scanner;

public class LerOpcao {

    private static final Scanner scanner = new Scanner(System.in);

    private LerOpcao() {
    }

    public static int lerInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static String lerString() {
        return scanner.nextLine();
    }
}
