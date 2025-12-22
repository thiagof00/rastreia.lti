package controller;

import util.Limpar;
import view.MenuView;
public class MenuController {

    private MenuView view;
    private subMenuController submenu;

    public MenuController() {
        this.view = new MenuView();
        this.submenu = new subMenuController(view);
    }

    public void exibirMenu(int tipoUsuario) {
        if (tipoUsuario == 1) {
            menuAdmin();
        } else {
            menuCliente();
        }
    }

    /* =========================
       MENU ADMIN
       ========================= */
    private void menuAdmin() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuPrincipalAdmin();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    submenu.submenuCargas();
                    break;

                case 2:
                    Limpar.terminal();
                    submenu.submenuMotoristas();
                    break;
                case 3:
                    Limpar.terminal();
                    submenu.submenuCarreta();
                    break;
                case 4:
                    Limpar.terminal();
                    submenu.submenuTipoCarreta();
                    break;
                case 5:
                    view.emConstrucao();
                    break;

                case 0:
                    view.sair();
                    break;

                default:
                    view.invalido();
            }
        }
    }

    /* =========================
       MENU CLIENTE
       ========================= */
    private void menuCliente() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuPrincipalCliente();

            switch (opcao) {
                case 1:
                    view.listarCargasSimuladas();
                    break;

                case 0:
                    view.sair();
                    break;

                default:
                    view.invalido();
            }
        }
    }
}
