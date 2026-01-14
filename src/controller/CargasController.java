package controller;

import java.util.List;

import model.Carga;
import model.EtapasTransporte;
import repository.CargaRepository;
import repository.EtapasTransporteRepository;
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
        Carga cargaEetapa = formView.formularioCadastroCarga();
        
        Carga carga = new Carga(cargaEetapa.getInvoice(), cargaEetapa.getPO(), cargaEetapa.getNotaFiscal(), cargaEetapa.getOrigem(), cargaEetapa.getDestino(), cargaEetapa.getStatus());

        EtapasTransporte etapa = new EtapasTransporte(carga, cargaEetapa.getCaminhao(), cargaEetapa.getCarreta1(), cargaEetapa.getCarreta2(), cargaEetapa.getMotorista(), cargaEetapa.getOrigem(), cargaEetapa.getDestino(), cargaEetapa.getStatus());

        CargaRepository.salvar(carga);

        EtapasTransporteRepository.salvar(etapa);

        System.out.println("Carga cadastrada com sucesso!");
        aguardarVoltar.Voltar();
    }
    public void listar(){
        List<Carga> cargas = CargaRepository.listar();
        listView.listarCargas(cargas);
    }
}
