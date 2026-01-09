package controller;
import java.util.List;
import model.Motorista;
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

    public void listar(){

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
    
    public void excluir(){
        String cpf = viewDelete.formularioExcluirMotorista();

        if(cpf == null){
            return;
        }
        boolean excluido = MotoristaRepository.excluir(cpf);

        if(excluido){
            System.out.println("Motorista removido com sucesso!");
        }else{
            System.out.println("motorista não encontrado");
        }
        aguardarVoltar.Voltar();

    }
}
