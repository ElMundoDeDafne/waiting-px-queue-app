package mx.com.espera.pacientes.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "PERSONA")
public class PersonaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private Long idPersona;
	private String primerNombre;
	private String segundoNombre;
	private String apPaterno;
	private String apMaterno;
	private LocalDate fechaNacimiento;
	private String sexo;
	private String genero;
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private PacienteEntity paciente;
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private MedicoEntity medico;
	@OneToMany(mappedBy = "persona")
	private List<LocalizadorEntity> localizadores; //una persona tiene mas de una forma de localizar
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public PacienteEntity getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}
	public MedicoEntity getMedico() {
		return medico;
	}
	public void setMedico(MedicoEntity medico) {
		this.medico = medico;
	}
	public List<LocalizadorEntity> getLocalizadores() {
		return localizadores;
	}
	public void setLocalizadores(List<LocalizadorEntity> localizadores) {
		this.localizadores = localizadores;
	}
	
	
	
	
}
