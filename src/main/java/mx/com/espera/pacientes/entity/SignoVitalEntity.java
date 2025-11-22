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
	@Column(precision = 3,scale=2)
	private Double peso;
	@Column(precision = 3,scale=2)
	private Double temperatura;
	@Column(precision = 3,scale=2)
	private Double estatura;
	@Column(precision = 3,scale=2)
	private Double imc;
	@Column(precision = 3,scale=2)
	private Double oxigenacion;
	@Column(precision = 3,scale=2)
	private Double presionSistolica;
	@Column(precision = 3,scale=2)
	private Double presionDiastolica;
	private LocalDateTime fechaRegistro;
	@ManyToOne
    @JoinColumn(name = "ID_PACIENTE") // FK en la tabla empleado
	private PacienteEntity paciente; //un localizador tiene una persona

	public PacienteEntity getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
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
