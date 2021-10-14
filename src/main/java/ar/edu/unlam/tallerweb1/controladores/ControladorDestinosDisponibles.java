package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ClaveLongitudIncorrectaException;
import ar.edu.unlam.tallerweb1.servicios.ClavesDistintasException;
import ar.edu.unlam.tallerweb1.servicios.DestinoNoExisteException;
import ar.edu.unlam.tallerweb1.servicios.ServicioDestinos;
import ar.edu.unlam.tallerweb1.servicios.ServicioItinerario;
import ar.edu.unlam.tallerweb1.servicios.UsuarioYaExisteException;


@Controller
public class ControladorDestinosDisponibles {

	@RequestMapping(path = "/destinosDisponibles")
    public ModelAndView mostrarDestinos(@ModelAttribute("datosItinerario") DatosItinerario datosItinerario){
        ModelMap modelo = new ModelMap();
        modelo.put("destino1", datosItinerario.getNombreDestino());
        return new ModelAndView("destinosDisponibles",modelo);
    }
		
}
