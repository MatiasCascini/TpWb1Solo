package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;

@Entity
public class Itinerario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Map<Long, Destinos> destino = new HashMap<>(); 
	private TipoDeTransporte transporte=null;
	private Integer dias=0;
	private Double distancia;
	private TipoDeEquipaje equipaje;
	private Double precioTotal;

	public Itinerario(TipoDeTransporte transporte,Double distancia, Integer dias, TipoDeEquipaje equipaje) {
		this.transporte=transporte;
		this.distancia=distancia;
		this.dias=dias;
		this.equipaje=equipaje;
		this.precioTotal=0.0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Long, Destinos> getDestino() {
		return destino;
	}

	public void setDestino(Map<Long, Destinos> destino) {
		this.destino = destino;
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
	
}
