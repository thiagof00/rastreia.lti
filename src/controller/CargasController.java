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
    private EtapasController etapasController;

    public CargasController() {
        this.formView = new CargaFormView();
        this.listView = new CargaListView();
        this.etapasController = new EtapasController();
    }

    /*
     * =========================
     * CADASTRO DE CARGA
     * =========================
     */
    public void cadastrar() {
        Carga cargaEetapa = formView.formularioCadastroCarga();
        
        if (cargaEetapa == null){
            return;
        }
        Carga carga = new Carga(cargaEetapa.getInvoice(), cargaEetapa.getPO(), cargaEetapa.getNotaFiscal(), cargaEetapa.getOrigem(), cargaEetapa.getLocalidade(), cargaEetapa.getDestino(), cargaEetapa.getStatus());

        EtapasTransporte etapa = new EtapasTransporte(carga, cargaEetapa.getCaminhao(), cargaEetapa.getCarreta1(), cargaEetapa.getCarreta2(), cargaEetapa.getMotorista(), cargaEetapa.getOrigem(), cargaEetapa.getproximaParada(), cargaEetapa.getStatus());

        CargaRepository.salvar(carga);

        EtapasTransporteRepository.salvar(etapa);

        System.out.println("Carga cadastrada com sucesso!");
        aguardarVoltar.Voltar();
    }
    public void listarComEtapa(){
        List<Carga> cargas = CargaRepository.listar();
        int escolhaEtapa = listView.listarCargas(cargas);
        if (escolhaEtapa == 0) {
            return;
        } else {
            etapasController.listar(escolhaEtapa);
        }
    }

    public void listar(){
        List<Carga> cargas = CargaRepository.listar();
    }
}
