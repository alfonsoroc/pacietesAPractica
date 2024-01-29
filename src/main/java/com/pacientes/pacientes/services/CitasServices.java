package com.pacientes.pacientes.services;

import com.pacientes.pacientes.entitys.Citas;
import com.pacientes.pacientes.entitys.Doctor;
import com.pacientes.pacientes.entitys.Pacientes;
import com.pacientes.pacientes.repository.CitasRepository;
import com.pacientes.pacientes.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasServices {
    @Autowired
    CitasRepository citasRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    DoctorServices doctorServices;
    public String guardarCitas(Citas citas,int paciente,int doctor){
        String result = "";
        try{
            Pacientes savePacientes = pacienteRepository.findByidPaciente(paciente).orElse(null);
            Doctor saveDoctor = doctorServices.consultaDoctor(doctor).orElse(null);
            if(savePacientes != null || saveDoctor != null){
            citas.setDoctor(saveDoctor);
            citas.setPacientes(savePacientes);
            citasRepository.save(citas);
            result = "Se registro Cita correctamenta";
            }

        }catch (Exception ex){
            result = "Error al registrar cita" + ex;
        }
        return result;
    }

    public ResponseEntity<String> consultarCita(int id) throws Exception {
        try {
            Citas citas = citasRepository.findByidCitas(id).orElse(null);
            return ResponseEntity.ok(citas.toString());
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
