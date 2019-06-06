
package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Servicios.Operaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModificarController {
    
    @Autowired
    Operaciones operaciones;
    
    @GetMapping("/modificar")
    public ModelAndView traerVista(@RequestParam("id") long id){
        PersonaDTO personaDTO=operaciones.buscarIdDTO(id);
        ModelAndView vista = new ModelAndView("modificar");
        vista.addObject("persona",personaDTO);
        vista.addObject("listaPaises",operaciones.getPais());
        return vista;
    }
    
}
