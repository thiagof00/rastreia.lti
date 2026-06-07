package controller;

import java.util.ArrayList;
import java.util.List;

import model.Caminhao;
import model.Carga;
import model.Carreta;
import model.EtapasTransporte;
import model.Motorista;
import model.enums.*;
import repository.*;
import util.Limpar;
import util.AguardarVoltar;
import view.delete.CargaDeleteView;
import view.form.CargaFormView;
import view.list.CargaListView;
import view.list.EtapasTransporteListView;
import view.menu.CargaMenuView;
import view.update.CargaStatusUpdateView;
import view.update.CargaUpdateView;
import view.update.EtapaUpdateView;

public class CargasController {

    private CargaMenuView menuView;
    private CargaFormView cargaFormView;
    private CargaListView listView;
    private EtapasTransporteListView listViewEtapa;
    private EtapaUpdateView etapaUpdateView;
    private CargaUpdateView cargaUpdateView;
    private CargaStatusUpdateView cargaStatusUpdateView;
    private CargaDeleteView cargaDeleteView;
    private EtapasController etapasController;

    public CargasController() {
        this.menuView = new CargaMenuView();
        this.cargaFormView = new CargaFormView();
        this.listView = new CargaListView();
        this.listViewEtapa = new EtapasTransporteListView();
        this.cargaUpdateView = new CargaUpdateView();
        this.cargaStatusUpdateView = new CargaStatusUpdateView();
        this.etapaUpdateView = new EtapaUpdateView();
        this.cargaDeleteView = new CargaDeleteView();
        this.etapasController = new EtapasController();
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

        if (LoginController.isUsuarioAdmin()) {
            List<Carga> cargas = CargaRepository.listar();
            int idCarga = cargas.getLast().getId();
            String cargaLocalidade = carga.getLocalidade();

            boolean etapaCriada = etapasController.atualizarEtapa(idCarga, cargaLocalidade);

            if (etapaCriada) {
                cargas.getLast().setStatus(StatusViagem.EM_VIAGEM);
            } else {
                cargas.getLast().setStatus(StatusViagem.PENDENTE);
            }
        }

        System.out.println("Carga cadastrada com sucesso!");
        AguardarVoltar.Voltar();
    }

    public void listarComEtapa() {
        List<Carga> cargas = CargaRepository.listar();

        int escohaCarga = listView.listarCargas(cargas, false);
        if (escohaCarga == 0) {
            Limpar.terminal();
            return;
        } else {
            List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();
            List<EtapasTransporte> etapasSelecionadas = new ArrayList<>();
            Carga cargaSelecionada = CargaRepository.getCargaPorId(escohaCarga);
            for (EtapasTransporte etapa : etapas) {
                if (etapa.getIdCarga() == escohaCarga) {
                    etapasSelecionadas.add(etapa);
                }
            }

            listViewEtapa.listarEtapas(etapasSelecionadas, cargaSelecionada);
        }
    }

    public void listarCargasPendentes(){
        List<Carga> cargas = CargaRepository.listarPendentes();
        int escolhaCarga = listView.listarCargas(cargas, true);
        Carga carga = CargaRepository.getCargaPorId(escolhaCarga);
        if (escolhaCarga == 0) {
            Limpar.terminal();
            return;
        }else if (!carga.getStatus().equals(StatusViagem.PENDENTE)) {
            System.out.println("Opção inválida!");
            AguardarVoltar.Voltar();
            return;
        }
        else{
            String cargaLocalidade = carga.getLocalidade();

            boolean etapaCriada = etapasController.atualizarEtapa(escolhaCarga, cargaLocalidade);

            if (etapaCriada) {
                cargas.getLast().setStatus(StatusViagem.EM_VIAGEM);
                System.out.println("Carga alterada com sucesso!");
            } else {
                cargas.getLast().setStatus(StatusViagem.PENDENTE);
                System.out.println("A carga não foi alterada!");
            }
        }

    }
    
    public void alterar() {
        List<Carreta> carretas = CarretaRepository.listar();
        List<Motorista> motoristas = MotoristaRepository.listar();
        List<Caminhao> caminhoes = CaminhaoRepository.listar();
        List<Carga> cargas = CargaRepository.listar();

        int cargaEscolhida = listView.listarCargas(cargas, true);

        List<EtapasTransporte> etapasDaCarga = EtapasTransporteRepository.getEtapasTransportePorIdCarga(cargaEscolhida);
        EtapasTransporte ultimaEtapa = etapasDaCarga.getLast();
        Carga cargaSelecionada = CargaRepository.getCargaPorId(cargaEscolhida);

        Carga cargaAlterada = cargaUpdateView.updateCarga(ultimaEtapa, cargaSelecionada);

        if (cargaAlterada == null) {
            return;
        }

        EtapasTransporte etapaAlterada = etapaUpdateView.updateEtapa(carretas, motoristas, caminhoes,
                ultimaEtapa);

        verificaAlteracaoDeEtapa(ultimaEtapa, etapaAlterada);

        etapaAlterada.setUltimaLocalidade(cargaAlterada.getLocalidade());

        cargaSelecionada.setInvoice(cargaAlterada.getInvoice());
        cargaSelecionada.setPO(cargaAlterada.getPO());
        cargaSelecionada.setNotaFiscal(cargaAlterada.getNotaFiscal());
        cargaSelecionada.setLocalidade(cargaAlterada.getLocalidade());
        cargaSelecionada.setDestino(cargaAlterada.getDestino());
        cargaSelecionada.setOrigem(cargaAlterada.getOrigem());

        EtapasTransporteRepository.salvar(etapaAlterada);
        System.out.println("Carga alterada com sucesso!");
        AguardarVoltar.Voltar();

    }

