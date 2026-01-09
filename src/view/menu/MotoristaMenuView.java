package view.menu;

import util.*;

public class MotoristaMenuView {

    public int menuMotoristas() {
        System.out.println("\n========== MENU MOTORISTAS ==========");
        System.out.println("1 - listar motoristas");
        System.out.println("2 - Cadastrar motoristas");
        System.out.println("3 - Alterar cadastro de motoristas");
        System.out.println("4 - Excluir motoristas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao.lerInt();
    }
}
