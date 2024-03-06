package com.buenaspracticas.apirest.models.dto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class UserDto implements Serializable {

    private Integer id ;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;
    private boolean Active;
    private Date registrationDate;
}
