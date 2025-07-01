package com.Cidenet.registro.infrastructure.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblDominio")
//@Document(collection ="tblDominio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DominioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dominio;

   // @ManyToOne
   // @JoinColumn(name="id_empleado", nullable=false)
   // private RegistroEmpleadoEntity empleado;

    @OneToMany(mappedBy = "nombredominio")
    private Set<RegistroEmpleadoEntity> empleados;

}
