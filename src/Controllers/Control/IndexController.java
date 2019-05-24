package Controllers.Control;

import Servicios.Operaciones;
import Models.Persona;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    private Operaciones operaciones=new Operaciones();
   
    
    @GetMapping("/")
    public ModelAndView getMain(){
        ModelAndView vista = new ModelAndView("index");
        ArrayList<Persona> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/moveTemplate")
    public ModelAndView getTemplate(){
        ModelAndView vista = new ModelAndView("template");
        return vista;
    }
    
    @GetMapping("/asd")
    public ModelAndView getIndex(){
        ModelAndView vista = new ModelAndView("index");
        Persona persona=operaciones.buscarNombre("Esmeralda");
        if(persona!=null){
            vista.addObject("nombrePersona",persona.getNombre());
            if(persona.getPadre()!=null){
               vista.addObject("nombrePadre",persona.getPadre().getNombre());
            }else{
                vista.addObject("nombrePadre","No Registrado");
            }
            if(persona.getMadre()!=null){
               vista.addObject("nombreMadre",persona.getMadre().getNombre());
            }else{
                vista.addObject("nombreMadre","No Registrado");
            }
        }
        return vista;
    }
}
