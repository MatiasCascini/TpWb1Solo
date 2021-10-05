package ar.edu.unlam.tallerweb1.repositorios;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;

public class TablaEstadia {

	private static final TablaEstadia instance1 = new TablaEstadia();
    private Map<Long, Estadia> tablaEstadia = new HashMap<>();

    private TablaEstadia(){}

    public static TablaEstadia getInstance(){
        return instance1;
    }

    public Estadia existeEstadiaCon(Long id){
        return this.tablaEstadia.get(id);
    }

    public void agregar(Estadia estadia){
        this.tablaEstadia.put(estadia.getId(), estadia);
    }
    public void reset(){
        this.tablaEstadia.clear();
    }
}
