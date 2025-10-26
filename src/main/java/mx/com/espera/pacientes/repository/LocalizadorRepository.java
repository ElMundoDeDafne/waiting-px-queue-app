package mx.com.espera.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.espera.pacientes.entity.LocalizadorEntity;

public interface LocalizadorRepository extends JpaRepository<LocalizadorEntity,Long>{

}
