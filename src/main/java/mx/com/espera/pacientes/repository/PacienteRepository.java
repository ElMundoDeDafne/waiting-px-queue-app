package mx.com.espera.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.espera.pacientes.entity.PacienteEntity;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long>{
	PacienteEntity findByIdPaciente(Long idPaciente);
}
