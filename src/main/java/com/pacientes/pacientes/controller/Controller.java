package com.pacientes.pacientes.controller;

import com.pacientes.pacientes.entitys.Doctor;
import com.pacientes.pacientes.entitys.Pacientes;
import com.pacientes.pacientes.repository.PacienteRepository;
import com.pacientes.pacientes.services.DoctorServices;
import com.pacientes.pacientes.services.PacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    PacienteServices pacienteServices;

    @Autowired
    DoctorServices doctorServices;

    @GetMapping()
    public String index(){
        return "conectado";
    }
    @GetMapping("/pacientes")
    public List<Pacientes> findByPacientes(){
        return pacienteRepository.findBy();
    }

    @PostMapping("/guardar/paciente")
    public String savePaciente(@RequestBody Pacientes pacientes){
        return pacienteServices.savePaciente(pacientes);
    }

    @PutMapping("actualizar/paciente/{id}")
    public String updatePaciente(@PathVariable int id,@RequestBody Pacientes pacientes){
        return pacienteServices.updatePaciente(id, pacientes);
    }

    @GetMapping("/consulta/doctor/{id}")
    public Optional<Doctor> consultaDoctor(@PathVariable int id) throws Exception {
        return doctorServices.consultaDoctor(id);
    }

    @PostMapping("guardar/doctor")
    public String saveDoctor(@RequestBody Doctor doctor){
        return doctorServices.saveDoctor(doctor);
    }


}
