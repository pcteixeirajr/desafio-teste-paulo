package com.paulojr.desafiojava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sessao_id")
    private SessaoVotacao sessaoVotacao;

    @Column(nullable = false)
    private String associado;

    @Column(nullable = false)
    private boolean ehVotoAprovativo;

    @Column(nullable = false)
    private boolean ehVotosRejeitivo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(id, voto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
