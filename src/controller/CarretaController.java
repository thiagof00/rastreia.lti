package controller;

import java.util.List;
import model.Carreta;
import model.EtapasTransporte;
import repository.CarretaRepository;
import repository.EtapasTransporteRepository;
import util.AguardarVoltar;
import view.delete.CarretaDeleteView;
import view.form.CarretaFormView;
import view.list.CarretaListView;
import view.menu.CarretaMenuView;

public class CarretaController {
    private CarretaMenuView menuView;
    private CarretaFormView formView;
    private CarretaListView listView;
    private CarretaDeleteView deleteView;

    public CarretaController() {
        this.menuView = new CarretaMenuView();
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
        AguardarVoltar.Voltar();
    }

    public void listar() {
        List<Carreta> carretas = CarretaRepository.listar();
        listView.listarCarretas(carretas);
    }

    public void excluir() {
        int id = deleteView.formularioExcluirCarreta();

        List<EtapasTransporte> etapasTransportes = EtapasTransporteRepository.listar();
        for (EtapasTransporte etapa : etapasTransportes) {
            if (etapa.getCarreta().getId() == id || etapa.getCarreta2().getId() == id) {
                System.out.println("Carreta relacionada a um registro de carga, não foi possivel excluir.");
                AguardarVoltar.Voltar();
                return;
            }
        }

        if (id == 0) {
            System.out.println("ID não pode ser vazio.");
            AguardarVoltar.Voltar();
            return;
        }

        boolean excluido = CarretaRepository.excluir(id);

        if (excluido) {
            System.out.println("Carreta removida com sucesso!");
        } else {
            System.out.println("Carreta não encontrada");
        }
        AguardarVoltar.Voltar();

    }

    public int exibirMenu() {
        return menuView.menuCarretas();
    }
}
