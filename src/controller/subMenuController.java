package controller;

import util.Limpar;
import util.mostrar;
import view.menu.*;

public class subMenuController {

    private CargaMenuView cargaMenuView;
    private MotoristaMenuView motoristaMenuView;
    private CarretaMenuView carretaMenuView;
    private CaminhaoMenuView caminhaoMenuView;

    private CargasController cargasController;
    private MotoristasController motoristasController;
    private CarretaController carretasController;
    private CaminhoesController caminhoesController;


    public subMenuController() {
        this.cargaMenuView = new CargaMenuView();
        this.motoristaMenuView = new MotoristaMenuView();
        this.carretaMenuView = new CarretaMenuView();
        this.caminhaoMenuView = new CaminhaoMenuView();
        this.cargasController = new CargasController();
        this.motoristasController = new MotoristasController();
        this.carretasController = new CarretaController();
        this.caminhoesController = new CaminhoesController();
    }

    public void submenuCargas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = cargaMenuView.menuCargas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    cargasController.listarComEtapa();
                    break;

                case 2:
                    Limpar.terminal();
                    cargasController.cadastrar();
                    break;
                case 3:        
                    cargasController.alterar();           
                case 4:
                    mostrar.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    mostrar.invalido();
                    break;
            }
        }
    }

    public void submenuMotoristas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = motoristaMenuView.menuMotoristas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    motoristasController.listar();
                    break;

                case 2:
                    Limpar.terminal();
                    motoristasController.cadastrar();
                    break;
                case 3:
                    mostrar.emConstrucao();
                    break;
                case 4:
                    motoristasController.excluir();
                    break;
                case 0:
                    Limpar.terminal();
                    break;

                default:
                    mostrar.invalido();
            }
        }
    }



    public void submenuCarreta() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = carretaMenuView.menuCarretas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    carretasController.listar();
                    break;
                case 2:
                    Limpar.terminal();
                    carretasController.cadastrar();
                    break;
                case 4:
                    Limpar.terminal();
                    carretasController.excluir();
                    break;
                case 3:
                    mostrar.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    mostrar.invalido();
            }
        }
    }

    public void submenuCaminhao() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = caminhaoMenuView.menuCaminhao();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    caminhoesController.listar();
                    break;
                case 2:
                    Limpar.terminal();
                    caminhoesController.cadastrar();
                    break;
                case 4:
                    Limpar.terminal();    
                    caminhoesController.excluir();
                    break;
                case 3:
                    mostrar.emConstrucao();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    mostrar.invalido();
            }
        }
    }

}
