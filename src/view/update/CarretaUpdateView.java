package view.update;

import java.util.List;
import java.util.Scanner;

import model.Caminhao;
import model.Carreta;
import model.enums.StatusVeiculo;
import util.AguardarVoltar;

public class CarretaUpdateView {
    public Carreta updateCarreta(List<Carreta> carretas) {
        String placaAlterada, tipoAlterado;
        int pesoAlterado, metragemAlterada;
        StatusVeiculo status = StatusVeiculo.INDISPONIVEL;
        Scanner Input = new Scanner(System.in);

        System.out.println("========== LISTA DE CARRETAS ==========");
        if (carretas.isEmpty()) {
            System.out.println("Nenhuma carreta cadastrada.");
            AguardarVoltar.Voltar();
            return null;
        }

        System.out.printf("%-4s | %-12s | %-12s | %-8s | %-8s | %-15s%n", "ID", "PLACA", "TIPO", "PESO MAX", "METRAGEM",
                "STATUS");
        System.out.println("-".repeat(74));
        for (Carreta c : carretas) {
            System.out.printf(
                    "%-4d | %-12s | %-12s | %-8d | %-8d | %-15s%n",
                    c.getId(),
                    c.getPlaca(),
                    c.getTipo(),
                    c.getPeso_max(),
                    c.getMetragem(),
                    c.getStatus());
        }
        System.out.println("Digite o id da carreta a ser alterada: ");
        int id = Integer.parseInt(Input.nextLine());
        Carreta carretaSelecionada = new Carreta("", "", null, 0, 0);

        for (Carreta carreta : carretas) {
            if (carreta.getId() == id) {
                carretaSelecionada = carreta;
            }
        }

        System.out.println("--Tecle 0 para manter o valor atual--");

        System.out.println("Digite a placa da carreta: ");
        String placa = Input.nextLine();

        System.out.println("Digite o tipo da carreta: ");
        String tipo = Input.nextLine();

        System.out.println("Digite o peso máximo: ");
        int peso = Integer.parseInt(Input.nextLine());

        System.out.println("Digite a metragem da carreta: ");
        int metragem = Integer.parseInt(Input.nextLine());

        int opcao = 0;
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
                    status = carretaSelecionada.getStatus();
                    statusValido = true;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        if (verificaValoresString(placa)) {
            placaAlterada = carretaSelecionada.getPlaca();
        } else
            placaAlterada = placa;
        if (verificaValoresString(tipo)) {
            tipoAlterado = carretaSelecionada.getTipo();
        } else 
            tipoAlterado = tipo;
        if (verificaValoresInt(peso)) {
            pesoAlterado = carretaSelecionada.getPeso_max();
        } else 
            pesoAlterado = peso;
        if (verificaValoresInt(metragem)) {
            metragemAlterada = carretaSelecionada.getMetragem();
        } else
            metragemAlterada = metragem;

        Carreta carretaAlterada = new Carreta(placaAlterada, tipoAlterado, status, pesoAlterado, metragemAlterada);
        carretaAlterada.setId(id);
        return carretaAlterada;
    }

    private boolean verificaValoresString(String valor) {

        if (valor.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaValoresInt(int valor) {

        if (valor == 0) {
            return true;
        } else {
            return false;
        }
    }
}
