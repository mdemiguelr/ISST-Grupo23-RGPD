package es.upm.dit.isst.rgpd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.rgpd.dao.InvestigadorDAO;
import es.upm.dit.isst.rgpd.dao.InvestigadorDAOImplementation;
import es.upm.dit.isst.rgpd.model.Investigador;

class TestInvestigadorDAOImplementation {
	
	private Investigador inv; 
	
	@BeforeEach
	void setUp() throws Exception {
		inv = new Investigador();
		inv.setEmail("i@gmail.com");
		inv.setNombre("n");
		inv.setPassword("p");
		inv.setApellidos("a");
		InvestigadorDAOImplementation.getInstance().create(inv);
	
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		InvestigadorDAOImplementation.getInstance().delete(inv);
		inv = null;
	}
	

	@Test
	public void testCreate() {
		InvestigadorDAO dao = InvestigadorDAOImplementation.getInstance();
		Investigador inv1 = new Investigador();
		inv1.setEmail("i@gmail.com");
		inv1.setNombre("n");
		inv1.setPassword("p");
		inv1.setApellidos("a");
		dao.create(inv1);
		Investigador inv2 = dao.read("i@gmail.com");
		assertEquals(inv.getNombre(), inv2.getNombre());
		assertEquals(inv.getEmail(), inv2.getEmail());
		assertEquals(inv.getPassword(), inv2.getPassword());
		assertEquals(inv.getApellidos(), inv2.getApellidos());
		
	}
	@Test
	public void testRead() {
		InvestigadorDAO dao = InvestigadorDAOImplementation.getInstance();
		Investigador inv2 = dao.read("i@gmail.com");
		assertEquals(inv.getNombre(), inv2.getNombre());
		assertEquals(inv.getEmail(), inv2.getEmail());
		assertEquals(inv.getPassword(), inv2.getPassword());
		assertEquals(inv.getApellidos(), inv2.getApellidos());
		
	}
	
	@Test
	public void testUpdate() {
		inv.setApellidos("b");
		InvestigadorDAO dao = InvestigadorDAOImplementation.getInstance();
		
		dao.update(inv);
		Investigador inv2 = dao.read(inv.getEmail());
		assertEquals(inv.getApellidos(), inv2.getApellidos());
		
	}
	
	@Test
	public void testReadAll() {
		InvestigadorDAO dao = InvestigadorDAOImplementation.getInstance();
		List<Investigador> read = dao.readAll();
		
		List<Investigador> currentInvestigador = new ArrayList<>();
		currentInvestigador.add(inv);
		assertEquals(currentInvestigador.size(), read.size());
	}
	
	@Test
	public void testDelete() {
		InvestigadorDAO dao = InvestigadorDAOImplementation.getInstance();
		
		dao.delete(inv);
		
		Investigador iDeleted= dao.read(inv.getEmail());
		System.out.println(iDeleted);
		assertNull(iDeleted);
		
	}
	

}
