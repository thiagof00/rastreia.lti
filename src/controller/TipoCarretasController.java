package controller;

import model.TipoCarreta;
import repository.TipoCarretaRepository;
import view.MenuView;

public class TipoCarretasController {
    private MenuView view;

    public TipoCarretasController(MenuView view) {
        this.view = view;
    }

    public void cadastrar() {
        TipoCarreta tipoCarreta = view.formularioCadastroTipoCarreta();

        if (tipoCarreta == null) {
            return;
        }
        TipoCarretaRepository.salvar(tipoCarreta);

        System.out.println("Tipo de Carreta cadastrado com sucesso!");
        view.aguardarVoltar();
    }
}
