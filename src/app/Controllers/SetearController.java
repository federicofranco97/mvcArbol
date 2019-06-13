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
public class SetearController {
    @Autowired
    Operaciones operaciones;
    
    @GetMapping("/setPadre")
    public ModelAndView setearPadre(@RequestParam("id")String data){
        String [] aux=data.split(" ");
        PersonaDTO buscarIdDTO = operaciones.buscarIdDTO(Long.parseLong(aux[0]));
        operaciones.setearPadre(buscarIdDTO, Long.parseLong(aux[1]));
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/setMadre")
    public ModelAndView setearMadre(@RequestParam("id")String data){
        String [] aux=data.split(" ");
        PersonaDTO buscarIdDTO = operaciones.buscarIdDTO(Long.parseLong(aux[0]));
        operaciones.setearMadre(buscarIdDTO, Long.parseLong(aux[1]));
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/setHijo")
    public ModelAndView setearHijo(@RequestParam("id")String data){
        String [] aux=data.split(" ");
        PersonaDTO buscarIdDTO = operaciones.buscarIdDTO(Long.parseLong(aux[0]));
        operaciones.agregarHijo(buscarIdDTO, Long.parseLong(aux[1]));
        ModelAndView vista = new ModelAndView("index");
        ArrayList<PersonaDTO> lista = operaciones.getLista();
        vista.addObject("listaPersonas", lista);
        return vista;
    }
    
    @GetMapping("/setRelaciones")
    public ModelAndView traerSet(){
        ModelAndView vista = new ModelAndView("setear");
        vista.addObject("listaPersonas", operaciones.getLista());
        vista.addObject("listaSeteo", operaciones.getListaComandos());
        return vista;
    }
    
}
