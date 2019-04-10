package es.upm.dit.isst.rgpd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Solicitud implements Serializable {
	
	
	
	@Id
	private int id = 0;
	
	private String titulo;
	
	private String departamento;
	
	private String escuela;
	
	private int estado;
	
	@Lob
	private byte[] memoria;

	@ManyToOne
	private Investigador investigador;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Experto> expertos;
	
	public Solicitud() {
		this.id = (id+1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public byte[] getMemoria() {
		return memoria;
	}

	public void setMemoria(byte[] memoria) {
		this.memoria = memoria;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Experto> getExpertos() {
		return expertos;
	}

	public void setExpertos(List<Experto> expertos) {
		this.expertos = expertos;
	}

	

}
