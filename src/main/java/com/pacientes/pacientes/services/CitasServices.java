package com.pacientes.pacientes.services;

import com.pacientes.pacientes.entitys.Citas;
import com.pacientes.pacientes.repository.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Citas> consulta() throws Exception {
        try{
            return citasRepository.findBy();
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public String deletecitas(int id){
        String result = "";
        try{
            citasRepository.deleteByidCitas(id);
            result = "Cita Eliminada con exito";
        }catch (Exception ex){
            result = "error al borrar cita" + ex;
        }
        return result;
    }

    public String updateCitas(int id, Citas citas){
        String result = "";
        try{
            Citas resultCitas = citasRepository.findByidCitas(id).orElse(null);
            if(resultCitas != null){
                resultCitas.setConcepto(citas.getConcepto());
                resultCitas.setFechaCita(citas.getFechaCita());
                citasRepository.save(resultCitas);
                result = "La cita se actualizo Correctamente";
            }
        }catch (Exception ex){
            result = "Error al guardar Cita" + ex;
        }
        return result;
    }

}
