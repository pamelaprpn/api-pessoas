package com.example.api_pessoas.service;

import com.example.api_pessoas.exception.PessoaNotFoundException;
import com.example.api_pessoas.model.Pessoa;
import com.example.api_pessoas.repository.PessoaRepository;

public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa buscarPorDocumento(String documento){
        return pessoaRepository
                .findByDocumento(documento)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada"));
    }
}
