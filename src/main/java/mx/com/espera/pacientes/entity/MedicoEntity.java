package mx.com.espera.pacientes.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "MEDICO")
public class MedicoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3929902088989093514L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MEDICO")
	private Long idMedico;
	private String cedulaProfesional;
	private String cedulaProfesionalEsp;
	@ManyToMany
	@JoinTable (name = "Paciente", joinColumns = @JoinColumn(name="paciente_id"), inverseJoinColumns = @JoinColumn(name = "id_medico"))
	private List<PacienteEntity> pacientes; //un medico puede tener uno o mas pacientes
	
	@OneToOne
	@MapsId
	@JoinColumn(name="ID_MEDICO")
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
	public List<PacienteEntity> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<PacienteEntity> pacientes) {
		this.pacientes = pacientes;
	}
	
}
