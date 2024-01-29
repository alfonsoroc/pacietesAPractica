package com.pacientes.pacientes.repository;

import com.pacientes.pacientes.entitys.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes,Integer> {

    List<Pacientes> findBynombre(String nombre);

    List<Pacientes> findBy();

    Optional<Pacientes> deleteAllByidPaciente(Integer idPaciente);

    Optional<Pacientes> findByidPaciente(Integer idPaciente);


}
