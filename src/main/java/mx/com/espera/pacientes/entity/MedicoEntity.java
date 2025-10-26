package mx.com.espera.pacientes.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

public class MedicoEntity {
	private Long idMedico;
	private String cedulaProfesional;
	private String cedulaProfesionalEsp;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id_medico")
	private PersonaEntity persona; //un medico es una persona
	
	public String getCedulaProfesional() {
		return cedulaProfesional;
	}
	public void setCedulaProfesional(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}
	public String getCedulaProfesionalEsp() {
		return cedulaProfesionalEsp;
	}
	public void setCedulaProfesionalEsp(String cedulaProfesionalEsp) {
		this.cedulaProfesionalEsp = cedulaProfesionalEsp;
	}
	public PersonaEntity getPersona() {
		return persona;
	}
	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}
	public Long getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}
	
}
