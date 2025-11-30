package mx.com.espera.pacientes.app;

import mx.com.espera.pacientes.dto.SignosVitalesDTO;
import mx.com.espera.pacientes.exception.BusinessException;

public interface ValidadoresSignosVitalesApp {
	String validarSignosVitales(SignosVitalesDTO signosVitales) throws BusinessException;
}
