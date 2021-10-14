package ar.edu.unlam.tallerweb1.controladores;

public class DatosItinerario {
	private Double presupuesto;
	private String nombreDestino;

	public DatosItinerario() {}
	
	public DatosItinerario(Double presupuesto, String nombreDestino) {
		this.presupuesto=presupuesto;
		this.nombreDestino=nombreDestino;
	}
	
	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getNombreDestino() {
		return nombreDestino;
	}

	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}

}
