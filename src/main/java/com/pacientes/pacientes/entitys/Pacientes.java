package com.pacientes.pacientes.entitys;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_pacientes",
        uniqueConstraints = @UniqueConstraint(
                name = "paciente_unique",
                columnNames = "email_paciente"
        )
)
public class Pacientes {
    @Id
    @SequenceGenerator(
            name = "customer_pacientes",
            sequenceName = "customer_pacientes",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "customer_pacientes",
            strategy = GenerationType.SEQUENCE
    )
    private int idPaciente;
    @Column(
            name = "nombre_paciente",
            nullable = false
    )
    private String nombre;
    @Column(
            name = "apellido_paciente",
            nullable = false
    )
    private String apellido;
    @Column(
            name = "nacimiento_paciente",
            nullable = false
    )
    private Date fechaNacimiento;
    @Column (
            name = "edad_paciente",
            nullable = false
    )
    private int edad;
    @Column(
            name = "peso_paciente",
            nullable = false
    )
    private Float peso;

    @Column(
            name = "altura_paciente",
            nullable = false
    )
    private Float altura;
    @Column(
            name = "telefono_paciente",
            nullable = false
    )
    private String telefono;
    @Column(
            name = "email_paciente",
            nullable = false
    )
    private String email;

}
