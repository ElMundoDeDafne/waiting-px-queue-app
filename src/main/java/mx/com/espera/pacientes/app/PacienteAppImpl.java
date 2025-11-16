package mx.com.espera.pacientes.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.repository.PacienteRepository;

public class PacienteAppImpl implements PacienteApp {

	@Autowired PacienteRepository pacienteRepository;
	
	@Override
	public List<PacienteEntity> obtenerTodosLosPacientes() {
		return pacienteRepository.findAllPacientes();
	}

	@Override
	public List<PacienteEntity> obtenerTodosLosPacientesPorMedico(Long idMedico) {
		// TODO Auto-generated method stub
		return null;
	}

}
