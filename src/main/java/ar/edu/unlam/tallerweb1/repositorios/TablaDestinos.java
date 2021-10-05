package ar.edu.unlam.tallerweb1.repositorios;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unlam.tallerweb1.modelo.Destinos;

public class TablaDestinos {

	private static final TablaDestinos instance1 = new TablaDestinos();
    private Map<Long, Destinos> tablaDestinos = new HashMap<>();

    private TablaDestinos(){}

    public static TablaDestinos getInstance(){
        return instance1;
    }

    public Destinos existeDestinoCon(Long id){
        return this.tablaDestinos.get(id);
    }

    public void agregar(Destinos destino){
        this.tablaDestinos.put(destino.getId(), destino);
    }
    public void reset(){
        this.tablaDestinos.clear();
    }
}
