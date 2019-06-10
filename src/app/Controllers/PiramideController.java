

package app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PiramideController {
    
    @GetMapping("/piramide")
    public ModelAndView getPiramide(){
        ModelAndView vista = new ModelAndView("piramide");
        
        return vista;
    }
    
}
