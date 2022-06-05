package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.controller;

import co.edu.utp.gia.proyectoComidas.proyecto.comidas.service.TypeFoodService;
import co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.dto.TypeFoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("typeFood")
public class TypeFoodController {
    @Autowired
    private TypeFoodService typeFoodService;

    @PostMapping("addTypeFood")
    public ResponseEntity<TypeFoodDTO> addTypeFood(@RequestBody TypeFoodDTO typeFoodDTO){
        return new ResponseEntity(typeFoodService.saveType(typeFoodDTO), HttpStatus.CREATED);
    }
}
