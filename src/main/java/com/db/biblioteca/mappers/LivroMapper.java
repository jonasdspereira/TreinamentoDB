package com.db.biblioteca.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.db.biblioteca.model.Livro;
import com.db.biblioteca.model.dto.CriarLivroDto;
import com.db.biblioteca.model.dto.LivroRespostaDto;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    @Mapping(target = "biblioteca", ignore = true)
    Livro toLivro(CriarLivroDto criarLivroDto);

    LivroRespostaDto toLivroRespostaDto(Livro livro);

    List<LivroRespostaDto> toListaDeLivroToRespostaDto(List<Livro> livros);
}
