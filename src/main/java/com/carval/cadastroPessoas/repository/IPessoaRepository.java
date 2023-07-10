package com.carval.cadastroPessoas.repository;

import com.carval.cadastroPessoas.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {
    @Modifying
    @Transactional
    @Query(value = "update Pessoa set nome = :nome, cpf = :cpf, dtNascimento = :dtNascimento where id = :id")
    void AtualizarPessoa(
            @Param("id") Long id,
            @Param("nome") String nome,
            @Param("cpf") String cpf,
            @Param("dtNascimento") String dtNascimento
    );

    @Query(value = "select id, nome, cpf, dtNascimento from Pessoa where (lower(nome) like %:pesquisa%) or (cpf like %:pesquisa%) or (dtNascimento like %:pesquisa%)")
    Page<Pessoa> BuscarPessoasPorFiltro(@Param("pesquisa") String pesquisa, Pageable pageable);
}
