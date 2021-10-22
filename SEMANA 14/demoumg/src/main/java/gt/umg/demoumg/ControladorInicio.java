/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.umg.demoumg;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Iris Damian
 */
@Controller
@Slf4j
public class ControladorInicio {
    @GetMapping("/")
    public String inicio(Model modelo){
        log.info("Entrando al controlador inicio MVC");
        var msg = "Tabla de Datos";    
        var persona = new Persona();
        persona.setNombre("Paola");
        persona.setEnero("Q 231");
        persona.setFebrero("Q 789");
        persona.setMarzo("Q 111");
        persona.setSuma("Q 1131");
        persona.setPromedio("377");
        
        var persona2 = new Persona();
        persona2.setNombre("Josue");
        persona2.setEnero("Q 245");
        persona2.setFebrero("Q 600");
        persona2.setMarzo("Q 2000");
        persona2.setSuma("Q 2845");
        persona2.setPromedio("948.3");
        
        var persona3 = new Persona();
        persona3.setNombre("Maria");
        persona3.setEnero("Q 345");
        persona3.setFebrero("Q 700");
        persona3.setMarzo("Q 8900");
        persona3.setSuma("Q 9945");
        persona3.setPromedio("3315");
        
        var persona4 = new Persona();
        persona4.setNombre("Karla");
        persona4.setEnero("Q 780");
        persona4.setFebrero("Q 340");
        persona4.setMarzo("Q 5600");
        persona4.setSuma("Q 6720");
        persona4.setPromedio("2240");
        
        var persona5 = new Persona();
        persona5.setNombre("Jose");
        persona5.setEnero("Q 180");
        persona5.setFebrero("Q 256");
        persona5.setMarzo("Q 700");
        persona5.setSuma("Q 1136");
        persona5.setPromedio("378.7");
        
        var persona6 = new Persona();
        persona6.setNombre("Fabian");
        persona6.setEnero("Q 1000");
        persona6.setFebrero("Q 370");
        persona6.setMarzo("Q 580");
        persona6.setSuma("Q 1950");
        persona6.setPromedio("650");
        
        var personas = Arrays.asList(persona,persona2,persona3,persona4,persona5,persona6);
        modelo.addAttribute("msg",msg);
        modelo.addAttribute("personas", personas);
        return "index";
    }
}
