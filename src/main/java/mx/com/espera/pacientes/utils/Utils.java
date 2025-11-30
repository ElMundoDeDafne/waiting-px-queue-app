package mx.com.espera.pacientes.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase con varias utilerias.
 */
public class Utils {
	private Utils() {}
	
	public static int calcularEdad(LocalDate fechaNacimiento) {
		return Period.between(fechaNacimiento,LocalDate.now()).getYears();
	}
	
}
