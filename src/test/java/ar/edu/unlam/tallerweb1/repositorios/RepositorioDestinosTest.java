package ar.edu.unlam.tallerweb1.repositorios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Excursiones;

public class RepositorioDestinosTest extends SpringTest {

	@Autowired
    private RepositorioDestinos repositorioDestinos;
	@Autowired
    private RepositorioExcursiones repositorioExcursiones;
	
    @Test
    @Transactional
    @Rollback
    public void guardarUnDestinoDeberiaPersistirlo(){
        Destinos destino = givenExisteUnDestino("Bariloche");
        Long id = whenGuardoDestino(destino);
        thenEncuentroElDestino(id);
    }
    
    private Destinos givenExisteUnDestino(String nombre) {
    	Destinos destino1 = new Destinos();
    	destino1.setNombre(nombre);
        return destino1;
    }
    
    private Long whenGuardoDestino(Destinos destino1) {
    	repositorioDestinos.guardar(destino1);
        return destino1.getId();
    }
    
    private void thenEncuentroElDestino(Long id) {
        Destinos destino1 = repositorioDestinos.buscar(id);
        assertThat(destino1).isNotNull();
    }
    
    @Test
    @Transactional
    @Rollback
    public void traerUnaExcursionPorId(){
        Excursiones excursion1 = givenExisteUnaExcursion("Escalar");
        Long idExcursion = whenGuardoUnaExcursion(excursion1);
        thenEncuentroLaExcursion(idExcursion);
    }

	private Excursiones givenExisteUnaExcursion(String nombre) {
		Excursiones excursion1 = new Excursiones();
		excursion1.setNombre(nombre);
        return excursion1;
	}
	
    private Long whenGuardoUnaExcursion(Excursiones excursion1) {
    	repositorioExcursiones.guardar(excursion1);
        return excursion1.getId();
    }
    
    private void thenEncuentroLaExcursion(Long id) {
        Excursiones excursion1 = repositorioExcursiones.buscar(id);
        assertThat(excursion1).isNotNull();
    }
    

}
