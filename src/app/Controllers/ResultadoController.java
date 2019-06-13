
package app.Controllers;

import app.DTOs.PersonaDTO;
import app.Servicios.Operaciones;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultadoController {
 
    @Autowired
    Operaciones operaciones;
    
    @GetMapping("/resultado")
    public ModelAndView mostrarRes(){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        return vista;        
    }
    
    @GetMapping("/getHijos")
    public ModelAndView mostrarHijos(@RequestParam("id")long id){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        PersonaDTO aux=operaciones.buscarIdDTO(id);
        ArrayList<PersonaDTO> aux2=operaciones.getHijosDTO(aux);
        vista.addObject("listaPersonas", aux2);
        return vista;
    }
}
