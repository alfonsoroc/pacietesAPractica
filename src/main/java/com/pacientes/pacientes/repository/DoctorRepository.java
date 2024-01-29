package com.pacientes.pacientes.repository;

import com.pacientes.pacientes.entitys.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findByidDoctor(int idDoctor);
}
