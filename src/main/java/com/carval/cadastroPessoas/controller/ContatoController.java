package com.carval.cadastroPessoas.controller;

import com.carval.cadastroPessoas.common.Validador;
import com.carval.cadastroPessoas.model.Contato;
import com.carval.cadastroPessoas.service.IContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contato")
public class ContatoController {

    @Autowired
    private IContatoService contatoService;

    @PostMapping
    public ResponseEntity<?> SalvarContato(@RequestBody Contato contato) {
        return new ResponseEntity<>(contatoService.SalvarContato(contato), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> ExcluirContato(@PathVariable Long id) {
        contatoService.ExcluirContato(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> BuscarContatos() {
        return new ResponseEntity<>(contatoService.BuscarContatos(), HttpStatus.OK);
    }

    @GetMapping("/pesquisa")
    public Page<Contato> BuscarContatosPorFiltro(
            @RequestParam("pesquisa") String pesquisa,
            @RequestParam(value = "pagina", required = false, defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", required = false, defaultValue = "50") int tamanho)
    {
        return contatoService.BuscarContatosPorFiltro(pesquisa, pagina, tamanho);
    }
}
