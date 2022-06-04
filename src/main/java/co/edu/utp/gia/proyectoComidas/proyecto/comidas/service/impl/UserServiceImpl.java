package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.UserEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.UserRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.UserService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(){}

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository =userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity userEntity1 =userRepository.save(userEntity);
        return modelMapper.map(userEntity1, UserDTO.class);
    }
}
