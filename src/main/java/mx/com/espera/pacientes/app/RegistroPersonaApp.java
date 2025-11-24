package mx.com.espera.pacientes.app;

import mx.com.espera.pacientes.dto.PersonaDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;

public interface RegistroPersonaApp {
	/***
	 * Registers a new person, whether is a medic or patient.
	 * @param personaDTO
	 * @return <code>ResponseDTO</code> response object notifying success.
	 */
	ResponseDTO registroPersona(PersonaDTO personaDTO);
}
