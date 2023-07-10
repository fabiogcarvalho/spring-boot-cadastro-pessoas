package com.carval.cadastroPessoas.service;

import com.carval.cadastroPessoas.model.Pessoa;
import com.carval.cadastroPessoas.repository.IPessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements IPessoaService {

    private IPessoaRepository pessoaRepository;

    public PessoaService(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa SalvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void ExcluirPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<Pessoa> BuscarPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public void AtualizarPessoa(Long pessoaId, Pessoa pessoa) {

        if (!pessoaRepository.findById(pessoaId).isEmpty()){
            pessoaRepository.AtualizarPessoa(pessoaId, pessoa.getNome(), pessoa.getCpf(), pessoa.getDtNascimento());
        }
    }

    @Override
    public Page<Pessoa> BuscarPessoasPorFiltro(String pesquisa, int pagina, int tamanho) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.ASC,"nome");
        return pessoaRepository.BuscarPessoasPorFiltro(pesquisa.toLowerCase(), pageRequest);
    }
}
