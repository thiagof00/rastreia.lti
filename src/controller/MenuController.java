package controller;

import util.*;
import view.menu.MenuPrincipalView;

public class MenuController {

    private subMenuController submenu;
    private CargasController listview;
    public MenuController() {
        this.submenu = new subMenuController();
        this.listview = new CargasController();
    }

    public void exibirMenu(int tipoUsuario) {
        if (tipoUsuario == 1) {
            menuAdmin();
        } else {
            menuCliente();
        }
    }

    /*
     * =========================
     * MENU ADMIN
     * =========================
     */
    private void menuAdmin() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = MenuPrincipalView.menuPrincipalAdmin();

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
                    submenu.submenuCaminhao();
                    break;
                case 5:
                    Limpar.terminal();
                    mostrar.emConstrucao();
                    break;

                case 0:
                    mostrar.sair();
                    return;

                default:
                    mostrar.invalido();
            }
        }
    }

    /*
     * =========================
     * MENU CLIENTE
     * =========================
     */
    private void menuCliente() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = MenuPrincipalView.menuPrincipalCliente();

            switch (opcao) {
                case 1:
                    listview.listar();
                    break;

                case 0:
                    mostrar.sair();
                    return;

                default:
                    mostrar.invalido();
            }
        }
    }
}
