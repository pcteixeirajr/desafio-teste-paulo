package com.paulojr.desafiojava.dto;

import com.paulojr.desafiojava.enuns.TipoVoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacaoDTO {
    private Long id;
    private PautaDTO pauta;
    private Integer tempoDeAberturaEmSegundos;
    private Date dataHoraAbertura;
    private TipoVoto tipoVoto;
}
