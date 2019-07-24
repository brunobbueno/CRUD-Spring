package br.com.crud.crudZup.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.crud.crudZup.entities.Pessoa;
import br.com.crud.crudZup.exception.ForbiddenException;
import br.com.crud.crudZup.service.PessoaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaAPI {
	
	@Autowired
	private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Optional<Pessoa> stock = pessoaService.findById(id);
        if (!stock.isPresent()) {
        	throw new ForbiddenException("Id " + id + " is not existed");
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        if (!pessoaService.findById(id).isPresent()) {
        	throw new ForbiddenException("Id " + id + " is not existed");
        }

        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!pessoaService.findById(id).isPresent()) {
        	throw new ForbiddenException("Id " + id + " is not existed");
        }

        pessoaService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
