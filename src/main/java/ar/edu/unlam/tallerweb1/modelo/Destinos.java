package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Destinos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToOne
	private TipoDeDestino tipoDeDestino;
	@ManyToOne
	private Estadia estadia;
	@ManyToOne
	private Excursiones excursiones;
	
	public Destinos() {}
	
	public Destinos(String nombre, TipoDeDestino tipo) {
		this.nombre=nombre;
		this.tipoDeDestino=tipo;
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
		return tipoDeDestino;
	}

	public void setTipo(TipoDeDestino tipo) {
		this.tipoDeDestino = tipo;
	}

	public TipoDeDestino getTipoDeDestino() {
		return tipoDeDestino;
	}

	public void setTipoDeDestino(TipoDeDestino tipoDeDestino) {
		this.tipoDeDestino = tipoDeDestino;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public Excursiones getExcursiones() {
		return excursiones;
	}

	public void setExcursiones(Excursiones excursiones) {
		this.excursiones = excursiones;
	}
	
	
		
}
