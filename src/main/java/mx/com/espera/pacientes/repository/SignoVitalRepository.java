package mx.com.espera.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.espera.pacientes.entity.PacienteEntity;
import mx.com.espera.pacientes.entity.SignoVitalEntity;

@Repository
public interface SignoVitalRepository extends JpaRepository<SignoVitalEntity, Long>{
	SignoVitalEntity findSignoVitalEntityByIdPaciente(Long idPaciente);
	PacienteEntity findPacienteEntityByIdSignosVitales(Long idSignosVitales);
}
