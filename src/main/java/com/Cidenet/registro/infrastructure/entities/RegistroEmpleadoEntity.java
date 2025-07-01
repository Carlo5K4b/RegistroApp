package com.Cidenet.registro.infrastructure.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblRegistroEmpleados")
//@Document(collection ="tblRegistroEmpleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEmpleadoEntity {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    private String nombre;
    private String otrosNombres;
    private String apellido1;
    private String apellido2;
    //private String pais;
    //private String tipoIdentificacion;

    // @Column(unique = true) // JPA

    @Id
    @Column(nullable = false, unique = true)
    private String numeroIdentificacion;
    // ...
    private String correo;
    private String fechaIngreso;
    private String area;
    private String estado;
    private String fechaHoraR;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private PaisEntity pais;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dominio")
    private DominioEntity nombredominio;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private AreaEntity areaE;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoIdentificacionEntity tipoIdentificacion;

    // @OneToMany(mappedBy="empleado")
    // private Set<PaisEntity> pais;

}






















