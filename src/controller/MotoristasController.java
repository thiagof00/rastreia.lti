package controller;

import java.util.List;
import model.EtapasTransporte;
import model.Motorista;
import repository.EtapasTransporteRepository;
import repository.MotoristaRepository;
import util.aguardarVoltar;
import view.delete.MotoristaDeleteView;
import view.form.MotoristaFormView;
import view.list.MotoristaListView;

public class MotoristasController {

    private MotoristaFormView formView;
    private MotoristaDeleteView viewDelete;
    private MotoristaListView listView;

    public MotoristasController() {
        this.formView = new MotoristaFormView();
        this.viewDelete = new MotoristaDeleteView();
        this.listView = new MotoristaListView();
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
        aguardarVoltar.Voltar();
    }

    public void excluir() {
        String cpf = viewDelete.formularioExcluirMotorista();

        List<EtapasTransporte> etapasTransportes = EtapasTransporteRepository.listar();
        for (EtapasTransporte etapa : etapasTransportes) {
            if (etapa.getMotorista().getCpf().equals(cpf)) {
                System.out.println(
                        "Motorista relacionado a um registro de etapa de uma carga, não foi possivel excluir.");
                aguardarVoltar.Voltar();
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
        aguardarVoltar.Voltar();

    }
}
