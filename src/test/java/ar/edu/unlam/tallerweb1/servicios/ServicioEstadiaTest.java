package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.enumeradores.TipoDeDestino;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeEquipaje;
import ar.edu.unlam.tallerweb1.enumeradores.TipoDeTransporte;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;
import ar.edu.unlam.tallerweb1.repositorios.TablaUsuario;

public class ServicioEstadiaTest {

	ServicioEstadia estadia = new ServicioEstadia();
	
    @Before
    public void init(){
        TablaUsuario.getInstance().reset();
    }
	
	
}
