package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Servicios.Operaciones;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired 
    private Operaciones operaciones;
   
    @GetMapping("/addPersona")
    public ModelAndView addPersona(){
        ModelAndView vista = new ModelAndView("agregar");
        vista.addObject("paisNatal",operaciones.getPaisNatal());
        vista.addObject("paisVive",operaciones.getPaisVive());
        return vista;
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
    
    @GetMapping("/eliminar")
    public ModelAndView borrarPersona(@RequestParam("id")long id){
        ModelAndView vista = new ModelAndView("eliminar");        
        vista.addObject("persona", operaciones.buscarIdDTO(id));
        return vista;
    }
    
    
    
}
