package mx.com.espera.pacientes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.espera.pacientes.app.RegistroPersonaApp;
import mx.com.espera.pacientes.dto.PacienteDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;

@RestController
@RequestMapping("/api/cola/v1.0")
@CrossOrigin(origins = "*")
public class RegistroPacienteController {
	
	@Autowired RegistroPersonaApp registro;
	
	@PostMapping("/registro/paciente")
	public ResponseEntity<Map<String,Object>> registroPaciente(@RequestBody PacienteDTO dto) throws Exception {
		ResponseDTO respuesta = new ResponseDTO();
		Map<String, Object> data = new HashMap();
		registro.registroPersona(dto);
		data.put("datos", data);
		respuesta.setExito(true);
		
		return null;
	}
}
