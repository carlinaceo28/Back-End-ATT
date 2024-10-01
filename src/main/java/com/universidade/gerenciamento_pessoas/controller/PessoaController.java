package com.universidade.gerenciamento_pessoas.controller;

import com.universidade.gerenciamento_pessoas.dto.PessoaDTO;
import com.universidade.gerenciamento_pessoas.model.Pessoa;
import com.universidade.gerenciamento_pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;   
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Método POST para criar uma Pessoa
    @PostMapping
    public Pessoa criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(null, pessoaDTO.getNome(), pessoaDTO.getCpf(), pessoaDTO.getIdade());
        return pessoaRepository.save(pessoa);
    }

    // Método GET para retornar uma Pessoa por Id
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
