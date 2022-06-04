package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.TypeFoodEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.TypeFoodRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.TypeFoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.TypeFoodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
}
