package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.TablaItinerario;

public class ServicioItinerario {

	private TablaItinerario tablaItinerario = TablaItinerario.getInstance();
	ServicioUsuario servicioUsuario;
	
	public Itinerario agregarDestino(Itinerario itinerario) {
		tablaItinerario.agregar(itinerario);
		return itinerario;
	}

	public Itinerario buscarRegistro(Long id) {
		return tablaItinerario.existeItinerarioCon(id);
	}

	public Double calcularPrecio(Itinerario itinerario, Estadia estadia) {
		
		itinerario.sumarPrecio(calcularPrecioTransporte(itinerario));
		itinerario.sumarPrecio(calcularPrecioEquipaje(itinerario));
		itinerario.sumarPrecio(estadia.getPrecioXNoche()*itinerario.getDias());
		
		tablaItinerario.update(itinerario);
		
		return itinerario.getPrecioTotal();
	}

	private Double calcularPrecioTransporte(Itinerario itinerario) {
		switch (itinerario.getTransporte()) {
		case AVION:
			return itinerario.getDistancia()*15;

		case AUTO:
			return itinerario.getDistancia()*13;

		case BUS:
			return itinerario.getDistancia()*10;

		case MOTO:
			return itinerario.getDistancia()*8;

		default:
			return 0.0;
		}
	}

	private Double calcularPrecioEquipaje(Itinerario itinerario) {
		switch (itinerario.getEquipaje()) {
		case DE_MANO:
			return 5000.0;
			
		case CHICO:
			return 8000.0;

		case GRANDE:
			return 10000.0;

		default:
			return 0.0;
		}
	}
	
}
