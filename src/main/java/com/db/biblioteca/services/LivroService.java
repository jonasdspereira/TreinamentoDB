package com.db.biblioteca.services;

import java.util.List;

import com.db.biblioteca.model.Livro;

public interface LivroService {
    Livro buscarLivroPorId(Long id);

    List<Livro> buscarLivrosPorTituloEBibliotecaId(String titulo, Long bibliotecaId);

    List<Livro> buscarLivrosPorAutorEBibliotecaId(String autor, Long bibliotecaId);

    List<Livro> buscarLivrosPorAnoPublicacaoEBibliotecaId(Integer anoPublicacao, Long bibliotecaId);

    List<Livro> buscarTodosLivrosPorBibliotecaId(Long bibliotecaId);

    List<Livro> buscarLivrosPorTitulo(String titulo);

    List<Livro> buscarLivrosPorAutor(String autor);

    List<Livro> buscarLivrosPorAnoDePublicacao(Integer anoPublicacao);
}
