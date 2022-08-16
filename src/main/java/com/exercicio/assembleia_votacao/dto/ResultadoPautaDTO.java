package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.model.enums.StatusPautaEnum;
import com.exercicio.assembleia_votacao.model.enums.StatusSessaoVotacaoEnum;
import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import com.exercicio.assembleia_votacao.model.Voto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoPautaDTO {
    
    private List<VotoResponseDTO> listaVotos;
    
    private StatusSessaoVotacaoEnum statusSessao; 
    
    private StatusPautaEnum statusPauta; 
    
    public void SetListaVotosFromVotos(List<Voto> votos){
        this.setListaVotos(converteParaVotoResponseDTO(votos));
    }
   
    public List<VotoResponseDTO> converteParaVotoResponseDTO(List<Voto> votos){
        List<VotoResponseDTO> novaListaVotos = new ArrayList<>();
        votos.forEach(voto ->{     
                novaListaVotos.add(new VotoResponseDTO(voto.getIdAssociado(), voto.getVoto()));
            }
        );       
        return novaListaVotos;
    }
    
    public void calculaStatusSessaoVotacao(SessaoVotacao sessaoVotacao){
        LocalDateTime dataAtual = LocalDateTime.now();
        if(dataAtual.isAfter(sessaoVotacao.getDataFim()) || dataAtual.isBefore(sessaoVotacao.getDataInicio()))
            setStatusSessao(StatusSessaoVotacaoEnum.FECHADA);
        else
            setStatusSessao(StatusSessaoVotacaoEnum.ABERTA);      
    }
    
    public void CalculaStatusPauta(){            
        int resultado = 0;      
        for(VotoResponseDTO v : listaVotos)
            resultado += v.getVoto().equals(VotoEnum.SIM) ? +1 : -1;
        
        if(listaVotos.isEmpty())
            setStatusPauta(StatusPautaEnum.NAO_VOTADA);
        else if(resultado == 0)
            setStatusPauta(StatusPautaEnum.EMPATE);
        else if(resultado > 0)
            setStatusPauta(StatusPautaEnum.APROVADA);
        else 
            setStatusPauta(StatusPautaEnum.REJEITADA);               
    }
}
