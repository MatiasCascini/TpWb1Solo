package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;

public class Destinos {
	
	private static final Integer PRECIOAVION = 15;
	private static final Integer PRECIOAUTO = 13;
	private static final Integer PRECIOBUS = 10;
	private static final Integer PRECIOMOTO = 8;
	
	private String nombre;
	private Integer distancia;
	private Integer precio;
	private TipoDeDestino tipo;
	
	public Destinos(String nombre, Integer distancia, TipoDeDestino tipo) {
		this.nombre=nombre;
		this.distancia=distancia;
		this.tipo=tipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getPrecio() {
		return precio;
	}
	
	public void calcularPrecio(TipoDeTransporte transporte) {
		switch (transporte) {
		case AVION:
			this.precio=distancia*PRECIOAVION;
			break;
		case AUTO:
			this.precio=distancia*PRECIOAUTO;
			break;
		case BUS:
			this.precio=distancia*PRECIOBUS;
			break;
		case MOTO:
			this.precio=distancia*PRECIOMOTO;
			break;
		default:
			break;
		}
	}
	
	
}
