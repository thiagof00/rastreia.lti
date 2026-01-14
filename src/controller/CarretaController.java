package controller;

import java.util.List;

import model.Carga;
import model.Carreta;
import view.delete.CarretaDeleteView;
import view.form.CarretaFormView;
import view.list.CarretaListView;
import repository.CargaRepository;
import repository.CarretaRepository;
import util.aguardarVoltar;

public class CarretaController {
    private CarretaFormView formView;
    private CarretaListView listView;
    private CarretaDeleteView deleteView;
    public CarretaController() {
        this.formView = new CarretaFormView();
        this.listView = new CarretaListView();
        this.deleteView = new CarretaDeleteView();
    }

    public void cadastrar() {
        Carreta carreta = formView.formularioCadastroCarreta();

        if (carreta == null) {
            return;
        }
        CarretaRepository.salvar(carreta);

        System.out.println("Carreta cadastrada com sucesso!");
        aguardarVoltar.Voltar();;
    }

    public void listar(){
        List<Carreta> carretas = CarretaRepository.listar();
         listView.listarCarretas(carretas);
    }

    public void excluir(){
        int id = deleteView.formularioExcluirCarreta();

        List<Carga> cargas = CargaRepository.listar();
        for (Carga carga : cargas) {
            if(carga.getCarreta1().getId() == id || carga.getCarreta2().getId() == id) {
                System.out.println("Carreta relacionada a um registro de carga, não foi possivel excluir.");
                aguardarVoltar.Voltar();
                return;
            }
        }

        if (id == 0) {
            System.out.println("ID não pode ser vazio.");
            aguardarVoltar.Voltar();
            return;
        }

        boolean excluido = CarretaRepository.excluir(id);

        if(excluido){
            System.out.println("Carreta removida com sucesso!");
        }else{
            System.out.println("Carreta não encontrada");
        }
        aguardarVoltar.Voltar();

    }
}
