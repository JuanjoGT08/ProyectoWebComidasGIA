package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.UserService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
    return new ResponseEntity((userService).saveUser(userDTO), HttpStatus.CREATED);
    }
}
