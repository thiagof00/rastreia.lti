package view.menu;

import util.*;

public class CaminhaoMenuView {

    public int menuCaminhao() {

        System.out.println("\n========== MENU CAMINHÕES ==========");
        System.out.println("1 - listar caminhões");
        System.out.println("2 - Cadastrar caminhão");
        System.out.println("3 - Excluir caminhão");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return LerOpcao.lerInt();
    }
}
