package controller;

import util.Limpar;
import util.mostrar;
import view.menu.*;

public class subMenuController {

    private final CargaMenuView cargaMenuView;
    private final MotoristaMenuView motoristaMenuView;
    private final CarretaMenuView carretaMenuView;
    private final CaminhaoMenuView caminhaoMenuView;
    private final TipoCarretaMenuView tipoCarretaMenuView;

    private final CargasController cargasController;
    private final MotoristasController motoristasController;
    private final CarretaController carretasController;
    private final TipoCarretasController tipoCarretasController;
    private final CaminhoesController caminhoesController;

    public subMenuController() {
        this.cargaMenuView = new CargaMenuView();
        this.motoristaMenuView = new MotoristaMenuView();
        this.carretaMenuView = new CarretaMenuView();
        this.caminhaoMenuView = new CaminhaoMenuView();
        this.tipoCarretaMenuView = new TipoCarretaMenuView();

        this.cargasController = new CargasController();
        this.motoristasController = new MotoristasController();
        this.carretasController = new CarretaController();
        this.tipoCarretasController = new TipoCarretasController();
        this.caminhoesController = new CaminhoesController();
    }

    public void submenuCargas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = cargaMenuView.menuCargas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    cargasController.listar();
                    break;

                case 2:
                    Limpar.terminal();
                    cargasController.cadastrar();
                    break;
                case 3:
                case 4:
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

    public void submenuTipoCarreta() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = tipoCarretaMenuView.menuTipoCarretas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    tipoCarretasController.listar();
                    break;

                case 2:
                    Limpar.terminal();
                    tipoCarretasController.cadastrar();
                    break;
                case 3:
                    mostrar.emConstrucao();
                    break;
                case 4:
                    tipoCarretasController.excluir();
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
                case 3:
                case 4:
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
                case 3:
                case 4:
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
