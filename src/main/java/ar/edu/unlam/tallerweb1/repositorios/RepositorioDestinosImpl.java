package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Destinos;

@Repository("repositorioDestinos")
public class RepositorioDestinosImpl implements RepositorioDestinos{

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioDestinosImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    @Override
	public void guardar(Destinos itinerario) {
		sessionFactory.getCurrentSession().save(itinerario);
	}

	@Override
	public Destinos buscar(Long id) {
		return (Destinos) sessionFactory.getCurrentSession().createCriteria(Destinos.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void modificar(Destinos itinerario) {
		sessionFactory.getCurrentSession().update(itinerario);
	}
}
