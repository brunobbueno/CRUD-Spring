package br.com.crud.crudZup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.crudZup.entities.Pessoa;
import br.com.crud.crudZup.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> findById(Long id){
		return pessoaRepository.findById(id);
	}
	
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void deleteById(Long id) {
		pessoaRepository.deleteById(id);
	}

}
