package com.pacientes.pacientes.services;

import com.pacientes.pacientes.entitys.Doctor;
import com.pacientes.pacientes.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServices {
    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        String result = "";
        try{
            doctorRepository.save(doctor);
            result = "Se registro Exitosamente";
        }catch (Exception ex){
            result = "Error Registro" + ex;
        }
        return result;
    }

    public Optional<Doctor> consultaDoctor(int id) throws Exception {
        try{
            return doctorRepository.findByidDoctor(id);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public String deleteDoctor(int id) {
        String result = "";
        try{
            Doctor deleteDoctor = doctorRepository.findByidDoctor(id).orElse(null);
            if(deleteDoctor != null){
                doctorRepository.delete(deleteDoctor);
                result = "Eliminado con Exito";
            }
        }catch (Exception ex){
            result = "Error eliminar";
        }
        return result;
    }
}
