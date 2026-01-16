package controller;


import java.util.List;

import model.EtapasTransporte;
import repository.EtapasTransporteRepository;
import view.list.EtapasTransporteListView;

public class EtapasController {

    private EtapasTransporteListView listView;

    public EtapasController(){
        this.listView = new EtapasTransporteListView();
    }

    public void listar(int id){
        List<EtapasTransporte> etapas = EtapasTransporteRepository.listar();
        
        listView.listarEtapas(etapas, id);
        
    }
}
