package view.form;

import java.util.Scanner;

import model.Caminhao;
import util.*;

public class CaminhaoFormView {

        Scanner input = new Scanner(System.in);

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
            aguardarVoltar.Voltar();
            return null;
        }
    }
}
