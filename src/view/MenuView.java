package view;

import java.util.Scanner;

public class MenuView {
    private Scanner input = new Scanner(System.in);

    public int menuPrincipal(int tipoUsuario) {
        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("------------------------------------");
        System.out.println("1 - Listar cargas");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public void listarCargasSimuladas() {
        System.out.println("\n========== LISTA DE CARGAS (SIMULADO) ==========");
        System.out.println("ID   | ORIGEM     | DESTINO    | STATUS");
        System.out.println("-----------------------------------------------");
        System.out.println("001  | Santa Maria | Porto Alegre | Em trânsito");
        System.out.println("002  | São Paulo   | Rio de Janeiro | Entregue");
        System.out.println("003  | Curitiba    | Florianópolis | Aguardando coleta");
        System.out.println("-----------------------------------------------\n");
    }

    public void sair() {
        System.out.println("Encerrando o sistema...");
    }

    public void invalido() {
        System.out.println("Opção inválida! Tente novamente.");
    }
}
