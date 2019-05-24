package Controllers.Control;

import DTOs.PersonaDTO;
import Models.Persona;
import Servicios.Operaciones;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
    private Operaciones operaciones = new Operaciones();
    
    
    @GetMapping("/focusPersona")
    public ModelAndView getTemplate(@RequestParam("id") String id){
        //id de la persona focus
        ModelAndView vista = new ModelAndView("template");
        PersonaDTO persona = operaciones.buscarIdDTO(Long.parseLong(id));
        if(persona==null){
            vista.addObject("persona",new Persona("John","Doe","x"));
            vista.addObject("padre",new Persona("John","Doe","x"));
            vista.addObject("madre",new Persona("Jane","Doe","x"));
        }
        vista.addObject("persona", persona);
        if(operaciones.getPadreDTO(persona)==null){
            vista.addObject("padre",new Persona("John","Doe","x"));
        }else{
            vista.addObject("padre",operaciones.getPadreDTO(persona));
        }
        if(operaciones.getMadreDTO(persona)==null){
            vista.addObject("madre",new Persona("Jane","Doe","x"));
        }else{
            vista.addObject("madre",operaciones.getMadreDTO(persona));
        }
        return vista; 
    }
    
}
