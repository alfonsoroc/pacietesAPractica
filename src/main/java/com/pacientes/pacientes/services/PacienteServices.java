package com.pacientes.pacientes.services;

import com.pacientes.pacientes.entitys.Pacientes;
import com.pacientes.pacientes.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServices {
    @Autowired
    PacienteRepository pacienteRepository;

    public String savePaciente(Pacientes pacientes){
        String result = "";
        try{
            pacienteRepository.save(pacientes);
            result = "Paciente Grabado con exito";
        }catch (Exception ex){
            result = "error en grabado" + ex;
        }
        return result;
    }

    public String updatePaciente(Integer id, Pacientes pacientes){
        String result = "";
        try {
            Pacientes pacienteResult = pacienteRepository.findByidPaciente(id).orElse(null);
            if(pacienteResult != null){
                pacienteResult.setNombre(pacientes.getNombre());
                pacienteResult.setApellido(pacienteResult.getApellido());
                pacienteResult.setFechaNacimiento(pacientes.getFechaNacimiento());
                pacienteResult.setEdad(pacientes.getEdad());
                pacienteResult.setPeso(pacientes.getPeso());
                pacienteResult.setAltura(pacientes.getAltura());
                pacienteResult.setTelefono(pacientes.getTelefono());
                pacienteResult.setEmail(pacienteResult.getEmail());
            }
            assert pacienteResult != null;
            pacienteRepository.save(pacienteResult);
            result = "Actualizado con Exito";
        }catch (Exception ex){
            result = "Error al Actualizar Paciente" + ex;
        }


        return result;

    }

}
