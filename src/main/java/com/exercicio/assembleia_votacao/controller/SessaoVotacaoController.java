package com.exercicio.assembleia_votacao.controller;

import com.exercicio.assembleia_votacao.dto.SessaoVotacaoDTO;
import com.exercicio.assembleia_votacao.service.SessaoVotacaoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/sessaoVotacao")
public class SessaoVotacaoController {
    
    @Autowired
    SessaoVotacaoService sessaoVotacaService;
    
    @PostMapping
    public void salvarSessaoVotacao (@Valid @RequestBody SessaoVotacaoDTO sessaoVotacaoDTO){
        //verificar se existe pauta com tal id
        //verificar se foi informado o tempo de abertura sessao
        sessaoVotacaService.salvarSessaoVotacao(sessaoVotacaoDTO.converteParaSessaoVotacao());
    }
    
    
}
