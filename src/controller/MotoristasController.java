package controller;

import model.Motorista;
import repository.MotoristaRepository;
import view.MenuView;

public class MotoristasController {
    private MenuView view;

    public MotoristasController(MenuView view) {
        this.view = view;
    }

    public void cadastrar() {
        Motorista motorista = view.formularioCadastroMotorista();

        if (motorista == null) {
            return;
        }
        MotoristaRepository.salvar(motorista);

        System.out.println("Motorista cadastrado com sucesso!");
        view.aguardarVoltar();
    }
}
