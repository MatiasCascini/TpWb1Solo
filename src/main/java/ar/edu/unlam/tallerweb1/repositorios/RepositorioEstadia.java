package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estadia;

public interface RepositorioEstadia {
	void guardar(Estadia estadia);
	Estadia buscar(Long id);
	void modificar(Estadia estadia);
}
