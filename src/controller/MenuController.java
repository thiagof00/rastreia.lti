package controller;

import util.*;
import view.menu.MenuPrincipalView;

public class MenuController {

    private SubMenuController submenu;
    private CargasController listview;
    private MenuPrincipalView menuView;

    public MenuController() {
        this.menuView = new MenuPrincipalView();
        this.submenu = new SubMenuController();
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
            opcao = menuView.menuPrincipalAdmin();

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
                case 0:
                    Mostrar.sair();
                    return;

                default:
                    Mostrar.invalido();
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
            opcao = menuView.menuPrincipalCliente();

            switch (opcao) {
                case 1:
                    listview.listarComEtapa();
                    break;

                case 0:
                    Mostrar.sair();
                    return;

                default:
                    Mostrar.invalido();
            }
        }
    }
}
