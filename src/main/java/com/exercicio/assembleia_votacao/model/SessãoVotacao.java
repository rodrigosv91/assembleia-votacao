package com.exercicio.assembleia_votacao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sessao_votacao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessãoVotacao implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id; 
    
    @NotNull(message = "O campo id_pauta é obrigatório.")
    @OneToOne(mappedBy = "sessaoVotacao")
    private Pauta pauta;
             
    private LocalDateTime data_inicio; 
    
    private LocalDateTime data_fim;
    
}
