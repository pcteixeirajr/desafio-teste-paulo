package com.paulojr.desafiojava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComandoAdicionarVotoDTO {
    private Long sessaoVotacao;
    private String associado;
    private boolean ehVotoAprovativo;

    private Long pautaId;
    private String cpf;
    private boolean voto;
}
