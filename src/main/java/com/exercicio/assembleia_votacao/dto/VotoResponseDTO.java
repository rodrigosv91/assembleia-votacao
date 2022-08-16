package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class VotoResponseDTO {
    
    private Long idAssociado;
    private VotoEnum voto;
    
}
