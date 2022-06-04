package co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.FoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<FoodEntity, Long> {
    List<FoodEntity> findByName(String name);
}
