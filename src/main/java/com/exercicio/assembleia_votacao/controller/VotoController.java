package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.dto.VotoDTO;
import com.exercicio.assembleia_votacao.model.Voto;
import com.exercicio.assembleia_votacao.service.VotoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/voto")
public class VotoController {
    
    @Autowired
    VotoService votoService;
    
    @PostMapping
    public ResponseEntity<Voto> salvarVoto(@Valid @RequestBody VotoDTO votoDTO){
        return new ResponseEntity<>(votoService.salvarVoto(votoDTO), HttpStatus.CREATED); 
    }   
}
