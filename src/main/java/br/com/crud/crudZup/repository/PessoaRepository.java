package br.com.crud.crudZup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crud.crudZup.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
