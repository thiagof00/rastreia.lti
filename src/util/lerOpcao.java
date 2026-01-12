package util;

import java.util.Scanner;

public class lerOpcao {

    private static final Scanner scanner = new Scanner(System.in);

    private lerOpcao() {
        // impede instanciação
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
