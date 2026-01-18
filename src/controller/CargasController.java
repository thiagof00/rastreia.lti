package controller;

import java.util.List;

import model.Carga;
import model.EtapasTransporte;
import repository.CargaRepository;
import repository.EtapasTransporteRepository;
import util.aguardarVoltar;
import view.form.CargaFormView;
import view.list.CargaListView;
import view.update.CargaUpdateView;
public class CargasController {

    private CargaFormView formView;
    private CargaListView listView;
    private EtapasController etapasController;
    private CargaUpdateView cargaUpdateView;

    public CargasController() {
        this.formView = new CargaFormView();
        this.listView = new CargaListView();
        this.etapasController = new EtapasController();
        this.cargaUpdateView = new CargaUpdateView();
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
    public void alterar(){
        List<Carga> cargas = CargaRepository.listar();
        Carga cargaAlterada = cargaUpdateView.updateCarga(cargas);
        int j=0;
        for (int i = 0; i < cargas.size(); i++) {
            if (cargas.get(i).getId() == cargaAlterada.getId()){
                j = i;
            }
        }

        cargas.get(j).setInvoice(cargaAlterada.getInvoice());
        cargas.get(j).setPO(cargaAlterada.getPO());
        cargas.get(j).setNotaFiscal(cargaAlterada.getNotaFiscal());
        cargas.get(j).setLocalidade(cargaAlterada.getLocalidade());
        cargas.get(j).setDestino(cargaAlterada.getDestino());
        cargas.get(j).setOrigem(cargaAlterada.getOrigem());

        
        EtapasTransporte etapa = new EtapasTransporte(cargas.get(j), cargaAlterada.getCaminhao(), cargaAlterada.getCarreta1(), cargaAlterada.getCarreta2(), cargaAlterada.getMotorista(), cargaAlterada.getLocalidade(),cargaAlterada.getproximaParada(), cargaAlterada.getStatus());
        EtapasTransporteRepository.salvar(etapa);
        System.out.println("Carga alterado com sucesso!");



    }
    public void listar(){
    List<Carga> cargas = CargaRepository.listar();

    }
}
