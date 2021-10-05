package ar.edu.unlam.tallerweb1.repositorios;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unlam.tallerweb1.modelo.Itinerario;

public class TablaItinerario {

	private static final TablaItinerario instance1 = new TablaItinerario();
    private Map<Long, Itinerario> tablaItinerario = new HashMap<>();

    private TablaItinerario(){}

    public static TablaItinerario getInstance(){
        return instance1;
    }

    public Itinerario existeItinerarioCon(Long id){
        return this.tablaItinerario.get(id);
    }

    public void agregar(Itinerario itinerario){
        this.tablaItinerario.put(itinerario.getId(), itinerario);
    }
    public void reset(){
        this.tablaItinerario.clear();
    }

	public void update(Itinerario itinerario) {
		this.tablaItinerario.replace(itinerario.getId(), itinerario);
	}
}
