package com.example.api_pessoas.controller;

import com.example.api_pessoas.dto.PessoaRequestDTO;
import com.example.api_pessoas.model.Pessoa;
import com.example.api_pessoas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/list")
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @PostMapping("/registrarName")
    public Pessoa registrarPessoa(@Valid @RequestBody PessoaRequestDTO dto) {
        return pessoaService.registrarPessoa(dto);
    }

    @GetMapping("/list/{documento}")
    public Pessoa buscarporDocumento(@PathVariable String documento){
        return pessoaService.buscarPorDocumento(documento);
    }

    @DeleteMapping("/list/{documento}")
    public void deletarPessoa(@PathVariable String documento){
        pessoaService.excluirPessoa(documento);
    }
}
