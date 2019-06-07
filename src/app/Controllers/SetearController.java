package app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SetearController {
    
    @GetMapping("/setRelaciones")
    public ModelAndView traerSet(){
        ModelAndView vista = new ModelAndView("setear");
        return vista;
    }
    
}
