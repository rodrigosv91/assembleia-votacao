package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.service.PautaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pauta")
public class PautaController {
    
    @Autowired
    PautaService pautaService;
    
    @PostMapping
    public void salvarPauta(@Valid @RequestBody Pauta pauta){
        
        pautaService.salvarPauta(pauta);
    }
    
    
}
