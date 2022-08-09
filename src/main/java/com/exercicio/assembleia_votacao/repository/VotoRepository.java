package com.exercicio.assembleia_votacao.repository;

import com.exercicio.assembleia_votacao.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long>{
    
}
