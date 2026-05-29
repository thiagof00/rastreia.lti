package view.update;

import java.util.Scanner;

public class CargaStatusUpdateView {

    Scanner Input = new Scanner(System.in);

    public boolean updateStatusCarga() {

        System.out.println("\nDeseja atualizar o status da carga para 'Concluída'? ");
        System.out.println("1 - Sim");
        System.out.println("0 - Não (Cancelar)");
        int escolhaAlterar = Integer.parseInt(Input.nextLine());

        if (escolhaAlterar != 1) {
            return false;
        } else {
            return true;
        }

    }

}
