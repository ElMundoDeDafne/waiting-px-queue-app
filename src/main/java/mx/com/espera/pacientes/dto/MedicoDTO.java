package mx.com.espera.pacientes.dto;

import java.io.Serializable;
import java.util.List;

public class MedicoDTO extends PersonaDTO implements Serializable {
	private List<PacienteDTO> pacientes;

	public List<PacienteDTO> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteDTO> pacientes) {
		this.pacientes = pacientes;
	}
	
	
}
