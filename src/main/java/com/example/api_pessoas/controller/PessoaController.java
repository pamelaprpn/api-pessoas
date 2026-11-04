package com.example.api_pessoas.controller;

import com.example.api_pessoas.dto.PessoaRequestDTO;
import com.example.api_pessoas.model.Pessoa;
import com.example.api_pessoas.service.PessoaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/list")
    public List<Pessoa> listarPessoas(
            @RequestParam(defaultValue = "10")
            @Min(1)
            @Max(100)
            Integer limite) {

        return pessoaService.listarPessoas(limite);
    }

    @PostMapping("/registrarName")
    public Pessoa registrarPessoa(@Valid @RequestBody PessoaRequestDTO dto) {
        return pessoaService.registrarPessoa(dto);
    }

    @GetMapping("/list/{documento}")
    public Pessoa buscarporDocumento(
            @PathVariable
            @Pattern(regexp = "\\d{11}", message = "Documento deve conter exatamente 11 números")
            String documento){

        return pessoaService.buscarPorDocumento(documento);
    }

    @DeleteMapping("/list/{documento}")
    public void deletarPessoa(
            @PathVariable
            @Pattern(regexp = "\\d{11}", message = "Documento deve conter exatamente 11 números")
            String documento){
        pessoaService.excluirPessoa(documento);
    }
}
