package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.UserService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.RestaurantDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
    return new ResponseEntity((userService).saveUser(userDTO), HttpStatus.CREATED);
    }
    @PutMapping("update")
    public boolean updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
    @DeleteMapping("delete")
    public boolean deleteUser(@RequestParam("id") Long id){return userService.deleteUser(id);}
    @GetMapping("getById")
    public ResponseEntity<UserDTO> getUser(@RequestParam("id") Long id){
        return new ResponseEntity(userService.getUser(id), HttpStatus.FOUND);
    }
    @GetMapping("getByName")
    public List<UserDTO> getByName(@RequestParam("name") String name){
        return userService.getByName(name);
    }
}
