package view.delete;

import java.util.List;
import java.util.Scanner;

import model.Motorista;
import repository.MotoristaRepository;
import util.*;

public class MotoristaDeleteView {

        Scanner input = new Scanner(System.in);

    public String formularioExcluirMotorista(){

        List<Motorista> motoristas = MotoristaRepository.listar();
        System.out.println("\n========== LISTA DE MOTORISTAS ==========");

        System.out.printf("%-4s | %-15s | %-15s | %-15s%n", "ID", "NOME", "CPF", "STATUS");
        System.out.println("-".repeat(58));
        for (Motorista m : motoristas) {
            System.out.printf(
                    "%-4d | %-15s | %-15s | %-15s%n",
                    m.getId(),
                    m.getNome(),
                    m.getCpf(),
                    m.getStatus());
        }
        
        System.out.println("Digite o cpf do motorista a ser excluido: ");
        String cpf = input.nextLine();

        if (cpf.isBlank()) {
            System.out.println("CPF não pode ser vazio.");
            aguardarVoltar.Voltar();
            return null;
        }

        return cpf;
    
    }
}
