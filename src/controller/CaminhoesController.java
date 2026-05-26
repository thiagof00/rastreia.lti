package controller;

import java.util.List;
import model.Caminhao;
import model.EtapasTransporte;
import repository.CaminhaoRepository;
import repository.EtapasTransporteRepository;
import util.AguardarVoltar;
import view.delete.CaminhaoDeleteView;
import view.form.CaminhaoFormView;
import view.list.CaminhaoListView;
import view.menu.CaminhaoMenuView;
import view.update.CaminhaoUpdateView;

public class CaminhoesController {
    private CaminhaoFormView formView;
    private CaminhaoListView listView;
    private CaminhaoDeleteView deleteView;
    private CaminhaoMenuView menuView;
    private CaminhaoUpdateView updateView;

    public CaminhoesController() {
        this.formView = new CaminhaoFormView();
        this.listView = new CaminhaoListView();
        this.deleteView = new CaminhaoDeleteView();
        this.menuView = new CaminhaoMenuView();
        this.updateView = new CaminhaoUpdateView();
    }

    public void cadastrar() {
        model.Caminhao caminhao = formView.formularioCadastroCaminhao();

        if (caminhao == null) {
            return;
        }
        repository.CaminhaoRepository.salvar(caminhao);

        System.out.println("Caminhão cadastrado com sucesso!");
        AguardarVoltar.Voltar();
        ;
    }

    public void listar() {
        List<Caminhao> caminhoes = CaminhaoRepository.listar();
        listView.listarCaminhoes(caminhoes);
    }

    public void excluir() {
        int id = deleteView.formularioExcluirCaminhao();

        List<EtapasTransporte> etapasTransportes = EtapasTransporteRepository.listar();
        for (EtapasTransporte etapa : etapasTransportes) {
            if (etapa.getCaminhao().getId() == id) {
                System.out
                        .println("Caminhão relacionado a um registro de etapa de uma carga, não foi possivel excluir.");
                AguardarVoltar.Voltar();
                return;
            }
        }

        if (id == 0) {
            System.out.println("ID não pode ser vazio.");
            AguardarVoltar.Voltar();
            return;
        }

        boolean excluido = CaminhaoRepository.excluir(id);

        if (excluido) {
            System.out.println("Caminhão removido com sucesso!");
        } else {
            System.out.println("Caminhão não encontrado");
        }
        AguardarVoltar.Voltar();

    }

    public void atualizarCaminhao() {

        List<Caminhao> caminhoes = CaminhaoRepository.listar();

        Caminhao alterado = updateView.updateCaminhao(caminhoes);
        Caminhao caminhaoSelecionadoParaAlterar = CaminhaoRepository.getCaminhaoPorId(alterado.getId());

        caminhaoSelecionadoParaAlterar
                .setPlaca(alterado.getPlaca());
        caminhaoSelecionadoParaAlterar
                .setTipo(alterado.getTipo());
        caminhaoSelecionadoParaAlterar
                .setStatus(alterado.getStatus());

        System.out.println("Caminhão alterado com sucesso!");
    }

    public int exibirMenu() {
        return menuView.menuCaminhao();
    }
}
