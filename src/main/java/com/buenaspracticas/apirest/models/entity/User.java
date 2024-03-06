package com.buenaspracticas.apirest.models.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "usuarios")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="telefono")
    private String telefono;
    @Column(name="isactive")
    private boolean Active;
    @Column(name ="registrationdate")
    private Date registrationDate = new Date();

}
