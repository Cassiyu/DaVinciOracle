package br.com.fiap.davincioracle.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_DAVINCI_MEDIDOR_ENERGIA")
@Data
@NoArgsConstructor
public class Medidor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEDIDOR")
    @SequenceGenerator(name = "SEQ_MEDIDOR", sequenceName = "SEQ_MEDIDOR", allocationSize = 1)
    private Long idMedidor;

    @Column(name = "nm_medidor", nullable = false, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
