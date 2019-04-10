package es.upm.dit.isst.rgpd.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Experto {
	
	@Id
	private String email;
	
	private String nombre;
	
	private String password;
	
	private boolean disponible;
	
	
	@ManyToMany(mappedBy = "expertos", fetch = FetchType.EAGER)
	private Collection<Solicitud> solAsignadas;
	
	
	public Experto() {
		
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public Collection<Solicitud> getSolAsignadas() {
		return solAsignadas;
	}


	public void setSolAsignadas(Collection<Solicitud> solAsignadas) {
		this.solAsignadas = solAsignadas;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



}
