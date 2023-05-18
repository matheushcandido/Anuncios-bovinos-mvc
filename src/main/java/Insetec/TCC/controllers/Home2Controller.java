package Insetec.TCC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home2Controller {
    
    @GetMapping("/home2")
    public String index(){
        return "home2/index";
    }
}
