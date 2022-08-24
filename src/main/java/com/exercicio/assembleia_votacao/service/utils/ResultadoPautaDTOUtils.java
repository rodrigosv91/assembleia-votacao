package com.exercicio.assembleia_votacao.service.utils;

import com.exercicio.assembleia_votacao.dto.ResultadoPautaDTO;
import com.exercicio.assembleia_votacao.dto.VotoResponseDTO;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.model.Voto;
import com.exercicio.assembleia_votacao.model.enums.StatusPautaEnum;
import com.exercicio.assembleia_votacao.model.enums.StatusSessaoVotacaoEnum;
import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import com.exercicio.assembleia_votacao.repository.VotoRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultadoPautaDTOUtils {
    
    @Autowired
    VotoRepository votoRepository;

    public ResultadoPautaDTO getResultadoPautaDTOFromSessaoVotacao(SessaoVotacao sessaoVotacao) {
        ResultadoPautaDTO resPauta = new ResultadoPautaDTO();
        List<VotoResponseDTO> listaVotos = converteParaVotoResponseDTO(votoRepository.findAllBySessaoVotacaoId(sessaoVotacao.getId()));
        resPauta.setListaVotos(listaVotos);                     
        resPauta.setStatusSessao(calculaStatusSessaoVotacao(sessaoVotacao));
        resPauta.setStatusPauta(calculaStatusPauta(listaVotos));       
        return resPauta;       
    }
   
    public List<VotoResponseDTO> converteParaVotoResponseDTO(List<Voto> votos){
        List<VotoResponseDTO> novaListaVotos = new ArrayList<>();
        votos.forEach(voto ->{     
                novaListaVotos.add(new VotoResponseDTO(voto.getIdAssociado(), voto.getVoto()));
            }
        );       
        return novaListaVotos;
    }
    
    public StatusSessaoVotacaoEnum calculaStatusSessaoVotacao(SessaoVotacao sessaoVotacao){
        LocalDateTime dataAtual = LocalDateTime.now();
        if(dataAtual.isAfter(sessaoVotacao.getDataFim()) || dataAtual.isBefore(sessaoVotacao.getDataInicio()))
            return StatusSessaoVotacaoEnum.FECHADA;
        else
            return StatusSessaoVotacaoEnum.ABERTA;      
    }
    
    public StatusPautaEnum calculaStatusPauta(List<VotoResponseDTO> listaVotos){            
        int resultado = 0;      
        for(VotoResponseDTO v : listaVotos)
            resultado += v.getVoto().equals(VotoEnum.SIM) ? +1 : -1;
        
        if(listaVotos.isEmpty())
            return (StatusPautaEnum.NAO_VOTADA);
        else if(resultado == 0)
            return (StatusPautaEnum.EMPATE);
        else if(resultado > 0)
            return (StatusPautaEnum.APROVADA);
        else 
            return (StatusPautaEnum.REJEITADA);               
    }
    
}
