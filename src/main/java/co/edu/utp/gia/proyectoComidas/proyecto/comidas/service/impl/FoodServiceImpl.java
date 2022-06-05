package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.FoodEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.FoodRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.FoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.FoodDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
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
    @Override
    public boolean updateFood(FoodDTO foodDTO){
        if(foodRepository.existsById(foodDTO.getId())){
            FoodEntity foodEntity = foodRepository.save(modelMapper.map(foodDTO,
                    FoodEntity.class));
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteFood(Long id){
        if (foodRepository.existsById(id)){
            foodRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public FoodDTO getFood(Long id){
        if (foodRepository.existsById(id)){
            FoodEntity foodEntity = foodRepository.findById(id).get();
            return modelMapper.map(foodRepository.findById(id).get(), FoodDTO.class);
        } else {
            throw new UserNotFoundException("Usuario no encontrado en la BD");
        }
    }
    @Override
    public List<FoodDTO> getByName(String name){
        if (!Objects.equals(name, "") && name !=null){
            List<FoodEntity> foodEntities = foodRepository.findByName(name);
            List<FoodDTO> foodDTOS = new ArrayList<>();
            foodEntities.forEach(foodEntity -> {
                foodDTOS.add(modelMapper.map(foodEntity, FoodDTO.class));
            });
            return foodDTOS;
        }else {throw new UserNotFoundException("nombre no puede ser vacio");
        }
    }
}
