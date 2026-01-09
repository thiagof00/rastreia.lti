package view;

import java.util.List;
import java.util.Scanner;
import model.*;
import repository.CaminhaoRepository;
import repository.CarretaRepository;
import repository.MotoristaRepository;
import repository.TipoCarretaRepository;
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

        System.out.printf("%-4s | %-8s | %-10s | %-10s | %-10s | %-10s%n", "ID", "INVOICE", "CAMINHÃO", "CARRET. 1",
                "CARRET. 2", "NOTA FISCAL");
        System.out.println("-".repeat(71));
        for (Carga c : cargas) {
            System.out.printf(
                    "%-4d |%-8d | %-10s | %-10s | %-10s | %-10s%n",
                    c.getId(),
                    c.getInvoice(),
                    c.getPlacaCaminhao().getPlaca(),
                    c.getPlacaCarreta1().getPlaca1(),
                    c.getPlacaCarreta2().getPlaca2(),
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

        System.out.printf("%-4s | %-15s | %-15s | %-15s%n", "ID", "NOME", "CPF", "STATUS");
        System.out.println("-".repeat(58));
        for (Motorista m : motoristas) {
            System.out.printf(
                    "%-4d | %-15s | %-15s | %-15s%n",
                    m.getId(),
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

        System.out.printf("%-4s | %-15s | %s | %-15s%n", "ID", "TIPO", "CAPACIDADE", "Quantidade de Placas");
        System.out.println("-".repeat(53));
        for (TipoCarreta tc : tipoCarretas) {
            System.out.printf(
                    "%-4d | %-15s | %-10s | %-15s%n",
                    tc.getId(),
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

        System.out.printf("%-4s | %-12s | %-12s | %-14s | %-15s%n", "ID", "PLACA 1", "PLACA 2", "TIPO", "STATUS");
        System.out.println("-".repeat(69));
        for (Carreta c : carretas) {
            System.out.printf(
                    "%-4d | %-12s | %-12s | %-14s | %-15s%n",
                    c.getId(),
                    c.getPlaca1(),
                    c.getPlaca2(),
                    c.getTipoCarreta().getTipo(),
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

        System.out.printf("%-4s | %-12s | %-14s | %-15s%n", "ID", "PLACA", "TIPO", "STATUS");
        System.out.println("-".repeat(54));
        for (Caminhao c : caminhoes) {
            System.out.printf(
                    "%-4d | %-12s | %-14s | %-15s%n",
                    c.getId(),
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

            System.out.println("\nCaminhões disponiveis:");
            List<Caminhao> caminhoes = CaminhaoRepository.listar();

            for (int i = 0; i < caminhoes.size(); i++) {
                Caminhao c = caminhoes.get(i);
                if (c.getStatus().equals("Ocioso")) {
                    System.out.println(
                            (i + 1) + " | Placa: " + c.getPlaca() +
                                    " | Tipo: " + c.getTipo() +
                                    " | Status: " + c.getStatus());
                }
            }

            System.out.print("\nEscolha o Caminhão (número): ");
            int opcaoCaminhao = Integer.parseInt(input.nextLine());

            if (opcaoCaminhao < 1 || opcaoCaminhao > caminhoes.size()
                    || !caminhoes.get(opcaoCaminhao - 1).getStatus().equals("Ocioso")) {
                System.out.println("Caminhão inválido.");
                aguardarVoltar();
                return null;
            }

            Caminhao caminhaoSelecionado = caminhoes.get(opcaoCaminhao - 1);

            System.out.println("\nCarretas disponiveis:");
            List<Carreta> carretas = CarretaRepository.listar();

            for (int i = 0; i < carretas.size(); i++) {
                Carreta c = carretas.get(i);
                if (c.getStatusCarreta().equals("Ocioso")) {
                    System.out.println(
                            (i + 1) + " - " + c.getPlaca1() +
                                    " - " + c.getPlaca2() +
                                    " | Tipo: " + c.getTipoCarreta().getTipo() +
                                    " | Status " + c.getStatusCarreta());
                }
            }

            System.out.print("\nEscolha a carreta (número): ");
            int opcaoCarreta = Integer.parseInt(input.nextLine());

            if (opcaoCarreta < 1 || opcaoCarreta > caminhoes.size()
                    || !caminhoes.get(opcaoCarreta - 1).getStatus().equals("Ocioso")) {
                System.out.println("Carreta inválida.");
                aguardarVoltar();
                return null;
            }

            Carreta carretaSelecionada = carretas.get(opcaoCarreta - 1);

            System.out.print("Nota fiscal: ");
            String notaFiscal = input.nextLine();

            caminhaoSelecionado.setStatus("Em uso");
            carretaSelecionada.setStatus("Em uso");

            return new Carga(invoice, caminhaoSelecionado, carretaSelecionada, carretaSelecionada, notaFiscal);

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
            input.nextLine();

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

            System.out.println("\nTipos de Carreta disponíveis:");
            List<TipoCarreta> tipos = TipoCarretaRepository.listar();

            for (int i = 0; i < tipos.size(); i++) {
                TipoCarreta t = tipos.get(i);
                System.out.println(
                        (i + 1) + " - " + t.getTipo() +
                                " | Capacidade: " + t.getCapacidade() +
                                " | Eixos: " + t.getQtdPlacas());
            }

            System.out.print("\nEscolha o tipo (número): ");
            int opcao = Integer.parseInt(input.nextLine());

            if (opcao < 1 || opcao > tipos.size()) {
                System.out.println("Tipo inválido.");
                aguardarVoltar();
                return null;
            }

            TipoCarreta tipoSelecionado = tipos.get(opcao - 1);

            System.out.print("Placa 1: ");
            String placa1 = input.nextLine();

            String placa2 = "";

            if (tipoSelecionado.getQtdPlacas() == 2) {
                System.out.print("Placa 2: ");
                placa2 = input.nextLine();
            }

            String status = "";
            int i = 0;
            while (i == 0) {
                System.out.print("Status da Carreta: ");
                System.out.println("\n1 - Ocioso \n2 - Em Manutenção \n3 - Em Uso");
                int statusInt = input.nextInt();
                input.nextLine();
                switch (statusInt) {
                    case 1:
                        status = "Ocioso";
                        i = 1;
                        break;
                    case 2:
                        status = "Em Manutenção";
                        i = 1;
                        break;
                    default:
                        System.out.println("\nOpção invalida.\n");

                        break;
                }
            }

            return new Carreta(placa1, placa2, tipoSelecionado, status);

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
     * =============================================================================
     * =============
     * VIEW DE DELETAR
     * =============================================================================
     * =============
     */

    public String formularioExcluirMotorista() {

        List<Motorista> motoristas = MotoristaRepository.listar();
        System.out.println("\n========== LISTA DE MOTORISTAS ==========");

        System.out.printf("%-4s | %-15s | %-15s | %-15s%n", "ID", "NOME", "CPF", "STATUS");
        System.out.println("-".repeat(58));
        for (Motorista m : motoristas) {
            System.out.printf(
                    "%-4d | %-15s | %-15s | %-15s%n",
                    m.getId(),
                    m.getNome(),
                    m.getCpf(),
                    m.getStatus());
        }

        System.out.println("Digite o cpf do motorista a ser excluido: ");
        String cpf = input.nextLine();

        if (cpf.isBlank()) {
            System.out.println("CPF não pode ser vazio.");
            aguardarVoltar();
            return null;
        }

        return cpf;

    }

    public int formularioExcluirTipoCarreta() {

        List<TipoCarreta> tipoCarretas = TipoCarretaRepository.listar();

        System.out.println("\n========== LISTA DE TIPO DE CARRETAS ==========");
        System.out.printf("%-4s | %-15s | %s | %-15s%n", "ID", "TIPO", "CAPACIDADE", "Quantidade de Placas");
        System.out.println("-".repeat(53));
        for (TipoCarreta tc : tipoCarretas) {
            System.out.printf(
                    "%-4d | %-15s | %-10s | %-15s%n",
                    tc.getId(),
                    tc.getTipo(),
                    tc.getCapacidade(),
                    tc.getQtdPlacas());
        }

        System.out.println("Digite o id do tipo da carreta a ser excluido: ");
        int id = input.nextInt();
        input.nextLine();

        return id;

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
        Limpar.terminal();
        System.out.println("Saindo do sistema...");
    }

    public void invalido() {
        System.out.println("Opção inválida! Tente novamente.");
    }

    public void emConstrucao() {
        System.out.println("Funcionalidade em construção.");
        aguardarVoltar();
    }

}
