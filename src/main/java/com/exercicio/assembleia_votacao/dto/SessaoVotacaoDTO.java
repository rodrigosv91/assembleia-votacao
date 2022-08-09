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
    
    @NotNull(message = "O campo id_pauta é obrigatório.")
    private Long idPauta;
    
    private Integer tempoAberturaSessao;
    
    public SessaoVotacao converteParaSessaoVotacao(){
        Pauta pauta = new Pauta();
        pauta.setId(this.idPauta); 
        return (new SessaoVotacao(null, pauta, null, null));
    }
      
}
