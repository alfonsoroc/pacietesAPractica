package com.pacientes.pacientes.repository;

import com.pacientes.pacientes.entitys.Citas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CitasRepository extends JpaRepository<Citas,Integer> {
    Optional<Citas> findByidCitas(int idCitas);

    List<Citas> findBy();
}
