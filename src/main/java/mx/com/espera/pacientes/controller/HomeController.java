package mx.com.espera.pacientes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cola/v1.0")
//@CrossOrigin(origins = "*")
public class HomeController {
	
	@Value("${spring.application.name}") String nameMs;
	
	@GetMapping("/home")
	ResponseEntity<Map<String,Object>> home(){
		Map<String,Object> data = new HashMap();
		data.put("datos",nameMs);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
