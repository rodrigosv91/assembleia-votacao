package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.service.PautaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<Pauta> salvarPauta(@Valid @RequestBody PautaDTO pautaDTO) {
        return new ResponseEntity<>(pautaService.salvarPauta(pautaDTO), HttpStatus.CREATED); 
    }
       
    //adicionar campo enum  "status" em pautas (verificar se ja foram votadas ou nao)
    //ou procurar por pautas que não tenham seu id em (sessaoVotacao)
      
    @GetMapping
    public ResponseEntity<List<Pauta>> listarPautas(){
        List<Pauta> pautas = this.pautaService.buscarPautas();
        return pautas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(pautas, HttpStatus.OK);
    }
    



    
}
