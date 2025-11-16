package mx.com.espera.pacientes.app;

import java.util.List;

import mx.com.espera.pacientes.entity.PacienteEntity;

public interface PacienteApp {
	/**
	 * Obtenemos una lista con todos los pacientes
	 * @return
	 */
	List<PacienteEntity> obtenerTodosLosPacientes();
	/**
	 * Dado un idMedico, vamos a obtener todos los pacientes ligados al idMedico.
	 * @param idMedico
	 * @return
	 */
	List<PacienteEntity> obtenerTodosLosPacientesPorMedico(Long idMedico);	
	
	//Metodos para:
	//actualizar posicion en lista
	//agregar paciente a lista
	//eliminar paciente de la lista, ya se atendio
}
