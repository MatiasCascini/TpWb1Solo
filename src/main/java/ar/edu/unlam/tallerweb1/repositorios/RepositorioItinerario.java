package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Itinerario;

public interface RepositorioItinerario {
	void guardar(Itinerario iti);
	Itinerario buscar(Long id);
	void modificar(Itinerario iti);
}
