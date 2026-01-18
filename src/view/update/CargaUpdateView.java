package view.update;

import java.util.List;
import java.util.Scanner;

import model.Caminhao;
import model.Carga;
import model.Carreta;
import model.EtapasTransporte;
import model.Motorista;
import repository.CaminhaoRepository;
import repository.CarretaRepository;
import repository.EtapasTransporteRepository;
import repository.MotoristaRepository;
import util.aguardarVoltar;

public class CargaUpdateView {

    Scanner input = new Scanner(System.in);
    Carga cargaSelecionada;
    Carreta carretaSelecionada, carretaSelecionada2;
    EtapasTransporte etapaSelecionada;
    int respInvoice;
    String respPO, respNotaFiscal, respOrigem, respLocalidade, respProximaParada, respDestino;
    Motorista motoristaSelecionado;
    Caminhao caminhaoSelecionado;

    public Carga updateCarga(List<Carga> cargas) {

        try {

            System.out.println("\n========== LISTA DE CARGAS ==========");
            if (cargas.isEmpty()) {
                System.out.println("Nenhuma carga cadastrada.");
                aguardarVoltar.Voltar();
                return null;
            }

            System.out.printf("%-4s | %-8s | %-13s | %-11s | %-15s | %-15s | %-12s%n", "ID", "INVOICE", "PO",
                    "NOTA FISCAL",
                    "ORIGEM", "DESTINO", "STATUS");
            System.out.println("-".repeat(96));
            for (Carga c : cargas) {
                System.out.printf(
                        "%-4d | %-8d | %-13s | %-11s | %-15s | %-15s | %-12s%n",
                        c.getId(),
                        c.getInvoice(),
                        c.getPO(),
                        c.getNotaFiscal(),
                        c.getOrigem(),
                        c.getDestino(),
                        c.getStatus());
            }

            System.out.println("Digite a carga para alterar");
            int escolhaCarga = Integer.parseInt(input.nextLine());

            List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();

            for (int i = etapas.size() - 1; i >= 0; i--) {
                EtapasTransporte e = etapas.get(i);
                etapaSelecionada = e;
                Carga c = e.getCarga();

                if (c.getId() == escolhaCarga) {
                    cargaSelecionada = c;
                    System.out.printf(
                            "%-4s | %-8s | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n",
                            "ID", "Invoice", "PO", "NF", "Origem", "Localidade", "Prox Parada", "Destino", "Caminhão",
                            "Carreta 1", "Carreta 2", "Status");
                    System.out.println("-".repeat(150));

                    String placaCarreta2;
                    if (c.getCarreta2() != null) {
                        placaCarreta2 = c.getCarreta2().getPlaca();
                    } else {
                        placaCarreta2 = "—";
                    }

                    System.out.printf(
                            "%-4d | %-8d | %-10s | %-7s | %-14s | %-14s | %-14s | %-14s | %-9s | %-10s | %-10s | %-12s\n",
                            e.getId(),
                            c.getInvoice(),
                            c.getPO(),
                            c.getNotaFiscal(),
                            c.getOrigem(),
                            e.getLocalidade(),
                            e.getProximaParada(),
                            c.getDestino(),
                            e.getCaminhao().getPlaca(),
                            e.getCarreta().getPlaca(),
                            placaCarreta2,
                            e.getStatus());
                    break;
                }
            }
            System.out.println("--Tecle 0 para manter o valor atual--");

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

            if (verificaValores(opcaoCaminhao)) {
                caminhaoSelecionado = etapaSelecionada.getCaminhao();
            } else if (opcaoCaminhao < 1 || opcaoCaminhao > caminhoes.size()
                    || !caminhoes.get(opcaoCaminhao - 1).getStatus().equals("Ocioso")) {
                System.out.println("Caminhão inválido.");
                aguardarVoltar.Voltar();
                return null;
            } else {
                caminhaoSelecionado = caminhoes.get(opcaoCaminhao - 1);
            }

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

            
            if (verificaValores(opcaoCarreta)) {
                carretaSelecionada = etapaSelecionada.getCarreta();
            } else if (opcaoCarreta < 1 || opcaoCarreta > carretas.size()
                    || !carretas.get(opcaoCarreta - 1).getStatus().equals("Ocioso")) {
                System.out.println("Carreta inválida.");
                aguardarVoltar.Voltar();
                return null;
            } else {
                carretaSelecionada = carretas.get(opcaoCarreta - 1);
            }

            System.out.println("Selecione a segunda carreta, digite 0 caso não apareça uma disponivel para uso: ");
            System.out.println("\nCarretas disponiveis:");

            for (int i = 0; i < carretas.size(); i++) {
                Carreta c = carretas.get(i);
                if (c.getStatus().equals("Ocioso") && !c.getPlaca().equals(carretaSelecionada.getPlaca())) {
                    System.out.println(
                            (i + 1) + " - " + c.getPlaca() +
                                    " | Tipo: " + c.getTipo());
                }
            }

            System.out.print("\nEscolha a carreta (número): ");
            int opcaoCarreta2 = Integer.parseInt(input.nextLine());

            if (opcaoCarreta2 != 0) {

                if (opcaoCarreta2 < 0 || opcaoCarreta2 > carretas.size()
                        || !carretas.get(opcaoCarreta2 - 1).getStatus().equals("Ocioso")
                        || opcaoCarreta2 == opcaoCarreta) {
                    System.out.println("Carreta inválida.");
                    aguardarVoltar.Voltar();
                    return null;
                }
            }

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


            if (verificaValores(opcaoMotorista)) {
                motoristaSelecionado = etapaSelecionada.getMotorista();
            } else if (opcaoMotorista < 1 || opcaoMotorista > motoristas.size()
                    || !motoristas.get(opcaoMotorista - 1).getStatus().equals("Ocioso")) {
                System.out.println("Motorista inválido.");
                aguardarVoltar.Voltar();
                return null;
            } else {
                motoristaSelecionado = motoristas.get(opcaoMotorista - 1);
                etapaSelecionada.getMotorista().setStatus("Ocioso");
            }

            System.out.print("Nota fiscal: ");
            String notaFiscal = input.nextLine();

            System.out.print("PO: ");
            String PO = input.nextLine();

            System.out.print("Origem: ");
            String origem = input.nextLine();

            String respLocalidade = etapaSelecionada.getLocalidade();

            System.out.print("Próxima parada: ");
            String proximaParada = input.nextLine();
            System.out.print("Destino: ");
            String destino = input.nextLine();

            if (verificaValores(invoice))
                respInvoice = cargaSelecionada.getInvoice();
            else
                respInvoice = invoice;
            if (verificaValoresString(PO))
                respPO = cargaSelecionada.getPO();
            else
                respPO = PO;
            if (verificaValoresString(notaFiscal))
                respNotaFiscal = cargaSelecionada.getNotaFiscal();
            else
                respNotaFiscal = notaFiscal;
            if (verificaValoresString(origem))
                respOrigem = cargaSelecionada.getOrigem();
            else
                respOrigem = origem;
            if (verificaValoresString(proximaParada))
                respProximaParada = etapaSelecionada.getProximaParada();
            else {
                respProximaParada = proximaParada;
                respLocalidade = etapaSelecionada.getProximaParada();
            }
            if (verificaValoresString(destino))
                respDestino = cargaSelecionada.getDestino();
            else
                respDestino = destino;

            setStatusEtapa(opcaoMotorista, opcaoCaminhao, opcaoCarreta, opcaoCarreta2);
            

            if (opcaoCarreta2 == 0) {
                
                return new Carga(cargaSelecionada.getId(), respInvoice, motoristaSelecionado, caminhaoSelecionado,
                        carretaSelecionada, respPO, respNotaFiscal, respOrigem, respLocalidade, respProximaParada,
                        respDestino, "Em viagem");
            } else {
                carretaSelecionada2 = carretas.get(opcaoCarreta2 - 1);
                etapaSelecionada.getCarreta2().setStatus("Ocioso");
                carretaSelecionada2.setStatus("Em uso");

                return new Carga(cargaSelecionada.getId(), respInvoice, motoristaSelecionado, caminhaoSelecionado,
                        carretaSelecionada, carretaSelecionada2, respPO, respNotaFiscal, respOrigem, respLocalidade,
                        respProximaParada, respDestino, "Em viagem");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no preenchimento dos dados.");
            aguardarVoltar.Voltar();
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

    private void setStatusEtapa(int motorista, int caminhao, int carreta1, int carreta2){
        if (!verificaValores(motorista)) {
                    etapaSelecionada.getMotorista().setStatus("Ocioso");
                    motoristaSelecionado.setStatus("Em viagem");;
                }
                if (!verificaValores(caminhao)) {
                    etapaSelecionada.getCaminhao().setStatus("Ocioso");
                    caminhaoSelecionado.setStatus("Em viagem");
                }
                if (!verificaValores(carreta1)) {
                    etapaSelecionada.getCarreta().setStatus("Ocioso");
                    carretaSelecionada.setStatus("Em viagem");
                }
                if (!verificaValores(carreta2)) {
                    etapaSelecionada.getCarreta().setStatus("Ocioso");
                    carretaSelecionada.setStatus("Em viagem");
                }
    }

}
