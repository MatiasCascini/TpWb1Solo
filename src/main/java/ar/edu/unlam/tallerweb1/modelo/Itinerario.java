package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;

public class Itinerario {

	private Map<String, Destinos> destino = new HashMap<>(); 
	private TipoDeTransporte transporte=null;
	private Integer dias=0;

	
	public void agregarDestino(String nombre, Integer dist, Integer dias, TipoDeDestino tipo) {
		Destinos destino1 = new Destinos(nombre, dist, tipo);
		destino.put(nombre, destino1);
		this.dias=dias;
	}

	public Destinos buscarRegistro(String destino1) {
		return destino.get(destino1);
	}

	public void setTransporte(TipoDeTransporte transporte2) {
		this.transporte=transporte2;
	}

	public Integer getDias() {
		return dias;
	}
	
}
