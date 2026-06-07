package controller;

import java.util.List;

import model.Caminhao;
import model.Carreta;
import model.EtapasTransporte;
import model.Motorista;
import model.enums.StatusMotorista;
import model.enums.StatusVeiculo;
import repository.CaminhaoRepository;
import repository.CarretaRepository;
import repository.EtapasTransporteRepository;
import repository.MotoristaRepository;
import view.form.EtapaFormView;
import view.list.EtapasTransporteListView;

public class EtapasController {

    private EtapasTransporteListView listView;
    private EtapaFormView etapaFormView;

    public EtapasController() {
        this.listView = new EtapasTransporteListView();
        this.etapaFormView = new EtapaFormView();
    }

    public void listar(int id) {
        List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();

    }

    public boolean atualizarEtapa(int idCarga, String localidade){
        List<Carreta> carretas = CarretaRepository.listar();
        List<Motorista> motoristas = MotoristaRepository.listar();
        List<Caminhao> caminhoes = CaminhaoRepository.listar();

        EtapasTransporte novaEtapa = etapaFormView.formularioCadastroEtapa(idCarga, carretas, motoristas, caminhoes);
        if (novaEtapa == null) return false;
        
        novaEtapa.setUltimaLocalidade(localidade);

        novaEtapa.getCaminhao().setStatus(StatusVeiculo.EM_VIAGEM);
        novaEtapa.getCarreta1().setStatus(StatusVeiculo.EM_VIAGEM);
        novaEtapa.getMotorista().setStatus(StatusMotorista.EM_VIAGEM);

        if (novaEtapa.getCarreta2() != null)
            novaEtapa.getCarreta2().setStatus(StatusVeiculo.EM_VIAGEM);

        EtapasTransporteRepository.salvar(novaEtapa);
        return true;
    }

    
}
