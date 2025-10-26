package mx.com.espera.pacientes.app;

import mx.com.espera.pacientes.dto.PacienteDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;

public interface ActualizarDatosPacienteApp {
	ResponseDTO actualizarDatosPaciente(PacienteDTO pacienteDTO);
}
