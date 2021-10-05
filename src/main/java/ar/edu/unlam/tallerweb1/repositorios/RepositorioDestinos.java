package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Destinos;

public interface RepositorioDestinos {
	void guardar(Destinos dest);
	Destinos buscar(Long id);
	void modificar(Destinos dest);
}
