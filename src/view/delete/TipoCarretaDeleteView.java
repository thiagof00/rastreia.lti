package view.delete;

import java.util.List;
import java.util.Scanner;

import model.TipoCarreta;
import repository.TipoCarretaRepository;

public class TipoCarretaDeleteView {

    Scanner input = new Scanner(System.in);
    public int formularioExcluirTipoCarreta(){

        List<TipoCarreta> tipoCarretas = TipoCarretaRepository.listar();

        System.out.println("\n========== LISTA DE TIPO DE CARRETAS ==========");
        System.out.printf("%-4s | %-15s | %s | %-15s%n","ID", "TIPO","CAPACIDADE","Quantidade de Placas");
        System.out.println("-".repeat(53));
        for (TipoCarreta tc : tipoCarretas) {
            System.out.printf(
                    "%-4d | %-15s | %-10s | %-15s%n",
                    tc.getId(),
                    tc.getTipo(),
                    tc.getCapacidade(),
                    tc.getQtdPlacas());
        }

        
        System.out.println("Digite o id do tipo da carreta a ser excluido: ");
        int id = input.nextInt();
        input.nextLine();

        return id;
    
    }
}
