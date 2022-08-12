package com.exercicio.assembleia_votacao.service;

import com.exercicio.assembleia_votacao.dto.PautaDTO;
import com.exercicio.assembleia_votacao.model.Pauta;
import com.exercicio.assembleia_votacao.repository.PautaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PautaService {
    
    @Autowired
    PautaRepository pautaRepository;
    
    public Pauta salvarPauta(PautaDTO pautaDTO){
        Pauta pauta = pautaDTO.converteParaPauta();
        return pautaRepository.save(pauta);
    }
    
    public List<Pauta> buscarPautas(){ 
        return pautaRepository.findAll();
    }
    
    public Optional<Pauta> getPautaById(Long idPauta){
        return pautaRepository.findById(idPauta);
    }
   
}
