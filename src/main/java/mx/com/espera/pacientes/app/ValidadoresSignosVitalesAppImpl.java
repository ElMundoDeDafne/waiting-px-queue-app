/**
 * 
 */
package mx.com.espera.pacientes.app;

import org.springframework.stereotype.Service;

import mx.com.espera.pacientes.dto.SignosVitalesDTO;

/**
 * 
 */
@Service
public class ValidadoresSignosVitalesAppImpl implements ValidadoresSignosVitalesApp {

	/*
	 * 
	 * 2. Peso (kg)

No hay un rango general, pero sí límites razonables para validación:

Rango válido típico: 2 – 400 kg
(para evitar registros erróneos por typos)

3. Estatura (m)

Rango válido típico: 0.30 – 2.50 m
(ó en cm si lo manejas así: 30 – 250 cm)

4. Índice de Masa Corporal (IMC)
peso / (estatura * estatura)
Delgadez: < 18.5
Normal: 18.5 – 24.9
Sobrepeso: 25.0 – 29.9
Obesidad I: 30.0 – 34.9
Obesidad II: 35.0 – 39.9
Obesidad III: ≥ 40

Para validación general: [10 – 90]

5. Oxigenación (SpO₂ %)
Normal: 95% – 100%
Ligeramente baja: 90% – 94%
Crítica: < 90%
Para validación: [50 – 100]

6. Presión sistólica (mmHg)

Normal: 90 – 120
Elevada: 121 – 129
Hipertensión grado 1: 130 – 139
Hipertensión grado 2: ≥ 140
Hipotensión: < 90
Validación general: [50 – 250]

7. Presión diastólica (mmHg)

Normal: 60 – 80
Elevada: 81 – 89
Hipertensión grado 1: 90 – 99
Hipertensión grado 2: ≥ 100
Hipotensión: < 60
Validación general: [30 – 150]
	 * 
	 * */
	
	@Override
	public String validarSignosVitales(SignosVitalesDTO signosVitales) {
		StringBuilder sb = new StringBuilder();
		sb.append(validarTemperatura(signosVitales.getTemperatura()));
		sb.append(validarPeso(signosVitales.getPeso()));
		return sb.toString();
	}
	
	private Object validarPeso(Double peso) {
		// TODO Auto-generated method stub
		return null;
	}

	private String validarTemperatura(Double temperatura) {
		StringBuilder sb = new StringBuilder();
		if(Double.compare(temperatura, 0)>0) {
			if(Double.compare(temperatura, 35)<0) {
				sb.append("Paciente presenta hipotermia.");
			}
			
			if(Double.compare(temperatura, 37.3)>0 && Double.compare(temperatura, 38.0) < 0) {
				sb.append("Paciente presenta febricula.");
			}
			
			if(Double.compare(temperatura, 38)>0) {
				sb.append("Paciente presenta fiebre.");
			}			
		} else {
			sb.append("Valores invalidos, debe ser mayor a 35.");
		}
		return sb.toString();
	}

}
