package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.RestaurantEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.RestaurantRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.RestaurantService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.RestaurantDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
