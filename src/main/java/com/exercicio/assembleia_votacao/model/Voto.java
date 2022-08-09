package com.exercicio.assembleia_votacao.model;

import com.exercicio.assembleia_votacao.model.enums.VotoEnum;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="voto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voto implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "O campo id_associado é obrigatório.")
    @NotBlank(message = "O campo id_associado é obrigatório.") 
    private Long idAssociado;
    
    @NotNull(message = "O campo id_pauta é obrigatório.")
    @NotBlank(message = "O campo id_associado é obrigatório.") 
    @ManyToOne
    @JoinColumn(name = "fk_pauta")
    private SessãoVotacao sessaoVotacao;
    
    @NotNull(message = "O campo voto é obrigatório.")
    @NotBlank(message = "O campo voto é obrigatório.") 
    private VotoEnum voto;
    
}
