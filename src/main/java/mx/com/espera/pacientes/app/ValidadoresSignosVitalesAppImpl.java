/**
 * 
 */
package mx.com.espera.pacientes.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.com.espera.pacientes.dto.SignosVitalesDTO;
import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.entity.PersonaEntity;
import mx.com.espera.pacientes.entity.SignoVitalEntity;
import mx.com.espera.pacientes.exception.BusinessException;
import mx.com.espera.pacientes.utils.PacienteConstants;

/**
 * 
 */
@Service
public class ValidadoresSignosVitalesAppImpl implements ValidadoresSignosVitalesApp {

	@PersistenceContext EntityManager em;
	
	/*
	 * 
	 * 2. Peso (kg)

No hay un rango general, pero sí límites razonables para validación:

Rango válido típico: 2 – 400 kg
(para evitar registros erróneos por typos)



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
	 * 
	 * */
	
	@Override
	public String validarSignosVitales(SignosVitalesDTO signosVitales) throws BusinessException{
		StringBuilder sb = new StringBuilder();
		SignoVitalEntity et = new SignoVitalEntity();
		PacienteEntity pe;
		Double imc = imc = signosVitales.getPeso() / (Math.pow(signosVitales.getEstatura(), 2));
		pe = em.find(PacienteEntity.class,signosVitales.getIdPaciente());
		if(pe==null) {
			throw new BusinessException("Paciente no encontrado, validar.");
		}
		sb.append(validarTemperatura(signosVitales.getTemperatura()));
		sb.append(validarPeso(signosVitales.getEstatura(),signosVitales.getPeso()));
		sb.append(validarEstatura(signosVitales.getEstatura()));
		sb.append(validarPresion(signosVitales));
		sb.append(validarOxigenacion(signosVitales));
		//Se registran los datos en tabla y paciente
		if(!sb.toString().isBlank() || !sb.toString().isEmpty()) {
			et.setObservaciones(sb.toString());
		}
		et.setEstatura(signosVitales.getEstatura());
		et.setFechaRegistro(LocalDateTime.now());
		et.setPresionDiastolica(signosVitales.getPresionDiastolica());
		et.setPresionSistolica(signosVitales.getPresionSistolica());
		et.setPeso(signosVitales.getPeso());
		et.setImc(imc);
		et.setOxigenacion(signosVitales.getOxigenacion());
		et.setPaciente(pe);
		em.persist(et);
		
		return "Registro exitoso";
	}
	private String validarOxigenacion(SignosVitalesDTO signosVitales) {
		// TODO: Implementar metodo para la oxigenacion de acuerdo a tipo de pacientes
		return null;
	}
	/**
	 * Metodo para validaciones de presion arterial, se toma en cuenta datos generales de los signos vitales
	 * para cada tipo de paciente.
	 * @param signosVitales
	 * @return
	 */
	private String validarPresion(SignosVitalesDTO signosVitales) {
		boolean esPediatrico;
		boolean esAdolescente;
		boolean esAdulto;
		boolean esAdultoMayor;
		boolean esObeso;
		PersonaEntity persona;
		LocalDate fechaNacimiento;
		Double presionSistolica;
		Double presionDiastolica;
		StringBuilder sb = new StringBuilder();
		int edad;
		//120/80 (sist/diast)
		
		
		persona = em.find(PersonaEntity.class,signosVitales.getIdPaciente());
		fechaNacimiento = persona.getFechaNacimiento();
		edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
		esPediatrico = edad >= 1 && edad <= 12;
		esAdolescente = edad >=13 && edad  <= 17;
		esAdulto = edad >=18 && edad <= 59;
		esAdultoMayor = edad >=60 && edad <= 105;
		
		if(esPediatrico) {
			/**
			 * TODO: implementar validaciones correctas
			 * Comparar PAS y PAD con tablas percentilares:
			 * Normal: < 90 percentil
			 * Elevada: 90–95 percentil o 120/80 (lo que sea menor)
			 * Hipertensión grado 1: 95–95+12 mmHg
			 * Hipertensión grado 2: ≥ 95+12 mmHg
			 * Talla correcta y brazalete proporcional al brazo.
			 * Medir tres veces y promediar.
			 */
		} else if (esAdolescente || esAdulto) {
			presionSistolica = signosVitales.getPresionSistolica();
			presionDiastolica = signosVitales.getPresionDiastolica();
			if((Double.compare(presionSistolica,120) > 0 || Double.compare(presionSistolica,129) < 0) 
					&& Double.compare(presionDiastolica,80) < 0) {
				sb.append(PacienteConstants.MSG_PRESION_ELEVADA);
			} else if((Double.compare(presionSistolica, 130) > 0) || Double.compare(presionSistolica,139) < 0
					&& (Double.compare(presionDiastolica,80) > 0 || Double.compare(presionDiastolica,89)<0)) {
				sb.append(PacienteConstants.MSG_PRESION_GRADO_I);
			} else if(Double.compare(presionSistolica,140)>=1 && Double.compare(presionDiastolica,90)>=0) {
				sb.append(PacienteConstants.MSG_PRESION_GRADO_II);
			} else if(Double.compare(presionSistolica,180)>=0 && Double.compare(presionDiastolica,120)>=0){
				sb.append(PacienteConstants.MSG_PRESION_CRISIS_HIPER);
			}
		} else if(esAdultoMayor) {
			//TODO: incluir validaciones:
			
			/**
			 * Su “barómetro” suele ser más rígido, así que se vigila con lupa.
			 * 
			 * ✅ Validaciones 
			 * Mantener <130/80 en la mayoría de guías. Considerar
			 * variaciones ortostáticas: Caída ≥20 mmHg PAS al ponerse de pie Caída ≥10 mmHg
			 * PAD Riesgo mayor de “HTA en bata blanca”.
			 * 
			 */
		}
		return sb.toString();
	}
	/**
	 * Validar estatura, en cms.
	 * @param estatura
	 * @return
	 */
	private String validarEstatura(Double estatura) {
		StringBuilder sb = new StringBuilder();
		if(Double.compare(estatura, 0)>0) {
			if(Double.compare(estatura,30)>0 && Double.compare(estatura,250)<0){
				return sb.toString();
			} else {
				sb.append("Estatura: Datos fuera de rango.");
			}
		} else {
			
		}
		return sb.toString();
	}

