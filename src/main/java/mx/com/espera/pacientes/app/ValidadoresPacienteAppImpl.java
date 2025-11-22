package mx.com.espera.pacientes.app;

import mx.com.espera.pacientes.dto.PacienteDTO;

public class ValidadoresPacienteAppImpl implements ValidadoresPacienteApp {

	@Override
	public Boolean validarDatosPaciente(PacienteDTO pacienteDTO) {
		Boolean esValido = false;
		if(pacienteDTO.getPrimerNombre()!=null) {
			esValido = true;
		}
		return esValido;
	}
	
}
