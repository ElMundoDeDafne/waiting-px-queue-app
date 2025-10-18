package mx.com.espera.pacientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.espera.pacientes.app.ActualizarColaPacienteApp;

@RestController
@RequestMapping("/api/cola/v1.0")
@CrossOrigin(origins = "*")
public class ActualizarColaController {
	
	@Autowired
	private ActualizarColaPacienteApp actualizarColaPxApp;
	
	@PostMapping("/actualizar/get")
	public Object actualizarColaPacientes(@RequestBody Object dto) throws Exception {
		return null;
	}
}
