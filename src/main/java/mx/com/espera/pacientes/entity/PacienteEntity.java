package mx.com.espera.pacientes.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class PacienteEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1645802151904007108L;
	private Long idPaciente;
	private String primerNombre;
	private String segundoNombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private LocalDate fechaConsulta;
	private LocalTime horaConsulta;
	private LocalDateTime fechaSiguienteConsulta;
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public LocalDate getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDate fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}
	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	public LocalDateTime getFechaSiguienteConsulta() {
		return fechaSiguienteConsulta;
	}
	public void setFechaSiguienteConsulta(LocalDateTime fechaSiguienteConsulta) {
		this.fechaSiguienteConsulta = fechaSiguienteConsulta;
	}
	
	
}
