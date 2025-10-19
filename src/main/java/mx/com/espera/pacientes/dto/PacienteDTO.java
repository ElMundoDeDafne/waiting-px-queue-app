package mx.com.espera.pacientes.dto;

import java.io.Serializable;

public class PacienteDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2825552759948417908L;
	private Long idPaciente;
	private Long posicion;
	
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
	
	
}
