package com.leilao.leilaoSite.presentation.user;

import java.time.LocalDate;
import java.util.Date;

import com.leilao.leilaoSite.domain.leilao.model.EnderecoModel;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private EnderecoModel endereco;
    private String cpf;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public EnderecoModel getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
