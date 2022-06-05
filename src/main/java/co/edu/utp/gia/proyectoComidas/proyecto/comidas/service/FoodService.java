package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.FoodDTO;

import java.util.List;

public interface FoodService {
    FoodDTO saveFood(FoodDTO foodDTO);

    boolean updateFood(FoodDTO foodDTO);

    boolean deleteFood(Long id);

    FoodDTO getFood(Long id);

    List<FoodDTO> getByName(String name);
}
