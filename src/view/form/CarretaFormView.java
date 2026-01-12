package view.form;

import java.util.List;
import java.util.Scanner;

import model.Carreta;
import model.TipoCarreta;
import repository.TipoCarretaRepository;
import util.*;
public class CarretaFormView {

        Scanner input = new Scanner(System.in);

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
                aguardarVoltar.Voltar();
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
            aguardarVoltar.Voltar();
            return null;
        }
    }
}
