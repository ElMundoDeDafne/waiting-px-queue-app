package mx.com.espera.pacientes.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.espera.pacientes.dto.PacienteDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;
import mx.com.espera.pacientes.dto.SignosVitalesDTO;
import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.entity.SignoVitalEntity;
import mx.com.espera.pacientes.repository.PacienteRepository;
import mx.com.espera.pacientes.repository.SignoVitalRepository;

public class ActualizarDatosPacienteAppImpl implements ActualizarDatosPacienteApp {

	@Autowired PacienteRepository pacienteRepository;
	@Autowired SignoVitalRepository signoVitalRepository;
	
	@Override
	public ResponseDTO actualizarDatosPaciente(PacienteDTO pacienteDTO) {
		ResponseDTO respuesta = new ResponseDTO();
		Map<String, Object> hmResp = new HashMap();
		PacienteEntity pacienteEntity;
		SignoVitalEntity signoVitalEntity;
		SignosVitalesDTO signosVitales = pacienteDTO.getSignosVitalesDTO();
		if(pacienteDTO.getIdPaciente() != null && pacienteDTO.getIdPaciente() > 0) {
			signoVitalEntity = new SignoVitalEntity();
			signoVitalEntity.setEstatura(signosVitales.getEstatura());
			signoVitalEntity.setImc(signosVitales.getImc());
			signoVitalEntity.setOxigenacion(signosVitales.getOxigenacion());
			signoVitalEntity.setPeso(signosVitales.getPeso());
			signoVitalEntity.setTemperatura(signosVitales.getTemperatura());
			signoVitalEntity.setPresionDiastolica(signosVitales.getPresionDiastolica());
			signoVitalEntity.setPresionSistolica(signosVitales.getPresionSistolica());
			signoVitalRepository.save(signoVitalEntity);
			pacienteEntity = pacienteRepository.findByIdPaciente(pacienteDTO.getIdPaciente());
			pacienteEntity.setSignosVitales(signoVitalEntity);
			pacienteRepository.save(pacienteEntity);
			respuesta.setExito(true);
			hmResp.put("datos","Actualizacion id paciente "+pacienteEntity.getIdPaciente()+" exitosa.");
		}
		return respuesta;
	}

}
