package mx.com.espera.pacientes.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class PacienteEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1645802151904007108L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PACIENTE")
	private Long idPaciente;
	@Column(name = "FECHA_CONSULTA")
	private LocalDate fechaConsulta;
	@Column(name = "HORA_CONSULTA")
	private LocalTime horaConsulta;
	@Column(name = "FECHA_SIGUIENTE_CONSULTA")
	private LocalDateTime fechaSiguienteConsulta;
	@Column(name = "MOTIVO_CONSULTA")
	private String motivoConsulta;
	@Column(name = "FECHA_REGISTRO")
	private LocalDateTime fechaRegistro;
	@OneToMany(mappedBy = "paciente")
	@Column(name = "SIGNO_VITAL")
	private List<SignoVitalEntity> signosVitales; //una persona tiene mas de una forma de localizar
    @ManyToMany(mappedBy = "pacientes")
    
//    @Column(name = "MEDICO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
	private MedicoEntity medico; //un paciente tiene uno o mas doctores
    @Column(name = "POSICION")
    private Integer posicion;

	@OneToOne
	@MapsId
	@JoinColumn(name="ID_PACIENTE")
	private PersonaEntity persona; //un paciente es una persona

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public LocalDate getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(LocalDate fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public LocalDateTime getFechaSiguienteConsulta() {
		return fechaSiguienteConsulta;
	}

	public void setFechaSiguienteConsulta(LocalDateTime fechaSiguienteConsulta) {
		this.fechaSiguienteConsulta = fechaSiguienteConsulta;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<SignoVitalEntity> getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(List<SignoVitalEntity> signosVitales) {
		this.signosVitales = signosVitales;
	}



	public MedicoEntity getMedico() {
		return medico;
	}

	public void setMedico(MedicoEntity medico) {
		this.medico = medico;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}
	
		
}
