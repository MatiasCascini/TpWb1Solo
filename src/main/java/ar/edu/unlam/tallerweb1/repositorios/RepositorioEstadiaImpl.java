package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Estadia;

@Repository("repositorioEstadia")
public class RepositorioEstadiaImpl implements RepositorioEstadia{

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioEstadiaImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    @Override
	public void guardar(Estadia itinerario) {
		sessionFactory.getCurrentSession().save(itinerario);
	}

	@Override
	public Estadia buscar(Long id) {
		return (Estadia) sessionFactory.getCurrentSession().createCriteria(Estadia.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void modificar(Estadia estadia) {
		sessionFactory.getCurrentSession().update(estadia);
	}
}
