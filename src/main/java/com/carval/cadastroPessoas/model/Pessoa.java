package com.carval.cadastroPessoas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "Pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "DtNascimento", nullable = false)
    private String dtNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private List<Contato> contatos;
}
