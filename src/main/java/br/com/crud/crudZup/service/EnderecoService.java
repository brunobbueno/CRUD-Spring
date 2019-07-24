package br.com.crud.crudZup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.crudZup.entities.Endereco;
import br.com.crud.crudZup.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}
	
	public Optional <Endereco> findById(Long id){
		return enderecoRepository.findById(id);
	}
	
	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public void deleteById(Long id) {
		enderecoRepository.deleteById(id);
	}

}
