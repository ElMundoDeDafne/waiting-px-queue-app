package mx.com.espera.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.espera.pacientes.entity.PacienteEntity;

public interface PacienteRepository extends JpaRepository<PacienteEntity,Long>{

}
