package com.exercicio.assembleia_votacao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class SessaoVotacao implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id; 
    
    @NotNull(message = "O campo id_pauta é obrigatório.")
    @OneToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;
             
    private LocalDateTime dataInicio; 
    
    private LocalDateTime dataFim;
    
}
