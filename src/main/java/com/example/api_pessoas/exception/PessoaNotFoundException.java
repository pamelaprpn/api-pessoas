package com.example.api_pessoas.exception;

public class PessoaNotFoundException  extends RuntimeException{

    public PessoaNotFoundException(String mensagem){
        super(mensagem);
    }
}
