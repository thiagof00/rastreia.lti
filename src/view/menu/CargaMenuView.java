package view.menu;

import util.LerOpcao;

public class CargaMenuView {

    public int menuCargas() {
        System.out.println("\n========== MENU CARGAS ==========");
        System.out.println("1 - Listar cargas");
        System.out.println("2 - Cadastrar carga");
        System.out.println("3 - Alterar etapa da carga");
        System.out.println("4 - Alterar status da carga");
        System.out.println("5 - Excluir carga");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return LerOpcao.lerInt();
    }
}
