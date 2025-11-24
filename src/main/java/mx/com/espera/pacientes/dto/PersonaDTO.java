package mx.com.espera.pacientes.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2576563093924403703L;
	private String primerNombre;
	private String segundoNombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String cedulaProfesional;
	private String cedulaProfesionalEsp;
	private String genero;
	private String sexo;
	private LocalDate fechaNacimiento;
	private List<LocalizadorDTO> localizadores;
	private List<String> mensajes;
	
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
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getCedulaProfesional() {
		return cedulaProfesional;
	}
	public void setCedulaProfesional(String cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}
	public String getCedulaProfesionalEsp() {
		return cedulaProfesionalEsp;
	}
	public void setCedulaProfesionalEsp(String cedulaProfesionalEsp) {
		this.cedulaProfesionalEsp = cedulaProfesionalEsp;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public List<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(String mensaje) {
		if(this.mensajes==null)
			this.mensajes = new ArrayList();
		this.mensajes.add(mensaje);
	}
	public List<LocalizadorDTO> getLocalizadores() {
		return localizadores;
	}
	public void setLocalizadores(List<LocalizadorDTO> localizadores) {
		this.localizadores = localizadores;
	}
	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}
	
}
