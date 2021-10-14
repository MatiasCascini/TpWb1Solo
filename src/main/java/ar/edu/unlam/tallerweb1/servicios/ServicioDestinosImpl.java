package ar.edu.unlam.tallerweb1.servicios;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controladores.DatosItinerario;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDestinos;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDestinosImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEstadiaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoDeDestinos;

@Service("servicioDestinos")
@Transactional
public class ServicioDestinosImpl implements ServicioDestinos {

	private RepositorioDestinos repo;
	private ServicioDestinosImpl servicioDestinos;

	@Autowired
	public ServicioDestinosImpl(RepositorioDestinos servicioDestinosDao){
		this.repo = servicioDestinosDao;
	}
	
	@Autowired
	private RepositorioTipoDeDestinos repoDestinos;
	
	public Destinos agregarDestino(Destinos destino) {
		repo.guardar(destino);
		return destino;
	}

	public Destinos buscarDestino(Long id) {
		return repo.buscar(id);
	}
	
	public Destinos buscarDestinoPorNombre(String nombre) {
		return repo.buscarPorNombre(nombre);
	}
	
	public Destinos buscarDestino(DatosItinerario datosItinerario) {
        if(repo.buscarDestino(datosItinerario) == null){
            throw new DestinoNoExisteException();
        }
		return repo.buscarDestino(datosItinerario);
	}

	public void completarBase() {
		TipoDeDestino tipo = new TipoDeDestino("Montaña");
		repoDestinos.guardar(tipo);
		Destinos destino = new Destinos("Bariloche", tipo);
		repo.guardar(destino);
	}

}
