package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDestinos;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;


public class ServicioDestinoTest {

    private RepositorioDestinos repositorioDestinos;
    private ServicioDestinosImpl servicioDestinos = new ServicioDestinosImpl(repositorioDestinos);
    private TipoDeDestino tipoDeDestino = new TipoDeDestino("Montaña");
//    @Before
//    public void init(){
//    	repositorioDestinos = mock(RepositorioDestinos.class);
//    	servicioDestinos = new ServicioDestinosImpl(repositorioDestinos);
//    }

	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaCrearYBuscarUndestino() {
		givenQueNoExistaUnDestino();
		Destinos destino = whenGenerarDestino("Bariloche", tipoDeDestino);
		thenQueExistaUnRegistro(destino);
	}
	
	private void givenQueNoExistaUnDestino() {
	}

	private Destinos whenGenerarDestino(String nombre, TipoDeDestino tipo) {
		Destinos destino = new Destinos(nombre, tipo);
		return servicioDestinos.agregarDestino(destino);
	}

	private void thenQueExistaUnRegistro(Destinos destino) {
		assertThat(servicioDestinos.buscarDestino(destino.getId())).isNotNull();
	}
}
