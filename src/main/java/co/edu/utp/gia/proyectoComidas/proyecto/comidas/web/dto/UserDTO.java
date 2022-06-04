package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

}
