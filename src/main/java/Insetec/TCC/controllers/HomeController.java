package Insetec.TCC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import Insetec.TCC.models.Anuncio;
import Insetec.TCC.repositorio.AnunciosRepo;

@Controller
public class HomeController{

    
    @Autowired
    private AnunciosRepo repo;


    @GetMapping("/")
    public String index(Model model) throws IOException{
    

        List<Anuncio> anuncios = (List<Anuncio>)repo.findAllByOrderByIdDesc();

        model.addAttribute("anuncios", anuncios);

        return "home/index";
    }


}
