package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Models.Persona;
import app.Servicios.Operaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
    @Autowired
    private Operaciones operaciones;
    
    
    @GetMapping("/focusPersona")
    public ModelAndView getTemplate(@RequestParam("id") String id){
        //id de la persona focus
        ModelAndView vista = new ModelAndView("template");
        PersonaDTO persona = operaciones.buscarIdDTO(Long.parseLong(id));
        if(persona==null){
            vista.addObject("persona",new Persona("No","Data","x"));
            vista.addObject("padre",new Persona("No","Data","x"));
            vista.addObject("madre",new Persona("No","Data","x"));
        }else{
            vista.addObject("persona", persona);
            if(operaciones.getPadreDTO(persona)==null){
                vista.addObject("padre",new Persona("No","Data","x"));
            }else{
                vista.addObject("padre",operaciones.getPadreDTO(persona));
            }
            if(operaciones.getMadreDTO(persona)==null){
                vista.addObject("madre",new Persona("No","Data","x"));
            }else{
                vista.addObject("madre",operaciones.getMadreDTO(persona));
            }
        }
        
        return vista; 
    }
    
}
