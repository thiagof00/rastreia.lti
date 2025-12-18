package view;

import java.util.Scanner;
import util.Limpar;

public class MenuView {

    private Scanner input = new Scanner(System.in);

    /* =========================
       MENUS PRINCIPAIS
       ========================= */
    public int menuPrincipalAdmin() {
        System.out.println("\n========== MENU PRINCIPAL (ADMIN) ==========");
        System.out.println("1 - Gerenciar cargas");
        System.out.println("2 - Gerenciar motoristas");
        System.out.println("3 - Gerenciar carretas");
        System.out.println("4 - Gerenciar tipos de carretas");
        System.out.println("5 - Gerar relatórios");
        System.out.println("6 - Gerenciar usuários");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

    public int menuPrincipalCliente() {
        System.out.println("\n========== MENU PRINCIPAL (CLIENTE) ==========");
        System.out.println("1 - Listar cargas");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

    public int menuCargas() {
        System.out.println("\n========== MENU CARGAS ==========");
        System.out.println("1 - Listar cargas");
        System.out.println("2 - Cadastrar carga");
        System.out.println("3 - Alterar status de carga");
        System.out.println("4 - Gerar relatórios");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

    /* =========================
       LISTAGENS
       ========================= */
    public void listarCargasSimuladas() {
        System.out.println("\n========== LISTA DE CARGAS ==========");
        System.out.println("ID   | ORIGEM        | DESTINO           | STATUS");
        System.out.println("-----------------------------------------------");
        System.out.println("001  | Santa Maria   | Porto Alegre      | Em trânsito");
        System.out.println("002  | São Paulo     | Rio de Janeiro    | Entregue");
        System.out.println("003  | Curitiba      | Florianópolis    | Aguardando coleta");
        System.out.println("-----------------------------------------------");

        aguardarVoltar();
    }

    public int menuMotoristas() {
        System.out.println("\n========== MENU MOTORISTAS ==========");
        System.out.println("1 - listar motoristas");
        System.out.println("2 - Cadastrar motoristas");
        System.out.println("3 - Alterar cadastro de motoristas");
        System.out.println("4 - Excluir motoristas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

    public int menuCarretas() {
        System.out.println("\n========== MENU CARRETAS ==========");
        System.out.println("1 - listar carretas");
        System.out.println("2 - Cadastrar carretas");
        System.out.println("3 - Alterar cadastro de carretas");
        System.out.println("4 - Excluir carretas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

    public int menuTipoCarretas() {
        System.out.println("\n========== MENU TIPO DE CARRETAS ==========");
        System.out.println("1 - listar tipos de carretas");
        System.out.println("2 - Cadastrar tipos de carretas");
        System.out.println("3 - Alterar cadastro de tipos de carretas");
        System.out.println("4 - Excluir tipos de carretas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

        
    public void listarMotoristasSimulados() {
        System.out.println("\n========== LISTA DE MOTORISTAS ==========");
        System.out.println("ID   | NOME            | CPF             | STATUS");
        System.out.println("-----------------------------------------------");
        System.out.println("001  | Paulo Lenin     | 97103990042     | Em trânsito");
        System.out.println("002  | Valdemiro Putin | 65056169005     | Ocioso");
        System.out.println("003  | Ronaldo Trump   | 95665017060     | Aguardando coleta");
        System.out.println("-----------------------------------------------");

        aguardarVoltar();
    }    

    /* =========================
       UTILITÁRIOS DE VIEW
       ========================= */
    private void aguardarVoltar() {
        System.out.println("\n0 - Voltar");
        System.out.print("Escolha: ");

        while (true) {
            try {
                int opcao = Integer.parseInt(input.nextLine());
                if (opcao == 0) {
                    Limpar.terminal();
                    break;
                }
            } catch (Exception e) {}

            System.out.print("Opção inválida. Digite 0 para voltar: ");
        }
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public void sair() {
        System.out.println("Encerrando o sistema...");
    }

    public void invalido() {
        System.out.println("Opção inválida! Tente novamente.");
    }

    public void emConstrucao() {
        System.out.println("Funcionalidade em construção.");
        aguardarVoltar();
    }
}
