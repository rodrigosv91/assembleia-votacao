package com.exercicio.assembleia_votacao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor
public enum VotoEnum {
    NAO(false),
    SIM(true);   

    boolean key;
}
