package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.model.Pauta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {
    
    private String descricao;
    
    public Pauta converteParaPauta() {
        return new Pauta(
                null,  
                this.descricao);
    }
    
    
}
