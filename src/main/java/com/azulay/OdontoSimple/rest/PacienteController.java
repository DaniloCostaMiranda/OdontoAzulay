package com.azulay.OdontoSimple.rest;

import com.azulay.OdontoSimple.model.entity.Paciente;
import com.azulay.OdontoSimple.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    @Autowired
    public PacienteController(PacienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar (@RequestBody @Valid Paciente paciente){
        return repository.save(paciente);
    }

    @GetMapping("{id}")
    public Paciente acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id) {
        repository.findById(id).map( paciente -> {
                    repository.delete(paciente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Paciente pacienteAtualizado){
        repository
                .findById(id)
                .map( paciente -> {
                    paciente.setCpf(pacienteAtualizado.getCpf());
                    paciente.setEmail(pacienteAtualizado.getEmail());
                    paciente.setEndereco(pacienteAtualizado.getEndereco());
                    paciente.setNome(pacienteAtualizado.getNome());
                    paciente.setTelefone(pacienteAtualizado.getTelefone());
                    return repository.save(paciente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Paciente> obterTodos(){
        return repository.findAll();
    }

}
