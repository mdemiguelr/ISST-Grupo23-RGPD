package es.upm.dit.isst.rgpd.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.rgpd.model.Experto;
import es.upm.dit.isst.rgpd.model.Investigador;
import es.upm.dit.isst.rgpd.dao.SessionFactoryService;


public class InvestigadorDAOImplementation implements InvestigadorDAO {

	private static  InvestigadorDAOImplementation instance = null;
	
	private InvestigadorDAOImplementation() {}
	 
	public static  InvestigadorDAOImplementation getInstance() {
	    if( null == instance ) 
	      instance = new  InvestigadorDAOImplementation();
	    return instance;
	}
	
	@Override
	public void create(Investigador investigador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save( investigador );
			session.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {

			session.close();
		}
			
	}

	@Override
	public Investigador read(String email) {
		Session session = SessionFactoryService.get().openSession();
		Investigador investigador = new Investigador();
		try {
			session.beginTransaction();
			investigador = session.load( Investigador.class, email );
			session.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			
			session.close();
		}
		return investigador;
	}

	@Override
	public void update(Investigador investigador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate( investigador );
			session.getTransaction().commit();
		} catch (Exception e) {
			
		}finally {
			session.close();
		}
			
		
	}

	@Override
	public void delete(Investigador investigador) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete( investigador );
			session.getTransaction().commit();
		} catch (Exception e) {
			
		}finally {

			session.close();
		}
		
	}
	
	@Override
	public Collection<Investigador> readAll() {
		Session session = SessionFactoryService.get().openSession();
		Collection<Investigador> investigadores = new ArrayList<>();
		try {
			session.beginTransaction();
			investigadores = session.createQuery("from Experto").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		return investigadores;
	}

}