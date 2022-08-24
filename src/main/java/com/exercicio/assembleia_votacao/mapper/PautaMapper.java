package com.exercicio.assembleia_votacao.mapper;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.model.Pauta;

public class PautaMapper {

    public static Pauta dtoParaPauta(PautaDTO pautaDTO){
        return Pauta.builder()
                .descricao(pautaDTO.getDescricao())
                .build();
    }
    
    public static PautaDTO pautaParaDTO(Pauta pauta){ 
        return PautaDTO.builder()
                .descricao(pauta.getDescricao())
                .build();
    }
}
