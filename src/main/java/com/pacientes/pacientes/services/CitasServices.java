package com.pacientes.pacientes.services;

import com.pacientes.pacientes.entitys.Citas;
import com.pacientes.pacientes.repository.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitasServices {
    @Autowired
    CitasRepository citasRepository;
    public String guardarCitas(Citas citas){
        String result = "";
        try{
            citasRepository.save(citas);
            result = "Se registro Cita correctamenta";

        }catch (Exception ex){
            result = "Error al registrar cita" + ex;
        }
        return result;
    }

    public Optional<Citas> consultarCita(int id) throws Exception {
        try {
            return citasRepository.findByidCitas(id);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
