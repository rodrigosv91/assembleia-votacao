package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PautaService {
    
    @Autowired
    PautaRepository pautaRepository;
    
    public Pauta salvarPauta(Pauta pauta){
        //dtoPauta
        return pautaRepository.save(pauta);
    }
   
}
