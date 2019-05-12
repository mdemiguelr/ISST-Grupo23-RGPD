package es.upm.dit.isst.rgpd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.rgpd.dao.ExpertoDAO;
import es.upm.dit.isst.rgpd.dao.ExpertoDAOImplementation;
import es.upm.dit.isst.rgpd.model.Experto;

import es.upm.dit.isst.rgpd.dao.SolicitudDAO;
import es.upm.dit.isst.rgpd.dao.SolicitudDAOImplementation;
import es.upm.dit.isst.rgpd.model.Solicitud;

import es.upm.dit.isst.rgpd.dao.InvestigadorDAO;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.rgpd.model.Investigador;

class TestExpertoDAOImplementation {
	
	private Experto exp1;
	private Experto exp2;
	private Experto exp3;
	private Experto exp4;
	private Solicitud sol;
	private Investigador inv;
	private List<Experto> expertos;

	@BeforeEach
	void setUp() throws Exception {
		exp1 = new Experto();
		exp1.setEmail("e1@gmail.com");
		exp1.setDisponible(true);
		exp1.setNombre("n1");
		exp1.setPassword("p1");
		List<Solicitud> soli = new ArrayList<Solicitud>();
		exp1.setSolAsignadas(soli);
		ExpertoDAOImplementation.getInstance().create(exp1);	
		
	}

	@AfterEach
	void tearDown() throws Exception {
		ExpertoDAOImplementation.getInstance().delete(exp1);
		exp1 = null;
	}
	
	@Test
	public void testCreate() {
		ExpertoDAO dao = ExpertoDAOImplementation.getInstance();
		Experto exp2 = new Experto();
		exp2.setEmail("e1@gmail.com");
		exp2.setDisponible(true);
		exp2.setNombre("n1");
		exp2.setPassword("p1");
		dao.create(exp2);
		Experto exp3 = dao.read("e1@gmail.com");
		assertEquals(exp1.getEmail(), exp3.getEmail());
		assertEquals(exp1.getNombre(), exp3.getNombre());
		assertEquals(exp1.getPassword(), exp3.getPassword());		
	}
	
	@Test
	public void testRead() {
		ExpertoDAO dao = ExpertoDAOImplementation.getInstance();
		Experto exp2 = dao.read("e1@gmail.com");
		assertEquals(exp1.getNombre(), exp2.getNombre());
		assertEquals(exp1.getEmail(), exp2.getEmail());
		assertEquals(exp1.getPassword(), exp2.getPassword());
	}
	
	@Test
	public void testUpdate() {
		exp1.setNombre("b");
		ExpertoDAO dao = ExpertoDAOImplementation.getInstance();
		
		dao.update(exp1);
		Experto exp2 = dao.read(exp1.getEmail());
		assertEquals(exp1.getNombre(), exp2.getNombre());
		
	}
	
	
	@Test
	public void testReadAll() {
		ExpertoDAO dao = ExpertoDAOImplementation.getInstance();
		List<Experto> read = dao.readAll();
		
		List<Experto> currentExperto = new ArrayList<>();
		currentExperto.add(exp1);
		assertEquals(currentExperto.size(), read.size());
	}

}
