package view;

import java.util.List;
import java.util.Scanner;
import model.*;
import util.Limpar;

public class MenuView {

    private Scanner input = new Scanner(System.in);

    /*
     * =========================
     * MENUS PRINCIPAIS
     * =========================
     */
    public int menuPrincipalAdmin() {
        System.out.println("\n========== MENU PRINCIPAL (ADMIN) ==========");
        System.out.println("1 - Gerenciar cargas");
        System.out.println("2 - Gerenciar motoristas");
        System.out.println("3 - Gerenciar carretas");
        System.out.println("4 - Gerenciar tipos de carretas");
        System.out.println("5 - Gerenciar caminhões");
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

    public int menuCaminhao() {

        System.out.println("\n========== MENU CAMINHÕES ==========");
        System.out.println("1 - listar caminhões");
        System.out.println("2 - Cadastrar caminhão");
        System.out.println("3 - Alterar cadastro de caminhão");
        System.out.println("4 - Excluir caminhão");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        return lerOpcao();
    }

    /*
     * =========================
     * LISTAGENS
     * =========================
     */
    public void listarCargas(List<Carga> cargas) {
        System.out.println("\n========== LISTA DE CARGAS ==========");

        if (cargas.isEmpty()) {
            System.out.println("Nenhuma carga cadastrada.");
            aguardarVoltar();
            return;
        }

        System.out.println(" INVOICE | CAMINHÃO | CARRET. 1 | CARRET. 2 | NOTA FISCAL");
        System.out.println("----------------------------------------------------------");
        for (Carga c : cargas) {
            System.out.printf(
                    "%-8d | %-8s | %-8s | %-8s | %-8s%n",
                    c.getInvoice(),
                    c.getPlacaCaminhao(),
                    c.getPlacaCarga1(),
                    c.getPlacaCarga2(),
                    c.getNotaFiscal());
        }

        aguardarVoltar();
    }

    public void listarMotoristas(List<Motorista> motoristas) {
        System.out.println("\n========== LISTA DE MOTORISTAS ==========");

        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
            aguardarVoltar();
            return;
        }

        System.out.println(" NOME            | CPF             | STATUS");
        System.out.println("-----------------------------------------------");
        for (Motorista m : motoristas) {
            System.out.printf(
                    "%-15s | %-15s | %-15s%n",
                    m.getNome(),
                    m.getCpf(),
                    m.getStatus());
        }
        aguardarVoltar();
    }

    public void listarTiposCarretas(List<TipoCarreta> tipoCarretas) {
        System.out.println("\n========== LISTA DE TIPO DE CARRETAS ==========");

        if (tipoCarretas.isEmpty()) {
            System.out.println("Nenhum tipo de carreta cadastrado.");
            aguardarVoltar();
            return;
        }

        System.out.println(" TIPO            | CAPACIDADE    | Quantidade de Placas");
        System.out.println("-----------------------------------------------");
        for (TipoCarreta tc : tipoCarretas) {
            System.out.printf(
                    "%-15s | %-15s | %-15s%n",
                    tc.getTipo(),
                    tc.getCapacidade(),
                    tc.getQtdPlacas());
        }
        aguardarVoltar();
    }

    public void listarCarretas(List<Carreta> carretas) {
        System.out.println("========== LISTA DE CARRETAS ==========");

        if (carretas.isEmpty()) {
            System.out.println("Nenhuma carreta cadastrada.");
            aguardarVoltar();
            return;
        }

        System.out.println(" PLACA 1     | PLACA 2     | TIPO           | STATUS");
        System.out.println("-----------------------------------------------");
        for (Carreta c : carretas) {
            System.out.printf(
                    "%-12s | %-12s | %-14s | %-15s%n",
                    c.getPlaca1(),
                    c.getPlaca2(),
                    c.getTipoCarreta(),
                    c.getStatusCarreta());
        }
        aguardarVoltar();
    }

    public void listarCaminhoes(List<Caminhao> caminhoes) {
        System.out.println("\n========== LISTA DE CAMINHÕES ==========");

        if (caminhoes.isEmpty()) {
            System.out.println("Nenhum caminhão cadastrado.");
            aguardarVoltar();
            return;
        }

        System.out.println(" PLACA      | TIPO           | STATUS");
        System.out.println("-----------------------------------------------");
        for (Caminhao c : caminhoes) {
            System.out.printf(
                    "%-12s | %-14s | %-15s%n",
                    c.getPlaca(),
                    c.getTipo(),
                    c.getStatus());
        }
        aguardarVoltar();
    }

    /*
     * =========================
     * FORMULÁRIOS DE CADASTRO
     * =========================
     */

    public Carga formularioCadastroCarga() {
        System.out.println("========== CADASTRO DE CARGA ==========");

        try {
            System.out.print("Invoice (número): ");
            int invoice = Integer.parseInt(input.nextLine());

            System.out.print("Placa do caminhão: ");
            String placaCaminhao = input.nextLine();

            System.out.print("Placa 1 da carga: ");
            String placaCarga1 = input.nextLine();

            System.out.print("Placa 2 da carga: ");
            String placaCarga2 = input.nextLine();

            System.out.print("Nota fiscal: ");
            String notaFiscal = input.nextLine();

            return new Carga(invoice, placaCaminhao, placaCarga1, placaCarga2, notaFiscal);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar();
            return null;
        }
    }

    public Motorista formularioCadastroMotorista() {
        System.out.println("========== CADASTRO DE MOTORISTA ==========");
        try {
            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("CPF: ");
            String cpf = input.nextLine();

            System.out.print("Status: ");
            String status = input.nextLine();

            return new Motorista(nome, cpf, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar();
            return null;
        }
    }

    public TipoCarreta formularioCadastroTipoCarreta() {
        System.out.println("========== CADASTRO DE TIPO DE CARRETAS ==========");
        try {
            System.out.print("Tipo: ");
            String tipo = input.nextLine();

            System.out.print("Capacidade: ");
            int capacidade = input.nextInt();

            System.out.print("Quantidade de placas: ");
            int qtdPlacas = input.nextInt();

            return new TipoCarreta(tipo, capacidade, qtdPlacas);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar();
            return null;
        }
    }

    public Carreta formularioCadastroCarreta() {
        System.out.println("========== CADASTRO DE CARRETA ==========");
        try {
            System.out.print("Placa 1: ");
            String placa1 = input.nextLine();

            System.out.print("Placa 2: ");
            String placa2 = input.nextLine();

            System.out.print("Tipo de Carreta: ");
            String tipo = input.nextLine();

            System.out.print("Status da Carreta: ");
            String status = input.nextLine();

            return new Carreta(placa1, placa2, tipo, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar();
            return null;
        }
    }

    public Caminhao formularioCadastroCaminhao() {
        System.out.println("========== CADASTRO DE CAMINHÃO ==========");
        try {
            System.out.print("Placa: ");
            String placa = input.nextLine();

            System.out.print("Tipo: ");
            String tipo = input.nextLine();

            System.out.print("Status: ");
            String status = input.nextLine();

            return new Caminhao(placa, tipo, status);

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar();
            return null;
        }
    }

    /*
     * =========================
     * UTILITÁRIOS DE VIEW
     * =========================
     */
    public void aguardarVoltar() {
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
