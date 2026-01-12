package util;

import java.util.Scanner;

public class aguardarVoltar {

    private static final Scanner input = new Scanner(System.in);

    private aguardarVoltar(){}

    public static void Voltar() {
        System.out.println("\n0 - Voltar");
        System.out.print("Escolha: ");

        while (true) {
            try {
                int opcao = Integer.parseInt(input.nextLine());
                if (opcao == 0) {
                    Limpar.terminal();
                    break;
                }
            } catch (Exception e) {
            }

            System.out.print("Opção inválida. Digite 0 para voltar: ");
        }
    }
}
