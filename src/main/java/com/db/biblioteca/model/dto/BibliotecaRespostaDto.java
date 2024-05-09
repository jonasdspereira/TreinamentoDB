package com.db.biblioteca.model.dto;

import java.util.List;

public class BibliotecaRespostaDto {
    private Long id;
    private String nome;

    private List<LivroRespostaDto> livros;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<LivroRespostaDto> getLivros() {
        return livros;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivros(List<LivroRespostaDto> livros) {
        this.livros = livros;
    }

}
