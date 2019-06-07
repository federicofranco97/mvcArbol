package app.Controllers;

import app.Servicios.Operaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultasController {
    
    @Autowired
    Operaciones operaciones;
    
    @GetMapping("/consultas")
    public ModelAndView traerConsultas(){
        ModelAndView vista = new ModelAndView("consultas");
        vista.addObject("listaPersonas", operaciones.getLista());
        vista.addObject("listaConsultas", operaciones.getListaConsultas());
        return vista;
    }
    
    @GetMapping("/resultadoConsulta")
    public ModelAndView mostrarResultado(@RequestParam("data")String data){
        ModelAndView vista = new ModelAndView("resultadoConsulta");
        String [] aux=data.split(" ");
        String consulta=aux[0];
        long id=Long.parseLong(aux[1]);
        System.out.println(consulta+" "+id);
        return vista;
    }

}
