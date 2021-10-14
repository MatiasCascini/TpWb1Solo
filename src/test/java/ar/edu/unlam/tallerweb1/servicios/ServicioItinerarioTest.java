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
import ar.edu.unlam.tallerweb1.modelo.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.modelo.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerarioImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

public class ServicioItinerarioTest {

	private Usuario usuario = new Usuario("Mati@gmail.com","12345678",100000.0);
	private TipoDeDestino tipoDeDestino = new TipoDeDestino("Montaña");
	private TipoDeEquipaje tipoDeEquipaje = new TipoDeEquipaje("Grande");
	private TipoDeTransporte tipoDeTransporte = new TipoDeTransporte("Avion");
    private RepositorioUsuario repositorioUsuario;
    private RepositorioItinerario repositorioItinerario;
    private ServicioUsuarioImpl servicioUsuario;
	private ServicioItinerarioImpl servicioItinerario;

    @Before
    public void init(){
        repositorioItinerario = mock(RepositorioItinerario.class);
        servicioItinerario = new ServicioItinerarioImpl(repositorioItinerario);
        repositorioUsuario = mock(RepositorioUsuario.class);
        servicioUsuario = new ServicioUsuarioImpl(repositorioUsuario);
    }
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaSaberElPrecioDelViaje() {
		Destinos destino = givenPosibleDestino("Bariloche", tipoDeDestino);
		Itinerario itinerarioNuevo = whenPongoLosParametrosDelItinerario(tipoDeTransporte, 1600.0, 7 , tipoDeEquipaje);
		thenCostoDelViaje(62000.0, itinerarioNuevo);
	}

	private Destinos givenPosibleDestino(String nombre, TipoDeDestino tipo) {
		return new Destinos(nombre, tipo);
	}

	private void thenCostoDelViaje(Double precioEstimado, Itinerario itinerario) {
		Estadia miEstadia = new Estadia("Los alamos", 4000.0);
		assertThat(precioEstimado).isEqualTo(servicioItinerario.calcularPrecio(itinerario, miEstadia));	
	}

	private Itinerario whenPongoLosParametrosDelItinerario(TipoDeTransporte transporte, Double distancia, Integer dias, TipoDeEquipaje equipaje ) {
		Itinerario itinerarioNuevo= new Itinerario(transporte, distancia, dias, equipaje);
		return servicioItinerario.agregarItinerario(itinerarioNuevo);
	}
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaComprarUnPasaje() {
		Destinos destino = givenPosibleDestino("Bariloche", tipoDeDestino);
		Itinerario itinerarioNuevo = whenPongoLosParametrosDelItinerario(tipoDeTransporte, 1600.0, 7 , tipoDeEquipaje);
		thenQueSePuedaComprar(itinerarioNuevo, usuario);
	}

	private void thenQueSePuedaComprar(Itinerario itinerario, Usuario usuario) {
		Estadia miEstadia = new Estadia("Los alamos", 4000.0);
		Double precio=servicioItinerario.calcularPrecio(itinerario, miEstadia);
		assertThat(servicioUsuario.descontarSaldoAlComprarUnPasaje(precio,usuario)).isTrue();
	}
	
	@Test(expected = DemasiadoCaroException.class)///////////////////////////////////////////////////////////////////////////////////////////////
	public void queNoSePuedaComprarUnPasajeSiElPrecioEsMayorAlPresupuestoDelUsuario() {
		Destinos destino = givenPosibleDestino("Bariloche", tipoDeDestino);
		Itinerario itinerarioNuevo = whenPongoLosParametrosDelItinerario(tipoDeTransporte, 1600.0, 7 , tipoDeEquipaje);
		thenLaCompraFalla(itinerarioNuevo, usuario);
	}

	private void thenLaCompraFalla(Itinerario itinerario, Usuario usuario) {
		Estadia miEstadia = new Estadia("Los alamos", 40000.0); //PRECIO DE ESTADIA AUMENTADO!!!!!!!!!!!!!!!!!!!!
		Double precio=servicioItinerario.calcularPrecio(itinerario, miEstadia);
		assertThat(servicioUsuario.descontarSaldoAlComprarUnPasaje(precio,usuario)).isFalse();
	}
	
	
}
