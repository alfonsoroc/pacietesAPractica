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
        name = "tbl_citas"
)
public class Citas {
    @Id
    @SequenceGenerator(
            name = "citas_sequence",
            sequenceName = "citas_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "citas_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int idCitas;
    @Column(
            name = "cita_concepto",
            nullable = false
    )
    private String concepto;
    @Column(
            name = "citas_fecha",
            nullable = false
    )
    private String fechaCita;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private  Pacientes pacientes;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;
}
