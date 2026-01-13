package view.delete;

import java.util.List;
import java.util.Scanner;
import model.Carreta;
import repository.CarretaRepository;

public class CarretaDeleteView {
    Scanner input = new Scanner(System.in);

    public int formularioExcluirCarreta(){

        List<Carreta> carretas = CarretaRepository.listar();
        System.out.println("\n========== LISTA DE CARRETAS ==========");

        System.out.printf("%-4s | %-12s | %-14s | %-15s%n", "ID", "PLACA", "TIPO", "STATUS");
        System.out.println("-".repeat(58));
        for (Carreta c : carretas) {
            System.out.printf(
                    "%-4d | %-12s | %-12s | %-8d | %-8d | %-15s%n",
                    c.getId(),
                    c.getPlaca(),
                    c.getTipo(),
                    c.getPeso_max(),
                    c.getMetragem(),
                    c.getStatus());
        }
        
        System.out.println("Digite o ID da carreta a ser excluida: ");
        int id = input.nextInt();      
        
        return id;
    }
}
