import controller.LoginController;
import controller.MenuController;
import util.Limpar;

public class App {
    public static void main(String[] args) {

        LoginController login = new LoginController();
        MenuController menu = new MenuController();

        while (true) {
            int resultado = login.fazerLogin();

            // encerrar sistema
            if (resultado == -9) {
                Limpar.terminal();
                System.out.println("Sistema encerrado.");
                break;
            }

            // login inválido
            if (resultado == -1) {
                System.out.println("Login inválido. Tente novamente.\n");
                continue;
            }

            // login válido → menu
            menu.exibirMenu(resultado);
        }
    }
}
