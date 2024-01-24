package br.com.bonatto.steticar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
    

    @GetMapping
    public ResponseEntity abreHome()
    {
        return ResponseEntity.ok().build();
    }
}
