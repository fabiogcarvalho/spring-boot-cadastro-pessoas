package com.carval.cadastroPessoas.repository;

import com.carval.cadastroPessoas.model.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IContatoRepository extends JpaRepository<Contato, Long> {

    @Modifying
    @Transactional
    @Query("update Contato set telefone = :telefone, email = :email where id = :id")
    void AtualizarContato(
            @Param("id") Long id,
            @Param("telefone") String telefone,
            @Param("email") String email
    );

    @Query(value = "select c.id, p.nome, c.telefone, c.email from Contato c " +
                    "join Pessoa p " +
                    "where (lower(p.nome) like %:pesquisa%) or (p.cpf like %:pesquisa%) or (c.telefone like %:pesquisa%) or (lower(c.email) like %:pesquisa%)")
    Page<Contato> BuscarContatosPorFiltro(@Param("pesquisa") String pesquisa, Pageable pageable);

    @Query(value = "select id, telefone, email from contatos where pessoa_id = :pessoaId", nativeQuery = true)
    List<Contato> BuscarContatosPorPessoa(@Param("pessoaId") Long pessoaId);
}
