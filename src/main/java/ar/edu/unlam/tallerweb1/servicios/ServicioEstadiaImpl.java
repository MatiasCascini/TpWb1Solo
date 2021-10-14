package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEstadiaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerarioImpl;


@Service("servicioEstadia")
@Transactional
public class ServicioEstadiaImpl implements ServicioEstadia {

	RepositorioEstadiaImpl repo;
	ServicioEstadiaImpl servicioUsuario;
	
	public Estadia agregarDestino(Estadia estadia) {
		repo.guardar(estadia);
		return estadia;
	}

	public Estadia buscarEstadia(Long id) {
		return repo.buscar(id);
	}

}
