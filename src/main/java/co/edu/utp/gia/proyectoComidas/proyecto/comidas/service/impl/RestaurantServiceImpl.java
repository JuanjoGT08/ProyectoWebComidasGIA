package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.RestaurantEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.RestaurantRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.RestaurantService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.RestaurantDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public RestaurantServiceImpl(){}
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ModelMapper modelMapper){
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public RestaurantDTO saveRestaurant(RestaurantDTO restaurantDTO) {
        RestaurantEntity restaurantEntity = modelMapper.map(restaurantDTO, RestaurantEntity.class);
        RestaurantEntity restaurantEntity1 = restaurantRepository.save(restaurantEntity);
        return modelMapper.map(restaurantEntity1, RestaurantDTO.class);
    }
    @Override
    public boolean updateRestaurant(RestaurantDTO restaurantDTO){
        if(restaurantRepository.existsById(restaurantDTO.getId())){
            RestaurantEntity restaurantEntity = restaurantRepository.save(modelMapper.map(restaurantDTO,
                    RestaurantEntity.class));
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteRestaurant(Long id){
        if (restaurantRepository.existsById(id)){
            restaurantRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public RestaurantDTO getRestaurant(Long id){
        if (restaurantRepository.existsById(id)){
            RestaurantEntity restaurantEntity = restaurantRepository.findById(id).get();
            return modelMapper.map(restaurantRepository.findById(id).get(), RestaurantDTO.class);
        } else {
            throw new UserNotFoundException("Usuario no encontrado en la BD");
        }
    }
    @Override
    public List<RestaurantDTO> getByName(String name){
        if (!Objects.equals(name, "") && name !=null){
            List<RestaurantEntity> restaurantEntities = restaurantRepository.findByName(name);
            List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
            restaurantEntities.forEach(restaurantEntity -> {
                restaurantDTOS.add(modelMapper.map(restaurantEntity, RestaurantDTO.class));
            });
            return restaurantDTOS;
        }else {throw new UserNotFoundException("nombre no puede ser vacio");
        }
    }
}
