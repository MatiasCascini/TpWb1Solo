package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Excursiones;

@Repository("repositorioExcursiones")
public class RepositorioExcursionesImpl implements RepositorioExcursiones {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioExcursionesImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void guardar(Excursiones excursion) {
		sessionFactory.getCurrentSession().save(excursion);		
	}

	@Override
	public Excursiones buscar(Long id) {
		return (Excursiones) sessionFactory.getCurrentSession().createCriteria(Excursiones.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void modificar(Excursiones excursion) {
		sessionFactory.getCurrentSession().update(excursion);
	}

}
