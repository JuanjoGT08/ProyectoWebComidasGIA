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
public class FoodDTO implements Serializable {

    private Long id;
    private String type;
    private String restaurant;
    private String price;

}
