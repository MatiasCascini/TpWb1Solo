package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Itinerario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private TipoDeTransporte transporte=null;
	@ManyToOne
	private TipoDeEquipaje equipaje=null;
	@ManyToOne
	private Destinos destinos;
	private Integer dias=0;
	private Double distancia;
	private String nombre;
	
//	private List<Itinerario> lista; 

	private Double precioTotal;

	public Itinerario(TipoDeTransporte transporte,Double distancia, Integer dias, TipoDeEquipaje equipaje) {
		this.transporte=transporte;
		this.distancia=distancia;
		this.dias=dias;
		this.equipaje=equipaje;
		this.precioTotal=0.0;
	}
	
	public Itinerario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public TipoDeEquipaje getEquipaje() {
		return equipaje;
	}

	public void setEquipaje(TipoDeEquipaje equipaje) {
		this.equipaje = equipaje;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public TipoDeTransporte getTransporte() {
		return transporte;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}
	
	public void setTransporte(TipoDeTransporte transporte2) {
		this.transporte=transporte2;
	}

	public Integer getDias() {
		return dias;
	}

	public void sumarPrecio(Double monto) {
		this.precioTotal += monto;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	
	
//	public List<Itinerario> getLista() {
//		return lista;
//	}
//
//	public void setDestino(List<Itinerario> lista) {
//		this.lista = lista;
//	}
//	
	
	
	
}
