package es.upm.dit.isst.rgpd.dao;

import java.util.Collection;

import es.upm.dit.isst.rgpd.model.Solicitud;

public interface SolicitudDAO {
	
	public void create(Solicitud solicitud);

	public Solicitud read(int id);

	public void update(Solicitud solicitud);

	public void delete(Solicitud solicitud);

	public Collection<Solicitud> readAll();
}
