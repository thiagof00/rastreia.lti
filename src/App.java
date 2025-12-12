//package rastreia.lti;

import controller.LoginController;
import controller.MenuController;

public class App {
    public static void main(String[] args) throws Exception {

        LoginController login = new LoginController();
        int resultado = login.fazerLogin();

        MenuController menu = new MenuController();
        menu.exibirMenu(resultado);
    }
}
