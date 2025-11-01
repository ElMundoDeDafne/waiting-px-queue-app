package mx.com.espera.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.espera.pacientes.entity.LocalizadorEntity;
@Repository
public interface LocalizadorRepository extends JpaRepository<LocalizadorEntity,Long>{

}
