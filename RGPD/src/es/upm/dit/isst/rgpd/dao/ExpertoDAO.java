package es.upm.dit.isst.rgpd.dao;

import java.util.List;

import es.upm.dit.isst.rgpd.model.Experto;


public interface ExpertoDAO {

	public void create(Experto experto);

	public Experto read(String email);

	public void update(Experto experto);

	public void delete(Experto experto);

	public List<Experto> readAll();

}
