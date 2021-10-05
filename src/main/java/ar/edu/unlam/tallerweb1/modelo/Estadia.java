package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estadia{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Double precioXNoche;
	
	public Estadia(String nombre, Double precioXNoche) {
		this.nombre=nombre;
		this.precioXNoche=precioXNoche;
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
	public Double getPrecioXNoche() {
		return precioXNoche;
	}
	public void setPrecioXNoche(Double precioXNoche) {
		this.precioXNoche = precioXNoche;
	}
	
}
