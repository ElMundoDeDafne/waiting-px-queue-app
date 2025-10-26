package mx.com.espera.pacientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.espera.pacientes.entity.PersonaEntity;
@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long>{
	
	List<PersonaEntity> findByApPaterno(String apPaterno);
	
}
