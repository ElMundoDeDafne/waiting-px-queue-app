package mx.com.espera.pacientes.app;

import org.springframework.stereotype.Service;

import mx.com.espera.pacientes.dto.LocalizadorDTO;
import mx.com.espera.pacientes.dto.PacienteDTO;

@Service
public class ValidadoresPacienteAppImpl implements ValidadoresPacienteApp {

	@Override
	public Boolean validarDatosPaciente(PacienteDTO pacienteDTO) {
		Boolean esValido = false;
		if(pacienteDTO.getPrimerNombre()!=null) {
			esValido = true;
		}
		return esValido;
	}

	@Override
	public Boolean validarLocalizadores(LocalizadorDTO localizadorDTO) {
		Boolean esValido = false;
		if(localizadorDTO.getCodigoLocalizador()!=null && !localizadorDTO.getCodigoLocalizador().isEmpty()) {
			esValido = true;
		}
		
		if(localizadorDTO.getValorLocalizador()!=null && !localizadorDTO.getValorLocalizador().isEmpty()) {
			esValido = true;
		}
		return esValido;
	}
	
}
