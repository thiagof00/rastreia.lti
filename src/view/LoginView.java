package view;

import java.util.Scanner;

import util.Limpar;

public class LoginView {
    private Scanner input = new Scanner(System.in);

    public String pedirUsuario() {
        System.out.print("Usuário: ");
        return input.nextLine();
    }

    public String pedirSenha() {
        System.out.print("Senha: ");
        return input.nextLine();
    }

    public void boasVindas() {
        System.out.println("=====================================");
        System.out.println("           RASTREIA.LTI              ");
        System.out.println("=====================================");
    }

    public void erro() {
        System.out.println("Falha no login. Tente novamente.\n");
    }

    public void sucessoAdmin(String user) {
        Limpar.terminal();
        System.out.println("Usuário ADMIN logado! Bem-vindo " + user + "\n");
    }

    public void sucessoCliente() {
        Limpar.terminal();
        System.out.println("Usuário CLIENTE logado!\n");
    }
}
