package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.RestaurantService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.FoodDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("add")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        return new ResponseEntity(restaurantService.saveRestaurant(restaurantDTO), HttpStatus.CREATED);
    }
    @PutMapping("update")
    public boolean updateRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.updateRestaurant(restaurantDTO);
    }
    @DeleteMapping("delete")
    public boolean deleteRestaurant(@RequestParam("id") Long id){return restaurantService.deleteRestaurant(id);}
    @GetMapping("getById")
    public ResponseEntity<RestaurantDTO> getRestaurant(@RequestParam("id") Long id){
        return new ResponseEntity(restaurantService.getRestaurant(id), HttpStatus.FOUND);
    }
    @GetMapping("getByName")
    public List<RestaurantDTO> getByName(@RequestParam("name") String name){
        return restaurantService.getByName(name);
    }
}
