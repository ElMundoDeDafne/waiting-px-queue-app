package mx.com.espera.pacientes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOCALIZADOR")
public class LocalizadorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LOCALIZADOR")
	private Long idLocalizador;
	@Column(name = "CODIGO")
	private String codigo;
	@Column(name = "CONTENIDO")
	private String contenido;
	
	@ManyToOne
    @JoinColumn(name = "idPersona") // FK en la tabla empleado
	private PersonaEntity persona; //un localizador tiene una persona
	
	private LocalDateTime fechaRegistro;
	private String usuarioRegistra;
	
	public Long getIdLocalizador() {
		return idLocalizador;
	}
	public void setIdLocalizador(Long idLocalizador) {
		this.idLocalizador = idLocalizador;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public PersonaEntity getPersona() {
		return persona;
	}
	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}
	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}
	
	
}
