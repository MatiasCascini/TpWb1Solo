package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.repositorios.TablaDestinos;
import ar.edu.unlam.tallerweb1.repositorios.TablaEstadia;
import ar.edu.unlam.tallerweb1.repositorios.TablaItinerario;

public class ServicioEstadia {

	private TablaEstadia tablaEstadia = TablaEstadia.getInstance();
	
	public Estadia agregarDestino(Estadia estadia) {
		tablaEstadia.agregar(estadia);
		return estadia;
	}

	public Estadia buscarEstadia(Long id) {
		return tablaEstadia.existeEstadiaCon(id);
	}

}
