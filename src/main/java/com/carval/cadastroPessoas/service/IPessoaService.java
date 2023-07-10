package com.carval.cadastroPessoas.service;

import com.carval.cadastroPessoas.model.Pessoa;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IPessoaService {
    Pessoa SalvarPessoa(Pessoa pessoa);

    void ExcluirPessoa(Long id);

    List<Pessoa> BuscarPessoas();

    void AtualizarPessoa(Long pessoaId, Pessoa pessoa);

    Page<Pessoa> BuscarPessoasPorFiltro(String pesquisa, int pagina, int tamanho);
}
