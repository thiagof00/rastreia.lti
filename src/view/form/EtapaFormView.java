package view.form;

import java.util.List;
import java.util.Scanner;
import model.Caminhao;
import model.Carreta;
import model.EtapasTransporte;
import model.Motorista;
import model.enums.StatusMotorista;
import model.enums.StatusVeiculo;
import util.AguardarVoltar;

public class EtapaFormView {
    Scanner Input = new Scanner(System.in);

    public EtapasTransporte formularioCadastroEtapa(int idCarga, List<Carreta> carretas, List<Motorista> motoristas,
            List<Caminhao> caminhoes) {

        System.out.print("Próxima parada após a origem: ");
        String proximaParada = Input.nextLine();

        System.out.println("\nCaminhões disponiveis:");

        for (int i = 0; i < caminhoes.size(); i++) {
            Caminhao c = caminhoes.get(i);
            if (c.getStatus().equals(StatusVeiculo.OCIOSO)) {
                System.out.println(
                        (i + 1) + " | Placa: " + c.getPlaca() +
                                " | Tipo: " + c.getTipo());
            }
        }

        System.out.print("\nEscolha o Caminhão (número): ");
        int opcaoCaminhao = Integer.parseInt(Input.nextLine());

        if (opcaoCaminhao < 1 || opcaoCaminhao > caminhoes.size()
                || !caminhoes.get(opcaoCaminhao - 1).getStatus().equals(StatusVeiculo.OCIOSO)) {
            System.out.println("Caminhão inválido.");
            AguardarVoltar.Voltar();
            return null;
        }

        Caminhao caminhaoSelecionado = caminhoes.get(opcaoCaminhao - 1);

        System.out.println("\nCarretas disponiveis:");

        for (int i = 0; i < carretas.size(); i++) {
            Carreta c = carretas.get(i);
            if (c.getStatus().equals(StatusVeiculo.OCIOSO)) {
                System.out.println(
                        (i + 1) + " - " + c.getPlaca() +
                                " | Tipo: " + c.getTipo());
            }
        }

        System.out.print("\nEscolha a carreta (número): ");
        int opcaoCarreta = Integer.parseInt(Input.nextLine());

        if (opcaoCarreta < 1 || opcaoCarreta > carretas.size()
                || !carretas.get(opcaoCarreta - 1).getStatus().equals(StatusVeiculo.OCIOSO)) {
            System.out.println("Carreta inválida.");
            AguardarVoltar.Voltar();
            return null;
        }

        Carreta carretaSelecionada = carretas.get(opcaoCarreta - 1);

        System.out.println("\nSelecione a segunda carreta, digite 0 caso não utilize: ");
        System.out.println("\nCarretas disponiveis:");

        for (int i = 0; i < carretas.size(); i++) {
            Carreta c = carretas.get(i);
            if (c.getStatus().equals(StatusVeiculo.OCIOSO) && !c.getPlaca().equals(carretaSelecionada.getPlaca())) {
                System.out.println(
                        (i + 1) + " - " + c.getPlaca() +
                                " | Tipo: " + c.getTipo());
            }
        }

        System.out.print("\nEscolha a carreta (número): ");
        int opcaoCarreta2 = Integer.parseInt(Input.nextLine());

        if (opcaoCarreta2 != 0) {

            if (opcaoCarreta2 < 0 || opcaoCarreta2 > carretas.size()
                    || !carretas.get(opcaoCarreta2 - 1).getStatus().equals(StatusVeiculo.OCIOSO)
                    || opcaoCarreta2 == opcaoCarreta) {
                System.out.println("Carreta inválida.");
                AguardarVoltar.Voltar();
                return null;
            }
        }

        System.out.println("\nMotoristas disponiveis:");

        for (int i = 0; i < motoristas.size(); i++) {
            Motorista m = motoristas.get(i);
            if (m.getStatus().equals(StatusMotorista.OCIOSO)) {
                System.out.println(
                        (i + 1) + " - " + m.getNome() +
                                " - " + m.getCpf());
            }
        }

        System.out.print("\nEscolha o motorista (número): ");
        int opcaoMotorista = Integer.parseInt(Input.nextLine());

        if (opcaoMotorista < 1 || opcaoMotorista > motoristas.size()
                || !motoristas.get(opcaoMotorista - 1).getStatus().equals(StatusMotorista.OCIOSO)) {
            System.out.println("Motorista inválido.");
            AguardarVoltar.Voltar();
            return null;
        }

        Motorista motoristaSelecionado = motoristas.get(opcaoMotorista - 1);

        EtapasTransporte novaEtapa = new EtapasTransporte(idCarga, motoristaSelecionado, caminhaoSelecionado,
                carretaSelecionada, proximaParada);

        if (opcaoCarreta2 != 0) {
            Carreta carretaSelecionada2 = carretas.get(opcaoCarreta2 - 1);
            novaEtapa.setCarreta2(carretaSelecionada2);
        }
        return novaEtapa;

    }
}