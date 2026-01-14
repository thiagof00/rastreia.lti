package view.form;

import java.util.List;
import java.util.Scanner;

import model.Caminhao;
import model.Carga;
import model.Carreta;
import model.Motorista;
import repository.CaminhaoRepository;
import repository.CarretaRepository;
import repository.MotoristaRepository;
import util.*;

public class CargaFormView {

    Scanner input = new Scanner(System.in);

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
                                    " | Tipo: " + c.getTipo());
                }
            }

            System.out.print("\nEscolha o Caminhão (número): ");
            int opcaoCaminhao = Integer.parseInt(input.nextLine());

            if (opcaoCaminhao < 1 || opcaoCaminhao > caminhoes.size()
                    || !caminhoes.get(opcaoCaminhao - 1).getStatus().equals("Ocioso")) {
                System.out.println("Caminhão inválido.");
                aguardarVoltar.Voltar();
                return null;
            }

            Caminhao caminhaoSelecionado = caminhoes.get(opcaoCaminhao - 1);

            System.out.println("\nCarretas disponiveis:");
            List<Carreta> carretas = CarretaRepository.listar();

            for (int i = 0; i < carretas.size(); i++) {
                Carreta c = carretas.get(i);
                if (c.getStatus().equals("Ocioso")) {
                    System.out.println(
                            (i + 1) + " - " + c.getPlaca() +
                                    " | Tipo: " + c.getTipo());
                }
            }

            System.out.print("\nEscolha a carreta (número): ");
            int opcaoCarreta = Integer.parseInt(input.nextLine());

            if (opcaoCarreta < 1 || opcaoCarreta > caminhoes.size()
                    || !caminhoes.get(opcaoCarreta - 1).getStatus().equals("Ocioso")) {
                System.out.println("Carreta inválida.");
                aguardarVoltar.Voltar();
                return null;
            }

            Carreta carretaSelecionada = carretas.get(opcaoCarreta - 1);

            System.out.println("\nMotoristas disponiveis:");
            List<Motorista> motoristas = MotoristaRepository.listar();

            for (int i = 0; i < motoristas.size(); i++) {
                Motorista m = motoristas.get(i);
                if (m.getStatus().equals("Ocioso")) {
                    System.out.println(
                            (i + 1) + " - " + m.getNome() +
                                    " - " + m.getCpf());
                }
            }

            System.out.print("\nEscolha o motorista (número): ");
            int opcaoMotorista = Integer.parseInt(input.nextLine());

            if (opcaoMotorista < 1 || opcaoMotorista > motoristas.size()
                    || !motoristas.get(opcaoMotorista - 1).getStatus().equals("Ocioso")) {
                System.out.println("Motorista inválido.");
                aguardarVoltar.Voltar();
                return null;
            }

            Motorista motoristaSelecionado = motoristas.get(opcaoMotorista - 1);

            System.out.print("Nota fiscal: ");
            String notaFiscal = input.nextLine();
            
            System.out.print("PO: ");
            String PO = input.nextLine();

            System.out.print("Origem: ");
            String origem = input.nextLine();

            System.out.print("Destino: ");
            String destino = input.nextLine();

            caminhaoSelecionado.setStatus("Em uso");
            carretaSelecionada.setStatus("Em uso");
            motoristaSelecionado.setStatus("Em Viagem");

            return new Carga(invoice, motoristaSelecionado, caminhaoSelecionado, carretaSelecionada, carretaSelecionada, PO, notaFiscal,origem,destino, "Em viagem");

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
            return null;
        }
    }
}