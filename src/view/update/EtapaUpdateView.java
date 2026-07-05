package view.update;

import java.util.List;
import java.util.Scanner;

import model.Caminhao;
import model.Carga;
import model.Carreta;
import model.EtapasTransporte;
import model.Motorista;
import model.enums.StatusMotorista;
import model.enums.StatusVeiculo;
import util.AguardarVoltar;

public class EtapaUpdateView {

    Scanner Input = new Scanner(System.in);
    Carga cargaSelecionada;
    Carreta carretaSelecionada, carretaSelecionada2;
    EtapasTransporte etapaSelecionada;
    int respInvoice;
    String respPO, respNotaFiscal, respOrigem, respLocalidade, respProximaParada, respDestino;
    Motorista motoristaSelecionado;
    Caminhao caminhaoSelecionado;

    public EtapasTransporte updateEtapa(List<Carreta> carretas, List<Motorista> motoristas, List<Caminhao> caminhoes,
            EtapasTransporte etapaSelecionada) {

        try {
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

            if (verificaValores(opcaoCaminhao)) {
                caminhaoSelecionado = etapaSelecionada.getCaminhao();
            } else if (opcaoCaminhao < 1 || opcaoCaminhao > caminhoes.size()
                    || !caminhoes.get(opcaoCaminhao - 1).getStatus().equals(StatusVeiculo.OCIOSO)) {
                System.out.println("Caminhão inválido.");
                AguardarVoltar.Voltar();
                return null;
            } else {
                caminhaoSelecionado = caminhoes.get(opcaoCaminhao - 1);
            }

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

            if (verificaValores(opcaoCarreta)) {
                carretaSelecionada = etapaSelecionada.getCarreta1();
            } else if (opcaoCarreta < 1 || opcaoCarreta > carretas.size()
                    || !carretas.get(opcaoCarreta - 1).getStatus().equals(StatusVeiculo.OCIOSO)) {
                System.out.println("Carreta inválida.");
                AguardarVoltar.Voltar();
                return null;
            } else {
                carretaSelecionada = carretas.get(opcaoCarreta - 1);
            }

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

            System.out.print("\nEscolha a segunda carreta (número): ");
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

            if (verificaValores(opcaoMotorista)) {
                motoristaSelecionado = etapaSelecionada.getMotorista();
            } else if (opcaoMotorista < 1 || opcaoMotorista > motoristas.size()
                    || !motoristas.get(opcaoMotorista - 1).getStatus().equals(StatusMotorista.OCIOSO)) {
                System.out.println("Motorista inválido.");
                AguardarVoltar.Voltar();
                return null;
            } else {
                motoristaSelecionado = motoristas.get(opcaoMotorista - 1);
                etapaSelecionada.getMotorista().setStatus(StatusMotorista.OCIOSO);
            }

            System.out.print("\nPróxima parada: ");
            String proximaParada = Input.nextLine();

            if (verificaValoresString(proximaParada))
                respProximaParada = etapaSelecionada.getproxParada();
            else {
                respProximaParada = proximaParada;
                respLocalidade = etapaSelecionada.getproxParada();
            }

            EtapasTransporte etapaAlterada = new EtapasTransporte(etapaSelecionada.getIdCarga(), motoristaSelecionado,
                    caminhaoSelecionado,
                    carretaSelecionada, respProximaParada);
            etapaAlterada.setCarreta2(etapaSelecionada.getCarreta2());
            if (opcaoCarreta2 != 0) {
                System.out.println("entrou 1");
                System.out.println("opção carreta 2: " + opcaoCarreta2);
                etapaAlterada.setCarreta2(carretas.get(opcaoCarreta2 - 1));
            }

            return etapaAlterada;

        } catch (Exception e) {
            System.out.println("Erro no preenchimento dos dados." + e);
            AguardarVoltar.Voltar();

            return null;
        }
    }

    private boolean verificaValores(int valor) {

        if (valor == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaValoresString(String valor) {

        if (valor.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

}
