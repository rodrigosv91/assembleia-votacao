package com.exercicio.assembleia_votacao.repository;

import com.exercicio.assembleia_votacao.model.Voto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long>{
    
    Optional<Voto> findByidAssociadoEqualsAndSessaoVotacaoIdEquals(Long idAssociado, Long SessaoVotacaoId);
    
}
