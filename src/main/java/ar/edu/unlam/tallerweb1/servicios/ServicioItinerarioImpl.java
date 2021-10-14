package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioItinerarioImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioItinerario")
@Transactional
public class ServicioItinerarioImpl implements ServicioItinerario {

	private RepositorioItinerario repo;
	private ServicioItinerarioImpl servicioUsuario;
	
	@Autowired
	public ServicioItinerarioImpl(RepositorioItinerario servicioItinerarioDao){
		this.repo = servicioItinerarioDao;
	}
	
	@Override
	public Itinerario agregarItinerario(Itinerario itinerario) {
		repo.guardar(itinerario);
		return itinerario;
	}

	@Override
	public Itinerario buscarRegistro(Long id) {
		return repo.buscar(id);
	}

	@Override
	public Double calcularPrecio(Itinerario itinerario, Estadia estadia) {
		
		itinerario.sumarPrecio(calcularPrecioTransporte(itinerario));
		itinerario.sumarPrecio(calcularPrecioEquipaje(itinerario));
		itinerario.sumarPrecio(estadia.getPrecioXNoche()*itinerario.getDias());
		
		repo.modificar(itinerario);
		
		return itinerario.getPrecioTotal();
	}

	@Override
	public Double calcularPrecioTransporte(Itinerario itinerario) {
		switch (itinerario.getTransporte().getNombre()) {
		case "Avion":
			return itinerario.getDistancia()*15;

		case "Auto":
			return itinerario.getDistancia()*13;

		case "Bus":
			return itinerario.getDistancia()*10;

		case "Moto":
			return itinerario.getDistancia()*8;

		default:
			return 0.0;
		}
	}

	@Override
	public Double calcularPrecioEquipaje(Itinerario itinerario) {
		switch (itinerario.getEquipaje().getNombre()) {
		case "De Mano":
			return 5000.0;
			
		case "Chico":
			return 8000.0;

		case "Grande":
			return 10000.0;

		default:
			return 0.0;
		}
	}
	
//	public List<Itinerario> listarDestinosPosibles(Itinerario itinerario){
//		List<Itinerario> list;
//		list = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			
//		}
//	}
	
}
