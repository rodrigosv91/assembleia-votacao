package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.VotoDTO;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.model.Voto;
import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import com.exercicio.assembleia_votacao.repository.SessaoVotacaoRepository;
import com.exercicio.assembleia_votacao.repository.VotoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    
    @Autowired
    VotoRepository votoRepository;
    
    @Autowired
    SessaoVotacaoRepository sessaoVotacaoRepository;
    
    public Voto salvarVoto(VotoDTO votoDTO){
        
        System.out.println("id user: " + votoDTO.getIdAssociado() );
        System.out.println("id sessao: " + votoDTO.getId_sessao_votacao());
        System.out.println("id voto: " + votoDTO.isVoto());
        
        Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoRepository.findById(votoDTO.getId_sessao_votacao());            
        if(sessaoVotacao.isEmpty())
            throw new IllegalArgumentException("Sessão não existe.");          
        else{
            Optional<Voto> votoProcurado = votoRepository.findByidAssociadoEqualsAndSessaoVotacaoIdEquals(votoDTO.getIdAssociado(),votoDTO.getId_sessao_votacao());       
            if(votoProcurado.isPresent())               
                throw new IllegalArgumentException("Voto já registrado na Sessão."); 
            else{
                LocalDateTime dataAtual = LocalDateTime.now(); 
                if(sessaoVotacao.get().getDataFim().isBefore(dataAtual) || sessaoVotacao.get().getDataInicio().isAfter(dataAtual))
                    throw new IllegalArgumentException("Sessão fechada para votos.");
                else{                                                          
                    Voto voto = new Voto(
                            null, 
                            votoDTO.getIdAssociado(),
                            sessaoVotacao.get(),
                            votoDTO.isVoto() ? VotoEnum.SIM : VotoEnum.NAO
                    );                    
                    return votoRepository.save(voto);                    
                }                   
            }       
        }          
    }
    
}
