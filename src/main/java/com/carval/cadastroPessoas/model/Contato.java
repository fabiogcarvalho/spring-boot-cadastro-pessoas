package com.carval.cadastroPessoas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefone", nullable = false,  length = 13)
    private String telefone;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;
}
