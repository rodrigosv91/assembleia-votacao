package com.exercicio.assembleia_votacao.dto;

import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
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
