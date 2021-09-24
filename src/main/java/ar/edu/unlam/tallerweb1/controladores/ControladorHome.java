package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView mostrarFormularioDeRegistro(){
        ModelMap modelo = new ModelMap();
        modelo.put("presupuesto", new Presupuesto());
        return new ModelAndView("home",modelo);
    }
	
}
