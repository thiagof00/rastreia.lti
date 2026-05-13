package controller;

import util.Limpar;
import util.Mostrar;

public class SubMenuController {

    private CargasController cargasController;
    private MotoristasController motoristasController;
    private CarretaController carretasController;
    private CaminhoesController caminhoesController;

    public SubMenuController() {

        this.cargasController = new CargasController();
        this.motoristasController = new MotoristasController();
        this.carretasController = new CarretaController();
        this.caminhoesController = new CaminhoesController();
    }

    public void submenuCargas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = cargasController.exibirMenu();

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
                    Limpar.terminal();
                    cargasController.alterar();
                    break;

                case 4:
                    Limpar.terminal();
                    cargasController.alterarStatus();
                    break;

                case 0:
                    Limpar.terminal();
                    break;

                default:
                    Mostrar.invalido();
                    break;
            }
        }
    }

    public void submenuMotoristas() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = motoristasController.exibirMenu();

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
                    Limpar.terminal();
                    motoristasController.excluir();
                    break;
                case 0:
                    Limpar.terminal();
                    break;

                default:
                    Mostrar.invalido();
            }
        }
    }

    public void submenuCarreta() {

        int opcao = -1;

        while (opcao != 0) {
            opcao = carretasController.exibirMenu();

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
                    Limpar.terminal();
                    carretasController.excluir();
                    break;
                case 0:
                    Limpar.terminal();
                    break;

                default:
                    Mostrar.invalido();
            }
        }
    }

    public void submenuCaminhao() {
        int opcao = -1;

        while (opcao != 0) {
            opcao = caminhoesController.exibirMenu();

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
                    Limpar.terminal();
                    caminhoesController.excluir();
                    break;
                case 0:
                    Limpar.terminal();
                    break;

                default:
                    Mostrar.invalido();
            }
        }
    }

}
