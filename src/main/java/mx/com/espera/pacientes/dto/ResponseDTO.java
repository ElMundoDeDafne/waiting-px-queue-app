package mx.com.espera.pacientes.dto;

import java.io.Serializable;
import java.util.Map;

public class ResponseDTO implements Serializable {
	private boolean exito;
	private Map<String, Object> respuesta;
	public boolean isExito() {
		return exito;
	}
	public void setExito(boolean exito) {
		this.exito = exito;
	}
	public Map<String, Object> getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Map<String, Object> respuesta) {
		this.respuesta = respuesta;
	}
	
	
}