    public void alterarStatus() {
        List<Carga> cargas = CargaRepository.listar();
        int idCargaSelecionada = listView.listarCargas(cargas, true);
        Carga cargaSelecionada = CargaRepository.getCargaPorId(idCargaSelecionada);

        boolean alterar = cargaStatusUpdateView.updateStatusCarga();

        if (alterar == false) {
            return;
        }
        cargaSelecionada.setStatus(StatusViagem.CONCLUIDO);

        List<EtapasTransporte> etapasDaCarga = EtapasTransporteRepository
                .getEtapasTransportePorIdCarga(idCargaSelecionada);
        EtapasTransporte ultimaEtapaRegistrada = etapasDaCarga.getLast();

        EtapasTransporte etapaDeConclusao = new EtapasTransporte(idCargaSelecionada,
                ultimaEtapaRegistrada.getMotorista(), ultimaEtapaRegistrada.getCaminhao(),
                ultimaEtapaRegistrada.getCarreta1(),
                "-");
        etapaDeConclusao.setUltimaLocalidade(cargaSelecionada.getDestino());
        cargaSelecionada.setLocalidade(cargaSelecionada.getDestino());

        if (ultimaEtapaRegistrada.getCarreta2() != null) {
            etapaDeConclusao.setCarreta2(ultimaEtapaRegistrada.getCarreta2());
            etapaDeConclusao.getCarreta2().setStatus(StatusVeiculo.OCIOSO);
        }

        EtapasTransporteRepository.salvar(etapaDeConclusao);
        etapaDeConclusao.getCaminhao().setStatus(StatusVeiculo.OCIOSO);
        etapaDeConclusao.getCarreta1().setStatus(StatusVeiculo.OCIOSO);
        etapaDeConclusao.getMotorista().setStatus(StatusMotorista.OCIOSO);

        System.out.println("Status da carga alterado com sucesso!");
        AguardarVoltar.Voltar();

    }

    public void excluirCarga() {
        List<Carga> cargas = CargaRepository.listar();
        int idCargaSelecionada = cargaDeleteView.formularioExcluirCarga(cargas);

        List<EtapasTransporte> etapasDaCarga = EtapasTransporteRepository
                .getEtapasTransportePorIdCarga(idCargaSelecionada);
        if (etapasDaCarga.getFirst() != etapasDaCarga.getLast()) {
            System.out.println("Não é possível excluir a carga\nA mesma possui mais de uma etapa registrada!");
            AguardarVoltar.Voltar();
            return;
        } else {
            boolean excluido = CargaRepository.excluir(idCargaSelecionada);

            if (excluido) {
                System.out.println("Carga removida com sucesso!");
                Carreta carreta2 = etapasDaCarga.getLast().getCarreta2();
                etapasDaCarga.getLast().getCarreta1().setStatus(StatusVeiculo.OCIOSO);
                etapasDaCarga.getLast().getCaminhao().setStatus(StatusVeiculo.OCIOSO);
                etapasDaCarga.getLast().getMotorista().setStatus(StatusMotorista.OCIOSO);

                if (carreta2 == null) {

                    // Adicionar excluir etapa----------------------------------------

                    return;
                } else {

                    // Adicionar excluir etapa----------------------------------------

                    carreta2.setStatus(StatusVeiculo.OCIOSO);
                    return;
                }

            } else {
                System.out.println("Carga não encontrada");
            }
        }
    }

    public int exibirMenu() {
        return menuView.menuCargas();
    }

    private void verificaAlteracaoDeEtapa(EtapasTransporte ultimaEtapa, EtapasTransporte etapaNova) {

        if (ultimaEtapa.getCaminhao() != etapaNova.getCaminhao()) {
            ultimaEtapa.getCaminhao().setStatus(StatusVeiculo.OCIOSO);
            etapaNova.getCaminhao().setStatus(StatusVeiculo.EM_VIAGEM);
        }
        if (ultimaEtapa.getMotorista() != etapaNova.getMotorista()) {
            ultimaEtapa.getMotorista().setStatus(StatusMotorista.OCIOSO);
            etapaNova.getMotorista().setStatus(StatusMotorista.EM_VIAGEM);
        }
        if (ultimaEtapa.getCarreta1() != etapaNova.getCarreta1()) {
            ultimaEtapa.getCarreta1().setStatus(StatusVeiculo.OCIOSO);
            etapaNova.getCarreta1().setStatus(StatusVeiculo.EM_VIAGEM);
        }
        if (ultimaEtapa.getCarreta2() != etapaNova.getCarreta2()) {

            if (ultimaEtapa.getCarreta2() == null) {
                etapaNova.getCarreta2().setStatus(StatusVeiculo.EM_VIAGEM);
            } else {
                ultimaEtapa.getCarreta2().setStatus(StatusVeiculo.OCIOSO);
                etapaNova.getCarreta2().setStatus(StatusVeiculo.EM_VIAGEM);
            }
        }
    }
}
