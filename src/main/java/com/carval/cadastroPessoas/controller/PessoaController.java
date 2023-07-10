package com.carval.cadastroPessoas.controller;

import com.carval.cadastroPessoas.model.Pessoa;
import com.carval.cadastroPessoas.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> SalvarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaService.SalvarPessoa(pessoa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> AtualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoaService.AtualizarPessoa(id, pessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> ExcluirPessoa(@PathVariable Long id) {
        pessoaService.ExcluirPessoa(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> BuscarPessoas() {
        return new ResponseEntity<>(pessoaService.BuscarPessoas(), HttpStatus.OK);
    }

    @GetMapping("/pesquisa")
    public Page<Pessoa> BuscarPessoasPorFiltro(
            @RequestParam("pesquisa") String pesquisa,
            @RequestParam(value = "pagina", required = false, defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", required = false, defaultValue = "50") int tamanho)
    {
        return pessoaService.BuscarPessoasPorFiltro(pesquisa, pagina, tamanho);
    }
}
