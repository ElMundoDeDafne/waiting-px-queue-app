package mx.com.espera.pacientes.entity;

public class SignoVitalEntity {
	private Long idSignosVitales;
	private Double peso;
	private Double temperatura;
	private Double estatura;
	private Double imc;
	private Double oxigenacion;
	private Double presionSistolica;
	private Double presionDiastolica;
	
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
	
	
}
