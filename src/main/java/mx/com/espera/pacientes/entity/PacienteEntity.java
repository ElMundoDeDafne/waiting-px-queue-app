package mx.com.espera.pacientes.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class PacienteEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1645802151904007108L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PACIENTE")
	private Long idPaciente;
	private LocalDateTime fechaConsulta;
	private LocalDateTime fechaSiguienteConsulta;
	private String motivoConsulta;
	private LocalDateTime fechaRegistro;
	@OneToMany(mappedBy = "paciente")
	private List<SignoVitalEntity> signosVitales; //una persona tiene mas de una forma de localizar

	@OneToOne
	@MapsId
	@JoinColumn(name="ID_PACIENTE")
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
	public PersonaEntity getPersona() {
		return persona;
	}
	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public List<SignoVitalEntity> getSignosVitales() {
		return signosVitales;
	}
	public void setSignosVitales(List<SignoVitalEntity> signosVitales) {
		this.signosVitales = signosVitales;
	}
	
}
