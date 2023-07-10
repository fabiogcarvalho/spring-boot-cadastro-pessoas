package com.carval.cadastroPessoas.service;

import com.carval.cadastroPessoas.common.Validador;
import com.carval.cadastroPessoas.model.Contato;
import com.carval.cadastroPessoas.repository.IContatoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService implements IContatoService {

    private IContatoRepository contatoRepository;
    private Contato contato;

    public ContatoService(IContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato SalvarContato(Contato contato) {
        if (Validador.ValidaEmail(contato.getEmail())) {
            return contatoRepository.save(contato);
        } else {
            throw new RuntimeException("Email não é válido!");
        }
    }

    @Override
    public void ExcluirContato(Long id) {
        contatoRepository.deleteById(id);
    }

    @Override
    public List<Contato> BuscarContatos() {
        return contatoRepository.findAll();
    }

    @Override
    public Page<Contato> BuscarContatosPorFiltro(String pesquisa, int pagina, int tamanho) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.ASC,"nome");
        return contatoRepository.BuscarContatosPorFiltro(pesquisa.toLowerCase(), pageRequest);
    }

    @Override
    public void AtualizarContato(Long id, Contato contato) {
        if (!contatoRepository.findById(id).isEmpty()) {
            contatoRepository.AtualizarContato(id, contato.getTelefone(), contato.getEmail());
        }
    }
}
