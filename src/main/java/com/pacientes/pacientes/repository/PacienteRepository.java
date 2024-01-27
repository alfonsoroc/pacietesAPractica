package com.pacientes.pacientes.repository;

import com.pacientes.pacientes.entitys.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes,Integer> {

    Optional<Pacientes> findBynombrePaciente(String nombrePaciente);
}
