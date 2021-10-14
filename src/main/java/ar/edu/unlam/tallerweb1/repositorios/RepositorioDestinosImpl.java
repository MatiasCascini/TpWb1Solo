package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.controladores.DatosItinerario;
import ar.edu.unlam.tallerweb1.modelo.Destinos;

@Repository("repositorioDestinos")
public class RepositorioDestinosImpl implements RepositorioDestinos{

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioDestinosImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    @Override
	public void guardar(Destinos Destino) {
		sessionFactory.getCurrentSession().save(Destino);
	}

	@Override
	public Destinos buscar(Long id) {
		return (Destinos) sessionFactory.getCurrentSession().createCriteria(Destinos.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	@Override
	public Destinos buscarPorNombre(String nombre) {
		return (Destinos) sessionFactory.getCurrentSession().createCriteria(Destinos.class)
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
	}
	
	@Override
	public Destinos buscarDestino(DatosItinerario datosItinerario) {
		return (Destinos) sessionFactory.getCurrentSession().createCriteria(Destinos.class)
				.add(Restrictions.eq("nombre", datosItinerario.getNombreDestino()))
				.uniqueResult();
	}

	@Override
	public void modificar(Destinos Destino) {
		sessionFactory.getCurrentSession().update(Destino);
	}
}
