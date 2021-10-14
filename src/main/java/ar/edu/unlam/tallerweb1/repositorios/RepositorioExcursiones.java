package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Excursiones;

public interface RepositorioExcursiones {

	void guardar(Excursiones excursion);
	Excursiones buscar(Long id);
	void modificar(Excursiones excursion);
	
}
