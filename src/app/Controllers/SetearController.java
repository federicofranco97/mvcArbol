package app.Controllers;

import app.Servicios.Operaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SetearController {
    @Autowired
    Operaciones operaciones;
    
    
    @GetMapping("/setRelaciones")
    public ModelAndView traerSet(){
        ModelAndView vista = new ModelAndView("setear");
        vista.addObject("listaPersonas", operaciones.getLista());
        return vista;
    }
    
}
