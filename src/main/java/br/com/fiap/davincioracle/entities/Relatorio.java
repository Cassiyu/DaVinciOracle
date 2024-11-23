package br.com.fiap.davincioracle.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "T_DAVINCI_RELATORIO")
@Data
@NoArgsConstructor
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RELATORIO")
    @SequenceGenerator(name = "SEQ_RELATORIO", sequenceName = "SEQ_RELATORIO", allocationSize = 1)
    private Long idRelatorio;

    @Column(name = "hora_relatorio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaRelatorio;

    @ManyToOne
    @JoinColumn(name = "id_analise", nullable = false)
    private Analise analise;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
