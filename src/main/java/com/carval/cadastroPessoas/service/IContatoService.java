package com.carval.cadastroPessoas.service;

import com.carval.cadastroPessoas.model.Contato;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IContatoService {
    Contato SalvarContato(Contato contato);

    void ExcluirContato(Long id);

    List<Contato> BuscarContatos();

    Page<Contato> BuscarContatosPorFiltro(String pesquisa, int pagina, int tamanho);

    void AtualizarContato(Long id, Contato contato);
}
