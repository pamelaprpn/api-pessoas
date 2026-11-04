package com.example.api_pessoas.service;

import com.example.api_pessoas.dto.PessoaRequestDTO;
import com.example.api_pessoas.exception.PessoaNotFoundException;
import com.example.api_pessoas.model.Pessoa;
import com.example.api_pessoas.repository.PessoaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
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

    public List<Pessoa> listarPessoas(Integer limite) {
        if (limite == null) {
            return pessoaRepository.findAll();
        }

        Pageable pageable = PageRequest.of(
                0,
                limite,
                Sort.by("id").ascending()
        );

        return pessoaRepository.findAll(pageable).getContent();

    }

    public Pessoa registrarPessoa(PessoaRequestDTO dto){
        Pessoa pessoa = new Pessoa();

        pessoa.setDocumento(dto.getDocumento());
        pessoa.setNome(dto.getNome());
        pessoa.setSobrenome(dto.getSobrenome());
        pessoa.setEmail(dto.getEmail());

        return pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(String documento){
        Pessoa pessoa = buscarPorDocumento(documento);
        pessoaRepository.delete(pessoa);
    }
}
