package es.upm.dit.isst.rgpd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.upm.dit.isst.rgpd.model.Solicitud;

@Entity
public class Investigador implements Serializable {
	
	
	@Id
	private String email;
	
	private String nombre;
	
	private String password;
	private String apellidos;
	
	

	@OneToMany(mappedBy = "investigador", fetch = FetchType.EAGER)
	private List<Solicitud> solRealizadas;
	
	
	public Investigador() {
		
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

	public List<Solicitud> getSolRealizadas() {
		return solRealizadas;
	}

	public void setSolRealizadas(List<Solicitud> solRealizadas) {
		this.solRealizadas = solRealizadas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	

}
