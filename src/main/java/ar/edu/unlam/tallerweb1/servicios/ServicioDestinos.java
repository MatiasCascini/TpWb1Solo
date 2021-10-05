package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.repositorios.TablaDestinos;
import ar.edu.unlam.tallerweb1.repositorios.TablaItinerario;

public class ServicioDestinos {

	private TablaDestinos tablaDestinos = TablaDestinos.getInstance();
	
	public Destinos agregarDestino(Destinos destino) {
		tablaDestinos.agregar(destino);
		return destino;
	}

	public Destinos buscarRegistro(Long id) {
		return tablaDestinos.existeDestinoCon(id);
	}

}
