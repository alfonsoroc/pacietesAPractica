package com.pacientes.pacientes.repository;

import com.pacientes.pacientes.entitys.Pacientes;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteRepositoryTest {
    @Autowired
    PacienteRepository repository;
    @Test
    public void savePaciente() throws ParseException {
        String fechaEspecifica = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nacimiento = sdf.parse(fechaEspecifica);

        Pacientes pacientes = Pacientes.builder()
                .nombre("Abraham")
                .apellido("Rocha")
                .fechaNacimiento(nacimiento)
                .edad(25)
                .peso(78.00f)
                .altura(175f)
                .telefono("6672520218")
                .email("alfonsoroc@g.com")
                .build();
        repository.save(pacientes);
    }
    @Test
    public void findBynombrePaciente() {
        List<Pacientes> pacientes = repository.findBynombre("Alfonso");
        System.out.println("Paciente = " + pacientes);
    }

    @Test
    public void findBy(){
        List<Pacientes> pacientesList = repository.findBy();
        System.out.println("Pacientes = " + pacientesList);
    }

    @Test
    @Transactional
    public void deleteById(){
        Pacientes pacientes = repository.findByidPaciente(10).orElse(null);
        if (pacientes != null){
            repository.delete(pacientes);
        }

    }

}