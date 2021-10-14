package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.controladores.DatosItinerario;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.Destinos_Excursiones;
import ar.edu.unlam.tallerweb1.modelo.Estadia;
import ar.edu.unlam.tallerweb1.modelo.Excursiones;
import ar.edu.unlam.tallerweb1.modelo.Itinerario;

@Repository("repositorioDestinos_Excursiones")
public class RepositorioDestinos_ExcursionesImpl implements RepositorioDestinos_Excursiones{

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioDestinos_ExcursionesImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    @Override
	public void guardar(Destinos_Excursiones destinosExcursiones) {
		sessionFactory.getCurrentSession().save(destinosExcursiones);
	}

	@Override
	public Destinos_Excursiones buscar(Long id) {
		return (Destinos_Excursiones) sessionFactory.getCurrentSession().createCriteria(Destinos_Excursiones.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	@Override
	public List buscarExcursionesDeUnDestino(Destinos destino) {
		return 	sessionFactory.getCurrentSession().createCriteria(Destinos_Excursiones.class)
				.add(Restrictions.eq("destino", destino))
				.list();
	}
	
	@Override
	public List buscarExcursionesDeUnDestinoDeTipoMontaña(Destinos destino) {
		return 	sessionFactory.getCurrentSession().createCriteria(Destinos_Excursiones.class)
				.createAlias("destino.tipoDeDestino", "Montaña")
				.list();
	}

	@Override
	public void modificar(Destinos_Excursiones destinosExcursiones) {
		sessionFactory.getCurrentSession().update(destinosExcursiones);
	}
	
}
