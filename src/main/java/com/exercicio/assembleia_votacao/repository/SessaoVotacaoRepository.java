package com.exercicio.assembleia_votacao.repository;

import com.exercicio.assembleia_votacao.model.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {
    
}
