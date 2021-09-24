package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;

public class ServicioItinerarioTest {

	Itinerario itinerario1 = new Itinerario();
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaCrearUndestino() {
		givenQueNoExistaUnDestino();
		whenGenerarDestino("Bariloche", 1600, TipoDeDestino.MONTAÑA);
		thenQueExistaUnRegistro("Bariloche");
	}
	
	private void thenQueExistaUnRegistro(String nombre) {
		assertThat(itinerario1.buscarRegistro(nombre)).isNotNull();
	}

	private void whenGenerarDestino(String nombre, Integer distancia, TipoDeDestino tipo) {
		itinerario1.agregarDestino(nombre, tipo);
	}

	private void givenQueNoExistaUnDestino() {
	}

	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaBuscarUnDestino() {
		givenPosibleDestino("Bariloche", TipoDeDestino.MONTAÑA);
		Destinos destinoEncontrado= whenBuscarDestino("Bariloche");
		thenRegistroEncontrado(destinoEncontrado, "Bariloche");
	}

	private void thenRegistroEncontrado(Destinos destinoEncontrado, String nombre) {
		assertThat(destinoEncontrado.getNombre()).isEqualTo(nombre);
	}

	public void givenPosibleDestino(String nombre, TipoDeDestino tipo) {
		itinerario1.agregarDestino(nombre, tipo);
	}

	private Destinos whenBuscarDestino(String destino) {
		return itinerario1.buscarRegistro(destino);
	}
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaSaberElPrecioDelViaje() {
		givenPosibleDestino("Bariloche", TipoDeDestino.MONTAÑA);
		whenParametros(TipoDeTransporte.AVION, 1600.0, 7 , TipoDeEquipaje.GRANDE);
		thenCostoDelViaje(62000.0);
	}

	private void thenCostoDelViaje(Double precioEstimado) {
		Estadia miEstadia = new Estadia("Los alamos", 4000.0);
		assertThat(precioEstimado).isEqualTo(itinerario1.calcularPrecio("Bariloche", miEstadia));	
	}

	private void whenParametros(TipoDeTransporte transporte, Double distancia, Integer dias, TipoDeEquipaje equipaje ) {
		itinerario1.setParametros(transporte,distancia , dias, equipaje);
	}
	
	
}
