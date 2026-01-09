package view.menu;

import util.lerOpcao;

public class CargaMenuView {

    public int menuCargas() {
        System.out.println("\n========== MENU CARGAS ==========");
        System.out.println("1 - Listar cargas");
        System.out.println("2 - Cadastrar carga");
        System.out.println("3 - Alterar status de carga");
        System.out.println("4 - Gerar relatórios");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao.lerInt();
    }
}
