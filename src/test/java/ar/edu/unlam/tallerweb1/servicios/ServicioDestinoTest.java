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
import ar.edu.unlam.tallerweb1.repositorios.TablaUsuario;

public class ServicioDestinoTest {

	ServicioDestinos destinos = new ServicioDestinos();
	
    @Before
    public void init(){
        TablaUsuario.getInstance().reset();
    }
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaCrearUndestino() {
		givenQueNoExistaUnDestino();
		Destinos destino = whenGenerarDestino("Bariloche", TipoDeDestino.MONTAÑA);
		thenQueExistaUnRegistro(destino);
	}
	
	private void thenQueExistaUnRegistro(Destinos destino) {
		assertThat(destinos.buscarRegistro(destino.getId())).isNotNull();
	}

	private Destinos whenGenerarDestino(String nombre, TipoDeDestino tipo) {
		Destinos destino = new Destinos(nombre, tipo);
		return destinos.agregarDestino(destino);
	}

	private void givenQueNoExistaUnDestino() {
	}

	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaBuscarUnDestino() {
		Destinos destino = givenPosibleDestino("Bariloche", TipoDeDestino.MONTAÑA);
		Destinos destinoEncontrado= whenBuscarDestino(destino);
		thenRegistroEncontrado(destinoEncontrado, destino);
	}

	private void thenRegistroEncontrado(Destinos destinoEncontrado, Destinos destino) {
		assertThat(destinoEncontrado.getId()).isEqualTo(destino.getId());
	}

	public Destinos givenPosibleDestino(String nombre, TipoDeDestino tipo) {
		Destinos destino = new Destinos(nombre, tipo);
		return destinos.agregarDestino(destino);
	}

	private Destinos whenBuscarDestino(Destinos destino) {
		return destinos.buscarRegistro(destino.getId());
	}
	
}
