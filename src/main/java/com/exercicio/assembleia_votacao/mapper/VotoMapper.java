package com.exercicio.assembleia_votacao.mapper;

import com.exercicio.assembleia_votacao.dto.VotoDTO;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import com.exercicio.assembleia_votacao.model.Voto;
import com.exercicio.assembleia_votacao.model.enums.VotoEnum;

public class VotoMapper {
    
    public static Voto dtoParaVoto(VotoDTO votoDTO, SessaoVotacao sessaoVotacao){
        
        return Voto.builder()
                .idAssociado(votoDTO.getIdAssociado())
                .sessaoVotacao(sessaoVotacao)
                .voto(votoDTO.isVoto() ? VotoEnum.SIM : VotoEnum.NAO)
                .build();
    }
    
    public static VotoDTO votoParaDTO(Voto voto){
        
        return VotoDTO.builder()
                .idAssociado(voto.getIdAssociado())
                .id_sessao_votacao(voto.getSessaoVotacao().getId())
                .voto(voto.getVoto().equals(VotoEnum.SIM))
                .build();
    }
}
