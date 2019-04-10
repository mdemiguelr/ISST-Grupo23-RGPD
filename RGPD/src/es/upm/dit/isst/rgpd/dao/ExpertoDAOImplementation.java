package es.upm.dit.isst.rgpd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.rgpd.model.Experto;

public class ExpertoDAOImplementation implements ExpertoDAO {

private static ExpertoDAOImplementation instance = null;
	
	private ExpertoDAOImplementation() {}
	
	public static ExpertoDAOImplementation getInstance() {
		if( null == instance ) instance = new ExpertoDAOImplementation();
		return instance;
	}
	
	
	@Override
	public void create(Experto experto) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.save( experto );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  
		} finally {
		  session.close();
		}
	}

	@Override
	public Experto read(String email) {
		
		Session session = SessionFactoryService.get().openSession();
		Experto experto = new Experto();
		try {
			session.beginTransaction();
			experto = session.load( Experto.class, email );
			session.getTransaction().commit();
		} catch (Exception e) {
			  
		} finally {
			  session.close();
		}
		return experto;
		
	}

	@Override
	public void update(Experto experto) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.saveOrUpdate( experto );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  
		} finally {
		  session.close();
		}
	}

	@Override
	public void delete(Experto experto) {
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  session.delete( experto );
		  session.getTransaction().commit();
		} catch (Exception e) {
		  
		} finally {
		  session.close();
		}
	}

	@Override
	public List<Experto> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Experto> expertos = new ArrayList<>();
		try {
			session.beginTransaction();
			expertos = session.createQuery("from Experto").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		return expertos;
	}

}
