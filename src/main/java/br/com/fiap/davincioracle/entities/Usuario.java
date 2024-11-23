package br.com.fiap.davincioracle.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "T_DAVINCI_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    private Long idUsuario;

    @Column(name = "edr_email", nullable = false)
    private String email;

    @Column(name = "dt_criacao", nullable = false)
    private Date dataCriacao;

}