package controller;

import java.util.List;

import model.EtapasTransporte;
import model.Motorista;
import repository.EtapasTransporteRepository;
import repository.MotoristaRepository;
import util.AguardarVoltar;
import view.delete.MotoristaDeleteView;
import view.form.MotoristaFormView;
import view.list.MotoristaListView;
import view.menu.MotoristaMenuView;
import view.update.MotoristaUpdateView;

public class MotoristasController {

    private MotoristaMenuView menuView;
    private MotoristaFormView formView;
    private MotoristaDeleteView viewDelete;
    private MotoristaListView listView;
    private MotoristaUpdateView updateView;

    public MotoristasController() {
        this.formView = new MotoristaFormView();
        this.viewDelete = new MotoristaDeleteView();
        this.listView = new MotoristaListView();
        this.menuView = new MotoristaMenuView();
        this.updateView = new MotoristaUpdateView();
    }

    public void listar() {

        List<Motorista> motoristas = MotoristaRepository.listar();

        listView.listarMotoristas(motoristas);

    }

    public void cadastrar() {
        Motorista motorista = formView.formularioCadastroMotorista();

        if (motorista == null) {
            return;
        }
        MotoristaRepository.salvar(motorista);

        System.out.println("Motorista cadastrado com sucesso!");
        AguardarVoltar.Voltar();
    }

    public void excluir() {
        String cpf = viewDelete.formularioExcluirMotorista();

        List<EtapasTransporte> etapasTransportes = EtapasTransporteRepository.listar();
        for (EtapasTransporte etapa : etapasTransportes) {
            if (etapa.getMotorista().getCpf().equals(cpf)) {
                System.out.println(
                        "Motorista relacionado a um registro de etapa de uma carga, não foi possivel excluir.");
                AguardarVoltar.Voltar();
                return;
            }
        }

        if (cpf == null) {
            System.out.println("CPF não pode ser vazio.");
            return;
        }
        boolean excluido = MotoristaRepository.excluir(cpf);

        if (excluido) {
            System.out.println("Motorista removido com sucesso!");
        } else {
            System.out.println("motorista não encontrado");
        }
        AguardarVoltar.Voltar();

    }

    public void atualizarMotorista() {

        List<Motorista> motoristas = MotoristaRepository.listar();

        Motorista alterada = updateView.updateMotorista(motoristas);

        if (alterada == null) {
            return;
        }

        Motorista motoristaSelecionadaParaAlterar = MotoristaRepository.getMotoristaPorId(alterada.getId());

        motoristaSelecionadaParaAlterar
                .setNome(alterada.getNome());
        motoristaSelecionadaParaAlterar
                .setCpf(alterada.getCpf());
        motoristaSelecionadaParaAlterar
                .setStatus(alterada.getStatus());

        System.out.println("Motorista alterado com sucesso!");
        AguardarVoltar.Voltar();
    }

    public int exibirMenu() {

        return menuView.menuMotoristas();
    }
}
