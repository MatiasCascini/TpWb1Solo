package ar.edu.unlam.tallerweb1.controladores;



import ar.edu.unlam.tallerweb1.servicios.*;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class ControladorHomeTest {

    private ServicioUsuario servicioUsuario;
    private ServicioDestinos servicioDestinos;
    private ControladorHome controladorHome;
    private ModelAndView mav;
    private Destinos destino = new Destinos("Bariloche", new TipoDeDestino("Montaña"));
    
	@Before
    public void init(){
		servicioDestinos= mock(ServicioDestinos.class);
        controladorHome = new ControladorHome(servicioDestinos);
    }

    @Test
    public void siElNombreDelDestinoExiste() {
        givenDestinoExistente(destino);
        DatosItinerario datosItinerario = givenExisteDatoDeItinerario(1.0,"Bariloche");
        whenBuscoUnDestinoCon(datosItinerario);
        thenLaBusquedaEsExitosa();
    }
    
    private void givenDestinoExistente(Destinos destino) {
    	servicioDestinos.agregarDestino(destino);
	}

	private void thenLaBusquedaEsExitosa() {
    	assertThat(mav.getViewName()).isEqualTo("redirect:/destinosDisponibles");
	}

	private void whenBuscoUnDestinoCon(DatosItinerario datosItinerario) {
		mav = controladorHome.Destinos(datosItinerario);
	}

	private DatosItinerario givenExisteDatoDeItinerario(Double cifra, String nombreDestino) {
		return new DatosItinerario(cifra, nombreDestino);
	}

	private void givenDestinoNoExiste() {
			
	}
}
