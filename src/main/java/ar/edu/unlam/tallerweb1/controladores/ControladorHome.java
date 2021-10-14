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
public class ControladorHome {

	private ServicioDestinos servicioDestinos;

	@Autowired
	public ControladorHome(ServicioDestinos servicioDestinos){
		this.servicioDestinos = servicioDestinos;
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView mostrarHome(){
		servicioDestinos.completarBase();
        ModelMap modelo = new ModelMap();
        modelo.put("datosItinerario", new DatosItinerario());
        return new ModelAndView("home",modelo);
    }
	
	@RequestMapping(path = "/destinos", method = RequestMethod.POST)
    public ModelAndView Destinos(@ModelAttribute("datosItinerario") DatosItinerario datosItinerario) {
        ModelMap modelo = new ModelMap();
        try{
            servicioDestinos.buscarDestino(datosItinerario);
        }catch (DestinoNoExisteException e){
            return registroFallido(modelo, "El registro no existe");
        }
        return registroExitoso();
    }
	
    private ModelAndView registroExitoso() {
        return new ModelAndView("redirect:/destinosDisponibles");
    }

    private ModelAndView registroFallido(ModelMap modelo, String mensaje) {
        modelo.put("error", mensaje);
        return new ModelAndView("home", modelo);
    }
	
    @RequestMapping(path = "/saludar", method = RequestMethod.GET)
    public ModelAndView saludar1(){
        ModelMap modelo = new ModelMap();
        modelo.put("mensaje1", "Hola como estas?");
        modelo.put("mensaje2", "Soy flor!");
        return new ModelAndView("saludo", modelo);
    }
    
    
//	@RequestMapping(path = "/usarPresupuesto", method = RequestMethod.POST)
//	public ModelAndView validarLogin(@ModelAttribute("datosItinerario") DatosItinerario datosItinerario, HttpServletRequest request) {
//		ModelMap model = new ModelMap();
//		
//		return new ModelAndView("login", model);
//	}
	
}
