package co.edu.utp.gia.proyectoComidas.proyecto.comidas.service;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);

    boolean updateUser(UserDTO userDTO);

    boolean deleteUser(Long id);

    UserDTO getUser(Long id);

    List<UserDTO> getByName(String name);
}
