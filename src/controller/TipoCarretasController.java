package controller;

import model.TipoCarreta;
import repository.TipoCarretaRepository;
import view.MenuView;

public class TipoCarretasController {
    private MenuView view;

    public TipoCarretasController(MenuView view) {
        this.view = view;
    }

    public void cadastrar() {
        TipoCarreta tipoCarreta = view.formularioCadastroTipoCarreta();

        if (tipoCarreta == null) {
            return;
        }
        TipoCarretaRepository.salvar(tipoCarreta);

        System.out.println("Tipo de Carreta cadastrado com sucesso!");
        view.aguardarVoltar();
    }
    public void excluir(){
        int id = view.formularioExcluirTipoCarreta();

        int excluido = TipoCarretaRepository.excluir(id);

        if(excluido == 1){
            System.out.println("Tipo removido com sucesso!");
        }else if(excluido == 0){
            System.out.println("Tipo não encontrado.");
        }else{
            System.out.println("Tipo associado a uma carreta, não é possível excluir.");
        }
        view.aguardarVoltar();

    }
}
