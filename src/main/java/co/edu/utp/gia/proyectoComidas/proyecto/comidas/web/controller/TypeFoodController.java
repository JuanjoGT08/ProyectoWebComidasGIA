package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.TypeFoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.TypeFoodDTO;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("typeFood")
public class TypeFoodController {
    @Autowired
    private TypeFoodService typeFoodService;

    @PostMapping("add")
    public ResponseEntity<TypeFoodDTO> addTypeFood(@RequestBody TypeFoodDTO typeFoodDTO){
        return new ResponseEntity(typeFoodService.saveType(typeFoodDTO), HttpStatus.CREATED);
    }
    @PutMapping("update")
    public boolean updateTypeFood(@RequestBody TypeFoodDTO typeFoodDTO){
        return typeFoodService.updateTypeFood(typeFoodDTO);
    }
    @DeleteMapping("delete")
    public boolean deleteTypeFood(@RequestParam("id") Long id){return typeFoodService.deleteTypeFood(id);}
    @GetMapping("getById")
    public ResponseEntity<TypeFoodDTO> getTypeFood(@RequestParam("id") Long id){
        return new ResponseEntity(typeFoodService.getTypeFood(id), HttpStatus.FOUND);
    }
    @GetMapping("getByName")
    public List<TypeFoodDTO> getByName(@RequestParam("name") String name){
        return typeFoodService.getByName(name);
    }
}
