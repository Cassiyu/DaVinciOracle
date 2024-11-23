package br.com.fiap.davincioracle.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_DAVINCI_ANALISE_DISPOSITIVO")
@Data
@NoArgsConstructor
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ANALISE")
    @SequenceGenerator(name = "SEQ_ANALISE", sequenceName = "SEQ_ANALISE", allocationSize = 1)
    private Long idAnalise;

    @Column(name = "potencia_registrada", nullable = false)
    private Integer potenciaRegistrada;

    @Column(name = "consumo_mensal", nullable = false)
    private Double consumoMensal;

    @Column(name = "classe_eficiencia", nullable = false, length = 1)
    private String classeEficiencia;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", nullable = false)
    private Dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
