package controller;

import model.Carreta;
import view.MenuView;
import repository.CarretaRepository;

public class CarretaController {
    private MenuView view;

    public CarretaController(MenuView view) {
        this.view = view;
    }

    public void cadastrar() {
        Carreta carreta = view.formularioCadastroCarreta();

        if (carreta == null) {
            return;
        }
        CarretaRepository.salvar(carreta);

        System.out.println("Carreta cadastrada com sucesso!");
        view.aguardarVoltar();
    }
}
