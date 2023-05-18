package Insetec.TCC.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Insetec.TCC.Servico.CookieService;
import Insetec.TCC.models.Usuario;
import Insetec.TCC.repositorio.LoginRepo;


@Controller
public class LoginController {

    @Autowired
    private LoginRepo repoUsu;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Usuario usuParam, HttpServletResponse response) throws IOException{
        Usuario usu = this.repoUsu.Login(usuParam.getEmail(), usuParam.getSenha());
        if(usu != null){
            CookieService.setCookie(response, "usuarioId", String.valueOf(usu.getId()), 2400);
            CookieService.setCookie(response, "usuarioNome", String.valueOf(usu.getNome()), 2400);
            CookieService.setCookie(response, "usuarioEmail", String.valueOf(usu.getEmail()), 2400);
            CookieService.setCookie(response, "usuarioEstado", String.valueOf(usu.getEstado()), 2400);
            CookieService.setCookie(response, "usuarioCidade", String.valueOf(usu.getCidade()), 2400);
            CookieService.setCookie(response, "usuarioTelefone", String.valueOf(usu.getTelefone()), 2400);

            return "redirect:/";
        }

        model.addAttribute("erro", "Usuario ou senha inválidos");

        return "login/index";
    }
}

