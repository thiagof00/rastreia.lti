package view.form;

import java.util.Scanner;

import model.TipoCarreta;
import util.aguardarVoltar;

public class TipoCarretaFormView {
    Scanner input = new Scanner(System.in);
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
                aguardarVoltar.Voltar();
            return null;
        }
    }
}
