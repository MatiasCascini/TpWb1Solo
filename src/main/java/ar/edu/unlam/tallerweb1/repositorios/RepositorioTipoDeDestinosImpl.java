package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.controladores.DatosItinerario;
import ar.edu.unlam.tallerweb1.modelo.Destinos;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDestino;

@Repository("repositorioTipoDeDestinos")
public class RepositorioTipoDeDestinosImpl implements RepositorioTipoDeDestinos{

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioTipoDeDestinosImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(TipoDeDestino tipo) {
		sessionFactory.getCurrentSession().save(tipo);
	}

	@Override
	public TipoDeDestino buscar(Long id) {
		return (TipoDeDestino) sessionFactory.getCurrentSession().createCriteria(TipoDeDestino.class)
		.add(Restrictions.eq("id", id))
		.uniqueResult();
	}

	@Override
	public void modificar(TipoDeDestino tipo) {
		sessionFactory.getCurrentSession().update(tipo);
	}
    
    
}
