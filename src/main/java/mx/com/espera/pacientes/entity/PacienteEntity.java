package mx.com.espera.pacientes.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class PacienteEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1645802151904007108L;
	private Long idPaciente;
	private LocalDateTime fechaConsulta;
	private LocalDateTime fechaSiguienteConsulta;
	private String motivoConsulta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_SIGNOS_VITALES", referencedColumnName = "ID_SIGNOS_VITALES")	
	private SignoVitalEntity signosVitales;

	@OneToOne
	@MapsId
	@JoinColumn(name="id_medico")
	private PersonaEntity persona; //un paciente es una persona
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public LocalDateTime getFechaSiguienteConsulta() {
		return fechaSiguienteConsulta;
	}
	public void setFechaSiguienteConsulta(LocalDateTime fechaSiguienteConsulta) {
		this.fechaSiguienteConsulta = fechaSiguienteConsulta;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public SignoVitalEntity getSignosVitales() {
		return signosVitales;
	}
	public void setSignosVitales(SignoVitalEntity signosVitales) {
		this.signosVitales = signosVitales;
	}
	public PersonaEntity getPersona() {
		return persona;
	}
	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}	
}
