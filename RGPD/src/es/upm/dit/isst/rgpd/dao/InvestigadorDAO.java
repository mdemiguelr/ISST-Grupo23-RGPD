package es.upm.dit.isst.rgpd.dao;

import java.util.List;

import es.upm.dit.isst.rgpd.model.Investigador;


public interface InvestigadorDAO {
	public void create(Investigador investigador);


	public Investigador read(String email);

	public void update(Investigador investigador);

	public void delete(Investigador investigador);

	public List <Investigador> readAll();


}