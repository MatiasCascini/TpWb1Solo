package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;

@Entity
public class Destinos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private TipoDeDestino tipo;
	
	public Destinos(String nombre, TipoDeDestino tipo) {
		this.nombre=nombre;
		this.tipo=tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeDestino getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeDestino tipo) {
		this.tipo = tipo;
	}
		
}
