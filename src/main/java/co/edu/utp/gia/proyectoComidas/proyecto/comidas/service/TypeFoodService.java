package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.TypeFoodDTO;

import java.util.List;

public interface TypeFoodService {
    TypeFoodDTO saveType(TypeFoodDTO typeDTO);

    boolean updateTypeFood(TypeFoodDTO typeFoodDTO);

    boolean deleteTypeFood(Long id);

    TypeFoodDTO getTypeFood(Long id);

    List<TypeFoodDTO> getByName(String name);
}
