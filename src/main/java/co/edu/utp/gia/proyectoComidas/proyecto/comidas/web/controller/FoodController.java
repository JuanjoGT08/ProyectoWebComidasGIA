package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.FoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("addFood")
    public ResponseEntity<FoodDTO> addFood(@RequestBody FoodDTO foodDTO){
        return new ResponseEntity(foodService.saveFood(foodDTO), HttpStatus.CREATED);
    }
}
