package controller;

import model.Carga;
import repository.CargaRepository;
import view.MenuView;

public class CargasController {
    private MenuView view;

    public CargasController(MenuView view) {
        this.view = view;
    }

    public void cadastrar() {
        Carga carga = view.formularioCadastroCarga();

        if (carga == null) {
            return;
        }

        CargaRepository.salvar(carga);

        System.out.println("Carga cadastrada com sucesso!");
        view.aguardarVoltar();
    }
}
