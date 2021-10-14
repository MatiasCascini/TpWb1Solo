package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Destinos_Excursiones;
import ar.edu.unlam.tallerweb1.modelo.Excursiones;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDestinos;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDestinos_Excursiones;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioExcursiones;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoDeDestinos;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin){
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		modelo.put("datosLogin", new DatosLogin());
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
		if(usuarioBuscado==null){
			model.put("error", "Usuario o clave incorrecta");
		}
		else if(usuarioBuscado.getEmail()=="admin"&&usuarioBuscado.getPassword()=="admin") {
			request.getSession().setAttribute("ADMIN", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/administrar");
		}else{
				request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
				return new ModelAndView("redirect:/home");
		}
		return new ModelAndView("login", model);
	}
	
}