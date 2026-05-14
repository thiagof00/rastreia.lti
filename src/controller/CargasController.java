package controller;

import java.util.List;

import model.Caminhao;
import model.Carga;
import model.Carreta;
import model.EtapasTransporte;
import model.Motorista;
import repository.CaminhaoRepository;
import repository.CargaRepository;
import repository.CarretaRepository;
import repository.EtapasTransporteRepository;
import repository.MotoristaRepository;
import util.Limpar;
import util.AguardarVoltar;
import view.form.CargaFormView;
import view.form.EtapaFormView;
import view.list.CargaListView;
import view.menu.CargaMenuView;
import view.update.CargaStatusUpdateView;
import view.update.CargaUpdateView;

public class CargasController {

    private CargaMenuView menuView;
    private CargaFormView cargaFormView;
    private EtapaFormView etapaFormView;
    private CargaListView listView;
    private EtapasController etapasController;
    private CargaUpdateView cargaUpdateView;
    private CargaStatusUpdateView CargaStatusUpdateView;

    public CargasController() {
        this.menuView = new CargaMenuView();
        this.cargaFormView = new CargaFormView();
        this.etapaFormView = new EtapaFormView();
        this.listView = new CargaListView();
        this.etapasController = new EtapasController();
        this.cargaUpdateView = new CargaUpdateView();
        this.CargaStatusUpdateView = new CargaStatusUpdateView();
    }

    /*
     * =========================
     * CADASTRO DE CARGA
     * =========================
     */
    public void cadastrar() {
        Carga novaCarga = cargaFormView.formularioCadastroCarga();

        if (novaCarga == null) {
            return;
        }
        Carga carga = new Carga(novaCarga.getInvoice(), novaCarga.getPO(), novaCarga.getNotaFiscal(),
                novaCarga.getOrigem(), novaCarga.getLocalidade(), novaCarga.getDestino(), novaCarga.getStatus());

        CargaRepository.salvar(carga);
        List<Carga> cargas = CargaRepository.listar();

        int idCarga = cargas.getLast().getId();

        List<Carreta> carretas = CarretaRepository.listar();
        List<Motorista> motoristas = MotoristaRepository.listar();
        List<Caminhao> caminhoes = CaminhaoRepository.listar();

        EtapasTransporte novaEtapa = etapaFormView.formularioCadastroEtapa(idCarga, carretas, motoristas, caminhoes);
        EtapasTransporte etapa = new EtapasTransporte(idCarga, novaEtapa.getMotorista(), novaEtapa.getCaminhao(),
                novaEtapa.getCarreta1(), novaEtapa.getproxParada());

        // PENDENCIA: Ver carreta2

        EtapasTransporteRepository.salvar(etapa);

        System.out.println("Carga cadastrada com sucesso!");
        AguardarVoltar.Voltar();
    }

    public void listarComEtapa() {
        List<Carga> cargas = CargaRepository.listar();
        int escolhaEtapa = listView.listarCargas(cargas);
        if (escolhaEtapa == 0) {
            Limpar.terminal();
            return;
        } else {
            etapasController.listar(escolhaEtapa);
        }
    }

    public void alterar() {
        List<Carreta> carretas = CarretaRepository.listar();
        List<Motorista> motoristas = MotoristaRepository.listar();
        List<Caminhao> caminhoes = CaminhaoRepository.listar();
        List<Carga> cargas = CargaRepository.listar();
        Carga cargaAlterada = cargaUpdateView.updateCarga(cargas, carretas, motoristas, caminhoes);
        if (cargaAlterada == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < cargas.size(); i++) {
            if (cargas.get(i).getId() == cargaAlterada.getId()) {
                j = i;
            }
        }

        cargas.get(j).setInvoice(cargaAlterada.getInvoice());
        cargas.get(j).setPO(cargaAlterada.getPO());
        cargas.get(j).setNotaFiscal(cargaAlterada.getNotaFiscal());
        cargas.get(j).setLocalidade(cargaAlterada.getLocalidade());
        cargas.get(j).setDestino(cargaAlterada.getDestino());
        cargas.get(j).setOrigem(cargaAlterada.getOrigem());

        EtapasTransporte etapa = new EtapasTransporte(cargas.get(j), cargaAlterada.getPO(),
                cargaAlterada.getNotaFiscal(), cargaAlterada.getInvoice(), cargaAlterada.getCaminhao(),
                cargaAlterada.getCarreta1(), cargaAlterada.getCarreta2(), cargaAlterada.getMotorista(),
                cargaAlterada.getLocalidade(), cargaAlterada.getProximaParada(), cargaAlterada.getStatus());
        EtapasTransporteRepository.salvar(etapa);
        System.out.println("Carga alterada com sucesso!");
        AguardarVoltar.Voltar();

    }

    public void alterarStatus() {
        List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();
        List<Carga> cargas = CargaRepository.listar();
        Carga cargaAlterada = CargaStatusUpdateView.updateStatusCarga(cargas, etapas);
        if (cargaAlterada == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < cargas.size(); i++) {
            if (cargas.get(i).getId() == cargaAlterada.getId()) {
                j = i;
            }
        }
        cargas.get(j).setStatus("Concluída");
        EtapasTransporte etapa = new EtapasTransporte(cargas.get(j), cargaAlterada.getPO(),
                cargaAlterada.getNotaFiscal(), cargaAlterada.getInvoice(), cargaAlterada.getCaminhao(),
                cargaAlterada.getCarreta1(), cargaAlterada.getCarreta2(), cargaAlterada.getMotorista(),
                cargaAlterada.getLocalidade(), cargaAlterada.getProximaParada(), cargaAlterada.getStatus());
        EtapasTransporteRepository.salvar(etapa);
        System.out.println("Status da carga alterado com sucesso!");
        AguardarVoltar.Voltar();

    }

    public int exibirMenu() {
        return menuView.menuCargas();
    }
}
