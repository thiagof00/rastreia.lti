package view.menu;

import util.lerOpcao;

public class MenuPrincipalView {

    private MenuPrincipalView(){}
    public static int menuPrincipalAdmin() {
        System.out.println("\n========== MENU PRINCIPAL (ADMIN) ==========");
        System.out.println("1 - Gerenciar cargas");
        System.out.println("2 - Gerenciar motoristas");
        System.out.println("3 - Gerenciar carretas");
        System.out.println("4 - Gerenciar caminhões");
        System.out.println("5 - Gerenciar usuários");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return lerOpcao.lerInt();
    }

    public static int menuPrincipalCliente() {
        System.out.println("\n========== MENU PRINCIPAL (CLIENTE) ==========");
        System.out.println("1 - Listar cargas");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return lerOpcao.lerInt();
    }
}
