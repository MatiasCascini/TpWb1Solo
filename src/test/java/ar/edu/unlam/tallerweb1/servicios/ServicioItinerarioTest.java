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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.TablaUsuario;

public class ServicioItinerarioTest {

	ServicioItinerario itinerario1 = new ServicioItinerario();
	ServicioUsuario servicioUsuario = new ServicioUsuario();
	Usuario usuario = new Usuario("Mati@gmail.com","12345678",100000.0);
	Destinos destino = new Destinos("Bariloche", TipoDeDestino.MONTAÑA);
	
    @Before
    public void init(){
        TablaUsuario.getInstance().reset();
    }
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaSaberElPrecioDelViaje() {
		givenPosibleDestino(destino);
		Itinerario itinerarioNuevo = whenPongoLosParametrosDelItinerario(TipoDeTransporte.AVION, 1600.0, 7 , TipoDeEquipaje.GRANDE);
		thenCostoDelViaje(62000.0, itinerarioNuevo);
	}

	private void givenPosibleDestino(Destinos destino) {
		
	}

	private void thenCostoDelViaje(Double precioEstimado, Itinerario itinerario) {
		Estadia miEstadia = new Estadia("Los alamos", 4000.0);
		assertThat(precioEstimado).isEqualTo(itinerario1.calcularPrecio(itinerario, miEstadia));	
	}

	private Itinerario whenPongoLosParametrosDelItinerario(TipoDeTransporte transporte, Double distancia, Integer dias, TipoDeEquipaje equipaje ) {
		Itinerario itinerarioNuevo= new Itinerario(transporte, distancia, dias, equipaje);
		return itinerario1.agregarDestino(itinerarioNuevo);
	}
	
	@Test///////////////////////////////////////////////////////////////////////////////////////////////
	public void queSePuedaComprarUnPasaje() {
		givenPosibleDestino(destino);
		Itinerario itinerarioNuevo = whenPongoLosParametrosDelItinerario(TipoDeTransporte.AVION, 1600.0, 7 , TipoDeEquipaje.GRANDE);
		thenQueSePuedaComprar(itinerarioNuevo, usuario);
	}

	private void thenQueSePuedaComprar(Itinerario itinerario, Usuario usuario) {
		Estadia miEstadia = new Estadia("Los alamos", 4000.0);
		Double precio=itinerario1.calcularPrecio(itinerario, miEstadia);
		assertThat(servicioUsuario.descontarSaldoAlComprarUnPasaje(precio,usuario)).isTrue();
	}
	
	@Test(expected = DemasiadoCaroException.class)///////////////////////////////////////////////////////////////////////////////////////////////
	public void queNoSePuedaComprarUnPasajeSiElPrecioEsMayorAlPresupuestoDelUsuario() {
		givenPosibleDestino(destino);
		Itinerario itinerarioNuevo = whenPongoLosParametrosDelItinerario(TipoDeTransporte.AVION, 1600.0, 7 , TipoDeEquipaje.GRANDE);
		thenLaCompraFalla(itinerarioNuevo, usuario);
	}

	private void thenLaCompraFalla(Itinerario itinerario, Usuario usuario) {
		Estadia miEstadia = new Estadia("Los alamos", 40000.0); //PRECIO DE ESTADIA AUMENTADO!!!!!!!!!!!!!!!!!!!!
		Double precio=itinerario1.calcularPrecio(itinerario, miEstadia);
		assertThat(servicioUsuario.descontarSaldoAlComprarUnPasaje(precio,usuario)).isFalse();
	}
	
	
}
