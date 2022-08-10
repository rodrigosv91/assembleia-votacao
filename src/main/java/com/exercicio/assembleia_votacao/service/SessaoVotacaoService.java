package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.SessaoVotacaoDTO;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.repository.SessaoVotacaoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoVotacaoService {
    
    @Autowired
    SessaoVotacaoRepository sessaoVotacaoRepository;
    
    public void salvarSessaoVotacao (SessaoVotacaoDTO sessaoVotacaoDTO){       
        Optional<SessaoVotacao> verificaSeExiste = sessaoVotacaoRepository.findSessaoVotacaoByPautaId(sessaoVotacaoDTO.getIdPauta());
        if(verificaSeExiste.isPresent())
            throw new IllegalArgumentException("Sessão já existe");     
        else
            sessaoVotacaoRepository.save(sessaoVotacaoDTO.converteParaSessaoVotacao());
    }
}
