package com.azulay.OdontoSimple.exception;

public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException(String login){
        super("Usuario já cadastrado para o login" + login);
    }
}
