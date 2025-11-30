package mx.com.espera.pacientes.app;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.com.espera.pacientes.dto.PacienteDTO;
import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.entity.PersonaEntity;

@Service
public class InsertarColaPacienteAppImpl implements InsertarColaPacienteApp {

	@PersistenceContext EntityManager em;
	
	@Override
	public void insertarColaPaciente(PacienteDTO pacienteDTO) {
		long idPaciente = pacienteDTO.getIdPaciente();
		PacienteEntity paciente = em.find(PacienteEntity.class,idPaciente);
		paciente.setPosicion(pacienteDTO.getPosicion());
		em.merge(paciente);
	}
}
