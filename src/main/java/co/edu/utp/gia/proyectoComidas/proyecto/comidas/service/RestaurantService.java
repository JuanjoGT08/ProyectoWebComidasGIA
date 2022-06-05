package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO);

    boolean updateRestaurant(RestaurantDTO restaurantDTO);

    boolean deleteRestaurant(Long id);

    RestaurantDTO getRestaurant(Long id);

    List<RestaurantDTO> getByName(String name);
}
