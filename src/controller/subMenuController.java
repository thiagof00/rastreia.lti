package controller;

import repository.*;
import util.Limpar;
import view.MenuView;

public class subMenuController {

    private MenuView view;
    private CargasController CargaController;
    private MotoristasController MotoristasController;
    private TipoCarretasController tipoCarretasController;
    private CarretaController carretaController;

    public subMenuController(MenuView view) {
        this.view = view;
        this.CargaController = new CargasController(view);
        this.MotoristasController = new MotoristasController(view);
        this.tipoCarretasController = new TipoCarretasController(view);
        this.carretaController = new CarretaController(view);
    }

    public void submenuCargas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuCargas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarCargas(CargaRepository.listar());
                    break;

                case 2:
                    Limpar.terminal();
                    CargaController.cadastrar();
                    break;
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

    public void submenuMotoristas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuMotoristas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarMotoristas(MotoristaRepository.listar());
                    break;

                case 2:
                    Limpar.terminal();
                    MotoristasController.cadastrar();
                    break;
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

    public void submenuTipoCarreta() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuTipoCarretas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarTiposCarretas(TipoCarretaRepository.listar());
                    break;

                case 2:
                    Limpar.terminal();
                    tipoCarretasController.cadastrar();
                    break;
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

    public void submenuCarreta() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuCarretas();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarCarretas(CarretaRepository.listar());
                    break;
                case 2:
                    Limpar.terminal();
                    carretaController.cadastrar();
                    break;
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

    public void submenuCaminhao() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = view.menuCaminhao();

            switch (opcao) {
                case 1:
                    Limpar.terminal();
                    view.listarCaminhoes(CaminhaoRepository.listar());
                    break;
                case 2:
                    Limpar.terminal();
                    new CaminhoesController(view).cadastrar();
                    break;
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
