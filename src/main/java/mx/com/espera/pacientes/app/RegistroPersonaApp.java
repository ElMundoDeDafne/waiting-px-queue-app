package mx.com.espera.pacientes.app;

import mx.com.espera.pacientes.dto.PersonaDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;

public interface RegistroPersonaApp {
	ResponseDTO registroPersona(PersonaDTO personaDTO);
}
