package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Destinos_Excursiones;
import ar.edu.unlam.tallerweb1.modelo.Excursiones;

public interface RepositorioDestinos_Excursiones {
	void guardar(Destinos_Excursiones DestinoExcursiones);
	Destinos_Excursiones buscar(Long id);
	void modificar(Destinos_Excursiones DestinoExcursiones);
	List buscarExcursionesDeUnDestino(Destinos destino);
	List buscarExcursionesDeUnDestinoDeTipoMontaña(Destinos destino);
}
