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

public class RepositorioExcursionesTest extends SpringTest {

	@Autowired
    private RepositorioExcursiones repositorioExcursiones;
	
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
