package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosItinerario;
import ar.edu.unlam.tallerweb1.modelo.Destinos;

public interface ServicioDestinos {
	Destinos agregarDestino(Destinos destino);
	Destinos buscarDestino(Long id);
	Destinos buscarDestino(DatosItinerario datosItinerario);
	void completarBase();
}
