package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Servicios.Operaciones;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    private Operaciones operaciones=new Operaciones();
   
    @GetMapping("/addPersona")
    public ModelAndView addPersona(){
        return new ModelAndView("agregar");
    }
    
    @GetMapping("/")
    public ModelAndView getMain(){
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/verIndex")
    public ModelAndView getMain2(){
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/moveTemplate")
    public ModelAndView getTemplate(){
        ModelAndView vista = new ModelAndView("plantilla");
        return vista;
    }
    
}
