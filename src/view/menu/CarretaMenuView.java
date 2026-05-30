package view.menu;

import util.*;

public class CarretaMenuView {

    public int menuCarretas() {
        System.out.println("\n========== MENU CARRETAS ==========");
        System.out.println("1 - listar carretas");
        System.out.println("2 - Cadastrar carretas");
        System.out.println("3 - Excluir carretas");
        System.out.println("4 - Atualizar carreta");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return LerOpcao.lerInt();
    }
}
