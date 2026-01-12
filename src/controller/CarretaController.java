package controller;

import java.util.List;

import model.Carreta;
import view.form.CarretaFormView;
import view.list.CarretaListView;
import repository.CarretaRepository;
import util.aguardarVoltar;

public class CarretaController {
    private CarretaFormView formView;
    private CarretaListView listView;
    public CarretaController() {
        this.formView = new CarretaFormView();
        this.listView = new CarretaListView();
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
}
