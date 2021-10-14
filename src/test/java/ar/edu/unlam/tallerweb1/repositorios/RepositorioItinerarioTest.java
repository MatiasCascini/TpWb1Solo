package ar.edu.unlam.tallerweb1.repositorios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;

public class RepositorioItinerarioTest extends SpringTest {

	@Autowired
    private RepositorioItinerario repositorioItinerario;
	
    @Test
    @Transactional
    @Rollback
    public void guardarUnItinerarioDeberiaPersistirlo(){
        Itinerario itinerario1 = givenExisteUnItinerario("Mi Itinerario");
        Long id = whenGuardoItinerario(itinerario1);
        thenEncuentroElItinerario(id);
    }
    
    private Itinerario givenExisteUnItinerario(String nombre) {
    	Itinerario itinerario1 = new Itinerario();
    	itinerario1.setNombre(nombre);
        return itinerario1;
    }
    
    private Long whenGuardoItinerario(Itinerario itinerario1) {
    	repositorioItinerario.guardar(itinerario1);
        return itinerario1.getId();
    }
    
    private void thenEncuentroElItinerario(Long id) {
        Itinerario itinerario1 = repositorioItinerario.buscar(id);
        assertThat(itinerario1).isNotNull();
    }

}
