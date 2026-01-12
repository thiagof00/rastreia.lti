package controller;

import java.util.List;

import model.Carga;
import repository.CargaRepository;
import util.aguardarVoltar;
import view.form.CargaFormView;
import view.list.CargaListView;
public class CargasController {

    private CargaFormView formView;
    private CargaListView listView;

    public CargasController() {
        this.formView = new CargaFormView();
        this.listView = new CargaListView();
    }

    /*
     * =========================
     * CADASTRO DE CARGA
     * =========================
     */
    public void cadastrar() {
        Carga carga = formView.formularioCadastroCarga();

        if (carga == null) {
            return;
        }

        CargaRepository.salvar(carga);

        System.out.println("Carga cadastrada com sucesso!");
        aguardarVoltar.Voltar();
    }
    public void listar(){
        List<Carga> cargas = CargaRepository.listar();
        listView.listarCargas(cargas);
    }
}
