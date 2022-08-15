package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.model.Voto;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/voto")
public class VotoController {
    
    @PostMapping
    public void salvarVoto(@Valid @RequestBody VotoDTO votoDTO){
        return new ResponseEntity<>(votoService.salvarVoto(votoDTO), HttpStatus.CREATED);           
    }
    
    //criar votoDTO (sem id e com resto) (votoEnum pode ser string ou numero (verificar qual melhor))
    //criar voto service (e voto repository)
    
    
}
