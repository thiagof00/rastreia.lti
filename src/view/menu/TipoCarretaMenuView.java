package view.menu;

import util.lerOpcao;

public class TipoCarretaMenuView {

    public int menuTipoCarretas() {
        System.out.println("\n========== MENU TIPO DE CARRETAS ==========");
        System.out.println("1 - listar tipos de carretas");
        System.out.println("2 - Cadastrar tipos de carretas");
        System.out.println("3 - Alterar cadastro de tipos de carretas");
        System.out.println("4 - Excluir tipos de carretas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao.lerInt();
    }
}
