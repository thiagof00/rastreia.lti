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

    public void excluir() {
        String cpf = view.formularioExcluirMotorista();

        if (cpf == null) {
            return;
        }
        boolean excluido = MotoristaRepository.excluir(cpf);

        if (excluido) {
            System.out.println("Motorista removido com sucesso!");
        } else {
            System.out.println("motorista não encontrado");
        }
        view.aguardarVoltar();

    }
}
