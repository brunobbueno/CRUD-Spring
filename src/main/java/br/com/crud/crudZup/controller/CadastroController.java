package br.com.crud.crudZup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroController {
	
	@GetMapping("/")
    public String list(){
        return "products";
    }

}
