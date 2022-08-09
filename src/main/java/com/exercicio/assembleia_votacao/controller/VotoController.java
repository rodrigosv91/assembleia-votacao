package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.model.Voto;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/voto")
public class VotoController {
    
    @PostMapping
    public void salvarVoto(@Valid @RequestBody Voto voto){
        
        
        
    }
}
