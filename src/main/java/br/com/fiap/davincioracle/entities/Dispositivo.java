package br.com.fiap.davincioracle.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_DAVINCI_DISPOSITIVOS")
@Data
@NoArgsConstructor
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISPOSITIVO")
    @SequenceGenerator(name = "SEQ_DISPOSITIVO", sequenceName = "SEQ_DISPOSITIVO", allocationSize = 1)
    private Long idDispositivo;

    @Column(name = "nm_dispositivo", nullable = false, length = 100)
    private String nome;

    @Column(name = "tp_dispositivo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "tmp_uso_diario", nullable = false)
    private Double tempoUsoDiario;

    @OneToOne
    @JoinColumn(name = "id_medidor", nullable = false)
    private Medidor medidor;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