	/**
	 * Índice de Masa Corporal (IMC)
		peso / (estatura * estatura)
		Delgadez: < 18.5
		Normal: 18.5 – 24.9
		Sobrepeso: 25.0 – 29.9
		Obesidad I: 30.0 – 34.9
		Obesidad II: 35.0 – 39.9
		Obesidad III: ≥ 40
	 * */
	private String validarPeso(Double estatura, Double peso) {
		StringBuilder sb = new StringBuilder();
		Double imc;
		//peso / (estatura * estatura)
		if(Double.compare(peso, 0) > 0 && Double.compare(estatura,0) > 0) {
			//aqui validamos el IMC
			imc = peso / (Math.pow(estatura, 2));
			if(Double.compare(imc,25.0) > 0 && Double.compare(imc,29.9) < 0) {
				sb.append("IMC: Sobrepeso");
				return sb.toString();
			} else if(Double.compare(imc,30.0) > 0 && Double.compare(imc,34.9) < 0) {
				sb.append("IMC: Obesidad I");
				return sb.toString();				
			} else if(Double.compare(imc,35.0) > 0 && Double.compare(imc,39.9) < 0) {
				sb.append("IMC: Obesidad II");
				return sb.toString();				
			}  else if(Double.compare(imc,40.0) > 0) {
				sb.append("IMC: Obesidad III");
				return sb.toString();				
			} else {
				return sb.toString();
			}
		} else {
			sb.append("Valores invalidos, revisar peso y estatura.");
			return sb.toString();
		}
	}

	private String validarTemperatura(Double temperatura) throws BusinessException {
		StringBuilder sb = new StringBuilder();
		if(Double.compare(temperatura, 0)>0) {
			if(Double.compare(temperatura, 35)<0) {
				sb.append("Paciente presenta hipotermia.");
				return sb.toString();
			} else if(Double.compare(temperatura, 37.3)>0 && Double.compare(temperatura, 38.0) < 0) {
				sb.append("Paciente presenta febricula.");
				return sb.toString();
			} else if(Double.compare(temperatura, 38)>0) {
				sb.append("Paciente presenta fiebre.");
				return sb.toString();
			} else {
				return sb.toString();
			}			
		} else {
			throw new BusinessException("Rangos invalidos, por favor valide.");
		}
	}
}