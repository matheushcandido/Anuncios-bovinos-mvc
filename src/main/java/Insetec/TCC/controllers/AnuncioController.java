package Insetec.TCC.controllers;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Insetec.TCC.models.Anuncio;
import Insetec.TCC.repositorio.AnunciosRepo;
//import Insetec.TCC.storage.Disco;

@Controller
public class AnuncioController {


    //@Autowired
    //private Disco disco;

    @Autowired
    private AnunciosRepo repo;

    
    @GetMapping("/anuncio")
    public String index(Model model){

        List<Anuncio> anuncios = (List<Anuncio>)repo.findAll();

        model.addAttribute("anuncios", anuncios);

        return "anuncio/index";
    }

    @PostMapping("/anuncio/criar")
    public String criar(Anuncio anuncio){

      repo.save(anuncio);
  
      return "redirect:/";
  }

    @GetMapping("/anuncio/{id}")
    public String busca(@PathVariable int id, Model model){
      Optional<Anuncio> anun = repo.findById(id);
      try{
        model.addAttribute("anuncio", anun.get());
      }
      catch(Exception err){ return "redirect:/"; }
  
      return "/anuncio/editar";
    }
  
    @PostMapping("/anuncio/{id}/atualizar")
    public String atualizar(@PathVariable int id, Anuncio anuncio){
      // if(!repo.exist(id)){
      if(!repo.existsById(id)){
        return "redirect:/";
      }
  
      repo.save(anuncio);
  
      return "redirect:/";
    }

    @GetMapping("/anuncio/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/";
    }

}
