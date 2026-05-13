package util;

public class Limpar {

    private Limpar() {

    }

    public static void terminal() {
        try {
            // Detecta o sistema operacional
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                // Comando para limpar terminal no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar terminal no Linux/Mac
                // System.out.print("\033[H\033[2J");
                new ProcessBuilder("clear").inheritIO().start().waitFor();
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível limpar o terminal.");
        }
    }
}