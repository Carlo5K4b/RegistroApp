package com.Cidenet.registro.infrastructure.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblArea")
//@Document(collection ="tblArea")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AreaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String area;

    @OneToMany(mappedBy = "areaE")
    private Set<RegistroEmpleadoEntity> empleados;

   // @ManyToOne
   // @JoinColumn(name="id_empleado", nullable=false)
   // private RegistroEmpleadoEntity empleado; // Cambiado el nombre aquí

}