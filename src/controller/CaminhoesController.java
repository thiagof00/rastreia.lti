package controller;

public class CaminhoesController {
    private view.MenuView view;

    public CaminhoesController(view.MenuView view) {
        this.view = view;
    }

    public void cadastrar() {
        model.Caminhao caminhao = view.formularioCadastroCaminhao();

        if (caminhao == null) {
            return;
        }
        repository.CaminhaoRepository.salvar(caminhao);

        System.out.println("Caminhão cadastrado com sucesso!");
        view.aguardarVoltar();
    }
}
