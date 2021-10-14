package ar.edu.unlam.tallerweb1.repositorios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Destinos_Excursiones;
import ar.edu.unlam.tallerweb1.modelo.Excursiones;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;

public class RepositorioDestinos_ExcursionesTest extends SpringTest {

	@Autowired
    private RepositorioDestinos repositorioDestinos;
	@Autowired
    private RepositorioExcursiones repositorioExcursiones;
	@Autowired
    private RepositorioDestinos_Excursiones repositorioDestinos_Excursiones;
	@Autowired
    private RepositorioTipoDeDestinos repositorioTipoDeDestinos;
	
	List<Destinos_Excursiones>excursionesLista= new ArrayList<>(); 
	
    @Test
    @Transactional
    @Rollback
    public void guardarUnDestino_ExcursionesDeberiaPersistirlo(){
        Destinos destino = givenExisteUnDestino("Bariloche");
        Excursiones excursion1 = givenExisteUnaExcursion("Escalar");
        whenGuardoDestino(destino);
        whenGuardoUnaExcursion(excursion1);
        Destinos_Excursiones destino_excursiones = givenExisteUnDestinoExcursiones(destino,excursion1);
        Long id = whenGuardoDestino_excursion(destino_excursiones);
        thenEncuentroElDestinos_Excursiones(id);
    }
    
    private void thenEncuentroElDestinos_Excursiones(Long id) {
    	Destinos_Excursiones destino_excursiones = repositorioDestinos_Excursiones.buscar(id);
        assertThat(destino_excursiones).isNotNull();
	}

	private Long whenGuardoDestino_excursion(Destinos_Excursiones destino_excursiones) {
    	repositorioDestinos_Excursiones.guardar(destino_excursiones);
    	return destino_excursiones.getId();
	}

	private Destinos_Excursiones givenExisteUnDestinoExcursiones(Destinos destino, Excursiones excursion1) {
		Destinos_Excursiones destinosExcursiones = new Destinos_Excursiones ();
		destinosExcursiones.setDestino(destino);
		destinosExcursiones.setExcursion(excursion1);
		return destinosExcursiones;
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
    
	private Excursiones givenExisteUnaExcursion(String nombre) {
		Excursiones excursion1 = new Excursiones();
		excursion1.setNombre(nombre);
        return excursion1;
	}
	
    private Long whenGuardoUnaExcursion(Excursiones excursion1) {
    	repositorioExcursiones.guardar(excursion1);
        return excursion1.getId();
    }
    
    @Test
    @Transactional
    @Rollback
    public void traerTodasLasExcursionesDeUnDestino(){
        Destinos destino = givenExisteUnDestino("Bariloche");
        Excursiones excursion1 = givenExisteUnaExcursion("Escalar");
        Excursiones excursion2 = givenExisteUnaExcursion("Trepar");
        whenGuardoDestino(destino);
        whenGuardoUnaExcursion(excursion1);
        whenGuardoUnaExcursion(excursion2);
        Destinos_Excursiones destino_excursiones = givenExisteUnDestinoExcursiones(destino,excursion1);
        Destinos_Excursiones destino_excursiones2 = givenExisteUnDestinoExcursiones(destino,excursion2);
        whenGuardoDestino_excursion(destino_excursiones);
        whenGuardoDestino_excursion(destino_excursiones2);
        thenEncuentroLasExcursionesDeUnDestino(destino);
    }

	private void thenEncuentroLasExcursionesDeUnDestino(Destinos destino) {
		assertThat(repositorioDestinos_Excursiones.buscarExcursionesDeUnDestino(destino)).isNotNull();
	}
    
	@Test
    @Transactional
    @Rollback
    public void traerTodasLasExcursionesDeUnDestinoDeMontaña(){
		TipoDeDestino tipoDeDestinoMontaña = givenExisteUnTipoDeDestino("Montaña");
		TipoDeDestino tipoDeDestinoNieve = givenExisteUnTipoDeDestino("Nieve");
		
        whenGuardoUnTipoDeDestino(tipoDeDestinoMontaña);
        whenGuardoUnTipoDeDestino(tipoDeDestinoNieve);
        
        Destinos destinoBariloche = givenExisteUnDestino("Bariloche",tipoDeDestinoMontaña);
        Destinos destinoCafayate = givenExisteUnDestino("Cafayate",tipoDeDestinoNieve);
        Excursiones excursionMontaña1 = givenExisteUnaExcursion("Escalar");
        Excursiones excursionMontaña2 = givenExisteUnaExcursion("Trepar");
        Excursiones excursionNieve1 = givenExisteUnaExcursion("Culipatin");
        
        whenGuardoDestino(destinoBariloche);
        whenGuardoDestino(destinoCafayate);
        whenGuardoUnaExcursion(excursionMontaña1);
        whenGuardoUnaExcursion(excursionMontaña2);
        whenGuardoUnaExcursion(excursionNieve1);

        Destinos_Excursiones destino_excursiones = givenExisteUnDestinoExcursiones(destinoBariloche,excursionMontaña1);
        Destinos_Excursiones destino_excursiones2 = givenExisteUnDestinoExcursiones(destinoBariloche,excursionMontaña2);
        Destinos_Excursiones destino_excursiones3 = givenExisteUnDestinoExcursiones(destinoCafayate,excursionNieve1);
        
        whenGuardoDestino_excursion(destino_excursiones);
        whenGuardoDestino_excursion(destino_excursiones2);
        whenGuardoDestino_excursion(destino_excursiones3);
        
        Integer numeroDeseado=2;
        thenCuentoLasExcursionesDeUnDestino(destinoBariloche,numeroDeseado);
    }

	private void thenCuentoLasExcursionesDeUnDestino(Destinos destinoBariloche, Integer numeroDeseado) {
		excursionesLista = repositorioDestinos_Excursiones.buscarExcursionesDeUnDestino(destinoBariloche);
		Integer cont=0;
		for (Destinos_Excursiones prueba : excursionesLista) {
			cont++;
		}
		assertThat(cont.equals(numeroDeseado));
	}

	private void whenGuardoUnTipoDeDestino(TipoDeDestino tipoDeDestino) {
		repositorioTipoDeDestinos.guardar(tipoDeDestino);
	}

	private TipoDeDestino givenExisteUnTipoDeDestino(String nombre) {
			TipoDeDestino tipoDeDestino = new TipoDeDestino();
			tipoDeDestino.setNombre(nombre);
			return tipoDeDestino;
	}

	private Destinos givenExisteUnDestino(String nombre, TipoDeDestino tipoDeDestino) {
	    	Destinos destino1 = new Destinos();
	    	destino1.setNombre(nombre);
	    	destino1.setTipo(tipoDeDestino);
	        return destino1;
	}

}
