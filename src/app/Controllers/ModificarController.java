
package app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModificarController {
    
    @GetMapping("/modificar")
    public ModelAndView traerVista(){
        ModelAndView vista = new ModelAndView("modificar");
        return vista;
    }
    
}
