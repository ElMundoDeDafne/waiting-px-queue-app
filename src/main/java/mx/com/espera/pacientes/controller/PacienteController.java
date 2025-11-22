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

import mx.com.espera.pacientes.app.PacienteApp;
import mx.com.espera.pacientes.app.RegistroPersonaApp;
import mx.com.espera.pacientes.dto.MedicoDTO;
import mx.com.espera.pacientes.dto.PacienteDTO;
import mx.com.espera.pacientes.dto.ResponseDTO;
import mx.com.espera.pacientes.dto.SignosVitalesDTO;

@RestController
@RequestMapping("/api/cola/v1.0")
@CrossOrigin(origins = "*")
public class PacienteController {
	@Autowired RegistroPersonaApp registro;
	@Autowired PacienteApp pacienteApp;
	
	@PostMapping("/paciente/registro")
	public ResponseEntity<Map<String,Object>> paciente(@RequestBody PacienteDTO dto) throws Exception {
		ResponseDTO respuesta = new ResponseDTO();
		Map<String, Object> data = new HashMap();
		respuesta = registro.registroPersona(dto);
		data.put("datos", respuesta.getRespuesta());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	//agregar metodos para:
	//recuperar un historial de visitas
	//hacer el registro de los demás datos faltantes del paciente (signos vitales por ejemplo)
	@PostMapping("/paciente/registro/signos")
	public ResponseEntity<Map<String,Object>> registroSignosVit(@RequestBody SignosVitalesDTO dto) throws Exception {
		String respuesta;
		Map<String, Object> data = new HashMap();
		respuesta = pacienteApp.registrarSignosVitales(dto);
		data.put("datos", respuesta);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}	
	//registro de localizador (datos contacto)
}
