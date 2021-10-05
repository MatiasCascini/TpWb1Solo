package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Itinerario;

@Repository("repositorioItinerario")
public class RepositorioItinerarioImpl implements RepositorioItinerario {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioItinerarioImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    @Override
	public void guardar(Itinerario itinerario) {
		sessionFactory.getCurrentSession().save(itinerario);
	}

	@Override
	public Itinerario buscar(Long id) {
		return (Itinerario) sessionFactory.getCurrentSession().createCriteria(Itinerario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void modificar(Itinerario itinerario) {
		sessionFactory.getCurrentSession().update(itinerario);
	}
}
