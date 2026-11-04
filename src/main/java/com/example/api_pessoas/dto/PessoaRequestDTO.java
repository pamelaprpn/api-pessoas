package com.example.api_pessoas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PessoaRequestDTO {

    @NotBlank(message = "Documento é obrigatório")
    @Pattern(
            regexp = "\\d{11}",
            message = "Documento deve conter exatamente 11 números"
    )
    private String documento;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
