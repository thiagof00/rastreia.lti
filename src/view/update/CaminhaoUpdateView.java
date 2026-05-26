package view.update;

import java.util.List;
import java.util.Scanner;

import model.Caminhao;
import model.enums.StatusVeiculo;

public class CaminhaoUpdateView {

    public Caminhao updateCaminhao(List<Caminhao> caminhoes) {
        String placaAlterada, tipoAlterado;
        StatusVeiculo statusAlterado;
        Scanner Input = new Scanner(System.in);

        System.out.println("\n========== LISTA DE CAMINHÕES ==========");
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
        System.out.println("Digite o id do caminhão a ser alterado: ");
        int id = Integer.parseInt(Input.nextLine());
        Caminhao caminhaoSelecionado = new Caminhao("", "", null);
        for (Caminhao caminhao : caminhoes) {

            if (caminhao.getId() == id) {
                caminhaoSelecionado = caminhao;
            }
        }

        System.out.println("--Tecle 0 para manter o valor atual--");

        System.out.print("Digite a placa do caminhão: ");
        String placa = Input.nextLine();

        System.out.print("Digite o tipo do caminhão: ");
        String tipo = Input.nextLine();

        int opcao = 0;
        StatusVeiculo status = StatusVeiculo.INDISPONIVEL;
        boolean statusValido = false;
        while (!statusValido) {
            System.out.println("\nStatus do Caminhão:");
            System.out.println("1 - Ocioso");
            System.out.println("2 - Em Manutenção");
            System.out.println("3 - Em Viagem");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(Input.nextLine());

            switch (opcao) {
                case 1:
                    status = StatusVeiculo.OCIOSO;
                    statusValido = true;
                    break;
                case 2:
                    status = StatusVeiculo.EM_MANUTENCAO;
                    statusValido = true;
                    break;
                case 3:
                    status = StatusVeiculo.EM_VIAGEM;
                    statusValido = true;
                    break;
                case 0:
                    status = caminhaoSelecionado.getStatus();
                    statusValido = true;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        if (verificaValoresString(placa)) {
            placaAlterada = caminhaoSelecionado.getPlaca();
        } else
            placaAlterada = placa;
        if (verificaValoresString(tipo)) {
            tipoAlterado = caminhaoSelecionado.getTipo();
        } else
            tipoAlterado = tipo;
        if (opcao == 0) {
            statusAlterado = caminhaoSelecionado.getStatus();
        } else
            statusAlterado = status;

        Caminhao caminhaoAlterado = new Caminhao(placaAlterada, tipoAlterado, statusAlterado);
        caminhaoAlterado.setId(id);
        return caminhaoAlterado;

    }

    private boolean verificaValoresString(String valor) {

        if (valor.equals("0")) {
            return true;
        } else {
            return false;
        }
    }
}
