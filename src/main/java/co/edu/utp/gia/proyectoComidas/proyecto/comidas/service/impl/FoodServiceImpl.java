package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.FoodEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.FoodRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.FoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.FoodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public FoodServiceImpl(){}
    public FoodServiceImpl(FoodRepository foodRepository, ModelMapper modelMapper){
        this.foodRepository = foodRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public FoodDTO saveFood(FoodDTO foodDTO) {
        FoodEntity foodEntity = modelMapper.map(foodDTO, FoodEntity.class);
        FoodEntity foodEntity1 = foodRepository.save(foodEntity);
        return modelMapper.map(foodEntity1, FoodDTO.class);
    }
}
