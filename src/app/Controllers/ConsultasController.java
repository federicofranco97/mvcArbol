package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Servicios.Operaciones;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultasController {
    
    @Autowired
    Operaciones operaciones;
    
    @GetMapping("/consultas")
    public ModelAndView traerConsultas(){
        ModelAndView vista = new ModelAndView("consultas");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
}
