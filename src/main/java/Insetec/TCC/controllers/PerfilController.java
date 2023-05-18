package Insetec.TCC.controllers;


import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Insetec.TCC.Servico.CookieService;
import Insetec.TCC.models.Usuario;
import Insetec.TCC.repositorio.UsuariosRepo;

@Controller
public class PerfilController{

    @Autowired
    private UsuariosRepo repo;


    @GetMapping("/perfil")
    public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException{

        model.addAttribute("id", CookieService.getCookie(request, "usuarioId"));
        model.addAttribute("nome", CookieService.getCookie(request, "usuarioNome"));
        model.addAttribute("email", CookieService.getCookie(request, "usuarioEmail"));
        model.addAttribute("estado", CookieService.getCookie(request, "usuarioEstado"));
        model.addAttribute("cidade", CookieService.getCookie(request, "usuarioCidade"));
        model.addAttribute("telefone", CookieService.getCookie(request, "usuarioTelefone"));

        return "perfil/index";

    }

    @GetMapping("/perfil/{id}")
    public String busca(@PathVariable int id, Model model){
      Optional<Usuario> usu = repo.findById(id);

    try{
      model.addAttribute("usuario", usu.get());
      }

    catch(Exception err){ return "redirect:/perfil"; }
  
      return "perfil/editar";
    }
  
    @PostMapping("/perfil/{id}/atualizar")
    public String atualizar(@PathVariable int id, Usuario usuario){
      // if(!repo.exist(id)){

      
      repo.save(usuario);
  
      return "redirect:/perfil";
    }

}
