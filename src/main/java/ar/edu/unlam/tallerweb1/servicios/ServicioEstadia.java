package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Estadia;

public interface ServicioEstadia {

	Estadia agregarDestino(Estadia estadia);
	Estadia buscarEstadia(Long id);
}
