package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.dto.SessaoVotacaoDTO;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.service.SessaoVotacaoService;
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
@RequestMapping("/sessaoVotacao")
public class SessaoVotacaoController {
    
    @Autowired
    SessaoVotacaoService sessaoVotacaoService;
    
    @PostMapping
    public ResponseEntity<SessaoVotacao> salvarSessaoVotacao (@Valid @RequestBody SessaoVotacaoDTO sessaoVotacaoDTO){
        //verificar se existe pauta com tal id
        //verificar se foi informado o tempo de abertura sessao
        return new ResponseEntity<>(sessaoVotacaoService.salvarSessaoVotacao(sessaoVotacaoDTO), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<SessaoVotacao>> buscarTodasSessoes(){ 
         List<SessaoVotacao> list = sessaoVotacaoService.buscarSessoes(); 
         return list.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(list, HttpStatus.OK);
    }
           
    @GetMapping("/abertas")
    public ResponseEntity<List<SessaoVotacao>> buscarSessoesAbertas(){
        List<SessaoVotacao> list = sessaoVotacaoService.buscarSessoesAbertas(); 
        //List<SessaoVotacao> list = sessaoVotacaoService.buscarSessoes(); 
        return list.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(list, HttpStatus.OK);     
    }
    
    //retornar sessao ao inves de void
    //metodo get sessoes
    
    
}
