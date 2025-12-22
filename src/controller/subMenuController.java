package controller;

import util.Limpar;
import view.MenuView;

public class subMenuController {
    
     private  MenuView view;
     
     public subMenuController(MenuView view) {
        this.view = view;
    }

     public  void submenuCargas() {
        
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuCargas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarCargasSimuladas();
                    break;

                case 2:
                case 3:
                case 4:
                    view.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    view.invalido();
            }
        }
    }


    public  void submenuMotoristas() {
        
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuMotoristas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarMotoristasSimulados();
                    break;

                case 2:
                case 3:
                case 4:
                    view.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    view.invalido();
            }
        }
    }
    public  void submenuTipoCarreta() {
        
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuTipoCarretas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarTiposCarretas();
                    break;

                case 2:
                case 3:
                case 4:
                    view.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    view.invalido();
            }
        }
    }

    public  void submenuCarreta() {
        
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuCarretas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarCarretas();
                    break;

                case 2:
                case 3:
                case 4:
                    view.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    view.invalido();
            }
        }
    }

}
