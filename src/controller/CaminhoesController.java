package controller;
import java.util.List;

import model.Caminhao;
import repository.CaminhaoRepository;
import util.aguardarVoltar;
import view.form.CaminhaoFormView;
import view.list.CaminhaoListView;
public class CaminhoesController {
    private CaminhaoFormView formView;
    private CaminhaoListView listView;

    public CaminhoesController() {
        this.formView = new CaminhaoFormView();
        this.listView = new CaminhaoListView();
    }

    public void cadastrar() {
        model.Caminhao caminhao = formView.formularioCadastroCaminhao();

        if (caminhao == null) {
            return;
        }
        repository.CaminhaoRepository.salvar(caminhao);

        System.out.println("Caminhão cadastrado com sucesso!");
        aguardarVoltar.Voltar();;
    }
    public void listar(){
        List<Caminhao> caminhoes = CaminhaoRepository.listar();
        listView.listarCaminhoes(caminhoes);
    }
}
