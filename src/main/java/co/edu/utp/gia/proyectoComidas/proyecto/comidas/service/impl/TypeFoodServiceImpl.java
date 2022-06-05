package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.TypeFoodEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.TypeFoodRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.TypeFoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.TypeFoodDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TypeFoodServiceImpl implements TypeFoodService {
    @Autowired
    private TypeFoodRepository typeFoodRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public TypeFoodServiceImpl(){}
    public TypeFoodServiceImpl(TypeFoodRepository typeFoodRepository, ModelMapper modelMapper){
        this.typeFoodRepository = typeFoodRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public TypeFoodDTO saveType(TypeFoodDTO typeDTO) {
        TypeFoodEntity typeFoodEntity = modelMapper.map(typeDTO, TypeFoodEntity.class);
        TypeFoodEntity typeFoodEntity1 = typeFoodRepository.save(typeFoodEntity);
        return modelMapper.map(typeFoodEntity1, TypeFoodDTO.class);
    }
    @Override
    public boolean updateTypeFood(TypeFoodDTO typeFoodDTO){
        if(typeFoodRepository.existsById(typeFoodDTO.getId())){
            TypeFoodEntity typeFoodEntity = typeFoodRepository.save(modelMapper.map(typeFoodDTO, TypeFoodEntity.class));
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteTypeFood(Long id){
        if (typeFoodRepository.existsById(id)){
            typeFoodRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public TypeFoodDTO getTypeFood(Long id){
        if (typeFoodRepository.existsById(id)){
            TypeFoodEntity typeFoodEntity = typeFoodRepository.findById(id).get();
            return modelMapper.map(typeFoodRepository.findById(id).get(), TypeFoodDTO.class);
        } else {
            throw new UserNotFoundException("Usuario no encontrado en la BD");
        }
    }
    @Override
    public List<TypeFoodDTO> getByName(String name){
        if (!Objects.equals(name, "") && name !=null){
            List<TypeFoodEntity> typeFoodEntities = typeFoodRepository.findByName(name);
            List<TypeFoodDTO> typeFoodDTOS = new ArrayList<>();
            typeFoodEntities.forEach(typeFoodEntity -> {
                typeFoodDTOS.add(modelMapper.map(typeFoodEntity, TypeFoodDTO.class));
            });
            return typeFoodDTOS;
        }else {throw new UserNotFoundException("nombre no puede ser vacio");
        }
    }
}
