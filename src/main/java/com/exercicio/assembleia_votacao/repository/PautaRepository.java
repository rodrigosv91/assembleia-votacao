package com.exercicio.assembleia_votacao.repository;

import com.exercicio.assembleia_votacao.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
    
}
