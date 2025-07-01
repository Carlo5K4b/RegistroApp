package com.Cidenet.registro.infrastructure.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tblTipoIdentificacion")
//@Document(collection ="tblTipoIdentificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TipoIdentificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoIdentificacion;

    @OneToMany(mappedBy = "tipoIdentificacion")
    private Set<RegistroEmpleadoEntity> empleados;

   // @ManyToOne
   // @JoinColumn(name = "id_empleado", nullable = false)
   // private RegistroEmpleadoEntity empleado;
}


