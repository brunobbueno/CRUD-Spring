package br.com.crud.crudZup.API;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.crudZup.entities.Endereco;
import br.com.crud.crudZup.entities.Pessoa;
import br.com.crud.crudZup.exception.ForbiddenException;
import br.com.crud.crudZup.service.EnderecoService;
import br.com.crud.crudZup.service.PessoaService;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoAPI {
	
	@Autowired
	private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Optional<Endereco> stock = enderecoService.findById(id);
        if (!stock.isPresent()) {
            throw new ForbiddenException("Id " + id + " is not existed");
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
        if (!enderecoService.findById(id).isPresent()) {
        	throw new ForbiddenException("Id " + id + " is not existed");
        }

        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!enderecoService.findById(id).isPresent()) {
        	throw new ForbiddenException("Id " + id + " is not existed");
        }

        enderecoService.deleteById(id);

        return ResponseEntity.ok().build();
    }


}
