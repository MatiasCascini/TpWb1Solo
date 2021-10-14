package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;

public interface RepositorioTipoDeDestinos {
	void guardar(TipoDeDestino tipo);
	TipoDeDestino buscar(Long id);
	void modificar(TipoDeDestino tipo);
}
