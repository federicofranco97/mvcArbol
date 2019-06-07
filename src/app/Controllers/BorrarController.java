
package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Servicios.Operaciones;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BorrarController {
    
    @Autowired
    Operaciones operaciones;
    
    @PostMapping("/")
    public ModelAndView volerIndex(PersonaDTO personaDTO){
        operaciones.borrarPersonaDTO(personaDTO.getId());
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
}
