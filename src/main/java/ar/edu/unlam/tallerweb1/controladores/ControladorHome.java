package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.repositorios.TablaItinerario;
import ar.edu.unlam.tallerweb1.repositorios.TablaUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioItinerario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorHome {

    private TablaUsuario tablaUsuario = TablaUsuario.getInstance();
    private ServicioUsuario servicioUsuario = new ServicioUsuario();
    private TablaItinerario tablaItinerario = TablaItinerario.getInstance();
    private ServicioItinerario servicioItinerario = new ServicioItinerario();
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView mostrarHome(){
        ModelMap modelo = new ModelMap();
        modelo.put("presupuesto", new Presupuesto());
        return new ModelAndView("home",modelo);
    }
	
}
