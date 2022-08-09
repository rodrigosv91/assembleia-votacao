package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.repository.SessaoVotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoVotacaoService {
    
    @Autowired
    SessaoVotacaoRepository sessaoVotacaoRepository;
    
    public void salvarSessaoVotacao (SessaoVotacao sessaoVotacao){
        //dto
        sessaoVotacaoRepository.save(sessaoVotacao);
    }
}
