

package app.Controllers;

import app.Servicios.Operaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PiramideController {
    
    @Autowired
    Operaciones operaciones;
    
    @GetMapping("/piramide")
    public ModelAndView getPiramide(){
        ModelAndView vista = new ModelAndView("piramide");
        vista.addObject("listaRangos", operaciones.getListaRangos());
        return vista;
    }
    
}
