package controller;

import model.Usuario;
import view.LoginView;
import util.ConfigLoader;

public class LoginController {

    public int fazerLogin() {
        LoginView view = new LoginView();
        view.boasVindas();

        Usuario admin = new Usuario(
                ConfigLoader.get("admin.username"),
                ConfigLoader.get("admin.password"),
                Integer.parseInt(ConfigLoader.get("admin.role")));

        Usuario cliente = new Usuario(
                ConfigLoader.get("cliente.username"),
                ConfigLoader.get("cliente.password"),
                Integer.parseInt(ConfigLoader.get("cliente.role")));

        while (true) {
            String usuario = view.pedirUsuario();

            if (usuario.equals("0")) {
                return -9;
            }

            String senha = view.pedirSenha();

            if (usuario.equals(admin.getUsername()) && senha.equals(admin.getPassword())) {
                view.sucessoAdmin(usuario);
                return 1;
            } else if (usuario.equals(cliente.getUsername()) && senha.equals(cliente.getPassword())) {
                view.sucessoCliente();
                return 0;
            } else {
                view.erro();
            }
        }
    }
}
