package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.impl;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.entities.UserEntity;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.model.repository.UserRepository;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.UserService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.UserDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Override
    public boolean updateUser(UserDTO userDTO){
        if(userRepository.existsById(userDTO.getId())){
            UserEntity userEntity = userRepository.save(modelMapper.map(userDTO, UserEntity.class));
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteUser(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public UserDTO getUser(Long id){
        if (userRepository.existsById(id)){
            UserEntity userEntity = userRepository.findById(id).get();
            return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
        } else {
            throw new UserNotFoundException("Usuario no encontrado en la BD");
        }
    }
    @Override
    public List<UserDTO> getByName(String name){
        if (!Objects.equals(name, "") && name !=null){
            List<UserEntity> userEntities = userRepository.findByName(name);
            List<UserDTO> userDTOS = new ArrayList<>();
            userEntities.forEach(userEntity -> {
                userDTOS.add(modelMapper.map(userEntity, UserDTO.class));
            });
            return userDTOS;
        }else {throw new UserNotFoundException("nombre no puede ser vacio");
        }
    }
}
