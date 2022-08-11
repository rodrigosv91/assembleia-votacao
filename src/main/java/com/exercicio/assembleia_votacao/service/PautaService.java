package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.repository.PautaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PautaService {
    
    @Autowired
    PautaRepository pautaRepository;
    
    public Pauta salvarPauta(PautaDTO pautaDTO){
        return pautaRepository.save(pautaDTO.converteParaPauta());
    }
    
    public List<Pauta> listarPautas(){ 
        //dtoPauta
        //pautaRepository.findAll().forEach(p -> System.out.println("p " + p.getDescricao()));
        return pautaRepository.findAll();
    }
   
}
