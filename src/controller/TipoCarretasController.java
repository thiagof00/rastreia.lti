package controller;

import java.util.List;

import model.TipoCarreta;
import repository.TipoCarretaRepository;
import util.aguardarVoltar;
import view.form.TipoCarretaFormView;
import view.delete.TipoCarretaDeleteView;
import view.list.TipoCarretaListView;

public class TipoCarretasController {

    private final TipoCarretaFormView formView;
    private final TipoCarretaDeleteView deleteView;
    private final TipoCarretaListView listView;

    public TipoCarretasController() {
        this.formView = new TipoCarretaFormView();
        this.deleteView = new TipoCarretaDeleteView();
        this.listView = new TipoCarretaListView();
    }

    /* =========================
     * LISTAR
     * ========================= */
    public void listar() {
        List<TipoCarreta> tipos = TipoCarretaRepository.listar();
        listView.listarTiposCarretas(tipos);
        aguardarVoltar.Voltar();
    }

    /* =========================
     * CADASTRAR
     * ========================= */
    public void cadastrar() {
        TipoCarreta tipoCarreta = formView.formularioCadastroTipoCarreta();

        if (tipoCarreta == null) return;

        TipoCarretaRepository.salvar(tipoCarreta);
        System.out.println("Tipo de carreta cadastrado com sucesso!");
        aguardarVoltar.Voltar();
    }

    /* =========================
     * EXCLUIR
     * ========================= */
    public void excluir() {
        int id = deleteView.formularioExcluirTipoCarreta();

        if (id <= 0) return;

        int resultado = TipoCarretaRepository.excluir(id);

        switch (resultado) {
            case 1:
                System.out.println("Tipo removido com sucesso!");
                break;
            case 0:
                System.out.println("Tipo não encontrado.");
                break;
            case -1:
                System.out.println("Tipo associado a uma carreta, não é possível excluir.");
                break;
            default:
                System.out.println("Erro ao excluir tipo de carreta.");
        }

        aguardarVoltar.Voltar();
    }
}
