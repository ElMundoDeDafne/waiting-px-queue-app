package mx.com.espera.pacientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.espera.pacientes.dto.PacienteDTO;
import mx.com.espera.pacientes.entity.PacienteEntity;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long>{
	@Query(value = "select p from PacienteEntity p where p.idPaciente = :idPaciente")
	PacienteEntity findByIdPaciente(@Param("idPaciente") Long idPaciente);
	@Query(value = "select p from PacienteEntity p")
	List<PacienteEntity> findAllPacientes();
	PacienteEntity actualizarPaciente(PacienteDTO pacienteDTO);
	@Query(value = "SELECT * FROM PacienteEntity WHERE pacienteEntity.medicos.idMedico = :idMedico ")
	List<PacienteEntity> findAllPacientesByIdMedico(@Param("idMedico") Long idMedico);
}
