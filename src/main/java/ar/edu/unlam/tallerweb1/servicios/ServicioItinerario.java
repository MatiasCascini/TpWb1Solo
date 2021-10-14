package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;

public interface ServicioItinerario {

	Itinerario agregarItinerario(Itinerario itinerario);
	Itinerario buscarRegistro(Long id);
	Double calcularPrecio(Itinerario itinerario, Estadia estadia);
	Double calcularPrecioTransporte(Itinerario itinerario);
	Double calcularPrecioEquipaje(Itinerario itinerario);
}
