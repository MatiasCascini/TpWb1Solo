package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {

	Usuario registrar(DatosRegistro datosRegistro);
	Boolean lasClavesSonDistintas(DatosRegistro datosRegistro);
	Boolean laClaveTieneLongitudIncorrecta(DatosRegistro datosRegistro);
	void registrarAdmin();
	Boolean descontarSaldoAlComprarUnPasaje(Double precio, Usuario usuario);
}
