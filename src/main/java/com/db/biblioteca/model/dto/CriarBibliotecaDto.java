package com.db.biblioteca.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CriarBibliotecaDto {
    @NotEmpty(message = "Nome da biblioteca deve ser informado")
    private String nome;

    public String getNome() {
        return nome;
    }

}
