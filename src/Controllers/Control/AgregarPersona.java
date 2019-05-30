package Controllers.Control;

import DTOs.PersonaDTO;
import Servicios.Operaciones;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgregarPersona {
    
    private Operaciones operaciones=new Operaciones();
    
    @GetMapping("/createPersona2")
    public ModelAndView addUser(@RequestParam("data")String persona){
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/createPersona")
    public ModelAndView addUserDTO(PersonaDTO persona){
        operaciones.agregarPersona(persona);
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
}
