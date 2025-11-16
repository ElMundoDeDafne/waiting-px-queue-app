package mx.com.espera.pacientes.app;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mx.com.espera.pacientes.dto.PersonaDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;
import mx.com.espera.pacientes.entity.MedicoEntity;
import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.entity.PersonaEntity;
import mx.com.espera.pacientes.repository.MedicoRepository;
import mx.com.espera.pacientes.repository.PacienteRepository;
import mx.com.espera.pacientes.repository.PersonaRepository;

@Service
public class RegistroPersonaAppImpl implements RegistroPersonaApp {

	@PersistenceContext EntityManager em;
	
	@Override
	public ResponseDTO registroPersona(@RequestBody PersonaDTO personaDTO) {
		ResponseDTO respuesta = new ResponseDTO();
		Map<String, Object> hm = new HashMap();		
		registrarPersona(personaDTO);
		hm.put("datos", personaDTO.getMensajes());
		respuesta.setExito(true);
		respuesta.setRespuesta(hm);
		return respuesta;
	}

	/***
	 * Método para hacer el registro de una persona.
	 * @param personaDTO
	 * @author Christian
	 */
	@Transactional
	private void registrarPersona(PersonaDTO personaDTO) {
		MedicoEntity medicoEntity;
		PacienteEntity pacienteEntity;
		PersonaEntity personaEntity = new PersonaEntity();		
		boolean esMedico = personaDTO.getCedulaProfesional()!=null&&personaDTO.getCedulaProfesional().length()>0;
		personaEntity.setApMaterno(personaDTO.getApellidoMaterno());
		personaEntity.setApPaterno(personaDTO.getApellidoPaterno());
		personaEntity.setFechaNacimiento(personaDTO.getFechaNacimiento());
		personaEntity.setPrimerNombre(personaDTO.getPrimerNombre());
		personaEntity.setSegundoNombre(personaDTO.getSegundoNombre()!=null&&personaDTO.getSegundoNombre().length()>0?personaDTO.getSegundoNombre():null);
		personaEntity.setGenero(personaDTO.getGenero());
		personaEntity.setSexo(personaDTO.getSexo());
		em.persist(personaEntity);
		if(esMedico) {
			medicoEntity = new MedicoEntity();
			medicoEntity.setPersona(personaEntity);
			medicoEntity.setCedulaProfesional(personaDTO.getCedulaProfesional());
			medicoEntity.setCedulaProfesionalEsp(personaDTO.getCedulaProfesionalEsp());
			em.persist(medicoEntity);
		} else {
			pacienteEntity = new PacienteEntity();
			pacienteEntity.setPersona(personaEntity);
			pacienteEntity.setFechaConsulta(LocalDateTime.now());
			//Por ahora se registran datos basicos de la persona, suponiendo que se registrarán en consulta los demás (signos vitales)
			em.persist(pacienteEntity);
		}
		personaDTO.setMensajes("Registro exitoso");
	}
}
