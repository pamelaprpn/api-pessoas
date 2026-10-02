package com.example.api_pessoas.controller;

import com.example.api_pessoas.dto.PessoaRequestDTO;
import com.example.api_pessoas.model.Pessoa;
import com.example.api_pessoas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/registrarName")
    public Pessoa registrarPessoa(@Valid @RequestBody PessoaRequestDTO dto) {
        return pessoaService.registrarPessoa(dto);
    }
}
