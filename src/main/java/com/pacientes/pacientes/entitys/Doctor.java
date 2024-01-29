package com.pacientes.pacientes.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_doctor"
)
public class Doctor {
    @Id
    @SequenceGenerator(
            name = "doctor_squence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "doctor_squence",
            strategy = GenerationType.SEQUENCE
    )
    private int idDoctor;
    @Column(
            name = "nombre_doctor",
            nullable = false
    )
    private String nombreDoctor;
    @Column(
            name = "apellido_paciente",
            nullable = false
    )
    private String apellidoDoctor;
    @Column(
            name = "especialidad_doctor",
            nullable = false
    )
    private String especialidad;

}
