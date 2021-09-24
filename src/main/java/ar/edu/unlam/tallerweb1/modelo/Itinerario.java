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
	private Map<String, Destinos> destino = new HashMap<>(); 
	private TipoDeTransporte transporte=null;
	private Integer dias=0;
	private Double distancia;
	private TipoDeEquipaje equipaje;
	private Double precioTotal;
	
	public void setParametros(TipoDeTransporte transporte,Double distancia, Integer dias, TipoDeEquipaje equipaje) {
		this.transporte=transporte;
		this.distancia=distancia;
		this.dias=dias;
		this.equipaje=equipaje;
		this.precioTotal=0.0;
	}
	
	public void agregarDestino(String nombre, TipoDeDestino tipo) {
		Destinos destino1 = new Destinos(nombre, tipo);
		destino.put(nombre, destino1);
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

	public Double calcularPrecio(String destino1, Estadia miEstadia) {
		Destinos miDestino = buscarRegistro(destino1);
		
		precioTotal += calcularPrecioTransporte(transporte);
		precioTotal += calcularPrecioEquipaje(equipaje);
		precioTotal += miEstadia.getPrecioXNoche()*this.dias;
		
		return precioTotal;
	}

	private Double calcularPrecioTransporte(TipoDeTransporte transporte2) {
		switch (transporte) {
		case AVION:
			return distancia*15;

		case AUTO:
			return distancia*13;

		case BUS:
			return distancia*10;

		case MOTO:
			return distancia*8;

		default:
			return 0.0;
		}
	}

	private Double calcularPrecioEquipaje(TipoDeEquipaje equipaje2) {
		switch (equipaje2) {
		case DE_MANO:
			return 5000.0;
			
		case CHICO:
			return 8000.0;

		case GRANDE:
			return 10000.0;

		default:
			return 0.0;
		}
	}
	
}
