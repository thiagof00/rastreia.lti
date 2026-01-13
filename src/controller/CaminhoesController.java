package controller;
import java.util.List;

import model.Caminhao;
import model.Carga;
import repository.CaminhaoRepository;
import repository.CargaRepository;
import repository.MotoristaRepository;
import util.aguardarVoltar;
import view.delete.CaminhaoDeleteView;
import view.form.CaminhaoFormView;
import view.list.CaminhaoListView;
public class CaminhoesController {
    private CaminhaoFormView formView;
    private CaminhaoListView listView;
    private CaminhaoDeleteView viewDelete;

    public CaminhoesController() {
        this.formView = new CaminhaoFormView();
        this.listView = new CaminhaoListView();
        this.viewDelete = new CaminhaoDeleteView();
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

    public void excluir(){
        int id = viewDelete.formularioExcluirCaminhao();

        List<Carga> cargas = CargaRepository.listar();
        for (Carga carga : cargas) {
            if(carga.getCaminhao().getId() == id) {
                System.out.println("Caminhão relacionado a um registro de carga, não foi possivel excluir.");
                aguardarVoltar.Voltar();
                return;
            }
        }

        if (id == 0) {
            System.out.println("ID não pode ser vazio.");
            aguardarVoltar.Voltar();
            return;
        }

        boolean excluido = CaminhaoRepository.excluir(id);

        if(excluido){
            System.out.println("Caminhão removido com sucesso!");
        }else{
            System.out.println("Caminhão não encontrado");
        }
        aguardarVoltar.Voltar();

    }
}
