package com.exercicio.assembleia_votacao.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacaoDTO    {
    
    private final int TEMPO_DEFAULT = 1;
    
    @NotNull(message = "O campo id_pauta é obrigatório.")
    private Long idPauta;  
    
    private Integer tempoAberturaSessao;
    /*
    public SessaoVotacao converteParaSessaoVotacao(){
        return new SessaoVotacao(
                    null, 
                    new Pauta(
                            this.idPauta), 
                    null, 
                    null);
    }
    */
}
