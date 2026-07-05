package view.update;

import java.util.List;
import java.util.Scanner;

import model.Motorista;
import model.enums.StatusMotorista;
import util.AguardarVoltar;

public class MotoristaUpdateView {
    public Motorista updateMotorista(List<Motorista> motoristas) {
        String nomeAlterado, cpfAlterado;
        StatusMotorista status = null;
        Scanner Input = new Scanner(System.in);

        System.out.println("\n========== LISTA DE MOTORISTAS ==========");
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
            AguardarVoltar.Voltar();
            return null;
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
        System.out.println("Digite o id do motorista a ser alterado: ");
        int id = Integer.parseInt(Input.nextLine());
        Motorista motoristaSelecionado = new Motorista("", "", null);

        for (Motorista motorista : motoristas) {
            if (motorista.getId() == id) {
                motoristaSelecionado = motorista;
            }
        }
        if (motoristaSelecionado.getNome().equals("")) {
            System.out.println("Id do motorista invalido.");
            AguardarVoltar.Voltar();
            return null;
        }

        System.out.println("--Tecle 0 para manter o valor atual--");

        System.out.println("Digite o nome do motorista: ");
        String nome = Input.nextLine();

        System.out.println("Digite o cpf do motorista: ");
        String cpf = Input.nextLine();

        int opcao = 0;
        boolean statusValido = false;
        while (!statusValido) {
            System.out.println("\nStatus do Motorista:");
            System.out.println("1 - Ocioso");
            System.out.println("2 - Indisponivel");
            System.out.println("3 - Em Viagem");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(Input.nextLine());

            switch (opcao) {
                case 1:
                    status = StatusMotorista.OCIOSO;
                    statusValido = true;
                    break;
                case 2:
                    status = StatusMotorista.INDISPONIVEL;
                    statusValido = true;
                    break;
                case 3:
                    status = StatusMotorista.EM_VIAGEM;
                    statusValido = true;
                    break;
                case 0:
                    status = motoristaSelecionado.getStatus();
                    statusValido = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        if (verificaValoresString(nome)) {
            nomeAlterado = motoristaSelecionado.getNome();
        } else
            nomeAlterado = nome;
        if (verificaValoresString(cpf)) {
            cpfAlterado = motoristaSelecionado.getCpf();
        } else
            cpfAlterado = cpf;

        Motorista motoristaAlterado = new Motorista(nomeAlterado, cpfAlterado, status);
        motoristaAlterado.setId(id);
        return motoristaAlterado;
    }

    private boolean verificaValoresString(String valor) {

        if (valor.equals("0")) {
            return true;
        } else {
            return false;
        }
    }
}
