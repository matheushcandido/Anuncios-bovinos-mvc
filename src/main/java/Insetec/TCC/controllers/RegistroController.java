package Insetec.TCC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import Insetec.TCC.models.Usuario;
import Insetec.TCC.repositorio.LoginRepo;


@Controller
public class RegistroController {
    
    @Autowired
    private LoginRepo usuRepo;

    @GetMapping("/registro")
    public String novoReg(){
        return "registro/index";
    }

    @PostMapping("/registro/registrar")
    public String registrar(Usuario usuario){
        usuRepo.save(usuario);
        return "redirect:/login";
    }
}

