package mx.com.espera.pacientes.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PacienteDTO extends PersonaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2825552759948417908L;
	private Long idPaciente;
	private Long posicion;
	private String motivoConsulta;
	private String estatus;
	private LocalDateTime fechaRegistro;
	private LocalDateTime fechaActualizacion;
	private SignosVitalesDTO signosVitalesDTO;
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Long getPosicion() {
		return posicion;
	}
	public void setPosicion(Long posicion) {
		this.posicion = posicion;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public SignosVitalesDTO getSignosVitalesDTO() {
		return signosVitalesDTO;
	}
	public void setSignosVitalesDTO(SignosVitalesDTO signosVitalesDTO) {
		this.signosVitalesDTO = signosVitalesDTO;
	}
	

	
	
}
