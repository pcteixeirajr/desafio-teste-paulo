package com.paulojr.desafiojava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComandoAbrirSessaoVotacaoDTO {
    private Long pauta;
    private Long idPauta;
    private Integer tempoDeAberturaEmSegundos;
}
