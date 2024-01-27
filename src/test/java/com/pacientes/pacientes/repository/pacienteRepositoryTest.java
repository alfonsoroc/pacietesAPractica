package com.pacientes.pacientes.repository;

import com.pacientes.pacientes.entitys.Pacientes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class pacienteRepositoryTest {
        @Autowired
        PacienteRepository repository;
        @Test
        public void savePaciente() throws ParseException {
            String fechaEspecifica = "1990-01-01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date nacimiento = sdf.parse(fechaEspecifica);

            Pacientes pacientes = Pacientes.builder()
                    .nombre("Alfonso")
                    .apellido("Rocha")
                    .fechaNacimiento(nacimiento)
                    .edad(25)
                    .peso(78.00f)
                    .altura(175f)
                    .telefono("6672520218")
                    .email("alfonsoroc@gmail.com")
                    .build();
            repository.save(pacientes);
        }



}