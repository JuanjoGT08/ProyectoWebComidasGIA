package co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.TypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeFoodRepository extends CrudRepository<TypeEntity, Long> {
    List<TypeEntity> findByName(String name);
}
