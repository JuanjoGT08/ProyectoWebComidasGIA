package co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.TypeFoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeFoodRepository extends CrudRepository<TypeFoodEntity, Long> {
    List<TypeFoodEntity> findByName(String name);
}
