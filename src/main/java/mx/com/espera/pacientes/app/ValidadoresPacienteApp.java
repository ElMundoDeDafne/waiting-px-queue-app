package mx.com.espera.pacientes.app;

import mx.com.espera.pacientes.dto.LocalizadorDTO;
import mx.com.espera.pacientes.dto.PacienteDTO;

public interface ValidadoresPacienteApp {

	Boolean validarDatosPaciente(PacienteDTO pacienteDTO);
	Boolean validarLocalizadores(LocalizadorDTO localizadorDTO);
}
