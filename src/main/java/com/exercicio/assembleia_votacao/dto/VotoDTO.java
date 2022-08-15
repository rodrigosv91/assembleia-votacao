package com.exercicio.assembleia_votacao.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter 
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {
    
    @NotNull(message = "O campo id_associado é obrigatório.")
    private Long idAssociado;
    
    @NotNull(message = "O campo id_sessao_votacao é obrigatório.")
    private Long id_sessao_votacao;
    
    private boolean voto; 
    
}
