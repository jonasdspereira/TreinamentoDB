package com.db.biblioteca.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.db.biblioteca.model.Biblioteca;
import com.db.biblioteca.model.Livro;
import com.db.biblioteca.model.dto.BibliotecaRespostaDto;
import com.db.biblioteca.model.dto.CriarBibliotecaDto;
import com.db.biblioteca.model.dto.LivroRespostaDto;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BibliotecaMapper {

    // BibliotecaMapper INSTANCE = Mappers.getMapper(BibliotecaMapper.class);

    @Mapping(target = "livros", ignore = true)
    Biblioteca toBiblioteca(CriarBibliotecaDto criarBibliotecaDto);

    BibliotecaRespostaDto toBibliotecaRespostaDto(Biblioteca biblioteca);

    List<BibliotecaRespostaDto> toListToBibliotecaRespostaDto(List<Biblioteca> bibliotecas);

    LivroRespostaDto toLivroRespostaDto(Livro livro);

}
