package mx.com.espera.pacientes.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//Error desconocido.
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> error(Exception ex) {
		Map<String,Object> hmResp = new HashMap();
		hmResp.put("error", ex.getMessage());
		return new ResponseEntity<>(hmResp,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
