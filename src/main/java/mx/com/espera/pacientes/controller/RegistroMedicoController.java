package mx.com.espera.pacientes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.espera.pacientes.app.RegistroPersonaApp;
import mx.com.espera.pacientes.dto.MedicoDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;

@RestController
@RequestMapping("/api/cola/v1.0")
@CrossOrigin(origins = "*")
public class RegistroMedicoController {
	@Autowired RegistroPersonaApp registro;
	@PostMapping("/registro/medico")
	public ResponseEntity<Map<String,Object>> registroMedico(@RequestBody MedicoDTO dto) throws Exception {
		ResponseDTO respuesta = new ResponseDTO();
		Map<String, Object> data = new HashMap();
		respuesta = registro.registroPersona(dto);
		data.put("datos", respuesta.getRespuesta());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
