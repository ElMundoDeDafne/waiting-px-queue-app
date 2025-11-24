package mx.com.espera.pacientes.app;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mx.com.espera.pacientes.dto.SignosVitalesDTO;
import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.entity.SignoVitalEntity;
import mx.com.espera.pacientes.repository.PacienteRepository;

@Service
public class PacienteAppImpl implements PacienteApp {

	@Autowired PacienteRepository pacienteRepository;
	@PersistenceContext EntityManager em;
	
	@Override
	public List<PacienteEntity> obtenerTodosLosPacientes() {
		return pacienteRepository.findAllPacientes();
	}

	@Override
	public List<PacienteEntity> obtenerTodosLosPacientesPorMedico(Long idMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void obtenerHistorialConsultas() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public String registrarSignosVitales(SignosVitalesDTO signosVitales) {
		SignoVitalEntity signoVitalEntity;
		PacienteEntity pacienteEntity;
		String respuesta = "";
		pacienteEntity = em.find(PacienteEntity.class,signosVitales.getIdPaciente());
		signoVitalEntity = new SignoVitalEntity();
		signoVitalEntity.setImc(signosVitales.getImc());
		signoVitalEntity.setPaciente(pacienteEntity);
		signoVitalEntity.setEstatura(signosVitales.getEstatura());
		signoVitalEntity.setFechaRegistro(LocalDateTime.now());
		signoVitalEntity.setPeso(signosVitales.getPeso());
		signoVitalEntity.setTemperatura(signosVitales.getTemperatura());
		em.merge(signoVitalEntity);
		em.merge(pacienteEntity);
		respuesta = "Registro exitoso";
		return respuesta;
	}

}
