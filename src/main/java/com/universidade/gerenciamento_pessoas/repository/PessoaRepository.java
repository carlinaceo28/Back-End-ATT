package com.universidade.gerenciamento_pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.universidade.gerenciamento_pessoas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
