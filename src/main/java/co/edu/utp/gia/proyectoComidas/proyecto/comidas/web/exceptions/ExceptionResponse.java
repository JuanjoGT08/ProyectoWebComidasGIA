package co.edu.utp.gia.proyectoComidas.proyecto.comidas.web.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor

public class ExceptionResponse {
    private Date timestamp;
    private String mensaje;
    private String details;
    private String httpCodeMessage;

}