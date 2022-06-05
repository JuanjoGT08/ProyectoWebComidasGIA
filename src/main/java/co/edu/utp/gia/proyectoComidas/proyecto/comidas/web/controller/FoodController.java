package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.FoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("add")
    public ResponseEntity<FoodDTO> addFood(@RequestBody FoodDTO foodDTO){
        return new ResponseEntity(foodService.saveFood(foodDTO), HttpStatus.CREATED);
    }
    @PutMapping("update")
    public boolean updateFood(@RequestBody FoodDTO foodDTO){
        return foodService.updateFood(foodDTO);
    }
    @DeleteMapping("delete")
    public boolean deleteFood(@RequestParam("id") Long id){return foodService.deleteFood(id);}
    @GetMapping("getId")
    public ResponseEntity<FoodDTO> getFood(@RequestParam("id") Long id){
        return new ResponseEntity(foodService.getFood(id), HttpStatus.FOUND);
    }
    @GetMapping("getName")
    public List<FoodDTO> getByName(@RequestParam("name") String name){
        return foodService.getByName(name);
    }
}
