package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.dto.ResultadoPautaDTO;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.service.PautaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        
    @GetMapping
    public ResponseEntity<List<Pauta>> listarPautas(){  
        List<Pauta> pautas = this.pautaService.buscarPautas();
        return pautas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(pautas, HttpStatus.OK);
    }
    
    @GetMapping("/resultado/{id}")
    public ResponseEntity<ResultadoPautaDTO> resultadoVotacao(@PathVariable Long id){
        ResultadoPautaDTO pautaResultado = this.pautaService.resultadoPauta(id);
        return new ResponseEntity<>(pautaResultado, HttpStatus.OK); 
    }
    
}
