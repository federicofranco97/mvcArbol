
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
    
    @GetMapping("/getPrimos")
    public ModelAndView mostrarPrimos(@RequestParam("id")long id){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        PersonaDTO aux=operaciones.buscarIdDTO(id);
        ArrayList<PersonaDTO> aux2=operaciones.getPrimosDTO(aux);
        vista.addObject("listaPersonas", aux2);
        return vista;
    }
    
    @GetMapping("/getAbuelos")
    public ModelAndView mostrarAbuelos(@RequestParam("id")long id){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        PersonaDTO aux=operaciones.buscarIdDTO(id);
        ArrayList<PersonaDTO> aux2=operaciones.getAbuelosDTO(aux);
        vista.addObject("listaPersonas", aux2);
        return vista;
    }
    
    @GetMapping("/getTios")
    public ModelAndView mostrarTios(@RequestParam("id")long id){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        PersonaDTO aux=operaciones.buscarIdDTO(id);
        ArrayList<PersonaDTO> aux2=operaciones.getTiosDTO(aux);
        vista.addObject("listaPersonas", aux2);
        return vista;
    }
    
    @GetMapping("/getHermanos")
    public ModelAndView mostrarHermanos(@RequestParam("id")long id){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        PersonaDTO aux=operaciones.buscarIdDTO(id);
        ArrayList<PersonaDTO> aux2=operaciones.getHermanosDTO(aux);
        vista.addObject("listaPersonas", aux2);
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
