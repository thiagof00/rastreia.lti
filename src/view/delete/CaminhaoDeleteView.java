package view.delete;

import java.util.List;
import java.util.Scanner;

import model.Caminhao;
import repository.CaminhaoRepository;

public class CaminhaoDeleteView {
    Scanner input = new Scanner(System.in);

    public int formularioExcluirCaminhao(){

        List<Caminhao> caminhoes = CaminhaoRepository.listar();
        System.out.println("\n========== LISTA DE CAMINHÕES ==========");

        System.out.printf("%-4s | %-15s | %-15s | %-15s%n", "ID", "PLACA", "TIPO", "STATUS");
        System.out.println("-".repeat(58));
        for (Caminhao c : caminhoes) {
            System.out.printf(
                    "%-4d | %-8s | %-15s | %-12s%n",
                    c.getId(),
                    c.getPlaca(),
                    c.getTipo(),
                    c.getStatus());
        }
        
        System.out.println("Digite o ID do caminhão a ser excluido: ");
        int id = input.nextInt();      
        
        return id;
    
    }
}
