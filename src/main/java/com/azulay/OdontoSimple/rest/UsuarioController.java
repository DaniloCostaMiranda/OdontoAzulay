package com.azulay.OdontoSimple.rest;


import com.azulay.OdontoSimple.exception.UsuarioCadastradoException;
import com.azulay.OdontoSimple.model.entity.Usuario;
import com.azulay.OdontoSimple.model.repository.UsuarioRepository;
import com.azulay.OdontoSimple.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){

       try {
           service.salvar(usuario);
       }catch (UsuarioCadastradoException e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
       }
    }

}
