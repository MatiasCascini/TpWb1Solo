package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;

public class ServicioItinerarioTest {

	Itinerario itinerario1 = new Itinerario();
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaCrearUndestino() {
		givenQueNoExistaUnDestino();
		whenGenerarDestino("Bariloche", 1600, 7, TipoDeDestino.MONTAÑA);
		thenQueExistaUnRegistro("Bariloche");
	}
	
	private void thenQueExistaUnRegistro(String nombre) {
		assertThat(itinerario1.buscarRegistro(nombre)).isNotNull();
	}

	private void whenGenerarDestino(String nombre, Integer distancia, Integer dias, TipoDeDestino tipo) {
		itinerario1.agregarDestino(nombre, distancia, dias, tipo);
	}

	private void givenQueNoExistaUnDestino() {
	}

	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaBuscarUnDestino() {
		givenPosibleDestino("Bariloche", 1600, 7, TipoDeDestino.MONTAÑA);
		Destinos destinoEncontrado= whenBuscarDestino("Bariloche");
		thenRegistroEncontrado(destinoEncontrado, "Bariloche");
	}

	private void thenRegistroEncontrado(Destinos destinoEncontrado, String nombre) {
		assertThat(destinoEncontrado.getNombre()).isEqualTo(nombre);
	}

	public void givenPosibleDestino(String nombre, Integer distancia, Integer dias, TipoDeDestino tipo) {
		itinerario1.agregarDestino(nombre, distancia, dias, tipo);
	}

	private Destinos whenBuscarDestino(String destino) {
		return itinerario1.buscarRegistro(destino);
	}
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaSaberElPrecioDelViaje() {
		givenPosibleDestino("Bariloche", 1600, 7, TipoDeDestino.MONTAÑA);
		whenModoDeTransporte(TipoDeTransporte.AVION);
		thenCostoDelViaje(168000);
	}

	private void thenCostoDelViaje(Integer precioEstimado) {
		assertThat(precioEstimado).isEqualTo(itinerario1.buscarRegistro("Bariloche").getPrecio()
		*itinerario1.getDias()		
				);
	}

	private void whenModoDeTransporte(TipoDeTransporte transporte) {
		itinerario1.setTransporte(transporte);
		itinerario1.buscarRegistro("Bariloche").calcularPrecio(transporte);;
	}
	
	
}
