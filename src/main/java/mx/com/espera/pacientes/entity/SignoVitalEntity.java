package mx.com.espera.pacientes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SIGNO_VITAL")
public class SignoVitalEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SIGNOS_VITALES")
	private Long idSignosVitales;
	private Double peso;
	private Double temperatura;
	private Double estatura;
	private Double imc;
	private Double oxigenacion;
	private Double presionSistolica;
	private Double presionDiastolica;
	private LocalDateTime fechaRegistro;
	@ManyToOne
    @JoinColumn(name = "ID_PACIENTE") // FK en la tabla empleado
	private PacienteEntity paciente; //un localizador tiene una persona
	public Long getIdSignoVital() {
		return idSignosVitales;
	}
	public void setIdSignoVital(Long idSignoVitales) {
		this.idSignosVitales = idSignoVitales;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public Double getImc() {
		return imc;
	}
	public void setImc(Double imc) {
		this.imc = imc;
	}
	public Double getOxigenacion() {
		return oxigenacion;
	}
	public void setOxigenacion(Double oxigenacion) {
		this.oxigenacion = oxigenacion;
	}
	public Double getPresionSistolica() {
		return presionSistolica;
	}
	public void setPresionSistolica(Double presionSistolica) {
		this.presionSistolica = presionSistolica;
	}
	public Double getPresionDiastolica() {
		return presionDiastolica;
	}
	public void setPresionDiastolica(Double presionDiastolica) {
		this.presionDiastolica = presionDiastolica;
	}
	public Long getIdSignosVitales() {
		return idSignosVitales;
	}
	public void setIdSignosVitales(Long idSignosVitales) {
		this.idSignosVitales = idSignosVitales;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
