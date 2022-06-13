
package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String Inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos en la semana 4";
        model.addAttribute("texto", mensaje);
        
        Cliente cliente = new Cliente("Melissa", "Meza", "mmeza20200@ufide.ac.cr", "61773338");
        model.addAttribute("cliente", cliente);
    
        Cliente cliente2 = new Cliente("Lucia", "Meza", "mmeza20200@ufide.ac.cr", "61773338");
        //var clientes = Arrays.asList(cliente, cliente2);
        var clientes = Arrays.asList();*/
        
        var clientes = clienteDao.findAll();
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
}
