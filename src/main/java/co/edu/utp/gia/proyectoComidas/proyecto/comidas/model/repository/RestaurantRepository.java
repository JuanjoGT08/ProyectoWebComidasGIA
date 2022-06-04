package co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.RestaurantEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findByName(String name);
}
