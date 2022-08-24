package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.dto.ResultadoPautaDTO;
import com.exercicio.assembleia_votacao.mapper.PautaMapper;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.repository.PautaRepository;
import com.exercicio.assembleia_votacao.repository.SessaoVotacaoRepository;
import com.exercicio.assembleia_votacao.repository.VotoRepository;
import com.exercicio.assembleia_votacao.service.utils.ResultadoPautaDTOUtils;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PautaService {
    
    @Autowired
    PautaRepository pautaRepository;
    
    @Autowired
    SessaoVotacaoRepository sessaoVotacaoRepository;
        
    public Pauta salvarPauta(PautaDTO pautaDTO){
        Pauta pauta = PautaMapper.dtoParaPauta(pautaDTO);
        return pautaRepository.save(pauta);
    }
    
    public List<Pauta> buscarPautas(){ 
        return pautaRepository.findAll();
    }
    
    public Optional<Pauta> getPautaById(Long idPauta){
        return pautaRepository.findById(idPauta);
    }
   
    public ResultadoPautaDTO resultadoPauta(Long idPauta){   
        
        Optional<Pauta> pauta = pautaRepository.findById(idPauta);  
        
        if(pauta.isEmpty())
            throw new IllegalArgumentException("Pauta não existe."); 
        else{
            Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoRepository.findByPautaId(idPauta);
            if(sessaoVotacao.isEmpty())
                throw new IllegalArgumentException("Sessão de votação não existe."); 
            else{ 
                //ResultadoPautaDTO resPauta = new ResultadoPautaDTO();
                //resPauta.SetListaVotosFromVotos(votoRepository.findAllBySessaoVotacaoId(sessaoVotacao.get().getId()));                     
                //resPauta.calculaStatusSessaoVotacao(sessaoVotacao.get());
                //resPauta.CalculaStatusPauta();               
                //return resPauta;
                
                return new ResultadoPautaDTOUtils().getResultadoPautaDTOFromSessaoVotacao(sessaoVotacao.get());
            } 
        }       
    }
    
}
